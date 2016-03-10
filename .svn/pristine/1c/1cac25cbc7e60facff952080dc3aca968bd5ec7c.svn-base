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
	<form id="dataForm13">
		<table id="dataTable2" title="陵园信息" style="margin-left: 30px;margin-top: 30px;"> 
			<input type="hidden" name="cemeteryId" >
			<div class="fitem" style="width: 700px">
		    	<label>陵园编号:</label>
		        <input name="cemeteryCode" class="easyui-textbox" data-options="required:true" disabled>
			</div>
			<div class="fitem" style="width: 700px">
		    	<label>陵园名称:</label>
		        <input name="cemeteryName" class="easyui-textbox" data-options="required:true" disabled>
			</div>
			<div class="fitem" style="width: 700px">
		    	<label>陵园介绍:</label>
		    	<textarea name="cemeteryContent" style=" border:1px solid #99bbe8;"  rows="4" cols="31" class="easyui-validatebox"  disabled></textarea>
			</div>
			<%-- <div class="fitem" style="width: 700px">
		    	<label>陵园类型:</label>
		        <input name="cemeteryType" class="easyui-textbox" data-options="required:true" style="width:100px" panelHeight="auto"
		        url="${rootPath}/getDictCombox?dictType=cemeteryType" valueField="dictId" textField="dictName" disabled>
			</div> --%>
			<div class="fitem" style="width: 700px">
		    	<label>陵园地址:</label>
		    	<textarea name="cemeteryAddrass" style=" border:1px solid #99bbe8;"  rows="4" cols="31" class="easyui-validatebox"  disabled></textarea>
			</div>
			<div class="fitem" style="width: 700px" >
		    	<label>陵园图片:</label>
		        <c:forEach  items="${urlList}" var="measure" varStatus="s">
						<img src="${measure.url}" width="80" height="50" />
				</c:forEach>
			</div>
			<!-- <div class="fitem">
		    	<label>示意图:</label>
		        <input name="signalUrl" class="easyui-textbox" data-options="required:true">
			</div> -->
			<div class="fitem" style="width: 700px">
		    	<label>经度:</label>
		        <input name="longitude" class="easyui-textbox" data-options="required:true" disabled>
			</div>
			<div class="fitem" style="width: 700px">
		    	<label>纬度:</label>
		        <input name="latitude" class="easyui-textbox" data-options="required:true" disabled>
			</div>
			<div class="fitem" style="width: 700px">
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
		<br>
		<table id="dataTable" title="园区列表" style="height: 260px"> </table>
		<table id="dataTable3" title="墓型列表"  style="height: 220px" >
			<input type="hidden" name="linkId"/>
		</table>
		<br>
	
	</form>
	</div>
   <div id="dlg-buttons" align="center">
       <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-cancel" onclick="goMainS()" style="width:90px">返回</a>
   	</div>
    <div id="divDialog"></div>
<script type="text/javascript">

var cemeteryId = '${cemeteryId}';

jQuery(function(){ 
	// 注意：不要读取缓存
	jQuery.ajaxSetup({
		cache : false
	});
	
	
	if (cemeteryId != null && cemeteryId != "" && cemeteryId!=0){
		var url='${rootPath}/cemetery/getOne?cemeteryId=' + cemeteryId;
		$('#dataForm13').form('load', url);
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
						{field :'PARK_ID',checkbox : true,hidden:true},
						{field:'PARK_CODE',title:'园区编号',width:80},
						{field:'PARK_NAME',title:'园区名称',width:80},
						{field:'PARK_CONTENT',title:'园区介绍',width:80,hidden:true},
						{
							field : 'operate',
							title : '操作',
							width : 160,
							formatter : function(value, row,index) {
								return "<a href='#' onclick=viewCemeteryPark('"+row.PARK_ID+"') style='margin-left:10px'>[查看详细]</a>";
							}
						},
						{field:'CEMETERY_ID',title:'墓园ID',width:80,hidden:true },
						{field:'CREATED_TIME',title:'创建时间',width:80,hidden:true },
						{field:'CREATED_BY',title:'创建人',width:80,hidden:true },
						{field:'MODIFIED_TIME',title:'修改时间',width:80,hidden:true },
						{field:'MODIFIED_BY',title:'修改人',width:80,hidden:true },
						{field:'VERSION',title:'版本',width:80,hidden:true },
						{field:'DELFLAG',title:'删除标记',width:80,hidden:true }
	
					//注：最后一行后面的逗号要去掉
	]],
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
									return "<a href='#' onclick=viewCemeteryType('"+row.TYPE_ID+"') style='margin-left:10px'>[查看详细]</a>";
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
	onLoadSuccess : function(data) {
		$('#dataTable3').datagrid('clearSelections'); //一定要加上这一句，要不然datagrid会记住之前的选择状态，删除时会出问题
	}
	});

		
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
	
	/**
	 * 查看墓型详细
	 */
	function viewCemeteryType(typeId) {
		url = '${rootPath}/cemeteryType/view?typeId='+typeId;
		$("#divDialog").dialog({ 
	        title: "查看墓型",
	        width: 430,
	        height: 430,
	        href:url,
			cache: false,
			closed: false,    
		    modal:true
	    });
	}
	 
	 /**
		 * 查看园区详细
		 */
		function viewCemeteryPark(parkId) {
			url = '${rootPath}/cemeteryPark/view?parkId='+parkId;
			$("#divDialog").dialog({ 
		        title: "查看园区",
		        width: 430,
		        height: 430,
		        href:url,
				cache: false,
				closed: false,    
			    modal:true
		    });
		}
	 
//返回父页面  
function goMainS(){
	window.location.href='${rootPath}/cemetery/goMains';
}
</script>

</body>
</html>
