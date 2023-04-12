<%--
  Created by IntelliJ IDEA.
  User: reyesmac
  Date: 4/6/23
  Time: 8:24 PM
  Seach page.
  author: ereyes.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<%-- head.jsp inclusion --%>
<%@include file="head.jsp"%>
<%-- gets results (if any) from request scope --%>
<c:set var="results" value='${requestScope["results"]}' />
<%-- get user query --%>
<c:set var="userQuery" value='${requestScope["userQuery"]}' />
<body class="bg-custom-mint-green">

<%-- main container --%>
<div class="container mt-4">
  <%-- nav inclusion --%>
  <%@include file="nav.jsp"%>
  <%-- content --%>
  <div class="container p-0">
    <%-- search bar inclusion --%>
    <%@include file="search-component.jsp"%>
    <%-- if search results is not empty --%>
    <c:if test="${not empty results}">
        <%-- results main container --%>
        <div>
            <%-- results header --%>
            <h1>Results:</h1>
            <%-- results grid--%>
            <div class="container p-0 text-center ">
                <%-- row --%>
                <div class="row justify-content-center justify-content-md-evenly row-cols-auto">
                    <%-- for each item in results, create column --%>
                    <c:forEach items="${results}" var="plant">
                        <%-- column --%>
                        <a href="http://localhost:8080/EntJava2023KueErickPatrick_war/plantPage?idToSearch=${plant.getId()}">
                            <div class="col p-0">
                                <%-- card container --%>
                                <div class="bg-white rounded text-dark m-1 overflow-auto">
                                    <%-- image --%>
                                    <img class="img-fluid rounded p-2" src="${plant.getDefaultImage().getThumbnail()}">
                                    <%-- name --%>
                                    <p class="p-0">${plant.getCommonName()}</p>
                                </div>
                            </div>
                        </a>
                    </c:forEach>
                </div>
            </div>
        </div>
    </c:if>
  </div>
</div>
</body>
</html>

