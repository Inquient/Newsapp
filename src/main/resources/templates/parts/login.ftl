<#macro login path>
    <div class="form">
        <form class="form-horizontal" role="form" action="${path}" method="post">
            <div class="form-group">
                <div class="form-group">
                    <label for="inputEmail3" style="text-align: center; margin-top:5%" class="col-sm-12 control-label"> User Name : </label>
                    <div class="col-sm-12">
                       <input type="text"  class="form-control" placeholder="User Name" name="username"/>
                    </div>
                </div>
                <div class="form-group">
                    <label for="inputPassword3" style="text-align: center" class="col-sm-12 control-label"> Password: </label>
                    <div class="col-sm-12">
                        <input type="password"  class="form-control" placeholder="Password"  name="password"/>
                    </div>
                </div>

                    <input type="hidden" name="_csrf" value="${_csrf.token}">
                    <div class="col-sm-offset-2 col-sm-10">
                        <input type="submit" class="btn btn-default btn-sm" value="Sign In"/>
                    </div>

            </div>
        </form>
    </div>
</#macro>

<#macro logout>
            <form action="/logout" method="post">
                <input type="hidden" name="_csrf" value="${_csrf.token}">
                <input type="submit" value="Sign Out"/>
            </form>
</#macro>