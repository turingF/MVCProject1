<%--
  Created by IntelliJ IDEA.
  User: 爷爷好
  Date: 2017/11/28
  Time: 23:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@page import="com.jspsmart.upload.SmartUpload"%>
<html>
<head>
    <title>Title</title>



</head>
<body>
<%
    //实例化SmartUpload上传组件
    SmartUpload su = new SmartUpload();
//初始化上传操作
    su.initialize(pageContext);
//上传准备
    su.upload();
//将上传文件保存在upload文件夹中，该文件夹是手动创建的。
    String uname = su.getRequest().getParameter("optionsRadiosinline");
    su.save("/upload");
%>
<%=uname%>

</body>
</html>
