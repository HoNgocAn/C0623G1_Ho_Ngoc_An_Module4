<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Dictionary</title>
</head>
<body>
<form action="/search">
    <label for="key">Enter the word to look up</label> <br><br>
    <input type="text" name="key" id="key"> <br><br>
    <input type="submit" value="search">
    <c:if test="${not empty result}">
        <p>${result}</p>
    </c:if>
</form>
</body>
</html>