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

<style type="text/css">
#header {
  width: 100%;
  height: 100px;
  border-bottom: 1px solid #e3e3e3;
  background-color: #f0f0f0;
}
</style>
</head>

<body class="container">
<div style="height: 40px"></div>
	<form action="sign/save.html" method="post" class="form-horizontal" onsubmit="return checkinput()">
		<div class="row">
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
					<label for="sex" class="control-label">性别：</label>
				</div>
				<div class="col-md-3">
					<select id="sex" name="sex" class="form-control ndv">
						<option value="1">男</option>
						<option value="2">女</option>
					</select>
				</div>
			</div>
		</div>
		<div class="row">
			<div class="form-group">
				<div class="col-md-1">
					<label for="email" class="control-label">邮箱：</label>
				</div>
				<div class="col-md-3">
					<input type="text" id="email" name="email" class="form-control">
				</div>
			</div>
		</div>
		<div class="row">
			<div class="form-group">
				<div class="col-md-1">
					<label for="phone" class="control-label">手机号：</label>
				</div>
				<div class="col-md-3">
					<input type="text" id="phone" name="phone" class="form-control">
				</div>
			</div>
		</div>
		
		<div class="row">
			<div class="form-group">4444
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
				<label class="col-md-2" for="sign"></label>
				<div class="com-md-4">
					<button type="submit" id="sign" class="btn btn-primary">注册</button>
				</div>
			</div>
		</div>
		
		
	</form>
	
<script type="text/javascript">
	function checkinput(){
		//登录校验密码不为空
		var password = $("#password").val();//密码
		var name = $("#name").val();//用户名
		
		if(""==password){
			alert("请输入密码！")
			return false;
		}
		if(name==""){
			alert("用户名不能为空!")
			return false;
		}
		return true;
	}
	
</script>	
</body>
</html>