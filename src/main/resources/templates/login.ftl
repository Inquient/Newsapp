<#import "parts/common.ftl" as c>
<#import "parts/login.ftl" as l>
<@c.page>
<#include "parts/navbar.ftl">
<div class="container">

</div>
<@l.login "/login" />

<a style="text-align: center; margin-top:5%" class="col-sm-12 control-label" href="/registration">Зарегистрироваться</a>
</@c.page>

