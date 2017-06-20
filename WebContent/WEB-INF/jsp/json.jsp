<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path;
%>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="static/js/jquery-1.4.4.min.js"></script>
<script type="text/javascript">
	$(function(){
		alert(123);
	});
	function json1(){
		$.ajax({
			type : 'post',
			url : 'json1.do',
			data : 'dname=哈哈&did=10',
			//contentType : 'application/x-www-form-urlencoded',
			success : function(data){
				alert(data);
				alert(data.did);
				alert(data.dname);
			}
		});
	}
	
	function json2(){
		$.ajax({
			type : 'post',
			url : 'json2.do',
			data : '{dname:"abc",did:20}',
			contentType : 'application/json',
			success : function(data){
				alert(data);
				alert(data.did);
				alert(data.dname);
			}
		});
	}
	
	function json3(){
		$.post('json2.do',{
			did : 30,
			dname : '啦啦'
		},function(data){
			alert(data);
			alert(data.did);
			alert(data.dname);
		});
	}

</script>
</head>
<body>
	<center>
		<input type="button" value="json1" onclick="json1()"/><br>
		<input type="button" value="json2" onclick="json2()"/><br>
		<input type="button" value="json3" onclick="json3()"/>
	</center>
</body>
</html>