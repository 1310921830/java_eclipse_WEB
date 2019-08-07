<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script src="<c:url value="/js/jquery-1.4.2.min.js"/>"></script>
<script type="text/javascript">
	$(function() {
		$("#btn").click(function() {
			var oldPwd = $("#p1").val();
			var newPwd1 = $("#p2").val();
			var newPwd2 = $("#p3").val();
			if(oldPwd.length==0){
				$("#sp1").text("密码不能为空");
			}else if(newPwd1.length==0){
				$("#sp2").text("密码不能为空");
			}else if(newPwd2.length==0){
				$("#sp3").text("密码不能为空");
			}else if(newPwd2!=newPwd1){
				$("#sp3").text("两次输入必须一致");
			}else{
				var id = $("#uid").val();
				
				$.ajax({
					url:"UpdatePwd",
					asyn:true,
					type:'post',
					data:{
						"id":id,
						"oldPwd":oldPwd,
						"newPwd":newPwd1
					},
					success:function(result){
						if(result.flag=="true"){
							alert(result.message);
							window.close();
						}else{
							
							$("#sp").text(result.message);
						}
					}	
				});
			};
		});
	});
</script>
</head>
<body>
	<form action="MgUpdateServlet" method="post" id="f1">
	<input type="hidden" name='uid' id='uid' value="${U.uId}">
	<table border=1px align="center" width=280px height=260px bgcolor="#E4E4E4" cellspacing="0">
			
			<tr align="center">
				<td>输入原密码</td>
				<td>
					<input type="password" name="pwd" id='p1'>
					<br><span id='sp1' style="color: red"></span>
				</td>
			</tr>
			<tr align="center">
				<td>输入新密码</td>
				<td>
					<input type="password" name="pwd1" id='p2'>
					<br><span id='sp2' style="color: red"></span>
				</td>
			</tr>
			<tr align="center">
				<td>再次输入新密码</td>
				<td>
					<input type="password" name="pwd2" id='p3'>
					<br><span id='sp3' style="color: red"></span>
				</td>
			</tr>
			
			<tr align="center">
				<td>
					<input type="button" value="提交" id="btn" style="color:blue">
				</td>
				<td>
					<input type="reset" name="重置" style="color:blue">
					<br><span id="sp"></span>
				</td>
			</tr>
		</table>
	</form>
</body>
</html>