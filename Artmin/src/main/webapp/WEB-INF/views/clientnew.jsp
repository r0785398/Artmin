<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>

    <head>
        <title>Client Information</title>
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
                <c:if test="${!publicclient}">
                    <div class="col-1" onclick="location.href = '<c:url value='/'/>';" style="cursor: pointer;">
                        <i class="material-icons my-auto text-white">home</i>
                    </div>
                </c:if> 
            </div>

            <div class="col-8">
                <c:choose>
                    <c:when test="${!publicclient}">
                        <h4 class="text-center my-auto text-white">New CLIENT</h4>
                    </c:when>
                    <c:otherwise>
                        <h4 class="text-center my-auto text-white">Client Information</h4>
                    </c:otherwise>
                </c:choose>  



            </div>

            <div class="col col-1">

            </div>

        </div>

    </nav>

    <c:if test="${!publicclient}">
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
    </c:if> 


</head>


<body>
    <br>
    <div class="container-fluid">
        <div class="row">

            <div class="col-lg">

                <form:form action="/clients/new-${event.id}-${publicclient}" method="POST" modelAttribute="client">
                    <form:input type="hidden" path="id" id="id"/>
                    <form:input type="hidden" path="userID" id="userID" value="${5}"/>
                    <form:input type="hidden" path="artistID" id="artistID" value="${event.artistID}"/>
                    <fieldset>    

                        <!--NAME-->
                        <!--NAME-->
                        <!-- NAME-->
                        <div class="form-group">
                            <label for="exampleInputEmail1">Client Name</label>
                            <form:input path="name" id="name" class="form-control" placeholder="Client name"/>
                            <form:errors path="name" cssClass="error"/>
                        </div>  

                        <hr>

                        <h4>Adress</h4>

                        <!--STRAAT-->
                        <div class="form-group">
                            <label for="exampleInputEmail1">Street</label>
                            <form:input path="street" id="street" class="form-control" placeholder="Street"/>
                            <form:errors path="street" cssClass="error"/>
                        </div>  

                        <!--NR en BUS-->
                        <div class="form-group">
                            <label for="exampleInputEmail1">NR / BUS</label>
                            <form:input path="nrBus" id="nrBus" class="form-control" placeholder="NR / BUS"/>
                            <form:errors path="nrBus" cssClass="error"/>
                        </div>  

                        <!--POSTCODE-->
                        <div class="form-group">
                            <label for="exampleInputEmail1">CODE</label>
                            <form:input path="postCode" id="postCode" class="form-control" placeholder="CODE"/>
                            <form:errors path="postCode" cssClass="error"/>
                        </div>  

                        <!--GEMEENTE-->
                        <div class="form-group">
                            <label for="exampleInputEmail1">CITY</label>
                            <form:input path="city" id="city" class="form-control" placeholder="City"/>
                            <form:errors path="city" cssClass="error"/>
                        </div>  

                        <!--LAND-->
                        <div class="form-group">
                            <label for="exampleInputEmail1">COUNTRY</label>
                            <form:input path="country" id="country" class="form-control" placeholder="country"/>
                            <form:errors path="country" cssClass="error"/>
                        </div>  

                        <!--BTW NUMMER-->
                        <div class="form-group">
                            <label for="exampleInputEmail1">VAT (optional)</label>
                            <form:input path="vat" id="vat" class="form-control" placeholder="VAT Number"/>
                            <form:errors path="vat" cssClass="error"/>
                        </div> 

                        <hr>

                        <!--TELEFOON-->
                        <div class="form-group">
                            <label for="exampleInputEmail1">PHONE</label>
                            <form:input path="phone" id="phone" class="form-control" placeholder="phone"/>
                            <form:errors path="phone" cssClass="error"/>
                        </div>  

                        <hr>

                        <!--E-MAIL-->
                        <div class="form-group">
                            <label for="exampleInputEmail1">E-Mail</label>
                            <form:input path="email" id="email" class="form-control" placeholder="email"/>
                            <form:errors path="email" cssClass="error"/>
                        </div>  

                        <hr>

                        <!-- Check -->
                        <!-- Check -->
                        <!-- Check -->
                        <c:if test="${!publicclient}">
                                        <div class="d-block">
                            <form:checkbox class="checkbox" path="ack" id="ack" />
                            
                        </div>
                        </c:if> 

                        <!-- SUBMIT BUTTON -->
                        <!-- SUBMIT BUTTON -->
                        <!-- SUBMIT BUTTON -->
                        <c:choose>
                            <c:when test="${!publicclient}">


                                <c:choose>
                                    <c:when test="${edit}">
                                        <button type="submit" class="btn btn-primary btn-block">Update Client</button>

                                    </c:when>
                                    <c:otherwise>
                                        <button type="submit" class="btn btn-primary btn-block">Add Client</button>

                                    </c:otherwise>
                                </c:choose>   


                            </c:when>
                            <c:otherwise>
                                <button type="submit" class="btn btn-primary btn-block">Send</button>
                            </c:otherwise>
                        </c:choose>  



                    </fieldset>
                </form:form>

            </div>
        </div>
</body>
</html>