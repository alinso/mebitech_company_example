<%@ page language="java" contentType="text/html; charset=UTF-8"
         import="java.util.Calendar" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:include page="partials/header.jsp" />

<body>
<c:forEach var="employee" items="${employees}" varStatus="loop">
    <h1>${employee.name}</h1>
    <h1>${employee.salary}</h1>

</c:forEach>
</body>
</html>
