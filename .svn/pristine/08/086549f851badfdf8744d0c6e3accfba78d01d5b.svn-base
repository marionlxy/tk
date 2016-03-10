<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">
	<%@ include file="/include.jsp"%>
    <title>添加服务</title>
    
</head>
<body>
<div>
	<form id="dataForm16">
		<table id="dataTable16" title="服务列表" >
		</table>
		<input name="flag" type="hidden" />
		<input id="linkId" type="hidden" value="${linkId}"/>
	<div id="divDialog"></div>
	</form>
	<br>
    <div id="dlg-buttons" align="center">
       <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-ok" id="save3" onclick="saveOrUpdate3()" style="width:90px">确定</a>
       <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-cancel" onclick="goBack(3)" style="width:90px">取消</a>
   </div>
</div>
    
<script type="text/javascript">
var site;
jQuery(function(){	  
	jQuery.ajaxSetup({
		cache : false
	});
	site ='${flag}';
	//初始化用品列表
 	$('#dataTable16').datagrid({
   		iconCls:'icon-tip',
   		singleSelect : true,
   		rownumbers:true,
   		pagination:true,
   		fitColumns:true,
   		url:'${rootPath}/fixed/serviceList?site='+site,
   		method : 'post',		
		idField : 'SERVICE_ID',//此处根据实际情况进行填写
		columns:[[
						{field :'SERVICE_ID',checkbox : true},
						{field:'SERVICE_NUM',title:'服务编码',width:80},
						{field:'SERVICE_NAME',title:'服务名称',width:80},
						{field:'SITE',title:'站点',width:80,hidden:true },
	
					//注：最后一行后面的逗号要去掉
	]],
	onLoadSuccess : function(data) {
		$('#dataTable16').datagrid('clearSelections'); //一定要加上这一句，要不然datagrid会记住之前的选择状态，删除时会出问题
	}
 });
	
});


function saveOrUpdate3()
{
	var r = $('#dataForm16').form('validate');
	if(!r) {
		return false;
	}
	else
	{	
		var linkId = $('#linkId').val();
		var serviceId = "";
		$('input[name=SERVICE_ID]:checked').each(
				function(i){
					serviceId = $(this).val();
			});
	
		$('#save2').linkbutton('disable');
		$.post("${rootPath}/fixed/saveLinkService?serviceId="+serviceId+"&linkId="+linkId,$("#dataForm16").serializeArray(),
		function(data)
		{			
			if(data.result == 'true' || data.result == true)
			{
			 	$.messager.alert("提示", data.msg);
				goBack(3);
			}
			else
			{
				$.messager.alert("提示", data.msg);
				$('#save2').linkbutton('enable');
			}
		});
	}
}





</script>

</body>
</html>
