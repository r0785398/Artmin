<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %> <!-- Dependancies voor data format -->
<html>

    <head>
        <title>Events</title>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link href="<c:url value="/resources/bootstrap.css" />" rel="stylesheet">
        <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">

        <style>
            .glyphicon {
                font-size: 30px;
            }


            /* Grootte van de icons*/
            .material-icons{
                font-size: 50px
            }

            /* Grootte van de icons*/
            .small {
                font-size: 30px
            }

            .item{
                height: 120px;  
            }



        </style>
    <nav class="navbar navbar-dark bg-dark">
        <div class="container-fluid">
            <div class="row justify-content-center">

                <div class="col-1" onclick="location.href = '<c:url value='/'/>';" style="cursor: pointer;">
                    <i class="material-icons small my-auto text-white">home</i>
                </div>

            </div>

            <div class="col-8">
                <h4 class="text-center my-auto text-white">${event.name}</h4>
            </div>

            <div class="col col-1">

            </div>

        </div>
    </nav>

    <ol class="breadcrumb">
        <li class="breadcrumb-item"><a href="<c:url value='/'/>">Home</a></li>
        <li class="breadcrumb-item"><a href="<c:url value='/artists'/>">Artists</a></li>
        <li class="breadcrumb-item"><a href="<c:url value='/events/opn-events-${hotartist.id}'/>">Events</a></li>
        <li class="breadcrumb-item active">${event.eventType.name}: ${event.name}</li>
    </ol>
</head>


<body>
    <div class="row">   
        <div class="col">
            <div><h5 align="center" ><span class="badge badge-pill ${event.statusColor}">${event.statusText}</span></h5></div> 
        </div>
    </div>  


    <!-- NOTES -->
    <!-- NOTES -->
    <!-- NOTES -->
    <div class="container-fluid modal-content" >
        <div class="row shadow item">

            <div class="col-2 align-self-center">

                <!-- ICON COLUMN -->
                <!-- ICON COLUMN -->
                <!-- ICON COLUMN -->                 
                <div class="text-center">
                    <div onclick="location.href = '<c:url value='/notes/all-${event.id}'/>';" style="cursor: pointer;">
                        <i class="material-icons">assignment</i>
                    </div>
                </div>   

            </div>

            <div class="col-8" onclick="location.href = '<c:url value='/notes/all-${event.id}'/>';" style="cursor: pointer;">

                <!-- DETAIL MIDDLE COLUMN -->
                <!-- DETAIL MIDDLE COLUMN -->
                <!-- DETAIL MIDDLE COLUMN -->
                <div class="container">
                    <div class="row">
                        <div class="col-sm">
                            <h3>NOTES</h3>
                            <hr>
                        </div>
                    </div>

                    <div class="row">
                        <div class="col-sm" >
                            <span class="badge badge-pill badge-warning"><h6>${event.aantalNotes}</h6></span> 

                        </div>
                    </div>

                    <div class="row">
                        <div class="col-sm">

                        </div>
                    </div>
                </div>

            </div>

            <div class="col-2 align-self-center">                  

            </div>
        </div>
    </div>

    <hr>

    <!-- TODO -->
    <!-- TODO -->
    <!-- TODO -->
    <div class="container-fluid modal-content" >
        <div class="row shadow item">

            <div class="col-2 align-self-center">

                <!-- ICON COLUMN -->
                <!-- ICON COLUMN -->
                <!-- ICON COLUMN -->                 
                <div class="text-center">
                    <div onclick="location.href = '<c:url value='/todos/all-${event.id}'/>';" style="cursor: pointer;">
                        <i class="material-icons">event_available</i>
                    </div>
                </div>   

            </div>

            <div class="col-8" onclick="location.href = '<c:url value='/todos/all-${event.id}'/>';" style="cursor: pointer;">

                <!-- DETAIL MIDDLE COLUMN -->
                <!-- DETAIL MIDDLE COLUMN -->
                <!-- DETAIL MIDDLE COLUMN -->
                <div class="container">
                    <div class="row">
                        <div class="col-sm">
                            <h3>TODO</h3>
                            <hr>
                        </div>
                    </div>

                    <div class="row">
                        <div class="col-sm">
                            <span class="badge badge-pill badge-warning"><h6>${event.aantalTodoAck}/${event.aantalTodo} done</h6></span>
                        </div>
                    </div>

                    <div class="row">
                        <div class="col-sm">

                        </div>
                    </div>
                </div>

            </div>

            <div class="col-2 align-self-center">

                <!-- CHECK COLUMN -->
                <!-- CHECK COLUMN -->
                <!-- CHECK COLUMN -->                 
                <div class="text-center" onclick="location.href = '<c:url value='/events/ack-${event.id}-${1}'/>';" style="cursor: pointer;">
                    <c:choose>
                        <c:when test="${event.todoAck}">
                            <i class="material-icons">check</i>

                        </c:when>
                        <c:otherwise>
                            <i class="material-icons">clear</i>
                        </c:otherwise>
                    </c:choose> 
                </div>  

            </div>
        </div>
    </div>

    <hr>

    <!-- DATE -->
    <!-- DATE -->
    <!-- DATE -->

    <div class="container-fluid modal-content" >
        <div class="row shadow item">

            <div class="col-2 align-self-center">

                <!-- ICON COLUMN -->
                <!-- ICON COLUMN -->
                <!-- ICON COLUMN -->                 
                <div class="text-center">
                    <div onclick="location.href = '<c:url value='/events/date-${event.id}'/>';" style="cursor: pointer;">
                        <i class="material-icons">event</i>
                    </div>
                </div>   


            </div>

            <div class="col-8" onclick="location.href = '<c:url value='/events/date-${event.id}'/>';" style="cursor: pointer;">

                <!-- DETAIL MIDDLE COLUMN -->
                <!-- DETAIL MIDDLE COLUMN -->
                <!-- DETAIL MIDDLE COLUMN -->
                <div class="container">
                    <div class="row">
                        <div class="col-sm">
                            <h3>DATE</h3>
                            <hr>
                        </div>
                    </div>

                    <div class="row">
                        <div class="col-sm">

                            <h6><fmt:formatDate value="${event.dateCalendar}" type="date" pattern="dd-MMM-yyyy"/></h6>
                        </div>
                    </div>

                    <div class="row">
                        <div class="col-sm">

                            <fmt:formatDate value="${event.dateActStart}" type="date" pattern="HH:mm"/>
                            - 
                            <fmt:formatDate value="${event.dateActEnd}" type="date" pattern="HH:mm"/>
                        </div>
                    </div>
                </div>

            </div>

            <div class="col-2 align-self-center">

                <!-- CHECK COLUMN -->
                <!-- CHECK COLUMN -->
                <!-- CHECK COLUMN -->                 
                <div class="text-center" onclick="location.href = '<c:url value='/events/ack-${event.id}-${2}'/>';" style="cursor: pointer;">
                    <c:choose>
                        <c:when test="${event.dateAck}">
                            <i class="material-icons">check</i>

                        </c:when>
                        <c:otherwise>
                            <i class="material-icons">clear</i>
                        </c:otherwise>
                    </c:choose> 
                </div>  

            </div>
        </div>
    </div>

    <hr>

    <!-- Confirmed -->
    <!-- Confirmed -->
    <!-- Confirmed -->
    <div class="container-fluid modal-content" >
        <div class="row shadow item">

            <div class="col-2 align-self-center">

                <!-- ICON COLUMN -->
                <!-- ICON COLUMN -->
                <!-- ICON COLUMN -->                 
                <div class="text-center" onclick="location.href = '<c:url value='/events/ack-${event.id}-${3}'/>';" style="cursor: pointer;">
                    <i class="material-icons">check_box</i>
                </div>  
            </div>

            <div class="col-8">

                <!-- DETAIL MIDDLE COLUMN -->
                <!-- DETAIL MIDDLE COLUMN -->
                <!-- DETAIL MIDDLE COLUMN -->
                <div class="container" onclick="location.href = '<c:url value='/events/ack-${event.id}-${3}'/>';" style="cursor: pointer;">
                    <div class="row">
                        <div class="col-sm">
                            <h3>CONFIRMED</h3>
                            <hr>
                        </div>
                    </div>

                    <div class="row">
                        <div class="col-sm">            
                        </div>
                    </div>

                    <div class="row">
                        <div class="col-sm">                
                        </div>
                    </div>
                </div>

            </div>

            <div class="col-2 align-self-center">

                <!-- CHECK COLUMN -->
                <!-- CHECK COLUMN -->
                <!-- CHECK COLUMN -->                 
                <div class="text-center" onclick="location.href = '<c:url value='/events/ack-${event.id}-${3}'/>';" style="cursor: pointer;">
                    <c:choose>
                        <c:when test="${event.confirmedAck}">
                            <i class="material-icons">check</i>

                        </c:when>
                        <c:otherwise>
                            <i class="material-icons">clear</i>
                        </c:otherwise>
                    </c:choose> 
                </div>  

            </div>
        </div>
    </div>

    <hr>

    <!-- Location -->
    <!-- Location -->
    <!-- Location -->
    <div class="container-fluid modal-content" >
        <div class="row shadow item">

            <div class="col-2 align-self-center">

                <!-- ICON COLUMN -->
                <!-- ICON COLUMN -->
                <!-- ICON COLUMN -->    
                <div class="text-center">
                    <div onclick="location.href = '<c:url value='/locations/all-${event.id}'/>';" style="cursor: pointer;">
                        <i class="material-icons">location_on</i>
                    </div>  
                </div>
            </div>


            <div class="col-8">

                <!-- DETAIL MIDDLE COLUMN -->
                <!-- DETAIL MIDDLE COLUMN -->
                <!-- DETAIL MIDDLE COLUMN -->
                <div class="container" onclick="location.href = '<c:url value='/locations/all-${event.id}'/>';" style="cursor: pointer;">
                    <div class="row">
                        <div class="col-sm">
                            <h3>LOCATION</h3>
                            <hr>
                        </div>
                    </div>

                    <div class="row">
                        <div class="col-sm">    
                            <h6>${event.location.name}</h6>
                        </div>
                    </div>

                    <div class="row">
                        <div class="col-sm">                
                            ${event.location.city}
                        </div>
                    </div>
                </div>

            </div>

            <div class="col-2 align-self-center">

                <!-- CHECK COLUMN -->
                <!-- CHECK COLUMN -->
                <!-- CHECK COLUMN -->                 
                <div class="text-center" onclick="location.href = '<c:url value='/events/ack-${event.id}-${4}'/>';" style="cursor: pointer;">
                    <c:choose>
                        <c:when test="${event.locationAck}">
                            <i class="material-icons">check</i>

                        </c:when>
                        <c:otherwise>
                            <i class="material-icons">clear</i>
                        </c:otherwise>
                    </c:choose> 
                </div>  
            </div>  

        </div>
    </div>
</div>

<hr>


<!-- Client -->
<!-- Client -->
<!-- Client -->
<div class="container-fluid modal-content" >
    <div class="row shadow item">

        <div class="col-2 align-self-center">

            <!-- ICON COLUMN -->
            <!-- ICON COLUMN -->
            <!-- ICON COLUMN -->    
            <div class="text-center">
                <div onclick="location.href = '<c:url value='/clients/all-${event.id}'/>';" style="cursor: pointer;">
                    <i class="material-icons">person</i>
                </div>  
            </div>
        </div>

        <div class="col-8" onclick="location.href = '<c:url value='/clients/all-${event.id}'/>';" style="cursor: pointer;">

            <!-- DETAIL MIDDLE COLUMN -->
            <!-- DETAIL MIDDLE COLUMN -->
            <!-- DETAIL MIDDLE COLUMN -->
            <div class="container">
                <div class="row">
                    <div class="col-6">
                        <h3>CLIENT</h3>                  
                    </div>

                    <div class="col-6">
                        <a href="/clients/new-${event.id}-true">Client Form</a>                  
                    </div>
                </div>    

                <div class="row">
                    <div class="col-sm">    
                        <h6>${event.client.name}</h6>
                    </div>
                </div>



                <div class="row">
                    <div class="col-6">    ·
                        ${event.client.city}
                    </div>

                    <div class="col-6">    
                        ${event.client.email}
                    </div>
                </div>
            </div>

        </div>

        <div class="col-2 align-self-center">

            <!-- CHECK COLUMN -->
            <!-- CHECK COLUMN -->
            <!-- CHECK COLUMN -->                 
            <div class="text-center" onclick="location.href = '<c:url value='/events/ack-${event.id}-${5}'/>';" style="cursor: pointer;">
                <c:choose>
                    <c:when test="${event.clientAck}">
                        <i class="material-icons">check</i>

                    </c:when>
                    <c:otherwise>
                        <i class="material-icons">clear</i>
                    </c:otherwise>
                </c:choose> 
            </div>  

        </div>
    </div>
</div>

<hr>
<!-- CROWD -->
<!-- CROWD -->
<!-- CROWD -->
<div class="container-fluid modal-content" >
    <div class="row shadow item">

        <div class="col-2 align-self-center">

            <!-- ICON COLUMN -->
            <!-- ICON COLUMN -->
            <!-- ICON COLUMN -->                 
            <div class="text-center">
                <div onclick="location.href = '<c:url value='/events/crowd-${event.id}'/>';" style="cursor: pointer;">
                    <i class="material-icons">people</i>
                </div>
            </div>  
        </div>

        <div class="col-8" onclick="location.href = '<c:url value='/events/crowd-${event.id}'/>';" style="cursor: pointer;">

            <!-- DETAIL MIDDLE COLUMN -->
            <!-- DETAIL MIDDLE COLUMN -->
            <!-- DETAIL MIDDLE COLUMN -->
            <div class="container">
                <div class="row">
                    <div class="col-sm">
                        <h3>CROWD</h3>
                    </div>
                </div>

                <div class="row">
                    <div class="col-sm">  
                        <h6>${event.crowdQty} PEOPLE</h6>
                    </div>
                </div>

                <div class="row">
                    <div class="col-sm">                
                        Average age: ${event.crowdsAvgAge}  

                    </div>
                </div>
            </div>

        </div>

        <div class="col-2 align-self-center">

            <!-- CHECK COLUMN -->
            <!-- CHECK COLUMN -->
            <!-- CHECK COLUMN -->                 
            <div class="text-center" onclick="location.href = '<c:url value='/events/ack-${event.id}-${6}'/>';" style="cursor: pointer;">
                <c:choose>
                    <c:when test="${event.crowdAck}">
                        <i class="material-icons">check</i>

                    </c:when>
                    <c:otherwise>
                        <i class="material-icons">clear</i>
                    </c:otherwise>
                </c:choose> 
            </div>  

        </div>
    </div>
</div>

<hr>

<!-- PAYMENTS -->
<!-- PAYMENTS -->
<!-- PAYMENTS -->
<div class="container-fluid modal-content" >
    <div class="row shadow item">

        <div class="col-2 align-self-center">

            <!-- ICON COLUMN -->
            <!-- ICON COLUMN -->
            <!-- ICON COLUMN -->   
            <div class="text-center">
                <div onclick="location.href = '<c:url value='/payments/all-${event.id}'/>';" style="cursor: pointer;">
                    <i class="material-icons">account_balance_wallet</i>
                </div>  
            </div>
        </div>

        <div class="col-8" onclick="location.href = '<c:url value='/payments/all-${event.id}'/>';" style="cursor: pointer;">

            <!-- DETAIL MIDDLE COLUMN -->
            <!-- DETAIL MIDDLE COLUMN -->
            <!-- DETAIL MIDDLE COLUMN -->
            <div class="container">
                <div class="row">
                    <div class="col-sm">
                        <h3>PAYMENTS</h3>
                        <hr>
                    </div>
                </div>

                <div class="row">
                    <div class="col-sm">
                        <span class="badge badge-pill badge-warning"><h6>${event.aantalPaymentsAck}/${event.aantalPayments} DONE</h6></span>
                    </div>
                </div>

                <div class="row">
                    <div class="col-sm">                
                    </div>
                </div>
            </div>

        </div>

        <div class="col-2 align-self-center">

            <!-- CHECK COLUMN -->
            <!-- CHECK COLUMN -->
            <!-- CHECK COLUMN -->                 
            <div class="text-center">

            </div>  

        </div>
    </div>
</div>

<hr>

<button type="button" class="item btn btn-danger btn-lg btn-block" onclick="location.href = '<c:url value='/events/ack-${event.id}-${7}'/>';">CANCEL EVENT</button>
</body>
</html>
