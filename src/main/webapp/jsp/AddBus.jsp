
<!Doctype html>
<%@page language="java" contentType="text/html" pageEncoding="UTF-8" %>

<html>
    <head>
        <title>Add Bus</title>
        <link rel = "stylesheet" type = "text/css" href = "/css/add.css">
    </head>
    <body>
    <h1>Add new Bus</h1>
    <form action="registerBus" method = "post">
        <div class="container">
            <table cellpadding = "5">
                <tr>
                    <td>Bus Number:</td>
                    <td>
                        <input type = "text" name = "busNumber" maxlength = "20"
                        placeholder = "Enter Bus Number" required/>
                    </td>
                </tr>
                <tr>
                    <td>Capacity:</td>
                    <td> 
                        <input type = "text" name = "capacity" maxlength = "20"
                        placeholder = "Enter Capacity" required />
                    </td>
                </tr>
                <tr>
                    <td>Operator:</td>
                    <td> 
                        <input type = "text" name = "operator" maxlength = "30"
                        placeholder= "Enter Operator" required />
                    </td>
                </tr>
                    <td>Seat Details</td>
                </tr>
                <tr>
                    <td>Seat Number:</td>
                    <td> 
                        <input type = "text" name = "seatNumber" required 
                        placeholder = "Enter Seat Number" maxlength = "30" />
                    </td>
                </tr>
                <tr>
                    <td>Type:</td>
                    <td> 
                        <input type = "text" name = "type" required 
                        placeholder = "Enter Seat Type" maxlength = "15" />
                    </td>
                </tr>
                <tr>
                    <td>Seat Details</td>
                </tr>
                <tr>
                    <td>Seat Number:</td>
                    <td> 
                        <input type = "text" name = "seatNumber1" required 
                        placeholder = "Enter Seat Number" maxlength = "30" />
                    </td>
                </tr>
                <tr>
                    <td>Type:</td>
                    <td> 
                        <input type = "text" name = "type1" required
                        placeholder = "Enter Seat Type" maxlength = "15" />
                    </td>
                </tr>
                <tr>
                    <td><button type="submit" class="registerbtn"/>Register</td>
                    <td><button type="Reset" class = "button5"/>Reset</td>
                </tr>
            </table>
            </div>
        </form> 
    </body>
</html>