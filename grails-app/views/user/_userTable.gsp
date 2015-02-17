<table>
    <thead>
    <tr>
        <th>name</th>
        <th>surname</th>
        <th>email</th>
        <th>actions</th>
    </tr>
    </thead>
    <tbody>
    <g:if test="${items}">
        <g:each in="${items}" var="user">
            <tr>
                <td>${user.name}</td>
                <td>${user.surname}</td>
                <td>${user.email}</td>
                <td>
                    <g:link class="edit" action="actionShowDetail" params="[id:user.id]">Edit</g:link>
                    <g:remoteLink class="delete" action="actionRemoveDetail" id="${user.id}" update="${tableId}" >Remove</g:remoteLink>
                </td>
            </tr>
        </g:each>
    </g:if>
    <g:else>
        <tr>
            <td colspan="3"><g:message code="UserDAO.table.no-records" /></td>
        </tr>
    </g:else>
    </tbody>
</table>