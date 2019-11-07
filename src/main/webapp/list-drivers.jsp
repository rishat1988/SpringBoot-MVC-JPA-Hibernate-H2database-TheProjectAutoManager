<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>net</title>
    <link href="/resources/css/bootstrap.min.css"
          rel="stylesheet">
    <%@ page isELIgnored="false"%>
    <script src="/resources/js/jquery-1.11.1.min.js"></script>
    <script src="/resources/js/bootstrap.min.js"></script>
</head>
<body>
<div class="container">
    <div class="col-md-offset-1 col-md-10">
        <h2>Driver Manager  | <a href="<c:url value="/logout" />">Log out!</a></h2>
        <hr />

        <input type="button" value="Add Driver"
               onclick="window.location.href='showForm'; return false;"
               class="btn btn-primary" />
        <br/><br/>
        <div class="panel panel-info">
            <div class="panel-heading">
                <div class="panel-title">Driver List </div><a href="<c:url value="/driver/goToAutoList" />">go to AutoList</a>
            </div>
            <div class="panel-body">
                <table class="table table-striped table-bordered">
                    <tr>
                        <th>fullName</th>
                        <th>numberOfTelefon</th>
                        <th>numberOfDrivingLicense</th>
                        <th> age</th>
                        <th>action</th>
                        <th>autos</th>
                    </tr>

                    <!-- loop over and print our autos -->
                    <c:forEach var="tempDriver" items="${drivers}">

                        <!-- construct an "update" link with auto id -->
                        <c:url var="updateLink" value="/driver/updateForm">
                            <c:param name="driverId" value="${tempDriver.id}" />
                        </c:url>

                        <!-- construct an "delete" link with auto id -->
                        <c:url var="deleteLink" value="/driver/delete">
                            <c:param name="driverId" value="${tempDriver.id}" />
                        </c:url>

                        <tr>
                            <td>${tempDriver.fullName}</td>
                            <td>${tempDriver.numberOfTelefon}</td>
                            <td>${tempDriver.numberOfDrivingLicense}</td>
                            <td>${tempDriver.age}</td>

                            <td>
                                <!-- display the update link --> <a href="${updateLink}">Update</a>
                                | <a href="${deleteLink}"
                                     onclick="if (!(confirm('Are you sure you want to delete this auto?'))) return false">Delete</a>
                            </td>
                            
                            <td>
                            	<div>
                            		<c:url var="addDriver" value="/auto/showForm">
                            			<c:param name="driverId" value="${tempDriver.id}" />
                        			</c:url>
                        			<c:url var="listAutos" value="/auto/listAutos">
                            			<c:param name="driverId" value="${tempDriver.id}" />
                        			</c:url>
                            		<a href="${addDriver}">Add auto</a>&nbsp;&nbsp;
                            		<a href="${listAutos}">List autos</a>
                            	</div>
                            		<c:forEach items="${tempDriver.autos}" var="auto">
                            	<div>
									${auto.statenumber}                            		
                            	</div>
                            		</c:forEach>
                            </td>

                        </tr>

                    </c:forEach>

                </table>

            </div>
        </div>
    </div>

</div>
</body>
</html>