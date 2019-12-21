<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=windows-1252">
        <title>Artist Confirmation Page</title>
    </head>

</head>
<body>
    message : ${success}
    <h1>Jippie!!</h1>
    <br/>
    <br/>
    Go back to <a href="<c:url value='/artist/list' />">List of All Artists</a>
     
</body>
</html>
