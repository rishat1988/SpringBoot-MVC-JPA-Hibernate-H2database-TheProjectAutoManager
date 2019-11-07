<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <title>Auto project</title>
    <link href="resources/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
  <div class="jumbotron d-flex align-items-center">
  <div class="container">
    <h2>
    <p>Admin portal  </p>
    <p>Use it</p>
    </h2>
    <div class="col-sm-2" name="join">
      <a href="join" class="btn btn-primary btn-sm">Join us</a>
    </div>
    <div class="col-sm-2" name="sign">
      <a href="sign" class="btn btn-primary btn-sm">Sign</a>
    </div>
   </div>
   </div>
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
  <script src="resources/js/bootstrap.min.js"></script>
</body>
</html>
