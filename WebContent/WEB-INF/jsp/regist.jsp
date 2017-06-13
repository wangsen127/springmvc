<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<center>
		<h3>注册信息</h3>
		<form action="regist2.do" method="post">
		<table border="0">
			<tr align="left">
				<td>用户名：</td>
				<td><input name="username"/></td>
			</tr>
			<tr align="left">
				<td>密码：</td>
				<td><input name="password"/></td>
			</tr>
			<tr align="left">
				<td>日期：</td>
				<td><input name="birthday"/></td>
			</tr>
			<tr align="center">
				<td colspan="2"><input type="submit" value="注册"/></td>
			</tr>
		</table>
		</form>
	</center>
</body>
</html>