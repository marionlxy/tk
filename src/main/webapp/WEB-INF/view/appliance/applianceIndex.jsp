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
		<div  data-options="region:'north',height:70,border : false">
		<!-- 注意：form ID 要加 1，用于区别子页面 form -->
		<form id="dataForm1" method="post">
		    <div class="container_12" style="position: relative;">
				<div class="grid_1 lbl">用品编号:</div>
				<div class="grid_2 val">
					<input name="applianceCoding" class="easyui-textbox" >
				</div>
				<div class="grid_1 lbl">用品名称:</div>
				<div class="grid_2 val">
					<input name="applianceName" class="easyui-textbox" >
				</div>
				<div class="grid_1 lbl">用品分类:</div>
				<div class="grid_2 val">
					 <input name="categoryId" class="easyui-combotree" data-options="url:'${rootPath}/goodscategory/getComTree?id=0',method:'get'" style="width:180px;">
				</div>
				
				<div class="grid_1 lbl">用品状态:</div>
				<div class="grid_2 val">
				<input class="easyui-combobox" editable="false" name="ismarketable" style="width:80px" panelHeight="auto"url="${rootPath}/getDictCombox?dictType=appliance" 
					   valueField="dictId" textField="dictName">
				</div>
	                
	                <div class="grid_1 lbl"></div>
	                <div class="grid_2 val">
	                    <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-search" onclick="searchInfo()" style="width:90px">查询</a>
	                </div>
	                
	                <div class="grid_1 lbl">
	                     <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-empty" onclick="clearForm()" style="width:90px">清空</a>
	                </div>
	                
	                <div class="grid_2 val"></div>
			</div>
		</form>
    </div>
    <div data-options="region:'center',border:false" style="overflow: hidden;">
		<table id="dataTable" title="商品列表" height="100%"></table>
	</div>
	<div id="divDialog"></div>
</div>
<script type="text/javascript">
	
	jQuery(function(){
		
		jQuery.ajaxSetup({
			cache : false
		});
		
		// 获取【列表】全部字典数据[用品状态]
		var dictList = getDictList('appliance');
   	
		//初始化列表
	   	$('#dataTable').datagrid({
	   		singleSelect : false,
	   		rownumbers:true,
	   		pagination:true,
	   		fitColumns:true,
	   		url : '${rootPath}/appliance/list',
	   		method : 'post',		
			idField : 'APPLIANCE_ID',//此处根据实际情况进行填写
			columns:[[
							{field:'APPLIANCE_ID',checkbox : true},
							{field:'APPLIANCE_CODING',title:'用品编号',width:$(this).width() * 0.15,align:'center',fit:true},
							{field:'CATEGORY_NAME',title:'用品分类',width:$(this).width() * 0.1,align:'center',fit:true},
							{field:'APPLIANCE_NAME',title:'用品名称',width:$(this).width() * 0.2,align:'center',fit:true},
							{field:'APPLIANCE_SETTLE_PRICE',title:'用品结算价',width:$(this).width() * 0.1,align:'center',fit:true},
							{field:'ISMARKETABLE',title:'用品状态',width:$(this).width() * 0.1,align:'center',fit:true,formatter : function(value, row,index) {
								return getDictName(dictList,"appliance",value);
							}},
							{field:'CREATED_TIME',title:'创建日期',width:$(this).width() * 0.2,align:'center',fit:true},
							{
								field : 'operate',
								title : '操作',
								width:$(this).width() * 0.25,
								fit:true,
								formatter : function(value, row,index) {
										return "<a href='#' onclick=viewrow('"+row.APPLIANCE_ID+"') style='margin-left:20px'>[查看详细]</a>"
										+"<a href='#' onclick=editrow('"+row.APPLIANCE_ID+"') style='margin-left:10px'>[修改]</a>"
										+"<a href='#' onclick=delerow('"+row.APPLIANCE_ID+"','"+row.VERSION+"') style='margin-left:10px'>[删除]</a>";
								}
							}
						//注：最后一行后面的逗号要去掉
			]],
			toolbar : [{
				id : 'btnadd',
				text : '添加商品',
				iconCls : 'icon-add',
				handler : function() {
					addrow();
				}
 			}, '-', {
 				id : 'btnedit',
 				text : '申请上架',
 				iconCls : 'icon-application_get',
 				handler : function() {
 					piliangs();
 				}
 			}, '-', {
 				id : 'btndel',
 				text : '申请下架',
 				iconCls : 'icon-download',
 				handler : function() {
 					piliangx();
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
		var url = '${rootPath}/appliance/list';
		$('#dataTable').datagrid('reload',url); //设置好查询参数 reload 一下就可以了
	}
	
	//清空查询条件
	function clearForm() {
		$('#dataForm1').form('clear');
	}

   //新增
   function addrow(){
	   
		//初始化列表
//	   	$('#dataTable').datagrid('appendRow',{
//			APPLIANCE_CODING:'asdasdas',
//			APPLIANCE_NAME:'1232'			
//		});
			//var index= $('#dataTable').datagrid('appendRow',{
			//}).datagrid('getRows').length-1;
			//$('#dataTable').datagrid('beginEdit',index)
			
//   	   	url = '${rootPath}/appliance/add';
//	   		$("#divDialog").dialog({
//	   			title : "修改商品信息",
//	   			width : 450,
//	   			height : 430,
//	   			href : url,
//	   			cache : false,
//	   			closed : false,
//	   			modal : true
//	   		});
	   window.location='${rootPath}/appliance/add'; 

   }
   
 //修改
  function piliangs(){
		var applianceId = "";
		$('input[name=APPLIANCE_ID]:checked').each(
				function(i){
					applianceId += $(this).val() + ",";
			});
		
		if(applianceId==null||applianceId==""){
			$.messager.alert("提示", "请选择用品");
		}
		else{
				applianceId = applianceId.substr(0,applianceId.length-1);
				$.post("${rootPath}/appliance/saveLinkServers?applianceId="+applianceId,$("#dataForm1").serializeArray(),
				function(data)
				{			
					if(data.result == 'true' || data.result == true)
					{
					 	$.messager.alert("提示", data.msg);
					 	goBack(1);
				}
					else
					{
						$.messager.alert("提示", data.msg);
					}
				});
		}
		
}
 
//修改
  function piliangx(){
		var applianceId = "";
		$('input[name=APPLIANCE_ID]:checked').each(
				function(i){
					applianceId += $(this).val() + ",";
			});
		
		if(applianceId==null||applianceId==""){
			$.messager.alert("提示", "请选择用品");
		}
		else{
				applianceId = applianceId.substr(0,applianceId.length-1);
				$.post("${rootPath}/appliance/saveLinkServerx?applianceId="+applianceId,$("#dataForm1").serializeArray(),
				function(data)
				{			
					if(data.result == 'true' || data.result == true)
					{
					 	$.messager.alert("提示", data.msg);
					 	goBack(1);
				}
					else
					{
						$.messager.alert("提示", data.msg);
					}
				});
		}
		
}
   
   //修改
   function editrow(applianceId){    	
       if (applianceId){
//    	   	url = '${rootPath}/appliance/edit?applianceId='+ applianceId;
//	   		$("#divDialog").dialog({
//	   			title : "修改商品信息",
//	   			width : 450,
//	   			height : 430,
//	   			href : url,
//	   			cache : false,
//	   			closed : false,
//	   			modal : true
//	   		});
	   	 window.location='${rootPath}/appliance/edit?applianceId='+ applianceId; 
       }
       else
       {
       	$.messager.alert('提示', "请选择你要操作的记录", 'info');
		return;
       }
   }
   
   //删除
   function delerow(applianceId, version){
//        var row = $('#dataTable').datagrid('getSelected');
       if (applianceId && version){
           $.messager.confirm('提示','确定要删除行记录吗？',function(r){
               if (r){
                   $.post('${rootPath}/appliance/del',{applianceId:applianceId,version:version},function(data){
                   	
                   	if(data.result == 'true' || data.result == true){
                   		$.messager.alert("提示", "删除成功！");
						goBack(1);
   					}else{
   						$.messager.alert("提示", "删除失败 ！");
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
   function viewrow(applianceId){    	
       if (applianceId){
//   	   	url = '${rootPath}/appliance/view?applianceId='+ applianceId;
//	   		$("#divDialog").dialog({
//	   			title : "查看商户信息",
//	   			width : 450,
//	   			height : 430,
//	   			href : url,
//	   			cache : false,
//	   			closed : false,
//	   			modal : true
//	   		});
	   	 window.location='${rootPath}/appliance/view?applianceId='+ applianceId;
       }
       else
       {
       	$.messager.alert('提示', "请选择你要操作的记录", 'info');
		return;
       }
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
	}
		
</script>
</body>
</html>