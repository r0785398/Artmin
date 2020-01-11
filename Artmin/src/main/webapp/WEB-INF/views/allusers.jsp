<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Users</title>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
       <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="<c:url value="/resources/bootstrap.css" />" rel="stylesheet">
    <style>
        tr:first-child{
            font-weight: bold;
            background-color: #C6C9C4;
        }
    </style>
</head>
 
 
<body>
    
    <h2>List of Employees</h2>  
    <table>
        <tr>
            <td>ID</td>
            <td>Username</td>
            <td></td>
            <td></td>
        </tr>
        
        <c:forEach items="${users}" var="user">
            <tr>
            <td>${user.id}</td>
            <td>${user.username}</td>
            <td><a href="<c:url value='/demo/edit-${user.id}-user' />">edit</a></td>
            <td><a href="<c:url value='/demo/delete-${user.id}-user' />">delete</a></td>
            </tr>
        </c:forEach>
    </table>
    <br/>
    <a href="<c:url value='/demo/new' />">Add New User</a>
</body>
</html>
