<%--
  Created by IntelliJ IDEA.
  User: dailinyi
  Date: 15/6/2
  Time: 下午10:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>

<head>


</head>

<body>
<div style="width: 100%; height: 75px; " class="easyui-panel" title="GATEWAY服务器">
    <form id="f1" method="post">
        <table cellpadding="5" width="100%">
            <tr>
                <td width="20%" align="right">Snort操作:</td>
                <td width="30%">
                    <input type="button" value="启动"  id="gateway_snortStart"/>
                    <input type="button" value="停止"  id="gateway_snortStop"/>
                </td>
                <td width="20%" align="right">Snort状态:</td>
                <td width="30%">
                    <span id = "gateway_snortStatus"></span>

                </td>

            </tr>

        </table>
    </form>

</div>
<div style="margin:10px 0;"></div>
<div style="width: 100%; height: 110px; " class="easyui-panel" title="HTTP服务器">
    <form id="f3" method="post">
        <table cellpadding="5" width="100%">
            <tr>
                <td width="20%" align="right">Snort操作:</td>
                <td width="30%">
                    <input type="button" value="启动"  id="http_snortStart"/>
                    <input type="button" value="停止"  id="http_snortStop"/>
                </td>
                <td width="20%" align="right">Snort状态:</td>
                <td width="30%">
                    <span id = "http_snortStatus"></span>

                </td>
            <tr>
                <td width="20%" align="right">Guardian操作:</td>
                <td width="30%">
                    <input type="button" value="启动"  id="http_guardianStart"/>
                    <input type="button" value="停止"  id="http_guardianStop"/>
                </td>
                <td width="20%" align="right">Guardian状态:</td>
                <td width="30%">
                    <span id = "http_guardianStatus"></span>

                </td>

            </tr>

            </tr>

        </table>
    </form>

</div>
<div style="margin:10px 0;"></div>
<div style="width: 100%; height: 110px; " class="easyui-panel" title="FTP服务器">
    <form id="f2" method="post">
        <table cellpadding="5" width="100%">
            <tr>
                <td width="20%" align="right">Snort操作:</td>
                <td width="30%">
                    <input type="button" value="启动"  id="ftp_snortStart"/>
                    <input type="button" value="停止"  id="ftp_snortStop"/>
                </td>
                <td width="20%" align="right">Snort状态:</td>
                <td width="30%">
                    <span id = "ftp_snortStatus"></span>

                </td>

            </tr>

            <tr>
                <td width="20%" align="right">Guardian操作:</td>
                <td width="30%">
                    <input type="button" value="启动"  id="ftp_guardianStart"/>
                    <input type="button" value="停止"  id="ftp_guardianStop"/>
                </td>
                <td width="20%" align="right">Guardian状态:</td>
                <td width="30%">
                    <span id = "ftp_guardianStatus"></span>
                </td>

            </tr>

        </table>
    </form>

</div>

</body>

<script type="application/javascript">
    $(function(){
        init();
        clickAction("gateway","snort","Start");
        clickAction("gateway","snort","Stop");
        clickAction("http","snort","Start");
        clickAction("http","snort","Stop");
        clickAction("http","guardian","Start");
        clickAction("http","guardian","Stop");
        clickAction("ftp","snort","Start");
        clickAction("ftp","snort","Stop");
        clickAction("ftp","guardian","Start");
        clickAction("ftp","guardian","Stop");
    });
    function clickAction(serverName,type,action){
        $("#"+serverName+"_"+type+action).click(function(){
            doAction(serverName,type,action);
        })
    }

    function statusChange(serverName,type,action){
        if(action == "Start"){

            $("#"+serverName+"_"+type+"Status").html("已启动");
            $("#"+serverName+"_"+type+"Start").attr('disabled',"disabled");
            $("#"+serverName+"_"+type+"Stop").removeAttr('disabled');
        } else if (action == "Stop"){
            $("#"+serverName+"_"+type+"Status").html("已停止");
            $("#"+serverName+"_"+type+"Stop").attr('disabled',"disabled");
            $("#"+serverName+"_"+type+"Start").removeAttr('disabled');
        }

    };

    function init(){
        var gatewaySnortStatus = <%=request.getAttribute("gatewaySnortStatus")%> ;
        var httpSnortStatus = <%=request.getAttribute("httpSnortStatus")%> ;
        var httpGuardianStatus = <%=request.getAttribute("httpGuardianStatus")%> ;
        var ftpSnortStatus = <%=request.getAttribute("ftpSnortStatus")%> ;
        var ftpGuardianStatus = <%=request.getAttribute("ftpGuardianStatus")%> ;

        if(gatewaySnortStatus){
            statusChange("gateway","snort","Start");
        } else {
            statusChange("gateway","snort","Stop");
        }

        if(httpSnortStatus){
            statusChange("http","snort","Start");
        } else {
            statusChange("http","snort","Stop");
        }

        if(httpGuardianStatus){
            statusChange("http","guardian","Start");
        } else {
            statusChange("http","guardian","Stop");
        }

        if(ftpSnortStatus){
            statusChange("ftp","snort","Start");
        } else {
            statusChange("ftp","snort","Stop");
        }

        if(ftpGuardianStatus){
            statusChange("ftp","guardian","Start");
        } else {
            statusChange("ftp","guardian","Stop");
        }

    }

    function doAction(serverName,type,action){
        var url = "<%=basePath%>/status/" + type + action +".do";
        var result = "";

        if(action == "Start"){
            result = "启动成功";
        } else if (action == "Stop"){
            result = "停止成功";
        } else {
            $.messager.show({
                title:'操作结果',
                msg : '指令错误,请联系管理员!',
                showType:'fade',
                style:{
                    right:'',
                    bottom:''
                },
                timeout:'3000'
            });
            return;
        }

        $.post(url,{serverName:serverName.toLocaleUpperCase()},function(data){

            var resultJson = eval(data);
            if(resultJson.status == 0){
                statusChange(serverName,type,action);
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
    };







</script>
</html>
