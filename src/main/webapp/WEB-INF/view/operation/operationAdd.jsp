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
	<form id="dataForm" >
		<%--<div class="fitem">
	    	<label>投诉编号:</label>
	        <input name="complain_num" class="easyui-textbox" disabled>
		</div> --%>
		<input type="hidden" name="complainId">
		<div class="fitem">
	    	<label>投诉人姓名:</label>
	        <input name="complainName" class="easyui-textbox" validType="length[0,50]" required="required">
		</div>
		<div class="fitem">
	    	<label>投诉人电话:</label>
	        <input name="complainTel" class="easyui-textbox" validType="length[0,30]" required="required">
		</div>
		<div class="fitem">
	    	<label>投诉内容:</label>
<!-- 	        <input name="complainMsg" class="easyui-textbox" validType="length[0,30]" required="required"> -->
                <textarea name="complainMsg" style=" border:1px solid #99bbe8;"  rows="4" cols="33" required="required"></textarea>
		</div>
<!-- 		<div class="fitem"> -->
<!-- 	    	<label>投诉状态:</label> -->
<!-- 	    	<input class="easyui-combobox" name="complainState" style="width:100px" required="required" panelHeight="auto" -->
<%-- 		 	url="${rootPath}/getDictCombox?dictType=complainstage" valueField="dictId" textField="dictName"> --%>
<!-- 		</div> -->
		<div class="fitem">
	    	<label>投诉类型:</label>
	    	<input class="easyui-combobox" name="complainType" style="width:100px" required="required" panelHeight="auto"
		 	url="${rootPath}/getDictCombox?dictType=type" valueField="dictId" textField="dictName">
		</div>		
	</form>
    <div id="dlg-buttons" align="center">
       <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-ok" id="save" onclick="saveOrUpdate()" style="width:90px">确定</a>
       <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-cancel" onclick="returnParent(1)" style="width:90px">取消</a>

   </div>
</div>
    
<script type="text/javascript">

jQuery(function(){ 
	
	jQuery.ajaxSetup({
		cache : false
	});
	
// 	$('#site').combobox({
//         url:'${rootPath}/getDictCombox?dictType=kemu1',    
//         valueField:'dictId',    
//         textField:'dictName',
//         panelWidth: 100,
//         panelHeight:'auto'
//  }); 
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
		$.post("${rootPath}/operation/save",$("#dataForm").serializeArray(),
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
// function goBack(flag){
// 	parent.returnParent(flag);
// }
</script>

</body>
</html>
