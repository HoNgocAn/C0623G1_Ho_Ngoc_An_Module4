<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Currency Converter</title>
    <link rel="stylesheet" type="text/css" href="css/style.css">
</head>
<body>
<h2>Currency Converter</h2>

<form action="/calculate">
    <p>USD</p>
    <input type="number" name="usd"  placeholder="Enter USD" > <br><br>
    <input class="btn btn-primary" type="submit" value="Convert">
    <c:if test="${not empty vnd}">
        <p>
            Result : ${vnd} đ
        </p>
    </c:if>
</form>
</body>
</html>