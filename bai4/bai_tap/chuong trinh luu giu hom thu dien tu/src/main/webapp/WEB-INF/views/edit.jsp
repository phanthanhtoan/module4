<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: Nhokh
  Date: 2/23/2022
  Time: 1:12 AM
  To change this template use File | Settings | File Templates.
--%>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
      integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<div class="container">
    <h1 class="text-center">Settings</h1>
    <form:form action="/update" method="post" modelAttribute="emails">
        <table class="table table-striped">
            <tr>
                <td class="form-label">
                    language
                </td>
                <td><form:select path="language">
                    <form:option value="English">English</form:option>
                    <form:option value="Vietnamese">Vietnamese</form:option>
                    <form:option value="Japanese">Japanese</form:option>
                    <form:option value="Chinese">Chinese</form:option>
                   </form:select>
                </td>
            </tr>
            <tr>
                <td>
                    pageSize
                </td>

                <td>Show<form:select path="pageSize">
                    <form:option value="5">5</form:option>
                    <form:option value="10">10</form:option>
                    <form:option value="15">15</form:option>
                    <form:option value="25">25</form:option>
                    <form:option value="50">50</form:option>
                    <form:option value="100">100</form:option>
                </form:select>Email per page</td>
            </tr>
            <tr>
                <td>
                    spamsFilter
                </td>
                <td><form:checkbox path="spamsFilter"/>Enable spams filter</td>
            </tr>
            <tr>
                <td>
                    signature
                </td>
                <td><form:textarea path="signature"/></td>
            </tr>

        </table>
        <button class="btn btn-primary" type="submit">Update</button>
    </form:form>
</div>
</body>
</html>
