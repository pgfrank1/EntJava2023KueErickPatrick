<%--
  Created by IntelliJ IDEA.
  User: student
  Date: 4/3/23
  Time: 12:00 PM
  Homepage for our project. Contains quick search bar, nav, and a plant of the day.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<%-- head.jsp inclusion --%>
<%@include file="head.jsp"%>
<%-- custom css inclusion --%>

<body class="bg-custom-mint-green">

<%-- main container --%>
<div class="container mt-4">
    <%-- nav will go here --%>
    <%@include file="nav.jsp"%>
    <%-- content --%>
    <div class="container d-flex justify-content-center">
        <div class="text-dark">
            <h3>Quick search</h3>
            <%-- search bar --%>
            <input type="text" class="form-control" placeholder="look up a plant">
             <%-- search bar help text --%>
            <div class="form-text">You can try: common name or scientific name!</div>
            <%-- plant of the day card --%>
            <div class="rounded bg-white mt-5">
                <%-- potd header --%>
                <h1 class="text-center">potd</h1>
                 <%-- potd subheader --%>
                <h2 class="text-center text-body-tertiary">(plant of the day)</h2>
                <%-- image container--%>
                 <div class="container">
                     <%-- row to create seperate sections --%>
                     <div class="row">
                         <%-- first column of row (image) --%>
                         <div class="col">
                             <img class="img-fluid" src="${pageContext.request.contextPath}/images/mini-cactus-example.png" alt="a small cactus in a pot">
                         </div>
                         <%-- second column of row (description) --%>
                         <div class="col p-4">
                             <%-- potd name --%>
                             <h1 class="m-0">example</h1>
                             <%-- scientific name --%>
                             <h2 class="text-body-tertiary">examplus generalus</h2>
                             <%-- progress bars containers --%>
                             <div class="container p-0">
                                 <%-- water --%>
                                 <div class="row">
                                     <%-- water text --%>
                                     <div class="col">
                                         <p>water level</p>
                                     </div>
                                     <%-- progress bar --%>
                                     <div class="col">
                                         <div class="progress" role="progressbar" aria-label="water-level">
                                             <div class="progress-bar bg-custom-sky-blue" style="width: 33%"></div>
                                         </div>
                                     </div>
                                 </div>
                                 <%-- sun --%>
                                 <div class="row">
                                     <%-- sun text --%>
                                     <div class="col">
                                         <p>sun level</p>
                                     </div>
                                     <%-- progress bar --%>
                                     <div class="col">
                                         <div class="progress" role="progressbar" aria-label="sun-level">
                                             <div class="progress-bar bg-custom-light-gold" style="width: 100%"></div>
                                         </div>
                                     </div>
                                 </div>
                             </div>
                             <%-- horizontal break --%>
                             <hr class="text-body-tertiary">
                             <%-- description --%>
                             <p>
                                 Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Vehicula ipsum a arcu cursus. In dictum non consectetur a erat nam.
                                 Enim sed faucibus turpis in eu mi bibendum neque egestas. Diam donec adipiscing tristique risus nec feugiat. Egestas dui id ornare arcu odio ut sem nulla. Potenti nullam ac tortor vitae purus faucibus ornare suspendisse.
                                 Netus et malesuada fames ac turpis egestas maecenas pharetra convallis. Orci sagittis eu volutpat odio. Arcu odio ut sem nulla pharetra diam. Non arcu risus quis varius quam quisque id diam. Suspendisse sed nisi lacus sed.
                             </p>
                         </div>
                     </div>
                 </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>
