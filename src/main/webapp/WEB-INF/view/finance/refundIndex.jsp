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
    	<div class="easyui-panel" title="查询条件" data-options="region:'north',height:112,collapsible:false,border : false">
		<!-- 注意：form ID 要加 1，用于区别子页面 form -->
		<form id="dataForm1" method="post">
		    <div id="condition" class="container_12" style="position: relative;">
		    <br/>
			<div class="grid_1 lbl">退货时间:</div>
            <div class="grid_2 val">
            <input name="applyTime" id = "applyTime"  class="easyui-datetimebox" >
            </div>
              <div class="grid_1 lbl"></div>
				<div class="grid_2 val">
			</div>
			 <div class="grid_1 lbl"> </div>
               
		    <div class="grid_1 lbl">
            <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-search" onclick="searchInfo()" style="width:90px;margin-left: 30px;">查询</a>
            </div>
			<div class="grid_2 val">
             &nbsp;&nbsp;<a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-empty" onclick="clearForm()" style="width:90px;margin-left: 60px;">清空</a>
            </div>
          
		
       </div>
        <div class="grid_2 val" style="font-size:18px" >
          <span style="color:red" > 合计金额： <input name="countPrice" style="border:0px;width:100px;color:red;font-size:16px"> 元</span> 
       	  </div>
       </form>
    </div>
    <div data-options="region:'center',border:false" style="overflow: hidden;">
		<table id="dataTable" title="退款列表" height="100%">
	<div id="divDialog"></div>
</div>
<script type="text/javascript">
	
	jQuery(function(){
		jQuery.ajaxSetup({
			cache : false
		});
		var url='${rootPath}/refund/sumRefundAccount';
		$('#dataForm1').form('load', url);
		// 获取【列表】全部字典数据[商户类型、站点]
		var dictList = getDictList('REFUND,CLOSELLER');
   	
		//初始化列表
	   	$('#dataTable').datagrid({
	   		singleSelect : true,
	   		rownumbers:true,
	   		pagination:true,
	   		fitColumns:true,
	   		url : '${rootPath}/refund/list',
	   		method : 'post',		
			idField : 'RETURN_ID',//此处根据实际情况进行填写
			columns:[[
		          			// 注意：这里是字段名SELLER_CODE，不是变量名sellerCode
							{field : 'ck',checkbox : true},
							{field:'RETURN_ID',title:'退款ID',width:80,hidden:true},
							{field:'RETURN_CODE',title:'退货单号',width:"15%",align:'center'},
// 		          				{field:'ORDER_CODE',title:'主订单编号',width:80,align:'center'},
							{field:'ORDER_CODE',title:'订单编号',width:"15%",align:'center'},
							{field:'APPLY_TIME',title:'退货时间',width:"15%",align:'center'},
							{field:'APPLIANCE_PRICE',title:'退货金额(￥)',width:"10%",align:'center'},
							{field:'REFUND_STATE',title:'退款状态',width:"12%",align:'center',formatter : function(value, row, index) {
								return getDictName(dictList,"REFUND",value);
							}},
							{field:'BALANCE_STATE',title:'结算状态',width:"12%",align:'center',formatter : function(value, row, index) {
								return getDictName(dictList,"CLOSELLER",value);
							}},
							{
								field : 'operate',
								title : '操作',
								width : "46%",
								formatter : function(value, row,index) {
									return "<a href='#' onclick=ok('"+row.RETURN_ID+"') style='margin-left:10px'>[确认已退款]</a>"
									+"<a href='#' onclick=ok1('"+row.RETURN_ID+"') style='margin-left:10px'>[确认未退款]</a>"
									/* +"<a href='#' onclick=ok2('"+row.RETURN_ID+"') style='margin-left:10px'>[退款作废]</a>" */
									+"<a href='#' onclick=ok3('"+row.RETURN_ID+"') style='margin-left:10px'>[确认已结算]</a>"
									+"<a href='#' onclick=ok4('"+row.RETURN_ID+"') style='margin-left:10px'>[确认未结算]</a>"
									+"<a href='#' onclick=ok5('"+row.RETURN_ID+"') style='margin-left:10px'>[作废]</a>";
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
			/* toolbar : [{
				id : 'btnadd',
				text : '添加商户',
				iconCls : 'icon-add',
				handler : function() {
					addrow();
				}
// 			}, '-', {
// 				id : 'btnedit',
// 				text : '修改',
// 				iconCls : 'icon-edit',
// 				handler : function() {
// 					editrow();
// 				}
// 			}, '-', {
// 				id : 'btndel',
// 				text : '删除',
// 				iconCls : 'icon-remove',
// 				handler : function() {
// 					delerow();
// 				}
			}], */
			onLoadSuccess : function(data) {
				$('#dataTable').datagrid('clearSelections'); //一定要加上这一句，要不然datagrid会记住之前的选择状态，删除时会出问题
				   var rows = $('#dataTable').datagrid('getRows');
				   var total=0;
				   for(var i=0;i<rows.length;i++)
					   {
					   	total+=rows[i]['APPLIANCE_PRICE'];
					   }
// 				   if(""+total+""=="NaN")
// 		   		   {
// 		   			$("#d").html("合计金额："+0+"元");				   		   }
// 		   	           else
// 		   		   {			   		 
// 			  	    	$("#d").html("合计金额："+total+"元");
// 		   		   }
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
		var url = '${rootPath}/refund/list';
		$('#dataTable').datagrid('reload',url); //设置好查询参数 reload 一下就可以了
		
		var aTime = $("#applyTime").datetimebox('getValue');
		var urls='${rootPath}/refund/sumRefundAccount?applyTime='+aTime;
		$('#dataForm1').form('load', urls);
	}
	
	//清空查询条件
	function clearForm() {
		$('#dataForm1').form('clear');
		searchInfo();
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
   
   function ok(returnId){
//     var row = $('#dataTable').datagrid('getSelected');
    if (returnId){
        $.messager.confirm('提示','确定要操作行记录吗？',function(r){
            if (r){
                $.post('${rootPath}/refund/ok',{returnId:returnId},function(data){
                	
                	if(data.result == 'true' || data.result == true)
					{
//                 		$('#dataTable').datagrid('reload');    // reload the user data
                		$.messager.alert("提示", "确认已退款成功！");
                		goBack(1);
					}
					else
					{
// 						$.messager.alert('提示',data.msg,'error');
						$.messager.alert("提示", "确认未退款失败 ！");
					}                    	
                });
            }
        });
    } else {
 	   $.messager.alert('提示', "请选择你要操作的记录", 'info');
			return;
		}
}
   
   function ok1(returnId){
//     var row = $('#dataTable').datagrid('getSelected');
    if (returnId){
        $.messager.confirm('提示','确定要操作行记录吗？',function(r){
            if (r){
                $.post('${rootPath}/refund/ok1',{returnId:returnId},function(data){
                	
                	if(data.result == 'true' || data.result == true)
					{
//                 		$('#dataTable').datagrid('reload');    // reload the user data
                		$.messager.alert("提示", "确认未退款成功！");
                		goBack(1);
					}
					else
					{
// 						$.messager.alert('提示',data.msg,'error');
						$.messager.alert("提示", "确认未退款失败 ！");
					}                    	
                });
            }
        });
    } else {
 	   $.messager.alert('提示', "请选择你要操作的记录", 'info');
			return;
		}
}
   
   function ok2(returnId){
//     var row = $('#dataTable').datagrid('getSelected');
    if (returnId){
        $.messager.confirm('提示','确定要操作行记录吗？',function(r){
            if (r){
                $.post('${rootPath}/refund/ok2',{returnId:returnId},function(data){
                	
                	if(data.result == 'true' || data.result == true)
					{
//                 		$('#dataTable').datagrid('reload');    // reload the user data
                		$.messager.alert("提示", "确认已退款成功！");
                		goBack(1);
					}
					else
					{
// 						$.messager.alert('提示',data.msg,'error');
						$.messager.alert("提示", "确认未退款失败 ！");
					}                    	
                });
            }
        });
    } else {
 	   $.messager.alert('提示', "请选择你要操作的记录", 'info');
			return;
		}
}
   
   function ok3(returnId){
//     var row = $('#dataTable').datagrid('getSelected');
    if (returnId){
        $.messager.confirm('提示','确定要操作行记录吗？',function(r){
            if (r){
                $.post('${rootPath}/refund/ok3',{returnId:returnId},function(data){
                	
                	if(data.result == 'true' || data.result == true)
					{
//                 		$('#dataTable').datagrid('reload');    // reload the user data
                		$.messager.alert("提示", "确认已结算成功！");
                		goBack(1);
					}
					else
					{
// 						$.messager.alert('提示',data.msg,'error');
						$.messager.alert("提示", "确认已结算失败 ！");
					}                    	
                });
            }
        });
    } else {
 	   $.messager.alert('提示', "请选择你要操作的记录", 'info');
			return;
		}
}
   
   function ok4(returnId){
//     var row = $('#dataTable').datagrid('getSelected');
    if (returnId){
        $.messager.confirm('提示','确定要操作行记录吗？',function(r){
            if (r){
                $.post('${rootPath}/refund/ok4',{returnId:returnId},function(data){
                	
                	if(data.result == 'true' || data.result == true)
					{
//                 		$('#dataTable').datagrid('reload');    // reload the user data
                		$.messager.alert("提示", "确认未结算成功！");
                		goBack(1);
					}
					else
					{
// 						$.messager.alert('提示',data.msg,'error');
						$.messager.alert("提示", "确认未结算失败 ！");
					}                    	
                });
            }
        });
    } else {
 	   $.messager.alert('提示', "请选择你要操作的记录", 'info');
			return;
		}
}
   
   function ok5(returnId){
//     var row = $('#dataTable').datagrid('getSelected');
    if (returnId){
        $.messager.confirm('提示','确定要操作行记录吗？',function(r){
            if (r){
                $.post('${rootPath}/refund/ok5',{returnId:returnId},function(data){
                	
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

//    function ok(returnId)
//    {  
// 	   $.ajax({
// 		   type: "POST",
// 		   url: "${rootPath}/refund/ok",
// 		   data: "returnId="+returnId+"",
// 		   success: function(msg){
// 			   $('#dataTable').datagrid('reload'); 
// 		   }
// 		});
//    }
   
//    function ok1(returnId)
//    {  
// 	   $.ajax({
// 		   type: "POST",
// 		   url: "${rootPath}/refund/ok1",
// 		   data: "returnId="+returnId+"",
// 		   success: function(msg){
// 			   $('#dataTable').datagrid('reload'); 
// 		   }
// 		});
//    }
   
//    function ok2(returnId)
//    {  
// 	   $.ajax({
// 		   type: "POST",
// 		   url: "${rootPath}/refund/ok2",
// 		   data: "returnId="+returnId+"",
// 		   success: function(msg){
// 			   $('#dataTable').datagrid('reload'); 
// 		   }
// 		});
//    }
   
//    function ok3(returnId)
//    {  
// 	   $.ajax({
// 		   type: "POST",
// 		   url: "${rootPath}/refund/ok3",
// 		   data: "returnId="+returnId+"",
// 		   success: function(msg){
// 			   $('#dataTable').datagrid('reload'); 
// 		   }
// 		});
//    }
   
//    function ok4(returnId)
//    {  
// 	   $.ajax({
// 		   type: "POST",
// 		   url: "${rootPath}/refund/ok4",
// 		   data: "returnId="+returnId+"",
// 		   success: function(msg){
// 			   $('#dataTable').datagrid('reload'); 
// 		   }
// 		});
//    }
   
//    function ok5(returnId)
//    {  
// 	   $.ajax({
// 		   type: "POST",
// 		   url: "${rootPath}/refund/ok5",
// 		   data: "returnId="+returnId+"",
// 		   success: function(msg){
// 			   $('#dataTable').datagrid('reload'); 
// 		   }
// 		});
//    }
   

   
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