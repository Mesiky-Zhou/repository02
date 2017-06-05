/**
 * 
 */

//定义页面全局变量
var totalRecord;//总记录数
var currentPage;//当前页面
var selectRowId;//当前选择行的ID
var selectRowData = [];//当前选择的行

function bindEvent(){
	$("#btn_add").click(function(){
		open_ui_add();
	});
	
	$("#btn_delete").click(function(){
		batchDelete();
	});
	
	$("#ui_add_btn_ok").click(function(){
		save_and_close('ui_add',PAGE_PROC_URL,'POST');
	});
	
	$("#ui_update_btn_ok").click(function(){
		save_and_close('ui_update',PAGE_PROC_URL + '/'+selectRowId,'PUT');
	});
}

function initPage(pageNo){
	getRequest(PAGE_PROC_URL,{'pageNo':pageNo},buildPage);
	currentPage = pageNo;
}
function buildPage(result){
	buildPageListHeader(result);
	buildPageList(result);
	buildPageNav(result);
}
function buildPageListHeader(result){
	
	var gridConfig = result.dataMap.pageConfig.gridConfig;
	
	var header = $("#grid-header");
	header.empty();
	
	var checkAllTh = $("<th><label class='checkbox-inline'><input type='checkbox' id='checkAll'>全选</label></th>");
	header.append(checkAllTh);
	$.each(gridConfig.nCols, function(index,item){
		
		var colTh = $("<th></th>").append(item);
		header.append(colTh);
	});
	var operTh = $("<th></th>").append("操作");
	header.append(operTh);
}
function buildPageList(result){
	var users = result.dataMap.pageInfo.list;
	var gridConfig = result.dataMap.pageConfig.gridConfig;
	var gridConfig_colProcFuns = gridConfig.colProcFuns;
	//先清空数据
	$("#table_list tbody").empty();
	
	$.each(users, function(index, item){
		var tr = $("<tr></tr>");
		
		var checkTd = $("<td></td>").append("<input type='checkbox' value='"+ item.id + "' class='checkItem'/>");
		tr.append(checkTd);
		
		/* var idTd = $("<td></td>").append(item.id);
		var userNameTd = $("<td></td>").append(item['userName']);
		var gendar = item.gendar=="M"?"男":"女";
		var gendarTd = $("<td></td>").append(gendar);
		var emailTd = $("<td></td>").append(item.email);
		var createTimeTd = $("<td></td>").append(item.createTime); */
		$.each(gridConfig.pCols,function(index,pName){
			var jsStr = "var colValue = " + gridConfig_colProcFuns[index] +"('" + item[pName] + "')";
			$.globalEval(jsStr);
			var colTd = $("<td></td>").append(colValue);
			tr.append(colTd);
		});
		
		
		/**
		<td><fmt:formatDate value="${user.createTime}" pattern="yyyy-MM-dd HH:mm:ss" /></td>
		<button class="btn btn-primary btn-sm">
						<span class="glyphicon glyphicon-pencil" aria-hidden="true"></span>
						编辑
					</button>
					<button class="btn btn-danger btn-sm">
						<span class="glyphicon glyphicon-trash" aria-hidden="true"></span>
						删除
					</button>
		*/
		var editBtn = $("<button></button>").addClass("btn btn-primary btn-sm")
					  .append($("<span></span>").addClass("glyphicon glyphicon-pencil").attr("aria-hidden","true"))
					  .append("编辑");
		var delBtn = $("<button></button>").addClass("btn btn-danger btn-sm")
					  .append($("<span></span>").addClass("glyphicon glyphicon-trash").attr("aria-hidden","true"))
					  .append("删除");
		var btnTd = $("<td></td>").append(editBtn).append("  ").append(delBtn);
		
		
		tr.append(btnTd);
		tr.attr("id","trId_" + item.id);
		tr.appendTo("#table_list tbody");
		/* tr.append(checkTd)
		.append(idTd)
		.append(userNameTd)
		.append(gendarTd)
		.append(emailTd)
		.append(createTimeTd)
		.append(btnTd)
		.appendTo("#table_list tbody"); */
		
		
		//每行编辑按钮绑定事件
		editBtn.click(function(){
			initSelectRowData(item.id);
			open_ui_update();
		});
		
		//每行删除按钮绑定事件
		delBtn.click(function(){
			initSelectRowData(item.id);
			deleteRequest(PAGE_PROC_URL + '/'+item.id,{},function(result){
				alert(result.desc);
				initPage(currentPage);
			});
		});
		
		//每行记录单击绑定事件
		tr.click(function(){
			initSelectRowData(item.id);
		});
		//每行记录双击绑定事件
		tr.dblclick(function(){
			var rowData = getSelectRow();
			alert(rowData[0] + '==' + rowData[1] + '==' + rowData[2] + '==' + rowData[3]);
		});
				
	});
	
	
	//全选绑定事件
	$("#checkAll").click(function(){
		$(".checkItem").prop("checked",$(this).prop("checked"));
	});
}
function buildPageNav(result){
	var pageInfo = result.dataMap.pageInfo;
	/**
	<div class="col-md-6">
		第${pageInfo.pageNum }页，共${pageInfo.pages }页，共${pageInfo.total }条记录
	</div>
	*/
	//先清空数据
	$("#page_info").empty();
	$("#page_info").append("第"+pageInfo.pageNum+"页，共"+pageInfo.pages+"页，共"+pageInfo.total+"条记录");
	
	totalRecord = pageInfo.total;
	
	/**
			<nav aria-label="Page navigation">
			  <ul class="pagination">
			    <li><a href="">首页</a></li>
			    
				<li>
				  <a href="" aria-label="Previous">
					<span aria-hidden="true">&laquo;</span>
				  </a>
				</li>
			   
			    <li class="active"><a href="#">1</a></li>
			    <li><a href="">1</a></li>


			    <li>
				      <a href="" aria-label="Next">
				        <span aria-hidden="true">&raquo;</span>
				      </a>
			    </li>

			    <li><a href="">末页</a></li>
			  </ul>
			</nav>
	*/
	//先清空数据
	$("#page_nav").empty();
	
	var nav = $("<nav></nav>").attr("aria-label","Page navigation");
	var ul = $("<ul></ul>").addClass("pagination");
	
	var firstPageLi = $("<li></li>").append($("<a></a>").append("首页").attr("href","#"));
	var prePageLi = $("<li></li>").append($("<a></a>").append(
						$("<span></span").attr("aria-hidden","true").append("&laquo;")	
					).attr("aria-label","Previous").attr("href","#"));
	if(!pageInfo.hasPreviousPage){
		firstPageLi.addClass("disabled");
		prePageLi.addClass("disabled");
	}else{
		firstPageLi.click(function(){initPage(1);});
		prePageLi.click(function(){initPage(pageInfo.pageNum - 1);});
	}
	
	
	var nextPageLi = $("<li></li>").append($("<a></a>").append(
						$("<span></span").attr("aria-hidden","true").append("&raquo;")	
					).attr("aria-label","Next").attr("href","#"));
	var lastPageLi =  $("<li></li>").append($("<a></a>").append("末页").attr("href","#"));
	if(!pageInfo.hasNextPage){
		nextPageLi.addClass("disabled");
		lastPageLi.addClass("disabled");
	}else{
		nextPageLi.click(function(){initPage(pageInfo.pageNum+1);});
		lastPageLi.click(function(){initPage(pageInfo.pages);});
	}
	
	
	
	ul.append(firstPageLi).append(prePageLi);
	$.each(pageInfo.navigatepageNums, function(index, item){
		var numLi = $("<li></li>").append($("<a></a>").append(item).attr("href","#"));
		if(item == pageInfo.pageNum){
			numLi.addClass("active");
		}
		numLi.click(function(){
			initPage(item);
		});
		ul.append(numLi);
	});
	ul.append(nextPageLi).append(lastPageLi);
	
	nav.append(ul);
	
	$("#page_nav").append(nav);
}


function initSelectRowData(dataId){
	selectRowId = dataId;
	var tds = $('#trId_' + selectRowId).children("td");
	for(var i=0;i<tds.length;i++){
		selectRowData[i] = tds.eq(i).text();
	}
}
function getSelectRow(){
	return selectRowData;
}

function batchDelete(){
	var idArr = getCheckIds();
	if(idArr.length<=0){
		alert("请至少选择1条记录！");
	}else{
		var ids = '';
		for(var i=0;i<idArr.length;i++){
			ids = ids +  idArr[i] + '-';
		}
		ids = ids.substring(0, ids.length-1);
		
		if(confirm('确认删除选择记录吗？')){
			deleteRequest(PAGE_PROC_URL+'/'+ids,{},function(result){
				alert(result.desc);
				initPage(currentPage);
			});
		}
	}
}

//获取所有的选择的ID
function getCheckIds(){
	var ids = [];
	var checks = $("#table_list tbody").find(".checkItem:checked");
	$.each(checks, function(index, item){
		ids[index] = $(item).val();
	});
	
	return ids;
}


//新增或修改点确定时的处理逻辑
function save_and_close(uiId, procUrl,requestMethod){
	if(!validate_form()){
		return  false;
	}
	
	//var formData = $("#"+ uiId +" form").serialize();
	var formData = formSerialize2Json("#"+ uiId +" form");
	request(requestMethod, procUrl,formData,false,function(result){
		alert(result.desc);
		$("#" + uiId).modal('hide');
		initPage(currentPage);
	});
}

//点击新增按钮弹出框
function open_ui_add(){
	//清空表单内容及样式
	$("#ui_add form")[0].reset();
	$("#ui_add form").find("*").removeClass("has-success has-error");
	$("#ui_add form").find(".help-block").text("");
	
	init_ui_add();
	$("#ui_add").modal({backdrop:'static'});
}
function init_ui_add(){
	getRequest(GLOBAL_APP_PATH+'/sysmgr/common/getPageConfig/userIndex',{},function(result){
		var addConfig = result.dataMap.pageConfig.addConfig;
		build_ui_add(null,addConfig);
	});
}
function build_ui_add(bean, addConfig){
	$("#ui_add form").empty();
	$.each(addConfig.nCols, function(index,item){
		var formEle = getFormEle(bean, item,addConfig.pCols[index],addConfig.types[index],addConfig.others[index],'ui_add');
		$("#ui_add form").append(formEle);
	});
}




//点编辑按钮弹出框
function open_ui_update(){
	//清空表单内容及样式
	$("#ui_update form")[0].reset();
	$("#ui_update form").find("*").removeClass("has-success has-error");
	$("#ui_update form").find(".help-block").text("");
	
	init_ui_update();
	$("#ui_update").modal({backdrop:'static'});
}
function init_ui_update(){
	getRequest(PAGE_PROC_URL+'/' + selectRowId,{},function(result){
		var bean = result.dataMap.bean;
		var updateConfig = result.dataMap.pageConfig.updateConfig;
		
		build_ui_update(bean,updateConfig);
	});
}
function build_ui_update(bean, updateConfig){
	$("#ui_update form").empty();
	$.each(updateConfig.nCols, function(index,item){
		var formEle = getFormEle(bean, item,updateConfig.pCols[index],updateConfig.types[index],updateConfig.others[index],'ui_update');
		$("#ui_update form").append(formEle);
	});
}

function getFormEle(bean, nCol,pCol,type,others,formEleIdPrefix){
	var eleStr;
	if(type=='text'){
		/*<div class="form-group">
		    <label for="userName" class="col-sm-2 control-label">用户名</label>
		    <div class="col-sm-10">
		      <input type="text" class="form-control" id="ui_add_input_userName" name="userName" placeholder="请输入用户名">
		      <span  class="help-block"></span>
		    </div>
		  </div>*/
		var ph = parseOthers(others)['ph'];
		var eleValue = "";
		if(bean!=null){
			eleValue = bean[pCol];
		}
		eleStr = "<div class='form-group'><label for='"+pCol+"' class='col-sm-2 control-label'>"+nCol+"</label>"
				+  "<div class='col-sm-10'>"
				+  "<input type='text' class='form-control' id='"+ formEleIdPrefix +"_input_"+pCol+"' name='"+pCol+"' placeholder='"+ ph +"' value='"+ eleValue +"'>"
		      	+  "<span  class='help-block'></span>"
		      	+  "</div>"
		      + "</div>";
		
	}else if(type=='password'){
		/*<div class="form-group">
	    <label for="password" class="col-sm-2 control-label">密码</label>
	    <div class="col-sm-10">
	      <input type="password" class="form-control" id="ui_add_input_password" name="password" placeholder="请输入密码">
	    </div>
	  </div>*/
		var ph = parseOthers(others)['ph'];
		var eleValue = "";
		if(bean!=null){
			eleValue = bean[pCol];
		}
		eleStr = "<div class='form-group'><label for='"+pCol+"' class='col-sm-2 control-label'>"+nCol+"</label>"
					+ "<div class='col-sm-10'>"
					+ "<input type='password' class='form-control' id='"+ formEleIdPrefix +"_input_"+pCol+"' name='"+pCol+"' placeholder='"+ph+"' value='"+ eleValue +"'>"
	      			+ "</div>"
	      		+ "</div>";
	}else if(type=='radio'){
		/*<div class="form-group">
		    <label for="性别" class="col-sm-2 control-label">性别</label>
		    <div class="col-sm-10">
			      <div class="radio-inline">
					  <label><input type="radio" name="gendar" id="gendar" value="M" checked>男</label>
				  </div>
				  <div class="radio-inline">
					  <label><input type="radio" name="gendar" id="gendar" value="F">女</label>
				  </div>
		    </div>
		  </div>*/
		eleStrHead = "<div class='form-group'>"
						+"<label for='"+pCol+"' class='col-sm-2 control-label'>"+nCol+"</label>"
						+"<div class='col-sm-10'>";
		var kvJson = parseRadio(parseOthers(others).kv);
		var eleStrMid = "";
		var isFirst = false;
		for(var key in kvJson){
			if(bean!=null && (kvJson[key] == bean[pCol])){
				isFirst = true;
			}
			eleStrMid = eleStrMid
							+"<div class='radio-inline'>"
								+"<label><input type='radio' name='"+pCol+"' id='"+ formEleIdPrefix +"_radio_"+ pCol + "_" + kvJson[key] + "' value='"+kvJson[key]+"' "+ (isFirst?"checked":"") +">"+key+"</label>"
							+"</div>"; 
			isFirst = false;
		}
		eleStrTail =     "</div>"
				     +"</div>";
		
		eleStr = eleStrHead + eleStrMid + eleStrTail;
		
	}else if(type=='select'){
		/*<div class="form-group">
		    <label for="所属部门" class="col-sm-2 control-label">所属部门</label>
		    <div class="col-sm-4">
			      <select class="form-control" name="deptId" id="ui_add_select_deptId">
					  
				  </select>
		    </div>
		  </div>*/
		eleStrHead = "<div class='form-group'>"
					+"<label for='所属部门' class='col-sm-2 control-label'>所属部门</label>"
					+" <div class='col-sm-4'>"
						+"  <select class='form-control' name='"+ pCol +"' id='"+ formEleIdPrefix +"_select_"+ pCol +"'>";
		
		eleStrMid = "<option value='-1'>-请选择-</option>";
		os = parseOthers(others);
		getRequest(GLOBAL_APP_PATH+os.url,{'async':false},function(result){
			var itemList = result.dataMap.list;
			
			$.each(itemList,function(index, item){
				var selectStr = '';
				if(bean!=null && (bean[pCol] == item[os.value])){
					selectStr = "selected='selected'";
				}
				eleStrMid = eleStrMid + "<option value='"+ item[os.value] +"' "+ selectStr +">"+ item[os.text] +"</option>";
			});
		});
					  
		eleStrTail		+"  </select>"
					 +"</div>"
				+"</div>";
		
		eleStr = eleStrHead + eleStrMid + eleStrTail;
	}
	
	return $(eleStr);
}


function validate_form(){
	/*var userName = $("#ui_add_input_userName").val();
	var email = $("#ui_add_input_email").val();
	if(userName.length>6 || userName.length<3){
		show_validate_msg("#ui_add_input_userName", false, "用户名最少3位最长6位！");
		return false;
	}else{
		show_validate_msg("#ui_add_input_userName", true, "");
	}*/
	
	return true;
}
function show_validate_msg(ele, status, msg){
	$(ele).parent().removeClass("has-success has-error");
	$(ele).next("span").text("");
	if(!status){
		$(ele).parent().addClass("has-error");
	}else{
		$(ele).parent().addClass("has-success");
	}
	$(ele).next("span").text(msg);
}

function parseOthers(others){
	var result = {};
	var othersStr = others.substring(1,others.length-1);
	var arr1 = othersStr.split("&");
	for(var i=0;i<arr1.length;i++){
		var arr2 = arr1[i].split("=");
		result[arr2[0]] = arr2[1];
	}
	
	return result;
}

function parseRadio(radioStr){
	//kv=男-M@女-F
	var result = {};
	var arr1 = radioStr.split("@");
	for(var i=0;i<arr1.length;i++){
		var arr2 = arr1[i].split("-");
		result[arr2[0]] = arr2[1];
	}
	
	return result;
}


