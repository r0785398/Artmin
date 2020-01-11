<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
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

            input[type='checkbox'] {
                display: block;
                margin-left: auto;
                margin-right: auto;
                margin-bottom: 10px;
                width:60px;
                height:60px;
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
                <h4 class="text-center my-auto text-white">New Todo</h4>
            </div>

            <div class="col col-1">

            </div>

        </div>

    </nav>

    <button type="button" class="btn btn-info btn-lg btn-block" onclick="location.href = '<c:url value='/events/detail-${event.id}'/>';">
        <div class="container-fluid">
            <div class="row">  
                <div class="col align-self-center">
                    <div class="text-right">
                        <i class="material-icons">clear_all</i>
                    </div>
                </div>

                <div class="col align-self-center text-left">
                    ${event.name}
                </div>
            </div>
        </div>
    </button>
</head>


<body>

    <div class="container-fluid">
        <div class="row">

            <div class="col-lg">

                <form:form method="POST" modelAttribute="todo">
                    <form:input type="hidden" path="id" id="id"/>
                    <form:input type="hidden" path="eventID" id="eventID" value="${event.id}"/>
                    <fieldset>    

                        <!--EVENT NAME-->
                        <!--EVENT NAME-->
                        <!--EVENT NAME-->
                        <div class="form-group">
                            <label for="exampleInputEmail1">Todo Name</label>

                            <form:input path="name" id="name" class="form-control" placeholder="Todo Name"/>
                        </div>


                        <!-- note-->
                        <!-- note-->
                        <!-- note-->
                        <div class="form-group">

                            <form:textarea class="form-control" rows="10" path="description" id="description" placeholder="Note..."></form:textarea>

                            </div>   

                            <hr>

                            <!-- FIle Path -->
                            <!-- FIle Path -->
                            <!-- FIle Path -->
                            <div class="form-group">
                                <label for="exampleInputEmail1">Attachment File Path</label>
                            <form:input path="attachmentFilePath" id="attachmentFilePath" class="form-control" placeholder="File Path"/>
                        </div>



                        <!-- Check -->
                        <!-- Check -->
                        <!-- Check -->
                        <div class="d-block">
                            <form:checkbox class="checkbox" path="ack" id="ack" />
                        </div>

                        <!-- SUBMIT BUTTON -->
                        <!-- SUBMIT BUTTON -->
                        <!-- SUBMIT BUTTON -->
                        <c:choose>
                            <c:when test="${edit}">
                                <button type="submit" class="btn btn-primary btn-block">Update Todo</button>

                            </c:when>
                            <c:otherwise>
                                <button type="submit" class="btn btn-primary btn-block">Add Todo</button>

                            </c:otherwise>
                        </c:choose>                

                    </fieldset>
                </form:form>

            </div>
        </div>
</body>
</html>