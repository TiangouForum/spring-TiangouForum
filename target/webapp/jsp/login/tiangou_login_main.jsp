<%--
  Created by IntelliJ IDEA.
  User: adu
  Date: 2018/4/14
  Time: 21:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<script  type="text/javascript" src="/webjars/jquery/2.1.4/jquery.js">
</script>
<script  type="text/javascript" src="/webjars/jquery/2.1.4/jquery.min.js">
</script>
<script  type="text/javascript" src="/webjars/bootstrap/3.2.0/js/bootstrap.min.js">
</script>
<script  type="text/javascript" src="/js/login/tiangou_login_main.js">
</script>
<script  type="text/javascript" src='/webjars/ajax-form/2.1.4/ajax-form.js'></script>
<html>
<head>
    <form id="form1" name="form1" method = 'post'  action = '/user/login.action'>
        <p>欢迎登陆！  </p>
        <p>姓名：
            <input type="text" id="userregnam" name="userregnam"/>
        </p>
        <p>密码:
            <input type="text" id="userpasswd" name="userpasswd"/>
        </p>
        <p class="err" style=" color:#ff0000" align="left">${requestScope.msg}</p>
        <p>
            <%--为button按钮添加type=button，防止点击以后，自动刷新页面--%>
            <button id="submitBtn" type="button" onclick="varifyForm();">登陆</button>
        </p>
    </form>
</head>
<body>

</body>
</html>