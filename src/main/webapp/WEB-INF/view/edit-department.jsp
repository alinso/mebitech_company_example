<%@ page language="java" contentType="text/html; charset=UTF-8"
         import="java.util.Calendar" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:include page="partials/header.jsp" />
<body>

<h3>${title}</h3>
<form:form modelAttribute="department">
    <div class="form-group">
        <label for="name">Department Name:</label>
        <form:input type="text" class="form-control" id="name" path="name"/>
    </div>
    <div class="form-group">
        <label for="surname">Department Description:</label>
        <form:input  type="text" class="form-control" id="description" path="description"/>
    </div>

    <form:hidden path="id" id="eId"></form:hidden>

    <button type="button" class="btn btn-default" id="save_department">Submit</button>
</form:form>


<div id="texts"></div>
<script>

    document.getElementById("save_department").addEventListener("click", function(){

        var departmentData  ={};
        departmentData.name  = document.getElementById("name").value;
        departmentData.id = document.getElementById("eId").value;
        departmentData.description = document.getElementById("description").value;
        postJSONP("/save-department", JSON.stringify(departmentData),function (result) {
            console.log(result);
        });

    });

</script>

</body>
</html>
