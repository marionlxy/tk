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
		<input type="hidden" name="complainId">
		<input type="hidden" name="version">
		<div class="fitem">
	    	<label>投诉编号:</label>
	        <input name="complainNum" class="easyui-textbox" disabled>
		</div>
		<div class="fitem">
	    	<label>投诉人姓名:</label>
	        <input name="complainName" class="easyui-textbox" disabled>
		</div>
		<div class="fitem">
	    	<label>投诉人电话:</label>
	        <input name="complainTel" class="easyui-textbox" disabled>
		</div>
		<div class="fitem">
	    	<label>投诉内容:</label>
	    	<textarea name="complainMsg" style=" border:1px solid #99bbe8;width: 201px"  rows="4" cols="33" disabled></textarea>
		</div>
		<div class="fitem">
	    	<label>投诉类型:</label>
	    	<input class="easyui-combobox" name="complainType" style="width:100px" panelHeight="auto"
		 	url="${rootPath}/getDictCombox?dictType=type" valueField="dictId" textField="dictName" disabled>
		</div>
		<div class="fitem" >
	    	<label>站点:</label>
			<input class="easyui-combobox" name="site" id ="site" value="010" style="width:100px" required="required" panelHeight="auto"
		 	url="${rootPath}/getDictCombox?dictType=SITE" valueField="dictId" textField="dictName" disabled/>
		</div>
		<div class="fitem">
	    	<label style="vertical-align:top;">订单编号:</label>
                <input name="subOrder" class="easyui-textbox" disabled>
		</div>
		<div class="fitem">
	    	<label>处理意见:</label>
	        <textarea name="disposeMsg" style=" border:1px solid #99bbe8;width: 201px"  rows="4" cols="33" disabled></textarea>
		</div>
	</form>
    <div id="dlg-buttons" align="center">
      <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-cancel" onclick="returnParent(1)" style="width:90px">取消</a>
   </div>
</div>
    
<script type="text/javascript">

var sellerId;
jQuery(function(){ 
	// 注意：不要读取缓存
	jQuery.ajaxSetup({
		cache : false
	});
	
	complainId ='${complainId}';
	
	if (complainId != null && complainId != "" && complainId!=0){
		var url='${rootPath}/complain/getOne?complainId=' + complainId;
		$('#dataForm').form('load', url);
	}
});

</script>

</body>
</html>
