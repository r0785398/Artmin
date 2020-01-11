<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %> <!-- Dependancies voor data format -->
<html>

    <head>
    <head>
        <title>Artists</title>
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
            
            .logo{
                width: 95%;
                width: 95%\9;
            }
        </style>


    <nav class="navbar navbar-dark bg-dark">
        <div class="container-fluid ">
            <div class="row justify-content-center">

                <div class="col-1 " onclick="location.href = '<c:url value='/'/>';" style="cursor: pointer;">
                    <i class="material-icons my-auto text-white">home</i>
                </div>

            </div> 

            <div class="col-8" >
                <h4 class="text-center my-auto text-white">ARTISTS</h4>
            </div>

            <div class="col col-1 " onclick="location.href = '<c:url value='/artists/new'/>';" style="cursor: pointer;">
                <i class="material-icons my-auto text-white">add</i>
            </div>
        </div>
    </nav>

    <ol class="breadcrumb">
        <li class="breadcrumb-item"><a href="<c:url value='/'/>">Home</a></li>
        <li class="breadcrumb-item active">Artists</li>
    </ol>
</head>


<body>  
    <c:forEach items="${artists}" var="artist">
        <div class="container-fluid">
            <div class="row">        

                <div class="col">

                    <!--Weergave van één artist  -->
                    <!--Weergave van één artist  -->
                    <!--Weergave van één artist  -->
                    <div class="modal-content shadow">

                        <div onclick="location.href = '<c:url value='/events/opn-events-${artist.id}'/>';" style="cursor: pointer;">
                            
                            <div class="image-wrapper">
                                <img src="${artist.logoUrl}" alt="logo" class="img-fluid logo"/>
                            </div>

                            <div class="text-center">
                                <h1 align="center"><c:out value="${artist.name}"/></h1>   
                                <h6 align="center"><c:out value="${artist.description}"/></h6>  
                            </div> 
                        </div>


                        <div class="modal-footer">


                            <button onclick="window.location.href = '<c:url value='/artists/edit-${artist.id}-artist'/>';" type="button" class="btn btn-warning">
                                <i class="material-icons small">edit</i>
                            </button>

                                
                            <button onclick="window.location.href = '<c:url value='/artists/delete-${artist.id}-artist'/>';" type="button" class="btn btn-danger">
                                <i class="material-icons small">clear</i>
                            </button>  
                                




                        </div>
                    </div>

                    <hr>


                </div>     
            </div>
        </div>
    </c:forEach>
</body>
</html>
