<%@ page isELIgnored="false" language="java" contentType="text/html; charset=ISO-8859-1"
 pageEncoding="ISO-8859-1" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<html>
  <head>
    
    <link rel="stylesheet" type="text/css" href="busListForUser.css" >
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
  <script>
      function myFunction() {
      alert("Clicked");
      }
</script>
  </head>
  <body>
  <nav class="navbar navbar-inverse">
  <div class="container-fluid">
    <div class="navbar-header">
       <a class="navbar-brand" href="#">LuxiTrip</a>
     <!--<a class="navbar-brand" href="#"><img class="imgg" ></a>-->
    </div>
    <ul class="nav navbar-nav">
    <li class="active"><a href="#">View Bookings</a></li>
    </ul>
    <ul class="nav navbar-nav navbar-right">
      <li><a href="#"><span class="glyphicon glyphicon-user"></span> Profile</a></li>
      <li><a href="#"><span class="glyphicon glyphicon-log-out"></span> Logout</a></li>
    </ul>
  </div>
</nav>
  <form action = "ticketReservation" method = "post">
    <div>
      <c:forEach var="schedule" items="${schedules}">
        <div class="divbox ">
          <fieldset class="divfieldset">
          <div class="col-sm-4">
            <div class="font">
                <c:out value = "${schedule.bus.operator}"/>
            </div></br>
            
            <div class="font">
                <c:out value = "${schedule.bus.type}"/>
            </div>
          </div>
          
          <div class="col-sm-6">
            <div class="one font">
                <c:out value = "${schedule.departureTime}"/>
            </div>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
          
            <div class="one">hrs</div>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
            <div class="one font">
                <c:out value = "${schedule.arrivalTime}"/>
            </div>
         
         </div>
         <div class="col-sm-2">
            <div class="form-btn">
             <button type="button" class="btn btn-primary" data-toggle="modal" data-target="#myModal">No of Seats</button>
              </div>
         </div>
        </div>
        </fieldset>
     
    <!-- The Modal -->
  <div class="modal" id="myModal">
    <div class="modal-dialog">
      <div class="modal-content">
      
         <!-- Modal Header -->
       <div class="modal-header">
       
         <button type="button" class="close" data-dismiss="modal">&times;</button>
         
       </div>
       
       <!-- Modal body -->
       <div class="modal-body">
          <h4 class="modal-title">Enter the Total No of Seats</h4>
         <input type="number" value = "numberOfSeats" min="1"/>
       </div>
       
       <!-- Modal footer -->
       
       <div class="modal-footer">
         <button type="submit" class="btn btn-primary">Submit</button>
         <button type="button" class="btn btn-danger" data-dismiss="modal">Close</button>
       </div>
        
      </div>
    </div>
  </div>
  <input type = "hidden" name = "schedule" value = "${schedule}">
  </c:forEach>
    </div>
    </form>
  </body>
</html>
