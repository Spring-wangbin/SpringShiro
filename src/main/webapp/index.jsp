<%@page contentType="text/html; charset=UTF-8" language="java" %>
<html>
<head></head>
<body>
<h3>用户登录</h3>
<span style="color: #ff1c21;">${errorMsg}</span>
<form method="post" action="/login">
    <p><input type="text" name="username" value="" placeholder="账号"></p>
    <p><input type="password" name="password" value="" placeholder="密码"></p>
    <input type="submit" value="登录">
</form>
</body>
</html>
