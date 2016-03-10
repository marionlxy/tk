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
<div class="easyui-panel"  style="width:100%;height:100%">
	<form id="dataForm"> 
			<input type="hidden" name="version">
			<input type="hidden" name="clueId">
			<div class="fitem">
		    	<label>线索编号:</label>
		        <input name="clueCode" class="easyui-textbox" disabled="disabled">
			</div>
			<div class="fitem">
		    	<label>客户姓名:</label>
		        <input name="customName" class="easyui-textbox" validType="length[0,50]" disabled="disabled">
			</div>
			<div class="fitem">
		    	<label>客户性别:</label>
<!-- 		        <input name="customSex" class="easyui-textbox" validType="length[0,50]" disabled="disabled"> -->
			    <input class="easyui-combobox" name="customSex" style="width:80px" panelHeight="auto"
		 	url="${rootPath}/getDictCombox?dictType=SEX_TYPE" valueField="dictId" textField="dictName" disabled="disabled">
			</div>
			<div class="fitem">
		    	<label>客户电话:</label>
		        <input name="customTel" class="easyui-numberbox" validType="length[11,11]" disabled="disabled">
			</div>
				<div class="fitem">
		    	<label>上门时间:</label>
		        <input name="doorTime" class="easyui-datetimebox"  style="width:205px" disabled="disabled">
			</div>
			<div class="fitem">
		    	<label>客户地址:</label>
		        <input name="customAddress" class="easyui-textbox" validType="length[0,50]" disabled="disabled" >
			</div>
			
			<div class="fitem">
		    	<label>代理人电话:</label>
		        <input name="proxyTel" class="easyui-numberbox" >
			</div>
			<div class="fitem">
		    	<label>客户需求:</label>
		    	<textarea   name="customRequire" class="easyui-validatebox validatebox-text validatebox-invalid" disabled="disabled" validtype="length[0,4000]" cols="31" rows="4" style=" border:1px solid #99bbe8;" title=""></textarea>
<!-- 		        <input name="customRequire" class="easyui-textbox" validType="length[0,50]" disabled="disabled"> -->
			</div>
		
			<div class="fitem">
		    	<label>备注:</label>
		    	<textarea   name="remark" class="easyui-validatebox validatebox-text validatebox-invalid" disabled="disabled" validtype="length[0,200]" cols="31" rows="4" style=" border:1px solid #99bbe8;"  title=""></textarea>
<!-- 		        <input name="remark" class="easyui-textbox" validType="length[0,200]" disabled="disabled"> -->
			</div>
				<div class="fitem">
		    	<label>无效原因:</label>
		    	<textarea   name="invalidReason" class="easyui-validatebox validatebox-text validatebox-invalid"  validtype="length[0,200]" cols="31" rows="4" style=" border:1px solid #99bbe8;"  title=""></textarea>
<!-- 		        <input name="invalidReason" class="easyui-textbox" > -->
			</div>
			</form>
    <div id="dlg-buttons" align="center">
       <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-ok" id="save" onclick="saveOrUpdate()" style="width:90px">提交</a>
       <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-cancel" onclick="goBack(0)" style="width:90px">取消</a>
   </div>
</div>
    
<script type="text/javascript">

var clueId;
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
  	// 注意：不要读取缓存
  	jQuery.ajaxSetup({
  		cache : false
  	});
  	clueId ='${clueId}';
	
	if (clueId != null && clueId != "" && clueId!=0){
		var url='${rootPath}/clue/getOne?clueId=' + clueId;
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
		$.post("${rootPath}/clue/del",$("#dataForm").serializeArray(),
		function(data)
		{			
			if(data.result == 'true' || data.result == true)
			{
// 			 	$.messager.show({title:'提示',msg:data.msg,showType:'show'});
				$.messager.alert("提示", data.msg);
				goBack(1);
			}
			else
			{
// 				$.messager.alert('提示',data.msg,'error');
				$.messager.alert("提示", data.msg);
				$('#save').linkbutton('enable');
			}
		});
	}
}
 
//返回父页面  
// function goBack(){
// 	$('#dataForm').dialog('close')
// }
</script>

</body>
</html>
