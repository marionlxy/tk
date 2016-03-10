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
	<form id="dataForm3">
		<div class="fitem">
					<label>测试序号:</label> <input name="serialId"
						validType="length[0,50]" class="easyui-textbox"
						data-options="required:true">
				</div>
				<div class="fitem">
					<label>排序:</label> <input name="num" validType="length[0,50]"
						class="easyui-textbox" data-options="required:true">
				</div>

				<div class="fitem">
					<label>标题:</label>
					<textarea name="title" style="border: 1px solid #99bbe8;"
						validType="length[0,100]" rows="4" cols="31"
						class="easyui-validatebox" data-options="required:true"></textarea>
				</div>

				<div class="fitem">
					<label>文本:</label>
					<textarea name="text" style="border: 1px solid #99bbe8;"
						validType="length[0,100]" rows="4" cols="31"
						class="easyui-validatebox" data-options="required:true"></textarea>
				</div>
	</form>
    <div id="dlg-buttons" align="center">
       <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-cancel" onclick="goBack()" style="width:90px">取消</a>
   </div>
</div>
    
<script type="text/javascript">

var serialId;
jQuery(function(){ 
	// 注意：不要读取缓存
	jQuery.ajaxSetup({
		cache : false
	});
	
	serialId ='${serialId}';
	alert(serialId);
	if (serialId != null && serialId != "" && serialId!=0){
		var url='${rootPath}/test/getOne?rowId=' + serialId;
		$('#dataForm3').form('load', url);
	}
});

</script>

</body>
</html>
