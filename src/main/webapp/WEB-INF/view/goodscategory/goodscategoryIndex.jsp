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

  <table id="dataTable" title="分类列表"  style="width:500%" ></table>    
    <div id="divDialog">
	</div>
	
	
<script type="text/javascript">


	jQuery(function(){	  
		
	//var dataArr;	
   	//初始化列表
   	$('#dataTable').treegrid({
   		iconCls:'icon-tip',
   		singleSelect : true,
		rownumbers:true,
		pagination:true,
		fit:true,	
		url:'${rootPath}/goodscategory/getMenuList4Tree',
   		method : 'post',		
   		idField:'CATEGORY_ID',    
   	    treeField:'CATEGORY_NAME', //此处根据实际情况进行填写
		columns:[[
							{field:'ck',checkbox:true},
							{field:'CATEGORY_NAME',title:'分类名称',width:380},
							{field:'CATEGORY_CODE',title:'分类编号',width:180},
							{field:'SORT',title:'排序',width:180},
							{field:'CREATED_TIME',title:'创建时间',width:180},
							{field:'CATEGORY_ID',title:'categoryId',width:80,hidden:true},
							{field:'treePath',title:'treePath',width:80,hidden:true},
							{field:'treePathName',title:'treePathName',width:80,hidden:true},
							{field:'createdBy',title:'createdBy',width:80,hidden:true},
							{field:'modifiedTime',title:'modifiedTime',width:80,hidden:true},
							{field:'modifiedBy',title:'modifiedBy',width:80,hidden:true},
							{field:'CATEGORY_GRADE',title:'层级',width:80,hidden:true},
							{field:'version',title:'version',width:80,hidden:true},
							{field:'delflag',title:'delflag',width:80,hidden:true}
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
			$('#dataTable').treegrid('clearSelections'); //一定要加上这一句，要不然treegrid会记住之前的选择状态，删除时会出问题
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
		var queryParams = $('#dataTable').treegrid('options').queryParams;
		var fields = $('#dataForm').serializeArray(); //自动序列化表单元素为JSON对象
	
		$.each(fields, function(i, field) {
			queryParams[field.name] = field.value; //设置查询参数
	
		});
		var url = '${rootPath}/goodscategory/getMenuList4Tree';
		$('#dataTable').treegrid('reload',url); //设置好查询参数 reload 一下就可以了
	}
	
	//清空查询条件
	function clearForm() {
		$('#dataForm').form('clear');
	
	}

   //新增
   function addrow(){
	   
	   var row=$('#dataTable').treegrid('getSelected');	
		var path='0';
	   if(row){
		   path=row.CATEGORY_CODE;
	   }
   		url = '${rootPath}/goodscategory/addAuto?treePath='+path;
   		$("#divDialog").dialog({
			title : "添加分类",
			width : 450,
			height : 430,
			href : url,
			cache : false,
			closed : false,
			modal : true
		});
		//openWin(url);
   }
   
   //修改
   function editrow(){    	
       var row = $('#dataTable').treegrid('getSelected');
       
       if (row){
       	url = '${rootPath}/goodscategory/edit?rowId='+ row.CATEGORY_ID;
    	$("#divDialog").dialog({
			title : "编辑菜单",
			width : 450,
			height : 430,
			href : url,
			cache : false,
			closed : false,
			modal : true
		});
		//openWin(url);
       }
       else
       {
       	$.messager.alert('提示', "请选择你要更新的记录", 'info');
		return;
       }
   }
   
   //删除
   function delerow(){
       var row = $('#dataTable').treegrid('getSelected');
       if (row){
           $.messager.confirm('提示','确定要删除行记录吗？',function(r){
               if (r){
                   $.post('${rootPath}/goodscategory/del',{rowId:row.CATEGORY_ID},function(data){
                   	
                   	if(data.result == 'true' || data.result == true)
   					{
                   		$('#dataTable').treegrid('reload');    // reload the user data
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
	
	function goBack(flag) {
		if (flag == 1) {
			url = '${rootPath}/goodscategory/getMenuList4Tree', $('#dataTable')
					.treegrid('reload');
		}
		$("#divDialog").window('close');
	}
</script>
</body>
</html>