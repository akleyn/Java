<%--
    Document   : index
    Created on : Jun 6, 2017, 11:32:51 AM
    Author     : softwareguild
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Flooring Calculator</title>
    </head>
    <body>
                <h1>Flooring Calculator</h1>
        <p>Please enter the width of the flooring area to be covered: </p>
        <p>
        <form method="POST" action="FlooringServlet">
            <input  type="text" name="width">
            <p>Please enter the length of the flooring area to be covered: </p>
            <input type="text" name="length">
            <p>Please enter the cost per square foot of the flooring material: </p>
            <input type ="text" name="materialCost">
            <p>
            <input type="submit" value="Calculate Cost!!!">
            </p>
        </form>

        </p>
    </body>
</html>