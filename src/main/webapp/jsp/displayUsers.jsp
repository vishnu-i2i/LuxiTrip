<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
  <head>
    <link rel="stylesheet" type="text/css" href="../css/displayUsers.css" >
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
            <table cellpadding="5px" class="allemployee">
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
                <td>Phone</td>
                <td>
                  <c:out value="${user.number}" />
                </td>
              </tr>
            </table>
            
        </div>
        </fieldset>
      </c:forEach>
    </div>
  </body>
</html>
