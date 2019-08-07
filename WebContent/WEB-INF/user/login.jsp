<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>登录页面</title>
<script>
	function myLogin() {
		var elem = document.getElementById("f1");
		var username = document.getElementById("un").value;
		var pw1 = document.getElementById("p1").value;
		var sp = document.getElementById("sp");
		if(username.length==0){
			sp.innerHTML = "用户名不能为空";
		}else if(pw1.length==0){
			sp.innerHTML = "密码不能为空";
		}else{
			elem.submit();
		}
	}
	
	function myLogin1() {
		sp.innerHTML = "";
	}
</script>
</head>

<body>
	<form action="LoginServlet" method="post" id="f1">
	<table border="1" align="center" width=300px height=300px cellspacing="0" bgcolor="#E4E4E4">
		<tr align="center">
			<td>用户名</td>
			<td><input type="text" name="username" id="un" onfocus="myLogin1()"></td>
		</tr>
		<tr align="center">
			<td>密码</td>
			<td><input type="password" name="pwd" id="p1" onfocus="myLogin1()"></td>
		</tr>
		<tr align="center">
			<td colspan="2">
				<input type="button" value="登录" onclick="myLogin()">
				<br><span style="color: red" id="sp"><c:out value="${result}"></c:out></span>
			</td>
		</tr>
	
	</table>
	</form>

</body>
</html>