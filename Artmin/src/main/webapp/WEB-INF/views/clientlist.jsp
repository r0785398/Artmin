<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Clients</title>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <link href="<c:url value="/resources/bootstrap.css" />" rel="stylesheet">
    <style>
        tr:first-child{
            font-weight: bold;
            background-color: #C6C9C4;
        }
    </style>
</head>
 
 
<body>
    
    <h2>List of Clients</h2>  
    <table>
        <tr>
            <td>ID</td>
            <td>Clientname</td>
            <td></td>
            <td></td>
        </tr>
        
        <c:forEach items="${clients}" var="client">
            <tr>
            <td>${client.id}</td>
            <td>${client.name}</td>
            <td><a href="<c:url value='/client/edit-${client.id}-client' />">edit</a></td>
            <td><a href="<c:url value='/client/delete-${client.id}-client' />">delete</a></td>
            </tr>
        </c:forEach>
    </table>
    <br/>
    <a href="<c:url value='/client/new' />">Add New Client</a>
</body>
</html>
