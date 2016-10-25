<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String path=request.getContextPath();

	String name = request.getServletContext().getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+"/"+path;
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>XX系统登录</title>
<link rel="stylesheet" href="./css/bootstrap/bootstrap.css">
<script type="text/javascript" src="./js/jquery-1.11.3.min.js"></script>
<script type="text/javascript" src="./js/jquery/jquery-ui-1.10.3.custom.min.js"></script>
</head>
<body class="container">
	<div style="height: 20px"></div>
	<form action="logincheck" method="post" class="form-horizontal" onsubmit="return checkpassword()">
		<div class="row">
		
			<div class="form-group">
				<div class="col-md-4">
					<span style="color: red;">${message}</span>
				</div>
			</div>
			<div class="form-group">
				<div class="col-md-1">
					<label for="name" class="control-label">用户名：</label>
				</div>
				<div class="col-md-3">
					<input type="text" id="name" name="name" class="form-control">
				</div>
			</div>
		</div>
		<div class="row">
			<div class="form-group">
				<div class="col-md-1">
					<label for="password" class="control-label">密码：</label>
				</div>
				<div class="col-md-3">
					<input type="password" id="password" name="password" class="form-control">
				</div>
			</div>
		</div>
		<div class="row"">
			<div class="form-group">
				<div class="com-md-4">
					<button type="submit" class="btn btn-primary" style="margin-left:170px">登录</button>
					<a class="btn btn-info" href="sign.json">注册</a>
				</div>
			</div>
		</div>
	</form>
	
<script type="text/javascript">
	function checkpassword(){
		//登录校验密码不为空
		var password = $("#password").val();
		if(""==password){
			alert("请输入密码！")
			return false;
		}
		return true;
	}
	
</script>	
</body>
</html>