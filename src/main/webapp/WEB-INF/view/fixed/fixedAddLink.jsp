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
	<br>
	<form id="dataForm3" style="padding-left: 50px">
		<div class="fitem">
		<input type="hidden" name="mealId">
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
       <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-ok" id="save1" onclick="saveOrUpdate1()" style="width:90px">提交</a>
       <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-cancel" onclick="goBack(1)" style="width:90px">取消</a>
   </div>
</div>
    
<script type="text/javascript">
var mealId;
jQuery(function(){ 
	
	jQuery.ajaxSetup({
		cache : false
	});
	
});

//保存记录
function saveOrUpdate1()
{
	var r = $('#dataForm3').form('validate');
	mealId='${mealId}';
	if(!r) {
		return false;
	}
	else
	{		
		$('#save1').linkbutton('disable');
		$.post("${rootPath}/fixed/saveLink?mealId="+mealId,$("#dataForm3").serializeArray(),
		function(data)
		{			
			if(data.result == 'true' || data.result == true)
			{	var linkId;
				linkId = data.linkId;
			 	$.messager.alert("提示", data.msg);
				goBacks(5,linkId);
			}
			else
			{
				$.messager.alert("提示", data.msg);
				$('#save1').linkbutton('enable');
			}
		});
	}
}
 
//返回父页面  
// function goBack(flag){
// 	parent.returnParent(flag);
// }
</script>

</body>
</html>
