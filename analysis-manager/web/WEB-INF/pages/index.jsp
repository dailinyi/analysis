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
    <link rel="stylesheet" type="text/css" href="<%=basePath%>/css/default.css" />
    <title>欢迎你!</title>
</head>
<body>
    <div class="easyui-layout" style="overflow: hidden; height: 100%; border: none; margin: 0px; padding: 0px;" scroll="no">
        <div  data-options="region:'north'" split="true" border="false" style="overflow: hidden; height: 40px;
                background: url(<%=basePath%>/images/layout-browser-hd-bg.gif) #7f99be repeat-x center 50%; line-height: 30px; color: #fff;">

            <span style="float: right; padding-right: 20px;" class="head">欢迎 admin

            <a href="#" id="editpass">修改密码</a> <a href="#" id="loginOut">安全退出</a>
            </span>
            <span style="padding-left: 20px; font-size: 16px; float: left;">
                <img src="<%=basePath%>/images/blocks.gif" width="20" height="20" align="absmiddle" />
                snort分析系统
            </span>

        </div>
        <div data-options="region:'west',split:true" title="导航菜单" style="width:200px;">
            <%@include file="include/left.jsp"%>
        </div>
        <div data-options="region:'center'">
            <div id="tabs" class="easyui-tabs"  fit="true" border="false">
                <div title="欢迎使用" style="padding: 20px; overflow: hidden;" id="home">
                    <h1>
                        Welcome !
                    </h1>
                </div>

            </div>

        </div>
    </div>
    <script type="text/javascript">

        $(function() {
            $('.tree-title a').click(function () {


//                var title = $(this).val();
                var title = $(this)[0].innerText;
                var url = $(this).attr("url");

                $('#tabs').tabs('add', {
                    title: title ,
                    href:url,
                    closable: true,
                    tools: [
                        {
                            iconCls:'icon-reload',
                            handler:function(){

                                    $('#tabs').tabs('getTab',title).panel('refresh');


                            }
                        }
                    ]
                });
            });
        })
    </script>
</body>
</html>
