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
		<div class="fitem">
	    	<label>名称:</label>
	        <input name="skuName" class="easyui-textbox" validType="length[0,50]" required="required">
		</div>
		<!-- 
		<div class="fitem">
	    	<label>价格:</label>
	        <input name="price" class="easyui-numberbox"  precision="2" groupSeparator="," decimalSeparator="." 
	        												prefix="￥" validType="length[0,10]" required="required"></input>
		</div>
		 -->
		<c:forEach  items="${qualitymeasureList}" var="measure" varStatus="s">
			<div class="fitem">
		    <label>${measure.QUALITY_NAME}:</label>
			    <select name="qualityName${measure.QUALITY_ID}" class="easyui-combobox" panelHeight="auto" style="width:100px" required="required"> 
			    <option value="">无</option>
					<c:forEach  items="${qualityvalueList}" var="entity" varStatus="s">
					 <c:if  test="${entity.QUALITY_ID==measure.QUALITY_ID}">
					<option value="${entity.QUALITY_VALUE_ID}">${entity.QUALITY_VALUE_NAME}</option>
					 </c:if>
					</c:forEach>
				</select> 
			</div>	
		</c:forEach>
	</form>
    <div id="dlg-buttons" align="center">
    	<c:if  test="${add==true}">
        <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-ok" id="save" onclick="saveOrUpdate2()" style="width:90px">提交</a>
       	</c:if>
       	<c:if  test="${add==false}">
        <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-ok" id="save" onclick="saveOrUpdate()" style="width:90px">提交</a>
        </c:if>
       <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-cancel" onclick="goBack()" style="width:90px">取消</a>
   </div>
</div>
    
<script type="text/javascript">

jQuery(function(){ 
	
	jQuery.ajaxSetup({
		cache : false
	});
	
	var applianceId='${applianceId}';
	
// 	$('#site').combobox({
//         url:'${rootPath}/getDictCombox?dictType=kemu1',    
//         valueField:'dictId',    
//         textField:'dictName',
//         panelWidth: 100,
//         panelHeight:'auto'
//  }); 
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
		$.post("${rootPath}/appliancesku/save?applianceId="+applianceId,$("#dataForm").serializeArray(),
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

//保存记录
function saveOrUpdate2()
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
