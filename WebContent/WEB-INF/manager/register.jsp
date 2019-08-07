<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>   
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
		
		var name = document.getElementById("n1").value;
		var age = document.getElementById("a1").value;
		if(username.length==0){
			document.getElementById('sp1').innerText="用户名不能为空";
		}else if(pw1.length==0){
			document.getElementById('sp2').innerText="密码不能为空";
		}else if(name.length==0){
			document.getElementById('sp3').innerText="姓名不能为空";
		}else if(age.length==0){
			document.getElementById('sp4').innerText="年龄不能为空";
		}else if(isNaN(Number(age))){
			document.getElementById('sp4').innerText="年龄必须输入数字";
		}else{
			elem.submit();
		}
	}
	
</script>
</head>
<body>
	<form action="MgUpdateServlet" method="post" id="f1">
	<input type="hidden" name='id' value="${U.uId}">
	<table border=1px align="center" width="300px" height="300px" bgcolor="#E4E4E4">
			<tr align="center">
				<td>用户名</td>
				<td>
					<input type="text" name="username" id="un" value="${U.userName}">
					<br><span id='sp1' style="color: red"></span>
				</td>
			</tr>
			<tr align="center">
				<td>密码</td>
				<td>
					<input type="password" name="pwd1" id='p1'>
					<br><span id='sp2' style="color: red"></span>
				</td>
			</tr>
			<tr align="center">
				<td>姓名</td>
				<td>
					<input type="text" name="name" id="n1" value="${U.name}">
					<br><span id='sp3' style="color: red"></span>
				</td>
			</tr>
			<tr align="center">
				<td>性别</td>
				<td>
					<c:set var="gender" value="${U.gender}"/>
					<c:if test="${gender eq 'male'}">
   						<input type="radio" name="gender" value="male" checked="checked">男&nbsp;
						<input type="radio" name="gender" value="female">女
					</c:if>
					<c:if test="${gender eq 'female'}">
   						<input type="radio" name="gender" value="male">男&nbsp;
						<input type="radio" name="gender" value="female" checked="checked">女
					</c:if>
					<c:if test="${empty gender}">
   						<input type="radio" name="gender" value="male" checked="checked">男&nbsp;
						<input type="radio" name="gender" value="female">女
					</c:if>
					
				</td>
			</tr>
			<tr align="center">
				<td>年龄</td>
				<td>
					<input type="text" name="age" id="a1" value="${U.age}">岁
					<br><span id='sp4' style="color: red"></span>
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