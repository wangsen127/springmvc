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
		<h3>测试map</h3>
		<form action="testMap.do" method="post">
		<table border="0">
			<tr>
				<td>员工姓名:</td>
				<td><input name="map['ename']"></td>
			</tr>
			<tr>
				<td>薪&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;资:</td>
				<td><input name="map['sal']"></td>
			</tr>
			<tr>
				<td>入职日期:</td>
				<td><input name="map['hireDate']"></td>
			</tr>
			<tr>
				<td><input type="submit" value="确定" /></td>
				<td><input type="reset" value="取消" /></td>				
			</tr>
		</table>
		</form>
	</center>
</body>
</html>