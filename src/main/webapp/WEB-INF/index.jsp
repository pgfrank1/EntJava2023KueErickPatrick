<%--
  Created by IntelliJ IDEA.
  User: student
  Date: 4/3/23
  Time: 12:00 PM
  Homepage for our project. Contains quick search bar, nav, and a random plant generator.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<%-- head.jsp inclusion --%>
<%@include file="head.jsp"%>
<%-- set random plant --%>
<c:set var="randomPlant" value='${requestScope["randomPlant"]}' />
<body class="bg-custom-mint-green">

<%-- main container --%>
<div class="container mt-4">
    <%-- nav will go here --%>
    <%@include file="nav.jsp"%>
    <%-- content --%>
    <div class="container d-flex justify-content-center p-0">
        <div class="text-dark">
            <%-- search inclusion --%>
            <%@include file="search-component.jsp"%>
            <%-- plant of the day card --%>
            <div class="rounded bg-white mt-5">
                <%-- potd header --%>
                <h1 class="text-center pt-4">Random Plant</h1>
                <%-- image container--%>
                 <div class="container">
                     <%-- row to create seperate sections --%>
                     <div class="row">
                         <%-- first column of row (image) --%>
                         <div class="col-md-4 ">
                             <img class="img-fluid" src="${randomPlant.getDefaultImage().getSmallUrl()}">
                         </div>
                         <%-- second column of row (description) --%>
                         <div class="col-md-8 p-4">
                             <%-- potd name --%>
                             <h1 class="m-0">${randomPlant.getCommonName()}</h1>
                             <%-- scientific name --%>
                             <h2 class="text-body-tertiary">${randomPlant.getScientificName()}</h2>
                             <%-- progress bars containers --%>
                             <div class="container p-0">
                                 <%-- water --%>
                                 <div class="row">
                                     <%-- water text --%>
                                     <div class="col">
                                         <p>water level</p>
                                     </div>
                                     <%-- progress bar --%>
                                     <%-- conditionals for watering possibilities --%>
                                     <c:choose>
                                         <c:when test="${randomPlant.getWatering() == 'None'}">
                                             <div class="col">
                                                 <div class="progress" role="progressbar" aria-label="water-level">
                                                     <div class="progress-bar bg-custom-sky-blue" style="width: 0%"></div>
                                                 </div>
                                             </div>
                                         </c:when>
                                         <c:when test="${randomPlant.getWatering() == 'Minimum'}">
                                             <div class="col">
                                                 <div class="progress" role="progressbar" aria-label="water-level">
                                                     <div class="progress-bar bg-custom-sky-blue" style="width: 33%"></div>
                                                 </div>
                                             </div>
                                         </c:when>
                                         <c:when test="${randomPlant.getWatering() == 'Average'}">
                                             <div class="col">
                                                 <div class="progress" role="progressbar" aria-label="water-level">
                                                     <div class="progress-bar bg-custom-sky-blue" style="width: 66%"></div>
                                                 </div>
                                             </div>
                                         </c:when>
                                         <c:when test="${randomPlant.getWatering() == 'Frequent'}">
                                             <div class="col">
                                                 <div class="progress" role="progressbar" aria-label="water-level">
                                                     <div class="progress-bar bg-custom-sky-blue" style="width: 100%"></div>
                                                 </div>
                                             </div>
                                         </c:when>
                                     </c:choose>
                                 </div>
                                 <%-- sun --%>
                                 <div class="row">
                                     <%-- sun text --%>
                                     <div class="col">
                                         <p>sun level</p>
                                     </div>
                                     <%-- progress bar --%>
                                     <%-- conditionals for most sun possibilities --%>
                                     <c:choose>
                                         <c:when test="${randomPlant.getSunlight() == '[Full shade]'}">
                                             <div class="col">
                                                 <div class="progress" role="progressbar" aria-label="sun-level">
                                                     <div class="progress-bar bg-custom-light-gold" style="width: 0%"></div>
                                                 </div>
                                             </div>
                                         </c:when>
                                         <c:when test="${randomPlant.getSunlight() == '[Part shade]'}">
                                             <div class="col">
                                                 <div class="progress" role="progressbar" aria-label="sun-level">
                                                     <div class="progress-bar bg-custom-light-gold" style="width: 33%"></div>
                                                 </div>
                                             </div>
                                         </c:when>
                                         <c:when test="${randomPlant.getSunlight() == '[Sun part shade]'}">
                                             <div class="col">
                                                 <div class="progress" role="progressbar" aria-label="sun-level">
                                                     <div class="progress-bar bg-custom-light-gold" style="width: 66%"></div>
                                                 </div>
                                             </div>
                                         </c:when>
                                         <c:when test="${randomPlant.getSunlight() == '[Full sun]'}">
                                             <div class="col">
                                                 <div class="progress" role="progressbar" aria-label="sun-level">
                                                     <div class="progress-bar bg-custom-light-gold" style="width: 100%"></div>
                                                 </div>
                                             </div>
                                         </c:when>
                                         <c:when test="${randomPlant.getSunlight() == '[full sun]'}">
                                             <div class="col">
                                                 <div class="progress" role="progressbar" aria-label="sun-level">
                                                     <div class="progress-bar bg-custom-light-gold" style="width: 100%"></div>
                                                 </div>
                                             </div>
                                         </c:when>
                                         <c:when test="${randomPlant.getSunlight() == '[Full sun, part shade]'}">
                                             <div class="col">
                                                 <div class="progress" role="progressbar" aria-label="sun-level">
                                                     <div class="progress-bar bg-custom-light-gold" style="width: 50%"></div>
                                                 </div>
                                             </div>
                                         </c:when>
                                         <c:when test="${randomPlant.getSunlight() == '[full sun, part shade]'}">
                                             <div class="col">
                                                 <div class="progress" role="progressbar" aria-label="sun-level">
                                                     <div class="progress-bar bg-custom-light-gold" style="width: 50%"></div>
                                                 </div>
                                             </div>
                                         </c:when>
                                         <c:when test="${randomPlant.getSunlight() == '[Part shade, full shade]'}">
                                             <div class="col">
                                                 <div class="progress" role="progressbar" aria-label="sun-level">
                                                     <div class="progress-bar bg-custom-light-gold" style="width: 25%"></div>
                                                 </div>
                                             </div>
                                         </c:when>
                                     </c:choose>

                                 </div>
                             </div>
                             <%-- horizontal break --%>
                             <hr class="text-body-tertiary">
                             <%-- description --%>
                             <c:choose>
                                 <c:when test="${empty randomPlant.getDescription()}">
                                     <p>Description not available :(</p>
                                 </c:when>
                                 <c:otherwise>
                                     <p>${randomPlant.getDescription()}</p>
                                 </c:otherwise>
                             </c:choose>
                         </div>
                     </div>
                 </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>
