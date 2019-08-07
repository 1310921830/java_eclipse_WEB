<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	function myFunction() {
		var elem = document.getElementById("f1");
		var username = document.getElementById("un").value;
		var pw1 = document.getElementById("p1").value;
		var pw2 = document.getElementById("p2").value;
		var name = document.getElementById("n1").value;
		var age = document.getElementById("a1").value;
		if(username.length==0){
			alert("用户名不能为空");
		}else if(pw1.length==0){
			alert("密码不能为空");
		}else if(pw2.length==0){
			alert("密码不能为空");
		}else if(name.length==0){
			alert("姓名不能为空");
		}else if(age.length==0){
			alert("年龄不能为空");
		}else if(pw1!=pw2){
			alert("两次输入密码必须一致");
		}else if(isNaN(Number(age))){
			alert("年龄必须输入数字");
		}else{
			elem.submit();
		}
	}
	
</script>
</head>
<body>
	<form action="RegisterServlet" method="post" id="f1">
	
	<table border=1px align="center" width="300px" height="300px" bgcolor="#E4E4E4">
			<tr align="center">
				<td>用户名</td>
				<td>
					<input type="text" name="username" id="un">
				</td>
			</tr>
			<tr align="center">
				<td>密码</td>
				<td>
					<input type="password" name="pwd1" id='p1'>
				</td>
			</tr>
			<tr align="center">
				<td>确认密码</td>
				<td>
					<input type="password" name="pwd2" id="p2">
				</td>
			</tr>
			<tr align="center">
				<td>姓名</td>
				<td>
					<input type="text" name="name" id="n1">
				</td>
			</tr>
			<tr align="center">
				<td>性别</td>
				<td>
					<input type="radio" name="gender" value="male" checked="checked">男&nbsp;
					<input type="radio" name="gender" value="female">女
				</td>
			</tr>
			<tr align="center">
				<td>年龄</td>
				<td>
					<input type="text" name="age" id="a1">岁
				</td>
			</tr>
			<tr align="center">
				<td>
					<input type="button" value="提交" onclick="myFunction()">
				</td>
				<td>
					<input type="reset" name="重置">
				</td>
			</tr>
		</table>
	</form>

</body>
</html>