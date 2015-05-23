<%--
  Created by IntelliJ IDEA.
  User: dailinyi
  Date: 15/5/13
  Time: 下午5:52
  To change this template use File | Settings | File Templates.
--%>
<%@include file="include/head.jsp"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <script type="text/javascript" src="<%=basePath%>/js/menu.js"></script>
    <title>欢迎你!</title>
</head>
<body>
    <div class="easyui-layout" style="width:100%;height:100%">
        <div data-options="region:'north'" style="height:50px">
            <center>欢迎进入管理系统</center>
        </div>
        <div data-options="region:'west',split:true" title="目录" style="width:200px;">
            <%@include file="include/left.jsp"%>
        </div>
        <div data-options="region:'center',title:'查询',iconCls:'icon-ok'">
            <table class="easyui-datagrid"
                   data-options="url:'datagrid_data1.json',method:'get',border:false,singleSelect:true,fit:true,fitColumns:true">
                <thead>
                <tr>
                    <th data-options="field:'itemid'" width="80">Item ID</th>
                    <th data-options="field:'productid'" width="100">Product ID</th>
                    <th data-options="field:'listprice',align:'right'" width="80">List Price</th>
                    <th data-options="field:'unitcost',align:'right'" width="80">Unit Cost</th>
                    <th data-options="field:'attr1'" width="150">Attribute</th>
                    <th data-options="field:'status',align:'center'" width="60">Status</th>
                </tr>
                </thead>
            </table>
        </div>
    </div>
</body>
</html>
