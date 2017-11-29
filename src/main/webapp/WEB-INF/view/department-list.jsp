<%@ page language="java" contentType="text/html; charset=UTF-8"
         import="java.util.Calendar" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:include page="partials/header.jsp" />

<body>

<table class="table">
    <thead>
    <tr>
        <th>Name</th>
        <th>Description</th>
        <th>Action</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="department" items="${departments}" varStatus="loop">
        <tr>
            <td>${department.name}</td>
            <td>${department.description}</td>
            <td><a href="/edit-department/${department.id}"><button class="btn btn-primary"> EDIT</button></a>
                &nbsp;&nbsp;&nbsp;<button class="btn btn-danger" onclick="deleteRecord('delete-department/${department.id}')"> DELETE</button></td>
        </tr>
    </c:forEach>
    </tbody>
</table>


</body>
</html>
