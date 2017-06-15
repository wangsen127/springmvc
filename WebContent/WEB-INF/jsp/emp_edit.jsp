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
	var setDname = function(){
		var sc = document.getElementById("dept.did");
		var ic = document.getElementById("dept.dname");
		for(var i=0;i<sc.length;i++){
			if(sc[i].selected){
				ic.value = sc[i].text;
				break;
			}			
		}
	}
</script>
</head>
<body>
	<center>
		<h3>修改员工</h3>
		<form action="editEmp.do" method="post">
		<input type="hidden" name="eid" value="${emp.eid }"/>
		<table border="0">
			<tr>
				<td>员工姓名:</td>
				<td><input name="ename" value="${emp.ename }"/></td>
			</tr>
			<tr>
				<td>薪&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;资:</td>
				<td><input name="sal" value="${emp.sal }"/></td>
			</tr>
			<tr>
				<td>入职日期:</td>
				<td><input name="hireDate" value="<fmt:formatDate value='${emp.hireDate }' pattern='yyyy-MM-dd'/>"/></td>
			</tr>
			<tr>
				<td>部门名称:</td>
				<td>
					<select id="dept.did" name="dept.did" onchange="setDname()">
						<option value="0">--请选择--</option>
						<c:forEach items="${deptlist }" var="dept">
						<option value="${dept.did }" <c:if test="${emp.dept.did==dept.did }">selected</c:if>>${dept.dname }</option>
						</c:forEach>
					</select>
					<input id="dept.dname" type="hidden" name="dept.dname"/>
				</td>
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