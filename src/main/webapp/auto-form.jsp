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
                <div class="panel-title">Add Auto</div>
            </div>
            <div class="panel-body">
                <form:form action="saveAuto" cssClass="form-horizontal"
                           method="post" modelAttribute="auto">

                    <!-- need to associate this data with auto id -->
                    <form:hidden path="id" />
                    <input type="hidden" name="driverId" value="<%=request.getParameter("driverId")%>"/>

                    <div class="form-group">
                        <label for="statenumber" class="col-md-3 control-label">statenumber</label>
                        <div class="col-md-9">
                            <form:input path="statenumber" cssClass="form-control" />
                             <form:errors path="statenumber" cssClass="error" />
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="uin" class="col-md-3 control-label">uin</label>
                        <div class="col-md-9">
                            <form:input path="uin" cssClass="form-control" />
                            <form:errors path="uin" cssClass="error" />
                        </div>
                    </div>

                    <div class="form-group">
                        <label for="parkname" class="col-md-3 control-label">parkname</label>
                        <div class="col-md-9">
                            <form:input path="parkname" cssClass="form-control" />
                            <form:errors path="parkname" cssClass="error" />
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