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
	    	<label>订单总额下限:</label>
	    	<input name="lowerLimit" id="lowerLimit" class="easyui-numberbox" validType="length[0,14]" invalidMessage="价格不能大于10位" data-options="required:true,groupSeparator:',',decimalSeparator:'.',min:0,precision:2,prefix:'￥'">
		</div>
		<div class="fitem">
	    	<label>订单总额上限:</label>
	    	<input name="upperLimit" id="upperLimit" type = "text" class="easyui-numberbox" validType="length[0,14]" invalidMessage="价格不能大于10位" data-options="required:true,groupSeparator:',',decimalSeparator:'.',min:0,precision:2,prefix:'￥'">
		</div>
		<div class="fitem">
	    	<label>最小优惠幅度:</label>
	    	<input name="preferMini" class="easyui-numberbox" validType="length[0,14]" invalidMessage="价格不能大于10位" data-options="required:true,groupSeparator:',',decimalSeparator:'.',min:0,precision:2,prefix:'￥'">
		</div>
		<div class="fitem">
	    	<label>最大优惠幅度:</label>
	    	<input name="preferMax" class="easyui-numberbox" validType="length[0,14]" invalidMessage="价格不能大于10位" data-options="required:true,groupSeparator:',',decimalSeparator:'.',min:0,precision:2,prefix:'￥'" >
		</div>
	</form>
    <div id="dlg-buttons" align="center">
       <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-ok" id="save" onclick="saveOrUpdate()" style="width:90px">提交</a>
       <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-cancel" onclick="goBack()" style="width:90px">取消</a>
   </div>
</div>
    
<script type="text/javascript">
var flog = true;
jQuery(function(){ 
	
	jQuery.ajaxSetup({
		cache : false
	});
	var row = $('#dataTable').datagrid('getSelected');
	$('#upperLimit').numberbox({onChange:confirmPrefer});
	$('#lowerLimit').numberbox({onChange:confirmPrefer});
});

//保存记录
function saveOrUpdate(){

	var r = $('#dataForm').form('validate');
	if(flog == false){
		alert("上限要大于下限或已有此优惠区间");
		return;
	}
	if(!r) {
		return false;
	}
	else
	{		
		
		$('#save').linkbutton('disable');
		$.post("${rootPath}/prefer/save",$("#dataForm").serializeArray(),
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
//ajax判断当前优惠价格区间是否存在
function confirmPrefer(){
	var lowerLimit = $("#lowerLimit").val();
	var upperLimit = $("#upperLimit").val();
	if(parseFloat(upperLimit) <= parseFloat(lowerLimit)){
		alert("上限金额要大于下限金额");
		flog = false;
	}
	if(upperLimit == null || upperLimit == ""){
		return;
	}
	if(lowerLimit == null || lowerLimit == ""){
		return;
	}
	URL="${rootPath}/prefer/confrimRefer";
    $.ajax({  
        async : false,  
        cache:false,  
        type: 'POST',  
        data:$('#dataForm').serialize(),// 你的formid
        dataType : "json",  
        url:URL, 
       success : function(date) { //请求成功后处理函数。 
           var eva = eval(date);
           if(eva[0].id <= 0){
        	   flog = false;
           }else{
        	   flog = true;
           }
       }, 
       error : function() {//请求失败处理函数
           alert('加载失败');
       }
   });
 
}

</script>

</body>
</html>
