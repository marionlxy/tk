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
<input type="hidden" name="reqMenuId">
<div class="easyui-layout" data-options="fit : true,border : false">
<div class="easyui-panel" title="查询条件" data-options="region:'north',height:100,collapsible:false,border : false">
	
		<form id="dataForm1" method="post">
			 <table style="width:100%; height:1%; overflow: hidden;" border="0" 
				cellpadding="0" cellspacing="0"  class="kTable" >
			    <tr>
				<td class="kTableLabel">投诉编号:</td>
				<td>
					<input class="z-text easyui-textbox" name="complainNum" id="complainNum" />
				</td>
				<td class="kTableLabel">投诉人姓名:</td>
				<td>
					<input class="z-text easyui-textbox" name="complainName" id="complainName"/>
				</td>
				<td class="kTableLabel">投诉状态:</td>
				<td>
					<input class="easyui-combobox" name="complainState" style="width:70px" panelHeight="auto"
				 	url="${rootPath}/getDictCombox?dictType=complainstage" valueField="dictId" textField="dictName" editable="editable">
				</td>
             	<td class="kTableLabel">投诉类型:</td>
				<td>
					<input class="easyui-combobox" name="complainType" style="width:70px" panelHeight="auto"
 				 	url="${rootPath}/getDictCombox?dictType=type" valueField="dictId" textField="dictName" editable="editable">
				</td>
				<td class="kTableLabel">站点:</td>
				<td>
					<input class="easyui-combobox" name="site"  style="width:70px" panelHeight="auto"
 				 	url="${rootPath}/getDictCombox?dictType=SITE" valueField="dictId" textField="dictName" editable="editable">
				</td>
               </tr>
               <tr >
               <td  valign="middle" align="center" colspan="8" >
				<a href="javascript:void(0)" class="easyui-linkbutton"
							iconCls="icon-search" onclick="searchInfo()" style="width: 90px">查询</a>
                  <a href="javascript:void(0)" class="easyui-linkbutton"
                            iconCls="icon-empty" onclick="clearForm()" style="width: 90px">清空</a>
                </td>
                </tr>
			</table>
		</form>
		
		</div>
     <div data-options="region:'center',border:false"   style="overflow: hidden;">
             <table id="dataTable" >
             </table> 
     </div>
   <div id="divDialog"></div>
</div>
<script type="text/javascript">


var reqMenuId;
 jQuery(function() {
	 reqMenuId = '${reqMenuId}';
	 complainState = '${complainState}';
	//初始化列表
	var dictList = getDictList('complainstage,type,SITE');
   	$('#dataTable').datagrid({
   		iconCls:'icon-tip',
   		singleSelect : true,
   		url:"${rootPath}/complain/list",
   		fit:true,
   		rownumbers:true,
   		pagination:true,
   		method : 'post',
   		idField : 'COMPLAIN_ID',//此处根据实际情况进行填写
		columns:[[
	                {field:'ck',checkbox:true},
	                //{field:'COMPLAIN_ID',title:'投诉ID',width:100},
            		{field:'COMPLAIN_NUM',title:'投诉编号',width:120},
					{field:'COMPLAIN_NAME',title:'投诉人姓名',width:100},
					{field:'SITE',title:'站点',width:60 , formatter : function(value, row, index) {
						return getDictName(dictList,"SITE",value);
					}},
					{field:'COMPLAIN_TEL',title:'投诉人电话',width:100},
                    {field:'COMPLAIN_STATE',title:'投诉状态',width:80,formatter : function(value, row,index) {
								return getDictName(dictList,"complainstage",value);
					}},
// 					{field:'COMPLAIN_TYPE',title:'投诉类型',width:100},
					{field:'COMPLAIN_TYPE',title:'投诉类型',width:80,formatter : function(value, row,index) {
								return getDictName(dictList,"type",value);
					}},
                   	{
						field : 'operate',
						title : '操作',
						width : 200,
						formatter : function(value, row,index) {
							return "<a href='#' onclick=viewrow('"+row.COMPLAIN_ID+"') style='margin-left:20px'>[查看详细]</a>"
 						   +"<a href='#' onclick=editrow('"+row.COMPLAIN_ID+"','"+row.COMPLAIN_STATE+"') style='margin-left:10px'>[修改]</a>"
 							+"<a href='#' onclick=deleUserrow('"+row.COMPLAIN_ID+"','"+row.VERSION+"','"+row.COMPLAIN_STATE+"') style='margin-left:10px'>[删除]</a>";
						}
					}
			    
					//注：最后一行后面的逗号要去掉
				]],
		toolbar : [{
			id : 'btnadd',
			text : '新增',
			iconCls : 'icon-add',
			handler : function() {
				addComplain();
			}
		}],
		onLoadSuccess : function(data) {
			$('#dataTable').datagrid('clearSelections'); //一定要加上这一句，要不然datagrid会记住之前的选择状态，删除时会出问题
          
		}
	});
    

});
 

 
/**
 * 增加用户<br/>
 */
function addComplain() {
	url = '${rootPath}/complain/add';
	$("#divDialog").dialog({
        title: "新增投诉信息",
        width: 450,
        height: 550,
        href:url,
		cache: false,
		closed: false,    
	    modal:true
    });
}
 function editrow(complainId,complainState){ 
	 
		if(complainState==0){
			
			$.messager.alert('提示', "该记录已被处理,不允许修改", 'info');
		}else{
			 if (complainId){
				 url = '${rootPath}/complain/edit?complainId='+ complainId;
		 		$("#divDialog").dialog({
		 			title : "修改投诉信息",
		 			width : 450,
		 			height : 430,
		 			href : url,
		 			cache : false,
		 			closed : false,
		 			modal : true
		 		});
		 }
		 else
		 {
		 	$.messager.alert('提示', "请选择你要操作的记录", 'info');
			return;
		 }
		 }
		}
 

/**
 * 删除投诉<br/>
 */
function deleUserrow(complainId,version,complainState) {
// 	var row = $('#dataTable').datagrid('getSelected');
	if(complainState==0){
		alert("该投诉已被处理,不允许删除");
	}else{
		if (complainId && version) {
			$.messager.confirm('提示','确定要删除此投诉记录吗？',function(r){
				if (r) {
					$.post('${rootPath}/complain/del', {complainId:complainId,version:version}, function(data) {
						if (data.result == 'true' || data.result == true) {
							$.messager.alert("success", "投诉删除成功！");
							goBack(1);
						} else {
							$.messager.alert("error", "投诉删除失败 ！");
						}
					});
				}
			});
		} else {
	        return;
	  }
	}
	
}

	function goBack(flag) {
		if (flag == 1) {
			searchInfo();
		}
		$("#divDialog").window('close');
	}
		
//清空查询条件
function clearForm() {
    $('#dataForm1').form('clear');
    searchInfo();
}


/**
 * 增加用户<br/>
 */
function addComplain() {
	url = '${rootPath}/complain/add';
	$("#divDialog").dialog({
        title: "新增",
        width: 450,
        height: 350,
        href:url,
		cache: false,
		closed: false,    
	    modal:true
    });
}
 //表格查询
 function searchInfo() {
     //查询参数直接添加在queryParams中
     var queryParams = $('#dataTable').datagrid('options').queryParams;
     var fields = $('#dataForm1').serializeArray(); //自动序列化表单元素为JSON对象
     $.each(fields, function(i, field) {
         queryParams[field.name] = field.value; //设置查询参数
 
     });
     var url = '${rootPath}/complain/list';
     $('#dataTable').datagrid('reload',url); //设置好查询参数 reload 一下就可以了
 }
 //查看
 function viewrow(complainId){    	
     if (complainId){
  	   	url = '${rootPath}/complain/view?complainId='+ complainId;
	   		$("#divDialog").dialog({
	   			title : "查看投诉信息",
	   			width : 450,
	   			height : 430,
	   			href : url,
	   			cache : false,
	   			closed : false,
	   			modal : true
	   		});
     }
 }
	//关闭弹出窗口，返回父页面,根据标记决定是否执行查询操作
	function returnParent(flag) {
		if(flag==1) {
			searchInfo();
		}
		$("#divDialog").window('close');
	}

</script>
</body>
</html>