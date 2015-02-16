<%--
  Created by IntelliJ IDEA.
  User: cepe
  Date: 13.02.2015
  Time: 14:57
--%>

<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <meta name="layout" content="main">
    <title>User list</title>
</head>

<body>

<h1>This is list of available users</h1>
<div class="nav" role="navigation">
    <ul>
        <g:link class="create" action="actionShowDetail" >Add</g:link>
    </ul>
</div>

<div id="usersTableContainer">
    <g:render template="userTable" model="['items':items, 'tableId': 'usersTableContainer']" />
</div>

</body>
</html>