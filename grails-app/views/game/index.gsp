<%--
  Created by IntelliJ IDEA.
  User: cepe
  Date: 17.02.2015
  Time: 14:09
--%>

<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <meta name="layout" content="main">
    <title>Game list</title>
</head>

<body>

<h1>History games</h1>
<div class="nav" role="navigation">
    <ul>
        <g:link class="create" action="actionShowDetail" >Add</g:link>
        <g:link class="list" controller="user" action="index" >Show all users</g:link>
    </ul>
</div>

<div id="gamesTableContainer">
    <g:render template="gameTable" model="['items':items, 'tableId': 'gamesTableContainer']" />
</div>

</body>
</html>