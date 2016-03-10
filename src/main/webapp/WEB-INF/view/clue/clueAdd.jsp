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
<div  class="easyui-panel"  style="width:100%;height:100%">
	<form id="dataForm">
		<input type="hidden" name="version">
		<input type="hidden" name="clueId">
<!-- 		<div class="fitem"> -->
<!-- 		    	<label>线索编号:</label> -->
<!-- 		        <input name="clueCode" class="easyui-textbox"  > -->
<!-- 			</div> -->
			<div class="fitem">
		    	<label>客户姓名:</label>
		        <input name="customName" class="easyui-textbox" validType="length[0,50]" required="required" missingMessage="客户姓名不能为空">
			</div>
			<div class="fitem">
		    	<label>客户性别:</label>
		        <input class="easyui-combobox" name="customSex" style="width:90px" editable="editable"  panelHeight="auto"
				 	url="${rootPath}/getDictCombox?dictType=SEX_TYPE" valueField="dictId" textField="dictName">
			
			</div>
			<div class="fitem">
		    	<label>站点:</label>
		        <input name="site" class="easyui-combobox" data-options="required:true" style="width:90px" panelHeight="auto"
		        url="${rootPath}/getDictCombox?dictType=SITE" valueField="dictId" textField="dictName"editable="editable" >
			</div>
			<div class="fitem">
		    	<label>客户电话:</label>
		        <input name="customTel" class="easyui-numberbox" validType="length[11,11]" required="required" missingMessage="客户电话不能为空">
			</div>
			<div class="fitem">
		    	<label>客户地址:</label>
		        <input name="customAddress" class="easyui-textbox" validType="length[0,50]" required="required" missingMessage="客户地址不能为空">
			</div>
				<div class="fitem">
		    	<label>上门时间:</label>
<!-- 		        <input name="doorTime" class="easyui-textbox" > -->
				<input class="easyui-datetimebox"  name="doorTime" style="width:205px">
			</div>
			<div class="fitem">
		    	<label>代理人电话:</label>
		        <input id="proxyTel" name="proxyTel" class="easyui-numberbox"  validType="length[11,11]" >
			</div>
			<div class="fitem">
		    	<label>客户需求:</label>
		    	<textarea   name="customRequire" class="easyui-validatebox validatebox-text validatebox-invalid" validtype="length[0,4000]" cols="31" rows="4" style=" border:1px solid #99bbe8;width: 201px;"title="" ></textarea>
			</div>
			<div class="fitem">
		    	<label>备注:</label>
		    	<textarea   name="remark" class="easyui-validatebox validatebox-text validatebox-invalid" validtype="length[0,200]" cols="31" rows="4" style=" border:1px solid #99bbe8;width: 201px;"  title="" ></textarea>
			</div>
		
			
	</form>
    <div id="dlg-buttons" align="center">
       <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-ok" id="save" onclick="saveOrUpdate()" style="width:90px">提交</a>
       <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-cancel" onclick="goBack(1)" style="width:90px">取消</a>
   </div>
</div>
    
<script type="text/javascript">
var flog = true;
jQuery(function(){ 
	
	jQuery.ajaxSetup({
		cache : false
	});
	$('#proxyTel').numberbox({onChange:confirmPrefer});
});
//ajax判断代理人电话是否存在
function confirmPrefer(){
	var proxyTel = $("#proxyTel").val();
	if(proxyTel == null && proxyTel == "" ){
		return ;
	}else{
		
	URL="${rootPath}/clue/proxyTelCheck";
    $.ajax({  
        async:false,  
        cache:false,  
        type: 'POST',  
        data:$('#dataForm').serialize(),// 你的formid
        dataType : "json",  
        url:URL, 
       success : function(date) { //请求成功后处理函数。 
    	   var eva = eval(date);
       if(eva[0].id <=0){
    	   alert("代理人不存在!");
    	   flog = false;
       }
		   
       }, 
       error : function() {//请求失败处理函数
//            alert('代理人不存在！');
           flog = false;
       }
   });
	}
 
}
//保存记录
function saveOrUpdate(){
	var proxyTel = $("#proxyTel").val();
	if(proxyTel == null || proxyTel == "" ){
		flog = true ;
	}
	var r = $('#dataForm').form('validate');
	if(flog == false){
// 		alert("代理人不存在");
		return;
	}
		if(!r) {
			return false;
		}
		else
		{		
			$('#save').linkbutton('disable');
			$.post("${rootPath}/clue/save",$("#dataForm").serializeArray(),
			function(data){			
				if(data.result == 'true' || data.result == true){
				 	$.messager.alert("提示", data.msg);
					goBack(1);
				}
					else{
						$.messager.alert("提示", data.msg);
						$('#save').linkbutton('enable');
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
