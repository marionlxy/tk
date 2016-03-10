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
		<form id="dataForm2" method="post">
			    	<table style="width:100%; height:1%; overflow: hidden;" border="0" 
				cellpadding="0" cellspacing="0"  class="kTable" >
				<tr>
				<td class="kTableLabel lbl">服务编号:</td>
				<td>
					<input name="serviceNum" class="easyui-textbox" >
				</td>
				<td class="kTableLabel lbl">服务名称:</td>
				<td>
					<input name="serviceName" class="easyui-textbox" >
				</td>
				<td class="kTableLabel lbl">服务分类:</td>
				<td>
				<input class="easyui-combobox" name="serviceType" style="width:80px" panelHeight="auto"
		 				url="${rootPath}/getDictCombox?dictType=servType" valueField="dictId" textField="dictName" editable="editable">
				</td>
				<td class="kTableLabel lbl">服务状态:</td>
				<td>
				<input class="easyui-combobox" name="serviceState" style="width:80px" panelHeight="auto"
		 				url="${rootPath}/getDictCombox?dictType=servStatus" valueField="dictId" textField="dictName" editable="editable">
				</td>
				</tr>
				<tr>
				<td valign="middle" align="center" colspan="6" >
                 	<a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-search" onclick="searchInfo()" style="width:90px">查询</a>
                	&nbsp;&nbsp;<a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-empty" onclick="clearForm()" style="width:90px">清空</a>
                </td>
                </tr>
                </table>
		</form>
    </div>
    <div data-options="region:'center',border:false" style="overflow: hidden;">
		<table id="dataTable" title="单项服务列表" height="100%"></table>
	</div>
	<div id="divDialog"></div>
</div>

<script type="text/javascript">
	
	jQuery(function(){	  
		jQuery.ajaxSetup({
			cache : false
		});
		
		var dictList = getDictList('servType,servStatus');
		
   	//初始化列表
	   	$('#dataTable').datagrid({
	   		iconCls:'icon-tip',
	   		singleTableSelect : true,
	   		rownumbers:true,
	   		pagination:true,
	   		fitColumns:true,
	   		url : '${rootPath}/singleTable/list',
	   		method : 'post',		
			idField : 'Service_Id',//此处根据实际情况进行填写
			columns:[[
							{field : 'SERVICE_ID',checkbox : true,hidden:true},
							//{field:'SERVICE_ID',title:'serviceId',width:80,hidden:true},
							{field:'SERVICE_NUM',title:'服务编号',width:80},
							{field:'SERVICE_NAME',title:'服务名称',width:80},
							{field:'SERVICE_TYPE',title:'服务分类',width:80, formatter : function(value, row, index) {
								return getDictName(dictList,"servType",value);
							}},
							{field:'SERVICE_MSG',title:'服务描述',width:80},
							{field:'PURCHASE_PRICE',title:'采购价格',width:80,hidden:true},
							{field:'SELL_PRICE',title:'销售价格',width:80},
							{field:'FACILITATOR_COUNT',title:'服务商数量',width:80, hidden:true},
							{field:'SERVICE_STATE',title:'状态',width:60, formatter : function(value, row, index) {
								return getDictName(dictList,"servStatus",value);
							}},
							{field:'SITE',title:'站点',width:80,hidden:true},
							{field:'MORAL',title:'寓意',width:80,hidden:true},
							{
								field : 'operate',
								title : '操作',
								width : 100,
								formatter : function(value, row,index) {
									return "<a href='#' onclick=viewrow('"+row.SERVICE_ID+"') style='margin-left:20px'>[查看详细]</a>";
								}
							},
							{field:'PICTURE_URL',title:'pictureUrl',width:80,hidden:true},
							{field:'SELL_COUNT',title:'销量',width:80,hidden:true},
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
		var fields = $('#dataForm2').serializeArray(); //自动序列化表单元素为JSON对象
	
		$.each(fields, function(i, field) {
			queryParams[field.name] = field.value; //设置查询参数
	
		});
		var url = '${rootPath}/singleTable/list';
		$('#dataTable').datagrid('reload',url); //设置好查询参数 reload 一下就可以了
	}
	
	//清空查询条件
	function clearForm() {
		$('#dataForm2').form('clear');
	
	}

   //新增
   function addrow(){
//    	url = '${rootPath}/seller/add';
// 		openWin(url);
	    url = '${rootPath}/singleTable/add';
		$("#divDialog").dialog({
			title : "添加单项服务",
			width : 450,
			height : 430,
			href : url,
			cache : false,
			closed : false,
			modal : true
		});
   }
   
   
   //查看
   function viewrow(serviceId){    	
       if (serviceId){
    	   	url = '${rootPath}/singleTable/view?serviceId='+ serviceId;
	   		$("#divDialog").dialog({
	   			title : "查看单项服务信息",
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
   
   //修改
   function editrow(serviceId){    	
	
       if (serviceId){
       	url = '${rootPath}/singleTable/edit?serviceId='+ serviceId;
   		$("#divDialog").dialog({
   			title : "修改单项服务信息",
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
   function delerow(serviceId, version){
//        var row = $('#dataTable').datagrid('getSelected');
       if (serviceId && version){
           $.messager.confirm('提示','确定要删除行记录吗？',function(r){
               if (r){
                   $.post('${rootPath}/singleTable/del',{serviceId:serviceId,version:version},function(data){
                   	
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
	
	//单项服务上架
	function shelves(){
			var serviceId;
			$('input[type=checkbox]:checked').each(
					function(i){
						serviceId = $(this).val();
					});
	       if (serviceId){
	          	url = '${rootPath}/singleTable/shelves?serviceId='+ serviceId;
	      		$("#divDialog").dialog({
	      			title : "单项服务上架",
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
	
	//单项服务下架
	function soldOut(){
		var serviceId;
		$('input[type=checkbox]:checked').each(
				function(i){
					serviceId = $(this).val();
				});
       if (serviceId){
          	url = '${rootPath}/singleTable/soldOut?serviceId='+ serviceId;
      		$("#divDialog").dialog({
      			title : "单项服务下架",
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
	
	//选择服务商
	function servNum(serviceId){
	       if (serviceId){
	    	  window.location.href = '${rootPath}/singleTable/servNum?serviceId='+ serviceId;
	      }
	       else
		      {
		      	$.messager.alert('提示', "请选择你要操作的记录", 'info');
		   	return;
		   }
	}
		
</script>
</body>
</html>