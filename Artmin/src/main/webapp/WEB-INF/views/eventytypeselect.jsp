<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>

    <head>
        <title>Select Event Type</title>
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



        </style>
    <nav class="navbar navbar-dark bg-dark">
        <div class="container-fluid">
            <div class="row justify-content-center">

                <div class="col-1" onclick="location.href = '<c:url value='/'/>';" style="cursor: pointer;">
                    <i class="material-icons my-auto text-white">home</i>
                </div>

            </div>

            <div class="col-8">
                <h4 class="text-center my-auto text-white">SELECT EVENT TYPE</h4>
            </div>

            <div class="col col-1" onclick="location.href = '<c:url value='/eventtypes/new-${hotartist.id}-${0}-${true}'/>';" style="cursor: pointer;">

                <i class="material-icons my-auto text-white">add</i>

            </div>

        </div>

    </div>
</nav>

<ol class="breadcrumb">
    <li class="breadcrumb-item"><a href="<c:url value='/'/>">Home</a></li>
    <li class="breadcrumb-item"><a href="<c:url value='/artists'/>">Artists</a></li>
    <li class="breadcrumb-item"><a href="<c:url value='/events/opn-events-${hotartist.id}'/>">Events</a></li>
    <li class="breadcrumb-item active">${hotartist.name} - Select Event Type</li>
</ol>
</head>

<body>  
    <c:forEach items="${eventtypes}" var="eventtype">
        <div class="container-fluid">
            <div class="row">        

                <div class="col">

                    <!--Weergave van één artist  -->
                    <!--Weergave van één artist  -->
                    <!--Weergave van één artist  -->
                    <div class="modal-content shadow">

                        <div onclick="location.href = '<c:url value='/eventtypes/select-${hotartist.id}-${event.id}-${eventtype.id}'/>';" style="cursor: pointer;">

                            <div class="text-center">
                                <h1 align="center"><c:out value="${eventtype.name}"/></h1>   
                            </div> 
                        </div>


                        <div class="modal-footer">

                            <button onclick="window.location.href = '<c:url value='/eventtypes/delete-${hotartist.id}-${event.id}-${eventtype.id}'/>';" type="button" class="btn btn-danger">
                                <i class="material-icons small">clear</i>
                            </button>   



                            <button onclick="window.location.href = '<c:url value='/eventtypes/edit-${hotartist.id}-${event.id}-${eventtype.id}'/>';" type="button" class="btn btn-warning">
                                <i class="material-icons small">edit</i>
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
