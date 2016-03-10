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
		<input type="hidden" name="skuId">
		<input type="hidden" name="version">
		<div class="fitem">
	    	<label>名称:</label>
	        <input name="skuName" class="easyui-textbox" validType="length[0,50]" required="required" disabled>
		</div>
		<!-- 
		<div class="fitem">
	    	<label>价格:</label>
	        <input name="price" class="easyui-numberbox"  precision="2" groupSeparator="," decimalSeparator="." 
	        												prefix="￥" validType="length[0,10]" required="required" disabled></input>
		</div>
		 -->
		<c:forEach  items="${qualitymeasureList}" var="measure" varStatus="s">
			<div class="fitem">
		    <label>${measure.QUALITY_NAME}:</label>
			    <select name="qualityName${measure.QUALITY_ID}" class="easyui-combobox" panelHeight="auto" style="width:100px" required="required" disabled> 
			    <option value="">无</option>
					<c:forEach  items="${qualityvalueList}" var="entity" varStatus="s">
					 	<c:if  test="${entity.QUALITY_ID==measure.QUALITY_ID}">
							 <c:if  test="${fn:contains(qualityValuesId,entity.quality_value_id)}">
						 		<option value="${entity.QUALITY_VALUE_ID}" selected="selected" >${entity.QUALITY_VALUE_NAME}</option>
							 </c:if>
							  <c:if  test="${fn:contains(qualityValuesId,entity.quality_value_id)}">
						 		<option value="${entity.QUALITY_VALUE_ID}" >${entity.QUALITY_VALUE_NAME}</option>
							 </c:if>
					 	</c:if>
					</c:forEach>
				</select> 
			</div>	
		</c:forEach>
	</form>
    <div id="dlg-buttons" align="center">
       <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-cancel" onclick="goBack()" style="width:90px">取消</a>
   </div>
</div>
    
<script type="text/javascript">

var skuId;
jQuery(function(){ 
	// 注意：不要读取缓存
	jQuery.ajaxSetup({
		cache : false
	});
	
	skuId ='${skuId}';
	
	if (skuId != null && skuId != "" && skuId!=0){
		var url='${rootPath}/appliancesku/getOne?skuId=' + skuId;
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
		$.post("${rootPath}/appliancesku/save",$("#dataForm").serializeArray(),
		function(data)
		{			
			if(data.result == 'true' || data.result == true)
			{
// 			 	$.messager.show({title:'提示',msg:data.msg,showType:'show'});
			 	$.messager.alert("提示", data.msg);
				goBack(1);
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
 
//返回父页面  
// function goBack(flag){
// 	parent.returnParent(flag);
// }
</script>

</body>
</html>
