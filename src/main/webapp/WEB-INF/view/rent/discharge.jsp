<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>

<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<link rel="stylesheet"
      href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.0/jquery.min.js"></script>

<script	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/v/bs/dt-1.10.21/datatables.min.css"/>

<script type="text/javascript" src="https://cdn.datatables.net/v/bs/dt-1.10.21/datatables.min.js"></script>

<html>  <link rel="icon" 
              type="image/png" 
              href="<c:url value="/images/"/>logo.png">
    <title>Discharge rents</title>
    <style>
        body{
            margin-top: 0px;
            background-image: url("<c:url value="/images/"/>bck.jpg");

            /* Full height */
            height: 100%;

            /* Center and scale the image nicely */
            background-position: center;
            background-repeat: no-repeat;
            background-size: cover;
            margin-top: 0px;
        }
        .navbar{
            margin-bottom: 0px;
        }

    </style>
    <script type="text/javascript">
        $(document).ready(function () {
            $('#tabela').DataTable({
                "paging": true // false to disable pagination (or any other option)
            });
            $('.dataTables_length').addClass('bs-select');
        });

    </script>
    <head><nav class="navbar navbar-inverse">

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
                <form:form action="${pageContext.request.contextPath}/logout" 
                           method="POST">
                    <input type="submit" class="button " value="Logout" />

                </form:form>


            </ul>
        </div>
    </nav></head>
<body>
    <div>


        <form>
            <c:if test="${not empty message}">
                <div class="alert alert-info" role="alert mb-2">${message}</div>
            </c:if>

            <div class="container-fluid">
                <table class="table table-striped table-bordered table-sm" cellspacing="0" width="100%" id="tabela">
                    <thead>
                        <tr>
                            <th scope="col">Rent ID</th>
                            <th scope="col">Client name</th>
                            <th scope="col">Client surname</th>
                            <th scope="col">Date from:</th>
                            <th scope="col">Date to:</th>
                            <th scope="col">Discharge</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach
                            items="${rentsAll}"
                            var="rent"
                            varStatus="loop">
                            <tr>
                                <td>${rent.rentID}</td>
                                <td>${rent.client.name}</td>
                                <td>${rent.client.surname}</td>
                                <td>${rent.dateFrom}</td>
                                <td>${rent.dateTo}</td>
                                <td>
                                    <div class="dropdown">
                                        <a class="btn btn-danger" href="<c:url value = "/rent/${rent.rentID}/delete/">

                                            </c:url>">Discharge</a>

                                    </div>
                                </td>

                            </tr>
                        </c:forEach>


                    </tbody>
                </table>
            </div>
        </form>
    </div></body></html>