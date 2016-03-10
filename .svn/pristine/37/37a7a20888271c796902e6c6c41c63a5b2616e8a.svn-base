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
<div class="easyui-layout" data-options="fit : true,border : false">
	<div class="easyui-panel" title="查询条件" data-options="region:'north',height:125,collapsible:false,border : true" style="overflow: hidden;">
		<form id="dataForm1" method="post" style="height: 140px;">
				<div id="condition" class="container_12" >
				<br/>
				 <div class="grid_1 lbl">退货编号:</div>
					<div class="grid_2 val">
						<input name="returnCode" class="easyui-textbox" >
					</div>
				<div class="grid_1 lbl">用品编号:</div>
					<div class="grid_2 val">
		        		<input name="applianceCoding" class="easyui-textbox" >
					</div>
					<div class="grid_1 lbl">用品名称:</div>
					<div class="grid_2 val">
		        		<input name="applianceName" class="easyui-textbox" >
					</div>
				<div class="grid_1 lbl">退货状态:</div>
					<div class="grid_2 val">
		        		<input class="easyui-combobox" name="returnState" editable="editable" style="width:90px;margin-left: 10px;" 
				 			url="${rootPath}/getDictCombox?dictType=reGoods" valueField="dictId" textField="dictName">
					</div>
	   		<div class="grid_1 lbl" >
                 	<a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-search" onclick="searchInfo()" style="width: 60px; margin-left: 355px; margin-top: 12px;">查询</a>
           </div>
		   <div class="grid_2 val" >
                	&nbsp;&nbsp;<a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-empty" onclick="clearForm()" style="margin-top: 12px;height: 25px; width: 60px; margin-bottom: 0px; border-bottom-width: 1px; margin-left: 420px; padding-left: 0px; padding-right: 0px; padding-top: 0px; border-left-width: 1px; border-right-width: 1px;">清空</a>
          </div>
          </div>
           </form>
    </div>
      <div  data-options="region:'center',border:false" style="overflow: hidden;">
   		 <table id="dataTable" title="退货列表" height="100%" ></table>
    </div>  
    <div id="divDialog" ></div>
</div>
<script type="text/javascript">
	
	jQuery(function(){	
		jQuery.ajaxSetup({
			cache : false
		});
		var dictList = getDictList('reGoods');
   	//初始化列表
   	$('#dataTable').datagrid({
//    		iconCls:'icon-tip',
   		singleSelect : true,
   		rownumbers:true,
   		pagination:true,
   		fitColumns:true,
   		url:'${rootPath}/regoods/list',
   		method : 'post',		
		idField : 'RETURN_ID',//此处根据实际情况进行填写
		columns:[[
							{field : 'ck',checkbox : true},
							{field:'RETURN_CODE',title:'退货编号',width:'15%'},
							{field:'ORDER_CODE',title:'订单编号',width:'20%'},
							{field:'APPLIANCE_CODING',title:'用品编号',width:'10%'},
							{field:'APPLIANCE_NAME',title:'用品名称',width:'16%'},
// 							{field:'LOGISTICS',title:'物流公司',width:70},
// 							{field:'APPLY_NAME',title:'退货申请人',width:70},
							{field:'RETURN_STATE',title:'退货状态',width:'10%' ,formatter : function(value, row,index) {
								return getDictName(dictList,"reGoods",value);
							}},
							{
								field : 'operate',
								title : '操作',
								width : '30%',
								formatter : function(value, row,index) {
									if(row.RETURN_STATE =='0'){
										return "<a href='#' onclick=pass('"+row.RETURN_ID +"','"+row.VERSION +"','1') style='margin-left:10px'>[通过]</a>"
										+"<a href='#' onclick=pass('"+row.RETURN_ID+"','"+row.VERSION+"','2') style='margin-left:10px'>[未通过]</a>";
									}
									if(row.RETURN_STATE =='6'){
										return "<a href='#' onclick=pass('"+row.RETURN_ID+"','"+row.VERSION +"','12') style='margin-left:10px'>[重新发货]</a>"
										+"<a href='#' onclick=pass('"+row.RETURN_ID+"','"+row.VERSION +"','5') style='margin-left:10px'>[商户处理]</a>"
										+"<a href='#' onclick=pass('"+row.RETURN_ID+"','"+row.VERSION +"','7') style='margin-left:10px'>[客户放弃]</a>";
									}
									if(row.RETURN_STATE =='8'){
										return "<a href='#' onclick=pass('"+row.RETURN_ID+"','"+row.VERSION +"','9') style='margin-left:10px'>[退款]</a>";
									}
									if(row.RETURN_STATE =='10'){
										return "<a href='#' onclick=pass('"+row.RETURN_ID+"','"+row.VERSION +"','9') style='margin-left:10px'>[退款]</a>"
										+"<a href='#' onclick=pass('"+row.RETURN_ID+"','"+row.VERSION +"','11') style='margin-left:10px'>[原物返回]</a>";
									}
								}
							}
		]],
		toolbar : [{
// 			id : 'btnadd',
// 			text : '返回',
// 			iconCls : 'icon-back',
// 			handler : function() {
// 				goBack(1);
// 			}
// 		}, '-', {
// 			id : 'btnedit',
// 			text : '更新',
// 			iconCls : 'icon-edit',
// 			handler : function() {
// 				editrow();
// 			}
// 		}, '-', {
// 			id : 'btndel',
// 			text : '删除',
// 			iconCls : 'icon-remove',
// 			handler : function() {
// 				delerow();
// 			}
		}],
		onLoadSuccess : function(data) {
			$('#dataTable').datagrid('clearSelections'); //一定要加上这一句，要不然datagrid会记住之前的选择状态，删除时会出问题
		}
	});
   	
   	//初始化下拉框-示例，请根据需要自定义实现
   	/*
   	 $('#combo1').combobox({    
  	        url:'${rootPath}/getDictlist?dicttypeid=userstatus',    
  	        valueField:'dictid',    
  	        textField:'dictname',
  	     	panelHeight:'auto'
  	    }); 
  	  */ 
   });
   
   //表格查询
	function searchInfo() {
		//查询参数直接添加在queryParams中
		var queryParams = $('#dataTable').datagrid('options').queryParams;
		var fields = $('#dataForm1').serializeArray(); //自动序列化表单元素为JSON对象
	
		$.each(fields, function(i, field) {
			queryParams[field.name] = field.value; //设置查询参数
	
		});
		var url = '${rootPath}/regoods/list';
		$('#dataTable').datagrid('reload',url); //设置好查询参数 reload 一下就可以了
	}
	
	//清空查询条件
	function clearForm() {
		$('#dataForm1').form('clear');
		searchInfo();
	}

   //新增
   function addrow(){
   		url = '${rootPath}/regoods/edit';
		openWin(url);
   }
   
//    // 审核通过
//    function pass(returnId,version,flag){
// 	   if(returnId){
// 	   url = '${rootPath}/regoods/pass?returnId='+returnId+"&version="+version+"&flag="+flag;
// 		$("#divDialog").dialog({
// 			width : 450,
// 			height : 430,
// 			href : url,
// 			cache : false,
// //			modal : true,
// 			minimized:true
			
// 		});
// 		goBack(1);
// 		$("#divDialog").window("close");
// 	   }else{
// 		   $("#divDialog").window("close");
// 		   $.messager.alert('提示',"请选择一条数据",'info');
// 	   }
//    }
   
// 审核通过/不通过
   function pass(returnId,version,flag){
       if (returnId && version && flag){
           $.messager.confirm('提示','确定要操作行记录吗？',function(r){
               if (r){
                   $.post('${rootPath}/regoods/pass',{returnId:returnId,version:version,flag:flag},function(data){
                   	
                   	if(data.result == 'true' || data.result == true)
   					{
                   		$.messager.alert("提示", "操作成功！");
						goBack(1);
   					}
   					else
   					{
   						$.messager.alert("提示", "操作失败 ！");
   					}                    	
                   });
               }
           });
       }else {
    	   $.messager.alert('提示', "请选择你要操作的记录", 'info');
			return;
		}
   }
   
   //点击增加弹出增加窗口
	function openWin(url) {
		$('#iframeDialogSelect').attr("src", url);
		$('#divDialog').window('open');

	}
	
	//关闭弹出窗口，返回父页面,根据标记决定是否执行查询操作
	function goBack(flag) {
		if(flag==1)
		{
			searchInfo();
		}
		$("#divDialog").window('close');
	}
		
</script>
</body>
</html>