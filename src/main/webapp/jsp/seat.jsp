<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
<meta charset="UTF-8">
<title>seats</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
    href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
<script
    src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script
    src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
<script
    src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
<script src='https://kit.fontawesome.com/a076d05399.js'></script>

<link rel="stylesheet" type="text/css" href="/css/seats.css">
</head>
<body>
<h1>SEATS AVAILABILITY</h1>
<div class="sea col-sm-4 ">
  <c:forEach  var="seat" items="${bus.seats}">

    <li class="seatl"><input  type="hidden" name="seatId" value="${seat.id}" />
                               <input type="checkbox" name="${seat.id}" class="checkbox" /><label><i class="fas fa-chair chair rotate-0"></i></label></li>&nbsp;&nbsp;&nbsp;&nbsp;
                                </c:forEach>
</div>
                                       
</body>
</html>