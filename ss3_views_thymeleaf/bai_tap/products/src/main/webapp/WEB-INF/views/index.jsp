<!DOCTYPE html>
<html xmlns:th="http://www.thymeleaf.org" lang="en">
<head >
    <title>ListProduct</title>
</head>
<body>
    <table>
        <thead>
        <tr>
            <th>STT</th>
            <th>Name</th>
            <th>Description</th>
            <th>Price</th>
        </tr>
        </thead>
        <tbody>
        <tr th:each="product,loop : ${products}">
            <th th:text="${loop.count}" ></th>
            <td th:text="${product.name}"></td>
            <td th:text="${product.description}"></td>
            <td th:text="${product.price}"></td>
        </tr>
        </tbody>
    </table>
</body>
</html>