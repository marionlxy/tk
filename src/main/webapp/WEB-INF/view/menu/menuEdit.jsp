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
<div class="easyui-panel" title="菜单详细信息编辑" style="width:600px">
	<form id="dataForm">			
		    <input name="menuId" type="hidden" value="${menuId}" >
		    <input name="isLeaf" type="hidden" value="${isLeaf}" >
			<div class="fitem">
	        	<label>是否叶子节点:</label>
	        	<input class="easyui-textbox" id="isLeafName" name="isLeafName" value="" readonly="readonly">
	    	</div>
	    	<div class="fitem">
		    	<label>菜单名称:</label>
		        <input name="menuName" class="easyui-textbox" data-options="required:true">
			</div>
	    	<c:if test="${isLeaf =='1'}"><!-- 如果是叶子节点，则需要选择上级菜单 -->
				<div class="fitem">
					<label>上级菜单:</label>
				  	<input class="easyui-combobox" id="combo2" name="parentId" data-options="required:true" value="---请选择---">
				</div>
				<div class="fitem">
			    	<label>访问路径:</label>
			        <input name="menuUrl" class="easyui-textbox" data-options="required:true">
				</div>
			</c:if>
			<div class="fitem">
		    	<label>菜单顺序（输入整数）:</label>
		        <input name="menuOrder" class="easyui-textbox" data-options="required:true">
			</div>
			<div class="fitem">
	        	<label>菜单状态:</label>
	        	<input class="easyui-combobox" id="combo1" name="menuStatus" value="1">
	    	</div>
	    	<div class="fitem">
	        	<label>创建时间:</label>
	        	<input class="easyui-datetimebox"  name="createTime">
	    	</div>	    	
		</form>
    <div id="dlg-buttons" align="center">
       <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-ok" id="save" onclick="saveOrUpdate()" style="width:90px">提交</a>
       <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-cancel" onclick="goBack(0)" style="width:90px">取消</a>
   </div>
</div>
    
<script type="text/javascript">

var menuId;
jQuery(function(){ 

	//初始化下拉框-示例，请根据需要自定义实现
   	
   	  $('#combo1').combobox({
	        url:'${rootPath}/getDictlist?dicttypeid=status',    
	        valueField:'dictId',    
	        textField:'dictName',
	     	panelHeight:'auto'
	    }); 
  	 
	menuId ='${menuId}';
	var isLeaf = '${isLeaf}';
	if("1"==isLeaf)//如果是叶子节点
	{
	    $('#isLeafName').textbox({value:'是'});
		 
		 //初始化上级菜单
		 /*$('#combo2').combobox({
		        url:'${rootPath}/menu/getParentMenu',    
		        valueField:'menuId',    
		        textField:'menuName',
		     	panelHeight:'auto'
		    }); 
		 */
	}
	else
	{
		$('#isLeafName').textbox({value:'否'});
	}
	
	if (menuId != null && menuId != "" && menuId!=0){
		var url='${rootPath}/menu/getOne?menuId=' + menuId;
		$('#dataForm').form('load', url);
	}
});

//保存记录
function saveOrUpdate()
{
	var r = $('#dataForm').form('validate');
	if(!r) {
		return false;
	}
	else
	{		
		$('#save').linkbutton('disable');
		$.post("${rootPath}/menu/save",$("#dataForm").serializeArray(),
		function(data)
		{			
			if(data.result == 'true' || data.result == true)
			{
			 	$.messager.show({title:'提示',msg:data.msg,showType:'show'});
				goBack(1);
			}
			else
			{
				$.messager.alert('提示',data.msg,'error');
				$('#save').linkbutton('enable');
			}
		});
	}
}
 
//返回父页面  
function goBack(flag){
	parent.returnParent(flag);
}
</script>

</body>
</html>
