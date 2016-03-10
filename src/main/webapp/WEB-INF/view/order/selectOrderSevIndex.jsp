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
<div class="easyui-layout" fit="true" data-options="border:false">
	<div data-options="region:'center',border:false" style="overflow: hidden;">
		<table id="sellerTab" title="服务商列表" style="height:100%;" >
   		</table>    
	</div>
</div>
<script type="text/javascript">
	var serviceNum = '${serviceNum}';
	var serviceId = '${serviceId}';
	var linkId = '${linkId}';
	jQuery(function(){	  
		jQuery.ajaxSetup({
			cache : false
		});
   	//初始化列表
   	$('#sellerTab').datagrid({
   		singleSelect : true,
   		rownumbers:true,
   		pagination:true,
   		fitColumns:true,
   		url:'${rootPath}/single/orderSevList?serviceId='+serviceId+"&serviceNum="+serviceNum,
   		method : 'post',		
		idField : 'SELLER_CODE',//此处根据实际情况进行填写
		columns:[[
          			{field:'ck',checkbox:true},
					{field:'SELLER_CODE',title:'服务商编号',width:80},
					{field:'SELLER_NAME',title:'服务商姓名',width:50}
		]],
		toolbar:[{
			id:'btnadd',
			text:'选择服务商',
			iconCls:'icon-add',
			handler:function(){
				selectSev();
			}
		}],
		
		onLoadSuccess : function(data) {
			$('#sellerTab').datagrid('clearSelections'); //一定要加上这一句，要不然datagrid会记住之前的选择状态，删除时会出问题
		}
	});
   	
   });

	

   //选择服务商
   function selectSev(){
   		var row = $('#sellerTab').datagrid('getSelected');
   		if(linkId == "undefined"){
   			linkId = "";
			}
   		if(!row){
   			$.messager.alert('提示','请选择服务商','info');
   			return ;
   		}else{
   			
	   		$.post('${rootPath}/orderSev/saveSev',{orderId:orderId,linkId:linkId,serviceId:serviceId,sellerCode:row.SELLER_CODE,sellerName:row.SELLER_NAME},
	   				function(data){
	   			if(data){
	   				$.messager.alert('提示',data.msg,'info');
	   				searchInfo();
	   				$('#designateLog').window('close');
	   				
	   			}
	   		});
   		}
   }
   
	//表格查询
	function searchInfo() {
		var url = '${rootPath}/orderSev/showOrderSevPage?orderId='+orderId;
		$('#dataOrder1').datagrid('reload',url); //设置好查询参数 reload 一下就可以了
	}

	//关闭弹出窗口，返回父页面,根据标记决定是否执行查询操作
	function returnParent(flag) {
		if(flag==1)
		{
			searchInfo();
		}
		$("#designateLog").window('close');
	}
</script>
</body>
</html>