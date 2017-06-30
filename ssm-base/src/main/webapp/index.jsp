<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/common/common_header.jsp" %> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<link rel="stylesheet" href="${APP_PATH }/static/css/index.css" />
	<title>Develop System</title>
</head>
<body>
	
<div class="row" style="margin-top:30px;">
	
	<div class="col-md-12">
		<div class="col-md-4">
        </div>
        
		<div class="well col-md-4">
			<h3>用户登录</h3>
			<div class="input-group input-group-md">
				<span class="input-group-addon" id="sizing-addon1"><i class="glyphicon glyphicon-user" aria-hidden="true"></i></span>
				<input id="input_userName" type="text" class="form-control" placeholder="用户名" aria-describedby="sizing-addon1">
			</div>
			<div class="input-group input-group-md">
				<span class="input-group-addon" id="sizing-addon1"><i class="glyphicon glyphicon-lock"></i></span>
				<input id="input_password"  type="password" class="form-control" placeholder="密码" aria-describedby="sizing-addon1">
			</div>
			
			<button id="btn_login" type="button" class="btn btn-success btn-block">登录</button>
		</div>
		
		<div class="col-md-4">
        </div>
	</div>
</div>

</center>
</body>

<script type="text/javascript">
    
$(function(){
	bindEvent();
});	

function bindEvent(){
	$("#btn_login").click(function(){
		login();
	});
}

function login(){
	var userName = $('#input_userName').val();
	var password = $('#input_password').val();
	if(userName == ''){
		alert('用户名不能为空!');
		return ;
	}
	if(password == ''){
		alert('密码不能为空!');
		return ;
	}
	
	getRequest(GLOBAL_APP_PATH+'/sysmgr/login',{"userName":userName, "password":password},function(result){
		var code = result.code;
		if(code==1){
			window.location.href = GLOBAL_APP_PATH + "/sysmgr/main";
		}else{
			alert(result.desc);
		}
	});
	
	
}
	
</script>
</html>