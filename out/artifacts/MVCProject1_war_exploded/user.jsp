<%--
  Created by IntelliJ IDEA.
  User: 爷爷好
  Date: 2017/11/27
  Time: 22:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <meta charset="UTF-8">
    <title>Themelight</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <!-- google fonts -->

    <!-- Css link -->
    <link rel="stylesheet" href="http://code.ionicframework.com/ionicons/2.0.1/css/ionicons.min.css">
    <link rel="stylesheet" href="css/font-awesome.min.css">
    <link rel="stylesheet" href="css/owl.carousel.css">
    <link rel="stylesheet" href="css/owl.transitions.css">
    <link rel="stylesheet" href="css/animate.min.css">
    <link rel="stylesheet" href="css/lightbox.css">
    <link rel="stylesheet" href="css/bootstrap.min.css">
    <link rel="stylesheet" href="css/preloader.css">
    <link rel="stylesheet" href="css/image.css">
    <link rel="stylesheet" href="css/icon.css">
    <link rel="stylesheet" href="css/style.css">
    <link rel="stylesheet" href="css/responsive.css">
    <link href="css/bootstrap.css" rel="stylesheet" />
    <link rel="stylesheet" type="text/css" href="layui.css">
    <link href="css/login-register.css" rel="stylesheet" />
    <link rel="stylesheet" href="http://netdna.bootstrapcdn.com/font-awesome/4.0.3/css/font-awesome.css">
    <script type="text/javascript" src="layui.js"></script>
    <script src="js/jquery-1.10.2.js" type="text/javascript"></script>
    <script src="js/bootstrap.js" type="text/javascript"></script>
    <script src="js/login-register.js" type="text/javascript"></script>
</head>
<body>
<nav class="navbar navbar-default navbar-fixed-top" role="navigation" >
    <div class="container-fluid">
        <div class="navbar-header">
            <a class="navbar-brand" href="javascript:void(0)" onclick="openLoginModal();">人工智能大数据分析系统</a>
        </div>

        <ul class="nav navbar-nav " style="margin-left: 50px">
            <li ><a href="#section1">我的应用</a></li>
            <li><a href="#section2">实例应用</a></li>

        </ul>
        <form class="navbar-form navbar-left" role="search" style="margin-left: 20px">
            <div class="form-group">
                <input type="text" class="form-control" placeholder="查找应用">
            </div>
            <button type="submit" class="btn btn-default">查找</button>
        </form>

        <ul class="nav navbar-nav navbar-right">

            <li><a href="javascript:login_out()" onclick="openRegisterModal();"><span class="glyphicon glyphicon-log-in"></span> 注销</a></li>
        </ul>

        <!-- 取消登錄 -->
        <script type="text/javascript">

            function login_out()
            {
                var r=confirm("确认要取消登录吗");
                if (r==true)
                {
                    window.location.href="index.jsp";
                }

            }
        </script>

    </div>
</nav>
<div style="padding-top: 0px;padding-left: 80px">
    <div id="section1" class="container-fluid" style="padding-top: 80px" style="margin-top: 80px">
        <h2>我的应用</h2>
        <hr class="layui-bg-orange">
        <div class="col-sm-6 col-md-3">
            <a href="#" class="thumbnail">
                <img src="/wp-content/uploads/2014/06/kittens.jpg"
                     alt="通用的占位符缩略图">
            </a>
        </div>
        <div class="col-sm-6 col-md-3">
            <a href="#" class="thumbnail">
                <img src="/wp-content/uploads/2014/06/kittens.jpg"
                     alt="通用的占位符缩略图">
            </a>
        </div>
        <div class="col-sm-6 col-md-3">
            <a href="#" class="thumbnail">
                <img src="/wp-content/uploads/2014/06/kittens.jpg"
                     alt="通用的占位符缩略图">
            </a>
        </div>
        <div class="col-sm-6 col-md-3">
            <a href="#" class="thumbnail">
                <img src="/wp-content/uploads/2014/06/kittens.jpg"
                     alt="新建应用">
            </a>
        </div>
    </div>
    <div id="section2" class="container-fluid" style="padding-top: 50px">
        <h2>示例应用</h2>
        <hr class="layui-bg-blue">
        <div class="col-sm-6 col-md-3">
            <a href="#" class="thumbnail">
                <img src="/wp-content/uploads/2014/06/kittens.jpg"
                     alt="通用的占位符缩略图">
            </a>
        </div>
        <div class="col-sm-6 col-md-3">
            <a href="#" class="thumbnail">
                <img src="/wp-content/uploads/2014/06/kittens.jpg"
                     alt="通用的占位符缩略图">
            </a>
        </div>
        <div class="col-sm-6 col-md-3">
            <a href="#" class="thumbnail">
                <img src="/wp-content/uploads/2014/06/kittens.jpg"
                     alt="通用的占位符缩略图">
            </a>
        </div>
        <div class="col-sm-6 col-md-3">
            <a href="#" class="thumbnail">
                <img src="/wp-content/uploads/2014/06/kittens.jpg"
                     alt="通用的占位符缩略图">
            </a>

        </div>
    </div>

</div>

</body>
</html>
