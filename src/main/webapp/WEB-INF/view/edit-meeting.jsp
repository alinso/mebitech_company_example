<%@ page language="java" contentType="text/html; charset=UTF-8"
         import="java.util.Calendar" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:include page="partials/header.jsp" />
<body>

<h3>${title}</h3>
<form:form modelAttribute="meeting">
    <div class="form-group">
        <label for="name">Meeting Name:</label>
        <form:input type="text" class="form-control" id="name" path="name"/>
    </div>
    <div class="form-group">
        <label for="surname">Meeting Description:</label>
        <form:input  type="text" class="form-control" id="description" path="description"/>
    </div>

    <form:hidden path="id" id="eId"></form:hidden>

    <button type="button" class="btn btn-default" id="save_meeting">Submit</button>
</form:form>


<div id="texts"></div>
<script>

    document.getElementById("save_meeting").addEventListener("click", function(){

        var meetingData  ={};
        meetingData.name  = document.getElementById("name").value;
        meetingData.id = document.getElementById("eId").value;
        meetingData.description = document.getElementById("description").value;
        postJSONP("/save-meeting", JSON.stringify(meetingData),function (result) {
            console.log(result);
        });

    });

</script>

</body>
</html>
