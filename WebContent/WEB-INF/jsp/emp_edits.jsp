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
</script>
</head>
<body>
	<center>
		<h3>批量修改员工信息</h3>
		<form name="editsEmpForm" action="editsEmp.do" method="post">
		<table border="0" width="80%">
			<tr align="left">
				<td>
					<input type="submit" value="修改信息">
				</td>				
			</tr>
		</table>
		<table border="1" width="80%">
			<tr>
				<th>员工编号</th>
				<th>员工姓名</th>
				<th>薪&nbsp;&nbsp;&nbsp;&nbsp;资</th>
				<th>入职日期</th>
				<th>部门名称</th>
			</tr>
			<c:forEach items="${emplist }" var="emp" varStatus="vs">
			<tr>
				<td><input name="emps.eid" value="${emp.eid }" readonly="readonly"/></td>				
				<td><input name="emps.ename" value="${emp.ename }"/></td>				
				<td><input name="emps.sal" value="${emp.sal }"/></td>
				<td><input name="emps.hireDate" value="<fmt:formatDate value='${emp.hireDate }' pattern='yyyy-MM-dd'/>"/></td>				
				<td>
					<select name="emps.dept.did">
						<option value="0">--请选择--</option>
						<c:forEach items="${deptlist }" var="dept">
						<option value="${dept.did }" <c:if test="${emp.dept.did==dept.did }">selected</c:if>>${dept.dname }</option>
						</c:forEach>
					</select>
				</td>				
			</tr>
			</c:forEach>
		</table>
		</form>
	</center>
</body>
</html>