<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/common/common_header.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Develop System 首页</title>
</head>
<body>
	<div class="container">
		<div class="row">
			<div class="col-md-12">
				<div class="col-md-8">
					<h1>Develop System 首页
				</div>
				<div class="col-md-4">
					<h2> 您好，${_loginInfo.infos.user.userName } <a id="a_logOut" href="#">退出</a></h2>
				</div>
			</div>
		 </div>
        
        <nav class="navbar navbar-inverse">
            <div class="navbar-collapse">
                <ul class="nav navbar-nav">
                    <li class="active"><a href="#">Home</a></li>
                    <li><a href="${pageContext.request.contextPath}/common/goIndex/userIndex">用户管理</a></li>
                    <li><a href="#">运维流程</a></li>
                </ul>
            </div>
            
        
            
        </nav>
    </div>
</body>
<script type="text/javascript">
$(function(){
	bindEvent();
});	

function bindEvent(){
	$("#a_logOut").click(function(){
		logout();
	});
}

function logout(){
	getRequest(GLOBAL_APP_PATH+'/sysmgr/logout',{},function(result){
		var code = result.code;
		if(code==1){
			window.location.href = GLOBAL_APP_PATH + "/index.jsp";
		}else{
			alert(result.desc);
		}
	});
}
</script>


<!--  
	<h1>
		<button class="btn btn-success">确定</button>
		<button type="button" class="btn btn-success">（成功）Success</button>
	</h1>
	
	<center>
		<h2></h2>
		<a href="${pageContext.request.contextPath}/user/list1">用户管理1</a>
		<a href="${pageContext.request.contextPath}/common/goIndex/userIndex">用户管理</a>
			
		
<div class="alert alert-warning alert-dismissible" role="alert">
  <button type="button" class="close" data-dismiss="alert" aria-label="Close"><span aria-hidden="true">&times;</span></button>
  <strong>Warning!</strong> Better check yourself, you're not looking too good.
</div>
-->	

</html>