<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="<c:url value="/js/jquery-1.4.2.min.js"/>"></script>
<style type="text/css">
	table{
		width:990px;
		margin:0 auto;
		font-size:12px;
		color:#9c9a9c;
		border-bottom:1px solid #E4E4E4;
	}
	.first-row{
		font-weight:bold;
		color:#666;
		border-bottom:1px solid #E4E4E4;
		
	}
/*	.first-row>td{*/
/*		text-align:left;*/
/*	}*/
	.col1{
		width:610px;
		text-align:left;
		padding-left:10px;
	}
	a{
		text-decoration:none;
		color:#005aa0;
	}
	td{
		border-bottom:1px dashed #E4E4E4;
		padding:5px 0px;
		text-align:center;
	}
	.fcol{
		padding-left:0;
	}



  </style>
 <script type="text/javascript">
 	$(function() {
		$("#btn1").click(function() {
			$("#a1").html("离线了a");
			$("#a2").html("");
			$("#uid").parent().html("");
			$(this).parent().html('<input type="button" value="登录" id="btn3">');
			$("#btn2").parent().html('<input type="button" value="注册" id="btn4">');
		});
		
		
	});
 	
 	function fn() {
		//alert("haha");
		var id = $("#uid").val();
		var url = 'UpdatePwd?id='+id;
		window.open(url,'修改密码','width=400,height=400,left=600');
		
	}
 </script>
 </head>
 <body background="img/1.jpg">
	<table>
		<tr class="first-row">
			<td class="col1 fcol">状态</td>
			<td></td>
			<td>欢迎</td>
			<td><input type="button" value="注销" id="btn1"></td>
		</tr>
		<tr>
			<td class="col1"><a href="#" id="a1"><c:out value="${result}"></c:out></a></td>
			<td><input type="hidden" id="uid" value="${u.uId}"></td>
			<td><a href="" id="a2"><c:out value="${u.userName}"></c:out></a></td>
			<td><input type="button" value="修改密码" id="btn2" onclick="fn()"></td>
		</tr>
		<tr class="first-row">
			<td class="pe=col1 fcol">主题</td>
			<td>回复/浏览</td>
			<td>作者</td>
			<td>时间</td>
		</tr>
		<tr>
			<td class="col1"><a href="#">银灰色的，很酷</a></td>
			<td>0/0</td>
			<td><a href="">2001年冬天</a></td>
			<td>2001-11-11 11:11:11</td>
		</tr>
		
	</table>
	
</body>
</html>