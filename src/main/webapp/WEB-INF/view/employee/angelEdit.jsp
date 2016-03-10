<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">
	<%@ include file="/include.jsp"%>
    <title></title>
</head>
<body>

<div class="easyui-layout" fit="true" data-options="border:false" style="overflow: hidden;">
	<div class="easyui-panel" data-options="region:'center',border:false" >
		<div style="margin-top: 10px;" >
			<form id="dataForm1">
				<input name="version" type="hidden" />
			    <input name="employeeId" type="hidden" />
			    <input name="userId" type="hidden" />
				<div class="fitem">
			    	<label>天使工号:</label>
			        <input name="employeeCode" class="easyui-textbox" readonly="true" />
				</div>
				<div class="fitem">
			    	<label>天使姓名:</label>
			        <input name="employeeName" class="easyui-textbox" data-options="required:true"/>
				</div>	
				<div class="fitem">
			    	<label>天使电话:</label>
			        <input name="employeeTel" class="easyui-numberbox" validType="length[11,11]" readonly="true" invalidMessage="电话号码不正确！" />
				</div>
				<div class="fitem">
			    	<label>天使微信:</label>
			        <input name="openId" class="easyui-textbox" readonly="true" />
				</div>
				
			</form>
			 <div id="dlg-buttons" align="left" style="margin-left: 150px">
       			<a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-ok" id="save" onclick="saveOrUpdate()" style="width:90px">提交</a>
  	 		</div>
		</div>
	</div>
	<!-- <div id="dlg-buttons" region="south" align="left" style="height:35px;padding-top:5px;border:0px">
		<a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-ok" id="save" onclick="saveOrUpdate()" style="width:90px">提交</a>
        <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-cancel" onclick="closeWind()" style="width:90px">取消</a>
	</div> -->
</div>
<script type="text/javascript" >
//获取【列表】全部字典数据[订单类型、订单状态]

jQuery(function(){ 	
	
	jQuery.ajaxSetup({
		cache:false
	});
	var userId = '${userId}';
	if(userId != null && userId != "" &&  userId!=0){
		var url='${rootPath}/employee/getOneAngel?userId='+userId;
		$('#dataForm1').form('load', url);
	}

});

//保存记录
function saveOrUpdate()
{
	var r = $('#dataForm1').form('validate');
	if(!r) {
		return false;
	}
	else
	{		
		$('#save').linkbutton('disable');
		$.post("${rootPath}/employee/save",$("#dataForm1").serializeArray(),
		function(data)
		{			
			if(data.result == 'true' || data.result == true)
			{
			 	$.messager.alert("提示",data.msg,'info');
			}
			else
			{
				$.messager.alert('提示',data.msg,'error');
				$('#save').linkbutton('enable');
			}
		});
	}
}

function closeWind(){
	$('#recommendlog').window('close');
}
 
</script>
</body>
</html>
