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
	<form id="dataForm" name="dataForm" method="post" action="${rootPath}/appliancesku/addimg" enctype="multipart/form-data">
		<input type="hidden" name="categoryId" value="${categoryId}">
		<input type="hidden" name="skuId" value="${skuId}">
		<input type="hidden" name="applianceId" value="${applianceId}">
		<input type="hidden" name="version">
		 <div class="fitem">
	    	<label style="vertical-align:top;">图片展示:</label>
	    	<c:forEach  items="${pictureDtoList}" var="measure" varStatus="s">
   		 		<img src="${measure.PICTURE_ADDRESS}" style="width: 100px;height: 100px;">
   		 	</c:forEach>
	    </div>
	</form>
	<form id="postForm" name="postForm"  action="${rootPath}/appliancesku/skuPictureAdd" method="post"  >
		<input type="hidden" name="skuId" value="${skuId}">
		<input type="hidden" name="applianceId" value="${applianceId}">
	</form>
    <div id="dlg-buttons" align="center">
       <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-cancel" onclick="goBack()" style="width:90px">取消</a>
   </div>
</div>
    
<script type="text/javascript">
var applianceId;
var skuId;
jQuery(function(){ 
	// 注意：不要读取缓存
	jQuery.ajaxSetup({
		cache : false
	});
	
});
</script>

</body>
</html>
