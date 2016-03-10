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
	<div id="tt" class="easyui-tabs" style="width: 120%; height: 500px">
		<div title="添加测试">
			<form id="dataForm1">
				<div class="fitem">
					<label>测试序号:</label> <input name="serialId"
						validType="length[0,50]" class="easyui-textbox"
						data-options="required:true">
				</div>
				<div class="fitem">
					<label>排序:</label> <input name="num" validType="length[0,50]"
						class="easyui-textbox" data-options="required:true">
				</div>

				<div class="fitem">
					<label>标题:</label>
					<textarea name="title" style="border: 1px solid #99bbe8;"
						validType="length[0,100]" rows="4" cols="31"
						class="easyui-validatebox" data-options="required:false"></textarea>
				</div>

				<div class="fitem">
					<label>文本:</label>
					<textarea name="text" style="border: 1px solid #99bbe8;"
						validType="length[0,100]" rows="4" cols="31"
						class="easyui-validatebox" data-options="required:false"></textarea>
				</div>
				<div class="fitem">
					<!-- <div>File1:</div> -->
					<label>上传图片:</label> <input class="easyui-filebox" name="image"
							validType=""
						data-options="prompt:'Choose a image...'" style="width: 45%">
				</div>
				<div class="fitem">
					<!-- <div>File1:</div> -->
					<label>上传应用:</label> <input class="easyui-filebox" name="file"
						validType=""
						data-options="prompt:'Choose a file...'" style="width: 45%">
				</div>

			</form>
			<!-- onclick="saveOrUpdate()" -->
			<div id="dlg-buttons" align="center">
				<a href="javascript:void(0)" class="easyui-linkbutton"
					iconCls="icon-ok" id="save" 
					style="width: 90px">提交</a> <a href="javascript:void(0)"
					class="easyui-linkbutton" iconCls="icon-cancel"
					onclick="returnParent(1)" style="width: 90px">取消</a>
			</div>
		</div>
	</div>
	<script type="text/javascript">
		
	 
	 $(function(){
         var options = {
              //target:     '#dataForm1',
              url:'${rootPath}/test/saveNew',
              type:'post',
              beforeSubmit: function(arr, $form, options) {
                  // The array of form data takes the following form:
                  // [ { name: 'username', value: 'jresig' }, { name: 'password', value: 'secret' } ]
            	  var r = $('#dataForm1').form('validate');
            	  if (!r) {
      				return false;
      			} 		
                  // return false to cancel submit                 
              },
              success:function(data) {
                  if (data.result == 'true' || data.result == true) {
						// $.messager.show({title:'提示',msg:data.msg,showType:'show'});
						$.messager.alert("提示", data.msg);
						returnParent(1);
						/* searchInfo();
						$("#divDialog").window('close'); */
						
              }else {
					// $.messager.alert('提示',data.msg,'error');
					$.messager.alert("提示", " 新增失败！");
					$('#save').linkbutton('enable');
				}
              },
              error: function(){
              	alert("error");
              }
             
          };
         $('#dataForm1').ajaxForm(options);
		 $("#save").click(function(){
			 $('#dataForm1').submit();
			 //$(this).resetForm(); // 提交后重置表单
			 //return false; // 阻止表单自动提交事件
		 });
	 })
		//保存记录
		/* function saveOrUpdate() {
			var r = $('#dataForm1').form('validate');
			if (!r) {
				return false;
			} else {
				$('#save').linkbutton('disable');
				console.log($("#dataForm1").serializeArray());
					$.post("${rootPath}/test/saveNew", $("#dataForm1")
						.serializeArray(), function(data) {
					if (data.result == 'true' || data.result == true) {
						// 			 	$.messager.show({title:'提示',msg:data.msg,showType:'show'});
						$.messager.alert("提示", " 新增成功！");
						goBack(1);
						//returnParent(1);
					} else {
						// 				$.messager.alert('提示',data.msg,'error');
						$.messager.alert("提示", " 新增失败！");
						$('#save').linkbutton('enable');
					}
				}); 
				
				
			} 
		} */

	</script>

</body>
</html>
