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
    <div data-options="region:'center',border:false" style="overflow: hidden;">
		<table id="dataTable" title="优惠列表" height="100%"></table>
	</div>
	<div id="divDialog"></div>
</div>
<script type="text/javascript">
	
	jQuery(function(){
		
		jQuery.ajaxSetup({
			cache : false
		});
		
		//初始化列表
	   	$('#dataTable').datagrid({
	   		singleSelect : true,
	   		rownumbers:true,
	   		pagination:true,
	   		fitColumns:true,
	   		url : '${rootPath}/prefer/list',
	   		method : 'post',		
			idField : 'PREFER_ID',//此处根据实际情况进行填写
			columns:[[
		          			// 注意：这里是字段名SELLER_CODE，不是变量名sellerCode
							{field : 'ck',checkbox : true},
		          			{field:'LOWER_LIMIT',title:'订单总额下限(￥)',width:"16%",align:"center"},
							{field:'UPPER_LIMIT',title:'订单总额上限(￥)',width:"16%",align:"center"},
							{field:'PREFER_MINI',title:'最小优惠幅度(￥)',width:"16%",align:"center"},
							{field:'PREFER_MAX',title:'最大优惠幅度(￥)',width:"20%",align:"center"},
							{
								field : 'operate',
								title : '操作',
								width : 80,
								formatter : function(value, row,index) {
									return "<a href='#' onclick=editrow('"+row.PREFER_ID+"') style='margin-left:40px'>[修改]</a>"
									+"<a href='#' onclick=delerow('"+row.PREFER_ID+"','"+row.VERSION+"') style='margin-left:20px'>[删除]</a>";
								}
							},
							{field:'PREFER_ID',title:'preferId',width:80,hidden:true},
							{field:'PREFER_MINI',title:'preferMini',width:80,hidden:true},
							{field:'VERSION',title:'version',width:80,hidden:true}
						//注：最后一行后面的逗号要去掉
			]],
			toolbar : [{
				id : 'btnadd',
				text : '添加优惠',
				iconCls : 'icon-add',
				handler : function() {
					addrow();
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
		var url = '${rootPath}/prefer/list';
		$('#dataTable').datagrid('reload',url); //设置好查询参数 reload 一下就可以了
	}
	
	//清空查询条件
	function clearForm() {
		$('#dataForm1').form('clear');
	
	}

   //新增
   function addrow(){
	    url = '${rootPath}/prefer/add';
		$("#divDialog").dialog({
			title : "添加优惠信息",
			width : 450,
			height : 230,
			href : url,
			cache : false,
			closed : false,
			modal : true
		});
   }
   
   //修改
   function editrow(preferId){    	
       if (preferId){
    	   	url = '${rootPath}/prefer/edit?preferId='+ preferId;
	   		$("#divDialog").dialog({
	   			title : "修改优惠信息",
	   			width : 450,
	   			height : 230,
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
   function delerow(preferId, version){
       if (preferId && version){
           $.messager.confirm('提示','确定要删除行记录吗？',function(r){
               if (r){
                   $.post('${rootPath}/prefer/del',{preferId:preferId,version:version},function(data){
                   	
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
	function goBack(flag) {
		if (flag == 1) {
			searchInfo();
		}
		$("#divDialog").window('close');
	}
   function formatNumber(number){
	   number = number.replace(/,/g);
	   var digit =number.indexOf('.');
	   var int =number.substr(0,digit);
	   var i ;
	   var mag = new Array();
	   var word;
	   if(number.indexOf('.'==-1)){
		   i= number.length;
		   while(i>0){
			   word = number.substring(i,i-3);
			   mag.number.unshift(word);
		   }
		   number = mag;
	   }else{
		   i = int.length;
		   while(i>0){
			   word = int.substring(i,i-3);
			   i-=3;
			   mag.unshift(word);
		   }
		   number = mag + number.substring(digit);
	   }
	   return number;
	   
   }
</script>
</body>
</html>