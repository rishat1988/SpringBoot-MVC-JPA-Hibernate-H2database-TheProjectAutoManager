<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form"   uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Spring </title>
    <link href="/resources/css/bootstrap.min.css"
          rel="stylesheet">
    <script src="/resources/js/jquery-1.11.1.min.js"></script>
    <script src=/resources/js/bootstrap.min.js"></script>

</head>
<body>
<div class="container">
    <div class="col-md-offset-2 col-md-7">
        <h2 class="text-center">
            fill it!  | <a href="<c:url value="/logout" />">Log out!</a></h2>
        <div class="panel panel-info">
            <div class="panel-heading">
                <div class="panel-title">Add Auto</div>
            </div>
            <div class="panel-body">
                <form:form action="saveDriver" cssClass="form-horizontal"
                           method="post" modelAttribute="driver">

                    <!-- need to associate this data with auto id -->
                    <form:hidden path="id" />
					<input type="hidden" name="autoId" value="<%=request.getParameter("autoId")%>"/>

                    <div class="form-group">
                        <label for="fullName" class="col-md-3 control-label">fullname</label>
                        <div class="col-md-9">
                            <form:input path="fullName" cssClass="form-control" />
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="numberOfTelefon" class="col-md-3 control-label">numberOfTelefon</label>
                        <div class="col-md-9">
                            <form:input path="numberOfTelefon" cssClass="form-control" />
                        </div>
                    </div>

                    <div class="form-group">
                        <label for="numberOfDrivingLicense" class="col-md-3 control-label">numberOfDrivingLicense</label>
                        <div class="col-md-9">
                            <form:input path="numberOfDrivingLicense" cssClass="form-control" />
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="age" class="col-md-3 control-label">age</label>
                        <div class="col-md-9">
                            <form:input path="age" cssClass="form-control" />
                        </div>
                    </div>

                    <div class="form-group">
                        <!-- Button -->
                        <div class="col-md-offset-3 col-md-9">
                            <form:button cssClass="btn btn-primary">Submit</form:button>
                        </div>
                    </div>

                </form:form>
            </div>
        </div>
    </div>
</div>
</body>
</html>