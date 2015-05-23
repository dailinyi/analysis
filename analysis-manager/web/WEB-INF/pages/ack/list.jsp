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
<body>
    <div class="easyui-layout" style="width:100%;height:100%">
        <%--<div data-options="region:'east',split:true" title="East" style="width:100px;"></div>--%>
        <div data-options="region:'west',split:true" title="West" style="width:200px;">


        </div>
        <div data-options="region:'center',title:'Main Title',iconCls:'icon-ok'">
            <table class="easyui-datagrid"
                   data-options="url:'list1.do',method:'get',border:false,singleSelect:true,fit:true,fitColumns:true">
                <thead>
                <tr>
                    <th data-options="field:'sigGid'" width="80">Item ID</th>
                    <th data-options="field:'sigRev'" width="100">Product ID</th>

                </tr>
                </thead>
            </table>
        </div>
    </div>
</body>
</html>
