<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>系统管理员登录</title>
<script>
	function myLogin() {
		var elem = document.getElementById("f1");
		var username = document.getElementById("un").value;
		var pw1 = document.getElementById("p1").value;
		if(username.length==0){
			alert("用户名不能为空");
		}else if(pw1.length==0){
			alert("密码不能为空");
		}else{
			elem.submit();
		}
	}
</script>
</head>
<body>
	<form action="MgIndex" method="post" id="f1">
	<table border="1" align="center" width=200px height=200px cellspacing="0" bgcolor="#E4E4E4">
		<tr align="center">
			<td>用户名</td>
			<td><input type="text" name="username" id="un"></td>
		</tr>
		<tr align="center">
			<td>密码</td>
			<td><input type="password" name="pwd" id="p1"></td>
		</tr>
		<tr align="center">
			<td colspan="2">
				<input type="button" value="登录" onclick="myLogin()">
			</td>
		</tr>
	</table>
	</form>
</body>
</html>