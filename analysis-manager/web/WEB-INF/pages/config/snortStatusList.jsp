<%--
  Created by IntelliJ IDEA.
  User: dailinyi
  Date: 15/5/24
  Time: 下午1:55
  To change this template use File | Settings | File Templates.
--%>
<%@include file="../include/head.jsp"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<%
    Boolean snortStatus = (Boolean)request.getAttribute("snortStatus");
    Boolean guardianStatus = (Boolean)request.getAttribute("guardianStatus");
    String serverName = (String)request.getAttribute("serverName");
    Boolean snortOnly = (Boolean)request.getAttribute("snortOnly");
%>
<head>
    <title></title>
    <script type="application/javascript">
        var snortStatus = <%=snortStatus%>;
        var snortServerName = "<%=serverName%>";
        $(function(){

            if(snortStatus != null && snortStatus == true){
                snortChange("start");
            } else {
                snortChange("stop");
            }
            $("#"+snortServerName+"startSnort").click(function(){
                changeSnort("start");
            });
            $("#"+snortServerName+"stopSnort").click(function(){
                changeSnort("stop");
            });
        });

        function snortChange(snortAction){
            if(snortAction == "start"){

                $("#"+snortServerName+"snortStatus").html("已启动");
                $("#"+snortServerName+"startSnort").attr('disabled',"disabled");
                $("#"+snortServerName+"stopSnort").removeAttr('disabled');
            } else if (snortAction == "stop"){
                $("#"+snortServerName+"snortStatus").html("已停止");
                $("#"+snortServerName+"stopSnort").attr('disabled',"disabled");
                $("#"+snortServerName+"startSnort").removeAttr('disabled');
            }

        };


        function changeSnort(snortAction){
            var url = "";
            var result = "";
            if(snortAction == "start"){
                url = "<%=basePath%>/status/snortStart.do";
                result = "启动成功";
            } else if (snortAction == "stop"){
                url = "<%=basePath%>/status/snortStop.do";
                result = "停止成功";
            } else {
                $.messager.show({
                    title:'操作结果',
                    msg : '指令错误,请联系管理员!',
                    showType:'show',
                    timeout:'3000'
                });
                return;
            }

            $.post(url,{serverName:'<%=request.getAttribute("serverName")%>'},function(data){

                var resultJson = eval(data);
                if(resultJson.status == 0){

                    snortChange(snortAction);
                } else {
                    result = resultJson.errorMsg;
                }
                $.messager.show({
                    title:'操作结果',
                    msg : result,
                    showType:'show',
                    timeout:'3000'
                });
            });
        };




    </script>

</head>
<body>

<div style="width: 100%; height: 100px; " class="easyui-panel" title="snort状态">
    <form id="ff" method="post">
        <input type="hidden" value="<%=request.getAttribute("serverName")%>" name="serverName"/>
        <table cellpadding="5" width="100%">
            <tr>
                <td width="20%" align="right">服务器操作:</td>
                <td width="30%">
                        <input type="button" value="启动"  id="<%=serverName%>startSnort"/>
                        <input type="button" value="停止"  id="<%=serverName%>stopSnort"/>
                </td>
                <td width="20%" align="right">服务器状态:</td>
                <td width="30%">
                    <span id = "<%=serverName%>snortStatus"></span>

                </td>

            </tr>

        </table>
    </form>

</div>
<div style="margin:10px 0;"></div>

<%
    if (snortOnly == null || !snortOnly ){
%>

<script type="application/javascript">
    var guardianStatus = <%=guardianStatus%>;
    $(function(){

        if(guardianStatus != null && guardianStatus == true){
            guardianChange("start");
        } else {
            guardianChange("stop");
        }
        $("#"+snortServerName+"guardianStart").click(function(){
            changeGuardian("start");
        });
        $("#"+snortServerName+"guardianStop").click(function(){
            changeGuardian("stop");
        });
    });

    function guardianChange(guardianAction){
        if(guardianAction == "start"){

            $("#"+snortServerName+"guardianStatus").html("已启动");
            $("#"+snortServerName+"guardianStart").attr('disabled',"disabled");
            $("#"+snortServerName+"guardianStop").removeAttr('disabled');
        } else if (guardianAction == "stop"){
            $("#"+snortServerName+"guardianStatus").html("已停止");
            $("#"+snortServerName+"guardianStop").attr('disabled',"disabled");
            $("#"+snortServerName+"guardianStart").removeAttr('disabled');
        }

    };


    function changeGuardian(snortAction){
        var url = "";
        var result = "";
        if(snortAction == "start"){
            url = "<%=basePath%>/status/guardianStart.do";
            result = "启动成功";
        } else if (snortAction == "stop"){
            url = "<%=basePath%>/status/guardianStop.do";
            result = "停止成功";
        } else {
            $.messager.show({
                title:'操作结果',
                msg : '指令错误,请联系管理员!',
                showType:'show',
                timeout:'3000'
            });
            return;
        }

        $.post(url,{serverName:'<%=request.getAttribute("serverName")%>'},function(data){

            var resultJson = eval(data);
            if(resultJson.status == 0){

                guardianChange(snortAction);
            } else {
                result = resultJson.errorMsg;
            }
            $.messager.show({
                title:'操作结果',
                msg : result,
                showType:'show',
                timeout:'3000'
            });
        });
    };




</script>

<div style="width: 100%; height: 100px; " class="easyui-panel" title="guardian状态">
    <form id="ff1" method="post">
        <input type="hidden" value="<%=request.getAttribute("serverName")%>" name="serverName"/>
        <table cellpadding="5" width="100%">
            <tr>
                <td width="20%" align="right">服务器操作:</td>
                <td width="30%">
                    <input type="button" value="启动"  id="<%=serverName%>guardianStart"/>
                    <input type="button" value="停止"  id="<%=serverName%>guardianStop"/>
                </td>
                <td width="20%" align="right">服务器状态:</td>
                <td width="30%">
                    <span id = "<%=serverName%>guardianStatus"></span>

                </td>

            </tr>

        </table>
    </form>

</div>

<%}%>


</body>
</html>
