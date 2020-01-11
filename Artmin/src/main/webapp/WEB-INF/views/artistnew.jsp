<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>

    <head>
        <title>New Artist</title>
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

            .item{
                height: 150px;  
            }

            .error {
                color: #ff0000;
            }

        </style>

           <nav class="navbar navbar-dark bg-dark">
        <div class="container-fluid">
            <div class="row justify-content-center">

                <div class="col-1" onclick="location.href = '<c:url value='/'/>';" style="cursor: pointer;">
                    <i class="material-icons my-auto text-white">home</i>
                </div>

            </div>

            <div class="col-8">
                <h4 class="text-center my-auto text-white">EDIT ARTIST</h4>
            </div>

            <div class="col col-1" onclick="location.href = '<c:url value='/artists/new'/>';" style="cursor: pointer;">
 

            </div>
        </div>
    </nav>


    <ol class="breadcrumb">
        <li class="breadcrumb-item"><a href="<c:url value='/'/>">Home</a></li>
        <li class="breadcrumb-item"><a href="<c:url value='/artists'/>">Artists</a></li>
        <li class="breadcrumb-item active">new Artist</li>
    </ol>
</head>


<body>



</body>
<div class="container-fluid">
    <div class="row">
 

        <div class="col-lg">

            <form:form method="POST" modelAttribute="artist">
                <form:input type="hidden" path="id" id="id"/>
                <fieldset>    

                    <!--ARTIST NAME-->
                    <!--ARTIST NAME-->
                    <!--ARTIST NAME-->
                    <div class="form-group">
                        <label for="exampleInputEmail1">Artist Name</label>
                        <form:input path="name" id="name" class="form-control" placeholder="Artist Name"/>
                        <form:errors path="name" cssClass="error"/>
                    </div>   

                    <!-- BESCHRIJVING -->
                    <!-- BESCHRIJVING -->
                    <!-- BESCHRIJVING -->
                    <div class="form-group">
                        <label for="exampleInputEmail1">Description</label>
                        <form:input path="description" id="description" class="form-control" placeholder="Description"/>
                        <form:errors path="description" cssClass="error"/>
                    </div>  

                    <hr>

                    <!-- Logo Url -->
                    <!-- Logo Url -->
                    <!-- Logo Url -->
                    <div class="form-group">
                        <label for="exampleInputEmail1">Logo Url</label>
                        <form:input path="logoUrl" id="logoUrl" class="form-control" placeholder="Logo Url"/>
                        <form:errors path="logoUrl" cssClass="error"/>
                    </div>  

                    <!-- SUBMIT BUTTON -->
                    <!-- SUBMIT BUTTON -->
                    <!-- SUBMIT BUTTON -->
                    <c:choose>
                        <c:when test="${edit}">
                            <button type="submit" class="btn btn-primary">Update Artist</button>

                        </c:when>
                        <c:otherwise>
                            <button type="submit" class="btn btn-primary btn-block">Add Artist</button>

                        </c:otherwise>
                    </c:choose>                

                </fieldset>
            </form:form>

        </div>
 
  </div>
</html>