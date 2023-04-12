<%--
  Created by IntelliJ IDEA.
  User: student
  Date: 4/3/23
  Time: 12:00 PM
  User page for our project.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<%-- head.jsp inclusion --%>
<%@include file="head.jsp"%>
<%-- get username from request scope --%>
<c:set var="user" value='${requestScope["user"]}' />
<%-- get user's plant list from request scope --%>
<c:set var="plantList" value='${requestScope["plantList"]}' />
<%-- body --%>
<body class="bg-custom-mint-green">
<%-- main container --%>
<div class="container mt-4">
    <%-- nav will go here --%>
    <%@include file="nav.jsp"%>
    <%-- content --%>
    <div class="container d-flex p-3">
        <div class="text-dark">
            <%-- user grid --%>
            <div class="container p-0">
                <%-- row --%>
                <div class="row">
                    <%-- user message col --%>
                    <div class="col p-0 mb-2">
                        <h3>There's never a wrong time to stop and smell the flowers, ${user.getFirstname()}</h3>
                    </div>
                    <h3 class="p-0">Your plants:</h3>
                    <%-- user's plants table --%>
                    <table class="table table-striped table-bordered">
                        <thead>
                            <tr>
                                <th scope="col">#</th>
                                <th scope="col">plant</th>
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach items="${plantList}" var="plant">
                            <tr>
                                <td>${plant.getKey()}</td>
                                <td>${plant.getValue().getCommonName()}</td>
                            </tr>
                            </c:forEach>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>
