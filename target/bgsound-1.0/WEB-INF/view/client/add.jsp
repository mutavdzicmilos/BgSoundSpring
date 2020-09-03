<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>


<html>  <link rel="icon" 
      type="image/png" 
     href="<c:url value="/images/"/>logo.png">
    <title>Add client</title>
    <style>
        body{
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
    <title>Add Client</title>
    <link rel="stylesheet"
          href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">

    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.0/jquery.min.js"></script>

    <script	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
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
 <div class="container center_div">

        <c:if test="${not empty message}">
            <div class="alert alert-info" role="alert mb-2">${message}</div>
        </c:if>

            <form:form action="${pageContext.request.contextPath}/client/save" method="post" modelAttribute="clientObject">

                <h4>Client name:</h4>
                <div><form:input type="text" id="name" path="name"/></div>
                <div class="text-danger">
                    <form:errors path="name" cssClass="error" />
                </div>

                <h4> Client surname:</h4>
                <div><form:input type="text" id="surname" path="surname" /></div>
                <div class="text-danger">
                    <form:errors path="surname" cssClass="error" />
                </div><h4>Client JMBG:</h4>
                <div><form:input type="text" id="JMBG" path="JMBG"/></div>
                <div class="text-danger">
                    <form:errors path="JMBG" cssClass="error" />
                </div>

                <h4> Client phone:</h4>
                <div><form:input type="text" id="phone" path="phone" /></div>
                <div class="text-danger">
                    <form:errors path="phone" cssClass="error" />
                </div>
                <p/>
                <div><button id="save" class=" btn btn-primary">Save</button> </div>
                <p/>
            </form:form>

    </div>
  
</body>
</html>