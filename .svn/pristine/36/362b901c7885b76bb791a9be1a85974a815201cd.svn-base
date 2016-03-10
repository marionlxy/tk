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
		<div  data-options="region:'north',height:100,border : false">
		<!-- 注意：form ID 要加 1，用于区别子页面 form -->
		<form id="dataForm1" method="post">
			<table style="width:100%; height:1%; overflow: hidden;" border="0" 
				cellpadding="0" cellspacing="0"  class="kTable" >
			 <tr>
				 <td class="kTableLabel lbl">用品编号:</td>
				 <td><input name="applianceCoding" class="easyui-textbox" ></td>
				 <td class="kTableLabel lbl">商户名称:</td>
				 <td><input name="sellerName" class="easyui-textbox" ></td> 				
			 	<td class="kTableLabel lbl">用品名称:</td>
				  <td><input name="applianceName" class="easyui-textbox" ></td>
				
			 </tr>
			  <tr>
				 <td class="kTableLabel lbl">用品状态:</td>
				 <td><input class="easyui-combobox" editable="false" name="ismarketable" style="width:80px" panelHeight="auto"url="${rootPath}/getDictCombox?dictType=appliance" 
					   valueField="dictId" textField="dictName"></td>
<!-- 				 <td class="kTableLabel">天使姓名:</td> -->
<!-- 				 <td><input name="angelName" class="easyui-textbox" ></td>  -->
<!-- 				 <td class="kTableLabel lbl">站点:</td> -->
<!-- 				 <td><input class="easyui-combobox" editable="false" name="serviceSite" style="width:80px" panelHeight="auto" -->
<%-- 		 				url="${rootPath}/getDictCombox?dictType=SITE" valueField="dictId" textField="dictName"> --%>
<!-- 				</td> -->
				  <td class="kTableLabel lbl">用品分类:</td>
				 <td><input name="categoryId" class="easyui-combotree" data-options="url:'${rootPath}/goodscategory/getComTree?id=0',method:'get'" style="width:180px;">
				</td>
			 </tr>		
			  <tr>
				 <td class="kTableLabel lbl"></td>
				  <td></td>
				 <td class="kTableLabel lbl"></td>
				 <td>
				</td>
			 	<td valign="middle" align="center" colspan="6" >
			 		<a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-search" onclick="searchInfo()" style="width:90px">查询</a>              
                	&nbsp;&nbsp;<a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-empty" onclick="clearForm()" style="width:90px">清空</a>
			 	</td>
			 </tr>			 
			</table>
		
		<!--  
		    <div id="condition" class="container_12" style="position: relative;">
				<div class="grid_1 lbl">用品编号:</div>
				<div class="grid_2 val">
					<input name="applianceCoding" class="easyui-textbox" >
				</div>

				<div class="grid_1 lbl">商户名称:</div>
				<div class="grid_2 val">
					<input name="sellerName" class="easyui-textbox" >
				</div>
				
				<div class="grid_1 lbl">用品分类:</div>
				<div class="grid_2 val">
					 <input name="categoryId" class="easyui-combotree" data-options="url:'${rootPath}/goodscategory/getComTree?id=0',method:'get'" style="width:160px;">
				</div>
				
				<div class="grid_1 lbl">用品状态:</div>
				<div class="grid_2 val">
				<input class="easyui-combobox" name="ismarketable" style="width:80px" panelHeight="auto"url="${rootPath}/getDictCombox?dictType=appliance" 
					   valueField="dictId" textField="dictName">
				</div>

				<div class="grid_1 lbl">站点:</div>
				<div class="grid_2 val">
				<input class="easyui-combobox" name="serviceSite" style="width:80px" panelHeight="auto"
		 				url="${rootPath}/getDictCombox?dictType=SITE" valueField="dictId" textField="dictName">
				</div>
				
					<div class="grid_1 lbl"></div>
	                <div class="grid_2 val">
	                    <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-search" onclick="searchInfo()" style="width:90px">查询</a>
	                </div>
	                
	                <div class="grid_1 lbl">
	                     <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-empty" onclick="clearForm()" style="width:90px">清空</a>
	                </div>
	                
	                <div class="grid_2 val"></div>			

			</div>
			-->
		</form>
    </div>
    <div data-options="region:'center',border:false" style="overflow: hidden">
		<table id="dataTable" title="用品列表" height="100%"></table>
	</div>
	<div id="divDialog"></div>
</div>
<script type="text/javascript">
	
	jQuery(function(){
		
		jQuery.ajaxSetup({
			cache : false
		});
		

		// 获取【列表】全部字典数据[用品状态]
		var dictList = getDictList('appliance,SITE');
   	
		//初始化列表
	   	$('#dataTable').datagrid({
	   		singleSelect : false,
	   		rownumbers:true,
	   		pagination:true,
	   		fitColumns:true,
	   		url : '${rootPath}/product/list',
	   		method : 'post',		
			idField : 'APPLIANCE_ID',//此处根据实际情况进行填写
			columns:[[
							{field:'APPLIANCE_ID',checkbox : true},
							{field:'APPLIANCE_CODING',title:'用品编号',width:$(this).width() * 0.15,align:'center'},
							{field:'CATEGORY_NAME',title:'用品分类',width:$(this).width() * 0.1,align:'center'},
							{field:'APPLIANCE_NAME',title:'用品名称',width:$(this).width() * 0.15,align:'center'},
							{field:'APPLIANCE_SETTLE_PRICE',title:'用品结算价',width:$(this).width() * 0.1,align:'center'},
							{field:'APPLIANCE_MARKETPRICE',title:'用品销售价',width:$(this).width() * 0.1,align:'center'},
							{field:'SELLER_NAME',title:'商户名称',width:$(this).width() * 0.1,align:'center'},
							{field:'ISMARKETABLE',title:'用品状态',width:$(this).width() * 0.1,align:'center',formatter : function(value, row,index) {
								return getDictName(dictList,"appliance",value);
							}},
							{field:'SERVICE_SITE',title:'站点',width:$(this).width() * 0.3,align:'center',formatter : function(value, row,index) {
								return getDictName(dictList,"SITE",value);
							}},
							{field:'CREATED_TIME',title:'创建日期',width:$(this).width() * 0.2,align:'center'},
							{
								field : 'operate',
								title : '操作',
								width:$(this).width() * 0.25,align:'center',
								formatter : function(value, row,index) {
									if(row.ISMARKETABLE=="3"){
										return "<a href='#' onclick=viewrow('"+row.APPLIANCE_ID+"') >[查看详细]</a>"
										+"<span style='margin-left:10px;color:#7e7789;'>[修改]</span>";										
									}else{
										return "<a href='#' onclick=viewrow('"+row.APPLIANCE_ID+"') >[查看详细]</a>"
										+"<a href='#' onclick=editrow('"+row.APPLIANCE_ID+"') style='margin-left:10px'>[修改]</a>";
									}
								}
							},
							{field:'CATEGORY_ID',title:'分类ID',width:80,hidden:true},
							{field:'INTERFLOW_PRICE',title:'物流费',width:80,hidden:true},
							{field:'QUALITY_VALUE_ID',title:'属性值ID',width:80,hidden:true},
							{field:'MODIFIED_TIME',title:'修改日期',width:80,hidden:true},
							{field:'CREATED_BY',title:'创建人',width:80,hidden:true},
							{field:'MODIFIED_BY',title:'修改人',width:80,hidden:true},
							{field:'IS_RETURN_BILLS',title:'是否允许退货',width:80,hidden:true},
							{field:'APPLIANCE_UNIT',title:'用品寓意',width:80,hidden:true},
							{field:'SERVICE_SITE',title:'站点',width:80,hidden:true},
							{field:'DELFLAG',title:'delflag',width:80,hidden:true},
							{field:'VERSION',title:'version',width:80,hidden:true}
						//注：最后一行后面的逗号要去掉
			]],
			toolbar : [{
				id : 'btnadd',
				text : '同意上架',
				iconCls : 'icon-accept',
				handler : function() {
					piliangs();
				}
 			},'-', {
				id : 'btnadd',
				text : '不同意上架',
				iconCls : 'icon-cancel',
				handler : function() {
					piliangsNo();
				}
 			},'-', {
 				id : 'btnedit',
 				text : '同意下架',
 				iconCls : 'icon-accept',
 				handler : function() {
 					piliangx();
 				}
 			},'-', {
 				id : 'btnedit',
 				text : '不同意下架',
 				iconCls : 'icon-cancel',
 				handler : function() {
 					piliangxNo();
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
		var url = '${rootPath}/product/list';
		$('#dataTable').datagrid('reload',url); //设置好查询参数 reload 一下就可以了
	}
	
	//清空查询条件
	function clearForm() {
		$('#dataForm1').form('clear');
	}

   //新增
   function addrow(){
	   
		//初始化列表
//	   	$('#dataTable').datagrid('appendRow',{
//			APPLIANCE_CODING:'asdasdas',
//			APPLIANCE_NAME:'1232'			
//		});
			//var index= $('#dataTable').datagrid('appendRow',{
			//}).datagrid('getRows').length-1;
			//$('#dataTable').datagrid('beginEdit',index)
			
//   	   	url = '${rootPath}/appliance/add';
//	   		$("#divDialog").dialog({
//	   			title : "修改商品信息",
//	   			width : 450,
//	   			height : 430,
//	   			href : url,
//	   			cache : false,
//	   			closed : false,
//	   			modal : true
//	   		});
	   window.location='${rootPath}/appliance/add'; 

   }
   
   //修改
   function editrow(applianceId){    	
       if (applianceId){
//    	   	url = '${rootPath}/appliance/edit?applianceId='+ applianceId;
//	   		$("#divDialog").dialog({
//	   			title : "修改商品信息",
//	   			width : 450,
//	   			height : 430,
//	   			href : url,
//	   			cache : false,
//	   			closed : false,
//	   			modal : true
//	   		});
	   	 window.location='${rootPath}/product/edit?applianceId='+ applianceId; 
       }
       else
       {
       	$.messager.alert('提示', "请选择你要操作的记录", 'info');
		return;
       }
   }
   
   //删除
   function delerow(applianceId, version){
//        var row = $('#dataTable').datagrid('getSelected');
       if (applianceId && version){
           $.messager.confirm('提示','确定要删除行记录吗？',function(r){
               if (r){
                   $.post('${rootPath}/product/del',{applianceId:applianceId,version:version},function(data){
                   	
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
   	
   //查看
   function viewrow(applianceId){    	
       if (applianceId){
//   	   	url = '${rootPath}/appliance/view?applianceId='+ applianceId;
//	   		$("#divDialog").dialog({
//	   			title : "查看商户信息",
//	   			width : 450,
//	   			height : 430,
//	   			href : url,
//	   			cache : false,
//	   			closed : false,
//	   			modal : true
//	   		});
	   	 window.location='${rootPath}/product/view?applianceId='+ applianceId;
       }
       else
       {
       	$.messager.alert('提示', "请选择你要操作的记录", 'info');
		return;
       }
   }
   
   //点击增加弹出增加窗口
// 	function openWin(url) {
// 		$('#iframeDialogSelect').attr("src", url);
// 		$('#divDialog').window('open');

// 	}
	
	//关闭弹出窗口，返回父页面,根据标记决定是否执行查询操作
// 	function returnParent(flag) {
// 		if(flag==1)
// 		{
// 			searchInfo();
// 		}
// 		$("#divDialog").window('close');
// 	}
	function goBack(flag) {
		if (flag == 1) {
			searchInfo();
		}
	}
	
	
	//修改同意上架
	  function piliangs(){
			var applianceId = "";
			$('input[name=APPLIANCE_ID]:checked').each(
					function(i){
						applianceId += $(this).val() + ",";
				});
			
			if(applianceId==null||applianceId==""){
				$.messager.alert("提示", "请选择用品");
			}
			else{
					applianceId = applianceId.substr(0,applianceId.length-1);
					$.post("${rootPath}/product/saveLinkServers?applianceId="+applianceId,$("#dataForm1").serializeArray(),
					function(data)
					{			
						if(data.result == 'true' || data.result == true)
						{
						 	$.messager.alert("提示", data.msg);
						 	goBack(1);
					}
						else
						{
							$.messager.alert("提示", data.msg);
						}
					});
			}
			
	}
		//修改不同意上架
	  function piliangsNo(){
			var applianceId = "";
			$('input[name=APPLIANCE_ID]:checked').each(
					function(i){
						applianceId += $(this).val() + ",";
				});
			
			if(applianceId==null||applianceId==""){
				$.messager.alert("提示", "请选择用品");
			}
			else{
					applianceId = applianceId.substr(0,applianceId.length-1);
					$.post("${rootPath}/product/saveLinkServersNo?applianceId="+applianceId,$("#dataForm1").serializeArray(),
					function(data)
					{			
						if(data.result == 'true' || data.result == true)
						{
						 	$.messager.alert("提示", data.msg);
						 	goBack(1);
					}
						else
						{
							$.messager.alert("提示", data.msg);
						}
					});
			}
			
	}
	 
	//修改同意下架
	  function piliangx(){
			var applianceId = "";
			$('input[name=APPLIANCE_ID]:checked').each(
					function(i){
						applianceId += $(this).val() + ",";
				});
			
			if(applianceId==null||applianceId==""){
				$.messager.alert("提示", "请选择用品");
			}
			else{
					applianceId = applianceId.substr(0,applianceId.length-1);
					$.post("${rootPath}/product/saveLinkServerx?applianceId="+applianceId,$("#dataForm1").serializeArray(),
					function(data)
					{			
						if(data.result == 'true' || data.result == true)
						{
						 	$.messager.alert("提示", data.msg);
						 	goBack(1);
					}
						else
						{
							$.messager.alert("提示", data.msg);
						}
					});
			}
			
	}
		//修改不同意下架
	  function piliangxNo(){
			var applianceId = "";
			$('input[name=APPLIANCE_ID]:checked').each(
					function(i){
						applianceId += $(this).val() + ",";
				});
			
			if(applianceId==null||applianceId==""){
				$.messager.alert("提示", "请选择用品");
			}
			else{
					applianceId = applianceId.substr(0,applianceId.length-1);
					$.post("${rootPath}/product/saveLinkServerxNo?applianceId="+applianceId,$("#dataForm1").serializeArray(),
					function(data)
					{			
						if(data.result == 'true' || data.result == true)
						{
						 	$.messager.alert("提示", data.msg);
						 	goBack(1);
					}
						else
						{
							$.messager.alert("提示", data.msg);
						}
					});
			}
			
	}
		
</script>
</body>
</html>