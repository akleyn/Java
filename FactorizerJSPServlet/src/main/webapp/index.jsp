<%-- 
    Document   : index
    Created on : Jun 5, 2017, 3:29:41 PM
    Author     : softwareguild
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Factorizer</title>
    </head>
    <body>
        <h1>Factorizer</h1>
        <p>Please enter the number that you would like to factor: </p>
        <p>
        <form method="POST" action="FactorizerServlet">
            <input  type="text" name="numberToFactor">
            <input type="submit" value="Find Factors!!!">
            
        </form>
            
        </p>
    </body>
</html>
