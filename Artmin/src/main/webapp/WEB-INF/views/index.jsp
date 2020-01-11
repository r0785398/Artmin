<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %> <!-- Dependancies voor data format -->
<html>

    <head>
        <title>Artmin Home</title>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link href="<c:url value="/resources/bootstrap.css" />" rel="stylesheet">
        <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">

        <style>
            .glyphicon {
                font-size: 30px;
            }

            /* Grootte van de icons*/
            .material-icons {
                font-size: 30px
            }

            .small {
                font-size: 15px
            }

            .item{
                height: 150px;  
            }

            img {
                max-width: 100%;
                max-height: 100%;
            }



        </style>

    <head>
    <nav class="navbar navbar-dark bg-dark">
        <div class="container-fluid justify-content-center">
            <h4 class="text-center my-auto text-white">ARTMIN</h4>
        </div>
    </nav>


</head>

<body>

    <br>
    <br>

    <div class="container-fluid">    
        <div class="row">
            <div class="col-3">

            </div>
            <div class="col-6">
                <img src="<c:url value="/resources/logo.png" />"  alt="Italian Trulli">
            </div>
            <div class="col-3">

            </div>
        </div>
    </div>

    <br>
    <br>


    <div class="container-fluid justify-content-center">
        <h6 class="text-center my-auto">
            Administration tool for Artists   
        </h6>
    </div>

    <br>
    <br>


    <div class="container-fluid">
        <div class="row">

            <div class="col-lg">

                <form:form method="POST" modelAttribute="note">
                    <form:input type="hidden" path="id" id="id"/>
                    <form:input type="hidden" path="eventID" id="eventID" value="${event.id}"/>
                    <fieldset>    

                        <!-- Username-->
                        <!-- Username-->
                        <!-- Username-->
                        <div class="form-group">
                            <label for="exampleInputEmail1">E-mail</label>
                            <form:textarea class="form-control" rows="10" path="email" id="email" placeholder="Note..."></form:textarea>
                        </div>   

                        <!-- Password-->
                        <!-- Password-->
                        <!-- Password-->
                        <div class="form-group">
                            <label for="exampleInputEmail1">Password</label>
                            <form:textarea class="form-control" rows="10" path="password" id="password" placeholder="Note..."></form:textarea>
                        </div>   

                        <!-- SUBMIT BUTTON -->
                        <!-- SUBMIT BUTTON -->
                        <!-- SUBMIT BUTTON -->
                        <c:choose>
                            <c:when test="${edit}">

                                <button type="submit" class="btn btn-primary">Update Note</button>

                            </c:when>
                            <c:otherwise>

                                <button type="button" class="btn btn-outline-secondary btn-block" >Login</button>
                            </c:otherwise>
                        </c:choose>                

                    </fieldset>
                </form:form>

            </div>
        </div>
</body>
</html>
