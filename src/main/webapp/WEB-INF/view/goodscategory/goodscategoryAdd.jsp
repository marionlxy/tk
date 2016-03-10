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
	    	<label>分类编码:</label>
	        <input name="categoryCode" class="easyui-textbox easyui-validatebox" data-options="validType:['cateCode','length[0,50]']"
	          required="required">
		</div>
		<div class="fitem">
	    	<label>分类名称:</label>
	        <input name="categoryName" class="easyui-textbox" validType="length[0,50]" required="required">
		</div>
		<div class="fitem">
	    	<label>排序:</label>
	        <input name="sort" class="easyui-textbox" validType="length[0,50]" required="required">
		</div>
		<div class="fitem">
	    	<label>路径:</label>
	        <input  class="easyui-textbox" value="${treePath}" validType="length[0,100]"  disabled="disabled" >
	         <input name="treePath"  value="${treePath}" type="hidden">
		</div>
	</form>
    <div id="dlg-buttons" align="center">
       <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-ok" id="save" onclick="saveOrUpdate()" style="width:90px">提交</a>
       <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-cancel" onclick="goBack()" style="width:90px">取消</a>
   </div>
</div>
    
<script type="text/javascript">

jQuery(function(){ 
	
// 	$('#site').combobox({
//         url:'${rootPath}/getDictCombox?dictType=kemu1',    
//         valueField:'dictId',    
//         textField:'dictName',
//         panelWidth: 100,
//         panelHeight:'auto'
//  }); 
	$.extend($.fn.validatebox.defaults.rules, {    
	    cateCode: {    
	        validator: function(value){ 
	        	var cateReg=/^[0-9]*$/;
	            return cateReg.test(value);    
	        },    
	        message: '分类编码必须是数字'   
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
		$.post("${rootPath}/goodscategory/save",$("#dataForm").serializeArray(),
		function(data)
		{			
			if(data.result == 'true' || data.result == true)
			{
			 	$.messager.alert("提示","菜单添加成功！");
				goBack(1);
			}
			else
			{
				$.messager.alert("提示", '菜单添加失败 ！');
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
