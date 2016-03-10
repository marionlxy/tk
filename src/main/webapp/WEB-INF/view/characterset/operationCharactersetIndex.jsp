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
	<div class="easyui-panel" title="查询条件" data-options="region:'north',height:100,collapsible:false,border : false">
		<!-- 注意：form ID 要加 1，用于区别子页面 form -->
		<form id="dataForm111" method="post">
		    <div id="condition" class="container_12" style="position: relative;">
		    <br/>
				<div class="grid_1 lbl">编号:</div>
				<div class="grid_2 val">
					<input name="mealCode" class="easyui-textbox" style="width:60px">
				</div>
				<div class="grid_1 lbl">名称:</div>
				<div class="grid_2 val">
					<input name="mealName" class="easyui-textbox" style="width:60px">
				</div>
				<div class="grid_1 lbl">类型:</div>
				<div class="grid_2 val">
				<input class="easyui-combobox" name="mealType" style="width:80px" panelHeight="auto"
		 				url="${rootPath}/getDictCombox?dictType=GXMEAL_TYPE" valueField="dictId" textField="dictName">
				</div>
				<div class="grid_1 lbl">站点:</div>
				<div class="grid_2 val">
				<input class="easyui-combobox" name="site" style="width:80px" panelHeight="auto"
		 				url="${rootPath}/getDictCombox?dictType=SITE" valueField="dictId" textField="dictName">
				</div>
				<div class="grid_1 lbl">
                 	<a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-search" onclick="searchInfo()" style="width:90px">查询</a>
                </div>
				<div class="grid_2 val">
                	<a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-empty" onclick="clearForm()" style="width:90px">清空</a>
                </div>
			</div>
		</form>
    </div>
    <div data-options="region:'center',border:false" style="overflow: hidden;">
		<table id="dataTable" title="个性套餐信息列表" height="100%"></table>
	</div>
	<div id="divDialog"></div>
</div>

<script type="text/javascript">
	
	jQuery(function(){	  
		jQuery.ajaxSetup({
			cache : false
		});
		
		var dictList = getDictList('GXMEAL_TYPE,SITE');
		
   	//初始化列表
	   	$('#dataTable').datagrid({
	   		iconCls:'icon-tip',
	   		singleSelect : true,
	   		rownumbers:true,
	   		pagination:true,
	   		fitColumns:true,
	   		url : '${rootPath}/characterset/list',
	   		method : 'post',		
			idField : 'MEAL_ID',//此处根据实际情况进行填写
			columns:[[
							{field : 'MEAL_ID',checkbox : true},
							{field:'MEAL_CODE',title:'套餐编号',width:80},
							{field:'MEAL_NAME',title:'套餐名称',width:80},
							{field:'MEAL_TYPE',title:'套餐类型',width:80, formatter : function(value, row, index) {
								return getDictName(dictList,"GXMEAL_TYPE",value);
							}},
							
							{field:'MEAL_CONTE',title:'套餐介绍',width:80 , hidden:true},

							{field:'SITE',title:'站点',width:80 , formatter : function(value, row, index) {
								return getDictName(dictList,"SITE",value);
							}},
							
							{
								field : 'operate',
								title : '操作',
								width : 100,
								formatter : function(value, row,index) {
									return "<a href='#' onclick=viewrow('"+row.MEAL_ID+"') style='margin-left:20px'>[查看详细]</a>"
								}
							},
							{field:'CREATED_TIME',title:'创建日期',width:80,hidden:true},
							{field:'CREATED_BY',title:'创建人员',width:80,hidden:true},
							{field:'MODIFIED_TIME',title:'修改日期',width:80,hidden:true},
							{field:'MODIFIED_BY',title:'修改人员',width:80,hidden:true},
							{field:'VERSION',title:'版本',width:80,hidden:true},
							{field:'DELFLAG',title:'删除标记',width:80,hidden:true}
							//注：最后一行后面的逗号要去掉
							]],
							onLoadSuccess : function(data) {
								$('#dataTable').datagrid('clearSelections'); //一定要加上这一句，要不然datagrid会记住之前的选择状态，删除时会出问题
							}
						});
					   	
					   });
					   
   //表格查询
   var mealId;
	function searchInfo() {
		//查询参数直接添加在queryParams中
		var queryParams = $('#dataTable').datagrid('options').queryParams;
		var fields = $('#dataForm111').serializeArray(); //自动序列化表单元素为JSON对象
	
		$.each(fields, function(i, field) {
			queryParams[field.name] = field.value; //设置查询参数
	
		});                    
		var url = '${rootPath}/characterset/list';
		$('#dataTable').datagrid('reload',url); //设置好查询参数 reload 一下就可以了
	}
	
	//清空查询条件
	function clearForm() {
		$('#dataForm111').form('clear');
		searchInfo();
	}

   //新增
   function addrow(){
	   window.location='${rootPath}/characterset/addcharacterset'; 
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
	 //查看套餐明细
	   function viewrow(mealId){    	
	       if (mealId){
	    	  window.location.href = '${rootPath}/characterset/viewMeal?mealId='+ mealId;
	       }
	       else
	       {
			return;
	       }
	   }
	   //修改GX套餐
	   function editrow(mealId){    	
		
	       if (mealId){
	       window.location.href = '${rootPath}/characterset/editMeal?mealId='+ mealId;
	 	
	   }
	   else
	   {
		return;
	   }
	   }
	   //删除gx套餐
	   function delerow(mealId, version){
//	        var row = $('#dataTable').datagrid('getSelected');
	       if (mealId && version){
	           $.messager.confirm('提示','确定要删除行记录吗？',function(r){
	               if (r){
	                   $.post('${rootPath}/characterset/delMeal',{mealId:mealId,version:version},function(data){
	                   	
	                   	if(data.result == 'true' || data.result == true){
	                   		$.messager.alert("提示", "套餐删除成功！");
							goBack(1);
	   					}else{
	   						$.messager.alert("提示", "套餐删除失败 ！");
	   					}                    	
	                   });
	               }
	           });
	       } else {
				return;
			}
	   }
	   	
</script>
</body>
</html>