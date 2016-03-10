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
<body >
<div class="easyui-layout" fit="true" data-options="border:false">
	<div class="easyui-panel" data-options="region:'north',border:false,height:150"  style="padding: 10px 60px 20px 60px">
		<form id="dataOrder">
			<div class="fitem" style="float:left;">
		    	<label>订单编号:</label>
		        <input name="orderCode" class="easyui-textbox" disabled="true">
			</div> 
			<div class="fitem" >
		    	<label>创建日期:</label>
		        <input name="createdTime" class="easyui-textbox" disabled="true">
			</div>	
			<div class="fitem" style="float:left;">
		    	<label>收货人姓名:</label>
		        <input name="receiverName" class="easyui-textbox" disabled="true">
			</div> 
			<div class="fitem" >
		    	<label>收货人邮编:</label>
		        <input name="receiverPostcode" class="easyui-textbox" disabled="true">
			</div>
			<div class="fitem" style="float:left;">
		    	<label>收货人电话:</label>
		        <input name="receiverPhone" class="easyui-textbox" disabled="true">
			</div> <div class="fitem">
		    	<label>收货人地址:</label>
		        <input name="receiverAddress" class="easyui-textbox" disabled="true">
			</div>
			<div class="fitem" style="float:left; width: 100%;" >
		    	<label>物流单号:</label>
		        <input name="oddnum" class="easyui-textbox" disabled="true">
			</div>
			<div class="fitem" style="float:left;">
		    	<label>物流公司:</label>
		        <input name="logistics" class="easyui-textbox" disabled="true">
			</div> <div class="fitem" >
		    	<label>物流费用:</label>
		        <input name="logisticsCost" class="easyui-textbox" disabled="true">
			</div>
		</form>
	</div>
	
	<div data-options="region:'center',border:false" style="overflow:auto;" >
		<table id="dataOrder1" title="用品列表" style="width:100%;height:270px" >
   		</table>    
	</div>
</div>
<script type="text/javascript">
	var orderId='${orderId}';
	jQuery(function(){	  
		jQuery.ajaxSetup({
			cache : false
		});	
		if (orderId != null && orderId != "" && orderId!=0){
			var url='${rootPath}/order/getOne?orderId=' + orderId;
			$('#dataOrder').form('load', url);
		}
		
		
		$('#dataOrder1').datagrid({

	   		singleSelect : true,
	   		rownumbers:true,
	   		pagination:true,
	   		fitColumns:true,
	   		url:'${rootPath}/orderApp/orderIdForPage?orderId='+orderId,
	   		method : 'post',		
			idField : 'ORDER_APP_ID',//此处根据实际情况进行填写
			columns:[[
								{field:'ORDER_APP_ID',title:'用品ID',width:80,hidden:true},
								{field:'APPLIANCE_CODING',title:'用品编号',width:80},
								{field:'APPLIANCE_NAME',title:'用品名称',width:80},
								{field:'APPLIANCE_MARKET_PRICE',title:'用品销售价',width:60},
								{field:'APPLIANCE_COUNT',title:'数量',width:30},
								{field:'APP_STATE',title:'用品状态',width:60},
								{field:'SITE',title:'站点',width:50},
								{field:'APPLIANCE_PRICE',title:'用品总价',width:80}
			]],
			onLoadSuccess : function(data) {
				$('#dataTable').datagrid('clearSelections'); //一定要加上这一句，要不然datagrid会记住之前的选择状态，删除时会出问题
			}
		});
   });		
</script>
</body>

</html>