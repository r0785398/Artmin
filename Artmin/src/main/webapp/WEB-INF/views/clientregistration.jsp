<%-- 
    Document   : clientregistration
    Created on : 21-dec-2019, 11:31:07
    Author     : m0317426
--%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=windows-1252">
        <title>Client Registration</title>
   <style>
 
    .error {
        color: #ff0000;
    }
</style>
 
</head>
 
<body>
 
    <h2>Client Registration Form</h2>
  
    <form:form method="POST" modelAttribute="client">
        <form:input type="hidden" path="id" id="id"/>
        <table>
            <!-- Client Name -->
            <tr>
                <td><label for="name">Client name: </label> </td>
                <td><form:input path="name" id="name"/></td>
            </tr>
            
            <!-- Street -->
            <tr>
                <td><label for="street">Street: </label> </td>
                <td><form:input path="street" id="street"/></td>
            </tr>
            
            <!-- nrBus -->
            <tr>
                <td><label for="nrBus">nrBus: </label> </td>
                <td><form:input path="nrBus" id="nrBus"/></td>
            </tr>
            
            <!-- postCode -->
            <tr>
                <td><label for="postCode">postCode: </label> </td>
                <td><form:input path="postCode" id="postCode"/></td>
            </tr>
            
            <!-- city -->
            <tr>
                <td><label for="city">city: </label> </td>
                <td><form:input path="city" id="city"/></td>
            </tr>
            
            <!-- country -->
            <tr>
                <td><label for="country">country: </label> </td>
                <td><form:input path="country" id="country"/></td>
            </tr>
            
            <!-- phone -->
            <tr>
                <td><label for="phone">phone: </label> </td>
                <td><form:input path="phone" id="phone"/></td>
            </tr>
            
            <!-- email -->
            <tr>
                <td><label for="email">email: </label> </td>
                <td><form:input path="email" id="email"/></td>
            </tr>
            
            <!-- vat -->
            <tr>
                <td><label for="vat">vat: </label> </td>
                <td><form:input path="vat" id="vat"/></td>
            </tr>
            
            <!-- ack -->
            <tr>
                <td><label for="ack">ack: </label> </td>
                <td><form:input path="ack" id="ack"/></td>
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
 