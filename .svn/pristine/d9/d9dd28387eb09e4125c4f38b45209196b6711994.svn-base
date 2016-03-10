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
<div class="easyui-layout" fit="true" data-options="border:false" style="overflow: hidden;">
	<div class="easyui-panel" title="查询条件" data-options="region:'north',height:100,width:100,collapsible:false,border:false" style="overflow: hidden;">
	<form id="dataForm" method="post">
<!-- 		    <br/>
		    <div id="condition" class="container_12" >
				<div class="grid_1 lbl" style="width:60px">天使电话:</div>
				<div class="grid_2 val" style="width:90px">
					<input name="employeeTel" class="easyui-textbox" style="width:90px">
				</div>
				
				<div class="grid_1 lbl" style="margin-left:30px;width:55px">天使姓名:</div>
				<div class="grid_2 val" style="width:80px">
					<input name="employeeName" class="easyui-textbox" style="width:80px" >
				</div>
                <div class="grid_1 lbl" style="width:40px">站点:</div>
				<div class="grid_2 val" style="width:80px">
				<input class="easyui-combobox" name="site" id ="sellerType" style="width:80px" editable="editable" panelHeight="auto"
		 			url="${rootPath}/getDictCombox?dictType=SITE" valueField="dictId" textField="dictName">
				</div>				
				<div class="grid_1 lbl" style="margin-left:60px;">
                 	<a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-search" onclick="searchInfo()" style="width:60px">查询</a>
                </div>
                <div class="grid_2 val" style="margin-left:30px;">
					&nbsp;<a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-empty" onclick="clearForm()" style="width:60px">清空</a>
                </div>
			</div>
			 -->
			 	<table style="width:100%; height:1%; overflow: hidden;" border="0" 
				cellpadding="0" cellspacing="0"  class="kTable" >
				<tr>
				<td class="kTableLabel lbl">天使电话:</td>
				<td>
					<input name="employeeTel" class="easyui-textbox">
				</td>
				<td class="kTableLabel lbl">天使姓名:</td>
				<td>
					<input name="employeeName" class="easyui-textbox" >
				</td>
				<td class="kTableLabel lbl">站点:</td>
				<td>
				<input class="easyui-combobox" name="site" id ="sellerType" style="width:80px" editable="editable" panelHeight="auto"
		 			url="${rootPath}/getDictCombox?dictType=SITE" valueField="dictId" textField="dictName">
				</td>
<!-- 				<td class="kTableLabel lbl">服务状态:</td> -->
<!-- 				<td> -->
<!-- 				<input class="easyui-combobox" name="serviceState" style="width:80px" panelHeight="auto" -->
<%-- 		 				url="${rootPath}/getDictCombox?dictType=servStatus" valueField="dictId" textField="dictName" editable="editable"> --%>
<!-- 				</td> -->
				</tr>
				<tr>
				<td valign="middle" align="center" colspan="6" >
                 	<a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-search" onclick="searchInfo()" style="width:60px">查询</a>
                	&nbsp;&nbsp;<a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-empty" onclick="clearForm()" style="width:60px">清空</a>
                </td>
                </tr>
                </table>
		</form>
	</div>
	<div data-options="region:'center',border:false" style="overflow: hidden">
		 <table id="dataTable" title="天使信息列表" style="height:100%;" >
	     </table> 
	
	</div>
	 <div id="recommendlog" >
	</div>
</div>
<script type="text/javascript">

	jQuery(function() {
		//获取【列表】全部字典数据[订单类型、订单状态]
		var dictList = getDictList('SITE');

		jQuery.ajaxSetup({
			cache : false
		});
		//初始化列表
		$('#dataTable').datagrid({
			singleSelect : true,
			rownumbers : true,
			pagination : true,
			fitColumns : true,
			url : '${rootPath}/employeeSecondAddController/listAngle',
			method : 'post',
			idField : 'EMPLOYEE_CODE',//此处根据实际情况进行填写
			columns : [ [
			// 						{field:'EMPLOYEE_ID',title:'代理人ID',width:80,hidden:true},
			// 						{field:'userId',title:'用户ID',width:80,hidden:true},
			// 						{field:'EMPLOYEE_CODE',title:'代理人工号',width:80},
			{
				field : 'EMPLOYEE_NAME',
				title : '天使姓名',
				width : 80
			},
			// 						{field:'RECOMMEND_CODE',title:'推荐人工号',width:80},
			{
				field : 'EMPLOYEE_TEL',
				title : '天使电话',
				width : 80
			}, {
				field : 'SITE',
				title : '站点',
				width : 60,
				align : 'center',
				formatter : function(value, row, index) {
					return getDictName(dictList, "SITE", value);
				}
			}
			// 						{field:'EMPLOYEE_SEX',title:'代理人性别',width:80,hidden:true},
			// 						{field:'EMPLOYEE_ADDRESS',title:'代理人地址',width:80,hidden:true},
			// 						{field:'VERSION',title:'版本',width:80,hidden:true},
			// 						{field:'TK',title:'操作',width:80,formatter:function(value,row,index){
			// 							return "<a href='javascript:void(0);' onclick=viewHander('"+row.EMPLOYEE_CODE+"') style='margin-left:10px;'>[查看明细]</a><a href='javascript:void(0);' onclick=editHander('"+row.EMPLOYEE_CODE+"') style='margin-left:5px;'>[修改]</a>"
			// 						}}
			//注：最后一行后面的逗号要去掉
			] ],
			onLoadSuccess : function(data) {
				$('#dataTable').datagrid('clearSelections'); //一定要加上这一句，要不然datagrid会记住之前的选择状态，删除时会出问题
			}
		});
	});
	 //表格查询
	function searchInfo() {
		//查询参数直接添加在queryParams中
		var queryParams = $('#dataTable').datagrid('options').queryParams;
		var fields = $('#dataForm').serializeArray(); //自动序列化表单元素为JSON对象
	
		$.each(fields, function(i, field) {
			queryParams[field.name] = field.value; //设置查询参数
	
		});
		var url = '${rootPath}/employeeSecondAddController/listAngle';
		$('#dataTable').datagrid('reload',url); //设置好查询参数 reload 一下就可以了
	}
	//清空查询条件
	function clearForm() {
		$('#dataForm').form('clear');
		searchInfo();
	
	}
</script>
</body>
</html>