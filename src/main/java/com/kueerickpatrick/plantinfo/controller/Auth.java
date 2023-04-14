package com.kueerickpatrick.plantinfo.controller;


import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.kueerickpatrick.plantinfo.auth.*;
import com.kueerickpatrick.plantinfo.entity.*;
import com.kueerickpatrick.plantinfo.persistence.*;
import com.kueerickpatrick.plantinfo.util.*;
import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.math.BigInteger;
import java.net.URI;
import java.net.URL;
import java.net.URLEncoder;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.RSAPublicKeySpec;
import java.util.*;
import java.util.stream.Collectors;


@WebServlet(
        urlPatterns = {"/auth"}
)
/**
 * Inspired by: https://stackoverflow.com/questions/52144721/how-to-get-access-token-using-client-credentials-using-java-code
 */

public class Auth extends HttpServlet implements PropertiesLoader {
    Properties properties;
    String CLIENT_ID;
    String CLIENT_SECRET;
    String OAUTH_URL;
    String LOGIN_URL;
    String REDIRECT_URL;
    String REGION;
    String POOL_ID;
    Keys jwks;

    private final Logger logger = LogManager.getLogger(this.getClass());

    @Override
    public void init() throws ServletException {
        super.init();
        loadProperties();
        loadKey();
    }

    /**
     * Gets the auth code from the request and exchanges it for a token containing user info.
     * @param req servlet request
     * @param resp servlet response
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String authCode = req.getParameter("code");
        List<String> userLoginInfo;
        logger.info("This is the start of the doGet method.");
        String firstName = null;
        String lastName = null;
        String username = null;
        int userID = 0;

        if (authCode == null) {

        } else {
            HttpRequest authRequest = buildAuthRequest(authCode);
            try {
                TokenResponse tokenResponse = getToken(authRequest);
                userLoginInfo = validate(tokenResponse);
                firstName = userLoginInfo.get(0);
                logger.info("First Name from token is: " + firstName);
                lastName = userLoginInfo.get(1);
                username = userLoginInfo.get(2);
            } catch (IOException e) {
                logger.error("Error getting or validating the token: " + e.getMessage(), e);
                e.printStackTrace();
            } catch (InterruptedException e) {
                logger.error("Error getting token from Cognito oauth url " + e.getMessage(), e);
                e.printStackTrace();
            }
        }

        // Check if user exist in User table. Add user if not found.
        userID = checkDatabaseForUser(firstName, lastName, username);

        // Put user information in session
        HttpSession session = req.getSession();

        session.setAttribute("firstName", firstName);
        session.setAttribute("lastName", lastName);
        session.setAttribute("username", username);
        session.setAttribute("id", userID);
        logger.info("User information has been added to session");

        // Upon successfully signing in, user is taken to Patient List
        RequestDispatcher dispatcher = req.getRequestDispatcher("/user");
        dispatcher.forward(req, resp);
    }

    // Check if user exist in User table
    public int checkDatabaseForUser(String firstName, String lastName, String username) {

        int id;

        GenericDao userDao = new GenericDao(User.class);
        List<User> usersDatabase = (List<User>) userDao.getByPropertyLike("username", username);
        logger.info("The username to check is: " + username);
        logger.info("The list of database users are: " + usersDatabase);
//        logger.info(usersDatabase.stream().anyMatch(user -> username.equals(user.getUsername())));
//        logger.info((usersDatabase.stream().filter(user -> user.getUsername().equals(username)).findFirst().isPresent()));

        String retrievedUsername = usersDatabase.get(0).getUsername();
        logger.info("The username issss: " + retrievedUsername);
        // Add user to table if doesn't already exist

//        if (usersDatabase.contains(username)) {
//        if ((usersDatabase.stream().filter(user -> user.getUsername().equals(username)).findFirst().isPresent())) {
        if (retrievedUsername.equals(username)) {
            id = usersDatabase.get(0).getId();
            logger.info("Retrieved user ID is: " + id);
        } else {
            logger.info("Got into the if-statement");
            User user = new User(firstName, lastName, username);
            id = userDao.insert(user);
            logger.info("User has been added to USER table");
        }

        return id;
    }

    /**
     * Sends the request for a token to Cognito and maps the response
     * @param authRequest the request to the oauth2/token url in cognito
     * @return response from the oauth2/token endpoint which should include id token, access token and refresh token
     * @throws IOException
     * @throws InterruptedException
     */
    private TokenResponse getToken(HttpRequest authRequest) throws IOException, InterruptedException {
        HttpClient client = HttpClient.newHttpClient();
        HttpResponse<?> response = null;

        response = client.send(authRequest, HttpResponse.BodyHandlers.ofString());


        logger.debug("Response headers: " + response.headers().toString());
        logger.debug("Response body: " + response.body().toString());

        ObjectMapper mapper = new ObjectMapper();
        TokenResponse tokenResponse = mapper.readValue(response.body().toString(), TokenResponse.class);
        logger.debug("Id token: " + tokenResponse.getIdToken());

        return tokenResponse;

    }

    /**
     * Get values out of the header to verify the token is legit. If it is legit, get the claims from it, such
     * as username.
     *
     * @param tokenResponse
     * @return
     * @throws IOException
     */
    private List<String> validate(TokenResponse tokenResponse) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        CognitoTokenHeader tokenHeader = mapper.readValue(CognitoJWTParser.getHeader(tokenResponse.getIdToken()).toString(), CognitoTokenHeader.class);

        // Header should have kid and alg- https://docs.aws.amazon.com/cognito/latest/developerguide/amazon-cognito-user-pools-using-the-id-token.html
        String keyId = tokenHeader.getKid();
        String alg = tokenHeader.getAlg();

        // todo pick proper key from the two - it just so happens that the first one works for my case
        // Use Key's N and E
        BigInteger modulus = new BigInteger(1, org.apache.commons.codec.binary.Base64.decodeBase64(jwks.getKeys().get(0).getN()));
        BigInteger exponent = new BigInteger(1, org.apache.commons.codec.binary.Base64.decodeBase64(jwks.getKeys().get(0).getE()));

        // TODO the following is "happy path", what if the exceptions are caught?
        // Create a public key
        PublicKey publicKey = null;
        try {
            publicKey = KeyFactory.getInstance("RSA").generatePublic(new RSAPublicKeySpec(modulus, exponent));
        } catch (InvalidKeySpecException e) {
            logger.error("Invalid Key Error " + e.getMessage(), e);
        } catch (NoSuchAlgorithmException e) {
            logger.error("Algorithm Error " + e.getMessage(), e);
        }

        // get an algorithm instance
        Algorithm algorithm = Algorithm.RSA256((RSAPublicKey) publicKey, null);

        // Verify ISS field of the token to make sure it's from the Cognito source
        String iss = String.format("https://cognito-idp.%s.amazonaws.com/%s", REGION, POOL_ID);

        JWTVerifier verifier = JWT.require(algorithm)
                .withIssuer(iss)
                .withClaim("token_use", "id") // make sure you're verifying id token
                .build();

        // Verify the token
        DecodedJWT jwt = verifier.verify(tokenResponse.getIdToken());
        String userName = jwt.getClaim("cognito:username").asString();
        logger.debug("here's the username: " + userName);

        String firstName = jwt.getClaim("given_name").asString();
        logger.debug("here's the first name: " + firstName);

        String lastName = jwt.getClaim("family_name").asString();
        logger.debug("here's the last name: " + lastName);

        logger.debug("here are all the available claims: " + jwt.getClaims());

        List<String> userLoginInfo = new ArrayList<>();
        userLoginInfo.add(firstName);
        userLoginInfo.add(lastName);
        userLoginInfo.add(userName);

        return userLoginInfo;
    }

    /** Create the auth url and use it to build the request.
     *
     * @param authCode auth code received from Cognito as part of the login process
     * @return the constructed oauth request
     */
    private HttpRequest buildAuthRequest(String authCode) {
        String keys = CLIENT_ID + ":" + CLIENT_SECRET;

        HashMap<String, String> parameters = new HashMap<>();
        parameters.put("grant_type", "authorization_code");
        parameters.put("client-secret", CLIENT_SECRET);
        parameters.put("client_id", CLIENT_ID);
        parameters.put("code", authCode);
        parameters.put("redirect_uri", REDIRECT_URL);

        String form = parameters.keySet().stream()
                .map(key -> key + "=" + URLEncoder.encode(parameters.get(key), StandardCharsets.UTF_8))
                .collect(Collectors.joining("&"));

        String encoding = Base64.getEncoder().encodeToString(keys.getBytes());

        HttpRequest request = HttpRequest.newBuilder().uri(URI.create(OAUTH_URL))
                .headers("Content-Type", "application/x-www-form-urlencoded", "Authorization", "Basic " + encoding)
                .POST(HttpRequest.BodyPublishers.ofString(form)).build();
        return request;
    }

    /**
     * Gets the JSON Web Key Set (JWKS) for the user pool from cognito and loads it
     * into objects for easier use.
     *
     * JSON Web Key Set (JWKS) location: https://cognito-idp.{region}.amazonaws.com/{userPoolId}/.well-known/jwks.json
     * Demo url: https://cognito-idp.us-east-2.amazonaws.com/us-east-2_XaRYHsmKB/.well-known/jwks.json
     *
     * @see Keys
     * @see KeysItem
     */
    private void loadKey() {
        ObjectMapper mapper = new ObjectMapper();

        try {
            URL jwksURL = new URL(String.format("https://cognito-idp.%s.amazonaws.com/%s/.well-known/jwks.json", REGION, POOL_ID));
            File jwksFile = new File("jwks.json");
            FileUtils.copyURLToFile(jwksURL, jwksFile);
            jwks = mapper.readValue(jwksFile, Keys.class);
            logger.debug("Keys are loaded. Here's e: " + jwks.getKeys().get(0).getE());
        } catch (IOException ioException) {
            logger.error("Cannot load json..." + ioException.getMessage(), ioException);
        } catch (Exception e) {
            logger.error("Error loading json" + e.getMessage(), e);
        }
    }

    /**
     * Read in the cognito props file and get/set the client id, secret, and required urls
     * for authenticating a user.
     */
    // TODO This code appears in a couple classes, consider using a startup servlet similar to adv java project
    private void loadProperties() {
        try {
            properties = loadProperties("/cognito.properties");
            CLIENT_ID = properties.getProperty("client.id");
            CLIENT_SECRET = properties.getProperty("client.secret");
            OAUTH_URL = properties.getProperty("oauthURL");
            LOGIN_URL = properties.getProperty("loginURL");
            REDIRECT_URL = properties.getProperty("redirectURL");
            REGION = properties.getProperty("region");
            POOL_ID = properties.getProperty("poolId");
        } catch (IOException ioException) {
            logger.error("Cannot load properties..." + ioException.getMessage(), ioException);
        } catch (Exception e) {
            logger.error("Error loading properties" + e.getMessage(), e);
        }
    }
}

