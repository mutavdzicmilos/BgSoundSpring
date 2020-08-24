<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
        <title>Clients Home</title>
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
                        </ul></li>
                    <li><a href="${pageContext.request.contextPath}/rent/rent">Rent</a></li>
                    <li><a href="${pageContext.request.contextPath}/rent/discharge">Discharge</a></li>
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
    <form>
        <div class="jumbotron jumbotron-fluid mb-3 text-center">
            <div class="container">
                <h1 class="display-4"> This is home page for client!</h1>
            </div>
        </div>
        <p>
		User: <security:authentication property="principal.username" />
		<br><br>
		Role(s): <security:authentication property="principal.authorities" />
	</p>
	
    </form>
</div></body></html>