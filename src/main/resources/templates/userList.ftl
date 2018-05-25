<#import "parts/common.ftl" as c>

<@c.page>
    <#include "parts/navbar.ftl">
Список пользователей
<table class="table table-condensed">
    <thead>
    <tr class="active">
        <th scope="col">Имя</th>
        <th scope="col">Роль</th>
        <th></th>
    </tr>
    </thead>

    <tbody>
        <#list users as user>
        <tr>
            <td>${user.username}</td>
            <td><#list user.roles as role>${role}<#sep>, </#list></td>
            <td><a href="/user/${user.id}">Редактировать</a></td>
            <td><form class="form-horizontal" role="form" action="/user/${user.id}" method="post">
                <input type="hidden" value="${user.id}" name="userId">
                <input type="hidden" value="${_csrf.token}" name="_csrf">
                <button class="btn btn-default btn-lg btn-block" name="delete" type="submit">Удалить</button>
            </form>
            </td>
        </tr>
        </#list>
    </tbody>

</table>

</@c.page>