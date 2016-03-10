<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="UTF-8"%>
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
<div class="easyui-layout" data-options="fit : true,border : false">
	<div  data-options="region:'north',height:80,border : false">
		<form id="dataForm1" method="post">
		<div class="container_12" style="position: relative;">
		        <br/>
		        <div class="grid_1 lbl">开始时间:</div>
                <div class="grid_2 val">
                    <input name="startTime" class="easyui-datetimebox" >
                </div>
                <div class="grid_1 lbl">结束时间:</div>
                <div class="grid_2 val">
                    <input name="endTime"  class="easyui-datetimebox" >
                </div>
                 <div class="grid_1 lbl">客户姓名:</div>
                <div class="grid_2 val">
                  <input name="customName" class="easyui-textbox" >
                </div>
                 <div class="grid_1 lbl">订单状态:</div>
                <div class="grid_2 val">
                <input class="easyui-combobox" name="orderState" style="width:100px" panelHeight="auto"
		 	    url="${rootPath}/getDictCombox?dictType=ORDER_STATUS"  valueField="dictId" textField="dictName" editable="editable">
                 </div>
                <div class="grid_1 lbl"></div>
                <div class="grid_2 val">
                </div>
                <div class="grid_1 lbl"></div>
                <div class="grid_2 val">
                </div>
                <div class="grid_1 lbl">
                </div>
                <div class="grid_2 val">
                </div>
              		<div class="grid_1 lbl">
                 	<a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-search" onclick="searchInfo()" style="width:80px">查询</a>
                </div>
				<div class="grid_2 val" >
                	<a  href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-empty" onclick="clearForm()" style="width:80px;margin-left: 30px;">清空</a>
                </div>

        </div>
        <div class="container_13" style="position: relative;">
        </div>
        <div class="container_13" style="position: relative;">
        </div>
		</form>
    </div>
    <div data-options="region:'center',border:false"   style="overflow: hidden;">
         <table id="dataTable" title ="服务列表">
         </table> 
     </div>
       
    <div id="divDialog"> </div>
</div>
<script type="text/javascript">
	
	jQuery(function(){	  
		jQuery.ajaxSetup({
			cache : false
		});
   	//初始化列表
   	var dictList = getDictList('ORDER_STATUS,ORDER_TYPE,appraiseState');
   	$('#dataTable').datagrid({
   		iconCls:'icon-tip',
   		singleSelect : true,
   		rownumbers:true,
   		fit:true,
   		pagination:true,
   		fitColumns:true,
   		url : '${rootPath}/orderSev/visitOrderSevPage',
   		method : 'post',		
		idField : 'ORDER_ID',//此处根据实际情况进行填写
		columns:[[		
                            {field:'ORDER_ID',checkbox:true},
							{field:'ORDER_CODE',title:'订单编号',width:'14%'},
							{field:'subCode',title:'子订单编号',width:'14%'},
							{field:'ORDER_TYPE',title:'订单类型',width:'7%',
								formatter : function(value, row,index) {
									return getDictName(dictList,"ORDER_TYPE",value);
								}},
							{field:'CUSTOM_NAME',title:'客户姓名',width:'7%'},
							{field:'ORDER_PRICE',title:'订单金额(￥)',width:'8%'},
							{field:'ORDER_STATE',title:'订单状态',width:'7%',
							formatter : function(value, row,index) {
								return getDictName(dictList,"ORDER_STATUS",value);
							}},
							{field:'appraiseState',title:'回访状态',width:'7%',
								formatter : function(value, row,index) {
									return getDictName(dictList,"appraiseState",value);
								}},
							{field:'CREATED_TIME',title:'创建时间',width:'14%'},
							{
								field : 'operate',
								title : '操作',
								width :'13%',
								formatter : function(value, row,index) {
									return "<a href='#' onclick=showdetail('"+row.ORDER_ID+"') style='margin-left:10px'>[查看详细]</a>"
								}
							}
						//注：最后一行后面的逗号要去掉
		]],
		onLoadSuccess : function(data) {
			$('#dataTable').datagrid('clearSelections'); //一定要加上这一句，要不然datagrid会记住之前的选择状态，删除时会出问题
		}
	});
   });
   
	//查看详细信息
	function showdetail(orderId) {
	    if (orderId) {
	        url = '${rootPath}/orderSev/viewSevOrderInfo?orderId=' + orderId;
	    	$("#divDialog").dialog({
				title : "订单详情",
				width : 800,
				height : 450,
				href : url,
				cache : false,
				closed : false,
				modal : true,
				draggable : false
			});
	    } else {
	        $.messager.alert('提示', "请选择你要查看的记录", 'info');
	        return;
	    }
	}
   //表格查询
	function searchInfo() {
		//查询参数直接添加在queryParams中
		var queryParams = $('#dataTable').datagrid('options').queryParams;
		var fields = $('#dataForm1').serializeArray(); //自动序列化表单元素为JSON对象
		$.each(fields, function(i, field) {
			queryParams[field.name] = field.value; //设置查询参数
	
		});
		var url = '${rootPath}/orderSev/visitOrderSevPage';
		$('#dataTable').datagrid('reload',url); //设置好查询参数 reload 一下就可以了
	}
	
	//清空查询条件
	function clearForm() {
		$('#dataForm1').form('clear');
	
	}
	
   //点击增加弹出增加窗口
	function openWin(url) {
		$('#iframeDialogSelect').attr("src", url);
		$('#divDialog').window('open');

	}
	
	//关闭弹出窗口，返回父页面,根据标记决定是否执行查询操作
	function returnParent(flag) {
		if(flag==1) {
			searchInfo();
		}
		$("#divDialog").window('close');
	}
	
</script>
</body>
</html>