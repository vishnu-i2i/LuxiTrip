<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<title> Update Theatre Form </title>
 <link rel="stylesheet" type="text/css" href="/css/bottom.css">
 <link rel="stylesheet" type="text/css" href="/css/theatreForm.css">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<style>

</style>
</head>
<body>

<h2>Update  Theatre Form</h2>
<div class="row">
  <div class="col-75">
    <div class="container">
    <form method="post" action="updateTheatre" modelAttribute="theatre">
        <div class="row">
          <div class="col-50">
            <h3>Theatre Details </h3>
            <label><i class="fa fa-user"></i> User Name</label>
           <input type="text"  value="${user.name}" required="true" readonly/>
            <label><i class="fa fa-map"></i> Location</label>
           <input type="text"  value="${user.number}" maxlength="25" placeholder=" Doe" required="true" readonly/>
            <label><i class="fa fa-envelope"></i> Email</label>
            <input type="email" value="${user.emailId}" maxlength="25" placeholder="john@gmail.com" required="true" readonly/> 
            <label><i class="fa fa-edit"></i> Phone Number</label>
           <input type="text" value="${user.id}" pattern="[6-9]{1}[0-9]{9}" maxlength="12"  placeholder="9685741230" required="true" readonly/>
      
        <input type="submit" value="Create" class="btn">
        &nbsp&nbsp&nbsp
        <input type="reset" value="cancel" class="cancelbtn">
      </form>
    </div>
  </div>
<div class="fixed-footer">
        <div class="containers">Copyright &copy; 2019 ideas2it</div>        
</div> 
</body>
</html>


