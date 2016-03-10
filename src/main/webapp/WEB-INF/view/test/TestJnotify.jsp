<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%@ include file="/include.jsp"%>
<title>Insert title here</title>
</head>

<body>


<div class="easyui-dialog" style="width:400px;height:200px"     data-options="title:'My Dialog',collapsible:true,iconCls:'icon-ok',onOpen:function(){}">     dialog content. </div>


<script type="text/javascript">
    $(document).ready(function(){
        //正确提示
        $("a#jnotify_success").click(function(e){  //定义了ID为jnotify_success的a被点击后触发下面的函数
            e.preventDefault();
            jSuccess(      //jSuccess为正确提示框，jError为错误提示，jNotify为一般提示。
                //下面的内容为提示的内容。
                '输入正确，欢迎登陆 !!点击对话框关闭本提示框。<br />您也可以应用下面的样式 <strong>加粗</strong>, <i>斜体</i>, <u>下划线</u>',
                {
                    //下面为提示框的具体参数设置。
                    autoHide : false,   //jnotify自动隐藏 true false
                    clickOverlay : false,  //jnotify弹出层单击遮罩层才关闭提示条（遮罩层即半透明黑色背景）
                    MinWidth : 250,   //jnotify弹出层宽度
                    TimeShown : 3000,   //显示时长。只有当autoHide（自动隐藏）参数为true时起作用。
                    ShowTimeEffect : 200,   //jnotify完全显示出来花费时间。
                    HideTimeEffect : 200,   //与上面参数相反，jnotify从页面上消失所需时间
                    LongTrip : 20,          //当jnotify弹出层提示条显示和隐藏时的位移
                    HorizontalPosition : 'center',  //jnotify弹出层提示条位于水平方向上的位置，参数有left,center,right
                    VerticalPosition : 'center',    //jnotify弹出层提示条位于垂直方向上的位置，参数有top,center,bottom
                    ShowOverlay : false,   //是否显示遮罩层（遮罩层即半透明黑色背景）
                    ColorOverlay : '#000',   //遮罩层颜色
                    OpacityOverlay : 0.3,   //遮罩层透明度，最大是1，最小是0.1
                    onClosed : function(){},   //关闭jnotify弹出层提示条调用的函数
                    onCompleted : function(){}   //打开jnotify弹出层提示条调用的函数
                }
            );
        });
    });
</script>
</body>
</html>