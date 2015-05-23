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
                    <span>基本信息</span>
                    <ul data-options="state:'closed'">
                        <li>
                            <span>snort</span>
                            <ul data-options="state:'closed'">
                                <li><span><a href="##" url="<%=basePath%>/config/snortConfList.do?serverName=test">配置文件</a></span></li>
                                <li><span><a href="##" url="<%=basePath%>/config/listRules.do?serverName=test" >规则库</a></span></li>
                            </ul>
                        </li>
                        <li>
                            <span>guardian</span>
                            <ul data-options="state:'closed'">
                                <li><span>配置文件</span></li>
                            </ul>
                        </li>
                    </ul>
                </li>
                <li><span>报警信息</span></li>
                <li><span>防御动作</span></li>
            </ul>

        </div>
        <div title="HTTP(172.16.1.2)" style="overflow:auto;padding:10px;">
            <ul class="easyui-tree">
                <li>
                    <span>基本信息</span>
                    <ul data-options="state:'closed'">
                        <li>
                            <span>snort</span>
                            <ul data-options="state:'closed'">
                                <li><span>配置文件</span></li>
                                <li><span>规则库</span></li>
                            </ul>
                        </li>
                        <li>
                            <span>guardian</span>
                            <ul data-options="state:'closed'">
                                <li><span>配置文件</span></li>
                            </ul>
                        </li>
                    </ul>
                </li>
                <li><span>报警信息</span></li>
                <li><span>防御动作</span></li>
            </ul>
        </div>
        <div title="FTP(172.16.1.3)" style="overflow:auto;padding:10px;" >
            <ul class="easyui-tree">
                <li>
                    <span>基本信息</span>
                    <ul data-options="state:'closed'">
                        <li>
                            <span>snort</span>
                            <ul data-options="state:'closed'">
                                <li><span>配置文件</span></li>
                                <li><span>规则库</span></li>
                            </ul>
                        </li>
                        <li>
                            <span>guardian</span>
                            <ul data-options="state:'closed'">
                                <li><span>配置文件</span></li>
                            </ul>
                        </li>
                    </ul>
                </li>
                <li><span>报警信息</span></li>
                <li><span>防御动作</span></li>
            </ul>
        </div>
    </div>
</body>
</html>
