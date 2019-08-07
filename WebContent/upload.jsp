<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"
	isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>

		<title>My JSP 'index.jsp' starting page</title>
		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">
		<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	</head>
	
	<script type="text/javascript">
   function downfile(newName,oldName)
	{
	   window.location.href = "/WEB03/who/downloadFile.action?downLoadFileName="+newName+"&uploadFileName="+oldName;
	}
	function uploadF(){
	    var uploadForm= document.getElementById("xx");
	    uploadForm.submit();
	}
    </script>
	<body>
		<form method="post" id="xx"
			action='<c:url value="/who/upload.action"/>'
			enctype="multipart/form-data">
			<c:if test="${empty uploadFileName }">选择一个文件: 
			<input type="file" name="upload">
				<input type="button" onclick="uploadF()" value="上传">
			</c:if>
			<c:if test="${not empty uploadFileName }">
				<c:out value="${uploadFileName}" />
				<input type="button" value="下载" onclick='downfile("${newFileName}","${uploadFileName}")' />
			</c:if>
			<span style="color: red;"><c:out value="${message}" />：</span><span
				onclick='downfile("${newFileName}","${uploadFileName}")'
				style="cursor: pointer;"><c:out value="${uploadFileName}" />
			</span>
			<br>
			<a
				href=<c:url value="/who/downloadFile.action?downLoadFileName=${newFileName}&uploadFileName=${uploadFileName}"/>>
				<c:out value="${uploadFileName}" /> </a>
			<input type="hidden" id="oldName" value="${uploadFileName}">
		</form>
	</body>
</html>
