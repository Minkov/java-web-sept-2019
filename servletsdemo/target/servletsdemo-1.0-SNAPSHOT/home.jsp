<%@ page import="java.util.List" %>
<%@ page import="models.view.HomeViewModel" %>
<%@ page import="models.entities.Course" %>
<%@ page import="models.service.CourseServiceModel" %>
<%--
  Created by IntelliJ IDEA.
  User: Doncho Minkov
  Date: 10/11/2019
  Time: 18:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" />
</head>
<body>
    <h1 class="text-center text-danger">It works</h1>
    <strong>
        <%= ((HomeViewModel)request.getAttribute("viewModel")).getName() %>
    </strong>

    <% for(CourseServiceModel course : ((HomeViewModel)request.getAttribute("viewModel")).getCourses()) { %>
        <li>
            <%= course.getName() %>
        </li>
    <% } %>
</body>
</html>
