<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>

    <head>
        <title>Events</title>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link href="<c:url value="/resources/bootstrap.css" />" rel="stylesheet">
        <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">

        <style>


        </style>
    <nav class="navbar navbar-dark bg-dark">
        <div class="container-fluid">
            <div class="row justify-content-center">

                <div class="col-1" onclick="location.href = '<c:url value='/'/>';" style="cursor: pointer;">
                    <i class="material-icons my-auto text-white">home</i>
                </div>

            </div>

            <div class="col-8">
                <h4 class="text-center my-auto text-white">NEW EVENT</h4>
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
    <li class="breadcrumb-item active">${hotartist.name} - new Event</li>
</ol>
</head>

<body>

    <div class="container-fluid">
        <div class="row">

            <div class="col-lg">

                <form:form action="/events/new-${hotartist.id}" method="POST" modelAttribute="event">
                    <form:input type="hidden" path="id" id="id"/>
                    <form:input type="hidden" path="artistID" id="artistID" value="${hotartist.id}"/>

                    <form:input type="hidden" path="locationID" id="locationID" value="0"/>
                    <form:input type="hidden" path="clientID" id="clientID" value="0"/>

                    <form:input type="hidden" path="eventTypeID" id="eventTypeID" value="${eventtype.id}"/>
                    <fieldset>    

                        <!--EVENT NAME-->
                        <!--EVENT NAME-->
                        <!--EVENT NAME-->
                        <div class="form-group">
                            <label for="exampleInputEmail1">Event name</label>

                            <form:input path="name" id="name" class="form-control" placeholder="Event Name"/>
                        </div>

                        <!--Event TYPE-->
                        <!--Event TYPE-->
                        <!--Event TYPE-->                            

                        <div class="form-group">
                            <label for="exampleSelect1">Event Type</label>

                            <div class="form-group">
                                <fieldset disabled="">
                                    <input class="form-control" id="disabledInput" type="text" placeholder="${eventtype.name}" disabled="">
                                </fieldset>
                            </div>


                        </div>

                        <hr>

                        <button type="submit" class="btn btn-primary btn-block">ADD Event</button>

                    </fieldset>
                </form:form>

            </div>

        </div>
</body>
</html>