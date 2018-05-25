<#import "parts/common.ftl" as c>

<@c.page>
<div class="col-sm-12">
    Редактор пользователей
</div>
<form class="form-horizontal" role="form" action="/user" method="post">
    <div class="col-sm-12">
        <input type="text" name="username" value="${user.username}">
    </div>
    <#list roles as role>
        <div class="col-sm-offset-2 col-sm-10">
             <div class="checkbox">
             <label><input type="checkbox" name="${role}" ${user.roles?seq_contains(role)?string("checked", "")}>${role}</label>
             </div>
        </div>
    </#list>
    <input type="hidden" value="${user.id}" name="userId">
    <input type="hidden" value="${_csrf.token}" name="_csrf">
    <button class="btn btn-default btn-lg btn-block" type="submit">Сохранить</button>
</form>
</@c.page>