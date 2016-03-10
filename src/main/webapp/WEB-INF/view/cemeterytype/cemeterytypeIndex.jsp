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
<div class="easyui-panel" title="XX信息管理" style="width:805px">
	<div style="padding: 10px 60px 20px 60px">
		<form id="dataForm" method="post">
				<div class="fitem">
		        	<label>typeId:</label>
		        	<input name="typeId" class="easyui-textbox" >
		    	</div>
				<div class="fitem">
		        	<label>parkId:</label>
		        	<input name="parkId" class="easyui-textbox" >
		    	</div>
				<div class="fitem">
		        	<label>typeCode:</label>
		        	<input name="typeCode" class="easyui-textbox" >
		    	</div>
				<div class="fitem">
		        	<label>typeName:</label>
		        	<input name="typeName" class="easyui-textbox" >
		    	</div>
				<div class="fitem">
		        	<label>typeContent:</label>
		        	<input name="typeContent" class="easyui-textbox" >
		    	</div>
				<div class="fitem">
		        	<label>realUrl:</label>
		        	<input name="realUrl" class="easyui-textbox" >
		    	</div>
				<div class="fitem">
		        	<label>minprice:</label>
		        	<input name="minprice" class="easyui-textbox" >
		    	</div>
				<div class="fitem">
		        	<label>maxprice:</label>
		        	<input name="maxprice" class="easyui-textbox" >
		    	</div>
				<div class="fitem">
		        	<label>priceAreaCode:</label>
		        	<input name="priceAreaCode" class="easyui-textbox" >
		    	</div>
				<div class="fitem">
		        	<label>longitude:</label>
		        	<input name="longitude" class="easyui-textbox" >
		    	</div>
				<div class="fitem">
		        	<label>latitude:</label>
		        	<input name="latitude" class="easyui-textbox" >
		    	</div>
				<div class="fitem">
		        	<label>createdTime:</label>
		        	<input name="createdTime" class="easyui-textbox" >
		    	</div>
				<div class="fitem">
		        	<label>createdBy:</label>
		        	<input name="createdBy" class="easyui-textbox" >
		    	</div>
				<div class="fitem">
		        	<label>modifiedTime:</label>
		        	<input name="modifiedTime" class="easyui-textbox" >
		    	</div>
				<div class="fitem">
		        	<label>modifiedBy:</label>
		        	<input name="modifiedBy" class="easyui-textbox" >
		    	</div>
				<div class="fitem">
		        	<label>version:</label>
		        	<input name="version" class="easyui-textbox" >
		    	</div>
				<div class="fitem">
		        	<label>delflag:</label>
		        	<input name="delflag" class="easyui-textbox" >
		    	</div>
					</form>
	    <div id="buttons" align="center">
	        <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-search" onclick="searchInfo()" style="width:90px">查询</a>
	        <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-empty" onclick="clearForm()" style="width:90px">清空</a>
	    </div>
    </div>
    <table id="dataTable" title="XX列表" style="width:800px;height:350px" >
    </table>    
    <div id="divDialog" class="easyui-window"
		data-options="closed:true,closable:true,collapsible:false,minimizable:false,maximizable:false,modal:true,title:'明细信息维护'"
		style="width: 650px; height: 450px;">
		<iframe id="iframeDialogSelect" frameborder="0" scrolling="yes"	width="100%" height="98%"></iframe>
	</div>
</div>
<script type="text/javascript">
	
	jQuery(function(){	  
   	//初始化列表
   	$('#dataTable').datagrid({
   		iconCls:'icon-tip',
   		singleSelect : true,
   		rownumbers:true,
   		pagination:true,
   		fitColumns:true,
   		method : 'post',		
		idField : 'rowId',//此处根据实际情况进行填写
		columns:[[
							{field:'typeId',title:'typeId',width:80},
							{field:'parkId',title:'parkId',width:80},
							{field:'typeCode',title:'typeCode',width:80},
							{field:'typeName',title:'typeName',width:80},
							{field:'typeContent',title:'typeContent',width:80},
							{field:'realUrl',title:'realUrl',width:80},
							{field:'minprice',title:'minprice',width:80},
							{field:'maxprice',title:'maxprice',width:80},
							{field:'priceAreaCode',title:'priceAreaCode',width:80},
							{field:'longitude',title:'longitude',width:80},
							{field:'latitude',title:'latitude',width:80},
							{field:'createdTime',title:'createdTime',width:80},
							{field:'createdBy',title:'createdBy',width:80},
							{field:'modifiedTime',title:'modifiedTime',width:80},
							{field:'modifiedBy',title:'modifiedBy',width:80},
							{field:'version',title:'version',width:80},
							{field:'delflag',title:'delflag',width:80},
						//注：最后一行后面的逗号要去掉
		]],
		toolbar : [{
			id : 'btnadd',
			text : '添加',
			iconCls : 'icon-add',
			handler : function() {
				addrow();
			}
		}, '-', {
			id : 'btnedit',
			text : '更新',
			iconCls : 'icon-edit',
			handler : function() {
				editrow();
			}
		}, '-', {
			id : 'btndel',
			text : '删除',
			iconCls : 'icon-remove',
			handler : function() {
				delerow();
			}
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
		var fields = $('#dataForm').serializeArray(); //自动序列化表单元素为JSON对象
	
		$.each(fields, function(i, field) {
			queryParams[field.name] = field.value; //设置查询参数
	
		});
		var url = '${rootPath}/cemeteryType/list';
		$('#dataTable').datagrid('reload',url); //设置好查询参数 reload 一下就可以了
	}
	
	//清空查询条件
	function clearForm() {
		$('#dataForm').form('clear');
	
	}

   //新增
   function addrow(){
   		url = '${rootPath}/cemeteryType/edit';
		openWin(url);
   }
   
   //修改
   function editrow(){    	
       var row = $('#dataTable').datagrid('getSelected');
	
       if (row){
       	url = '${rootPath}/cemeteryType/edit?rowId='+ row.rowId;
		openWin(url);
       }
       else
       {
       	$.messager.alert('提示', "请选择你要更新的记录", 'info');
		return;
       }
   }
   
   //删除
   function delerow(){
       var row = $('#dataTable').datagrid('getSelected');
       if (row){
           $.messager.confirm('提示','确定要删除行记录吗？',function(r){
               if (r){
                   $.post('${rootPath}/cemeteryType/del',{rowId:row.rowId},function(data){
                   	
                   	if(data.result == 'true' || data.result == true)
   					{
                   		$('#dataTable').datagrid('reload');    // reload the user data
   					}
   					else
   					{
   						$.messager.alert('提示',data.msg,'error');
   					}                    	
                   });
               }
           });
       }
   }
   
   //点击增加弹出增加窗口
	function openWin(url) {
		$('#iframeDialogSelect').attr("src", url);
		$('#divDialog').window('open');

	}
	
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