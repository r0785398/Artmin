<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 
<html>
 
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>User Registration Form</title>
 
<style>
 
    .error {
        color: #ff0000;
    }
</style>
 
</head>
 
<body>
 
    <h2>Registration Form</h2>
  
    <form:form method="POST" modelAttribute="artist">
        <form:input type="hidden" path="id" id="id"/>
        <table>
            <!-- Artist Name -->
            <tr>
                <td><label for="name">Artist name: </label> </td>
                <td><form:input path="name" id="name"/></td>
            </tr>
            
            <!-- Description -->
            <tr>
                <td><label for="description">Description: </label> </td>
                <td><form:input path="description" id="description"/></td>
            </tr>
            
            <!-- Logo URL -->
            <tr>
                <td><label for="logoUrl">Logo URL: </label> </td>
                <td><form:input path="logoUrl" id="logoUrl"/></td>
            </tr>
         
            <tr>
            <tr>
                <td colspan="3">
                    <c:choose>
                        <c:when test="${edit}">
                            <input type="submit" value="Update"/>
                        </c:when>
                        <c:otherwise>
                            <input type="submit" value="Register"/>
                        </c:otherwise>
                    </c:choose>
                </td>
            </tr>
            <tr>
                <td>
                    ${message}
                </td>
            </tr>
        </table>
    </form:form>
    <br/>
    <br/>
    Go back to <a href="<c:url value='/artist/list' />">List of All Artists </a>
</body>
</html>