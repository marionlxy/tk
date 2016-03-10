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
	<form id="dataForm">
		    <input type="hidden" name="parkId" />
			<div class="fitem">
		    	<label>园区名称:</label>
		        <input name="parkName" class="easyui-textbox" data-options="required:true" disabled>
			</div>
			<div class="fitem">
		    	<label>园区编号:</label>
		        <input name="parkCode" class="easyui-textbox" data-options="required:true" disabled>
			</div>
			<div class="fitem">
		    	<label>园区介绍:</label>
		        <input name="parkContent" class="easyui-textbox" data-options="required:true" disabled>
			</div>
			</form>
    <div id="dlg-buttons" align="center">
       <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-cancel" onclick="goBack(0)" style="width:90px">返回</a>
   </div>
    
<script type="text/javascript">

var parkId ='${parkId}';

jQuery(function(){ 
	// 注意：不要读取缓存
	jQuery.ajaxSetup({
		cache : false
	});

	if (parkId != null && parkId != "" && parkId !=0){
		var url='${rootPath}/cemeteryPark/getOne?parkId=' + parkId;
		$('#dataForm').form('load', url);
	}
});

//返回父页面  
function goBack(){
	$('#divDialog').window('close');
}
</script>

</body>
</html>
