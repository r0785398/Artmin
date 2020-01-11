<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>

    <head>
        <title>New Event Type</title>
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



        </style>

    <nav class="navbar navbar-dark bg-dark">
        <div class="container-fluid">
            <div class="row justify-content-center">

                <div class="col-1" onclick="location.href = '<c:url value='/'/>';" style="cursor: pointer;">
                    <i class="material-icons my-auto text-white">home</i>
                </div>

            </div>

            <div class="col-8">
                <h4 class="text-center my-auto text-white">New Event Type</h4>
            </div>

            <div class="col col-1">

            </div>

        </div>

    </div>
</nav>

<ol class="breadcrumb">
    <li class="breadcrumb-item"><a href="<c:url value='/'/>">Home</a></li>
    <li class="breadcrumb-item"><a href="<c:url value='/artists'/>">Artists</a></li>
    <li class="breadcrumb-item"><a href="<c:url value='/events/opn-events-${hotartist.id}'/>">Events</a></li>
    <li class="breadcrumb-item active">${hotartist.name} - new Event Type</li>
</ol>
</head>
<body>

    <div class="container-fluid">
        <div class="row">

            <div class="col-lg">
                <c:choose>
                    <c:when test="${edit}">
                        <!-- EDIT FORM -->
                        <!-- EDIT FORM -->
                        <!-- EDIT FORM -->
                        <form:form action="/eventtypes/edit-${hotartist.id}-${event.id}" method="POST" modelAttribute="eventtype">
                            <form:input type="hidden" path="Id" id="Id"/>
                            <form:input type="hidden" path="artistID" id="artistID" value="${hotartist.id}"/>

                            <fieldset>    

                                <!--EVENT TYPE NAME-->
                                <!--EVENT TYPE NAME-->
                                <!--EVENT TYPE NAME-->
                                <div class="form-group">
                                    <label for="exampleInputEmail1">Type name</label>

                                    <form:input path="name" id="name" class="form-control" placeholder="Event Type Name"/>
                                </div>

                                <hr>

                                <button type="submit" class="btn btn-primary">Update Event Type</button>

                            </fieldset>


                        </form:form>
                    </c:when>
                    <c:otherwise>


                        <!-- NEW FORM -->
                        <!-- NEW FORM -->
                        <!-- NEW FORM -->
                        <form:form action="/eventtypes/new-${hotartist.id}-${event.id}" method="POST" modelAttribute="eventtype">
                            <form:input type="hidden" path="Id" id="Id"/>
                            <form:input type="hidden" path="artistID" id="artistID" value="${hotartist.id}"/>

                            <fieldset>    

                                <!--EVENT TYPE NAME-->
                                <!--EVENT TYPE NAME-->
                                <!--EVENT TYPE NAME-->
                                <div class="form-group">
                                    <label for="exampleInputEmail1">Type name</label>

                                    <form:input path="name" id="name" class="form-control" placeholder="Event Type Name"/>
                                </div>

                                <hr>

                                <button type="submit" class="btn btn-primary btn-block">ADD Event Type</button>

                            </fieldset>
                        </form:form>


                    </c:otherwise>
                </c:choose>   

            </div>

        </div>
</body>
</html>
