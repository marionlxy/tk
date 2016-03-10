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
<div class="easyui-layout" data-options="fit : true,border : false" >
<div class="easyui-panel" title="查询条件111"  data-options="region:'north',height:120,collapsible:false,border : true" style="overflow: hidden;">
		<form id="dataForm1" method="post" action="${rootPath}/worksheet/downloadSeller">
		<div id="condition" class="container_12" style="position: relative;">
		    <br/>
				<tr>	
				<div class="grid_1 lbl">工单编号:</div>
						<div class="grid_2 val">
							<input name="worksheetCode" class="easyui-textbox" style="width:100px">
						</div>		
				<div class="grid_1 lbl" style="float:left;" >客户姓名:</div>
						<div class="grid_2 val">
							<input name="customName" class="easyui-textbox" style="width:100px">
						</div>
			 <div class="grid_1 lbl">开始时间:</div>
						<div class="grid_2 val" >
							<input name="createdTime" class="easyui-datetimebox" style="width:90px">
						</div>
			<div class="grid_1 lbl" >结束时间:</div>
						<div class="grid_2 val">
							<input name="createdTime1" class="easyui-datetimebox" style="width:90px">
						</div>
		</tr>
		<tr>
			<div class="grid_1 lbl" style="float:left;" >客户电话:</div>
						<div class="grid_2 val">
							<input name="customTel"   class="easyui-numberbox" style="width:100px">
						</div>
				<div class="grid_1 lbl"> 天使姓名:</div>
						<div class="grid_2 val">
<!-- 						<input name="angelName" angelCode class="easyui-textbox" style="width:120px"> -->
						      <input class="easyui-combobox"   name="angelName" style="width:100px;" panelHeight="auto"
			      				  url="${rootPath}/worksheet/getAngelList" valueField="angelName" editable="editable" textField="angelName"/>
						</div>	
						<div class="grid_1 lbl"> 工单状态:</div>
						<div class="grid_2 val">
						<input class="easyui-combobox"  editable="editable"  name="worksheetState" style="width:90px;" panelHeight="auto"
			      				 url="${rootPath}/getDictCombox?dictType=WORKSHEET_STATUS" valueField="dictId" textField="dictName"/>
						</div>
				<div class="grid_1 lbl" >
                    <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-search" onclick="searchInfo()" style="width:90px ;margin-top:14px;">查询</a>
                
                </div>
				<div class="grid_2 val" align="center">
                	&nbsp;&nbsp;<a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-empty" onclick="clearForm()" style="width:90px;margin-top:14px;margin-left: 25px;">清空</a>
                </div>
        </tr>					
		    	</div>
			</form>
    </div>
    <div  data-options="region:'center',border:false" style="overflow: hidden;">
    	<table id="dataTable" title="工单列表" height="100%"  ></table>
    </div> 
    <div id="divDialog" ></div>
</div>
<script type="text/javascript">
	
	jQuery(function(){	  
   	//初始化列表
   	jQuery.ajaxSetup({
		cache : false
	});
   	var dictList = getDictList('WORKSHEET_STATUS,SITE');
   	$('#dataTable').datagrid({
   		iconCls:'icon-tip',
   		singleSelect:true,
   		rownumbers:true,
   		pagination:true,
   		fitColumns:true,
   		method : 'post',	
   		url : '${rootPath}/worksheet/list',
		idField : 'WORKSHEET_ID',//此处根据实际情况进行填写
		columns:[[
							{field : 'ck',checkbox : true},
							{field:'WORKSHEET_CODE',title:'工单编号',width:'10%'},
							{field:'CUSTOM_NAME',title:'客户姓名',width:'10%'},
							{field:'SITE',title:'站点',width:60 , formatter : function(value, row, index) {
								return getDictName(dictList,"SITE",value);
							}},
							{field:'CUSTOM_TEL',title:'客户电话',width:'10%'},
							{field:'ANGEL_NAME',title:'天使姓名',width:'10%'},
							{field:'ANGEL_TEL',title:'天使电话',width:'10%'},
							{field:'PROXY_TEL',title:'代理人电话',width:'10%'},
							{field:'CREATED_TIME',title:'创建时间',width:'13%'},
// 							{field:'CREATED_BY',title:'创建人',width:80},
							{field:'WORKSHEET_STATE',title:'工单状态',width:'10%' ,formatter : function(value, row,index) {
								return getDictName(dictList,"WORKSHEET_STATUS",value);
							}},
							{
								field : 'operate',
								title : '操作',
								width : '20%',
								formatter : function(value, row,index) {
								
									if(row.WORKSHEET_STATE =='0'){
										return "<a href='#' onclick=viewrow('"+row.WORKSHEET_ID+"') style='margin-left:20px'>[查看详细]</a>"
										+"<a href='#' onclick=editrow('"+row.WORKSHEET_ID+"') style='margin-left:10px'>[修改]</a>"
										+"<a href='#' onclick=delerow('"+row.WORKSHEET_ID+"','"+row.VERSION+"') style='margin-left:10px'>[删除]</a>"
										+"<a href='#' onclick=worksheet('"+row.WORKSHEET_ID+"','"+row.VERSION+"') style='margin-left:10px'>[未成单]</a>";
									}else{
										return "<a href='#' onclick=viewrow('"+row.WORKSHEET_ID+"') style='margin-left:20px'>[查看详细]</a>"
										+"<a href='#' onclick=editrow('"+row.WORKSHEET_ID+"') style='margin-left:10px'>[修改]</a>"
										+"<a href='#' onclick=delerow('"+row.WORKSHEET_ID+"','"+row.VERSION+"') style='margin-left:10px'>[删除]</a>";
									}
								}
							},
							{field:'ANGEL_OPEN_ID',title:'angelOpenId',width:80,hidden:true},
							{field:'ANGEL_CODE ',title:'angelCode',width:80,hidden:true},
							{field:'CLUE_ID',title:'clueId',width:80,hidden:true},
							{field:'MODIFIED_TIME',title:'modifiedTime',width:80,hidden:true},
							{field:'MODIFIED_BY',title:'modifiedBy',width:80,hidden:true},
							{field:'VERSION',title:'version',width:80,hidden:true},
							{field:'DELFLAG',title:'delflag',width:80,hidden:true}
							
						//注：最后一行后面的逗号要去掉
		]],
		toolbar : [{
			id : 'btnadd',
			text : '添加工单',
			iconCls : 'icon-add',
			handler : function() {
				addrow();
			}
		},'-', {
				id : 'btnexport',
				text : '导出',
				iconCls : 'icon-page_excel',
				handler : function() {
					download();
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
		var url = '${rootPath}/worksheet/list';
		$('#dataTable').datagrid('reload',url); //设置好查询参数 reload 一下就可以了
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
	  //查看
	   function viewrow(worksheetId){    	
	       if (worksheetId){
	    	   	url = '${rootPath}/worksheet/view?worksheetId='+ worksheetId;
		   		$("#divDialog").dialog({
		   			title : "查看工单",
		   			width : 450,
		   			height : 450,
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
   //派工单
   function addrow(){
	   	 window.location='${rootPath}/worksheet/worksheetClue';

   }
   
   //修改
   function editrow(worksheetId){    	
	      if (worksheetId){
//	        url = '${rootPath}/seller/edit?rowId='+ row.rowId;
//	   		openWin(url);
	      	   	url = '${rootPath}/worksheet/edit?worksheetId='+ worksheetId;
	  	   		$("#divDialog").dialog({
	  	   			title : "修改工单信息",
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
   function delerow(worksheetId, version){
       if (worksheetId && version){
           $.messager.confirm('提示','确定要删除行记录吗？',function(r){
               if (r){
                   $.post('${rootPath}/worksheet/del',{worksheetId:worksheetId,version:version},function(data){
                   	
                   	if(data.result == 'true' || data.result == true){
                   		$.messager.alert("提示", "工单删除成功！");
                   		returnParent(1);
   					}else{
   						$.messager.alert("提示", "工单删除失败 ！");
   					}                    	
                   });
               }
           });
       } else {
    	   $.messager.alert('提示', "请选择你要操作的记录", 'info');
			return;
		}
   }
   
   //未成单
   function worksheet(worksheetId, version){
       if (worksheetId && version){
           $.messager.confirm('提示','确定未成单吗？',function(r){
               if (r){
                   $.post('${rootPath}/worksheet/delwork',{worksheetId:worksheetId,version:version},function(data){
                   	
                   	if(data.result == 'true' || data.result == true){
                   		$.messager.alert("提示", "成功！");
                   		returnParent(1);
   					}else{
   						$.messager.alert("提示", "失败 ！");
   					}                    	
                   });
               }
           });
       } else {
    	   $.messager.alert('提示', "请选择你要操作的记录", 'info');
			return;
		}
   }
   
//    //点击增加弹出增加窗口
// 	function openWin(url) {
// 		$('#iframeDialogSelect').attr("src", url);
// 		$('#divDialog').window('open');

// 	}
	
	//关闭弹出窗口，返回父页面,根据标记决定是否执行查询操作
	function returnParent(flag) {
		if(flag==1)
		{
			searchInfo();
		}
		$("#divDialog").window('close');
	}
		
</script>
</body>
</html>