<%--
  Created by IntelliJ IDEA.
  User: dailinyi
  Date: 15/5/24
  Time: 上午10:07
  To change this template use File | Settings | File Templates.
--%>
<%@include file="../include/head.jsp"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>
<div style="margin:0px 0;"></div>
<table class="easyui-datagrid" title="报警信息列表" style="width:100%"
       url="<%=basePath%>/alert/listAjax.do?serverName=<%=request.getAttribute("serverName")%>"
       data-options="rownumbers:true,singleSelect:true,method:'get'">
    <thead>
    <tr>
        <th field="content" width="100%" data-options="formatter:rowformater">报警信息</th>

    </tr>
    </thead>
</table>

<div id="w1" class="easyui-window" title="报警详情" data-options="modal:true,inline:true,closed:true,iconCls:'icon-save'" style="width:80%;height:80%;padding:10px;">
    当你看到这段文字的时候,说明可能服务器出问题了.请联系管理员解决.
</div>

<script type="application/javascript">
    function rowformater(value,row,index){

        if(value != null ){
            var id = "row"+row.num;
            var cli = "openPanel('"+id+"')";
            return '<a href="###" id="'+id+'" onclick="'+cli+'">'+value+'</a>';
        } else {
            return value;
        }
    }

    function openPanel(value){
        $("#w1").html("<pre>"+$("#"+value).html()+"</pre>");
        $('#w1').window('open');

    }

</script>
</body>
</html>
