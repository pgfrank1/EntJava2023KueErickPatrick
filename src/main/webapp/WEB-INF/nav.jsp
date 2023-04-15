<%--
  Created by IntelliJ IDEA.
  User: reyesmac
  Date: 4/4/23
  Time: 8:17 PM
  Modularized navigation.
  author: ereyes3
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<nav class="navbar navbar-expand-lg mt-2 mb-5 bg-white rounded shadow sticky-top">
  <div class="container-fluid">
    <%-- logo --%>
    <img src="${pageContext.request.contextPath}/images/pixel-plant.png" class="plant-logo-sizing">
    <%-- project name --%>
    <a class="navbar-brand fw-bold" href="${pageContext.request.contextPath}/">plantlookerupper</a>
    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarToggler" aria-controls="navbarToggler" aria-expanded="false" aria-label="Toggle navigation">
      <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarToggler">
      <ul class="navbar-nav me-auto mb-2 mb-lg-0">
        <li class="nav-item">
          <a class="nav-link" href="${pageContext.request.contextPath}/">Home</a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="${pageContext.request.contextPath}/search">Search</a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="${pageContext.request.contextPath}/restfulDocs">API Documentation</a>
        </li>
        <c:choose>
          <c:when test="${sessionScope.username != null}" >
            <li class="nav-item">
              <a class="nav-link" href="./user"><c:out value="${sessionScope.username}"/></a>
            </li>
          </c:when>
          <c:otherwise>
          <li class="nav-item">
            <a class="nav-link" href="./logIn">Login</a>
          </li>
          </c:otherwise>
        </c:choose>
      </ul>
    </div>
  </div>
</nav>