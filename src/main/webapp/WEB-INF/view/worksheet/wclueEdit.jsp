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
<div class="easyui-panel"  style="width:100%;height: 100%">
	<form id="dataForm"> 
			<input type="hidden" name="version">
			<input type="hidden" name="clueId">
			<input type="hidden" name="clueCode">
			<input type="hidden" name="clueState">
			<input type="hidden" name="customId">
			<input type="hidden" name="worksheetId">
			<input type="hidden" name="site">
				<h3 style="color: red">客户信息：</h3>
			<div class="fitem">
		    	<label>客户电话:</label>
		        <input name="customTel" class="easyui-textbox" validType="length[0,50]" readonly="true">
			</div>
			<div class="fitem">
		    	<label>客户姓名:</label>
		        <input name="customName" class="easyui-textbox" validType="length[0,50]" readonly="true">
			</div>
			<div class="fitem">
		    	<label>客户性别:</label>
		    	<input class="easyui-combobox" name="customSex" style="width:90px" panelHeight="auto"
				 	url="${rootPath}/getDictCombox?dictType=SEX_TYPE" valueField="dictId" textField="dictName" readonly="true">
<!-- 		        <input name="customSex" class="easyui-textbox" validType="length[0,50]" readonly="true"> -->
			</div>
			<div class="fitem">
		    	<label>客户地址:</label>
		        <input name="customAddress" class="easyui-textbox" validType="length[0,50]" readonly="true">
			</div>
			
			<div class="fitem">
		    	<label>客户需求:</label>
		    		<textarea   name="customRequire" class="easyui-validatebox validatebox-text validatebox-invalid" validtype="length[0,4000]" cols="31" rows="4" style=" border:1px solid #99bbe8;" readonly="true" title=""></textarea>
			</div>
<!-- 			<div class="fitem"> -->
<!-- 		    	<label>无效原因:</label> -->
<!-- 		        <input name="invalidReason" class="easyui-textbox" disabled="disabled"> -->
<!-- 			</div> -->
<!-- 			</div> -->
				<div class="fitem">
		    	<label>上门时间:</label>
		        <input name="doorTime" class="easyui-textbox"  style="width:205px" readonly="true">
			</div>
			<h3 style="color: red">天使信息：</h3>
				<div class="fitem">
		    	<label>天使编号:</label>
		        <input   id="angelCodes" class="easyui-textbox"  style="width:200px;" disabled="disabled" >
		        <input id="angelCode" name="angelCode" type="hidden">
			</div>
				<div class="fitem">
			    	<label>天使姓名:</label>
			           <input class="easyui-combobox"  id="angelName" editable="editable" name="angelName" style="width:200px;" panelHeight="auto"
			        url="${rootPath}/worksheet/getAngelList" valueField="angelName" textField="angelName" data-options="required:true"/>
				</div>
				<div class="fitem">
		    	<label>天使电话:</label>
		        <input  id="angelTels" class="easyui-textbox"  style="width:200px;" disabled="disabled"  >
		        <input  id="angelTel" name="angelTel" type="hidden" >
			</div>
			<h3 style="color: red">代理人信息：</h3>
			<div class="fitem">
		    	<label>代理人电话:</label>
		        <input name="proxyTel" class="easyui-textbox" validType="length[0,20]" readonly="true">
			</div>
			<div class="fitem">
		    	<label>备注:</label>
		    	<textarea   name="remark" class="easyui-validatebox validatebox-text validatebox-invalid" validtype="length[0,200]" cols="31" rows="4" style=" border:1px solid #99bbe8;" name="sellerAddress" title=""></textarea>
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
	jQuery.ajaxSetup({
		cache : false
	});
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
	//获取天使信息
	$('#angelName').combobox({
		onSelect:function(data){
			$('#angelCode').val(data.angelCode);
			$('#angelCodes').textbox('setValue',data.angelCode);
			$('#angelTels').textbox('setValue',data.angelTel);
			$('#angelTel').val(data.angelTel);
		}
	});
	
	
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
		$.post("${rootPath}/worksheet/weditSave",$("#dataForm").serializeArray(),
		function(data)
		{			
			if(data.result == 'true' || data.result == true)
			{
				$.messager.alert("提示", data.msg);
				goBack(1);
			}
			else
			{
				$.messager.alert("提示", data.msg);
				$('#save').linkbutton('enable');
			}
		});
	}
}
 
 //获取天使编号，
 function angelCode(){
	 $("#angelName")
 }
</script>

</body>
</html>
