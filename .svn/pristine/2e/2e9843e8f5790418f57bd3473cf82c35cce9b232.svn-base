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
<div class="easyui-layout" data-options="fit : true,border : false">
<div class="easyui-panel" title="" data-options="region:'north',height:97,collapsible:false,border : true" style="overflow: hidden;">
	<form id="dataForm1" method="post">
		<table style="width:100%; height:1%; margin-top:10px; overflow: hidden;" border="0" 
			cellpadding="0" cellspacing="0"  class="kTable" >
			 <tr>
				 <td class="kTableLabel lbl">线索编号:</td>
				 <td><input name="clueCode" class="easyui-textbox" style="width:90px"></td>
				 <td class="kTableLabel lbl">客户姓名:</td>
				 <td> <input name="customName" class="easyui-textbox" style="width:90px" >
				 <td class="kTableLabel lbl">客户电话:</td>
				 <td><input name="customTel"   class="easyui-numberbox" style="width:90px"></td>
				 <td class="kTableLabel lbl">状态:</td>
				 <td>	<input class="easyui-combobox" name="clueState" editable="editable"  style="width:90px" panelHeight="auto"
				 			url="${rootPath}/getDictCombox?dictType=clueSatus" valueField="dictId" textField="dictName">
				</td> 
			 </tr>
			  <tr>
				 <td class="kTableLabel lbl">开始时间:</td>
				 <td><input name="createdTime" class="easyui-datetimebox" style="width:90px" > &nbsp;&nbsp; &nbsp;&nbsp;
				 <td class="kTableLabel lbl">结束时间:</td>
				 <td><input name="createdTime1" class="easyui-datetimebox" style="width:90px" /></td>
				 
				 
				
			 	<td valign="middle" align="center" colspan="6" >
			 	  <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-search" onclick="searchInfo()" style="width:90px;margin-top:10px;" >查询</a>
			 	  &nbsp;&nbsp;<a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-empty"   onclick="clearForm()" style="width:90px;margin-top:10px;" >清空</a>
			 	
			 	</td>
			 </tr>
			</table>
			<input type="hidden" name="version">
			<input type="hidden" name="clueId">
		</form>
    </div>
    <div  data-options="region:'center',border:false" style="overflow: hidden;">
   		 <table id="dataTable" title="线索列表" height="100%" ></table>
    </div>    
    <div id="divDialog" ></div>
</div>
<script type="text/javascript">
jQuery(function(){
	
	jQuery.ajaxSetup({
		cache : false
	});
	var dictList = getDictList('clueSatus');
   	//初始化列表
   	$('#dataTable').datagrid({
   		iconCls:'',
   		singleSelect : true,
   		rownumbers:true,
   		pagination:true,
   		fitColumns:true,
   		method : 'post',
   		url : '${rootPath}/worksheet/clueList',
		idField : 'CLUE_ID',//此处根据实际情况进行填写
		columns:[[
// 							{field : 'ck',checkbox : true},
							{field:'CLUE_CODE',title:'线索编号',width:120},
// 							{field:'CLUE_STATE',title:'状态',width:80,hidden:true},
							{field:'CUSTOM_NAME',title:'客户姓名',width:80 },
							{field:'CUSTOM_SEX',title:'CUSTOM_SEX',width:80,hidden:true},
							{field:'CUSTOM_TEL',title:'客户电话',width:100},
							{field:'CUSTOM_ADDRESS ',title:'CUSTOM_ADDRESS',width:80,hidden:true},
							{field:'CUSTOM_REQUIRE ',title:'CUSTOM_REQUIRE ',width:80,hidden:true},
							{field:'DOOR_TIME',title:'DOOR_TIME',width:80,hidden:true},
							{field:'INVALID_REASON',title:'INVALID_REASON',width:80,hidden:true},
							{field:'PROXY_TEL',title:'代理人电话',width:100},
							{field:'ANGEL_NAME',title:'天使姓名',width:80,hidden:true},
							{field:'CLUE_STATE',title:'状态',width:80 ,formatter : function(value, row,index) {
								return getDictName(dictList,"clueSatus",value);
							}},
							{field:'CONFIRM_BY',title:'确认人',width:'10%'},
							{field:'REMARK',title:'REMARK',width:80,hidden:true},
							{field:'CREATED_TIME',title:'创建时间',width:180},
							{field:'CREATED_BY',title:'创建人',width:80},

							{
								field : 'operate',
								title : '操作',
								width : 150,
								formatter : function(value, row,index) {
									if(row.CLUE_STATE=1){
										
										return "<a href='#' onclick=editrow('"+row.CLUE_ID+"','"+row.VERSION+"') style='margin-left:20px'>[派工单]</a>";
									}
									}
							},
// 							{field:'CUSTOM_ID',title:'CUSTOM_ID',width:80,hidden:true},
// 							{field:'MODIFIED_TIME',title:'MODIFIED_TIME',width:80,hidden:true},
// 							{field:'MODIFIED_BY',title:'MODIFIED_BY',width:80,hidden:true},
// 							{field:'VERSION',title:'VERSION',width:80,hidden:true},
// 							{field:'DELFLAG',title:'DELFLAG',width:80,hidden:true},
// 							{field:'CLUE_ID',title:'CLUE_ID',width:80,hidden:true}
						//注：最后一行后面的逗号要去掉
		]],
		toolbar : [{
			id : 'btnadd',
			text : '返回',
			iconCls : 'icon-back',
			handler : function() {
				goBacks();
			}
		}],
		onLoadSuccess : function(data) {
			$('#dataTable').datagrid('clearSelections'); //一定要加上这一句，要不然datagrid会记住之前的选择状态，删除时会出问题
		}
   	});
	});
   	function goBacks(){
   	 window.location='${rootPath}/worksheet/';
   	}
   
   //表格查询
	function searchInfo() {
		//查询参数直接添加在queryParams中
		var queryParams = $('#dataTable').datagrid('options').queryParams;
		var fields = $('#dataForm1').serializeArray(); //自动序列化表单元素为JSON对象
		$.each(fields, function(i, field) {
			queryParams[field.name] = field.value; //设置查询参数
		});
		var url = '${rootPath}/worksheet/clueList';
		$('#dataTable').datagrid('reload',url); //设置好查询参数 reload 一下就可以了
	}
	
	//清空查询条件
	function clearForm() {
		$('#dataForm1').form('clear');
		searchInfo();
	}
	   
	
	function editrow(clueId){    	
		
	       if (clueId){
	    	 	url = '${rootPath}/clue/wedit?clueId='+ clueId ;
		   		$("#divDialog").dialog({
		   			title : "添加工单",
		   			width : 450,
		   			height : 450,
		   			href : url,
		   			cache : false,
		   			closed : false,
		   			modal : true
		   		});

	       }
	       else
	       {
	       	$.messager.alert('提示', "请选择你要更新的记录", 'info');
			return;
	       }
	   }
   //新增
   function addrow(){
//    		url = '${rootPath}/clue/edit';
// 		openWin(url);
	    url = '${rootPath}/clue/add';
		$("#divDialog").dialog({
			title : "添加线索",
			width : 450,
			height : 430,
			href : url,
			cache : false,
			minimized:true
			
		});
   }
   
//    //派工单
//    function editrow(clueId, version){
//        if (clueId && version){
//            $.messager.confirm('提示','确定要派工单吗？',function(r){
//                if (r){
//                    $.post('${rootPath}/worksheet/wedit',{clueId:clueId,version:version},function(data){
                   	
//                    	if(data.result == 'true' || data.result == true)
//    					{
//                    		$.messager.alert("提示", "派工单成功！");
//                    		goBack(1);
//    					}
//    					else
//    					{
// //    						$.messager.alert('提示',data.msg,'error');
//    						$.messager.alert("提示", "派工单失败 ！");
//    					}                    	
//                    });
//                }
//            });
//        } else {
//     	   $.messager.alert('提示', "请选择你要操作的记录", 'info');
// 			return;
// 		}
//    }
   //查看
   function viewrow(clueId){    	
       if (clueId){
    	   	url = '${rootPath}/clue/view?clueId='+ clueId;
	   		$("#divDialog").dialog({
	   			title : "查看线索信息",
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
//    //点击增加弹出增加窗口
// 	function openWin(url) {
// 		$('#iframeDialogSelect').attr("src", url);
// 		$('#divDialog').window('open');

// 	}
	
// 	//关闭弹出窗口，返回父页面,根据标记决定是否执行查询操作
// 	function returnParent(flag) {
// 		if(flag==1)
// 		{
// 			searchInfo();
// 		}
// 		$("#divDialog").window('close');
// 	}
	function goBack(flag) {
		if (flag == 1) {
			searchInfo();
		}
		$("#divDialog").window('close');
	}
		
		
</script>
</body>
</html>