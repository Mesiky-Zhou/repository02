/**
 * 
 */
//WEB应用上下文
var GLOBAL_APP_PATH;


function request(reqMethod, urlStr,reqData,isAsync,successFun,errorFun){
	if(reqMethod == 'PUT'){
		reqData['_method'] = 'PUT';
		reqMethod = 'POST';
	}else if(reqMethod == 'DELETE'){
		reqData['_method'] = 'DELETE';
		reqMethod = 'POST';
	}
	$.ajax({
		url:urlStr,
		type:reqMethod,
		async:isAsync,
		data:reqData,
		cache:false,
		success:successFun,
		error:errorFun
	});
}

function getRequest(urlStr,reqData,successFun,errorFun){
	var isAsync = true;
	if(reqData != undefined && reqData['async']!=undefined){
		isAsync = reqData['async'];
	}
	request('GET', urlStr,reqData,isAsync,successFun,errorFun);
}

function getRequestSync(urlStr,reqData,successFun,errorFun){
	var isAsync = false;
	request('GET', urlStr,reqData,isAsync,successFun,errorFun);
}

function postRequest(urlStr,reqData,successFun,errorFun){
	request('POST', urlStr,reqData,true,successFun,errorFun);
}

function putRequest(urlStr,reqData,successFun,errorFun){
	request('PUT', urlStr,reqData,true,successFun,errorFun);
}

function deleteRequest(urlStr,reqData,successFun,errorFun){
	request('DELETE', urlStr,reqData,true,successFun,errorFun);
}


function formSerialize2Json(formEleStr){
	var o = {};
	/*序列化为字符串$("#"+ uiId +" form").serialize();
	通过$("#form").serializeArray()输出以数组形式序列化表单值。

	[ 
	  {name: 'firstname', value: 'Hello'}, 
	  {name: 'lastname', value: 'World'},
	  {name: 'alias'}, // 值为空
	]*/
	var a = $(formEleStr).serializeArray();
	$.each(a, function() {
		if (o[this.name] !== undefined) {
			if (!o[this.name].push) {
				o[this.name] = [o[this.name]];
			}
			o[this.name].push(this.value || '');
		} else {
			o[this.name] = this.value || '';
		}
	});
	return o;
};

//初始化下拉选择的数据
/* 参考：$.ajax({
url:'${APP_PATH}/sysmgr/dept/service/listWithNoPage',
type:'GET',
cache:false,
success:function(result){
	var deptList = result.dataMap.list;
	$("#ui_add_select_deptId").empty();
	$("#ui_add_select_deptId").append($("<option></option>").append('-请选择-').attr("value",-1));
	$.each(deptList,function(index, item){
		$("#ui_add_select_deptId").append($("<option></option>").append(item.name).attr("value",item.id));
	});
}
}); */
////初始化部门
//initSelect('ui_add_select_deptId', '${APP_PATH}/sysmgr/dept/service/listWithNoPage','name', 'id');
function initSelect(selectEleId, urlStr,key, value ,reqData){
	getRequest(urlStr,reqData,function(result){
		var itemList = result.dataMap.list;
		$("#" + selectEleId).empty();
		$("#" + selectEleId).append($("<option></option>").append('-请选择-').attr("value",-1));
		$.each(itemList,function(index, item){
			$("#" + selectEleId).append($("<option></option>").append(item[key]).attr("value",item[value]));
		});
	});
}

function gridColProcFun(colValue){
	return colValue;
}

