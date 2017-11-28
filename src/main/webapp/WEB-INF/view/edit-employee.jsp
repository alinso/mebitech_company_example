<%@ page language="java" contentType="text/html; charset=UTF-8"
         import="java.util.Calendar" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:include page="partials/header.jsp" />
<body>

<h3>${title}</h3>
<form:form modelAttribute="eViewModel">
    <div class="form-group">
        <label for="name">Employee Name:</label>
        <form:input type="text" class="form-control" id="name" path="employee.name"/>
    </div>
    <div class="form-group">
        <label for="surname">Employee Surname:</label>
        <form:input  type="text" class="form-control" id="employee" path="employee.surname"/>
    </div>
    <div class="form-group">
        <label for="salary">Employee Salary:</label>
        <form:input  type="text" class="form-control" id="salary" path="employee.salary"/>
    </div>

    <div class="form-group">
        <label for="department">Employee Department:</label>
        <form:select path="departmentId">
            <form:options path="departmentId" items="${departments}" itemLabel="name" itemValue="id"/>
        </form:select>
    </div>


    <button type="submit" class="btn btn-default">Submit</button>
</form:form>


</body>
</html>
