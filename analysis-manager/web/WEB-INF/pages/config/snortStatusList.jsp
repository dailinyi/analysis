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
<head>
    <title></title>

</head>
<body>

<div style="width: 100%; height: 100px; " class="easyui-panel" title="snort状态">
    <form id="ff" method="post">
        <table cellpadding="5" width="100%">
            <tr>
                <td width="20%" align="right">服务器操作:</td>
                <td width="30%">
                    <a href="javascript:void(0)" class="easyui-linkbutton" onclick="submitForm()">启动</a>
                    <a href="javascript:void(0)" class="easyui-linkbutton" onclick="submitForm()" disabled>停止</a>
                </td>
                <td width="20%" align="right">服务器状态:</td>
                <td width="30%">已停止</td>

            </tr>

        </table>
    </form>

</div>
<div style="margin:10px 0;"></div>
<div style="width: 100%; height:100%" class="easyui-panel" title="snort日志"></div>

</body>
</html>
