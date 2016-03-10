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
<div>
	<form id="dataForm14">
		<input type="hidden" name="linkId">
		<input type="hidden" name="mealId">
		<input type="hidden" name="version">
		<div class="fitem">
	    	<label>环节编号:</label>
	        <input name="linkCode" class="easyui-textbox" disabled>
		</div>
		<div class="fitem">
	    	<label>环节名称:</label>
	        <input name="linkName" class="easyui-textbox" validType="length[0,50]" required="required">
		</div>
		<div class="fitem">
	    	<label>环节序号:</label>
	        <input name="linkNum" class="easyui-textbox" validType="length[0,50]" required="required">
		</div>
		<div class="fitem">
	    	<label>阶段:</label>
	        <input name="stage" class="easyui-textbox" validType="length[0,50]" required="required">
		</div>

	</form>
    <div id="dlg-buttons" align="center">
       <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-ok" id="save6" onclick="saveOrUpdate6()" style="width:90px">提交</a>
       <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-cancel" onclick="goBack(6)" style="width:90px">取消</a>
   </div>
</div>
    
<script type="text/javascript">

var linkId;
jQuery(function(){ 
	// 注意：不要读取缓存
	jQuery.ajaxSetup({
		cache : false
	});
	
	linkId ='${linkId}';
	if (linkId != null && linkId != "" && linkId!=0){
		var url='${rootPath}/fixed/getOneLink?linkId=' + linkId;
		$('#dataForm14').form('load', url);
	}
});

//保存记录
function saveOrUpdate6()
{
	var r = $('#dataForm14').form('validate');
	if(!r) {
		return false;
	}
	else
	{		
		$('#save6').linkbutton('disable');
		$.post("${rootPath}/fixed/saveLink",$("#dataForm14").serializeArray(),
		function(data)
		{			
			if(data.result == 'true' || data.result == true)
			{
			 	$.messager.alert("提示", data.msg);
				goBack(7);
			}
			else
			{
				$.messager.alert("提示", data.msg);
				$('#save6').linkbutton('enable');
			}
		});
	}
}
 
</script>

</body>
</html>
