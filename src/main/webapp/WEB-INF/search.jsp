<%--
  Created by IntelliJ IDEA.
  User: reyesmac
  Date: 4/6/23
  Time: 8:24 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<%-- head.jsp inclusion --%>
<%@include file="head.jsp"%>
<%-- gets results (if any) from request scope --%>
<c:set var="results" value='${requestScope["results"]}' />
<body class="bg-custom-mint-green">

<%-- main container --%>
<div class="container mt-4">
  <%-- nav will go here --%>
  <%@include file="nav.jsp"%>
  <%-- content --%>
  <div class="container">
    <%-- search container --%>
    <div class="text-dark w-100">
      <%-- search bar title --%>
      <h3>Detailed search</h3>
      <%-- search bar --%>
      <form id="apiSearch" method="POST" action="search">
          <%-- text input --%>
          <input type="text" class="form-control" name="query" placeholder="look up a plant">
          <%-- enter and clear button container --%>
          <div class="container mt-3 justify-content-end d-flex p-0">
              <button class="btn btn-light border-black me-3" type="reset">clear</button>
              <button class="btn btn-primary border-black" type="submit" value="beginSearch">search</button>
          </div>
      </form>
    </div>
    <c:if test="${not empty results}">
        <%-- results container --%>
        <div>
            <h1>Results:</h1>
            <c:forEach items="${results}" var="plant">
                <p>${plant.getCommonName()}</p>
                <img class="img-fluid" src="${plant.getDefaultImage().getThumbnail()}">
            </c:forEach>
        </div>
    </c:if>
  </div>
</div>
</body>
</html>

