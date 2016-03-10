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
	<div class="easyui-panel" title="查询条件" data-options="region:'north',height:80,collapsible:false,border : false">
		<!-- 注意：form ID 要加 1，用于区别子页面 form -->
		<form id="dataForm1" method="post">
		    <div id="condition" class="container_12" style="position: relative;">
		    <br/>
				<div class="grid_1 lbl">商户编号:</div>
				<div class="grid_2 val">
					<input name="basicCode" class="easyui-textbox" >
				</div>
				<div class="grid_1 lbl">商户名称:</div>
				<div class="grid_2 val">
					<input name="basicName" class="easyui-textbox" >
				</div>
				<div class="grid_1 lbl">商户状态:</div>
				<div class="grid_2 val">
				<input class="easyui-combobox" name="basicState" style="width:80px" panelHeight="auto"
		 	url="${rootPath}/getDictCombox?dictType=status" valueField="dictId" textField="dictName">
<!-- 					<select class="easyui-combobox" name="basicState" style="width:80px" panelHeight="60px"> -->
<!-- 				            <option value=""></option> -->
<!-- 							<option value="1">使用中</option> -->
<!-- 							<option value="0">已注销</option> -->
<!-- 				 	</select> -->
				</div>
				<div class="grid_1 lbl">
                 	<a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-search" onclick="searchInfo()" style="width:90px">查询</a>
                </div>
				<div class="grid_2 val">
                	&nbsp;&nbsp;<a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-empty" onclick="clearForm()" style="width:90px">清空</a>
                </div>
			</div>
		</form>
    </div>
    <div data-options="region:'center',border:false" style="overflow: hidden;">
		<table id="dataTable" title="主键配置列表" height="100%"></table>
	</div>
	<div id="divDialog"></div>
</div>
<script type="text/javascript">
	
	jQuery(function(){
		jQuery.ajaxSetup({
			cache : false
		});
		
		// 获取【列表】全部字典数据[商户类型、站点]
		var dictList = getDictList('MultiState,status');
   	
		//初始化列表
	   	$('#dataTable').datagrid({
	   		singleSelect : true,
	   		rownumbers:true,
	   		pagination:true,
	   		fitColumns:true,
	   		url : '${rootPath}/appraise/list',
	   		method : 'post',		
			idField : 'Seq_Type',//此处根据实际情况进行填写
			columns:[[
		          			// 注意：这里是字段名basic_CODE，不是变量名basicCode
							{field :'APPRAISE_ID',checkbox : true},
		          			{field:'APPRAISE_NUM',title:'评价人',width:80},
							{field:'CUSTOM_ID',title:'客户名称',width:80},
							{field:'APPRAISE_BY',title:'评价人',width:80},
							{field:'APPRAISE_MSG',title:'评价信息',width:80},
							{field:'APPRAISE_TYPE',title:'评价类型',width:80},
							{field:'SUB_ORDER',title:'订单号',width:80},
							{
								field : 'operate',
								title : '操作',
								width : 100,
								formatter : function(value, row,index) {
									return "<a href='#' onclick=viewrow('"+row.APPRAISE_ID+"') style='margin-left:20px'>[查看详细]</a>"
									+"<a href='#' onclick=editrow('"+row.basic_ID+"') style='margin-left:10px'>[修改]</a>"
									+"<a href='#' onclick=delerow('"+row.basic_ID+"','"+row.VERSION+"') style='margin-left:10px'>[删除]</a>";
								}
							}
						//注：最后一行后面的逗号要去掉
			]],
			toolbar : [{
				id : 'btnadd',
				text : '添加主键',
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
		var url = '${rootPath}/appraise/list';
		$('#dataTable').datagrid('reload',url); //设置好查询参数 reload 一下就可以了
	}
	
	//清空查询条件
	function clearForm() {
		$('#dataForm1').form('clear');
	
	}

   //新增
   function addrow(){
//    	url = '${rootPath}/basic/add';
// 		openWin(url);
	    url = '${rootPath}/appraise/add';
$("#divDialog").dialog({
			title : "评价信息",
			width : 450,
			height : 360,
			href : url,
			cache : false,
			closed : false,
			modal : true
		});
   }
   
   //修改
   function editrow(basicId){    	
//     var row = $('#dataTable').datagrid('getSelected');
       if (basicId){
//      url = '${rootPath}/basic/edit?rowId='+ row.rowId;
// 		openWin(url);
    	   	url = '${rootPath}/appraise/edit?basicId='+ basicId;
	   		$("#divDialog").dialog({
	   			title : "修改商户信息",
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
   
   //删除
   function delerow(basicId, version){
//        var row = $('#dataTable').datagrid('getSelected');
       if (basicId && version){
           $.messager.confirm('提示','确定要删除行记录吗？',function(r){
               if (r){
                   $.post('${rootPath}/appraise/del',{basicId:basicId,version:version},function(data){
                   	
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
   function viewrow(appraiseId){    
       if (appraiseId){
    	   	url = '${rootPath}/appraise/getOne?appraiseId='+ appraiseId;
    	   $("#divDialog").dialog({
	   			title : "查看商户信息",
	   			width : 450,
	   			height : 360,
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