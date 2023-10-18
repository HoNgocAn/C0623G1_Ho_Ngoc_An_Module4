<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
  <title>Title</title>
</head>
<body>
<h2>View</h2>
<form:form action="/save" method="post" modelAttribute="mail">
  <table>
    <tr>
      <td style="font-weight: bold">Languages</td>
      <td colspan="4">
        <form:select path="language">
          <form:option value="English" label="English"/>
          <form:option value="Vietnamese" label="Vietnamese"/>
          <form:option value="Japanese" label="Japanese"/>
          <form:option value="Chinese" label="Chinese"/>
        </form:select>
      </td>
    </tr>
    <tr>
      <td style="font-weight: bold">Page Size</td>
      <td>Show</td>
      <td>
        <form:select path="pageSize">
          <form:option value="5" label="5"/>
          <form:option value="10" label="10"/>
          <form:option value="15" label="15"/>
          <form:option value="25" label="25"/>
          <form:option value="50" label="50"/>
          <form:option value="100" label="100"/>
        </form:select>
      </td>
      <td>emails per page</td>
    </tr>
    <tr>
      <td style="font-weight: bold">Spam Filter</td>
      <td colspan="4">
        <form:checkbox path="spamsFilter" value="true" label="Enable Spam Filter"/>
      </td>
    </tr>
    <tr>
      <td style="font-weight: bold">Signature</td>
      <td colspan="4">
        <form:textarea path="signature"/>
      </td>
    </tr>
    <tr>
      <td></td>
      <td>
        <button type="submit">Update
        </button>
      </td>
      <td>
        <a role="button" href="/view">Cancel</a>
      </td>
    </tr>
  </table>
</form:form>
</body>
</html>
