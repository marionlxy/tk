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
	<div class="easyui-panel" data-options="region:'north',border:false,height:175"  style="padding: 8px 70px 5px 80px">
		<form id="dataOrder">
		<input type = "hidden" name="${orderId}" >
		    <div class="fitem">
		    	<label>订单状态:</label>
		       <input class="easyui-combobox" name="orderState" style="width:100px" panelHeight="auto"
		 	url="${rootPath}/getDictCombox?dictType=ORDER_STATUS"  valueField="dictId" textField="dictName" disabled>
			</div>
			<div class="fitem" style="float:left;">
		    	<label>订单编号:</label>
		        <input name="orderCode" class="easyui-textbox" disabled="true">
			</div> 
			<div class="fitem" >
		    	<label>创建日期:</label>
		        <input name="createdTime" class="easyui-textbox" disabled="true">
			</div>	
			<div class="fitem" style="float:left;">
		    	<label>用户姓名:</label>
		        <input name="receiverName" class="easyui-textbox" disabled="true">
			</div>
			<div class="fitem" >
		    	<label>用户电话:</label>
		        <input name="receiverPhone" class="easyui-textbox" disabled="true">
			</div> <div class="fitem" >
		    	<label>收货人地址:</label>
		        <input name="receiverAddress" class="easyui-textbox" disabled="true">
			</div>
			<div class="fitem"  >
		    	<label>天使姓名:</label>
		        <input name="angelName" class="easyui-textbox" disabled="true">
			</div>
			<div class="fitem" style="float:left;">
		    	<label>天使电话:</label>
		        <input name="angelTel" class="easyui-textbox" disabled="true">
			</div> 
		</form>
	</div>
	
	<div data-options="region:'center',border:false" style="overflow:auto;" >
		<table id="dataOrder1" title="服务列表" style="width:100%;height:245px" >
   		</table>    
	</div>
	<div id="divDialog1"> </div>
</div>
<script type="text/javascript">
	var orderId='${orderId}';
	jQuery(function(){	  
		jQuery.ajaxSetup({
			cache : false
		});	
		if (orderId != null && orderId != "" && orderId!=0){
			var url='${rootPath}/orderSev/getOne?orderId=' + orderId;
			$('#dataOrder').form('load', url);
		}
		$('#dataOrder1').datagrid({
			iconCls:'icon-tip',
	   		singleSelect : true,
	   		rownumbers:true,
	   		fit:true,
	   		pagination:true,
	   		fitColumns:true,
	   		url:'${rootPath}/orderSev/visitOrderSevList?orderId='+orderId,
	   		method : 'post',		
			idField : 'ORDER_SEV_ID',//此处根据实际情况进行填写
			columns:[[
								{field:'SERVICE_NUM',title:'服务编号',width:80},
								{field:'SERVICE_NAME',title:'服务名称',width:80},
								{field:'SELLER_NAME',title:'服务商名称',width:60},
								{field:'SELL_PRICE',title:'价格',width:60},
								{
									field : 'operate',
									title : '回访操作',
									width : 100,
									formatter : function(value, row,index) {
										if(row.APPRAISE_STATE != 1){
											return "<a href='#' onclick=showAppraise('"+row.ORDER_SEV_ID+"','"+row.APPRAISE_STATE+"','"+row.SUB_ID+"') style='margin-left:65px'><span  style='color:red'>[未回访]</span></a>"
										}else{
											return "<a href='#' onclick=showAppraise('"+row.ORDER_SEV_ID+"','"+row.APPRAISE_STATE+"','"+row.SUB_ID+"') style='margin-left:65px'>[已回访]</a>"
										}
										
									}
								},
								{field:'ORDER_SEV_ID',title:'orderSevId',width:80,hidden:true},
								{field:'APPRAISE_STATE',title:'appariseState',width:80,hidden:true},
								{field:'SUB_ID',title:'subId',width:80,hidden:true},
								
			]],
			onLoadSuccess : function(data) {
				$('#dataOrder1').datagrid('clearSelections'); //一定要加上这一句，要不然datagrid会记住之前的选择状态，删除时会出问题
			}
		});
   });		
	function showAppraise(orderSevId,appariseState,subId,linkId) {
		var tURL = "";
		if(linkId == "undefined"){
			linkId="";
		}
	    if (orderSevId) {
	    	tURL = '${rootPath}/appraise/add?orderSevId='+orderSevId+"&appariseState="+appariseState+"&subId="+subId+"&linkId="+linkId;
	    	$("#divDialog1").dialog({
				title : "评价",
				width : 430,
				height : 260,
				href : tURL,
				cache : false,
				closed : false,
				modal : true
			});
	    } else {
	        $.messager.alert('提示', "请选择你要查看的记录", 'info');
	        return;
	    }
	}
	function goBack(flag) {
		if (flag == 1) {
			searchInfo();
		}
		$("#divDialog1").window('close');
	}
	function returnParent(flag) {
		if(flag==1) {
			searchInfo();
		}
		$("#divDialog1").window('close');
	}
	
	function searchInfo() {
		var orderId='${orderId}';
		//查询参数直接添加在queryParams中
		var queryParams = $('#dataTable').datagrid('options').queryParams;
		var fields = $('#dataOrder1').serializeArray(); //自动序列化表单元素为JSON对象
		$.each(fields, function(i, field) {
			queryParams[field.name] = field.value; //设置查询参数
		});
		var url = '${rootPath}/orderSev/visitOrderSevList?orderId='+orderId;
		$('#dataOrder1').datagrid('reload',url); //设置好查询参数 reload 一下就可以了
	}
</script>
</body>

</html>