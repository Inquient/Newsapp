<#import "parts/common.ftl" as c>
<#import "parts/login.ftl" as l>
<@c.page>
Вход в аккаунт
<@l.login "/login" />
<a href="/registration">Зарегистрироваться</a>
</@c.page>
