<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Artists</title>
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
    
    <h2>List of Artists</h2>  
    <table>
        <tr>
            <td>ID</td>
            <td>Artistname</td>
            <td></td>
            <td></td>
        </tr>
        
        <c:forEach items="${artists}" var="artist">
            <tr>
            <td>${artist.id}</td>
            <td>${artist.name}</td>
            <td><a href="<c:url value='/artist/edit-${artist.id}-artist' />">edit</a></td>
            <td><a href="<c:url value='/artist/delete-${artist.id}-artist' />">delete</a></td>
            </tr>
        </c:forEach>
    </table>
    <br/>
    <a href="<c:url value='/artist/new' />">Add New Artist</a>
</body>
</html>
