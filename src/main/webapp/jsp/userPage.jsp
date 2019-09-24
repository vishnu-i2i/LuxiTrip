<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
  <head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" type="text/css" href="/css/displayall.css" >
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
  </head>
  <body>
    <div>
      <c:forEach var="user" items="${users}">
        <div class="divbox">
          <fieldset class="divfieldset">
            <legend class="divfieldsetlegend">
              <i class="fa fa-user-circle-o"></i>
            </legend>
            <center>
              <table cellpadding="5px" >
                <tr>
                  <td>Id</td>
                  <td>
                    <c:out value="${user.id}" />
                  </td>
                <tr>
                <tr>
                  <td>Name</td>
                  <td>
                    <c:out value="${user.name}" />
                  </td>
                </tr>
                <tr>
                  <td>Number</td>
                  <td><c:out value="${user.number}" /></td>
                </tr>
              <center>
            <table cellpadding="3px">
              <br>
           <tr>
            <td>
              <form action="removeUser" method="post">
                <input type="hidden" name="userId" value= "${user.id}" />
                <button type="submit"target="_self" class="button removebuttonbackground" >
                  <i class="fa fa-trash" aria-hidden="true"></i>
                </button>              
              </form>
          </td>
          <td>
              <form action="displayUserToUpdate" method="post">
                <input type="hidden" name="userId" value= "${user.id}" />
                <button type="submit"target="_self" class="button editbuttonbackground" >
                  <i class="fa fa-pencil-square-o"></i></button>            
              </form>
          </td>
          <td>
              <form action="displayUser" method="post">
                <input type="hidden" name="userId" value= "${user.id}" />
                <button type="submit" target="_self" class="button viewbuttonBackground">
                  <i class="fa fa-eye"></i></button>            
             </form>
           </td>
           </tr>
           </table>
           </center>
           </table>
        </fieldset>
        </div>
      </c:forEach>
    </div>
  </body>
</html>