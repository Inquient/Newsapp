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
                <th scope="col">Категория</th>
                <th scope="col">Автор</th>
            </tr>
            </thead>
    <#list news as n>
            <tbody>
            <tr>
                <th scope="row"><b>${n.title}</b></th>
                <td><span>${n.text}</span></td>
                <td><i>${n.keywords?ifExists}</i></td>
                <td><strong>${n.authorName}</strong></td>
                <td><form class="form-horizontal" role="form" action="/news/${n.id}" method="post">
                    <input type="hidden" value="${n.id}" name="newsId">
                    <input type="hidden" value="${_csrf.token}" name="_csrf">
                    <button class="btn btn-default btn-lg btn-block" name="delete" type="submit">Удалить</button>
                </form>
                </td>
            </tr>
            </tbody>
    <#else>
    Нет Новостей
    </#list>
        </table>
    </div>


    <a href="/addNews">Добавить Новости</a>
</@c.page>