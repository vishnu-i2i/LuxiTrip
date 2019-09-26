<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<title> User Form </title>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
 <link rel="stylesheet" type="text/css" href="/css/bottom.css">
 <link rel="stylesheet" type="text/css" href="/css/userForm.css">
<style>

</style>
</head>
<body>
<form method="post" action="createFare">
<label>SOURCE </label>
<input type="text" name="source"/>
<label>DEST</label>
<input type="text" name="dest"/>
<label>Price</label>
<input type="text" name="price"/>
<input type="submit" value="register"/>
</form>
</body>
</html>
