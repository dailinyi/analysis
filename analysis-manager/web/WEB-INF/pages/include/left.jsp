<%--
  Created by IntelliJ IDEA.
  User: dailinyi
  Date: 15/5/17
  Time: 下午3:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <!-- 左侧菜单json-->
    <link rel="stylesheet" type="text/css" href="<%=basePath%>/plugins/jquery-easyui/themes/default/easyui.css">
    <title></title>
</head>
<body>

<div class="easyui-accordion" data-options="multiple:true">

        <div title="GATEWAY(172.16.1.1)" style="overflow:auto;padding:10px;">
            <ul class="easyui-tree">
                <li>
                    <span>ROOT</span>
                    <ul data-options="state:'closed'">
                        <li>
                            <span>snort</span>
                            <ul data-options="state:'closed'">
                                <li><span><a href="##" id="GATEWAY-snort-配置文件" url="<%=basePath%>/config/snortConfList.do?serverName=GATEWAY">配置文件</a></span></li>
                                <li><span><a href="##" id="GATEWAY-snort-规则库" url="<%=basePath%>/config/listRules.do?serverName=GATEWAY" >规则库</a></span></li>
                                <li><span><a href="##" id="GATEWAY-snort-报警信息" url="<%=basePath%>/alert/list.do?serverName=GATEWAY">报警信息</a></span></li>
                                <li><span><a href="##" id="GATEWAY-snort-运行信息" url="<%=basePath%>/config/snortLog.do?serverName=GATEWAY">运行信息</a></span></li>
                            </ul>
                        </li>
                        <li><span><a href="##" id="GATEWAY-服务设置" url="<%=basePath%>/status/snortStatus.do?serverName=GATEWAY&snortOnly=true" >服务设置</a></span></li>

                    </ul>
                </li>

            </ul>

        </div>
        <div title="HTTP(172.16.1.2)" style="overflow:auto;padding:10px;">
            <ul class="easyui-tree">

                <li>
                    <span>ROOT</span>
                    <ul data-options="state:'closed'">
                        <li>
                            <span>snort</span>
                            <ul data-options="state:'closed'">
                                <li><span><a href="##" id="HTTP-snort-配置文件" url="<%=basePath%>/config/snortConfList.do?serverName=HTTP">配置文件</a></span></li>
                                <li><span><a href="##" id="HTTP-snort-规则库" url="<%=basePath%>/config/listRules.do?serverName=HTTP" >规则库</a></span></li>
                                <li><span><a href="##" id="HTTP-snort-报警信息" url="<%=basePath%>/alert/list.do?serverName=HTTP">报警信息</a></span></li>
                                <li><span><a href="##" id="HTTP-snort-运行信息" url="<%=basePath%>/config/snortLog.do?serverName=HTTP">运行信息</a></span></li>
                            </ul>
                        </li>
                        <li>
                            <span>guardian</span>
                            <ul data-options="state:'closed'">
                                <li><span><a href="##" id="HTTP-guardian-配置文件" url="<%=basePath%>/config/guardianConf.do?serverName=HTTP">配置文件</a></span></li>
                                <li><span><a href="##" id="HTTP-guardian-防御动作" url="<%=basePath%>/log/guardianLogAction.do?serverName=HTTP">防御动作</a></span></li>
                                <li><span><a href="##" id="HTTP-guardian-运行信息" url="<%=basePath%>/log/guardianLog.do?serverName=HTTP">运行信息</a></span></li>

                            </ul>
                        </li>
                        <li><span><a href="##" id="HTTP-服务设置" url="<%=basePath%>/status/snortStatus.do?serverName=HTTP" >服务设置</a></span></li>

                    </ul>
                </li>
            </ul>
        </div>
        <div title="FTP(172.16.1.3)" style="overflow:auto;padding:10px;" >
            <ul class="easyui-tree">
                <li>
                    <span>ROOT</span>
                    <ul data-options="state:'closed'">
                        <li>
                            <span>snort</span>
                            <ul data-options="state:'closed'">
                                <li><span><a href="##" id="FTP-snort-配置文件" url="<%=basePath%>/config/snortConfList.do?serverName=FTP">配置文件</a></span></li>
                                <li><span><a href="##" id="FTP-snort-规则库" url="<%=basePath%>/config/listRules.do?serverName=FTP" >规则库</a></span></li>
                                <li><span><a href="##" id="FTP-snort-报警信息" url="<%=basePath%>/alert/list.do?serverName=FTP">报警信息</a></span></li>
                                <li><span><a href="##" id="FTP-snort-运行信息" url="<%=basePath%>/config/snortLog.do?serverName=FTP">运行信息</a></span></li>

                            </ul>
                        </li>
                        <li>
                            <span>guardian</span>
                            <ul data-options="state:'closed'">
                                <li><span><a href="##" id="FTP-guardian-配置文件" url="<%=basePath%>/config/guardianConf.do?serverName=FTP">配置文件</a></span></li>
                                <li><span><a href="##" id="FTP-guardian-防御动作" url="<%=basePath%>/log/guardianLogAction.do?serverName=FTP">防御动作</a></span></li>
                                <li><span><a href="##" id="FTP-guardian-运行信息" url="<%=basePath%>/log/guardianLog.do?serverName=FTP">运行信息</a></span></li>

                            </ul>
                        </li>
                        <li><span><a href="##" id="FTP-服务设置" url="<%=basePath%>/status/snortStatus.do?serverName=FTP" >服务设置</a></span></li>
                    </ul>
                </li>
            </ul>
        </div>
    </div>
</body>
</html>
