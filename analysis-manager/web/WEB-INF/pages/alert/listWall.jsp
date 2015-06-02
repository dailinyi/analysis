<%--
  Created by IntelliJ IDEA.
  User: dailinyi
  Date: 15/6/3
  Time: 上午5:32
  To change this template use File | Settings | File Templates.
--%>
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
        <textarea name="configText" id="configText"  style="width:90%;height:90%"><%=request.getAttribute("config")%></textarea>
    </form>
</center>
<br/>

</body>
</html>

