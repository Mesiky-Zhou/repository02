<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/common/common_header.jsp" %>  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<link rel="stylesheet" href="${APP_PATH }/static/css/index.css" />
<title>首页</title>
</head>
<body>
<!--  
	<h1>
		<button class="btn btn-success">确定</button>
		<button type="button" class="btn btn-success">（成功）Success</button>
	</h1>
	-->
	<center>
		<h2></h2>
		<a href="${pageContext.request.contextPath}/user/list1">用户管理1</a>
		<a href="${pageContext.request.contextPath}/sysmgr/common/goIndex/userIndex">用户管理</a>
			
<!--		
<div class="alert alert-warning alert-dismissible" role="alert">
  <button type="button" class="close" data-dismiss="alert" aria-label="Close"><span aria-hidden="true">&times;</span></button>
  <strong>Warning!</strong> Better check yourself, you're not looking too good.
</div>
-->	
	</center>
	
<div class="row" style="margin-top:30px;">
<div class="col-md-6" style="border-right:1px solid #ddd;">
<div class="well col-md-10">
<h3>用户登录</h3>
<div class="input-group input-group-md">
<span class="input-group-addon" id="sizing-addon1"><i class="glyphicon glyphicon-user" aria-hidden="true"></i></span>
<input type="text" class="form-control" placeholder="用户名" aria-describedby="sizing-addon1">
</div>
<div class="input-group input-group-md">
<span class="input-group-addon" id="sizing-addon1"><i class="glyphicon glyphicon-lock"></i></span>
<input type="password" class="form-control" placeholder="密码" aria-describedby="sizing-addon1">
</div>
<div class="well well-sm" style="text-align:center;">
<input type="radio" name="kind" value="tea"> 老师
<input type="radio" name="kind" value="stu"> 学生
</div>
<button type="submit" class="btn btn-success btn-block">
登录
</button>
</div>
</div>
<div class="col-md-6">
<h3>
欢迎使用学生作业管理系统
</h3>
<ul>
<li>学生使用<em>学号</em>登录，初始密码为<em>6个1</em>，登录后请及时修改密码</li>
<li>老师请使用<em>工号</em>登录，初始密码为<em>6个1</em>，登录后请及时修改密码</li>
</ul>
</div>
</div>


</body>
</html>