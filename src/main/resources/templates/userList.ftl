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
        </tr>
        </#list>
    </tbody>

</table>

</@c.page>