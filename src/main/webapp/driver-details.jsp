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
	</div>
	 <div class="panel panel-info">
            <div class="panel-heading">
                <div class="panel-title">Driver Details</div>
            </div>
            <div class="panel-body">
                <table class="table table-striped table-bordered">
                    <tr>
                        <th>fullName</th>
                        <th>numberOfTelefon</th>
                        <th>numberOfDrivingLicense</th>
                        <th> age</th>                        
                        <th>auto</th>
                        <th>action</th>
                    </tr>
                     <tr>
                            <td>${driver.fullName}</td>
                            <td>${driver.numberOfTelefon}</td>
                            <td>${driver.numberOfDrivingLicense}</td>
                            <td>${driver.age}</td>
                            <td>
                            	<c:forEach items="${driver.autos}" var="auto">
                            		<div>
                            			${auto.statenumber}
                            		</div>
                            	</c:forEach>                            	
                            </td>
                            <td>
                            	<!-- construct an "update" link with auto id -->
                        <c:url var="updateLink" value="/driver/updateForm">
                            <c:param name="driverId" value="${driver.id}" />
                        </c:url>

                        <!-- construct an "delete" link with auto id -->
                        <c:url var="deleteLink" value="/driver/delete">
                            <c:param name="driverId" value="${driver.id}" />
                        </c:url>
                                                
                                <!-- display the update link --> <a href="${updateLink}">Update</a>
                                | <a href="${deleteLink}"                                     onclick="if (!(confirm('Are you sure you want to delete this auto?'))) return false">Delete</a>                        
					</tr>                            
				</table>
			</div>
		</div>
</div>