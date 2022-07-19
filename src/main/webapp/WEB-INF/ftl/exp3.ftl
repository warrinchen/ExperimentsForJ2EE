<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>exp3-login</title>
    <script src="../../resources/jquery-3.6.0.js"></script>
</head>
<body>
    <form action="/exp3/login" method="post">
        <table align="center" style="margin-top: 350px;">
            <tr>
                <td align="center" colspan="2">用户登陆入口</td>
            </tr>
            <tr>
                <td><label>用户名</label></td>
                <td><input type="text" maxlength="15" name="username"></td>
            </tr>
            <tr>
                <td><label>密码</label></td>
                <td><input type="password" maxlength="60" name="password"></td>
            </tr>
            <tr>
                <td colspan="2" style="text-align: center"><input type="submit" value="登陆" ></td>
            </tr>
        </table>
    </form>
<#if err_info??>
    <script>
        $(function (){
            alert("${err_info}");
        });
    </script>
</#if>
</body>
</html>