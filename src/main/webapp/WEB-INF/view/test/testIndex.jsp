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
	<div class="easyui-panel" title="测试信息管理" style="width: 1105px">
		<div style="padding: 10px 60px 20px 60px">
		<!-- 注意：form ID 要加 1，用于区别子页面 form -->
			<form id="dataForm" method="post" action="${rootPath}/test/downloadTest">
				<div class="fitem">
					<label>测试序号:</label> <input name="serialId" class="easyui-textbox">
				</div>
				<div class="fitem">
					<label>排序:</label> <input name="num" class="easyui-textbox">
				</div>
				<div class="fitem">
					<label>标题:</label> <input name="title" class="easyui-textbox">
				</div>
				<div class="fitem">
					<label>文本:</label> <input name="text" class="easyui-textbox">
				</div>
			</form>
			<div id="buttons" align="center">
				<a href="javascript:void(0)" class="easyui-linkbutton"
					iconCls="icon-search" onclick="searchInfo()" style="width: 90px">查询</a>
				<a href="javascript:void(0)" class="easyui-linkbutton"
					iconCls="icon-empty" onclick="clearForm()" style="width: 90px">清空</a>
			</div>
		</div>

		<div data-options="region:'center',border:false"
			style="overflow: hidden;">
			<table id="dataTable" title="测试列表"
				style="width: 1000px; height: 350px">
			</table>
		</div>
		<div id="divDialog"></div>
	</div>
	<script type="text/javascript">
		jQuery(function() {
			//初始化列表
			$('#dataTable')
					.datagrid(
							{
								iconCls : 'icon-tip',
								singleSelect : true,
								rownumbers : true,
								pagination : true,
								fitColumns : true,
								url : '${rootPath}/test/list',
								method : 'post',
								idField : 'SERIAL_ID',//此处根据实际情况进行填写
								columns : [ [
										{
											field : 'ck',
											checkbox : true
										},
										{
											field : 'SERIAL_ID',
											title : '测试序号',
											width : 80
										},
										{
											field : 'PICTURE',
											title : '图片',
											width : 80,
											align:'center',
											formatter:function(value,row,index){
												//src='"+row.image+"'
												//static/images/form/checkbox1.png
												//1449314678339Chrysanthemum.jpg
												//1449314678336Chrysanthemum.jpg
												return '<img src="static/upload/1449314678336Chrysanthemum.jpg" height="25px" width="25"/>';
										}
										},
										{
											field : 'NUM',
											title : '排序',
											width : 80
										},
										{
											field : 'NAME',
											title : '模块',
											width : 80
										},
										{
											field : 'TITLE',
											title : '标题',
											width : 80
										},
										{
											field : 'TEXT',
											title : '文本',
											width : 80
										},
										{
											field : 'operate',
											title : '操作',
											width : 100,
											formatter : function(value, row,
													index) {
												return "<a href='#' onclick=viewrow('"
														+ row.SERIAL_ID
														+ "') style='margin-left:20px'>[查看详细]</a>"
														+ "<a href='#' onclick=editrow('"
														+ row.SERIAL_ID
														+ "') style='margin-left:10px'>[修改]</a>"
														+ "<a href='#' onclick=delerow('"
														+ row.SERIAL_ID
														+ "') style='margin-left:10px'>[删除]</a>";
											}
										}
								//注：最后一行后面的逗号要去掉
								] ],
								toolbar : [ {
									id : 'btnadd',
									text : '添加测试',
									iconCls : 'icon-add',
									handler : function() {
										addrow();
									}
								}, '-', {
									id : 'btnexport',
									text : '导出',
									iconCls : 'icon-page_excel',
									handler : function() {
										downloadTest();
									}
								} ],
								onLoadSuccess : function(data) {
									$('#dataTable').datagrid('clearSelections'); //一定要加上这一句，要不然datagrid会记住之前的选择状态，删除时会出问题
									var rows = $('#dataTable').datagrid('getRows');
									for (var i = 0; i < rows.length; i++) { 
										console.log(rows[i]['SERIAL_ID']);
									} 
									
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
			var fields = $('#dataForm').serializeArray(); //自动序列化表单元素为JSON对象
			console.log(fields);
			$.each(fields, function(i, field) {
				queryParams[field.name] = field.value; //设置查询参数

			});
			var url = '${rootPath}/test/list';
			$('#dataTable').datagrid('reload', url); //设置好查询参数 reload 一下就可以了
		}

		//清空查询条件
		function clearForm() {
			$('#dataForm').form('clear');

		}

		//导出excel
		function downloadTest() {
			//		 		var url='${rootPath}/seller/downloadSeller';
			//		 		$('#dataForm1').form('load', url);
// 			console.log($("form:first"));
			$("form:first").submit();
		}

		//新增
		function addrow() {
			//			url = '${rootPath}/test/edit';
			//			openWin(url);
			url = '${rootPath}/test/add';
			$("#divDialog").dialog({
				title : "添加测试",
				width : 450,
				height : 450,
				href : url,
				cache : false,
				closed : false,
				modal : true
			});
		}

		//修改
		function editrow(SERIAL_ID) {
			/* 			var row = $('#dataTable').datagrid('getSelected');

			 if (row) {
			 //从页面上的值
			 url = '${rootPath}/test/edit?rowId=' + row.SERIAL_ID;
			 openWin(url);
			 } else {
			 $.messager.alert('提示', "请选择你要更新的记录", 'info');
			 return;
			 } */

			//		     var row = $('#dataTable').datagrid('getSelected');
			if (SERIAL_ID) {
				//		      url = '${rootPath}/seller/edit?rowId='+ row.rowId;
				//		 		openWin(url);

				url = '${rootPath}/test/edit?rowId=' + SERIAL_ID;//对应初始化的idFeild
				$("#divDialog").dialog({
					title : "修改测试信息",
					width : 450,
					height : 400,
					href : url,
					cache : false,
					closed : false,
					modal : true
				});
			} else {
				$.messager.alert('提示', "请选择你要操作的记录", 'info');
				return;
			}
		}

		//删除
		function delerow(SERIAL_ID) {
			//   			var row = $('#dataTable').datagrid('getSelected');
			if (SERIAL_ID) {
				$.messager.confirm('提示', '确定要删除行记录吗？', function(r) {
					if (r) {
						$.post('${rootPath}/test/del', {
							serial_id : SERIAL_ID
						}, function(data) {

							if (data.result == 'true' || data.result == true) {
								$('#dataTable').datagrid('reload'); // reload the user data
							} else {
								$.messager.alert('提示', data.msg, 'error');
							}
						});
					}
				});
			}
		}

		//查看
		function viewrow(SERIAL_ID) {
			if (SERIAL_ID) {
				url = '${rootPath}/test/view?serialId=' + SERIAL_ID;
				$("#divDialog").dialog({
					title : "查看测试信息",
					width : 450,
					height : 450,
					href : url,
					cache : false,
					closed : false,
					modal : true
				});
			} else {
				$.messager.alert('提示', "请选择你要操作的记录", 'info');
				return;
			}
		}
/* 		//点击增加弹出增加窗口
		function openWin(url) {
			$('#iframeDialogSelect').attr("src", url);
			$('#divDialog').window('open');

		} */

		//关闭弹出窗口，返回父页面,根据标记决定是否执行查询操作
		function returnParent(flag) {
			if (flag == 1) {
				searchInfo();
			}
			$("#divDialog").window('close');
		}
		//查看取消
		function goBack(flag) {
			if (flag == 1) {
				searchInfo();
			}
			$("#divDialog").window('close');
		}
	</script>
</body>
</html>