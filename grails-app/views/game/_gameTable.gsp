<style>
    .gameContainer {
        width: 80%;
        margin-left: auto;
        margin-right: auto;
    }

    .gameInfo:not(:last-child) {
        padding-bottom: 4%;
    }
    .gameInfo:first-child {
        margin-top: 3%;
    }

    .gameInfo ul {
        padding-left: 5%;
    }

    .gameInfo:hover {
        background-color: #dff0d8;
    }

</style>

<div class="gameContainer">
    <g:if test="${items}">

        <g:each in="${items}" var="game">
            <div class="gameInfo">
                <h3>${game.name}</h3>
                <p>${game.dateAndTime}</p>
                <br/>
                <p>Players:</p>
                <g:if test="${game?.users}">
                    <ul>
                    <g:each in="${game.users}" var="user">
                        <li>
                            <g:link controller="user" action="actionShowDetail" id="${user.id}">${user.getCode()}</g:link>
                        </li>
                    </g:each>
                    </ul>
                </g:if>
            </div>
        </g:each>
    </g:if>
    <g:else>
        <p><g:message code="GameDAO.table.no-records" /></p>
    </g:else>
</div>