<%--
  Created by IntelliJ IDEA.
  User: dailinyi
  Date: 15/5/13
  Time: 下午5:52
  To change this template use File | Settings | File Templates.
--%>
<%@include file="../include/head.jsp"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>欢迎你!</title>
</head>
<body style="margin-left:auto;margin-right:auto;">
<div style="margin:30px 0;"></div>
    <center>
    <form id="viewForm">
        <input id="serverName" type="hidden" name="serverName" value="<%=request.getAttribute("serverName")%>">
        <textarea name="configText" id="configText"  style="width:80%;height:80%"><%=request.getAttribute("conf")%></textarea>
    </form>
    </center>
    <br/>
    <div style="text-align:center;padding:5px">
        <a href="javascript:void(0)" class="easyui-linkbutton" onclick="submitForm()">提交</a>

    </div>
<script type="application/javascript">

    function submitForm(){
        $.messager.confirm('是否确定修改?', '修改此配置,需要重启snort后生效.是否确定修改?', function(r){
            if (r){
                submit();
            }
        });
    }

    function submit(){

        $.post("<%=basePath%>/config/mergeSnortConf.do",{configText:$("#configText").val(),serverName:$("#serverName").val()},function(data){
            var result = "";
            var resultJson = eval(data);
            if(resultJson.status == 0){
                result = "修改成功!"
            } else {
                result = resultJson.errorMsg;
            }
            $.messager.show({
                title:'操作结果',
                msg : result,
                showType:'fade',
                style:{
                    right:'',
                    bottom:''
                },
                timeout:'3000'
            });
        });
    }

</script>
</body>
</html>
