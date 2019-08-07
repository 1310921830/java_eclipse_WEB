<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	function loginFn() {
		window.location.href="userFoward?id=login";//跳转登录页面
	}
	
	function regFn() {
		window.location.href="userFoward?id=register";//跳转注册页面
	}
	function mgLogin() {
		window.location.href="MgLogin";//跳转登录页面
	}
</script>
<body>
<table border="1" align="center" width=200px height=200px cellspacing="0" bgcolor="#9AB5D3">
	<tr align="center">
		<td>我的主页</td>
	</tr>
	<tr align="center">
		<td><input type="button" value="登录" onclick="loginFn()"></td>
	</tr>
	<tr align="center">
		<td><input type="button" value="注册" onclick="regFn()"></td>
	</tr>
	<tr align="center">
		<td><input type="button" value="系统管理员" onclick="mgLogin()"></td>
	</tr>
</table>
</body>
</html>