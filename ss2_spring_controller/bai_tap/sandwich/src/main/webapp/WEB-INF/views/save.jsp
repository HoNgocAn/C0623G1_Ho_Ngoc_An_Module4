<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Title</title>
</head>
<body>
<p>Bạn đã chọn Sandwich với các gia vị sau:</p>
<c:forEach items="${spice}" var="spice" >
  <p>${spice}</p>
</c:forEach>
</body>
</html>
