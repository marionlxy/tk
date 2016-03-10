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
		<input type="hidden" name="serviceId">
		<input type="hidden" name="version">
		<div class="fitem">
	    	<label>服务编号:</label>
	        <input name="serviceNum" class="easyui-textbox" disabled>
		</div>
		<div class="fitem">
	    	<label>服务名称:</label>
	        <input name="serviceName" class="easyui-textbox" disabled>
		</div>
		<div class="fitem">
	    	<label>服务分类:</label>
	    	<input class="easyui-combobox" name="serviceType" style="width:100px" panelHeight="auto"
		 	url="${rootPath}/getDictCombox?dictType=servType" valueField="dictId" textField="dictName" disabled>
		</div>
		<div class="fitem">
	    	<label>销售价格:</label>
	       	<input name="sellPrice" class="easyui-numberbox" validType="length[0,14]" invalidMessage="价格不能大于10位" data-options="required:true,groupSeparator:',',decimalSeparator:'.',min:0,precision:2,prefix:'￥'" disabled="disabled">
		</div>
		<div class="fitem">
	    	<label>站点:</label>
	    	<input class="easyui-combobox" name="site" style="width:100px" panelHeight="auto"
		 	url="${rootPath}/getDictCombox?dictType=SITE" valueField="dictId" textField="dictName" disabled>
		</div>
		<div class="fitem">
	    	<label style="vertical-align:top;">服务描述:</label>
			<textarea name="serviceMsg" style=" border:1px solid #99bbe8;"  rows="4" cols="31" class="easyui-validatebox"  disabled></textarea>
		</div>		
		<div class="fitem">
	    	<label style="vertical-align:top;">寓意:</label>
			<textarea name="moral" style=" border:1px solid #99bbe8;"  rows="4" cols="31" class="easyui-validatebox"  disabled></textarea>
		</div>
		<div class="fitem" style="padding-left: 60px">
			<c:forEach  items="${urlList}" var="measure" varStatus="s">
						<img src="${measure.url}" width="80" height="50" />
			</c:forEach>	
	       </div>
	</form>
    <div id="dlg-buttons" align="center">
       <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-cancel" onclick="goBack()" style="width:90px">取消</a>
   </div>
</div>
    
<script type="text/javascript">

var serviceId;
jQuery(function(){ 
	// 注意：不要读取缓存
	jQuery.ajaxSetup({
		cache : false
	});
	
	serviceId ='${serviceId}';
	
	if (serviceId != null && serviceId != "" && serviceId!=0){
		var url='${rootPath}/single/getOne?serviceId=' + serviceId;
		$('#dataForm').form('load', url);
	}
});

</script>

</body>
</html>
