<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>

<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<link rel="stylesheet"
      href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.0/jquery.min.js"></script>

<script	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script><script type="text/javascript" src="https://cdn.datatables.net/v/bs/dt-1.10.21/datatables.min.js"></script>

<html>
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
                <c:if test="${not empty message}">
                    <div class="alert alert-info" role="alert mb-2">${message}</div>
                </c:if>

                <div class="container-fluid">
                    <form:form action="${pageContext.request.contextPath}/equipment/${equipment.equipmentID}/saved" method="post" modelAttribute="equipment">

                        <div>Equipment name</div>
            <div><form:input type="text" id="name" path="name"/></div>
            <div class="text-danger">
                <form:errors path="name" cssClass="error" />
            </div>

            <div> Equipment connection</div>
            <div><form:input type="text" id="connection" path="connection" /></div>
            <div class="text-danger">
                <form:errors path="connection" cssClass="error" />
            </div><div>Specification</div>
            <div><form:textarea type="text" id="specification" path="specification"/></div>
            <div class="text-danger">
                <form:errors path="specification" cssClass="error" />
            </div>
            <div>Number of new copies to add</div>
            <div><input type="number" id="copies" name="copiesNo" value="0"/></div>


            <div>Type</div>
             <form:select path="type.equipmentTypeID">
                <div class="container-fluid">
                    <c:forEach
                        items="${types}"
                        var="p"
                        varStatus="loop">

                        <form:option value="${p.equipmentTypeID}">${p.type}</form:option>

                    </c:forEach>

                </form:select>

            <div>Producer</div>
            <form:select path="producer.producerid">
                <div class="container-fluid">
                    <c:forEach
                        items="${producers}"
                        var="p"
                        varStatus="loop">

                        <form:option value="${p.producerid}">${p.name}</form:option>

                    </c:forEach>

                </form:select>


              
                <hr>
                <div><button id="save" class="btn btn-primary">Save</button> </div>
                <p/>
                    </form:form>
                </div>

            </div>

            <div class="col-sm-7 text-left"> 
                <h2>Copies</h2>
                <table id="tabela" class="table table-striped table-bordered table-sm" cellspacing="0" width="100%">
                    <thead>
                        <tr>
                            <th scope="col">ID</th>
                            <th scope="col">Defect</th>
                            <th scope="col">Working</th>
                            <th scope="col">Available</th>
                            <th scope="col">Actions</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach items="${equipment.copies}" var="m" varStatus="loop">
                            <tr>
                                <td>${m.copyID}</td>
                                <td>${m.defect}</td>
                                <td>${m.working}</td>
                                <td>${m.available}</td>
                                <td>
                                    <div class="dropdown">
                                        <a class="btn btn-danger" href="<c:url value = "/copy/${m.copyID}/delete/">

                                            </c:url>">Delete</a>
                                        <a style="text-decoration: none"> / </a>
                                        <a class="btn btn-success" href="<c:url value = "/copy/${m.copyID}/view/">

                                            </c:url>">View</a>
                                    </div>
                                </td>

                            </tr>
                        </c:forEach>


                    </tbody>
                </table>
            </div>


        </div>
    </div>
</div>
</body>












</html>