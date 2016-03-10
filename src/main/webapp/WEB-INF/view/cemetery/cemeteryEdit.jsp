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
		<form id="dataForm12" name="dataForm12" >
		<table id="dataTable2" title="陵园信息" style="margin-left: 30px;margin-top: 30px;"> 
			<input type="hidden" name="cemeteryId" />
			<input type="hidden" name="version" />
			<div class="fitem" style="width:700px">
		    	<label>陵园编号:</label>
		        <input name="cemeteryCode" class="easyui-textbox" data-options="required:true" disabled>
			</div>
			<div class="fitem" style="width:700px">
		    	<label>陵园名称:</label>
		        <input name="cemeteryName" class="easyui-textbox" data-options="required:true" validType="length[0,50]">
			</div>
			<div class="fitem" style="width:700px">
		    	<label>陵园介绍:</label>
		    	<textarea name="cemeteryContent" data-options="required:true" style=" border:1px solid #99bbe8;" validType="length[0,1000]"  rows="4" cols="31" class="easyui-validatebox"  ></textarea>
			</div>
			<%-- <div class="fitem" style="width: 700px">
		    	<label>陵园类型:</label>
		        <input name="cemeteryType" class="easyui-textbox" data-options="required:true" style="width:100px" panelHeight="auto"
		        url="${rootPath}/getDictCombox?dictType=cemeteryType" valueField="dictId" textField="dictName" disabled>
			</div> --%>
			<div class="fitem" style="width:700px">
		    	<label>陵园地址:</label>
		    	<textarea name="cemeteryAddrass" data-options="required:true" style=" border:1px solid #99bbe8;" validType="length[0,100]"  rows="4" cols="31" class="easyui-validatebox"  ></textarea>
			</div>
			<%-- <div class="fitem" style="padding-left: 60px" >
			<c:forEach  items="${urlList}" var="measure" varStatus="s">
						<img src="${measure.url}" width="80" height="50" />
			</c:forEach>	
	       </div> --%>
			<!-- <div class="fitem" style="width:700px">
		    	<label>示意图:</label>
		        <input name="signalUrl" class="easyui-textbox" data-options="required:true">
			</div> -->
			<div class="fitem" style="width:700px">
		    	<label>经度:</label>
		        <input name="longitude" class="easyui-numberbox" validType="length[0,14]" data-options="required:true,groupSeparator:',',decimalSeparator:'.',min:0,precision:6" />
			</div>
			<div class="fitem" style="width:700px">
		    	<label>纬度:</label>
		        <input name="latitude" class="easyui-numberbox" validType="length[0,14]" data-options="required:true,groupSeparator:',',decimalSeparator:'.',min:0,precision:6" />
			</div>
			<div class="fitem" style="width:700px">
		    	<label>站点:</label>
		        <input name="site" class="easyui-combobox" data-options="required:true" style="width:100px" panelHeight="auto"
		        url="${rootPath}/getDictCombox?dictType=SITE" valueField="dictId" textField="dictName" disabled>
			</div>
			<div class="fitem" style="width: 700px">
		    	<label>城市区域:</label>
		        <input name="areacode" class="easyui-combobox" data-options="required:true" style="width:100px" panelHeight="auto"
		        url="${rootPath}/getDictCombox?dictType=AREACODE" valueField="dictId" textField="dictName" disabled>
			</div>
		</table>
	</form>
	<form name="userFormCet" id="userFormCet" action="${rootPath}/cemetery/uploadByCemetery"  method="post" enctype="multipart/form-data">
		<input name="cemeteryId" type="hidden" id="hidCId" />
		<div class="fitem" style="width:700px">
		    <label style="vertical-align:top;margin-left: 40px">图片上传:</label>
		    <input type="file" name="file" id="file"  />
		    <input type="button" id="addfile" name="addfile" value="添加" style="width: 60px; height: 20px;">
		</div>
		<div id="addfile1"></div>
	</form>
		<br>
		 <table id="dataTable" title="园区列表" style="height: 260px"> </table>
		<table id="dataTable3" title="墓型列表"  style="height: 220px" >
			<input type="hidden" name="parkId"/>
		</table>
		<br>
	
	</div>
   <div id="dlg-buttons" align="center">
   		<a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-ok" id="save" onclick="saveOrUpdate()" style="width:90px">提交</a>
		<a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-cancel" onclick="goMainS()" style="width:90px">返回</a>
   	</div>
     <div id="divDialog"></div>
<script type="text/javascript">

var cemeteryId = '${cemeteryId}';
var parkId = '${parkId}';

jQuery(function(){ 
	// 注意：不要读取缓存
	jQuery.ajaxSetup({
		cache : false
	});
	
	if (cemeteryId != null && cemeteryId != "" && cemeteryId!=0){
		var url='${rootPath}/cemetery/getOne?cemeteryId=' + cemeteryId;
		$('#dataForm12').form('load', url);
	}
});

	//初始化园区列表
		 $('#dataTable').datagrid({
			iconCls:'icon-tip',
			singleSelect : true,
			rownumbers:true,
			pagination:true,
			fitColumns:true,
			url:'${rootPath}/cemeteryPark/getAllCemeteryParkList?cemeteryId='+cemeteryId,
			method : 'post',		
		idField : 'PARK_ID',//此处根据实际情况进行填写
		columns:[[
						{field:'CEMETERY_ID',title:'墓园ID',width:80,hidden:true },
						{field :'PARK_ID',checkbox : true,hidden:true},
						{field:'PARK_CODE',title:'园区编号',width:80},
						{field:'PARK_NAME',title:'园区名称',width:80},
						{field:'PARK_CONTENT',title:'园区介绍',width:80,hidden:true },
						{
							field : 'operate',
							title : '操作',
							width : 160,
							formatter : function(value, row,index) {
								return "<a href='#' onclick=editCemeterypark('"+row.PARK_ID+"') style='margin-left:20px'>[修改]</a>"
								+"<a href='#' onclick=delCemeterypark('"+row.PARK_ID+"','"+row.VERSION+"') style='margin-left:20px'>[删除]</a>";
							}
						},
						{field:'CREATED_TIME',title:'创建时间',width:80,hidden:true },
						{field:'CREATED_BY',title:'创建人',width:80,hidden:true },
						{field:'MODIFIED_TIME',title:'修改时间',width:80,hidden:true },
						{field:'MODIFIED_BY',title:'修改人',width:80,hidden:true },
						{field:'VERSION',title:'版本',width:80,hidden:true },
						{field:'DELFLAG',title:'删除标记',width:80,hidden:true }
	
					//注：最后一行后面的逗号要去掉
	]],
	toolbar : [{
		id : 'btnadd',
		text : '添加园区',
		iconCls : 'icon-add',
		handler : function() {
			addCemeteryPark();
		}
	}
	],
	onClickRow:function(){
		var row = $('#dataTable').datagrid('getSelected');
		//$('#ifrDictItem')[0].src = '${ctx}/dictItem/list?dictCode=' + row.dictCode+"&cateCode=" + row.cateCode;
			searchCemeteryType();
	},
	onLoadSuccess : function(data) {
		$('#dataTable').datagrid('clearSelections'); //一定要加上这一句，要不然datagrid会记住之前的选择状态，删除时会出问题
	}
	});
	 
		//初始化墓型列表
		$('#dataTable3').datagrid({
			iconCls:'icon-tip',
			singleSelect : true,
			rownumbers:true,
			pagination:true,
			fitColumns:true,
			url:'${rootPath}/cemeteryType/list?cemeteryId='+cemeteryId,
			method : 'post',		
		idField : 'TYPE_ID',//此处根据实际情况进行填写
		columns:[[
						{field :'TYPE_ID',checkbox : true,hidden:true},
						{field:'TYPE_CODE',title:'墓型编号',width:80},
						{field:'TYPE_NAME',title:'墓型名称',width:80},
// 						{field:'TYPE_CONTENT',title:'园区介绍',width:80},
// 						{field:'REAL_URL',title:'实景图片',width:80,hidden:true},
// 						{field:'MINPRICE',title:'最小价格',width:80,hidden:true},
// 						{field:'MAXPRICE',title:'最大价格',width:80,hidden:true},
// 						{field:'PRICE_AREA_CODE',title:'价格区间',width:80,hidden:true},
// 						{field:'LONGITUDE',title:'经度',width:80,hidden:true},
// 						{field:'LATITUDE',title:'纬度',width:80,hidden:true},
// 						{field:'CEMETERY_ID',title:'墓园ID',width:80,hidden:true },
						{
								field : 'operate',
								title : '操作',
								width : 160,
								formatter : function(value, row,index) {
									return "<a href='#' onclick=editCemeterytype('"+row.TYPE_ID+"') style='margin-left:20px'>[修改]</a>"
									+"<a href='#' onclick=delCemeterytype('"+row.TYPE_ID+"','"+row.VERSION+"') style='margin-left:20px'>[删除]</a>";
								}
							},
						{field:'CREATED_TIME',title:'创建时间',width:80,hidden:true },
						{field:'CREATED_BY',title:'创建人',width:80,hidden:true },
						{field:'MODIFIED_TIME',title:'修改时间',width:80,hidden:true },
						{field:'MODIFIED_BY',title:'修改人',width:80,hidden:true },
						{field:'VERSION',title:'版本',width:80,hidden:true },
						{field:'DELFLAG',title:'删除标记',width:80,hidden:true }
	
					//注：最后一行后面的逗号要去掉
	]],
	toolbar : [{
		id : 'btnadd',
		text : '添加墓型',
		iconCls : 'icon-add',
		handler : function() {
			addCemeteryType();
		}
	}
	],
	onLoadSuccess : function(data) {
		$('#dataTable3').datagrid('clearSelections'); //一定要加上这一句，要不然datagrid会记住之前的选择状态，删除时会出问题
	}
	});
		
	//查询该陵园下的园区
	function searchCemeteryPark(){
		
		var url = '${rootPath}/cemeteryPark/getAllCemeteryParkList?cemeteryId='+cemeteryId;
		$('#dataTable').datagrid('reload',url); //设置好查询参数 reload 一下就可以了

}
		
	//查询该园区下的墓型
	 function searchCemeteryType(){
		var parkId;
		$('input[name=PARK_ID]:checked').each(
				function(i){
					parkId = $(this).val();
				});
		var url='${rootPath}/cemeteryType/getCemeteryType?parkId='+parkId;
		$('#dataTable3').datagrid('reload',url); //设置好查询参数 reload 一下就可以了	
	}
	
	
	//添加园区
		function addCemeteryPark() {
			url = '${rootPath}/cemeteryPark/add?cemeteryId='+cemeteryId;
			$("#divDialog").dialog({ 
		        title: "添加园区",
		        width: 430,
		        height: 430,
		        href:url,
				cache: false,
				closed: false,    
			    modal:true
		    });
		}
	
		//添加墓型
		function addCemeteryType() {
			var parkId = "";
			$('input[name=PARK_ID]:checked').each(
					function(i){
						parkId = $(this).val();
					});
			
			if(parkId==""){
				alert("请选择园区");
			}else{
				url = '${rootPath}/cemeteryType/add?parkId='+parkId;
				$("#divDialog").dialog({ 
			        title: "添加墓型",
			        width: 430,
			        height: 430,
			        href:url,
					cache: false,
					closed: false,    
				    modal:true
			    });
				
			}
		}
	
	//保存或修改
	function saveOrUpdate()
	{
		var r = $('#dataForm12').form('validate');
		if(!r) {
			return false;
		}
		else
		{	
			$.post("${rootPath}/cemetery/save",$("#dataForm12").serializeArray(),
			function(data)
			{			
				if(data.result == 'true' || data.result == true)
				{	
					$("#hidCId").val(cemeteryId);
					$('#userFormCet').form('submit', {   
					    success: function(data){  
					    	$.messager.alert("提示", "更新成功！");
					    	goBack(1);
					    }   
					});
				}
				else
				{
					$.messager.alert("提示", "更新失败！");
					$('#save').linkbutton('enable');
				}
			});
		}
	}
	
	//编辑园区
	function editCemeterypark(parkId) {
		url = '${rootPath}/cemeteryPark/edit?parkId='+parkId;
		$("#divDialog").dialog({ 
	        title: "修改园区信息",
	        width: 430,
	        height: 430,
	        href:url,
			cache: false,
			closed: false,    
		    modal:true
	    });
	}
	
 	//编辑墓型
	function editCemeterytype(typeId) {
		url = '${rootPath}/cemeteryType/edit?typeId='+typeId;
		$("#divDialog").dialog({ 
	        title: "修改墓型信息",
	        width: 430,
	        height: 430,
	        href:url,
			cache: false,
			closed: false,    
		    modal:true
	    });
	}
	
	//删除园区
	   function delCemeterypark(parkId,version){
		   if (parkId && version){
	           $.messager.confirm('提示','确定要删除此园区吗？该操作将会删除该园区下的所有墓型！',function(r){
	               if (r){
	                   $.post('${rootPath}/cemeteryPark/del',{parkId:parkId,version:version},function(data){
	                   	if(data.result == 'true' || data.result == true){
	                   		$.messager.alert("提示", data.msg);
	                   		searchCemeteryPark();
	                   		goBack(4);
	   					}else{
	   						$.messager.alert("提示", "园区删除失败 ！");
	   					}                    	
	                   });
	               }
	           });
	       } else {
	    	   $.messager.alert('提示', "请选择你要操作的记录", 'info');
				return;
			}
	   }
	
	 //删除墓型
	   function delCemeterytype(typeId,version){
		   if (typeId && version){
	           $.messager.confirm('提示','确定要删除此墓型吗？',function(r){
	               if (r){
	                   $.post('${rootPath}/cemeteryType/del',{typeId:typeId,version:version},function(data){
	                   	if(data.result == 'true' || data.result == true){
	                   		$.messager.alert("提示", data.msg);
	                   		goBack(4);
	   					}else{
	   						$.messager.alert("提示", "墓型删除失败 ！");
	   					}                    	
	                   });
	               }
	           });
	       } else {
	    	   $.messager.alert('提示', "请选择你要操作的记录", 'info');
				return;
			}
	   }
	 
	//局部刷新 
	   function goBack(flag) {
			if(flag==1){
				window.location.href = '${rootPath}/cemetery/edit?cemeteryId='+ cemeteryId;
			}else if(flag==2){
				searchCemeteryPark();
				$("#divDialog").window('close');
			}else if(flag==3){
				searchCemeteryType();
				$("#divDialog").window('close');
			}else if(flag==4){
				var url='${rootPath}/cemeteryType/list?cemeteryId='+cemeteryId;
        		$('#dataTable3').datagrid('reload',url);
        		$("#divDialog").window('close');
			}
		}
	
	 //根据添加图片按钮增加多个图片上传
		$().ready(function() {
							var $addfile = $("#addfile");
							var $addfile1 = $("#addfile1");
							var fileImage = 1;
							$addfile.click(function() {
										var fileImages = '<div class="fitem"><label style="vertical-align:top;margin-left: 40px"></label>&nbsp;<input type="file" id="file'
												+ (fileImage + 1)
												+ '" name="file'
												+ (fileImage + 1)
												+ '"/><a href="javascript:void(0)" class="easyui-linkbutton" id="del1" onclick="deletcheck('
												+ (fileImage + 1)
												+ ')" style="width:90px">&nbsp;&nbsp;&nbsp;删除</a></div>';
										$addfile1.append(fileImages);
										fileImage++;
									});
						});

		function deletcheck(id) {
			if (confirm("确定要删除吗?")) {
				$("#file" + id).parent().remove();
			}
		}
	   
//返回父页面  
function goMainS(){
	window.location.href='${rootPath}/cemetery/goMains';
}
</script>

</body>
</html>
