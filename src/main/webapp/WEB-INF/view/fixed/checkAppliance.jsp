<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">
	<%@ include file="/include.jsp"%>
    <title>添加固定套餐</title>
    
</head>
<body>
<div>
	<form id="dataForm5">
		<table id="dataTable5" title="用品列表" style="height: 560%">
		</table>
		<input id="flag" type="hidden" />
		<input id="linkId" type="hidden" value="${linkId}"/>
	<div id="divDialog"></div>
	</form>
    <div id="dlg-buttons" align="center">
       <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-ok" id="save3" onclick="saveOrUpdate3()" style="width:90px">确定</a>
       <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-cancel" onclick="goBack(2)" style="width:90px">取消</a>
   </div>
</div>
    
<script type="text/javascript">
jQuery(function(){	  
	jQuery.ajaxSetup({
		cache : false
	});
	site ='${flag}';
	//初始化用品列表
   	$('#dataTable5').datagrid({
   		iconCls:'icon-tip',
   		singleSelect : false,
   		rownumbers:true,
   		pagination:true,
   		fitColumns:true,
   		url : '${rootPath}/fixed/applianceList?site='+site,
   		method : 'post',		
		idField : 'APPLIANCE_ID',//此处根据实际情况进行填写
		columns:[[
						{field : 'APPLIANCE_ID',checkbox : true},
						{field:'CATEGORY_ID',title:'用品分类',width:80,hidden:true},
						{field:'QUALITY_VALUE_ID',title:'属性值ID',width:80,hidden:true},
						{field:'SKUID',title:'SKUID',width:80,hidden:true},
						{field:'APPLIANCE_CODING',title:'用品编号',width:80 },
						{field:'APPLIANCE_NAME',title:'用品名称',width:80 },
						{field:'APPLIANCE_SETTLE_PRICE',title:'用品结算价',width:80 ,hidden:true},
						{field:'APPLIANCE_MARKETPRICE',title:'用品销售价',width:80 ,hidden:true},
						{field:'SELLER_NAME',title:'商户名称',width:80,hidden:true },
						{field:'SITE',title:'站点',width:80,hidden:true },
						{field:'APPLIANCE_CATEGORY_ID',title:'用品类别ID',width:80 ,hidden:true},
						{field:'ISMARKETABLE',title:'是否上架',width:80 ,hidden:true},
						{field:'IS_RETURN_BILLS',title:'是否允许退货',width:80 ,hidden:true},
						{field:'INTERFLOW_PRICE',title:'物流费',width:80 ,hidden:true},
						
						{field:'CREATED_TIME',title:'创建日期',width:80,hidden:true},
						{field:'MODIFIED_TIME',title:'修改日期',width:80,hidden:true},
						{field:'VERSION',title:'版本',width:80,hidden:true},
						{field:'DELFLAG',title:'删除标记',width:80,hidden:true}
					//注：最后一行后面的逗号要去掉
	]],
	onLoadSuccess : function(data) {
		$('#dataTable5').datagrid('clearSelections'); //一定要加上这一句，要不然datagrid会记住之前的选择状态，删除时会出问题
	}
 });
	
});


function saveOrUpdate3()
{
	var r = $('#dataForm5').form('validate');
	if(!r) {
		return false;
	}
	else
	{	
		var linkId = $('#linkId').val();
		var applianceId = "";
		$('input[name=APPLIANCE_ID]:checked').each(
				function(i){
					applianceId += $(this).val() + ",";
			});
		applianceId = applianceId.substr(0,applianceId.length-1);
	
		$('#save3').linkbutton('disable');
		$.post("${rootPath}/fixed/saveLinkServer?applianceId="+applianceId+"&linkId="+linkId,$("#dataForm5").serializeArray(),
		function(data)
		{			
			if(data.result == 'true' || data.result == true)
			{
			 	$.messager.alert("提示", data.msg);
				goBack(2);
			}
			else
			{
				$.messager.alert("提示", data.msg);
				$('#save3').linkbutton('enable');
			}
		});
	}
}





</script>

</body>
</html>
