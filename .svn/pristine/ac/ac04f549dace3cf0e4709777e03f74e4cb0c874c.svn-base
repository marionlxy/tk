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
	<div class="easyui-panel" title="查询条件" data-options="region:'north',height:124,border : false">
		<!-- 注意：form ID 要加 1，用于区别子页面 form -->
		<form id="dataForm1" method="post" action="${rootPath}/order/downloadYunying">
			<table style="width:100%; height:1%; overflow: hidden;" border="0" 
				cellpadding="0" cellspacing="0"  class="kTable" >
			 <tr>
				 <td class="kTableLabel lbl">订单编号:</td>
				 <td><input name="orderCode" class="easyui-textbox" ></td>
				 <td class="kTableLabel lbl">客户姓名:</td>
				 <td><input name="customName" class="easyui-textbox" ></td> 
				  <td class="kTableLabel lbl">订单类型 :</td>
				 <td><input class="easyui-combobox" editable="editable" id="orderType"  name="orderType" style="width:150px" panelHeight="auto"
		 			url="${rootPath}/getDictCombox?dictType=ORDER_TYPE" valueField="dictId" textField="dictName">
				</td>
			 </tr>
			  <tr>
				 <td class="kTableLabel lbl">创建时间:</td>
				 <td><input name="createdTime" class="easyui-datetimebox" style="width:100px" >-<input name="createdTime1" class="easyui-datetimebox" style="width:100px"></td>
				 <td class="kTableLabel lbl">天使姓名:</td>
				 <td><input name="angelName" class="easyui-textbox" ></td> 
				 <td class="kTableLabel lbl">订单状态 :</td>
				 <td><input class="easyui-combobox" editable="editable" id="orderState"  name="orderState" style="width:150px" panelHeight="auto"
		 			url="${rootPath}/getDictCombox?dictType=ORDER_STATUS" valueField="dictId" textField="dictName" >
				</td>
			 </tr>
			 <tr>
			 	<td valign="middle" align="center" colspan="6" >
			 		<a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-search" onclick="searchInfo()" style="width:90px">查询</a>              
                	&nbsp;&nbsp;<a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-empty" onclick="clearForm()" style="width:90px">清空</a>
			 	</td>
			 </tr>
			</table>
		</form>
    </div>

	<div data-options="region:'center',border:false" style="overflow: hidden;">
		<table id="dataTable" title="订单列表" style="height:100%;" >
   		</table>    
	</div>
    <div id="divDialog" >
		<!-- <iframe id="iframeDialogSelect" src="" frameborder="0" scrolling="yes"	width="100%" height="98%"></iframe> -->
	</div>
</div>

</body>
<script type="text/javascript">

	jQuery(function(){	  
		jQuery.ajaxSetup({
			cache : false
		});
		
		//获取【列表】全部字典数据[订单类型、订单状态]
		var dictList = getDictList('ORDER_STATUS,ORDER_TYPE,INVOICE_STATUS,SITE');
		
		
   	//初始化列表
   	$('#dataTable').datagrid({
   		singleSelect : true,
   		rownumbers:true,
   		pagination:true,
   		fitColumns:true,
   		url:'${rootPath}/order/list',
   		method : 'post',		
		idField : 'ORDER_ID',//此处根据实际情况进行填写
		columns:[[
          			{field:'ck',checkbox:true},
					{field:'ORDER_ID',title:'订单ID',width:80,hidden:true},
					{field:'ORDER_CODE',title:'订单编号',width:70},
					{field:'subCode',title:'子订单编号',width:70},
					{field:'SITE',title:'站点',width:40,align:'center',formatter : function(value, row, index) {
						return getDictName(dictList,"SITE",value)}},
					{field:'CUSTOM_NAME',title:'客户姓名',width:50},
					{field:'ANGEL_NAME',title:'天使姓名',width:50},
					{field:'ORDER_TYPE',title:'订单类型',width:40,align:'center',formatter : function(value, row, index) {
						return getDictName(dictList,"ORDER_TYPE",value)}},
					{field:'ORDER_PRICE',title:'订单总价',width:50},
					{field:'ORDER_STATE',title:'订单状态',width:50,formatter : function(value, row, index) {
							return getDictName(dictList,"ORDER_STATUS",value);	
					}
					},
					{field:'INVOICE_STATE',title:'发票类型',width:50,
						formatter : function(value, row, index) {
							return getDictName(dictList,"INVOICE_STATUS",value);	
					}
					},
					{field:'CREATED_TIME',title:'创建时间',width:80},
					{field:'TK' ,title:'操作',width:70,formatter:function(value,row,index){
						return "<a href='javascript:void(0);' onclick=viewOrder('"+ row.ORDER_ID +"','"+ row.ORDER_TYPE +"','"+ row.ORDER_STATE +"','"+row.subCode+"') style='margin-left:5px;'>[查看明细]</a>"
					}}
		]],
		toolbar :
		[{
			id : 'btnexport',
			text : '导出',
			iconCls : 'icon-page_excel',
			handler : function() {
				downloadByYunying();
			}
		}],
		onLoadSuccess : function(data) {
			$('#dataTable').datagrid('clearSelections'); //一定要加上这一句，要不然datagrid会记住之前的选择状态，删除时会出问题
		}
	});
   	
   });
	//表格查询
	function searchInfo() {
		//查询参数直接添加在queryParams中
		var queryParams = $('#dataTable').datagrid('options').queryParams;
		var fields = $('#dataForm1').serializeArray(); //自动序列化表单元素为JSON对象
	
		$.each(fields, function(i, field) {
			queryParams[field.name] = field.value; //设置查询参数
	
		});
		var url = '${rootPath}/order/list';
		$('#dataTable').datagrid('reload',url); //设置好查询参数 reload 一下就可以了
	}
	
	//清空查询条件
	function clearForm() {
		$('#dataForm1').form('clear');
		searchInfo();
	
	}

   //新增
   function addrow(){
   		$.ajax({
   		  type:'GET',
   		  url:'${rootPath}/order/test',
   		  dataType:'json',
   		  success:function(data){
   			  if(data){
   				  $.messager.alert('提示',data.msg,'info');
   			  }
   		  }
   		  
   		});
   }

   
	function  viewOrder(orderId,orderType,orderStatus,subCode){
		var url = '${rootPath}/order/showOrderList?orderId='+orderId+"&orderType="+orderType+"&orderState="+orderStatus+"&subCode="+subCode;
		//parent.top.$('#w').dialog({
		$("#divDialog").dialog({ 
			title:"查看订单信息",
		    width:790,   
		    height:450, 
			resizable:false,
			href : url,
			cache : false,
			closed : false,
			modal : true
		    
		});  

	}
		
	//导出excel
	   function downloadByYunying(){
		
		   $("form:first").submit();
	   }
		
    //点击增加弹出增加窗口
	function openWin(url) {
		//$('#iframeDialogSelect').attr("src", url);
		$('#divDialog').window('open');

	}
	
	//关闭弹出窗口，返回父页面,根据标记决定是否执行查询操作
	function returnParent(flag) {
		if(flag==1)
		{
			searchInfo();
		}
		$("#divDialog").window('close');
	}
   
   

		
</script>
</html>