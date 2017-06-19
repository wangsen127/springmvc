<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<center>
		<h3>文件列表</h3>
		<c:forEach items="${filelist }" var="name">
			<img src="/up/${name}" width="50" height="50"><a href="download.do?fileName=${name}">下载</a><br>
		</c:forEach>
	</center>
</body>
</html>