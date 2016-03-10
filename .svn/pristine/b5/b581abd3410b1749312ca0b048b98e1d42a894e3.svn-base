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
	<form id="dataForm">
		<input type="hidden" name="sellerId">
		<input type="hidden" name="version">
		<div class="fitem">
	     	<label>评价人:</label>
	     	<input name="appraiseNum" class="easyui-textbox" value= "${appraise.appraiseNum }" disabled>
	 	</div>
        <div class="fitem">
	    	<label style="vertical-align:top;">评价信息:</label>
			<textarea name="appraiseMsg" style=" border:1px solid #99bbe8;"  rows="6" cols="31" class="easyui-validatebox" disabled>${appraise.appraiseMsg}</textarea>
        </div>
		<div class="fitem">
	    	<label>服务评价:</label>
		</div>
		<c:forEach  items="${dimensionVo}" var="entity" varStatus="s">
		<div class="fitem">
	    	<label><c:out value="${entity.dimensionField}"/>:</label>
	        <input name="bankName" class="easyui-textbox" value="<c:out value="${entity.dimensionScore}星"/>" disabled>
		</div>
		</c:forEach>
	</form>
    <div id="dlg-buttons" align="center">
       <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-cancel" onclick="goBack()" style="width:90px">取消</a>
   </div>
</div>
    
<script type="text/javascript">


</script>

</body>
</html>
