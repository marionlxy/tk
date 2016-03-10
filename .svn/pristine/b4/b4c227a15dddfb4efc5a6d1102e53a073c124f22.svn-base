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
<div>
<form id="dataForm13">
	<table id="dataTable2" title="个性套餐基本信息" style="margin-left: 30px">
		<br>
		<input type="hidden" name="mealId">
		<input type="hidden" name="version">
		<input type="hidden" name="linkId">
		<div class="fitem" style="width: 700px">
	    	<label>套餐名称:</label>
	        <input name="mealName" class="easyui-textbox" validType="length[0,50]" required="required" disabled>
		</div>
		<div class="fitem" style="width: 700px">
	    	<label>站点:</label>
			<input class="easyui-combobox" name="site" id ="site" value="010" style="width:100px" required="required" panelHeight="auto"
		 	url="${rootPath}/getDictCombox?dictType=SITE" valueField="dictId" textField="dictName" disabled/>
		</div>
		<div class="fitem" style="width: 700px">
	    	<label style="vertical-align:top;">套餐描述:</label>
			<textarea name="mealConte" style=" border:1px solid #99bbe8;"  rows="4" cols="31" class="easyui-validatebox" validType="length[0,200]" required="required" disabled></textarea>
		</div>	
		<tr>
		<td colspan="3"  valign="middle" align="center" name="mealPicture" id="mealPicture" required="required" style="padding-left: 60px">
					<img src="${mealPicture}" width="150" height="100" />
	      </td>
	      </tr>	
		</table>
		<table id="dataTable" title="环节列表" style="height: 260px"> </table>
		<br>
		<table id="dataTable3" title="服务列表"  style="height: 220px" >
			<input type="hidden" name="linkId"/>
		</table>
		<br>
		<table id="dataTable1" title="用品列表" style="height: 240px">
		<input type="hidden" name="linkId"/>
		</table>
	<div id="divDialog"></div>
	<div id="divDialog1"></div>
	<div id="divDialog2"></div>
	<div id="divDialog3"></div>
	</form>
</div>
 <div id="dlg-buttons" align="center">
       <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-cancel" onclick="goMainS()" style="width:90px">取消</a>
   </div>
</div>   
<script type="text/javascript">
var mealId;
var linkId;
jQuery(function(){	  
	jQuery.ajaxSetup({
		cache : false
	});
	var site;
	site = $('#site').combobox("getValue");
	mealId = '${mealId}';
	linkId = '${linkId}';
	//初始化环节列表
   	$('#dataTable').datagrid({
   		iconCls:'icon-tip',
   		singleSelect : true,
   		rownumbers:true,
   		pagination:false,
   		fitColumns:true,
   		url:'${rootPath}/characterset/editLinkList?mealId='+mealId,
   		method : 'post',		
		idField : 'LINK_ID',//此处根据实际情况进行填写
		columns:[[
						{field : 'LINK_ID',checkbox : true},
						{field:'MEAL_ID',title:'套餐id',width:80,hidden:true},
						{field:'LINK_CODE',title:'环节编号',width:80},
						{field:'LINK_NAME',title:'环节名称',width:80},
						{field:'LINK_NUM',title:'环节序号',width:80},
						{field:'STAGE',title:'阶段名称',width:80 },
						{field:'CREATED_TIME',title:'创建日期',width:80,hidden:true},
						{field:'CREATED_BY',title:'创建人员',width:80,hidden:true},
						{field:'MODIFIED_TIME',title:'修改日期',width:80,hidden:true},
						{field:'MODIFIED_BY',title:'修改人员',width:80,hidden:true},
						{field:'VERSION',title:'版本',width:80,hidden:true},
						{field:'DELFLAG',title:'删除标记',width:80,hidden:true}
						
					//注：最后一行后面的逗号要去掉
	]],
	onClickRow:function(linkId){
		var row = $('#dataTable').datagrid('getSelected');
		//$('#ifrDictItem')[0].src = '${ctx}/dictItem/list?dictCode=' + row.dictCode+"&cateCode=" + row.cateCode;
			searchService();
			searchApplianceInfo1();
	},
	onLoadSuccess : function(data) {
		$('#dataTable').datagrid('clearSelections'); //一定要加上这一句，要不然datagrid会记住之前的选择状态，删除时会出问题
	}
   	});
	
	
  //初始化服务列表
   	$('#dataTable3').datagrid({
   		iconCls:'icon-tip',
   		singleSelect : true,
   		rownumbers:true,
   		pagination:false,
   		fitColumns:true,
   		url:'${rootPath}/characterset/ListEmpty',
   		method : 'post',		
		idField : 'SERVICE_ID',//此处根据实际情况进行填写
		columns:[[
						{field :'SERVICE_ID',checkbox : true},
						{field:'SERVICE_NUM',title:'服务编码',width:80},
						{field:'SERVICE_NAME',title:'服务名称',width:80},
						{field:'SITE',title:'站点',width:80,hidden:true },
	
					//注：最后一行后面的逗号要去掉
	]],
	onClickRow:function(serviceId){
		var row = $('#dataTable').datagrid('getSelected');
		//$('#ifrDictItem')[0].src = '${ctx}/dictItem/list?dictCode=' + row.dictCode+"&cateCode=" + row.cateCode;
			searchApplianceInfo1();
	},
	onLoadSuccess : function(data) {
		$('#dataTable3').datagrid('clearSelections'); //一定要加上这一句，要不然datagrid会记住之前的选择状态，删除时会出问题
	}
 });
	
  //初始化用品列表
   	$('#dataTable1').datagrid({
   		iconCls:'icon-tip',
   		singleSelect : true,
   		rownumbers:true,
   		pagination:false,
   		fitColumns:true,
   		url:'${rootPath}/characterset/ListEmpty',
   		method : 'post',		
		idField : 'APPLIANCE_ID',//此处根据实际情况进行填写
		columns:[[
						{field : 'APPLIANCE_ID',checkbox : true},
						{field:'CATEGORY_ID',title:'用品分类',width:80,hidden:true},
						{field:'QUALITY_VALUE_ID',title:'属性值ID',width:80,hidden:true},
						{field:'SKUID',title:'SKUID',width:80,hidden:true},
						{field:'APPLIANCE_CODING',title:'用品编号',width:80 },
						{field:'APPLIANCE_NAME',title:'用品名称',width:80 },
						{field:'APPLIANCE_SETTLE_PRICE',title:'用品结算价',width:80 ,hidden:true},
						{field:'APPLIANCE_MARKETPRICE',title:'用品销售价',width:80 ,hidden:true},
						{field:'SELLER_NAME',title:'商户名称',width:80,hidden:true },
						{field:'SITE',title:'站点',width:80,hidden:true },
						{field:'APPLIANCE_CATEGORY_ID',title:'用品类别ID',width:80 ,hidden:true},
						{field:'ISMARKETABLE',title:'是否上架',width:80 ,hidden:true},
						{field:'IS_RETURN_BILLS',title:'是否允许退货',width:80 ,hidden:true},
						{field:'INTERFLOW_PRICE',title:'物流费',width:80 ,hidden:true},
						{field:'CREATED_TIME',title:'创建日期',width:80,hidden:true},
						{field:'MODIFIED_TIME',title:'修改日期',width:80,hidden:true},
						{field:'VERSION',title:'版本',width:80,hidden:true},
						{field:'DELFLAG',title:'删除标记',width:80,hidden:true}
					//注：最后一行后面的逗号要去掉
	]],
	onLoadSuccess : function(data) {
		$('#dataTable1').datagrid('clearSelections'); //一定要加上这一句，要不然datagrid会记住之前的选择状态，删除时会出问题
	}
 });
});
	




//查询单个套餐

jQuery(function(){ 
	mealId ='${mealId}';
	if (mealId != null && mealId != "" && mealId!=0){
		var url='${rootPath}/characterset/getOneMeal?mealId=' + mealId;
		$('#dataForm13').form('load', url);

	}
	
});

//查询环节
function searchInfo(){
	var mealId;
	mealId='${mealId}'
	var url = '${rootPath}/characterset/linkLists?mealId='+mealId;
	$('#dataTable').datagrid('reload',url); //设置好查询参数 reload 一下就可以了

}
//查询用品
function searchApplianceInfo(){
	var serviceId;
	$('input[name=SERVICE_ID]:checked').each(
			function(i){
				srelationId = $(this).val();
			});
	var url='${rootPath}/characterset/applianceShowList?serviceId='+serviceId;
	$('#dataTable1').datagrid('reload',url); //设置好查询参数 reload 一下就可以了
	
}

function searchApplianceInfo1(){
	var serviceId;
	$('input[name=SERVICE_ID]:checked').each(
			function(i){
				serviceId = $(this).val();
			});
	$('input[name=LINK_ID]:checked').each(
			function(i){
				linkId = $(this).val();
			});
	var url='${rootPath}/characterset/appliancesShowList1?serviceId='+serviceId+'&linkId='+linkId;
	$('#dataTable1').datagrid('reload',url); //设置好查询参数 reload 一下就可以了
	
}

//查询服务
function searchService(){
	 var linkId;
		$('input[name=LINK_ID]:checked').each(
				function(i){
					linkId = $(this).val();
				});
	  url = '${rootPath}/characterset/viewServer?linkId='+ linkId;
	  $('#dataTable3').datagrid('reload',url);
}
//跳会主页面
function goMainS(){
	window.location.href='${rootPath}/characterset/goMains';
}
function goBack(flag) {
	if(flag==1){
		searchInfo();
		$("#divDialog").window('close');
	}else if(flag==2){
		searchApplianceInfo();
		$("#divDialog2").window('close');
	}else if(flag==3){
		searchService()
		$("#divDialog3").window('close');
}
}
</script>

</body>
</html>
