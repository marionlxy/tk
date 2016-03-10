 <%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="UTF-8"%>
 <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
	<div class="easyui-panel" title="查询条件" data-options="region:'north',height:108,collapsible:false,border : false">
		<!-- 注意：form ID 要加 1，用于区别子页面 form -->
		<form id="dataForm1" method="post" action="${rootPath}/finance/downloadFinance">
		<div class="container_12" style="position: relative;">
		        <br/>
                <div class="grid_1 lbl">开始时间:</div>
                <div class="grid_2 val">
                    <input name="payTime" id = "payTime" class="easyui-datetimebox" >
                </div>
                <div class="grid_1 lbl">结束时间:</div>
                <div class="grid_2 val">
                    <input name="payTime1"  id = "payTime1"  class="easyui-datetimebox" >
                </div>
               	<div class="grid_1 lbl">支付方式:</div>
		<div class="grid_2 val">
		<input id = "payMethod" class="easyui-combobox" name="payMethod" style="width:80px" editable="editable" panelHeight="auto"
		 	url="${rootPath}/getDictCombox?dictType=PAY_METHOD" valueField="dictId" textField="dictName">
                </div>
                <div class="grid_1 lbl"> 天使姓名:</div>
		<div class="grid_2 val">
		<input name="angelName" class="easyui-textbox" id = "angelName" style="width:120px">
		</div>
		</div>
		  <div class="grid_2 val" style="font-size:18px" >
         <span style="color:red" > 合计金额：  <input name="countPrice" style="border:0px;width:120px;color:red;font-size:16px"> 元</span> 
       	 </div>
  	            <div class="grid_1 lbl"> </div>
                <div class="grid_2 val">
                </div>
                 <div class="grid_1 lbl"> </div>
                <div class="grid_2 val">
                </div>
                 <div class="grid_1 lbl"> </div>
                <div class="grid_2 val">
                </div>
                   <div class="grid_1 lbl"> </div>
                <div class="grid_2 val">
                </div>
              	<div class="grid_1 lbl">
                 	<a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-search" onclick="searchInfo()" style="width:90px">查询</a>
                </div>
				<div class="grid_2 val">
                	&nbsp;&nbsp;<a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-empty" onclick="clearForm()" style="width:90px;margin-left: 25px;">清空</a>
                </div>
        
		</form>
    </div>
    <div data-options="region:'center',border:false" style="overflow: hidden;">
		<table id="dataTable" title="对账列表" height="100%"></table>
	</div>
	<div id="divDialog"></div>
</div>
<script type="text/javascript">
	
	jQuery(function(){
		
		jQuery.ajaxSetup({
			cache : false
		});
		var url='${rootPath}/finance/sumFinanceAccount';
		$('#dataForm1').form('load', url);
		// 获取【列表】全部字典数据[商户类型、站点]
		var dictList = getDictList('ACCOUNT,PAY_METHOD');
   	
		//初始化列表
	   	$('#dataTable').datagrid({
	   		singleSelect : true,
	   		rownumbers:true,
	   		pagination:true,
	   		//fitColumns:true,
	   		fit : true,
	   		url : '${rootPath}/finance/list',
	   		method : 'post',		
			idField : 'ORDER_ID',//此处根据实际情况进行填写
			columns:[[
		          			// 注意：这里是字段名SELLER_CODE，不是变量名sellerCode
							{field : 'ck',checkbox : true},
		          			{field:'ORDER_ID',title:'主订单编号',width:1,hidden:true},
		          			{field:'ORDER_CODE',title:'主订单编号',width:"15%"},
							{field:'PAY_TIME',title:'支付时间',width:"15%"},
							{field:'PAY_METHOD',title:'支付方式',width:"10%",formatter : function(value, row, index) {
								return getDictName(dictList,"PAY_METHOD",value);
							}},				
							{field:'ORDER_PRICE',title:'订单金额(￥)',width:"10%"},
							//{field:'countsubprice',title:'订单总额',width:80},
							{field:'serialno',title:'流水号',width:"11%"},
							{field:'BANK_ACCOUNT',title:'银行账号',width:"12%"},
							{field:'ANGEL_NAME',title:'天使姓名',width:"10%"},
							{field:'ACCOUNT_STATE',title:'到账状态',width:"10%",formatter : function(value, row, index) {
								return getDictName(dictList,"ACCOUNT",value);
							}},
							{
								field : 'operate',
								title : '操作',
								width : "26%",
								formatter : function(value, row,index) {
									return "<a href='#' onclick=ok('"+row.ORDER_ID+"','"+row.SUB_ID+"') style='margin-left:10px'>[确认已到账]</a>"
									+"<a href='#' onclick=ok1('"+row.ORDER_ID+"','"+row.SUB_ID+"') style='margin-left:10px'>[确认未到账]</a>"
									+"<a href='#' onclick=ok2('"+row.ORDER_ID+"','"+row.SUB_ID+"') style='margin-left:10px'>[作废]</a>";
								}
							}, 
							
							
						/* 	{field:'ORDER_ID',title:'orderId',width:80,hidden:true}, */
						/* 	{field:'SELLER_LINKMAN',title:'sellerLinkman',width:80,hidden:true},
							{field:'SELLER_ADDRESS',title:'sellerAddress',width:80,hidden:true},
							{field:'SITE',title:'site',width:80,hidden:true},
							{field:'BANK_NAME',title:'bankName',width:80,hidden:true},
							{field:'BANK_ACCOUNT',title:'bankAccount',width:80,hidden:true},
							{field:'ACCOUNT_HOLDER',title:'accountHolder',width:80,hidden:true},
							{field:'CREATED_BY',title:'createdBy',width:80,hidden:true},
							{field:'MODIFIED_BY',title:'modifiedBy',width:80,hidden:true},
							{field:'MODIFIED_TIME',title:'modifiedTime',width:80,hidden:true},
							{field:'DELFLAG',title:'delflag',width:80,hidden:true},
							{field:'VERSION',title:'version',width:80,hidden:true} */
						//注：最后一行后面的逗号要去掉
			]],
			toolbar : [ {
				id : 'btnexport',
				text : '导出',
				iconCls : 'icon-page_excel',
				handler : function() {
					download();
				}
			}],
			onLoadSuccess : function(data) {
				$('#dataTable').datagrid('clearSelections'); //一定要加上这一句，要不然datagrid会记住之前的选择状态，删除时会出问题
				   var rows = $('#dataTable').datagrid('getRows');
				  /*  var total=0;
				   for(var i=0;i<rows.length;i++)
					   {
					   	total+=rows[i]['SUB_PRICE'];
					   }
				   	   if(""+total+""=="NaN")
				   		   {
				   			$("#d").html("合计金额："+0+"元");				   		   }
				   	   else
				   		   {			   		 
					  	    	$("#d").html("合计金额："+total+"元");
				   		   } */

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
		var url = '${rootPath}/finance/list';
		$('#dataTable').datagrid('reload',url); //设置好查询参数 reload 一下就可以了
		var sTime = $("#payTime").datetimebox('getValue');
		var eTime = $('#payTime1').datetimebox('getValue');
		var oMethod = $('#payMethod').combobox('getValue');
		var aName = $('#angelName').textbox('getValue');
		var urls='${rootPath}/finance/sumFinanceAccount?payTime='+sTime+'&payTime1='+eTime+'&payMethod='+oMethod+'&angelName='+encodeURI(encodeURI(aName));
		$('#dataForm1').form('load', urls);
	}
	
	//清空查询条件
	function clearForm() {
		$('#dataForm1').form('clear');
		searchInfo();
	}
	   //导出excel
	function download(){
		$("form:first").submit();
	}

   //新增
   function addrow(){
//    	url = '${rootPath}/seller/add';
// 		openWin(url);
	    url = '${rootPath}/seller/add';
		$("#divDialog").dialog({
			title : "添加商户",
			width : 450,
			height : 430,
			href : url,
			cache : false,
			closed : false,
			modal : true
		});
   }
   
   //修改
   function editrow(orderId){    	
//     var row = $('#dataTable').datagrid('getSelected');
       if (orderId){
//      url = '${rootPath}/seller/edit?rowId='+ row.rowId;
// 		openWin(url);
    	   	url = '${rootPath}/finance/edit?orderId='+ orderId;
	   		/* $("#divDialog").dialog({
	   			title : "修改商户信息",
	   			width : 450,
	   			height : 430,
	   			href : url,
	   			cache : false,
	   			closed : false,
	   			modal : true
	   		}); */
       }
       else
       {
       	$.messager.alert('提示', "请选择你要操作的记录", 'info');
		return;
       }
   }
   
   //删除
   function delerow(sellerId, version){
//        var row = $('#dataTable').datagrid('getSelected');
       if (sellerId && version){
           $.messager.confirm('提示','确定要删除行记录吗？',function(r){
               if (r){
                   $.post('${rootPath}/seller/del',{sellerId:sellerId,version:version},function(data){
                   	
                   	if(data.result == 'true' || data.result == true){
                   		$.messager.alert("提示", "角色删除成功！");
						goBack(1);
   					}else{
   						$.messager.alert("提示", "角色删除失败 ！");
   					}                    	
                   });
               }
           });
       } else {
    	   $.messager.alert('提示', "请选择你要操作的记录", 'info');
			return;
		}
   }
   	
   //查看
   function viewrow(orderId){    	
       if (orderId){
    	   	url = '${rootPath}/finance/edit?orderId='+ orderId;
 	   		$("#divDialog").dialog({
	   			title : "查看商户信息",
	   			width : 450,
	   			height : 430,
	   			href : url,
	   			cache : false,
	   			closed : false,
	   			modal : true
	   		}); 
       }
       else
       {
       	$.messager.alert('提示', "请选择你要操作的记录", 'info');
		return;
       }
   }
   
   
   function ok(orderId){
//     var row = $('#dataTable').datagrid('getSelected');
    if (orderId){
        $.messager.confirm('提示','确定要操作行记录吗？',function(r){
            if (r){
                $.post('${rootPath}/finance/ok',{orderId:orderId},function(data){
                	
                	if(data.result == 'true' || data.result == true)
					{
//                 		$('#dataTable').datagrid('reload');    // reload the user data
                		$.messager.alert("提示", "确认已到账成功！");
                		goBack(1);
					}
					else
					{
// 						$.messager.alert('提示',data.msg,'error');
						$.messager.alert("提示", "确认已到账失败 ！");
					}                    	
                });
            }
        });
    } else {
 	   $.messager.alert('提示', "请选择你要操作的记录", 'info');
			return;
		}
}
   
   function ok1(orderId){
//     var row = $('#dataTable').datagrid('getSelected');
    if (orderId){
        $.messager.confirm('提示','确定要操作行记录吗？',function(r){
            if (r){
                $.post('${rootPath}/finance/ok1',{orderId:orderId},function(data){
                	
                	if(data.result == 'true' || data.result == true)
					{
//                 		$('#dataTable').datagrid('reload');    // reload the user data
                		$.messager.alert("提示", "确认未到账成功！");
                		goBack(1);
					}
					else
					{
// 						$.messager.alert('提示',data.msg,'error');
						$.messager.alert("提示", "确认未到账失败 ！");
					}                    	
                });
            }
        });
    } else {
 	   $.messager.alert('提示', "请选择你要操作的记录", 'info');
			return;
		}
} 
   
   function ok2(orderId){
//     var row = $('#dataTable').datagrid('getSelected');
    if (orderId){
        $.messager.confirm('提示','确定要操作行记录吗？',function(r){
            if (r){
                $.post('${rootPath}/finance/ok2',{orderId:orderId},function(data){
                	
                	if(data.result == 'true' || data.result == true)
					{
//                 		$('#dataTable').datagrid('reload');    // reload the user data
                		$.messager.alert("提示", "确认作废成功！");
                		goBack(1);
					}
					else
					{
// 						$.messager.alert('提示',data.msg,'error');
						$.messager.alert("提示", "确认作废失败 ！");
					}                    	
                });
            }
        });
    } else {
 	   $.messager.alert('提示', "请选择你要操作的记录", 'info');
			return;
		}
}   
   
//    function ok(orderId)
//    {
// 	   $.ajax({
// 		   type: "POST",
// 		   url: "${rootPath}/finance/ok",
// 		   data: {"orderId":orderId,"subId":subId},
// 		   success: function(msg){
// 			   $('#dataTable').datagrid('reload'); 
// 		   }
// 		});
//    }
   
//    function ok1(orderId)
//    {  
// 	   $.ajax({
// 		   type: "POST",
// 		   url: "${rootPath}/finance/ok1",
// 		   data: "orderId="+orderId+"",
// 		   success: function(msg){
// 			   $('#dataTable').datagrid('reload'); 
// 		   }
// 		});
//    }
   
//    function ok2(orderId)
//    {  
// 	   $.ajax({
// 		   type: "POST",
// 		   url: "${rootPath}/finance/ok2",
// 		   data: "orderId="+orderId+"",
// 		   success: function(msg){
// 			   $('#dataTable').datagrid('reload'); 
// 		   }
// 		});
//    }
   
   function  getcol()
   {
	   var rows = $('#dataTable').datagrid('getRows');
	   var total=0;
	   for(var i=0;i<rows.length;i++)
		   {
		   	total+=rows[i]['SUB_PRICE'];
		   }
	   $("#d").html("合计金额："+total+"元");
   }

   
   //点击增加弹出增加窗口
// 	function openWin(url) {
// 		$('#iframeDialogSelect').attr("src", url);
// 		$('#divDialog').window('open');

// 	}
	
	//关闭弹出窗口，返回父页面,根据标记决定是否执行查询操作
// 	function returnParent(flag) {
// 		if(flag==1)
// 		{
// 			searchInfo();
// 		}
// 		$("#divDialog").window('close');
// 	}
	function goBack(flag) {
		if (flag == 1) {
			searchInfo();
		}
		$("#divDialog").window('close');
	}
		
</script>
</body>
</html>