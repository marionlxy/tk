<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="UTF-8"%>
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
		    	<label>角色编码:</label>
		        <input name="roleCode" class="easyui-textbox" data-options="required:true">
			</div>
					<div class="fitem">
		    	<label>角色名称:</label>
		        <input name="roleName" class="easyui-textbox" data-options="required:true">
			</div>
			        <div class="fitem">
		    	<label>角色性质</label>
		        <select class="easyui-combobox" name="roleNature" style="width:80px" panelHeight="60px" required="required">				        
							<option value=""></option>
							<option value="H">总公司</option>
							<option value="B">分公司</option>
				</select>
			</div>
				    <div class="fitem">
		    	<label>状态:</label>
		    	<select class="easyui-combobox" name="roleStatus" style="width:80px" panelHeight="60px" required="required">				        
							<option value=""></option>
							<option value="1">有效</option>
							<option value="0">无效</option>
				</select>
			</div>
			<!-- <div class="fitem">
		    	<label>分属部门:</label>
		        <input name="roleDep" class="easyui-textbox">
			</div> -->
			</form>
    <div id="dlg-buttons" align="center">
       <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-ok" id="save" onclick="saveOrUpdate()" style="width:90px">提交</a>
       <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-cancel" onclick="goBack()" style="width:90px">取消</a>
   </div>
</div>
    
<script type="text/javascript">
	//保存记录
	function saveOrUpdate() {
		var r = $('#dataForm').form('validate');
		if (!r) {
			return false;
		} else {
			$.post("${rootPath}/role/save", $("#dataForm").serializeArray(),
					function(data) {
						if (data.result == 'true' || data.result == true) {
							$.messager.alert("success", data.msg);
							goBack(1);
							//com.message("success", "角色添加成功！");
						} else {
							$.messager.alert("error", data.msg);
							//com.message("error", "角色添加失败 ！");
						}
					});
		}
	}
</script>

</body>
</html>
