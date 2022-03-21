<%--
  Created by IntelliJ IDEA.
  User: Nhokh
  Date: 2/28/2022
  Time: 12:18 AM
  To change this template use File | Settings | File Templates.
--%>
<html>
<head>
  <title>Information</title>
</head>
<body>
<h2>Submitted Email Information</h2>
<table>
  <tr>
    <td>Language:</td>
    <td>${email.language}</td>
  </tr>
  <tr>
    <td>Page sizze:</td>
    <td>${email.pageSize}</td>
  </tr>
  <tr>
    <td>Spams Filter:</td>
    <td>${email.spamsFilter}</td>
  </tr>
  <tr>
    <td>Signature:</td>
    <td>${email.signature}</td>
  </tr>
</table>
</body>
</html>