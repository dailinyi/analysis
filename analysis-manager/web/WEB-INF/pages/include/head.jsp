<%--
  Created by IntelliJ IDEA.
  User: dailinyi
  Date: 15/5/17
  Time: 下午12:49
  To change this template use File | Settings | File Templates.
--%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <script type="text/javascript" src="<%=basePath%>/plugins/jquery-easyui/jquery.min.js"></script>
    <script type="text/javascript" src="<%=basePath%>/plugins/jquery-easyui/jquery.easyui.min.js"></script>
    <link rel="stylesheet" type="text/css" href="<%=basePath%>/plugins/jquery-easyui/themes/default/easyui.css">
    <link rel="stylesheet" type="text/css" href="<%=basePath%>/plugins/jquery-easyui/themes/icon.css">
    <title></title>
</head>
<body>

</body>
</html>
