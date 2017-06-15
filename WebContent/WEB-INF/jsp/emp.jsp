<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	function delEmp(){
		document.delEmpForm.submit();
	}
</script>
</head>
<body>
	<center>
		<h3>员工信息</h3>
		<form action="listEmp.do" method="post">
		<table border="0" width="80%">
			<tr align="left">
				<td>部门名称:
					<select name="dept.did">
						<option value="0">--请选择--</option>
						<c:forEach items="${deptlist }" var="dept">
						<option value="${dept.did }">${dept.dname }</option>
						</c:forEach>
					</select>
				</td>
				<td>员工姓名:<input name="ename"></td>	
				<td>
					<input type="submit" value="查询">
					<input type="button" value="批量修改" onclick="location.href='showEditsEmp.do'">
					<input type="button" value="批量删除" onclick="delEmp()">
				</td>				
			</tr>
		</table>
		</form>
		<form name="delEmpForm" action="delEmpAll.do" method="post">
		<table border="1" width="80%">
			<tr>
				<th></th>
				<th>员工编号</th>
				<th>员工姓名</th>
				<th>薪&nbsp;&nbsp;&nbsp;&nbsp;资</th>
				<th>入职日期</th>
				<th>部门编号</th>
				<th>部门名称</th>
				<th>操&nbsp;&nbsp;&nbsp;&nbsp;作</th>
			</tr>
			<c:forEach items="${emplist }" var="emp" varStatus="vs">
			<tr>
				<td><input type="checkbox" name="ids" value="${emp.eid }"/></td>
				<td>${emp.eid }&nbsp;</td>				
				<td>${emp.ename }&nbsp;</td>				
				<td>${emp.sal }&nbsp;</td>
				<td><fmt:formatDate value="${emp.hireDate }" pattern="yyyy-MM-dd"/>&nbsp;</td>				
				<td>${emp.dept.did }&nbsp;</td>				
				<td>${emp.dept.dname }&nbsp;</td>				
				<td>
					<a href="###">修改</a>
					&nbsp;&nbsp;&nbsp;&nbsp;
					<a href="###">删除</a>
				</td>				
			</tr>
			</c:forEach>
		</table>
		</form>
	</center>
</body>
</html>