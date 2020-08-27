<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>

<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<link rel="stylesheet"
      href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">


<script	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<head>
    <title>BgSound Home page</title>
    <style>
        body{
           
            margin-top: 0px;

        }
        .navbar{
            margin-bottom: 0px;
        }

    </style>
<nav class="navbar navbar-inverse">

    <div class="container-fluid">
        <div class="navbar-header">
            <a class="navbar-brand" href="${pageContext.request.contextPath}/">BgSound</a>
        </div>
        <ul class="nav navbar-nav">
            <li class="dropdown">
                <a class="dropdown-toggle" data-toggle="dropdown" href="#">Client
                    <span class="caret"></span></a>
                <ul class="dropdown-menu">
                    <li><a href="${pageContext.request.contextPath}/client/add">Add client</a></li>
                    <li><a href="${pageContext.request.contextPath}/client/all">View clients</a></li>
                </ul>
            </li>
            <li class="dropdown"><a class="dropdown-toggle" data-toggle="dropdown" href="#">Equipment
                    <span class="caret"></span></a>
                <ul class="dropdown-menu">
                    <li><a href="${pageContext.request.contextPath}/equipment/add">Add equipment</a></li>
                    <li><a href="${pageContext.request.contextPath}/equipment/all">View equipment</a></li>
                    <li><a href="${pageContext.request.contextPath}/producer/add">Add producer</a></li>
                </ul></li>
            <li><a href="${pageContext.request.contextPath}/rent/rent">Rent</a></li>
            <li><a href="${pageContext.request.contextPath}/rent/discharge">Discharge Rents</a></li>
        </ul>
        <ul class="nav navbar-nav navbar-right">
            <form:form action="${pageContext.request.contextPath}/logout"  method="POST">
                <input type="submit" class="button" value="Logout" />

            </form:form>


        </ul>
    </div>
</nav></head>

<body>


    <div id="myCarousel" class="carousel slide" data-ride="carousel">
        <!-- Indicators -->
        <ol class="carousel-indicators">
            <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
            <li data-target="#myCarousel" data-slide-to="1"></li>
            <li data-target="#myCarousel" data-slide-to="2"></li>
        </ol>

        <!-- Wrapper for slides -->
        <div class="carousel-inner">
            <div class="item active">
                <img src="<c:url value="/images/"/>slika1.jpg" alt="First slide">
            </div>

            <div class="item">
                <img src="<c:url value="/images/"/>slika2.jpg" alt="Second slide">
            </div>

            <div class="item">
                <img src="<c:url value="/images/"/>slika3.jpg" alt="Third slide">
            </div>
        </div>

        <!-- Left and right controls -->
        <a class="left carousel-control" href="#myCarousel" data-slide="prev">
            <span class="glyphicon glyphicon-chevron-left"></span>
            <span class="sr-only">Previous</span>
        </a>
        <a class="right carousel-control" href="#myCarousel" data-slide="next">
            <span class="glyphicon glyphicon-chevron-right"></span>
            <span class="sr-only">Next</span>
        </a>
    </div>

</body>











