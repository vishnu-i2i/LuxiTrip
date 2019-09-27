<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html >
  <head>
    <script>
              function openForm() {
                document.getElementById("myForm").style.display = document.getElementById("myForm").style.display === 'block' ? 'none' : 'block';
              }
              
              function closeForm() {
                document.getElementById("myForm").style.display = "none";
              }
    </script>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-alpha.5/js/bootstrap.min.js" integrity="sha384-BLiI7JTZm+JWlgKa0M0kGRpJbF2J8q+qreVrKBC47e3K6BW78kGLrCkeRX6I9RoK" crossorigin="anonymous"></script>
    <script src="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/js/bootstrap.min.js"></script>
    <script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
    <link href="https://fonts.googleapis.com/css?family=Poppins:400" rel="stylesheet">
    <link type="text/css" rel="stylesheet" href="../css/admin.css" />
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    <meta charset="UTF-8">
    <title>Admin Page</title>
  </head>
  <body>
    <div id="booking" class="section">
      <nav class="navbar navbar-inverse">
      <div class="container-fluid">
        <div class="navbar-header">
          <a class="navbar-brand" href="#">LuxiTrip</a>
        </div>
        <ul class="nav navbar-nav">
          <li class="dropdown">
            <a class="dropdown-toggle" data-toggle="dropdown" href="#">Bus Management <span class="caret"></span></a>
            <ul class="dropdown-menu">
              <li><a data-toggle="modal" data-target="#addBusModal" class="title m-b-md">New Bus</a></li>
            </ul>
          </li>
          <li class="dropdown">
            <a class="dropdown-toggle" data-toggle="dropdown" href="#">User Management <span class="caret"></span></a>
            <ul class="dropdown-menu">
              <li><a data-toggle="modal" data-target="#addUserModal" class="title m-b-md">New Driver</a></li>
              <li><a href="displayUsers">View</a></li>
            </ul>
          </li>
        </ul>
        <ul class="nav navbar-nav navbar-right">
          <li><a href="#" onClick="openForm()"><span class="glyphicon glyphicon-user"></span> profile</a></li>
          <li><a href="logout"><span class="glyphicon glyphicon-log-out"></span> Logout</a></li>
        </ul>
      </div>
    </div>
    
    <div class="modal fade" id="addBusModal" tabindex="-1" role="dialog" aria-labelledby="modalLabel" aria-hidden="true">
    <div class="modal-dialog">
    <div class="modal-content">
    <div class="modal-header">
    <h1 class="modal-title">Add New Bus</h1>
    </div>
    <div class="modal-body">
    <!-- content goes here -->
    <form method="post" action="registerBus">
    <div class="form-group">
    <label for="exampleInputEmail1">Bus Number</label>
    <input type="text" class="form-control" id="exampleInputEmail1" name="busNumber" pattern = "^[A-Z]{2} [0-9]{2} [A-Z] [0-9]{4}$"/>
    </div>
    <div class="form-group">
    <label for="exampleInputPassword1">Capacity</label>
    <input type="text" class="form-control" id="exampleInputPassword1" name="capacity"/>
    </div>
    <div class="form-group">
    <label for="exampleInputFile">Operator</label>
    <input type="text" class="form-control" id="exampleInputFile" name="operator"/>
    </div>
    <div class="form-group">
    <label for="exampleInputEmail1">Type</label>
    <input type="text" class="form-control" id="exampleInputEmail1" name="type"/>
    </div>
    <div class="modal-footer">
    <div class="btn-group btn-group-justified" role="group" aria-label="group button">
    <div class="btn-group" role="group">
    <button type="submit" class="btn btn-default">Add</button>
    </div>
    </div>
    </div>          
    </form>
    </div>
    </div>
    </div>
    </div>
    </div>
    
    <!-- line modal -->
    <div class="modal fade" id="displayBusModal" tabindex="-1" role="dialog" aria-labelledby="modalLabel" aria-hidden="true">
    <div class="modal-dialog">
    <div class="modal-content">
    <div class="modal-header">
    <button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">×</span><span class="sr-only">Close</span></button>
    <h3 class="modal-title" id="lineModalLabel"></h3>
    </div>
    <div class="modal-body">
    <!-- content goes here -->
    <form action="updateBus" method="post">
    <div class="form-group">
    <label for="exampleInputEmail1">Bus Number</label>
    <input type="text" class="form-control" id="exampleInputEmail1" value="${bus.busNumber}">
    </div>
    <div class="form-group">
    <label for="exampleInputPassword1">Capacity</label>
    <input type="text" class="form-control" id="exampleInputPassword1" value="${bus.capacity}">
    </div>
    <div class="form-group">
    <label for="exampleInputFile">Operator</label>
    <input type="text" class="form-control" id="exampleInputFile" value="${bus.operator}">
    </div>
    <div class="form-group">
    <label for="exampleInputEmail1">Type</label>
    <input type="text" class="form-control" id="exampleInputEmail1" value="${bus.type}">
    </div>
    <div class="modal-footer">
    <div class="btn-group btn-group-justified" role="group" aria-label="group button">
    <div class="btn-group" role="group">
    <button type="submit" class="btn btn-default">Submit</button>
    </div>
    </div>
    </div>          
    </form>
    </div>
    </div>
    </div>
    </div>
    
    <div class="modal fade" id="addUserModal" tabindex="-1" role="dialog" aria-labelledby="modalLabel" aria-hidden="true">
    <div class="modal-dialog">
    <div class="modal-content">
    <div class="modal-header">
    <h1 class="modal-title">Add New Driver</h1>
    </div>
    <div class="modal-body">
    <!-- content goes here -->
    <form action="registerUser" method="post">
    <div class="form-group">
    <label for="exampleInputEmail1">Name</label>
    <input type="text" class="form-control" id="exampleInputEmail1" name="name"/>
    </div>
    <div class="form-group">
    <label for="exampleInputPassword1">Mobile</label>
    <input type="text" class="form-control" id="exampleInputPassword1" name="number"  pattern = "^[7-9][0-9]{9}$"/>
    </div>
    <div class="form-group">
    <label for="exampleInputFile">Email</label>
    <input type="email" class="form-control" id="exampleInputFile" required="false" name="emailId"/>
    </div>
    <input type="hidden" value="Driver" name="password"/>
    <input type="hidden" value="Driver" name="role"/>
    <div class="modal-footer">
    <div class="btn-group btn-group-justified" role="group" aria-label="group button">
    <div class="btn-group" role="group">
    <button type="submit" class="btn btn-default">Add</button>
    </div>
    </div>
    </div>          
    </form>
    </div>
    </div>
    </div>
    </div>
    </div>
    
    <div class="display-margin">
    <c:forEach var="bus" items="${buses}">
      <div class="divbox">
        <fieldset class="divfieldset">
          <legend class="divfieldsetlegend">
            <i class="fa fa-bus"></i>
          </legend>
          <table cellpadding="5px" class="allemployee">
            <tr>
              <td>Bus No :</td>
              <td>
                <c:out value="${bus.busNumber}" />
              </td>
            <tr>
            <tr>
              <td>Capcity :</td>
              <td>
                <c:out value="${bus.capacity}" />
              </td>
            </tr>
            <tr>
              <td>Operator :</td>
              <td>
                <c:out value="${bus.operator}" />
              </td>
            </tr>
            <tr>
              <td>Bus type :</td>
              <td>
                <c:out value="${bus.type}" />
              </td>
            </tr>
          </table>
          <center>
         
          
            
        </fieldset>
      </div>  
    </c:forEach>
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
    <form:input type="hidden" value="${user.role}" path="role"/>
    <button type="submit" class="btn">Edit</button>
    <button type="button" class="btn cancel" onclick="closeForm()">Close</button>
  </form:form>
</div>
  </body>
</html>
