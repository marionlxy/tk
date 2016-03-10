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
<div class="easyui-layout" fit="true" data-options="border:false" style="overflow: auto; ">
	<div class="easyui-panel" data-options="region:'north',border:false,height:200" style="overflow: hidden">
	<div style="margin-top: 10px;">
		<form id="dataOrder">
			<div class="fitem" >
		    	<label><font color="red">订单状态:</font></label>
		        <input name="orderState"  class="easyui-combobox" style="width:200px" panelHeight="auto"
		 	url="${rootPath}/getDictCombox?dictType=ORDER_STATUS" valueField="dictId" textField="dictName" disabled="true">
			</div>
			<div class="fitem"  style="float:left;">
		    	<label>订单编号:</label>
		        <input name="orderCode" class="easyui-textbox" disabled="true">
			</div> 
			<div class="fitem" >
		    	<label>创建日期:</label>
		        <input name="createdTime" class="easyui-textbox" disabled="true">
			</div>	
			<div class="fitem" style="float:left;">
		    	<label>用户姓名:</label>
		        <input name="customName" class="easyui-textbox" disabled="true">
			</div> <div class="fitem" >
		    	<label>用户电话:</label>
		        <input name="customTel" class="easyui-textbox" disabled="true">
			</div>
			<div class="fitem" >
		    	<label>用户地址:</label>
		        <input name="customAddress" class="easyui-textbox" disabled="true">
			</div> 
			<div class="fitem" style="float:left;">
		    	<label>天使姓名:</label>
		        <input name="angelName" class="easyui-textbox" disabled="true">
			</div> 
			<div class="fitem" >
		    	<label>天使电话:</label>
		        <input name="angelTel" class="easyui-textbox" disabled="true">
			</div>
			<div class="fitem" style="float:left;">
		    	<label>发票抬头:</label>
		        <input name="invoiceName" class="easyui-textbox" disabled="true">
			</div> <div class="fitem" >
		    	<label>发票内容:</label>
		        <input name="invoiceContent" class="easyui-textbox" disabled="true">
			</div>
			<c:if test="${not empty subCode}">
			<div class="fitem" style="float:left;">
		    	<label>商户名称:</label>
		        <input name="sellerName" class="easyui-textbox" disabled="true" >
			</div>
			 <div class="fitem" >
		    	<label>商户电话:</label>
		        <input name="sellerMobile" class="easyui-textbox" disabled="true">
			</div>
			</c:if>
		</form>
		</div>
	</div>
	<div data-options="region:'center',border:false" style="overflow:hidden;" >
		<table id="dataOrder1" title="服务列表" style="width:100%;height:100%;" >
   		</table>    
	</div>
	<div id="dlg-buttons" region="south" align="center" style="height:35px;padding-top:5px;border: false">
		<a href="javascript:void(0)" id="btnSave" onclick="addSubOrder();" class="easyui-linkbutton" iconCls="icon-ok">生成子订单</a> &nbsp;&nbsp;&nbsp;
		<a href="javascript:void(0)" id="btnClose" onclick="closeWin()" class="easyui-linkbutton" iconCls="icon-cancel">关&nbsp;&nbsp;闭</a>
	</div>
    <div id="designateLog" >
	 </div>
</div>
<script type="text/javascript" >
	var orderId='${orderId}';
	var orderType = '${orderType}';
	var orderState = '${orderState}';
	var subCode = '${subCode}';
	
	jQuery(function(){	  
		jQuery.ajaxSetup({
			cache : false
		});	
		if(orderState != '02'){
			$('#btnSave').css('display','none');
		}
		
		//获取【列表】全部字典数据[订单类型、订单状态]
		var dictList = getDictList('ORDER_STATUS,SITE');
		if (orderId != null && orderId != "" && orderId!=0){
			var url;
			if(subCode != null && subCode != "" && subCode!=0){
				url='${rootPath}/order/getOneSev?subCode='+subCode;
			}else{
				url='${rootPath}/order/getOne?orderId='+orderId;
			}
			$('#dataOrder').form('load', url);
		}
		
		
		$('#dataOrder1').datagrid({
	   		singleSelect : true,
	   		rownumbers:true,
	   		pagination:true,
	   		fitColumns:true,
	   		url:'${rootPath}/orderSev/showOrderSevPage?orderId='+orderId+"&subCode="+subCode,
	   		method : 'post',		
			idField : 'ORDER_SEV_ID',//此处根据实际情况进行填写
			columns:[[
						
	          			{field:'SERVICE_ID',title:'服务ID',hidden:true},
	          			{field:'ORDER_ID',title:'订单ID',hidden:true},
						{field:'ORDER_SEV_ID',title:'订单服务ID',hidden:true},
						{field:'SELLER_CODE',title:'商户编号',width:80,hidden:true},
						{field:'SERVICE_NUM',title:' 服务编号',width:80},
						{field:'SERVICE_NAME',title:'服务名称',width:80},
						{field:'SELLER_NAME',title:'商户名称',width:60},
						{field:'SELLER_MOBILE',title:'商户电话',width:60,hidden:true},
						{field:'LINK_ID',title:'环节ID',width:60,hidden:true},
						{field:'SELL_PRICE',title:'价格',width:50},
						{field:'SERVICE_SITE',title:'站点',width:50,formatter : function(value, row, index) {
							return getDictName(dictList,"SITE",value);}},
						{field:'SEV_STATE',title:'状态',width:60,formatter : function(value, row, index) {
							return getDictName(dictList,"ORDER_STATUS",value)}}, 
						{field:'TK',title:'操作',width:60,formatter:function(value,row,index){	
							if(row.SEV_STATE == '02' ){
								return "<a href='javascript:void(0);' onclick=designate('" + row.SERVICE_ID + "','"+ row.LINK_ID+ "','"+row.SERVICE_NUM+"') style='margin-left:20px;'>[指派]</a>"	
							}else{
								return "";
							}
						}}
								
			]],
			onLoadSuccess : function(data) {
				$('#dataOrder1').datagrid('clearSelections'); //一定要加上这一句，要不然datagrid会记住之前的选择状态，删除时会出问题
				
			}
		});
   });	
	
	function designate(serviceId,linkId,serviceNum){
		var url = '${rootPath}/order/selectOrderSevIndex?serviceId='+serviceId+"&linkId="+linkId+"&serviceNum="+serviceNum;
		$('#designateLog').dialog({
				title:"指派服务商",
			    width:500,   
			    height:300, 
				resizable:false,
				href : url,
				cache : false,
				closed : false,
				modal : true		
		});
		
	}
	
	function addSubOrder(){
		var rows = $('#dataOrder1').datagrid('getRows');
		var temp = [];	
		if(rows == null || rows == ""){
			$.messager.alert('提示',"没有需要生成子订单的服务",'info');
			return ;
		}else{
			for(var i=0;i < rows.length;i++){
				if((rows[i].SELLER_CODE =='undefined' || rows[i].SELLER_CODE =='null'  || rows[i].SELLER_CODE == null) && rows[i].SEV_STATE !="15"){
					temp.push(rows[i].SERVICE_NUM+"<br>");
				}else{
					break;
				}
			}
			 if(temp.length>0){
				$.messager.alert('提示',"服务编号:<font color='red' > " + temp + "</font>的服务没有指派服务商",'info');
			}else{
				$.post('${rootPath}/orderSev/subOrderSave',{orderId:orderId,orderType:orderType},function(data){
// 					if(data.result == 'true' || data.result == true){
// 						$.messager.alert('',data.msg,'info',function(){
// 							closeWin();
// 						});
// 					}
					$.messager.alert('',data.msg,'info');
					closeWin();
				});
			}
		}
		
	}
	
	//表格查询
	function searchInfo() {
		var url = '${rootPath}/order/list';
		$('#dataOrder1').datagrid('reload',url); //设置好查询参数 reload 一下就可以了
	}
	function closeWin(){
		$('#dataTable').datagrid('reload');
		$('#divDialog').window('close');	
	}
	
</script>
</body>

</html>