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
		<div class="easyui-panel" title="查询条件"
			data-options="region:'north',height:100,collapsible:false,border : false"
			style="margin-top: 20px">
			<!-- 注意：form ID 要加 1，用于区别子页面 form -->
			<form id="dataForm1" method="post">
				<table style="width: 100%; height: 1%; overflow: hidden;" border="0"
					cellpadding="0" cellspacing="0" class="kTable">
					<tr>
						<td class="kTableLabel">陵园编号:</td>
						<td><input name="cemeteryCode" validType="length[0,50]" class="easyui-textbox">
						</td>
						<td class="kTableLabel">陵园名称:</td>
						<td><input name="cemeteryName" validType="length[0,50]" class="easyui-textbox">
						</td>
						<%-- <td class="kTableLabel">陵园类型:</td>
					<td>
						<input class="easyui-combobox" name="cemeteryType"  style="width:100px" panelHeight="auto"
					 			url="${rootPath}/getDictCombox?dictType=cemeteryType" valueField="dictId" textField="dictName">
					</td> --%>
						<td class="kTableLabel">站点:</td>
						<td><input class="easyui-combobox" name="site" id="site"
							style="width: 100px" panelHeight="auto" editable="editable"
							url="${rootPath}/getDictCombox?dictType=SITE" valueField="dictId"
							textField="dictName"></td>
						<td class="kTableLabel">地区:</td> 
						<td><input class="easyui-combobox" name="areacode" id="areacode"
							url="${rootPath}/getDictCombox?dictType=AREACODE"
							style="width: 100px"  editable="editable" data-options="valueField:'dictId', textField:'dictName'"></td> 
					</tr>
					<tr>
						<td valign="middle" align="center" colspan="6"><a
							href="javascript:void(0)" class="easyui-linkbutton"
							iconCls="icon-search" onclick="searchInfo()" style="width: 90px">查询</a>
						</td>
						<td>&nbsp;&nbsp;<a href="javascript:void(0)"
							class="easyui-linkbutton" iconCls="icon-empty"
							onclick="clearForm()" style="width: 90px">清空</a>
						</td>
					</tr>
				</table>
			</form>
		</div>
		<div data-options="region:'center',border:false"
			style="overflow: hidden;">
			<table id="dataTable" title="陵园列表" height="100%"></table>
		</div>
		<div id="divDialog"></div>
	</div>
	<script type="text/javascript">
	
		jQuery(function() {
			//省市联动
			$('#site').combo({ onChange:changeLinkageBy});
			
			jQuery.ajaxSetup({
				cache : false
			});
			//获取字典项
			var dictList = getDictList('cemeteryType,SITE,AREACODE');

			//初始化列表
			$('#dataTable')
					.datagrid(
							{
								singleSelect : true,
								rownumbers : true,
								pagination : true,
								fitColumns : true,
								url : '${rootPath}/cemetery/list',
								method : 'post',
								idField : 'cemeteryId',//此处根据实际情况进行填写
								columns : [ [
										{
											field : 'CEMETERY_ID',
											checkbox : true
										},
										// 							{field:'CEMETERY_ID',title:'墓地ID',width:80,hidden:true},
										{
											field : 'CEMETERY_CODE',
											title : '陵园编号',
											width : 70
										},
										{
											field : 'CEMETERY_NAME',
											title : '陵园名称',
											width : 70
										},
										{
											field : 'CEMETERY_CONTENT',
											title : '陵园介绍',
											width : 80,
											hidden : true
										},
										{
											field : 'CEMETERY_TYPE',
											title : '陵园类型',
											width : 30,
											hidden : true,
											formatter : function(value, row,
													index) {
												return getDictName(dictList,
														"cemeteryType", value);
											}
										},
										{
											field : 'CEMETERY_ADDRASS',
											title : '陵园地址',
											width : 140,
										},
										{
											field : 'REAL_URL',
											title : '实景图片',
											width : 80,
											hidden : true
										},
										{
											field : 'SIGNAL_URL',
											title : '示意图',
											width : 80,
											hidden : true
										},
										{
											field : 'LONGITUDE',
											title : '经度',
											width : 80,
											hidden : true
										},
										{
											field : 'LATITUDE',
											title : '纬度',
											width : 80,
											hidden : true
										},
										{
											field : 'SITE',
											title : '站点',
											width : 30,
											formatter : function(value, row,
													index) {
												return getDictName(dictList,
														"SITE", value);
											}
										},
										{
											field : 'AREACODE',
											title : '城市区域',
											width : 60,
											formatter : function(value, row,
													index) {
												return getDictName(dictList,
														"AREACODE", value);
											}
										},
										{
											field : 'operate',
											title : '操作',
											width : 160,
											formatter : function(value, row,
													index) {
												return "<a href='#' onclick=viewrow('"
														+ row.CEMETERY_ID
														+ "') style='margin-left:20px'>[查看详细]</a>"
														+ "<a href='#' onclick=editrow('"
														+ row.CEMETERY_ID
														+ "','"
														+ row.VERSION
														+ "') style='margin-left:10px'>[修改]</a>"
														+ "<a href='#' onclick=delerow('"
														+ row.CEMETERY_ID
														+ "','"
														+ row.VERSION
														+ "') style='margin-left:10px'>[删除]</a>";
											}
										}, {
											field : 'CREATED_TIME',
											title : '创建时间',
											width : 80,
											hidden : true
										}, {
											field : 'CREATED_BY',
											title : '创建人',
											width : 80,
											hidden : true
										}, {
											field : 'MODIFIED_TIME',
											title : '修改时间',
											width : 80,
											hidden : true
										}, {
											field : 'MODIFIED_BY',
											title : '修改人',
											width : 80,
											hidden : true
										}, {
											field : 'VERSION',
											title : '版本',
											width : 80,
											hidden : true
										}, {
											field : 'DELFLAG',
											title : '删除标记',
											width : 80,
											hidden : true
										}
								//注：最后一行后面的逗号要去掉
								] ],
								toolbar : [ {
									id : 'btnadd',
									text : '添加陵园',
									iconCls : 'icon-add',
									handler : function() {
										addrow();
									}
								} ],
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
			var url = '${rootPath}/cemetery/list';
			$('#dataTable').datagrid('reload', url); //设置好查询参数 reload 一下就可以了
		}

		//清空查询条件
		function clearForm() {
			$('#dataForm1').form('clear');
			searchInfo();

		}

		//查看墓地详细
		function viewrow(cemeteryId) {
			if (cemeteryId) {
				window.location.href = '${rootPath}/cemetery/view?cemeteryId='
						+ cemeteryId;
			} else {
				$.messager.alert('提示', "请选择你要操作的记录", 'info');
				return;
			}
		}

		//新增
		function addrow() {
			url = '${rootPath}/cemetery/add';
			$("#divDialog").dialog({
				title : "添加陵园",
				width : 450,
				height : 450,
				href : url,
				cache : false,
				closed : false,
				modal : true
			});
		}

		//修改
		function editrow(cemeteryId) {

			if (cemeteryId) {
				window.location.href = '${rootPath}/cemetery/edit?cemeteryId='
						+ cemeteryId;
			} else {
				$.messager.alert('提示', "请选择你要操作的记录", 'info');
				return;
			}
		}

		//删除
		function delerow(cemeteryId, version) {
			if (cemeteryId && version) {
				$.messager.confirm('提示', '确定要删除此陵园吗？该操作将会删除该陵园下的所有园区和墓型！', function(r) {
					if (r) {
						$.post('${rootPath}/cemetery/del', {
							cemeteryId : cemeteryId,
							version : version
						}, function(data) {
							if (data.result == 'true' || data.result == true) {
								$.messager.alert("提示", data.msg);
								returnParent(1);
							} else {
								$.messager.alert("提示", "陵园删除失败 ！");
							}
						});
					}
				});
			} else {
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
		function returnParent(flag) {
			if (flag == 1) {
				searchInfo();
				$('#divDialog').window('close');
			}

		}
		
	//区域联动
			function changeLinkageBy(){
			var site = $("#site").combobox('getValue');
			URL="${rootPath}/sys/dictEntry/getAreaList?site="+site;//区域请求地址
			var areacode = $('#areacode');
		    $.getJSON(URL,function(date){
		    	areacode.combobox('clear');//改变前清空下拉框的值，否则显示有问题
		    	areacode.combobox('loadData',date);//将返回的json对象放到下拉框中
		    	
		   }); 
	   }
	
	   
	</script>
</body>
</html>