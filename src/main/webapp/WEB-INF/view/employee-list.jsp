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
    <th>Surname</th>
    <th>Salary</th>
    <th>Department</th>
    <th>Action</th>
</tr>
</thead>
<tbody>
 <c:forEach var="employee" items="${employees}" varStatus="loop">
<tr>
    <td>${employee.name}</td>
    <td>${employee.surname}</td>
    <td>${employee.salary}</td>
    <td>${employee.department.name}</td>
    <td><a href="/edit-employee/${employee.id}"><button class="btn btn-primary"> EDIT</button></a>
        &nbsp;&nbsp;&nbsp;<button class="btn btn-danger" onclick="deleteRecord('delete-employee/${employee.id}')"> DELETE</button></td>
</tr>
</c:forEach>
</tbody>
</table>


</body>
</html>
