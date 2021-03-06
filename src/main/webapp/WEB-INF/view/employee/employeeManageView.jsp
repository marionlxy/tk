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
	<form id="dataForm">
		<input type="hidden" name="employeeId">
		<input type="hidden" name="userId">
		<input type="hidden" name="version">
		<div class="fitem">
	    	<label>员工姓名:</label>
	        <input name="employeeName" class="easyui-textbox" validType="length[0,50]" required="required" data-options="required:true,validType: ['unnormal']  " disabled="true" >
		</div>		
<!-- 		<div class="fitem"> -->
<!-- 		<label>商户类型:</label> -->
<!-- 		<input class="easyui-combobox" name="sellerType" value="1" style="width:100px" editable="editable" required="required" panelHeight="auto" -->
<%-- 				 	url="${rootPath}/getDictCombox?dictType=MultiState" valueField="dictId" textField="dictName"> --%>
<!-- 		</div> -->
		<div class="fitem">
	    	<label>手机号:</label>
	        <input name="employeeTel" class="easyui-textbox" validType="length[0,30]" required="required" data-options="required:true,validType: ['phoneAndMobile']  " disabled="true" >
		</div>		
		<div class="fitem">
	    	<label style="vertical-align:top;">所在地址:</label>
			<textarea name="employeeAddress" style=" border:1px solid #99bbe8;"  rows="4" cols="31" class="easyui-validatebox" validType="length[0,200]" disabled="true" ></textarea>
		</div>
		<div class="fitem">
		    	<label>性别:</label>
		        <input class="easyui-combobox" name="employeeSex" style="width:90px" editable="editable"  panelHeight="auto"
				 	url="${rootPath}/getDictCombox?dictType=SEX_TYPE" valueField="dictId" textField="dictName" disabled="true" >
			
			</div>
		<div class="fitem">
	    	<label>站点:</label>
			<input class="easyui-combobox" name="site" value=" " style="width:100px" editable="editable" required="required" panelHeight="auto"
		 	url="${rootPath}/getDictCombox?dictType=SITE" valueField="dictId" textField="dictName" disabled="true">
<!-- 	    	<input class="easyui-combobox" id="site" name="site" value="001" style="width:100px" required="required"> -->
		</div>
<!-- 		<div class="fitem"> -->
<!-- 	    	<label>登录名:</label> -->
<!-- 	        <input name="loginName" class="easyui-textbox" validType="length[0,30]" required="required" data-options="required:true,validType: ['username']  "> -->
<!-- 		</div> -->
<!-- 		<div class="fitem"> -->
<!-- 	    	<label>初始密码:</label> -->
<!-- 	        <input name="loginInitPwd" type="password" class="easyui-textbox" validType="length[0,30]" required="required" data-options="required:true,validType: ['unnormal']  "> -->
<!-- 		</div> -->
	</form>
    <div id="dlg-buttons" align="center">
<!--        <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-ok" id="save" onclick="saveOrUpdate()" style="width:90px">提交</a> -->
       <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-cancel" onclick="goBack()" style="width:90px">取消</a>
   </div>
</div>
    
<script type="text/javascript">
var employeeId;
jQuery(function(){ 
	
	jQuery.ajaxSetup({
		cache : false
	});
	
	employeeId ='${employeeId}';
	
	if (employeeId != null && employeeId != "" && employeeId!=0){
		var url='${rootPath}/employeeManage/getOne?employeeId=' + employeeId;
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
		$.post("${rootPath}/employeeManage/save",$("#dataForm").serializeArray(),
		function(data)
		{			
			if(data.result == 'true' || data.result == true)
			{
// 			 	$.messager.show({title:'提示',msg:data.msg,showType:'show'});
			 	$.messager.alert("提示",data.msg);
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
</script>

</body>
</html>
