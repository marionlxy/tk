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
<div class="easyui-panel" title="XX详细信息编辑" style="width:600px">
	<form id="dataForm">
			<div class="fitem">
		    	<label>subId:</label>
		        <input name="subId" class="easyui-textbox" data-options="required:true">
			</div>
			<div class="fitem">
		    	<label>orderId:</label>
		        <input name="orderId" class="easyui-textbox" data-options="required:true">
			</div>
			<div class="fitem">
		    	<label>orderCode:</label>
		        <input name="orderCode" class="easyui-textbox" data-options="required:true">
			</div>
			<div class="fitem">
		    	<label>subCode:</label>
		        <input name="subCode" class="easyui-textbox" data-options="required:true">
			</div>
			<div class="fitem">
		    	<label>subState:</label>
		        <input name="subState" class="easyui-textbox" data-options="required:true">
			</div>
			<div class="fitem">
		    	<label>subType:</label>
		        <input name="subType" class="easyui-textbox" data-options="required:true">
			</div>
			<div class="fitem">
		    	<label>subPrice:</label>
		        <input name="subPrice" class="easyui-textbox" data-options="required:true">
			</div>
			<div class="fitem">
		    	<label>sellerCode:</label>
		        <input name="sellerCode" class="easyui-textbox" data-options="required:true">
			</div>
			<div class="fitem">
		    	<label>sellerName:</label>
		        <input name="sellerName" class="easyui-textbox" data-options="required:true">
			</div>
			<div class="fitem">
		    	<label>oddnum:</label>
		        <input name="oddnum" class="easyui-textbox" data-options="required:true">
			</div>
			<div class="fitem">
		    	<label>logistics:</label>
		        <input name="logistics" class="easyui-textbox" data-options="required:true">
			</div>
			<div class="fitem">
		    	<label>logisticsCost:</label>
		        <input name="logisticsCost" class="easyui-textbox" data-options="required:true">
			</div>
			<div class="fitem">
		    	<label>appraiseState:</label>
		        <input name="appraiseState" class="easyui-textbox" data-options="required:true">
			</div>
			<div class="fitem">
		    	<label>createdTime:</label>
		        <input name="createdTime" class="easyui-textbox" data-options="required:true">
			</div>
			<div class="fitem">
		    	<label>createdBy:</label>
		        <input name="createdBy" class="easyui-textbox" data-options="required:true">
			</div>
			<div class="fitem">
		    	<label>modifiedTime:</label>
		        <input name="modifiedTime" class="easyui-textbox" data-options="required:true">
			</div>
			<div class="fitem">
		    	<label>modifiedBy:</label>
		        <input name="modifiedBy" class="easyui-textbox" data-options="required:true">
			</div>
			<div class="fitem">
		    	<label>version:</label>
		        <input name="version" class="easyui-textbox" data-options="required:true">
			</div>
			<div class="fitem">
		    	<label>delflag:</label>
		        <input name="delflag" class="easyui-textbox" data-options="required:true">
			</div>
			</form>
    <div id="dlg-buttons" align="center">
       <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-ok" id="save" onclick="saveOrUpdate()" style="width:90px">提交</a>
       <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-cancel" onclick="goBack(0)" style="width:90px">取消</a>
   </div>
</div>
    
<script type="text/javascript">

var rowId;
jQuery(function(){ 

	//初始化下拉框-示例，请根据需要自定义实现
   	/*
   	 $('#combo1').combobox({    
  	        url:'${rootPath}/getDictlist?dicttypeid=userstatus',    
  	        valueField:'dictid',    
  	        textField:'dictname',
  	     	panelHeight:'auto'
  	    }); 
  	  */ 
	
	rowId ='${rowId}';
	
	if (rowId != null && rowId != "" && rowId!=0){
		var url='${rootPath}/orderSub/getOne?rowId=' + rowId;
		$('#dataForm').form('load', url);
	}
});

//保存记录
function saveOrUpdate()
{
	var r = $('#dataForm').form('validate');
	if(!r) {
		return false;
	}
	else
	{		
		$('#save').linkbutton('disable');
		$.post("${rootPath}/orderSub/save",$("#dataForm").serializeArray(),
		function(data)
		{			
			if(data.result == 'true' || data.result == true)
			{
			 	$.messager.show({title:'提示',msg:data.msg,showType:'show'});
				goBack(1);
			}
			else
			{
				$.messager.alert('提示',data.msg,'error');
				$('#save').linkbutton('enable');
			}
		});
	}
}
 
//返回父页面  
function goBack(flag){
	parent.returnParent(flag);
}
</script>

</body>
</html>
