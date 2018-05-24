<#import "parts/common.ftl" as c>

<@c.page>
<form action="/news" method="POST">
    <div>
        <label>
            <span>Заголовок новости</span><br>
            <textarea name="title" cols="40" rows="1"></textarea>
        </label><br>
    </div>
    <div>
        <label>
            <span>Текст новости</span><br>
            <textarea name="text" cols="40" rows="5"></textarea>
        </label><br>
    </div>
    <div>
        <form method="post" action="news">
            <input type="submit" value="Add new order">
            <input type="hidden" name="_csrf" value="${_csrf.token}">
        </form>
    </div>
</form>
</@c.page>