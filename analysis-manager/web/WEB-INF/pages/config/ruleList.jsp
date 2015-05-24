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

<div style="margin:0px 0;"></div>

<table class="easyui-datagrid" title="规则库列表" style="width:100%"
       url="<%=basePath%>/config/listRulesAjax.do?serverName=<%=request.getAttribute("serverName")%>"
       data-options="rownumbers:true,singleSelect:true,method:'get'">
    <thead>
    <tr>
        <th field="fileName" width="40%" data-options="formatter:rowformater">规则库文件名称</th>
        <th field="mergeDate" width="30%" align="right">规则库文件修改日期</th>
        <th field="fileSize" width="30%" >规则库文件大小</th>

    </tr>
    </thead>
</table>



<div id="w" class="easyui-dialog" title="规则库文件" style="width:80%;height:80%;padding:10px"
     data-options="
				iconCls: 'icon-save',
				closed:true,
				inline:true,
				modal:true,
				buttons: [{
					text:'Save',
					iconCls:'icon-save',
					handler:function(){
						mergeRules()
					}
				},{
				    text:'Close',
					handler:function(){
						$('#w').dialog('close')
					}
				}]
			">
    当你看到这段文字的时候,说明可能服务器出问题了.请联系管理员解决.
</div>

<script type="application/javascript">
        function rowformater(value,row,index){

            if(value != null && value != '[total]'){

                var cli = "openPanel('"+value+"')";
                return '<a href="###" onclick="'+cli+'">'+value+'</a>';
            } else {
                return value;
            }
        }

        function openPanel(value){
            var url = "<%=basePath%>/config/ruleConf.do?serverName=<%=request.getAttribute("serverName")%>&ruleName="+value;
            $.post(url,{},function(data){
                var result = "";
                var resultJson = eval(data);
                if(resultJson.status == 0){
                    $("#w").html('<input type="hidden" id="ruleNames" value="'+value+'" /><textarea id="'+value+'Content" style="width:100%;height:100%">'+resultJson.content+'</textarea>');
                    $('#w').window('open');

                } else {
                    result = resultJson.errorMsg;
                    $.messager.show({
                        title:'操作结果',
                        msg : result,
                        showType:'show',
                        timeout:'3000'
                    });
                }

            });
        }

        function mergeRules(){
            var ruleName = $("#ruleNames").val();
            if(ruleName == null || ruleName == ""){
                $.messager.show({
                    title:'操作结果',
                    msg : '页面获取不到此文件,请联系管理员!',
                    showType:'show',
                    timeout:'3000'
                });
            }
            var url = "<%=basePath%>/config/mergeRuleConf.do";
            var id = ruleName + "Content"
            $.post(url,{serverName:'<%=request.getAttribute("serverName")%>',ruleName:ruleName,content:document.getElementById(id).value},function(data){
                var result = "";
                var resultJson = eval(data);
                if(resultJson.status == 0){
                    result = "修改成功!"
                    $('#w').window('close');
                } else {
                    result = resultJson.errorMsg;
                }
                $.messager.show({
                    title:'操作结果',
                    msg : result,
                    showType:'show',
                    timeout:'3000'
                });
            });
        }

</script>

</body>
</html>
