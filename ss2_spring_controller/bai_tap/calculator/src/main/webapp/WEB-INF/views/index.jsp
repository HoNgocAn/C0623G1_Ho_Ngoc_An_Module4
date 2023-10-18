<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Calculator</title>
</head>
<body>

<h2>Calculator</h2>
<form method="post">
        <table>
            <tr>
                <td>Number A: </td>
                <td><input name="numberA" type="number"/></td>
            </tr>
            <tr>
                <td>Operator: </td>
                <td>
                    <select name="math">
                        <option value="+">Addition(+)</option>
                        <option value="-">Subtraction(-)</option>
                        <option value="*">Multiplication(*)</option>
                        <option value="/">Division(/)</option>
                    </select>
                </td>
            </tr>
            <tr>
                <td>Number B: </td>
                <td><input name="numberB" type="number"/></td>
            </tr>
            <tr>
                <td></td>
                <td><input type="submit" value="Calculate"/></td>
            </tr>
        </table>
</form>
<c:if test="${not empty result}">
    <p>Result: ${result}</p>
</c:if>
<c:if test="${not empty error}">
    <p>${error}</p>
</c:if>
</body>
</html>