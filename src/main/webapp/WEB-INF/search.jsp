<%--
  Created by IntelliJ IDEA.
  User: reyesmac
  Date: 4/6/23
  Time: 8:24 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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

<body class="bg-custom-mint-green">

<%-- main container --%>
<div class="container mt-4">
  <%-- nav will go here --%>
  <%@include file="nav.jsp"%>
  <%-- content --%>
  <div class="container d-flex justify-content-center">
    <%-- search container --%>
    <div class="text-dark w-100">
      <%-- search bar title --%>
      <h3>Detailed search</h3>
      <%-- search bar --%>
      <form>
          <input type="text" class="form-control" placeholder="look up a plant">
          <%-- select menus container --%>
          <div class="container d-md-flex justify-content-between p-0 mt-3">
              <%-- sunlight --%>
              <select class="form-select form-select-sm me-md-3 mb-md-0 mb-3" aria-label="sunlight">
                  <option selected>Sunlight</option>
                  <option value="full_shade">no sun</option>
                  <option value="part_shade">some shade</option>
                  <option value="sun-part_shade">some sun</option>
                  <option value="full_sun">full sun</option>
              </select>
              <%-- water --%>
              <select class="form-select form-select-sm mx-md-3 my-md-0 my-3" aria-label="water">
                  <option selected>Water</option>
                  <option value="frequent">frequent</option>
                  <option value="average">average</option>
                  <option value="minimum">some</option>
                  <option value="none">none</option>
              </select>
              <%-- habitat --%>
              <select class="form-select form-select-sm mx-md-3 my-md-0 my-3" aria-label="habitat">
                  <option selected>Habitat</option>
                  <option value="TRUE">indoors</option>
                  <option value="FALSE">outdoors</option>
              </select>
              <%-- poison --%>
              <select class="form-select form-select-sm ms-md-3 mt-md-0 mt-3" aria-label="poison">
                  <option selected>Poisonous</option>
                  <option value="TRUE">Yes</option>
                  <option value="FALSE">No</option>
              </select>
          </div>
          <%-- enter and clear button container --%>
          <div class="container mt-3 justify-content-end d-flex p-0">
              <button class="btn btn-light border-black me-3" type="reset">clear</button>
              <button class="btn btn-primary border-black" type="submit">search</button>
          </div>
      </form>
    </div>
  </div>
</div>
</body>
</html>

