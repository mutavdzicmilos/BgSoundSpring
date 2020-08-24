<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>

<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<link rel="stylesheet"
      href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.0/jquery.min.js"></script>

<script	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<script type="text/javascript" src="https://cdn.datatables.net/v/bs/dt-1.10.21/datatables.min.js"></script>

<html>
    <title>Rent equipment</title>
    <script type="text/javascript">
        $(document).ready(function () {
            $('#tabela').DataTable({
                "paging": true // false to disable pagination (or any other option)
            });
            $('.dataTables_length').addClass('bs-select');
        });

    </script><head><nav class="navbar navbar-inverse">

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

    <div class="container-fluid text-center">    
        <div class="row content">
            <div class="col-sm-3 sidenav">

                <form:form action="${pageContext.request.contextPath}/rent/save" method="post" modelAttribute="rentObject">
                    <label>Select client:</label>
                 <form:select path="client.clientID">
                <div class="container-fluid">
                    <c:forEach
                        items="${clients}"
                        var="p"
                        varStatus="loop">

                        <form:option value="${p.clientID}">${p.name} ${p.surname},ID: ${p.clientID}</form:option>

                    </c:forEach>

                </form:select>
                        </hr>
                        <div>Date from:</div>
                        <div><form:input type="date" id="dateFrom" path="dateFrom"/></div>
                    <div class="text-danger">
                        <form:errors path="dateFrom" cssClass="error" />
                    </div>

                    <div>Date to:</div>
                    <div><form:input type="date" id="dateTo" path="dateTo" /></div>
                    <div class="text-danger">
                        <form:errors path="dateTo" cssClass="error" />
                    </div>
                    <div><button id="save" class="btn btn-primary">Save</button> </div>
                    <p/>


                </div>

                <div class="col-sm-7 text-left"> 
                    <h2>Copies</h2>
                    <table id="tabela" class="table table-striped table-bordered table-sm" cellspacing="0" width="100%">
                        <thead>
                            <tr>
                                <th scope="col">Copy ID</th>
                                <th scope="col">Equipment name</th>
                                <th scope="col">Defect</th>
                                <th scope="col">Working</th>
                                <th scope="col">Available</th>
                                <th scope="col">Rent</th>
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach items="${copies}" var="m" varStatus="loop">
                                <tr>
                                    <td>${m.copyID}</td>
                                    <td>${m.equipment.name}</td>
                                    
                                    <td>${m.defect}</td>
                                    <td>${m.working}</td>
                                    <td>${m.available}</td>
                                    <td align="center">  
                                        <form:checkbox path="copies[${rentObject.copies.size()}].copyID"   
                                                       value="${m}.copyID"/>  
                                        
                                    </td>
                                </tr>
                            </c:forEach>


                        </tbody>
                    </table>
                </div>
            </form:form>

        </div>
    </div>
</div>
</body>


</html>