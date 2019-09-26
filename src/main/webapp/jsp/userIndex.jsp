<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
   <head>
      <meta charset="utf-8">
      <meta http-equiv="X-UA-Compatible" content="IE=edge">
      <meta name="viewport" content="width=device-width, initial-scale=1">
      <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
      <title>Booking Form HTML Template</title>
      
      <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
      <link href="https://fonts.googleapis.com/css?family=Poppins:400" rel="stylesheet">
      <!-- Bootstrap -->
      <!--<link type="text/css" rel="stylesheet" href="css/bootstrap.min.css" />-->
      <!-- Custom stlylesheet -->
      <link type="text/css" rel="stylesheet" href="../css/userIndex.css" />
      <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
      <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
      <!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
      <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
      <![endif]-->
   </head>
   <body>
      <div id="booking" class="section">
      <nav class="navbar navbar-inverse">
  <div class="container-fluid">
    <div class="navbar-header">
       <a class="navbar-brand" href="#">LuxiTrip</a>
     <!--<a class="navbar-brand" href="#"><img class="imgg" ></a>-->
    </div>
    <ul class="nav navbar-nav">
      <li class="active"><a href="#">Home</a></li>
      <li class="dropdown"><a class="dropdown-toggle" data-toggle="dropdown" href="#">Page 1 <span class="caret"></span></a>
        <ul class="dropdown-menu">
          <li><a href="#">Page 1-1</a></li>
          <li><a href="#">Page 1-2</a></li>
          <li><a href="#">Page 1-3</a></li>
        </ul>
      </li>
     <li class="dropdown"><a class="dropdown-toggle" data-toggle="dropdown" href="#">Page 2 <span              class="caret"></span></a>
        <ul class="dropdown-menu">
          <li><a href="#">Page 1-1</a></li>
          <li><a href="#">Page 1-2</a></li>
          <li><a href="#">Page 1-3</a></li>
        </ul>
      </li>
    </ul>
    <ul class="nav navbar-nav navbar-right">
     <li><a href="#" onClick="openForm()"><span class="glyphicon glyphicon-user"></span> profile</a></li>
     <li><a href="logout"><span class="glyphicon glyphicon-log-out"></span> Logout</a></li>
    </ul>
  </div>
<div class="form-popup" id="myForm">
  <form:form action="updateUser" class="form-container" modelAttribute="user">
    <label><b>User Id</b></label>
    <form:input type="text" value="${user.id}" path="id" readonly="true"/>
    <label><b>Name</b></label>
    <form:input type="text" value="${user.name}" path="name" />

    <label><b>Mobile Number</b></label>
    <form:input type="tel" value="${user.number}" path="number"/>
    <label><b>Email</b></label>
    <form:input type="email" value="${user.emailId}" path="emailId" /> 
    
    <button type="submit" class="btn">Edit</button>
    <button type="button" class="btn cancel" onclick="closeForm()">Close</button>
  </form:form>
</div>

<script>

function openForm() {
  document.getElementById("myForm").style.display = document.getElementById("myForm").style.display === 'block' ? 'none' : 'block';
}

function closeForm() {
  document.getElementById("myForm").style.display = "none";
}
</script>
      
</nav>
         <div class="section-center">
            <div class="container">
               <div class="row">
                  <div class="booking-form">
                     <form>
                        <div class="row no-margin">
                           <div class="col-md-3">
                              <div class="form-group">
                                 <span class="form-label">Source</span>
                                 <input class="form-control" type="text" placeholder="From:">
                              </div>
                           </div>
                           <div class="row no-margin">
                           <div class="col-md-3">
                              <div class="form-group">
                                 <span class="form-label">Destination</span>
                                 <input class="form-control" type="text" placeholder="To:">
                              </div>
                           </div>
                           <div class="col-md-6">
                              <div class="row no-margin">
                                 <div class="col-md-5">
                                    <div class="form-group">
                                       <span class="form-label">ONWARD DATE</span>
                                       <input class="form-control" type="date" required>
                                    </div>
                                 </div>
                                 <div class="col-md-5">
                                    <div class="form-group">
                                       <span class="form-label">RETURN DATE</span>
                                       <input class="form-control" type="date" required>
                                    </div>
                                 </div>
                                 <div class="col-md-2">
                                     <div class="form-btn">
                                 <button class="submit-btn">Check availability</button>
                              </div>
                                 </div>
                              </div>
                           </div>
                        </div>
                     </form>
                  </div>
               </div>
            </div>
         </div>
      </div>
   </body>
</html>
