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
			<input type="hidden" name="cemeteryId" />
			<div class="fitem">
		    	<label>园区名称:</label>
		        <input name="parkName" validType="length[0,50]" class="easyui-textbox" data-options="required:true">
			</div>
			<div class="fitem">
		    	<label>园区介绍:</label>
		    	<textarea name="parkContent" validType="length[0,200]" style="border:1px solid #99bbe8;" data-options="required:true"  rows="4" cols="31" class="easyui-validatebox"  ></textarea>
			</div>
			</form>
    <div id="dlg-buttons" align="center">
       <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-ok" id="saveCP" onclick="saveOrUpdateCP()" style="width:90px">提交</a>
       <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-cancel" onclick="goBack(2)" style="width:90px">关闭</a>
   </div>
    
<script type="text/javascript">

var cemeteryId = '${cemeteryId}';

jQuery(function(){ 
	
	jQuery.ajaxSetup({
		cache : false
	});
	// 上传按钮事件

});

//保存记录
function saveOrUpdateCP()
{
	
	var r = $('#dataForm').form('validate');
	if(!r) {
		return false;
	}
	else
	{		
// 		$('#save').linkbutton('disable');
		$.post("${rootPath}/cemeteryPark/save?cemeteryId="+cemeteryId,$("#dataForm").serializeArray(),
		function(data)
		{			
			if(data.result == 'true' || data.result == true)
			{	
				$.messager.alert("提示", data.msg);
				goBack(2);
			}
			else
			{
				$.messager.alert("提示", data.msg);
				$('#saveCP').linkbutton('enable');
			}
		});
	}
}
 
</script>

</body>
</html>
