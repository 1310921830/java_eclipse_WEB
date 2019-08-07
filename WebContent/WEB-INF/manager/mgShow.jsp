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
	//查询
	function fn() {
		var mgForm = document.getElementById("mgForm");
		mgForm.action = "http://127.0.0.1:8080/WEB03/MgQuery";
		//alert('aaa');
		mgForm.submit();
	}
	
	//新增
	function addFn() {
		var url = 'MgUpdateShow';
		window.open(url,'修改信息','width=400,height=400');
	}
	
	function updateFn(t) {
		var id = t.parentNode.parentNode.children[0].innerHTML;
		//alert(id);
		var url = 'MgUpdateShow?id='+id;
		//alert(url);
		window.open(url,'修改信息','width=400,height=400');
	}
	
	function deleteFn(t) {
		var id = t.parentNode.parentNode.children[0].innerHTML;
		var urlString ="MgDelete";
		$.ajax({url:urlString,
			asyn:true,
			type:'post',
			data:{"id":id},
			success:function(result){
				if(result.flag=="true"){
					alert(result.message);
					t.parentNode.parentNode.parentNode.removeChild(t.parentNode.parentNode);
				}else{
					alert(result.message);
				}
			}	
			
		});
	} 
</script>
</head>
<body>
	<form method="post" id="mgForm">
		
		
	<table border="1" cellpadding="0" width=100% bgcolor="#EEEEEE" bgcolor="#E4E4E4">
		<tr>
			<td>
				用户名:<input type="text" name="username" value="${uname}">
			</td>
			<td>
				真实姓名:<input type="text" name="name" value="${name}">
			</td>
		</tr>
		<tr>
			<td>
				<input type="button" value="查询" onclick="fn()">
			</td>
			<td>
				<input type="button" value="新增" onclick="addFn()">
			</td>
		</tr>
	</table>	
	</form>
	<table border="1" cellpadding="0" width=100% bgcolor="#EEEEEE" bgcolor="#E4E4E4">
		<tr>
			<td>用户编号</td>
			<td>用户名</td>
			<td>用户密码</td>
			<td>真实姓名</td>
			<td>性别</td>
			<td>年龄</td>
			<td>操作</td>
		</tr>
		<c:forEach items="${userList}" var="user">
		<tr>	
			<td>${user.uId}</td>
			<td>${user.userName}</td>
			<td>${user.pwd}</td>
			<td>${user.name}</td>
			<td>${user.gender}</td>
			<td>${user.age}</td>
			<td>
				<input type="button" value="修改" onclick="updateFn(this)">&nbsp;
				<input type="button" value="删除" onclick="deleteFn(this)">
			</td>
		</tr>	
		</c:forEach>
	</table>
</body>
</html>