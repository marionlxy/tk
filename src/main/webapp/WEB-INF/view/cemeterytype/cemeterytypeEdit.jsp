<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="UTF-8"%>
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
	<form id="dataForm" name="dataForm" >
		<input type="hidden" name="typeId" /> <input type="hidden"
			name="version" />
		<div class="fitem">
			<label>墓型编号:</label> <input name="typeCode" class="easyui-textbox"
				data-options="required:true" disabled>
		</div>
		<div class="fitem">
			<label>墓型名称:</label> <input name="typeName" validType="length[0,50]"  class="easyui-textbox"
				data-options="required:true">
		</div>
		<div class="fitem">
			<label>墓型介绍:</label>
			<textarea name="typeContent" data-options="required:true" validType="length[0,1000]" style="border: 1px solid #99bbe8;"
				rows="4" cols="31" class="easyui-validatebox"></textarea>
		</div>
		<div class="fitem">
			<label>最小价格:</label> <input name="minprice" id="minprice" validType="length[0,14]" class="easyui-numberbox"
				invalidMessage="价格不能大于10位" data-options="required:true,groupSeparator:',',decimalSeparator:'.',min:0,precision:2,prefix:'￥'">
		</div>
		<div class="fitem">
			<label>最大价格:</label> <input name="maxprice" id="maxprice" validType="length[0,14]" class="easyui-numberbox"
				invalidMessage="价格不能大于10位" data-options="required:true,groupSeparator:',',decimalSeparator:'.',min:0,precision:2,prefix:'￥'">
		</div>
	</form>
	<form name="userFormCT" id="userFormCT" action="${rootPath}/cemeteryType/uploadByCemeteryType" method="post" enctype="multipart/form-data">
		<input name="typeId" type="hidden" id="hidTId" />
		<div class="fitem" style="width:700px">
		    <label style="vertical-align:top;margin-left: 61px;">图片上传:</label>
		    <input type="file" name="file" id="file"  />
		    <input type="button" id="addfiles2" name="addfiles2" value="添加" style="width: 60px; height: 20px;" />
		</div>
		<div id="addfiles3"></div>
	</form>
	<div>
	<div id="dlg-buttons" align="center" style="margin-top:20px;">
		<a href="javascript:void(0)" class="easyui-linkbutton"
			iconCls="icon-ok" id="saveCT" onclick="saveOrUpdateCT()"
			style="width: 90px">提交</a> <a href="javascript:void(0)"
			class="easyui-linkbutton" iconCls="icon-cancel" onclick="goBack(4)"
			style="width: 90px">取消</a>
	</div>

	<script type="text/javascript">
		var typeId = '${typeId}';
		var flog = true;
		$('#minprice').numberbox({onChange:confirmPrice});
		$('#maxprice').numberbox({onChange:confirmPrice});
		
		jQuery(function() {
			// 注意：不要读取缓存
			jQuery.ajaxSetup({
				cache : false
			});

			if (typeId != null && typeId != "" && typeId != 0) {
				var url = '${rootPath}/cemeteryType/getOne?typeId=' + typeId;
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
		//保存和修改
		function saveOrUpdateCT() {
			
			if(flog == false){
				alert("最大价格要大于最小价格");
				return;
			}
			
			var r = $('#dataForm').form('validate');
			if (!r) {
				return false;
			} else {
// 				$('#save').linkbutton('disable');
				$.post("${rootPath}/cemeteryType/save", $("#dataForm")
						.serializeArray(), function(data) {
					if (data.result == 'true' || data.result == true) {
						$("#hidTId").val(typeId);
						$('#userFormCT').form('submit', {   
						    success: function(data){  
						    	$.messager.alert("提示", "更新成功！");
								goBack(3);
						    }   
						});
						
					} else {
						$.messager.alert("提示", "更新失败！");
						$('#saveCT').linkbutton('enable');
					}
				});
			}
		}
	
	</script>
	<script type="text/javascript">
//根据添加图片按钮增加多个图片上传
 	$().ready(function(){
    		var $addfile =$("#addfiles2");
    		var $addfile1=$("#addfiles3");
    		var fileImage = 1;
    		$addfile.click(function(){
    			var fileImages='<div class="fitem"><label style="vertical-align:top;margin-left: 61px;"></label>&nbsp;<input type="file" id="file'+(fileImage+1)+'" name="file'+(fileImage+1)+'"/><a href="javascript:void(0)" class="easyui-linkbutton" id="del1" onclick="deletcheck('+(fileImage+1)+')" style="width:90px">&nbsp;&nbsp;&nbsp;删除</a></div>';
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
