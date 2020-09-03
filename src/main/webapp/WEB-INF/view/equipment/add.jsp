<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>

<link rel="stylesheet"
      href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.0/jquery.min.js"></script>

<script	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<html>  <link rel="icon" 
              type="image/png" 
              href="<c:url value="/images/"/>logo.png">
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
        .center_div{
            margin: 0 auto;
            width:80% /* value of your choice which suits your alignment */
        }
    </style>
    <title>Add equipment</title>
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
    </nav></head><body>
    <div>

        <c:if test="${not empty message}">
            <div class="alert alert-info" role="alert mb-2">${message}</div>
        </c:if>

        <div class="container center_div">
            <form:form action="${pageContext.request.contextPath}/equipment/save" enctype="multipart/form-data" method="post" modelAttribute="equipmentObject">

                <h4>Equipment name</h4>
                <div><form:input type="text" id="name" path="name"/></div>
                <div class="text-danger">
                    <form:errors path="name" cssClass="error" />
                </div>

                <h4> Equipment connection</h4>
                <div><form:input type="text" id="connection" path="connection" /></div>
                <div class="text-danger">
                    <form:errors path="connection" cssClass="error" />
                </div><h4>Specification</h4>
                <div><form:textarea resize="none" type="text" id="specification" path="specification"/></div>
                <div class="text-danger">
                    <form:errors path="specification" cssClass="error" />
                </div>
                <h4>Number of copies</h4>
                <div><input type="number" id="copies" name="copiesNo" value="0"/></div>


                <h4>Type</h4>
                <form:select path="type.equipmentTypeID">
                    <c:forEach
                        items="${types}"
                        var="p"
                        varStatus="loop">

                        <form:option value="${p.equipmentTypeID}">${p.type}</form:option>

                    </c:forEach>

                </form:select>

                <h4>Producer</h4>
                <form:select path="producer.producerid">
                    <c:forEach
                        items="${producers}"
                        var="p"
                        varStatus="loop">

                        <form:option value="${p.producerid}">${p.name}</form:option>

                    </c:forEach>

                </form:select>


                <h4>Picture</h4>
                <input type="file" name="imageFile" accept="image/x-png,image/gif,image/jpeg" >
                <hr>
                <div><button id="save" class="btn btn-primary">Save</button> </div>
                <p/>
            </form:form>





        </div>

    </div>




</body></html>
