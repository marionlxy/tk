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
		    	<label>orderId:</label>
		        <input name="orderId" class="easyui-textbox" data-options="required:true">
			</div>
			<div class="fitem">
		    	<label>orderCode:</label>
		        <input name="orderCode" class="easyui-textbox" data-options="required:true">
			</div>
			<div class="fitem">
		    	<label>orderState:</label>
		        <input name="orderState" class="easyui-textbox" data-options="required:true">
			</div>
			<div class="fitem">
		    	<label>orderType:</label>
		        <input name="orderType" class="easyui-textbox" data-options="required:true">
			</div>
			<div class="fitem">
		    	<label>orderSubType:</label>
		        <input name="orderSubType" class="easyui-textbox" data-options="required:true">
			</div>
			<div class="fitem">
		    	<label>customId:</label>
		        <input name="customId" class="easyui-textbox" data-options="required:true">
			</div>
			<div class="fitem">
		    	<label>customLoginName:</label>
		        <input name="customLoginName" class="easyui-textbox" data-options="required:true">
			</div>
			<div class="fitem">
		    	<label>customName:</label>
		        <input name="customName" class="easyui-textbox" data-options="required:true">
			</div>
			<div class="fitem">
		    	<label>customSex:</label>
		        <input name="customSex" class="easyui-textbox" data-options="required:true">
			</div>
			<div class="fitem">
		    	<label>customTel:</label>
		        <input name="customTel" class="easyui-textbox" data-options="required:true">
			</div>
			<div class="fitem">
		    	<label>customAddress:</label>
		        <input name="customAddress" class="easyui-textbox" data-options="required:true">
			</div>
			<div class="fitem">
		    	<label>customEmail:</label>
		        <input name="customEmail" class="easyui-textbox" data-options="required:true">
			</div>
			<div class="fitem">
		    	<label>customType:</label>
		        <input name="customType" class="easyui-textbox" data-options="required:true">
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
		    	<label>angelLoginName:</label>
		        <input name="angelLoginName" class="easyui-textbox" data-options="required:true">
			</div>
			<div class="fitem">
		    	<label>angelCode:</label>
		        <input name="angelCode" class="easyui-textbox" data-options="required:true">
			</div>
			<div class="fitem">
		    	<label>angelName:</label>
		        <input name="angelName" class="easyui-textbox" data-options="required:true">
			</div>
			<div class="fitem">
		    	<label>angelTel:</label>
		        <input name="angelTel" class="easyui-textbox" data-options="required:true">
			</div>
			<div class="fitem">
		    	<label>angelOpenId:</label>
		        <input name="angelOpenId" class="easyui-textbox" data-options="required:true">
			</div>
			<div class="fitem">
		    	<label>receiverName:</label>
		        <input name="receiverName" class="easyui-textbox" data-options="required:true">
			</div>
			<div class="fitem">
		    	<label>receiverPostcode:</label>
		        <input name="receiverPostcode" class="easyui-textbox" data-options="required:true">
			</div>
			<div class="fitem">
		    	<label>receiverPhone:</label>
		        <input name="receiverPhone" class="easyui-textbox" data-options="required:true">
			</div>
			<div class="fitem">
		    	<label>receiverAddress:</label>
		        <input name="receiverAddress" class="easyui-textbox" data-options="required:true">
			</div>
			<div class="fitem">
		    	<label>site:</label>
		        <input name="site" class="easyui-textbox" data-options="required:true">
			</div>
			<div class="fitem">
		    	<label>payMethod:</label>
		        <input name="payMethod" class="easyui-textbox" data-options="required:true">
			</div>
			<div class="fitem">
		    	<label>invoiceState:</label>
		        <input name="invoiceState" class="easyui-textbox" data-options="required:true">
			</div>
			<div class="fitem">
		    	<label>invoiceName:</label>
		        <input name="invoiceName" class="easyui-textbox" data-options="required:true">
			</div>
			<div class="fitem">
		    	<label>invoiceContent:</label>
		        <input name="invoiceContent" class="easyui-textbox" data-options="required:true">
			</div>
			<div class="fitem">
		    	<label>orderPrice:</label>
		        <input name="orderPrice" class="easyui-textbox" data-options="required:true">
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
		    	<label>payBy:</label>
		        <input name="payBy" class="easyui-textbox" data-options="required:true">
			</div>
			<div class="fitem">
		    	<label>payTime:</label>
		        <input name="payTime" class="easyui-textbox" data-options="required:true">
			</div>
			<div class="fitem">
		    	<label>cancelBy:</label>
		        <input name="cancelBy" class="easyui-textbox" data-options="required:true">
			</div>
			<div class="fitem">
		    	<label>cancelTime:</label>
		        <input name="cancelTime" class="easyui-textbox" data-options="required:true">
			</div>
			<div class="fitem">
		    	<label>createSubBy:</label>
		        <input name="createSubBy" class="easyui-textbox" data-options="required:true">
			</div>
			<div class="fitem">
		    	<label>createSubTime:</label>
		        <input name="createSubTime" class="easyui-textbox" data-options="required:true">
			</div>
			<div class="fitem">
		    	<label>sendBy:</label>
		        <input name="sendBy" class="easyui-textbox" data-options="required:true">
			</div>
			<div class="fitem">
		    	<label>sendTime:</label>
		        <input name="sendTime" class="easyui-textbox" data-options="required:true">
			</div>
			<div class="fitem">
		    	<label>editSendBy:</label>
		        <input name="editSendBy" class="easyui-textbox" data-options="required:true">
			</div>
			<div class="fitem">
		    	<label>editSendTime:</label>
		        <input name="editSendTime" class="easyui-textbox" data-options="required:true">
			</div>
			<div class="fitem">
		    	<label>takeBy:</label>
		        <input name="takeBy" class="easyui-textbox" data-options="required:true">
			</div>
			<div class="fitem">
		    	<label>takeTime:</label>
		        <input name="takeTime" class="easyui-textbox" data-options="required:true">
			</div>
			<div class="fitem">
		    	<label>rejectBy:</label>
		        <input name="rejectBy" class="easyui-textbox" data-options="required:true">
			</div>
			<div class="fitem">
		    	<label>rejectTime:</label>
		        <input name="rejectTime" class="easyui-textbox" data-options="required:true">
			</div>
			<div class="fitem">
		    	<label>refundBy:</label>
		        <input name="refundBy" class="easyui-textbox" data-options="required:true">
			</div>
			<div class="fitem">
		    	<label>refundTime:</label>
		        <input name="refundTime" class="easyui-textbox" data-options="required:true">
			</div>
			<div class="fitem">
		    	<label>completeBy:</label>
		        <input name="completeBy" class="easyui-textbox" data-options="required:true">
			</div>
			<div class="fitem">
		    	<label>completeTime:</label>
		        <input name="completeTime" class="easyui-textbox" data-options="required:true">
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
		var url='${rootPath}/order/getOne?rowId=' + rowId;
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
		$.post("${rootPath}/order/save",$("#dataForm").serializeArray(),
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
