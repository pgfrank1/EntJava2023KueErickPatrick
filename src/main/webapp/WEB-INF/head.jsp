<%--
  Created with IntelliJ IDEA.
  User: ereyes3
  Date: 4/3/23
  Time: 6:32 PM
  head.jsp will be included in every JSP page.
  Contains links to Bootstrap CSS, custom CSS, and etc resources.
  Creates JSTL.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%-- creates dynamic page title from a pageTitle variable in request scope --%>
<c:set var="title" value='${requestScope["pageTitle"]}' />
<html>
<head>
    <%-- meta --%>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <%-- title --%>
    <title><c:out value="${title}" /></title>
    <%-- bootstrap css --%>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD" crossorigin="anonymous">
    <%-- bootstrap js --%>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js" integrity="sha384-w76AqPfDkMBDXo30jS1Sgez6pr3x5MlQ1ZAGC+nuZB+EYdgRZgiwxhTBTkF7CXvN" crossorigin="anonymous"></script>
    <%-- css file --%>
    <link href="css/main.css" rel="stylesheet" type="text/css">
</head>
<body>

</body>
</html>
