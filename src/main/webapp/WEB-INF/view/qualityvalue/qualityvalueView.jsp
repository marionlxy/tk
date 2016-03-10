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
	    	<label>属性值名称:</label>
	        <input name="qualityValueName" class="easyui-textbox" disabled>
		</div>
		<div class="fitem">
	    	<label>排序:</label>
	        <input name="sort" class="easyui-textbox" disabled>
		</div>
		<div class="fitem">
	    	<label>属性名选择:</label>
	    	 <select name="qualityId" class="easyui-combobox" panelHeight="auto" style="width:100px" required="required" disabled> 
				<c:forEach  items="${qualitymeasureList}" var="entity" varStatus="s">
				    <option value="${entity.QUALITY_ID}">${entity.QUALITY_NAME}</option>
				</c:forEach>
			  </select> 
		</div>
	</form>
    <div id="dlg-buttons" align="center">
       <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-cancel" onclick="goBack()" style="width:90px">取消</a>
   </div>
</div>
    
<script type="text/javascript">

var qualityValueId;
jQuery(function(){ 
	// 注意：不要读取缓存
	jQuery.ajaxSetup({
		cache : false
	});
	
	qualityValueId ='${qualityValueId}';
	
	if (qualityValueId != null && qualityValueId != "" && qualityValueId!=0){
		var url='${rootPath}/qualityvalue/getOne?qualityValueId=' + qualityValueId;
		$('#dataForm').form('load', url);
	}
});

</script>

</body>
</html>
