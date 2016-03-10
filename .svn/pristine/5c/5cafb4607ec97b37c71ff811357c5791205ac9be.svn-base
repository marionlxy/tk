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
	<form id="dataForm">
			<div class="fitem" >
		    	<label>墓型编号:</label>
		        <input name="typeCode" class="easyui-textbox" data-options="required:true" disabled>
			</div>
			<div class="fitem" >
		    	<label>墓型名称:</label>
		        <input name="typeName" class="easyui-textbox" data-options="required:true" disabled>
			</div>
			<div class="fitem" >
		    	<label>墓型介绍:</label>
		        <textarea name="typeContent" style=" border:1px solid #99bbe8;"  rows="4" cols="31" class="easyui-validatebox"  disabled></textarea>
			</div>
			<div class="fitem" >
		    	<label>墓型图片:</label>
		        <c:forEach  items="${urlList}" var="measure" varStatus="s">
						<img src="${measure.url}" width="80" height="50" />
				</c:forEach>
			</div> 
			<div class="fitem" >
		    	<label>最小价格:</label>
		        <input name="minprice" class="easyui-numberbox" data-options="required:true,groupSeparator:',',decimalSeparator:'.',min:0,precision:2,prefix:'￥'"  disabled>
			</div>
			<div class="fitem" >
		    	<label>最大价格:</label>
		        <input name="maxprice" class="easyui-numberbox" data-options="required:true,groupSeparator:',',decimalSeparator:'.',min:0,precision:2,prefix:'￥'" disabled>
			</div>
			</form>
    <div id="dlg-buttons" align="center">
       <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-cancel" onclick="goBack()" style="width:90px">返回</a>
   </div>
    
<script type="text/javascript">

var typeId ='${typeId}';

jQuery(function(){ 
	// 注意：不要读取缓存
	jQuery.ajaxSetup({
		cache : false
	});

	if (typeId != null && typeId != "" && typeId !=0){
		var url='${rootPath}/cemeteryType/getOne?typeId=' + typeId;
		$('#dataForm').form('load', url);
	}
});

//返回父页面  
function goBack(){
	$('#divDialog').window('close');
}
</script>

</body>
</html>
