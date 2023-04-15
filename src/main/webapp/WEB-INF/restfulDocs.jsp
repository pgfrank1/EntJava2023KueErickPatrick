<%--
  Created by IntelliJ IDEA.
  User: student
  Date: 4/12/23
  Time: 4:35 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<%@include file="head.jsp" %>
<body>
<%-- main container --%>
<div class="container mt-4">
    <%-- nav will go here --%>
    <%@include file="nav.jsp" %>
    <div class="container d-flex justify-content-center p-0">
        <div class="text-dark">
            <h2>Plant API</h2>
            <div class="container">
                <p>
                    <button class="btn btn-primary" type="button" data-bs-toggle="collapse"
                            data-bs-target="#showSearchTermPath" aria-expanded="false"
                            aria-controls="showSearchTermPath">
                        EntJava2023KueErickPatrick_war/rest/search/{searchTerm}
                    </button>
                </p>
                <div class="collapse" id="showSearchTermPath">
                    <div class="card card-body">
                        This API path will allow you to search for the name of any plant that is in the Perenual
                        database
                        <p>
                            <button class="btn btn-primary" type="button" data-bs-toggle="collapse"
                                    data-bs-target="#showSearchTermResponse" aria-expanded="false"
                                    aria-controls="showSearchTermResponse">
                                JSON Response Example
                            </button>
                        </p>
                        <div class="collapse" id="showSearchTermResponse">
                            <div class="card card-body">
                                <pre>
                                    <code>
{
    "sunlight" : [ "Sun", " Partial Shade" ],
    "watering" : "Average",
    "scientific_name" : [ "Acer macrophyllum 'Mocha Rose'" ],
    "other_name" : [ "Oregon Maple" ],
    "default_image" : {
    "license" : 5,
    "regular_url" : "https://perenual.com/storage/species_image/24_acer_macrophyllum_mocha_rose/regular/4715169892_220a9d39f6_b.jpg",
    "license_name" : "Attribution-ShareAlike License",
    "thumbnail" : "https://perenual.com/storage/species_image/24_acer_macrophyllum_mocha_rose/thumbnail/4715169892_220a9d39f6_b.jpg",
    "small_url" : "https://perenual.com/storage/species_image/24_acer_macrophyllum_mocha_rose/small/4715169892_220a9d39f6_b.jpg",
    "original_url" : "https://perenual.com/storage/species_image/24_acer_macrophyllum_mocha_rose/og/4715169892_220a9d39f6_b.jpg",
    "medium_url" : "https://perenual.com/storage/species_image/24_acer_macrophyllum_mocha_rose/medium/4715169892_220a9d39f6_b.jpg",
    "license_url" : "https://creativecommons.org/licenses/by-sa/2.0/"
}
                                    </code>
                                </pre>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <div class="container">
                <p>
                    <button class="btn btn-primary" type="button" data-bs-toggle="collapse"
                            data-bs-target="#showPlantSearchIdPath" aria-expanded="false"
                            aria-controls="showPlantSearchIdPath">
                        EntJava2023KueErickPatrick_war/rest/search/id/
                    </button>
                </p>
                <div class="collapse" id="showPlantSearchIdPath">
                    <div class="card card-body">
                        This API path will allow you to search for the name of any plant that is in the Perenual
                        database
                        <p>
                            <button class="btn btn-primary" type="button" data-bs-toggle="collapse"
                                    data-bs-target="#showPlantSearchIdResponse" aria-expanded="false"
                                    aria-controls="showSearchIdResponse">
                                JSON Response Example
                            </button>
                        </p>
                        <div class="collapse" id="showPlantSearchIdResponse">
                            <div class="card card-body">
                                <pre>
                                    <code>
{
  "medicinal_use" : "Coming Soon",
  "endangered" : "Coming Soon",
  "type" : "tree",
  "salt_tolerant" : false,
  "leaf_color" : [ "red", "purple" ],
  "poison_effects_to_pets" : "Coming Soon",
  "growth_rate" : "Moderate",
  "problem" : "Coming Soon",
  "harvest_season" : "Coming Soon",
  "cones" : false,
  "rare" : "Coming Soon",
  "attracts" : [ "Squirrels", " Bees" ],
  "poison_effects_to_humans" : "Coming Soon",
  "id" : 24,
  "common_name" : "Mocha Rose Big Leaf Maple",
  "cuisine_list" : "Coming Soon",
  "endangered_level" : "Coming Soon",
  "pest_susceptibility" : [ "Fungal leaf spot", " Heart rot", " Mildew", "  Pest resistant", " Disease resistant " ],
  "edible_fruit_taste_profile" : "Coming Soon",
  "flowers" : true,
  "invasive" : false,
  "scientific_name" : [ "Acer macrophyllum 'Mocha Rose'" ],
  "poisonous_to_humans" : 0,
  "leaf_nutritional_value" : "Coming Soon",
  "poison_to_humans_cure" : "Coming Soon",
  "propagation" : [ "Seed Propagation" ],
  "indoor" : false,
  "default_image" : {
    "license" : 5,
    "regular_url" : "https://perenual.com/storage/species_image/24_acer_macrophyllum_mocha_rose/regular/4715169892_220a9d39f6_b.jpg",
    "license_name" : "Attribution-ShareAlike License",
    "thumbnail" : "https://perenual.com/storage/species_image/24_acer_macrophyllum_mocha_rose/thumbnail/4715169892_220a9d39f6_b.jpg",
    "small_url" : "https://perenual.com/storage/species_image/24_acer_macrophyllum_mocha_rose/small/4715169892_220a9d39f6_b.jpg",
    "original_url" : "https://perenual.com/storage/species_image/24_acer_macrophyllum_mocha_rose/og/4715169892_220a9d39f6_b.jpg",
    "medium_url" : "https://perenual.com/storage/species_image/24_acer_macrophyllum_mocha_rose/medium/4715169892_220a9d39f6_b.jpg",
    "license_url" : "https://creativecommons.org/licenses/by-sa/2.0/"
  },
  "thorny" : false,
  "edible_leaf_taste_profile" : "Coming Soon",
  "flowering_season" : "Spring",
  "origin" : [ "British Columbia", "California", "Oregon", "Washington" ],
  "hardiness_location_image" : "Coming Soon",
  "edible_fruit" : false,
  "fruit_nutritional_value" : "Coming Soon",
  "description" : null,
  "soil" : [ "Sandy Loamy" ],
  "harvest_method" : "Coming Soon",
  "medicinal" : false,
  "cycle" : "Perennial",
  "fruits" : true,
  "poison_to_pets_cure" : "Coming Soon",
  "rare_level" : "Coming Soon",
  "dimension" : "Height:  60 feet",
  "drought_tolerant" : true,
  "cuisine" : false,
  "leaf" : true,
  "fruiting_season" : "Autumn",
  "hardiness" : {
    "min" : "6",
    "max" : "6"
  },
  "tropical" : false,
  "sunlight" : [ "Sun", " Partial Shade" ],
  "watering" : "Average",
  "flower_color" : "Greenish-yellow",
  "fruit_color" : [ ],
  "medicinal_method" : "Coming",
  "pest_susceptibility_api" : "Coming Soon",
  "poisonous_to_pets" : 0,
  "care_level" : "Medium",
  "other_name" : [ "Oregon Maple" ],
  "edible_leaf" : false,
  "family" : "Sapindaceae",
  "maintenance" : "Low"
}
                                    </code>
                                </pre>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <h2>User API</h2>
            <div class="container">
                <p>
                    <button class="btn btn-primary" type="button" data-bs-toggle="collapse"
                            data-bs-target="#showSearchUserIdPath" aria-expanded="false"
                            aria-controls="showSearchUserIdPath">
                        EntJava2023KueErickPatrick_war/rest/plantinfo/user/{id}
                    </button>
                </p>
                <div class="collapse" id="showSearchUserIdPath">
                    <div class="card card-body">
                        This API path will allow you to search for the user of anyone within the database
                        <p>
                            <button class="btn btn-primary" type="button" data-bs-toggle="collapse"
                                    data-bs-target="#showSearchUserIdResponse" aria-expanded="false"
                                    aria-controls="showSearchUserIdResponse">
                                JSON Response Example
                            </button>
                        </p>
                        <div class="collapse" id="showSearchUserIdResponse">
                            <div class="card card-body">
                                <pre>
                                    <code>
{
  "id" : 1,
  "firstname" : "Kue",
  "lastname" : "Xiong",
  "username" : "kxiong",
  "userplants" : [ {
    "id" : 1
  }, {
    "id" : 2
  } ]
}
                                    </code>
                                </pre>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <div class="container">
                <p>
                    <button class="btn btn-primary" type="button" data-bs-toggle="collapse"
                            data-bs-target="#showUserPlantsPath" aria-expanded="false"
                            aria-controls="showUserPlantsPath">
                        EntJava2023KueErickPatrick_war/rest/plantinfo/user/{id}/plants
                    </button>
                </p>
                <div class="collapse" id="showUserPlantsPath">
                    <div class="card card-body">
                        This API path will allow you to search for the name of any plant that is in the Perenual
                        database
                        <p>
                            <button class="btn btn-primary" type="button" data-bs-toggle="collapse"
                                    data-bs-target="#showUserPlantsResponse" aria-expanded="false"
                                    aria-controls="showUserPlantsResponse">
                                JSON Response Example
                            </button>
                        </p>
                        <div class="collapse" id="showUserPlantsResponse">
                            <div class="card card-body">
                                <pre>
                                    <code>
[ {
  "id" : 1,
  "perenualid" : 1,
  "userplants" : [ {
    "id" : 3
  }, {
    "id" : 2
  } ]
}, {
  "id" : 2,
  "perenualid" : 3,
  "userplants" : [ {
    "id" : 1
  } ]
} ]

                                    </code>
                                </pre>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <div class="container">
                <p>
                    <button class="btn btn-primary" type="button" data-bs-toggle="collapse"
                            data-bs-target="#showPlantsUserIdPath" aria-expanded="false"
                            aria-controls="showPlantsUserIdPath">
                        EntJava2023KueErickPatrick_war/rest/plantinfo/plant/{id}
                    </button>
                </p>
                <div class="collapse" id="showPlantsUserIdPath">
                    <div class="card card-body">
                        This API path will allow you to search for the name of any plant that is in the Perenual
                        database
                        <p>
                            <button class="btn btn-primary" type="button" data-bs-toggle="collapse"
                                    data-bs-target="#showPlantsUserIdResponse" aria-expanded="false"
                                    aria-controls="showPlantsUserIdResponse">
                                JSON Response Example
                            </button>
                        </p>
                        <div class="collapse" id="showPlantsUserIdResponse">
                            <div class="card card-body">
                                <pre>
                                    <code>
{
  "id" : 1,
  "perenualid" : 1,
  "userplants" : [ {
    "id" : 3
  }, {
    "id" : 2
  } ]
}
                                    </code>
                                </pre>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <div class="container">
                <p>
                    <button class="btn btn-primary" type="button" data-bs-toggle="collapse"
                            data-bs-target="#showUserPlantAssociation" aria-expanded="false"
                            aria-controls="showUserPlantAssociation">
                        EntJava2023KueErickPatrick_war/rest/plantinfo/plant/{id}/users
                    </button>
                </p>
                <div class="collapse" id="showUserPlantAssociation">
                    <div class="card card-body">
                        This API path will allow you to search for the name of any plant that is in the Perenual
                        database
                        <p>
                            <button class="btn btn-primary" type="button" data-bs-toggle="collapse"
                                    data-bs-target="#showSearchIdResponse" aria-expanded="false"
                                    aria-controls="showSearchIdResponse">
                                JSON Response Example
                            </button>
                        </p>
                        <div class="collapse" id="showSearchIdResponse">
                            <div class="card card-body">
                                <pre>
                                    <code>
[ {
  "id" : 2,
  "firstname" : "Spongebob",
  "lastname" : "Square Pants",
  "username" : "ssquarepants",
  "userplants" : [ {
    "id" : 3
  } ]
}, {
  "id" : 1,
  "firstname" : "Kue",
  "lastname" : "Xiong",
  "username" : "kxiong",
  "userplants" : [ {
    "id" : 1
  }, {
    "id" : 2
  } ]
} ]
                                    </code>
                                </pre>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>
