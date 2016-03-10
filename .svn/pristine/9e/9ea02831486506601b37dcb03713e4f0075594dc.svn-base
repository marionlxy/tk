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
    <div  style="overflow: hidden;">
			<input type="hidden" name="serviceId">
		<table id="dataTable" title="服务商列表" height="560%">
		</table>
	</div>
	<div id="divDialog"></div>
<script type="text/javascript">
var serviceId;

jQuery(function(){ 
	// 注意：不要读取缓存
	jQuery.ajaxSetup({
		cache : false
	});
	serviceId = '${serviceId}';
	var dictList = getDictList('MultiState');
	$('#dataTable').datagrid({
   		singleSelect : true,
   		rownumbers:true,
   		pagination:true,
   		fitColumns:true,
   		url : '${rootPath}/single/servNumList?serviceId='+serviceId,
   		method : 'post',		
		idField : 'RELATION_ID',//此处根据实际情况进行填写
		columns:[[
						{field:'SERVICE_ID',checkbox : true},
						{field:'RELATION_ID',title:'关联Id',width:80,hidden:true},
						{field:'SELLER_ID',title:'sellerId',width:80,hidden:true},
						{field:'SELLER_CODE',title:'商户编号',width:80},
						{field:'SELLER_NAME',title:'商户名称',width:80},
						{field:'SETTLE_PRICE',title:'结算价格',width:80},
						{field:'SERVICE_MSG',title:'商户描述',width:80},
						{field:'SELLER_TYPE',title:'商户类型',width:60, formatter : function(value, row, index) {
							return getDictName(dictList,"MultiState",value);
						} ,hidden:true},
						{
							field : 'operate',
							title : '操作',
							width : 100,
							formatter : function(value, row,index) {
								return "<a href='#' onclick=delerow('"+row.RELATION_ID+"','"+row.VERSION+"') style='margin-left:10px'>[删除]</a>"
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
	toolbar : [{
		id : 'btnadd',
		text : '添加服务商',
		iconCls : 'icon-add',
		handler : function() {
			addrow();
		}
	},'-', {
		id : 'btnreturn',
		text : '返回主页',
		iconCls : 'icon-add',
		handler : function() {
			goMain();
		}
	}
	],
	onLoadSuccess : function(data) {
		$('#dataTable').datagrid('clearSelections'); //一定要加上这一句，要不然datagrid会记住之前的选择状态，删除时会出问题
	}
	});
});
//添加服务商
	function addrow(){
		serviceId = '${serviceId}';
	    url = '${rootPath}/single/addFacilitator?serviceId='+serviceId;
		$("#divDialog").dialog({
			title : "添加服务商",
			width : 450,
			height : 270,
			href : url,
			cache : false,
			closed : false,
			modal : true
		});
}
	   //表格查询
	function searchInfo() {
		var url = '${rootPath}/single/servNumList?serviceId='+serviceId;
		$('#dataTable').datagrid('reload',url); //设置好查询参数 reload 一下就可以了
	}

	   //点击增加弹出增加窗口
	function openWin(url) {
		$('#iframeDialogSelect').attr("src", url);
		$('#divDialog').window('open');

	}
	
	  //删除
	  var relationId ;
	function delerow(relationId, version){
	      if (relationId && version){
	          $.messager.confirm('提示','确定要删除此服务商记录吗？',function(r){
	              if (r){
	                  $.post('${rootPath}/single/delSellerService',{relationId:relationId,version:version},function(data){
	                   	
	                  if(data.result == 'true' || data.result == true){
	                   		$.messager.alert("提示", "服务商删除成功！");
							goBack(1);
	   					}else{
	   						$.messager.alert("提示", "服务商删除失败 ！");
	   					}                    	
	                   });
	               }
	           });
	       } else {
	    	   $.messager.alert('提示', "请选择你要操作的记录", 'info');
				return;
			}
	   }
	//关闭弹出窗口，返回父页面,根据标记决定是否执行查询操作
	function goBack(flag) {
		if(flag==1)
		{
			searchInfo();
		}
		$("#divDialog").window('close');
	}
	function goMain(){
		window.location.href='${rootPath}/single/goMain';
	}
</script>

</body>
</html>
