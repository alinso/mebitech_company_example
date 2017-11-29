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
        <form:input type="text" class="form-control" id="name" path="name"/>
    </div>
    <div class="form-group">
        <label for="surname">Employee Surname:</label>
        <form:input  type="text" class="form-control" id="surname" path="surname"/>
    </div>
    <div class="form-group">
        <label for="salary">Employee Salary:</label>
        <form:input  type="text" class="form-control" id="salary" path="salary"/>
    </div>

    <div class="form-group">
        <label for="department">Employee Department:</label>
        <form:select path="departmentId" id="departmentId">
            <form:options path="departmentId" items="${departments}" itemLabel="name" itemValue="id"/>
        </form:select>
    </div>

    <form:hidden path="id" id="eId"></form:hidden>

    <button type="button" class="btn btn-default" id="save_employee">Submit</button>
</form:form>


<div id="texts"></div>
<script>

    document.getElementById("save_employee").addEventListener("click", function(){

        var eData  ={};
        eData.name  = document.getElementById("name").value;
        eData.id = document.getElementById("eId").value;
        eData.surname  = document.getElementById("surname").value;
        eData.salary  = document.getElementById("salary").value;
        eData.departmentId  = document.getElementById("departmentId").value;
        postJSONP("/save-employee", JSON.stringify(eData),function (result) {
           console.log(result);
        });

    });

</script>

</body>
</html>
