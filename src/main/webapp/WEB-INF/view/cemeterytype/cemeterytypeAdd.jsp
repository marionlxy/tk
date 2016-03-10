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
<div id="tt" class="easyui-tabs" style="width:120%; height: 500px">  
<div title="添加墓型" >
	<form id="dataForm">
			<div class="fitem" >
		    	<label>墓型名称:</label>
		        <input name="typeName" validType="length[0,50]" class="easyui-textbox" data-options="required:true" >
			</div>
			<div class="fitem" >
		    	<label>墓型介绍:</label>
		        <textarea name="typeContent"  data-options="required:true"  validType="length[0,1000]" style=" border:1px solid #99bbe8;"  rows="4" cols="31" class="easyui-validatebox"  ></textarea>
			</div>
			<div class="fitem" >
		    	<label>最小价格:</label>
		        <input name="minprice" id="minprice" class="easyui-numberbox" validType="length[0,14]" invalidMessage="价格不能大于10位" data-options="required:true,groupSeparator:',',decimalSeparator:'.',min:0,precision:2,prefix:'￥'" >
			</div>
			<div class="fitem" >
		    	<label>最大价格:</label>
		        <input name="maxprice" id="maxprice" class="easyui-numberbox" validType="length[0,14]" invalidMessage="价格不能大于10位" data-options="required:true,groupSeparator:',',decimalSeparator:'.',min:0,precision:2,prefix:'￥'">
			</div>
			</form>
    <div id="dlg-buttons" align="center">
    	<a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-ok" id="saveCT" onclick="saveOrUpdateCT()" style="width:90px">提交</a>
       <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-cancel" onclick="goBack(3)" style="width:90px">关闭</a>
   </div>
   </div>
    <div title="图片上传"  >  
   		 <h1 style="margin-left: 80px;color: red">墓型上传图片</h1>
	<form name="userFormType" id ="userFormType"  action="${rootPath}/cemeteryType/uploadByCemeteryType" enctype="multipart/form-data" method="post">
		<input name="typeId" type="hidden" id="hidTId"/>
	    <div class="fitem">
   		 	<input type="file" name="file" id="file" style="margin-left: 93px"/>&nbsp;
   		 	<input type="button" id="addfiless" name="addfiless" value="添加" style="width:60px; height: 20px;">
	    </div>
	    <div id="addfiless1"></div>
	</form>
    </div> 
 </div> 
<script type="text/javascript">

var flog = true;
var typeId ='${typeId}';
var parkId ='${parkId}';
$('#minprice').numberbox({onChange:confirmPrice});
$('#maxprice').numberbox({onChange:confirmPrice});

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

//ajax判断当前价格比较
function confirmPrice(){
	var lowerLimit = $("#minprice").val();
	var upperLimit = $("#maxprice").val();
	if(parseFloat(upperLimit) <= parseFloat(lowerLimit)){
		alert("最大价格要大于最小价格");
		flog = false;
	}else{
		flog = true;
	}
}

function saveOrUpdateCT()
{	
	if(flog == false){
		alert("最大价格要大于最小价格");
		return;
	}
	var imgFileArr=$(":file");
	if(imgFileArr){
		//alert(imgFileArr.length);
		var isNum=false;
		for(i=0;i<imgFileArr.length;i++){
			var fileName=imgFileArr[i];
			if($.trim($(fileName).val())!=""&&$(fileName).val()!=null){
				isNum=true;
			}
		}		
		if(!isNum){
			$.messager.alert("提示", "请上传至少一张墓型图片！");				
			return;
		}
	}else{
		$.messager.alert("提示", "请上传至少一张墓型图片！");				
		return;
	}
	var r = $('#dataForm').form('validate');
	if(!r) {
		return false;
	}
	else
	{		
// 		$('#save').linkbutton('disable');
		$.post("${rootPath}/cemeteryType/save?parkId="+parkId,$("#dataForm").serializeArray(),
		function(data)
		{			
			if(data.result == 'true' || data.result == true)
			{	
				$("#hidTId").val(data.tId);
				$('#userFormType').form('submit', {   
				    success: function(data){  
					 	$.messager.alert("提示", "新增成功！");
					 	goBack(3);
				    }   
				});  
			}
			else
			{
				$.messager.alert("提示", "新增失败！");
				$('#saveCT').linkbutton('enable');
			}
		});
	}
}


</script>
<script type="text/javascript">
//根据添加图片按钮增加多个图片上传
 	$().ready(function(){
    		var $addfile =$("#addfiless");
    		var $addfile1=$("#addfiless1");
    		var fileImage = 1;
    		$addfile.click(function(){
    			var fileImages='<div class="fitem"><label style="vertical-align:top;"></label>&nbsp;<input type="file" id="file'+(fileImage+1)+'" name="file'+(fileImage+1)+'"/><a href="javascript:void(0)" class="easyui-linkbutton" id="del1" onclick="deletcheck('+(fileImage+1)+')" style="width:90px">&nbsp;&nbsp;&nbsp;删除</a></div>';
    			$addfile1.append(fileImages);
    			fileImage++;
    		});
    	});
    	
    	function deletcheck(id){
    		if(confirm("确定要删除吗?")){   			
    			$("#file"+id).parent().remove();
    		}
    	}
</script>
</body>
</html>
