<<<<<<< HEAD
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
=======
<!DOCTYPE html>
>>>>>>> feature -
<html >
<head>
<script src="/css/Validation.js">
</script>
<link href="/css/StyleSheet.css" rel="stylesheet" type="text/css">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<meta charset="UTF-8">
<title>Admin Page</title>
</head>
<body>
        <div style="display: in-line; float:right;">
<<<<<<< HEAD
        <img class ="luxitrip"  src="4339.png">
=======
        <img class ="luxitrip"  src="../img/4339.png">
>>>>>>> feature -
        </div>
	<div class="navsidebar navbar-block navdark-grey navanimate-left"
		style="display: in-line; float:right;" id="mySidebar">
		<button class="navbar-itemm navbutton navlarge" onclick="navClose()">&times;</button>
<<<<<<< HEAD
		<form action="createBus" method="GET">
			<button href="#" class="navbar-item navbutton" value="displayAll"
				name="operation">Register Buses</button>
		</form>
		<form action="" method="GET">
=======
		<form action="" method="GET">
			<button href="#" class="navbar-item navbutton" value="displayAll"
				name="operation">Register Buses</button>
		</form>
		<form action="createDriver" method="GET">
>>>>>>> feature -
			<button href="#" class="navbar-item navbutton" value="displayClients"
				name="operation">Register Driver</button>
		</form>
		<form action="" method="post">
			<button href="#" class="navbar-item navbutton"
				value="Display Projects" name="operation">Route Entry</button>
		</form>
<<<<<<< HEAD
		<form action="logOut" method="POST">
=======
        <form action="displayUsers" method="get">
            <button href="#" class="navbar-item navbutton" value="displayUsers"
                  name="displayUsers">Display Users</button>
        </form>
		<form action="logout" method="POST">
>>>>>>> feature -
			<button href="#" class="navbar-item navbutton" value="logout"
				name="operation">Logout</button>
		</form>
	</div>
	<div style="width: 60px;">
		<button class="navbutton navwhite navxxlarge" onclick="navOpen()">&#9776;</button>
	</div>
    <div class="display-margin">
<<<<<<< HEAD
      <c:forEach var="bus" items="${buses}">
=======
      <c:forEach var="employee" items="${employees}">
>>>>>>> feature -
        <div class="divbox">
          <fieldset class="divfieldset">
            <legend class="divfieldsetlegend">
              <i class="fa fa-bus"></i>
            </legend>
            <table cellpadding="5px" class="allemployee">
              <tr>
                <td>Bus No</td>
                <td>
<<<<<<< HEAD
                  <c:out value="${bus.busNumber}" />
=======
                  <c:out value="${employee.id}" />
>>>>>>> feature -
                </td>
              <tr>
              <tr>
                <td>Capcity</td>
                <td>
<<<<<<< HEAD
                  <c:out value="${bus.capacity}" />
=======
                  <c:out value="${employee.name}" />
>>>>>>> feature -
                </td>
              </tr>
              <tr>
              <td>Operator</td>
              <td>
<<<<<<< HEAD
                <c:out value="${bus.operator}" />
=======
                <c:out value="${employee.designation}" />
>>>>>>> feature -
              </td>
              </tr>
              <tr>
                <td>Bus type</td>
                <td>
<<<<<<< HEAD
                  <c:out value="${bus.type}" />
                </td>
              </tr>
            </table>
              <center>
               <form action="displayAllBuses" method="get" style="display: inline-block;">
                <td> <input type="hidden" name="id" value= "${bus.id}" /></td>
                <button type="submit" value="delete" target="_self" class="button remove" >
                  <i class="fa fa-trash" aria-hidden="true"></i>
                </form>
                </button>
                <form action="displayAllBuses" method="get" style="display: inline-block;">
                <td> <input type="hidden" name="id" value= "${bus.id}" /></td>
                <button type="submit" value ="search" target="_self" class="button update" >
                  <i class="fa fa-pencil-square-o"></i></button>
                  </form>
                </button>
                <form action="displayAllBuses" method="get" style="display: inline-block;">
                <td> <input type="hidden" name="id" value= "${bus.id}" /></td>
                <button type="submit" value="display" target="_self" class="button display">
                  <i class="fa fa-eye"></i></button>
                 </form>
                </button>
              </center>
=======
                  <c:out value="${employee.mobileNumber}" />
                </td>
              </tr>
            </table>
            <form action="displayEmployees" method="get">
              <center>
                <td> <input type="hidden" name="id" value= "${employee.id}" /></td>
                <button type="submit" value="delete" target="_self" class="button remove" >
                  <i class="fa fa-trash" aria-hidden="true"></i>
                </button>
                <button type="submit" value ="search" target="_self" class="button update" >
                  <i class="fa fa-pencil-square-o"></i></button>
                <button type="submit" value="display" target="_self" class="button display">
                  <i class="fa fa-eye"></i></button>
              </center>
            </form>
>>>>>>> feature -
        </div>
        </fieldset>
      </c:forEach>
    </div>
</body>
</html>
