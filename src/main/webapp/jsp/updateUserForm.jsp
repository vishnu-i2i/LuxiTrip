<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<meta name="viewport" content="width=device-width, initial-scale=1">
 <link rel="stylesheet" type="text/css" href="/css/bottom.css">
 <link rel="stylesheet" type="text/css" href="/css/userPage.css">
<style>


</style>
</head>
<body>

<div class="navbar">
<form method="post" action="logout">
    <button style="height:45px;width:100px" type="submit" value="Logout">Logout</button>
</form>

</div>

 <div class="move" align="center">
        <table border="1" cellpadding="5">
            <caption><h2>Profile</h2></caption>
            <tr>
                <th>UserID</th>
                <th>FirstName</th>
                <th>EmailId</th>
                <th>PhoneNumber</th> 
                
                <th>Status</th>
                <th>Action</th>
                <th>Booking</th>
            </tr>
                <tr>
                    <td><c:out value="${user.id}" /></td>
                    <td><c:out value="${user.name}" /></td>
                    <td><c:out value="${user.emailId}" /></td>
                    <td><c:out value="${user.number}" /></td>
                    <td><c:out value="${user.status}" /></td>
                    <td>
                       <form action = "getUser" method = "post">
                       <input type = "hidden" name = "userId" value = '${user.userId}'/>
                       <button class="btn" type = "submit"><i class="fa fa-edit"></i></button>
                       </form>
                       <form action = "deleteUser" method = "post">
                       <input type = "hidden" name = "userId" value = '${user.userId}'/>
                        <button class="btn" type = "submit"><i class="fa fa-trash"></i></button>
                       </form>
                    </td>
                       <td>
                       <form action = "selectMovies" method = "post" modelAttribute="user"> 
                       <input type = "hidden" name = "userId" value = '${user.userId}'/>
                       <button class = "btn" type = "submit"><i class="fa fa-ticket"></i></button>
                       </form>
                       </td>
                </tr>
        </table>
    </div>   
<div class="fixed-footer">
        <div class="containers">Copyright &copy; 2019 ideas2it</div>        
</div> 
</body>
</html>

