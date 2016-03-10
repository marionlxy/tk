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
	<div title="修改单项服务">
	<form id="dataForm">
		<input type="hidden" name="serviceId" id="serviceId">
		<input type="hidden" name="version">
		<div class="fitem">
	    	<label>逝者名称:</label>
	        <input name="picName" class="easyui-textbox" validType="length[0,50]" required="required"  />
		</div>
		<div class="fitem">
	    	<label style="vertical-align:top;">逝者信息:</label>
			<textarea name="picDesc" id ="picDesc" style=" border:1px solid #99bbe8;"  rows="4" cols="31" required="required" data-options="validType: ['unsafe']" ></textarea>
		</div>
		<div class="fitem">
	    	<label>宣传图序号:</label>
	        <input name="picNum" class="easyui-numberbox" validType="length[0,14]" required="required" >
		</div>
		<div class="fitem" id="imgArr">
	    	<label style="vertical-align:top;">上传图片:</label>
   		 		<img src="${picUrl}" style="width: 100px;height: 100px;">
	          <input type="file" name="file" id="file" >
		</div>
		<div class="fitem">
	    	<label>宣传图链接:</label>
	        <input name="picLink"  validType="length[0,50]" required="required">
		</div>
	</form>
    <div id="dlg-buttons" align="center">
       <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-ok" id="save" onclick="saveOrUpdate()" style="width:90px">提交</a>
       <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-cancel" onclick="goBack()" style="width:90px">取消</a>
   </div>
   </div>
     <div title="图片修改"  >  
   		 <h1>单项服务上传修改图片</h1>
	<form name="userForm3" id = "userForm3"  action="${rootPath}/single/uploadBySpringGrpSingle" enctype="multipart/form-data" method="post">
		<input name="serviceId" type="hidden" id="hidSId"/>
		<div id="newUpload2">
			<input type="file" name="file"><br>
		</div>
		<input type="button" id="btn_add2" value="增加一行">
		<div id="newUpload1"></div>
		
	</form>
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
		$.post("${rootPath}/single/save",$("#dataForm").serializeArray(),
		function(data)
		{			
			if(data.result == 'true' || data.result == true)
			{	
				$("#hidSId").val(data.sId);
				  document.userForm3.submit();
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
<script type="text/javascript">  
    i = 1;  
    j = 1;  
    var $newUpload1=$("#newUpload1");
    $(document).ready(function(){  
        $("#btn_add2").click(function(){  
          var fileImages =  document.getElementById("newUpload2").innerHTML+='<div id="div_'+j+'"><input  name="file_'+j+'" type="file"  /><input type="button" value="删除"  onclick="del_2('+j+')"/></div>';  
          j = j + 1;  
        });  
    });  
  
    function del_1(o){  
     document.getElementById("newUpload1").removeChild(document.getElementById("div_"+o));  
    }  
      
    function del_2(o){  
         document.getElementById("newUpload2").removeChild(document.getElementById("div_"+o));  
    }  
    
	//$('#uploadBySpringGrp').click( function () {
	//	method = "post";  
    //    action = "${rootPath}/file/uploadBySpringGrp";  
    //    submit();  
	//});
</script>

</body>
</html>
