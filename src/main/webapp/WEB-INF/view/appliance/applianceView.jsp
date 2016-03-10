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
    <link rel="stylesheet" href="<%=basePath%>/static/js/kindeditor/plugins/code/prettify.css" />
	<link rel="stylesheet" href="<%=basePath%>/static/js/kindeditor/themes/default/default.css" />
	<script charset="utf-8" src="<%=basePath%>/static/js/kindeditor/kindeditor.js"></script>
	<script charset="utf-8" src="<%=basePath%>/static/js/kindeditor/zh_CN.js"></script>
	<script charset="utf-8" src="<%=basePath%>/static/js/kindeditor/plugins/code/prettify.js"></script>
</head>
<body>
<div>
<div id="tt" class="easyui-tabs" style="width:100%;">  
	<div title="用品信息" style="padding:20px;"> 
	<form id="dataForm1">
	    <input type="hidden" name="applianceId">
		<input type="hidden" name="version">
		<div class="fitem" id="divTab1">
	    	<label>用品类别:</label>
	        <input name="categoryId" class="easyui-combotree" data-options="url:'${rootPath}/goodscategory/getCategoryComboTree',method:'get',required:true" style="width:205px;" disabled>
	    </div>
	    
		<div class="fitem">
	    	<label>用品名称:</label>
	    	<!-- <input type="checkbox" onclick="aa()" > -->
	        <input name="applianceName" class="easyui-textbox" validType="length[0,100]" required="required" disabled>
		</div>
		
		<div class="fitem">
	    	<label>用品结算价格:</label>
	        <input name="applianceSettlePrice" class="easyui-numberbox"  precision="2" groupSeparator="," decimalSeparator="." 
	        												prefix="￥" validType="length[0,10]" required="required" disabled></input>
		</div>
		
		<div class="fitem">
	    	<label>物流费:</label>
	        <input name="interflowPrice" class="easyui-textbox" validType="length[0,12]"  value="暂时不用" disabled>
		</div>
		
		<div class="fitem">
	    	<label style="vertical-align:top;">用品寓意:</label>
	    	<input name="applianceUnit" class="easyui-textbox" validType="length[0,50]" required="required" disabled>
	    </div>
	      <div class="fitem">
	    	<label style="vertical-align:top;">图片展示:</label>
	    	<c:forEach  items="${pictureDtoList}" var="measure" varStatus="s">
   		 		<img src="${measure.PICTURE_ADDRESS}" style="width: 100px;height: 100px;">
   		 	</c:forEach>
	    </div>
	</form>
    <div id="dlg-buttons" align="center">
       <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-cancel" onclick="goBackindex()" style="width:90px">取消</a>
   </div>
   </div>
    <div title="用品属性信息"  >  
   		 <table id="dataTable2" title="用品属性列表" style="width:98%;margin:10px;" disabled></table>
    </div>  
    
     <div title="编辑器" >  
    	<div class="fitem">
	    	<textarea id="content" name="describe"  style="width: 100%;" disabled></textarea>
	    </div>
    </div> 
    
</div>
</div>
<div id="divDialog2"></div>
    
<script type="text/javascript">

var applianceId;
jQuery(function(){ 
	
	/**
	 * 编辑器
	 */
	var content;
	KindEditor.ready(function(K) {
		content = K.create('#content', {
				allowFileManager : true,
				uploadJson : '${rootPath}//main/kindeditor/upload/',
				items : [
					 		'source', '|', 'undo', 'redo', '|', 'preview', 'print', 'template', 'code', 'cut', 'copy', 'paste',
					 		'plainpaste', 'wordpaste', '|', 'justifyleft', 'justifycenter', 'justifyright',
					 		'justifyfull', 'insertorderedlist', 'insertunorderedlist', 'indent', 'outdent', 'subscript',
					 		'superscript', 'clearhtml', 'quickformat', 'selectall', '|', 'fullscreen',
					 		'formatblock', 'fontname', 'fontsize', '|', 'forecolor', 'hilitecolor', 'bold','italic', 'underline', 'strikethrough', 'lineheight', 'removeformat', '|', 'image', 'table', 'hr', 'pagebreak',
					 		'anchor', 'link', 'unlink'
					 	], 
					 	allowFileManager: true,        //经测试，下面这行代码可有可无，不影响获取textarea的值        
					 	afterCreate: function(){this.sync();} ,       
						//下面这行代码就是关键的所在，当失去焦点时执行 this.sync();        
						afterBlur: function(){this.sync();}

			}
			);
			prettyPrint();
	});
	
	// 注意：不要读取缓存
	jQuery.ajaxSetup({
		cache : false
	});
	
	applianceId ='${applianceId}';
	
	if (applianceId != null && applianceId != "" && applianceId!=0){
		var url='${rootPath}/appliance/getOne?applianceId=' + applianceId;
		$('#dataForm1').form('load', url);
	}
	
	
	$('#tt').tabs({   
	    border:false,   
	    onSelect:function(title){   
	    }   
	});  
	
	//初始化列表
	$('#dataTable2').datagrid({
		singleSelect : true,
		rownumbers:true,
		pagination:true,
		fitColumns:true,
		url : '${rootPath}/appliancesku/list?applianceId='+applianceId,
   		method : 'post',		
		idField : 'SKU_ID',//此处根据实际情况进行填写
	    columns:[[
				//注意：这里是字段名SELLER_CODE，不是变量名sellerCode
				{field : 'ck',checkbox : true},
				{field:'SKU_NAME',title:'名称',width:100},
				{field:'QUALITY_NAMES',title:'属性值名称',width:200},
				{field:'PRICE',title:'价格',width:80},
				{field:'CREATED_TIME',title:'创建时间',width:80},
				{field:'SKU_ID',title:'SkuId',width:80,hidden:true},
				{field:'MODIFIED_TIME',title:'modifiedTime',width:80,hidden:true},
				{field:'STATE',title:'状态',width:80,hidden:true},
				{field:'DELFLAG',title:'delflag',width:80,hidden:true},
				{field:'VERSION',title:'version',width:80,hidden:true}
		]],
//		toolbar : [{
//			id : 'btnadd',
//			text : '添加用品属性',
//			iconCls : 'icon-add',
//			handler : function() {
//				addrow();
//			}
//			}, '-', {
//				id : 'btnedit',
//				text : '修改',
//				iconCls : 'icon-edit',
//				handler : function() {
//					editrow();
//				}
//			}, '-', {
//				id : 'btndel',
//				text : '删除',
//				iconCls : 'icon-remove',
//				handler : function() {
//					delerow();
//				}
//	}],
	onLoadSuccess : function(data) {
		$('#dataTable2').datagrid('clearSelections'); //一定要加上这一句，要不然datagrid会记住之前的选择状态，删除时会出问题
	}
});
	
});


//新增
function addrow(){
	    url = '${rootPath}/appliancesku/add';
		$("#divDialog2").dialog({
			title : "添加用品属性",
			width : 450,
			height : 430,
			href : url,
			cache : false,
			closed : false,
			modal : true
		});
}

//修改
function editrow(qualityValueId){    	
    if (qualityValueId){
 	   	url = '${rootPath}/qualityvalue/edit?qualityValueId='+ qualityValueId;
	   		$("#divDialog2").dialog({
	   			title : "修改商户信息",
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
function delerow(qualityValueId, version){
//     var row = $('#dataTable').datagrid('getSelected');
    if (qualityValueId && version){
        $.messager.confirm('提示','确定要删除行记录吗？',function(r){
            if (r){
                $.post('${rootPath}/qualityvalue/del',{qualityValueId:qualityValueId,version:version},function(data){
                	
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

//保存记录
function saveOrUpdate()
{
	var r = $('#dataForm1').form('validate');
	if(!r) {
		return false;
	}
	else
	{		
		$('#save').linkbutton('disable');
		$.post("${rootPath}/appliance/save",$("#dataForm1").serializeArray(),
		function(data)
		{			
			if(data.result == 'true' || data.result == true)
			{
// 			 	$.messager.show({title:'提示',msg:data.msg,showType:'show'});
			 	$.messager.alert("提示", data.msg);
			 	goBackindex();
			}
			else
			{
// 				$.messager.alert('提示',data.msg,'error');
				$.messager.alert("提示", data.msg);
				$('#save').linkbutton('enable');
			}
		});
	}
}

//表格查询
function searchInfo() {
	//查询参数直接添加在queryParams中
	var queryParams = $('#dataTable2').datagrid('options').queryParams;
	var url = '${rootPath}/appliancesku/list?applianceId='+applianceId;
	$('#dataTable2').datagrid('reload',url); //设置好查询参数 reload 一下就可以了
}

function goBack(flag) {
	if (flag == 1) {
		searchInfo();
	}
	$("#divDialog2").window('close');
}


function goBackindex(flag) {
	window.location='${rootPath}/appliance'; 
}
 
//返回父页面  
// function goBack(flag){
// 	parent.returnParent(flag);
// }
</script>

</body>
</html>
