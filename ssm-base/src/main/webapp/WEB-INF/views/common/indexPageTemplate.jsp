<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/common/common_header.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript">
	var PAGE_REST_URL = '${pageConfig.restUrl}' ;//页面全局变量，传递给后面的js使用
	var PAGE_PROC_URL = GLOBAL_APP_PATH + PAGE_REST_URL;
	var PAGE_CODE = '${code}';
	
</script>

<script type="text/javascript" src="${APP_PATH}/static/js/common/indexPageTemplate.js?version=<%=Math.random()%>"></script>
<title>${pageConfig.indexTitle }</title>
</head>
<body>
	<!-- 新增界面 start-->
	<div class="modal fade" tabindex="-1" role="dialog" id="ui_add">
	  <div class="modal-dialog" role="document">
	    <div class="modal-content">
	      <div class="modal-header">
	        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
	        <h4 class="modal-title">新增</h4>
	      </div>
	      <div class="modal-body">
	      		<!-- 表单 -->
	        	<form class="form-horizontal">
				  
				</form>
	      </div>
	      <div class="modal-footer">
	        <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
	        <button type="button" class="btn btn-primary" id="ui_add_btn_ok">确定</button>
	      </div>
	    </div><!-- /.modal-content -->
	  </div><!-- /.modal-dialog -->
	</div><!-- /.modal -->
	<!-- 新增界面end -->
	
	
	<!-- 修改界面 start-->
	<div class="modal fade" tabindex="-1" role="dialog" id="ui_update">
	  <div class="modal-dialog" role="document">
	    <div class="modal-content">
	      <div class="modal-header">
	        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
	        <h4 class="modal-title">编辑</h4>
	      </div>
	      <div class="modal-body">
	      		<!-- 表单 -->
	        	<form class="form-horizontal" id="ui_update_form">
	        	<!--  
				  <div class="form-group">
				    <label for="userName" class="col-sm-2 control-label">用户名</label>
				    <div class="col-sm-10">
				      <input type="text" class="form-control" id="ui_add_input_userName" name="userName" placeholder="请输入用户名">
				      <span  class="help-block"></span>
				    </div>
				  </div>
				  <div class="form-group">
				    <label for="password" class="col-sm-2 control-label">密码</label>
				    <div class="col-sm-10">
				      <input type="password" class="form-control" id="ui_add_input_password" name="password" placeholder="请输入密码">
				    </div>
				  </div>
				  
				  <div class="form-group">
				    <label for="性别" class="col-sm-2 control-label">性别</label>
				    <div class="col-sm-10">
					      <div class="radio-inline">
							  <label><input type="radio" name="gendar" id="gendar" value="M" checked>男</label>
						  </div>
						  <div class="radio-inline">
							  <label><input type="radio" name="gendar" id="gendar" value="F">女</label>
						  </div>
				    </div>
				  </div>
				  
				  <div class="form-group">
				    <label for="mail" class="col-sm-2 control-label">邮箱</label>
				    <div class="col-sm-10">
				      <input type="text" class="form-control" id="ui_add_input_email" name="email" placeholder="test@abc.com">
				      <span  class="help-block"></span>
				    </div>
				  </div>
				  
				  <div class="form-group">
				    <label for="所属部门" class="col-sm-2 control-label">所属部门</label>
				    <div class="col-sm-4">
					      <select class="form-control" name="deptId" id="ui_add_select_deptId">
							  
						  </select>
				    </div>
				  </div>
				  -->
				  
				  
				</form>
	      </div>
	      <div class="modal-footer">
	        <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
	        <button type="button" class="btn btn-primary" id="ui_update_btn_ok">确定</button>
	      </div>
	    </div><!-- /.modal-content -->
	  </div><!-- /.modal-dialog -->
	</div><!-- /.modal -->
	<!-- 修改界面end -->


	<div class="container">
		<div class="row">
			<div class="col-md-12"><h1><a href="${pageContext.request.contextPath}/sysmgr/main">首页</a> ${pageConfig.indexTitle }</h1></div>
		</div>
		
		<div class="row">
			<div class="col-md-4 col-md-offset-8">
				<button class="btn btn-primary" id="btn_add">新增</button>
				<button class="btn btn-danger" id="btn_delete">删除</button>
			</div>
		</div>
		
		<div class="row">
			<div class="col-md-12">
				<table class="table table-hover" id="table_list">
					<thead>
						<tr id="grid-header">
							<!--  
							<th>
								 <label class="checkbox-inline"><input type="checkbox" id="checkAll">全选</label>
							</th>
							<th>#</th>
							<th>用户名</th>
							<th>性别</th>
							<th>邮箱</th>
							<th>创建时间</th>
							<th>操作</th>
							-->
						</tr>
					</thead>
					<tbody>
					</tbody>
					
				</table>
			</div>
		</div>
		
		<div class="row">
			<div class="col-md-6" id="page_info">
				<!-- 分页结果信息 -->
			</div>
			<div class="col-md-6" id="page_nav">
				<!-- 分页导航栏 -->
			
			</div>
		</div>
	
	</div>
	
	<script type="text/javascript">
	    
		$(function(){
			initPage(1);
			bindEvent();
		});	
		
		function colProcFunForGendar(colValue){
			return colValue=='M'?'男':'女';
		}
		
	</script>
</body>
</html>