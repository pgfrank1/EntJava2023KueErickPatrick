<%--
  Created by IntelliJ IDEA.
  User: student
  Date: 4/3/23
  Time: 12:00 PM
  Plant details page.
  author: ereyes3
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<%-- head.jsp inclusion --%>
<%@include file="head.jsp"%>
<%-- set random plant --%>
<c:set var="selectedPlant" value='${requestScope["selectedPlant"]}' />
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
                <h1 class="text-center pt-4">Plant details</h1>
                <%-- image container--%>
                 <div class="container">
                     <%-- row to create seperate sections --%>
                     <div class="row">
                         <%-- first column of row (image) --%>
                         <div class="col-md-4 ">
                             <img class="img-fluid" src="${selectedPlant.getDefaultImage().getSmallUrl()}">
                         </div>
                         <%-- second column of row (description) --%>
                         <div class="col-md-8 p-4">
                             <%-- potd name --%>
                             <h1 class="m-0">${selectedPlant.getCommonName()}</h1>
                             <%-- scientific name --%>
                             <h2 class="text-body-tertiary">${selectedPlant.getScientificName()}</h2>
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
                                         <c:when test="${selectedPlant.getWatering() == 'None'}">
                                             <div class="col">
                                                 <div class="progress" role="progressbar" aria-label="water-level">
                                                     <div class="progress-bar bg-custom-sky-blue" style="width: 0%"></div>
                                                 </div>
                                             </div>
                                         </c:when>
                                         <c:when test="${selectedPlant.getWatering() == 'Minimum'}">
                                             <div class="col">
                                                 <div class="progress" role="progressbar" aria-label="water-level">
                                                     <div class="progress-bar bg-custom-sky-blue" style="width: 33%"></div>
                                                 </div>
                                             </div>
                                         </c:when>
                                         <c:when test="${selectedPlant.getWatering() == 'Average'}">
                                             <div class="col">
                                                 <div class="progress" role="progressbar" aria-label="water-level">
                                                     <div class="progress-bar bg-custom-sky-blue" style="width: 66%"></div>
                                                 </div>
                                             </div>
                                         </c:when>
                                         <c:when test="${selectedPlant.getWatering() == 'Frequent'}">
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
                                         <c:when test="${selectedPlant.getSunlight() == '[Full shade]'}">
                                             <div class="col">
                                                 <div class="progress" role="progressbar" aria-label="sun-level">
                                                     <div class="progress-bar bg-custom-light-gold" style="width: 0%"></div>
                                                 </div>
                                             </div>
                                         </c:when>
                                         <c:when test="${selectedPlant.getSunlight() == '[Part shade]'}">
                                             <div class="col">
                                                 <div class="progress" role="progressbar" aria-label="sun-level">
                                                     <div class="progress-bar bg-custom-light-gold" style="width: 33%"></div>
                                                 </div>
                                             </div>
                                         </c:when>
                                         <c:when test="${selectedPlant.getSunlight() == '[Sun part shade]'}">
                                             <div class="col">
                                                 <div class="progress" role="progressbar" aria-label="sun-level">
                                                     <div class="progress-bar bg-custom-light-gold" style="width: 66%"></div>
                                                 </div>
                                             </div>
                                         </c:when>
                                         <c:when test="${selectedPlant.getSunlight() == '[Full sun]'}">
                                             <div class="col">
                                                 <div class="progress" role="progressbar" aria-label="sun-level">
                                                     <div class="progress-bar bg-custom-light-gold" style="width: 100%"></div>
                                                 </div>
                                             </div>
                                         </c:when>
                                         <c:when test="${selectedPlant.getSunlight() == '[full sun]'}">
                                             <div class="col">
                                                 <div class="progress" role="progressbar" aria-label="sun-level">
                                                     <div class="progress-bar bg-custom-light-gold" style="width: 100%"></div>
                                                 </div>
                                             </div>
                                         </c:when>
                                         <c:when test="${selectedPlant.getSunlight() == '[Full sun, part shade]'}">
                                             <div class="col">
                                                 <div class="progress" role="progressbar" aria-label="sun-level">
                                                     <div class="progress-bar bg-custom-light-gold" style="width: 50%"></div>
                                                 </div>
                                             </div>
                                         </c:when>
                                         <c:when test="${selectedPlant.getSunlight() == '[full sun, part shade]'}">
                                             <div class="col">
                                                 <div class="progress" role="progressbar" aria-label="sun-level">
                                                     <div class="progress-bar bg-custom-light-gold" style="width: 50%"></div>
                                                 </div>
                                             </div>
                                         </c:when>
                                         <c:when test="${selectedPlant.getSunlight() == '[Part shade, full shade]'}">
                                             <div class="col">
                                                 <div class="progress" role="progressbar" aria-label="sun-level">
                                                     <div class="progress-bar bg-custom-light-gold" style="width: 25%"></div>
                                                 </div>
                                             </div>
                                         </c:when>
                                         <c:otherwise>
                                             <div class="col">
                                                 <p>Special care needed: ${selectedPlant.getSunlight()}</p>
                                             </div>
                                         </c:otherwise>
                                     </c:choose>

                                 </div>
                             </div>
                             <%-- horizontal break --%>
                             <hr class="text-body-tertiary">
                             <%-- description --%>
                             <c:choose>
                                 <c:when test="${empty selectedPlant.getDescription()}">
                                     <p>Description not available :(</p>
                                 </c:when>
                                 <c:otherwise>
                                     <p>${selectedPlant.getDescription()}</p>
                                 </c:otherwise>
                             </c:choose>
                                 <form method="post" action="addPlant">
                                     <button type="submit" name="plantId" value="${selectedPlant.getId()}">Add</button>
                                 </form>
                         </div>
                     </div>
                 </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>
