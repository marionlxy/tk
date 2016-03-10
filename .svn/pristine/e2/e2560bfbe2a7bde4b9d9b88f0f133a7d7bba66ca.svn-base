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
	<form id="dataForm">
		<input type="hidden" name="sellerId">
		<input type="hidden" name="version">
		<div class="fitem">
	    	<label>属性名称:</label>
	        <input name="qualityName" class="easyui-textbox" disabled>
		</div>
		<div class="fitem" >
	    	<label>用品类别:</label>
	        <input name="categoryId" class="easyui-combotree" data-options="url:'${rootPath}/goodscategory/getComTree?id=0',method:'get',required:true" style="width:205px;" disabled>
	    </div>
		<div class="fitem">
	    	<label>排序:</label>
	        <input name="sort" class="easyui-textbox" disabled>
		</div>
	</form>
    <div id="dlg-buttons" align="center">
       <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-cancel" onclick="goBack()" style="width:90px">取消</a>
   </div>
</div>
    
<script type="text/javascript">

var qualityId;
jQuery(function(){ 
	// 注意：不要读取缓存
	jQuery.ajaxSetup({
		cache : false
	});
	
	qualityId ='${qualityId}';
	
	if (qualityId != null && qualityId != "" && qualityId!=0){
		var url='${rootPath}/qualitymeasure/getOne?qualityId=' + qualityId;
		$('#dataForm').form('load', url);
	}
});

</script>

</body>
</html>
