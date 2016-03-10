<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">
	<%@ include file="/include.jsp"%>
    <title>添加个性套餐</title>
</head>
<body>
<div>
	<form id="dataForm9" name="dataForm9" action="${rootPath}/characterset/uploadBySpringGrpCharacter"  method="post" enctype="multipart/form-data" >
		<table id="dataTable2" title="个性套餐基本信息" style="margin-left: 30px">
		<input name="mealId" type="hidden" id="hidSId"/>
		
		<br>
		<div class="fitem" style="width: 700px">
	    	<label>套餐名称:</label>
	        <input name="mealName" class="easyui-textbox" validType="length[0,50]" required="required">
		</div>
		<div class="fitem" style="width: 700px">
	    	<label>站点:</label>
			<input class="easyui-combobox" name="site" id ="site" value="010" style="width:100px" required="required" panelHeight="auto"
		 	url="${rootPath}/getDictCombox?dictType=SITE" valueField="dictId" textField="dictName" />
		</div>
		<div class="fitem" style="width: 700px">
	    	<label style="vertical-align:top;">套餐描述:</label>
			<textarea name="mealConte" style=" border:1px solid #99bbe8;"  rows="4" cols="31" class="easyui-validatebox" validType="length[0,200]" required="required" ></textarea>
		</div>
		<div class="fitem">
	    	<label style="vertical-align:top;">图片上传:</label>
   		 	<input type="file" name="file" id="file" />
	    </div>	
		</table>
		<table id="dataTable" title="环节列表" style="height: 260px"> </table>
		<br>
		<table id="dataTable3" title="服务列表"  style="height: 220px" >
			<input type="hidden" name="linkId"/>
		</table>
		<br>
		<table id="dataTable1" title="用品列表" style="height: 240px">
		<input type="hidden" name="serviceId"/>
		</table>
	<div id="divDialog"></div>
	<div id="divDialog1"></div>
	<div id="divDialog2"></div>
	<div id="divDialog3"></div>
	</form>
    <div id="dlg-buttons" align="center">
       <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-ok"  onclick="saveOrUpdate4()" style="width:90px">确定</a>
       <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-cancel" onclick="goMainS()" style="width:90px">取消</a>
   </div>
</div>
    
<script type="text/javascript">

var linkId;
jQuery(function(){	  
	jQuery.ajaxSetup({
		cache : false
	});
	var site;
	site = $('#site').combobox("getValue");
	//初始化环节列表
   	$('#dataTable').datagrid({
   		iconCls:'icon-tip',
   		singleSelect : true,
   		rownumbers:true,
   		pagination:false,
   		fitColumns:true,
   		method : 'post',	
   		url : '${rootPath}/characterset/ListEmpty',
		idField : 'LINK_ID',//此处根据实际情况进行填写
		columns:[[
						{field : 'LINK_ID',checkbox : true},
						{field:'MEAL_ID',title:'套餐id',width:80,hidden:true},
						{field:'LINK_CODE',title:'环节编号',width:80},
						{field:'LINK_NAME',title:'环节名称',width:80},
						{field:'LINK_NUM',title:'环节序号',width:80},
						{field:'STAGE',title:'阶段名称',width:80 },
						{
							field : 'operate',
							title : '操作',
							width : 100,
							formatter : function(value, row,index) {
								return "<a href='#' onclick=editLink('"+row.LINK_ID+"') style='margin-left:10px'>[修改]</a>"
								+"<a href='#' onclick=delrow('"+row.LINK_ID+"','"+row.VERSION+"') style='margin-left:10px'>[删除]</a>";
							}
						},
						{field:'CREATED_TIME',title:'创建日期',width:80,hidden:true},
						{field:'CREATED_BY',title:'创建人员',width:80,hidden:true},
						{field:'MODIFIED_TIME',title:'修改日期',width:80,hidden:true},
						{field:'MODIFIED_BY',title:'修改人员',width:80,hidden:true},
						{field:'VERSION',title:'版本',width:80,hidden:true},
						{field:'DELFLAG',title:'删除标记',width:80,hidden:true}
						
					//注：最后一行后面的逗号要去掉
	]],toolbar : [{
		id : 'btnadd',
		text : '添加环节',
		iconCls : 'icon-add',
		handler : function() {
			addLink();
		}
		}
	],
	onClickRow:function(linkId){
		var row = $('#dataTable').datagrid('getSelected');
		//$('#ifrDictItem')[0].src = '${ctx}/dictItem/list?dictCode=' + row.dictCode+"&cateCode=" + row.cateCode;
			searchService();
			clearAppliance();
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
   		method : 'post',
   		url : '${rootPath}/characterset/ListEmpty',
		idField : 'SERVICE_ID',//此处根据实际情况进行填写
		columns:[[
						{field :'SRELATION_ID',checkbox : true},
						{field:'SERVICE_ID',title:'服务ID',width:80,hidden:true},
						{field:'SERVICE_NUM',title:'服务编码',width:80},
						{field:'SERVICE_NAME',title:'服务名称',width:80},
						{field:'SITE',title:'站点',width:80,hidden:true },
						{
							field : 'operate',
							title : '操作',
							width : 100,
							formatter : function(value, row,index) {
								return "<a href='#' onclick=delService('"+row.SRELATION_ID+"','"+row.VERSION+"') style='margin-left:10px'>[删除]</a>";
							}
						},
					//注：最后一行后面的逗号要去掉
	]],toolbar : [{
		id : 'btnadd',
		text : '选择服务',
		iconCls : 'icon-add',
		handler : function() {
			checkService();
		}
	} ],
	onClickRow:function(){
		var row = $('#dataTable').datagrid('getSelected');
		//$('#ifrDictItem')[0].src = '${ctx}/dictItem/list?dictCode=' + row.dictCode+"&cateCode=" + row.cateCode;
			searchApplianceInfo();
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
   		method : 'post',	
   		url : '${rootPath}/characterset/ListEmpty',
		idField : 'APPLIANCE_ID',//此处根据实际情况进行填写
		columns:[[
						{field : 'APPLIANCE_ID',checkbox : true},
						{field:'CATEGORY_ID',title:'用品分类',width:50,hidden:true},
						{field:'QUALITY_VALUE_ID',title:'属性值ID',width:50,hidden:true},
						{field:'SKUID',title:'SKUID',width:80,hidden:true},
						{field:'APPLIANCE_CODING',title:'用品编号',width:50 },
						{field:'APPLIANCE_NAME',title:'用品名称',width:50 },
						{field:'APPLIANCE_SETTLE_PRICE',title:'用品结算价',width:80 ,hidden:true},
						{field:'APPLIANCE_MARKETPRICE',title:'用品销售价',width:80 ,hidden:true},
						{field:'SELLER_NAME',title:'商户名称',width:80,hidden:true },
						{field:'SITE',title:'站点',width:80,hidden:true },
						{field:'APPLIANCE_CATEGORY_ID',title:'用品类别ID',width:80 ,hidden:true},
						{
							field : 'operate',
							title : '操作',
							width : 100,
							formatter : function(value, row,index) {
								return "<a href='#' onclick=delAppliance('"+row.APPLIANCE_ID+"','"+row.VERSION+"') style='margin-left:10px'>[删除]</a>";
							}
						},
						{field:'CREATED_TIME',title:'创建日期',width:80,hidden:true},
						{field:'MODIFIED_TIME',title:'修改日期',width:80,hidden:true},
						{field:'VERSION',title:'版本',width:80,hidden:true},
						{field:'DELFLAG',title:'删除标记',width:80,hidden:true}
					//注：最后一行后面的逗号要去掉
	]],toolbar : [{
		id : 'btnadd',
		text : '选择用品',
		iconCls : 'icon-add',
		handler : function() {
			checkAppliance();
		}
	} ],
	onLoadSuccess : function(data) {
		$('#dataTable1').datagrid('clearSelections'); //一定要加上这一句，要不然datagrid会记住之前的选择状态，删除时会出问题
	}
 });
});
	


//修改
function editLink(linkId){
    if (linkId){
    	url = '${rootPath}/characterset/editLink?linkId='+ linkId;
		$("#divDialog").dialog({
			title : "修改环节信息",
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
	return;
}
}

//删除用品
   function delAppliance(applianceId, version){
	   var srelationId;
		$('input[name=SRELATION_ID]:checked').each(
				function(i){
					srelationId = $(this).val();
				});
       if (applianceId && version){
           $.messager.confirm('提示','确定要删除行记录吗？',function(r){
               if (r){
                   $.post('${rootPath}/characterset/delAppliances?srelationId='+srelationId,{applianceId:applianceId,version:version},function(data){
                   	
                   	if(data.result == 'true' || data.result == true){
                   		$.messager.alert("提示", "删除成功！");
						goBack(2);
   					}else{
   						$.messager.alert("提示", "请先删除用品 ！");
   					}                    	
                   });
               }
           });
       } else {
			return;
		}
   }
//删除服务
   function delService(srelationId, version){
		var linkId ="";
	   var srelationId;
		$('input[name=LINK_ID]:checked').each(
				function(i){
					linkId = $(this).val();
				});
		if(linkId ==""){
			alert("请选择环节");
		}else{
		       if (srelationId && version){
		           $.messager.confirm('提示','确定要删除吗？',function(r){
		               if (r){
		                   $.post('${rootPath}/characterset/delService?linkId='+linkId,{srelationId:srelationId,version:version},function(data){
		                   	
		                   	if(data.result == 'true' || data.result == true){
		                   		$.messager.alert("提示", data.msg);
								goBack(3);
		   					}else{
		   						$.messager.alert("提示", "删除失败");
		   					}                    	
		                   });
		               }
		           });
		       } else {
					return;
				}
		}
		

   }
//删除环节
   function delrow(linkId, version){
       if (linkId && version){
           $.messager.confirm('提示','确定要删除行记录吗？',function(r){
               if (r){
                   $.post('${rootPath}/characterset/delLink',{linkId:linkId,version:version},function(data){
                   	
                   	if(data.result == 'true' || data.result == true){
                   		$.messager.alert("提示", "环节删除成功！");
						goBack(1);
   					}else{
   						$.messager.alert("提示", "该环节下有用品 ！");
   					}                    	
                   });
               }
           });
       } else {
			return;
		}
   }
//添加环节
function addLink(){
    url = '${rootPath}/characterset/addLinks';
	$("#divDialog").dialog({
		title : "添加环节",
		width : 450,
		height : 430,
		href : url,
		cache : false,
		closed : false,
		modal : true
	});
}

//查询环节
function searchInfo(){
	var url = '${rootPath}/characterset/linkList';
	$('#dataTable').datagrid('reload',url); //设置好查询参数 reload 一下就可以了

}
//查询用品
function searchApplianceInfo(){
	var srelationId;
	$('input[name=SRELATION_ID]:checked').each(
			function(i){
				srelationId = $(this).val();
			});
	var url='${rootPath}/characterset/applianceShowList?srelationId='+srelationId;
	$('#dataTable1').datagrid('reload',url); //设置好查询参数 reload 一下就可以了
	
}
//保存记录
function saveOrUpdate4()
{
	var r = $('#dataForm9').form('validate');
	if(!r) {
		return false;
	}else{
		$.post("${rootPath}/characterset/saveMeal",$("#dataForm9").serializeArray(),
		function(data)
		{				
			if(data.result == 'true' || data.result == true)
			{	
				$("#hidSId").val(data.sId);
			 	document.dataForm9.submit();
			 	$.messager.alert("提示", data.msg);
			 	goBack(1);
			}
			else
			{	
				$.messager.alert("提示", "添加套餐成功");
				window.location.href='${rootPath}/characterset/goMain';
			}
		});
		
	}
}
function clearAppliance(){
	var url='${rootPath}/characterset/clearList';
	$('#dataTable1').datagrid('reload',url); //设置好查询参数 reload 一下就可以了
}
function goBack(flag) {
	if(flag==1)
	{
		searchInfo();
		$("#divDialog").window('close');
	}else if(flag==2){
		searchApplianceInfo();
		$("#divDialog2").window('close');
	}else if(flag==3){
		searchService()
		$("#divDialog3").window('close');
	}else if(flag==6){
		$("#divDialog").window('close');
	}
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
//选择用品
function checkAppliance(){
	var srelationId = "";
	$('input[name=SRELATION_ID]:checked').each(
			function(i){
				srelationId = $(this).val();
			});
	var site;
	site= $('#site').combobox("getValue");
	if(srelationId == ""){
		alert("请选择服务");
	}else{
		url='${rootPath}/characterset/checkAppliance?srelationId='+ srelationId+'&flag='+site;
		$("#divDialog2").dialog({
			title : "选择用品",
			width : 800,
			height : 430,
			href : url,
			cache : false,
			closed : false,
			modal : true
		});
	}
	
	}
//跳会主页面
function goMainS(){
	window.location.href='${rootPath}/characterset/goMains';
}
//选择服务
function checkService(){
	var linkId = "";
	$('input[name=LINK_ID]:checked').each(
			function(i){
				linkId = $(this).val();
			});
	var site;
	site= $('#site').combobox("getValue");
	if(linkId==""){
		alert("请选择环节");
	}else{
		url='${rootPath}/characterset/checkService?linkId='+ linkId+'&flag='+site;
		$("#divDialog3").dialog({
			title : "选择服务",
			width : 800,
			height : 430,
			href : url,
			cache : false,
			closed : false,
			modal : true
		});
	}
}

$(function(){   
    $('#btn').bind('click', function(){   
        alert('easyui');   
    });   
});  



</script>

</body>
</html>
