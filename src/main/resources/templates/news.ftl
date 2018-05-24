<#import "parts/common.ftl" as c>
<#import "parts/login.ftl" as l>
<@c.page>
    <div>
        <@l.logout />
    </div>

    <form method="get" action="/news">
        <input type="text" name="filter" value="${filter}">
        <button type="submit">Найти</button>
    </form>

    <div>Список новостей</div>
    <#list news as n>
    <div>
        <b>${n.title}</b>
        <span>${n.text}</span>
        <b>${n.publishDate}</b>
        <i>${n.keywords}</i>
        <strong>${n.authorName}</strong>
    </div>
    <#else>
    Нет Новостей
    </#list>

    <a href="/addNews">Добавить Новости</a>
</@c.page>