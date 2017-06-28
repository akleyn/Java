<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@page contentType="text/html" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Vending</title>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" type="text/css" href="css/bootstrap.css">
    <link rel="stylesheet" type="text/css" href="css/home.css">
    <script src="js/jquery-2.2.4.js"></script>
    <script src="js/bootstrap.min.js"></script>
    <script src="js/home.js"></script>
</head>
<body>
<div class="container">

    <h2 class="main-header">Vending Machine</h2>
    <ul class="list-group">
    <div class="row">
        <div class="col-lg-7" id="goods">
            ${items}
            <br>
        </div>
        <div class="col-lg-3 col-lg-offset-1">
            <div class="row right-side-botoom-border-container">
                <h4 class="header">Total $ in</h4>
                <div class="row">
                    <% float total = 0.00f;
                        String totalFormated = "0.00";
                        if (request.getParameter("total") != null) {
                            total = Float.parseFloat(request.getParameter("total"));
                            totalFormated = String.format("%.2f", total);
                        }
                    %>
                    <input class="form-control main-input" type="text" value="<%=totalFormated%>" disabled="disabled" id="total">
                </div>
                <br>
                <div class="row">
                    <div class="col-lg-12">
                        <div class="row">
                            <div class="col-lg-6">
                                <button class="btn btn-default col-lg-10 col-lg-offset-1" onclick="addTotal(1)">Add
                                    Dollar
                                </button>
                            </div>
                            <div class="col-lg-6">
                                <button class="btn btn-default col-lg-10 col-lg-offset-1" onclick="addTotal(0.25)">Add
                                    Quarter
                                </button>
                            </div>
                        </div>
                    </div>
                </div>
                <br>
                <div class="row">
                    <div class="col-lg-12">
                        <div class="row">
                            <div class="col-lg-6">
                                <button class="btn btn-default col-lg-10 col-lg-offset-1" onclick="addTotal(0.1)">Add
                                    Dime
                                </button>
                            </div>
                            <div class="col-lg-6">
                                <button class="btn btn-default col-lg-10 col-lg-offset-1" onclick="addTotal(0.05)">Add
                                    Nickel
                                </button>
                            </div>
                        </div>
                    </div>
                </div>
                <br>
            </div>

            <div class="row right-side-botoom-border-container">
                <h4 class="header">Messages</h4>
                <div class="col-lg-12">
                    <%
                        String message = "";
                        if (request.getParameter("message") != null) {
                            message = request.getParameter("message");
                        }
                    %>
                    <input class="form-control main-input" value="<%=message%>" disabled="disabled"
                           id="messages">
                </div>
                <br>
                <div class="row">
                    <div class="col-lg-12">
                        <div class="row">
                            <div class="col-lg-6">
                                <h5 class="control-label col-lg-3 col-lg-offset-3">Item:</h5>
                            </div>
                            <div class="col-lg-6">
                                <%
                                    String item_id = "";
                                    if (request.getParameter("item_id") != null) {
                                        item_id = request.getParameter("item_id");
                                }
                                %>
                                <input class="form-control col-lg-10 col-lg-offset-1" value="<%=item_id%>" disabled="disabled"
                                       id="item">
                            </div>
                        </div>
                    </div>
                </div>
                <br>
                <div class="row">
                    <div class="col-lg-12">
                        <button name="Make Purchase" class="btn btn-default col-lg-10 col-lg-offset-1"
                                onclick="submitData()">Make Purchase
                        </button>
                    </div>
                </div>
                <br>
            </div>

            <div class="row">
                <h4 class="header">Change</h4>
                <div class="col-lg-12">


                <input class="form-control main-input" value="" disabled="disabled"
                       id="change">
                    <%
                        if (request.getParameter("total") != null) {
                    %>
                    <script>
                        showChange(<%=total%>);
                    </script>
                    <% } %>
                </div>
                <br>
                <div class="row">
                    <button class="btn btn-default col-lg-10 col-lg-offset-1" id="return" onclick="document.location='/'">Change Return
                    </button>
                </div>
            </div>
        </div>
    </div>
    </ul>
</div>

</body>
</html>
