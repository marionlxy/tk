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
		<div class="fitem">
	    	<label>属性值名称:</label>
	        <input name="qualityValueName" class="easyui-textbox" validType="length[0,50]" required="required">
		</div>
		<div class="fitem">
	    	<label>排序:</label>
	        <input name="sort" class="easyui-textbox" validType="length[0,50]" required="required">
		</div>
		<div class="fitem">
	    	<label>属性名选择:</label>
	    	 <select name="qualityId" class="easyui-combobox" panelHeight="auto" style="width:100px" required="required"> 
				<c:forEach  items="${qualitymeasureList}" var="entity" varStatus="s">
				    <option value="${entity.QUALITY_ID}">${entity.QUALITY_NAME}</option>
				</c:forEach>
			  </select> 
		</div>
	</form>
    <div id="dlg-buttons" align="center">
       <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-ok" id="save" onclick="saveOrUpdate()" style="width:90px">提交</a>
       <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-cancel" onclick="goBack()" style="width:90px">取消</a>
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
		$.post("${rootPath}/qualityvalue/save",$("#dataForm").serializeArray(),
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
