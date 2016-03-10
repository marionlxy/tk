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
<div class="easyui-layout" fit="true" data-options="border:false" style="overflow: auto;">
	<div class="easyui-panel" data-options="region:'center',border:false" >
	<div style="margin-top: 10px;" align="center">
		<form id="dataForm1">
			<input name="version" type="hidden" />
			<input name="employeeId" type="hidden" />
  			<input name="userId" type="hidden" />
   			<input name="openId" type="hidden"/> 
			<div class="fitem">
				<label>代理人工号:</label>
				<input name="employeeCode" class="easyui-textbox" disabled="true" />
			</div>
			<div class="fitem">
   				<label>代理人姓名:</label>
       			<input name="employeeName" class="easyui-textbox" disabled="true" />
			</div>
			<div class="fitem">
   				<label>代理推荐人:</label>
       			<input class="easyui-textbox" name="recommendCode"  disabled="true"/>
			</div>
		</form>
	</div>
 	</div>
	<div id="dlg-buttons" region="south" align="center" style="height:35px;padding-top:5px;border:0px">
		<a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-cancel" onclick="closeWind()" style="width:90px">取消</a>
	</div>
</div>
<script type="text/javascript" >
//获取【列表】全部字典数据[订单类型、订单状态]

jQuery(function(){ 	
	
	jQuery.ajaxSetup({
		cache:false
	});
	var employeeCode = '${employeeCode}';
	if(employeeCode != null && employeeCode != "" && employeeCode!=0){
		var url='${rootPath}/employee/getOne?employeeCode='+employeeCode;
		$('#dataForm1').form('load', url);
	}

});



function closeWind(){
	$('#recommendlog').window('close');
}
 
</script>

</body>
</html>
