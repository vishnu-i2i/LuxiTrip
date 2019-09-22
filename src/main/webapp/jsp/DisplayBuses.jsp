<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page import="com.ideas2it.luxitrip.model.Bus"%>
<%@page import="com.ideas2it.luxitrip.model.Seat"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!Doctype html>

<html>
    <head>
        <title>Display Buses</title>
        <link rel = "stylesheet" type = "text/css" href = "/css/display.css">
        <link rel = "stylesheet" type = "text/css" href = "/css/MainMenu.css">
    </head>
    <body>
        <center>
            <a href = "AddBus.jsp"><button type = "button" class = "button">New Bus</button></a>
            <div class = "background"><h1>BUS</h1></div>
        </center>
        <table align = "center" border =10>
        <tr>
            <th><b>Bus Number</b></th>
            <th><b>Capacity</b></th>
            <th><b>Operator</b></th>
            <th><b>Type</b></th>    
            <th><b>Status</b></th>
            <th><b>Action</b></th>
            </tr>
        <%List<Bus> buses= new ArrayList<>();
        buses = (ArrayList<Bus>)request.getAttribute("buses");
        for(Bus bus:buses){%> 
        <tr>
            <td><%=bus.getBusNumber()%></td> 
            <td><%=bus.getCapacity()%></td> 
            <td><%=bus.getOperator()%></td>
            <td><%=bus.getType()%></td>
            <td><%=bus.isStatus()%></td>
            <td>
                <form method = "get" action ="fetchBus">
                <input type="hidden" name="id" value="<%=bus.getId()%>"/>
                <button type="submit">update</button>
                </form>
                <form method = "post" action ="deleteBus">
                <input type="hidden" name="id" value="<%=bus.getId()%>"/>
                <button type="submit">delete</button>
                </form>
            </td>
        </tr>
        <%}%> 
        </table>
    </body>
</html>