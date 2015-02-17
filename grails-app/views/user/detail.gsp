<%--
  Created by IntelliJ IDEA.
  User: cepe
  Date: 16.02.2015
  Time: 09:11
--%>

<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <meta name="layout" content="main">
    <title>Detail of user</title>
</head>

<body>
<div style="color: red">
    <g:renderErrors bean="${userObj}" as="list" />
</div>

<g:form action="save">

    <g:hiddenField name="id" value="${userObj?.id}" />
    <g:hiddenField name="version" value="${userObj?.version}" />

    <div class="fieldcontain ${hasErrors(bean: userObj, field: 'name', 'error')} required">
        <label for="userName">
            <g:message code="UserDAO.name.label" default="Name" />
            <span class="required-indicator">*</span>
        </label>
        <g:textField id="userName" name="name" required="" value="${userObj?.name}"/>
    </div>

    <div class="fieldcontain ${hasErrors(bean: userObj, field: 'surname', 'error')} required">
        <label for="userSurname">
            <g:message code="UserDAO.surname.label" default="Surname" />
            <span class="required-indicator">*</span>
        </label>
        <g:textField id="userSurname" name="surname" required="" value="${userObj?.surname}"/>
    </div>


    <div class="fieldcontain ${hasErrors(bean: userObj, field: 'email', 'error')} required">
        <label for="userSurname">
            <g:message code="UserDAO.email.label" default="Surname" />
            <span class="required-indicator">*</span>
        </label>
        <g:textField id="userEmail" name="email" required="" value="${userObj?.email}"/>
    </div>

    <div class="buttons nav">
        <g:if test="${userObj != null && userObj.id > 0}">
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