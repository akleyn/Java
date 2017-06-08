<%-- 
    Document   : result
    Created on : Jun 5, 2017, 3:30:57 PM
    Author     : softwareguild
--%>
<%@taglib prefix = "c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Result</title>
    </head>
    <body>
        <h1>Result</h1>
        <p>
            You asked us to factor ${numberToFactor}
        </p>
        <p>
            <c:forEach var="currentFactor" items="${factor}">
                <c:out value="${currentFactor} "/>
                       
            </c:forEach>
        </p>
        <p>
            <c:choose>
            <c:when test="${isPerfect}">
                <c:out value="The number is perfect.">
                    
                </c:out>
            </c:when>
                <c:otherwise>
                    <c:out value="The number is not perfect."/>
                </c:otherwise>
            </c:choose>
        </p>
        <p>
            <c:choose>
            <c:when test="${isPrime}">
                <c:out value="The number is prime.">
                    
                </c:out>
            </c:when>
                <c:otherwise>
                    <c:out value="The number is not prime."/>
                </c:otherwise>
            </c:choose>
        </p>
        <p>
            <a hred="index.jsp">
                Factor another one!
            </a>
        </p>
    </body>
</html>
