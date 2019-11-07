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
<style>
            .error {
                color: red
            }
        </style>
</head>
<body>
<div class="container">
    <div class="col-md-offset-2 col-md-7">
        <h2 class="text-center">
            fill it!  | <a href="<c:url value="/logout" />">Log out!</a></h2>
        <div class="panel panel-info">
            <div class="panel-heading">
                <div class="panel-title">Add Route</div>
            </div>
            <div class="panel-body">
                <form:form action="saveRoute" cssClass="form-horizontal"
                           method="post" modelAttribute="route">

                    <!-- need to associate this data with auto id -->
                    <input type="hidden" name="autoId" value="${autoId}" />

                    <div class="form-group">
                        <label for="number" class="col-md-3 control-label">number</label>
                        <div class="col-md-9">
                            <form:input path="number" cssClass="form-control" />
                             <form:errors path="number" cssClass="error" />
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="distance" class="col-md-3 control-label">distance</label>
                        <div class="col-md-9">
                            <form:input path="distance" cssClass="form-control" />
                            <form:errors path="distance" cssClass="error" />
                        </div>
                    </div>

                    <div class="form-group">
                        <label for="district" class="col-md-3 control-label">district</label>
                        <div class="col-md-9">
                            <form:input path="district" cssClass="form-control" />
                            <form:errors path="district" cssClass="error" />
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