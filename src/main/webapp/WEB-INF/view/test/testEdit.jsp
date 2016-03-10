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
<div class="easyui-panel" title="测试详细信息编辑" style="width:600px">
	<form id="dataForm2">
			<div class="fitem">
					<label>测试序号:</label> <input name="serialId"
						validType="length[0,50]" class="easyui-textbox"
						data-options="required:true">
				</div>
				<div class="fitem">
					<label>排序:</label> <input name="num" validType="length[0,50]"
						class="easyui-textbox" data-options="required:true">
				</div>

				<div class="fitem">
					<label>标题:</label>
					<textarea name="title" style="border: 1px solid #99bbe8;"
						validType="length[0,100]" rows="4" cols="31"
						class="easyui-validatebox" data-options="required:true"></textarea>
				</div>

				<div class="fitem">
					<label>文本:</label>
					<textarea name="text" style="border: 1px solid #99bbe8;"
						validType="length[0,100]" rows="4" cols="31"
						class="easyui-validatebox" data-options="required:true"></textarea>
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
  	jQuery.ajaxSetup({
		cache : false
	});
	rowId ='${rowId}';
	alert(rowId);
	///* 一条查询数据 */
	if (rowId != null && rowId != "" && rowId!=0){
		var url='${rootPath}/test/getOne?rowId=' + rowId;
		$('#dataForm2').form('load', url);
	}
});

//保存记录
function saveOrUpdate()
{
	var r = $('#dataForm2').form('validate');
	if(!r) {
		return false;
	}
	else
	{		
		$('#save').linkbutton('disable');
		$.post("${rootPath}/test/save",$("#dataForm2").serializeArray(),
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
 
/* //返回父页面  
function goBack(flag){
	parent.returnParent(flag);
} */
</script>

</body>
</html>
