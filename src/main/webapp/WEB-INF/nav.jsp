<%--
  Created by IntelliJ IDEA.
  User: reyesmac
  Date: 4/4/23
  Time: 8:17 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%-- navbar --%>
<nav class="navbar navbar-expand-lg mb-5 bg-white rounded">
  <%-- container --%>
  <div class="container-fluid">
    <%-- logo --%>
    <img src="${pageContext.request.contextPath}/images/pixel-plant.png" class="plant-logo-sizing">
    <%-- app name --%>
    <a class="navbar-brand fw-bold" href="#">plantlookerupper &#8226</a>
    <%-- toggler (smaller displays) --%>
    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarTogglerDemo02" aria-controls="navbarTogglerDemo02" aria-expanded="false" aria-label="Toggle navigation">
      <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse">
      <%-- navbar list --%>
      <ul class="navbar-nav me-auto mb-2 mb-lg-0">
        <li class="nav-item">
          <a class="nav-link active" aria-current="page" href="#">Home &#8226</a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="#">Search &#8226</a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="#">Login</a>
        </li>
      </ul>
    </div>
  </div>
</nav>
