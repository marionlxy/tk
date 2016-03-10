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
	<form id="dataForm21" >
		<input type="hidden" name="mealId">
		<input type="hidden" name="version">
		<input type="hidden" name="state">
		<div class="fitem">
	    	<label>套餐编号:</label>
	        <input name="mealCode" class="easyui-textbox" disabled>
		</div>
		<div class="fitem">
	    	<label>套餐名称:</label>
	        <input name="mealName" class="easyui-textbox" validType="length[0,50]" required="required" disabled>
		</div>
		<div class="fitem">
	    	<label>套餐价格:</label>
	    	<input name="mealPrice" class="easyui-numberbox" validType="length[0,14]" invalidMessage="价格不能大于10位" data-options="required:true,groupSeparator:',',decimalSeparator:'.',min:0,precision:2,prefix:'￥'">
		</div>
		<div class="fitem">
	    	<label>站点:</label>
	    	<input class="easyui-combobox" id="site" name="site" style="width:100px" required="required" panelHeight="auto"
		 	url="${rootPath}/getDictCombox?dictType=SITE" valueField="dictId" textField="dictName" disabled>
		</div>
	</form>
    <div id="dlg-buttons" align="center">
       <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-ok" id="save" onclick="saveOrUpdate()" style="width:90px">发布上架</a>
       <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-cancel" onclick="goBack()" style="width:90px">取消</a>
   </div>
</div>
    
<script type="text/javascript">

var mealId;
jQuery(function(){ 
	// 注意：不要读取缓存
	jQuery.ajaxSetup({
		cache : false
	});
	
	mealId ='${mealId}';
	if (mealId != null && mealId != "" && mealId!=0){
		var url='${rootPath}/fixed/getOneMeal?mealId=' + mealId;
		$('#dataForm21').form('load', url);
	}
});

//保存记录
function saveOrUpdate()
{
	var r = $('#dataForm21').form('validate');
	if(!r) {
		return false;
	}
	else
	{		
		$('#save').linkbutton('disable');
		$.post("${rootPath}/fixed/saveShelves",$("#dataForm21").serializeArray(),
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
