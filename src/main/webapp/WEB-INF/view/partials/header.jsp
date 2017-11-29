<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <title> ${title} </title>
    <!-- Bootstrap core CSS -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/latest/css/bootstrap.min.css">


   <!-- <script src="${pageContext.request.contextPath}/node_modules/react/cjs/react.production.min.js"></script>
    <script src="${pageContext.request.contextPath}/node_modules/react-dom/cjs/react-dom.development.js"></script>
    <script src="${pageContext.request.contextPath}/node_modules/react-bootstrap/dist/react-bootstrap.js"></script>
-->
    <script src="https://unpkg.com/react@16.2.0/umd/react.development.js"></script>
    <script src="https://unpkg.com/react-dom@16.2.0/umd/react-dom.development.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/react-bootstrap/0.31.5/react-bootstrap.js"></script>
    <script src="${pageContext.request.contextPath}/require.js"></script>
    <script src="${pageContext.request.contextPath}/app.js"></script>

</head>

<body>

<nav class="navbar navbar-inverse">
    <div class="container">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
                <span class="sr-only">Menu</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="${pageContext.request.contextPath}">Mebitech Demo Company Meeting System</a>
            <ul class="nav navbar-nav">
            </ul>
        </div>
        <div id="navbar" class="navbar-collapse collapse">
            <ul class="nav navbar-nav navbar-left">
                <li><a href="${pageContext.request.contextPath}/meeting-list">Meetings</a></li>
                <li><a href="${pageContext.request.contextPath}/department-list">Departments</a></li>
                <li><a href="${pageContext.request.contextPath}/employee-list">Employees</a></li>
            </ul>
        </div>
    </div>
</nav>



<div class="container">
    <div class="row content">
