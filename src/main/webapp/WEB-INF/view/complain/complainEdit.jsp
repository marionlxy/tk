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

		<form id="dataForm">
			<input type="hidden" name="complainId">

			<div class="fitem">
				<label>投诉编号:</label> <input name="complainNum" value="默认值"
					class="easyui-textbox" readonly="true" data-options="required:true">
			</div>

			<div class="fitem">
				<label>投诉人姓名:</label> <input name="complainName"
					class="easyui-textbox" data-options="required:true">
			</div>

			<div class="fitem">
				<label>投诉人电话:</label> <input name="complainTel"
					class="easyui-textbox" data-options="required:true">
			</div>
			<div class="fitem" >
	    	<label style="vertical-align:top;">投诉内容:</label>
			<textarea name="complainMsg" style=" border:1px solid #99bbe8;"  rows="4" cols="31" class="easyui-validatebox" validType="length[0,200]" required="required" ></textarea>
			</div>
			<div class="fitem" >
	    	<label>站点:</label>
			<input class="easyui-combobox" name="site" id ="site"  style="width:100px" required="required" panelHeight="auto"
		 	url="${rootPath}/getDictCombox?dictType=SITE" valueField="dictId" textField="dictName" editable="editable"/>
			</div>
		</form>

		<div id="dlg-buttons" align="center">
			<a href="javascript:void(0)" class="easyui-linkbutton"
				iconCls="icon-ok" id="save" onclick="saveOrUpdate()"
				style="width: 90px">确定</a> 
				<a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-cancel" onclick="returnParent(1)" style="width:90px">取消</a>
		</div>
	</div>

	<script type="text/javascript">
		var complainId;
		jQuery(function() {
			complainId = '${complainId}';
			if (complainId != null && complainId != "" && complainId != 0) {
				var url = '${rootPath}/complain/getOne?complainId='
						+ complainId;
				$('#dataForm').form('load', url);
			}
		});

		//保存记录
		function saveOrUpdate() {
			var r = $('#dataForm').form('validate');
			if (!r) {
				return false;
			} else {
				
				$('#save').linkbutton('disable');
				$.post("${rootPath}/complain/save", $("#dataForm")
						.serializeArray(), function(data) {
					
					if (data.result == 'true' || data.result == true) {
						goBack(1);
					} else {
						$('#save').linkbutton('enable');
					}
				});
			}
		}
	</script>

</body>
</html>
