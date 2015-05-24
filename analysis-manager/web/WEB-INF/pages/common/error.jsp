<%--
  Created by IntelliJ IDEA.
  User: dailinyi
  Date: 15/5/24
  Time: 上午9:47
  To change this template use File | Settings | File Templates.
--%>
<%@include file="../include/head.jsp"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>
    <script type="application/javascript" >
        $(function(){
            var result = "执行失败";
            if("<%=request.getAttribute("errorMessage")%>" != "null"){
                result = "<%=request.getAttribute("errorMessage")%>";
            }
            $.messager.show({
                title:'操作结果',
                msg : result,
                showType:'show',
                timeout:'3000'
            });
        });


    </script>
</body>
</html>
