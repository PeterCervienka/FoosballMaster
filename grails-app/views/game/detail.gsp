<%--
  Created by IntelliJ IDEA.
  User: cepe
  Date: 17.02.2015
  Time: 14:42
--%>

<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <meta name="layout" content="main">
    <title>Detail of game</title>
</head>

<body>
<div style="color: red">
    <g:renderErrors bean="${gameObj}" as="list" />
</div>

<g:form action="save">

    <g:hiddenField name="id" value="${gameObj?.id}" />
    <g:hiddenField name="version" value="${gameObj?.version}" />

    <div class="fieldcontain ${hasErrors(bean: gameObj, field: 'name', 'error')} required">
        <label for="gameName">
            <g:message code="GameDAO.name.label" default="Name" />
            <span class="required-indicator">*</span>
        </label>
        <g:textField id="gameName" name="name" required="" value="${gameObj?.name}"/>
    </div>

    <div class="fieldcontain ${hasErrors(bean: gameObj, field: 'dateAndTime', 'error')} required">
        <label for="gameDateAndTime">
            <g:message code="GameDAO.dateAndTime.label" default="Surname" />
            <span class="required-indicator">*</span>
        </label>
        <g:datePicker id="gameDateAndTime" name="dateAndTime" required="" value="${gameObj?.dateAndTime}" relativeYears="[0..1]"/>
    </div>

    <div class="fieldcontain" style="padding-top: 5%">
        <p>Players</p>
    </div>

    <div class="buttons nav">
        <g:if test="${gameObj != null && gameObj.id > 0}">
            <g:submitButton class="edit" value="Update" name="saveButton"/>
        </g:if>
        <g:else>
            <g:submitButton class="save" value="Save" name="saveButton"/>
        </g:else>

        <g:link class="home" action="index">Back</g:link>
    </div>

</g:form>
</body>
</html>