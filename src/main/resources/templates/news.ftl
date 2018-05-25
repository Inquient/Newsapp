<#import "parts/common.ftl" as c>
<#import "parts/login.ftl" as l>
<@c.page>
    <#include "parts/navbar.ftl">
    <div class="">
        <div class="row">
            <div class="col-md-6"><@l.logout /></div>
            <div class="col-md-6"> <span><a href="/user">Список пользователей</a> </span>
                <form method="get" action="/news">
                    <input type="text" name="filter" value="${filter?ifExists}">
                    <button type="submit">Найти</button>
                </form>
            </div>
        </div>
    </div>



    <div style="text-align: center; margin-top:5%" class="col-sm-12" >Список новостей</div>
<#--<#list news as n>-->
    <div>
        <table class="table table-condensed">
            <thead>
            <tr class="active">
                <th scope="col">Заголовок</th>
                <th scope="col">Текст</th>
                <th scope="col">Дата публикации</th>
                <th scope="col">Категория</th>
                <th scope="col">Автор</th>
            </tr>
            </thead>
    <#list news as n>
            <tbody>
            <tr>
                <th scope="row"><b>${n.title}</b></th>
                <td><span>${n.text}</span></td>
                <td><b>${n.publishDate}</b></td>
                <td><i>${n.keywords?ifExists}</i></td>
                <td><strong>${n.authorName}</strong></td>
            </tr>
            </tbody>
    <#else>
    Нет Новостей
    </#list>
        <#--<b>${n.title}</b>-->
        <#--<span>${n.text}</span>-->
        <#--<b>${n.publishDate}</b>-->
        <#--<i>${n.keywords}</i>-->
        <#--<strong>${n.authorName}</strong>-->
        </table>
    </div>


    <a href="/addNews">Добавить Новости</a>
</@c.page>