<%@ page language="java" contentType="text/html; charset=UTF-8"
         import="java.util.Calendar" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:include page="partials/header.jsp" />

<body>






    <form:form modelAttribute="meetingDepartment">

        <div class="form-group">
            <label for="departmentId">Add Department To Meeting:</label>
            <form:select path="departmentId" id="departmentId">
                <form:options path="departmentId" items="${allDepartments}" itemLabel="name" itemValue="id"/>
            </form:select>
        </div>

        <input type="hidden" value="${meeting.id}" id="mId">

        <button type="button" class="btn btn-default" id="add_department">Add to Meeting</button>

</form:form>

    <script>

        document.getElementById("add_department").addEventListener("click", function(){

            var meetingData  ={};
            meetingData.departmentId  = document.getElementById("departmentId").value;
            meetingData.meetingId = document.getElementById("mId").value;
            postJSONP("/add-department-to-meeting", JSON.stringify(meetingData),function (result) {
                console.log(result);
            });

        });

    </script>
<table class="table">
    <thead>
    <tr>
        <th>Department Name</th>
        <th>Action</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="department" items="${enrolledDepartments}" varStatus="loop">
        <tr>
            <td>${department.name}</td>

                <td><button class="btn btn-danger" onclick="removeFromMeeting('/remove-department-from-meeting', ${meeting.id}, ${department.id})"> REMOVE FROM MEETING</button></td>
        </tr>
    </c:forEach>
    </tbody>
</table>


</body>
</html>
