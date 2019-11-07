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
        <h2>Auto Manager  | <a href="<c:url value="/logout" />">Log out!</a></h2>
        <hr />

        <input type="button" value="Add Auto"
               onclick="window.location.href='showForm?driverId=123'; return false;"
               class="btn btn-primary" />
               &nbsp;
        <input type="button" value="List Drivers"
               onclick="window.location.href='<c:url value="/driver/list"/>'; return false;"
               class="btn btn-primary" />
               
        <br/><br/>
        <div class="panel panel-info">
            <div class="panel-heading">
                <div class="panel-title">Auto List</div>
            </div>            
            <div class="panel-body">
                <table class="table table-striped table-bordered">
                    <tr>
                        <th>statenumber</th>
                        <th>uin</th>
                        <th>parkname</th>
                        <th>action</th>
						<th>drivers</th>
						<th>routes</th>
                    </tr>

                    <!-- loop over and print our autos -->
                    <c:forEach var="tempAuto" items="${autos}">

                        <!-- construct an "update" link with auto id -->
                        <c:url var="updateLink" value="/auto/updateForm">
                            <c:param name="autoId" value="${tempAuto.id}" />
                        </c:url>

                        <!-- construct an "delete" link with auto id -->
                        <c:url var="deleteLink" value="/auto/delete">
                            <c:param name="autoId" value="${tempAuto.id}" />
                        </c:url>

                        <c:url var="addDriverLink" value="/auto/addDriver">
                            <c:param name="autoId" value="${tempAuto.id}" />
                        </c:url>
                        
                        <c:url var="driverDetails" value="/driver/listDrivers">
                            <c:param name="autoId" value="${tempAuto.id}" />
                        </c:url>
                        
                        <c:url var="addRouteLink" value="/route/showForm">
                            <c:param name="autoId" value="${tempAuto.id}" />
                        </c:url>

                        <tr>
                            <td>${tempAuto.statenumber}</td>
                            <td>${tempAuto.uin}</td>
                            <td>${tempAuto.parkname}</td>

                            <td>
                                <!-- display the update link --> <a href="${updateLink}">Update</a>
                                | <a href="${deleteLink}"
                                     onclick="if (!(confirm('Are you sure you want to delete this auto?'))) return false">Delete</a>
                                | <a href="${addDriverLink}">AddDriversToThisAuto</a>
                                | <a href="${addRouteLink}">AddRoute</a>
                                | <a href="${driverDetails}">List Drivers</a>

                            </td>
							
							<td>
								<c:forEach var="tempDriver" items="${tempAuto.drivers}">
								 <div>
								 	<a href="<c:url value="/driver/details?driverId=${tempDriver.id}" />">
								 		${tempDriver.fullName}</div>
								 	</a>
								</c:forEach>
							</td>
							
							<td>
								<c:forEach var="route" items="${tempAuto.routes}">
								 <div>								 	
								 		${route.number} &nbsp;
								 		<a href="<c:url value="/route/showEditForm?routeId=${route.id}"/>">Update Route</a>&nbsp;
								 		<a href="<c:url value="/route/delete?routeId=${route.id}"/>">Delete Route</a>
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