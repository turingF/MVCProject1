<%--
  Created by IntelliJ IDEA.
  User: 爷爷好
  Date: 2017/11/28
  Time: 22:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <!-- google fonts -->
    <meta charset="UTF-8">
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

            <li><a href="javascript:void(0)" onclick="openRegisterModal();"><span class="glyphicon glyphicon-log-in"></span> 注销</a></li>
        </ul>
    </div>
</nav>
<form action="filedotest.jsp" method="post" enctype="multipart/form-data">
<div style="padding-top: 0px;padding-left: 80px">
    <div id="section1" class="container-fluid" style="padding-top: 80px" style="margin-top: 80px">
        <h3>请选择文件类型</h3>
        <hr class="layui-bg-orange">

            <div>
                <div class="col-sm-6 col-md-3">
                    <a href="#" class="thumbnail" onclick="document.getElementById('able').className ='btn btn-primary btn-lg';document.getElementById('optionsRadios3').checked=true">
                        <img src="/wp-content/uploads/2014/06/kittens.jpg"
                             alt="通用的占位符缩略图">
                        <input type="radio" name="optionsRadiosinline" id="optionsRadios3" value="option1" >
                    </a>
                </div>
                <div class="col-sm-6 col-md-3">
                    <a href="#" class="thumbnail" onclick="document.getElementById('able').className ='btn btn-primary btn-lg';document.getElementById('optionsRadios4').checked=true">
                        <img src="/wp-content/uploads/2014/06/kittens.jpg"
                             alt="通用的占位符缩略图">
                        <input type="radio" name="optionsRadiosinline" id="optionsRadios4" value="option2" >
                    </a>
                </div>
                <div class="col-sm-6 col-md-3">
                    <a href="#" class="thumbnail" onclick="document.getElementById('able').className ='btn btn-primary btn-lg';document.getElementById('optionsRadios5').checked=true">
                        <img src="/wp-content/uploads/2014/06/kittens.jpg"
                             alt="通用的占位符缩略图">
                        <input type="radio" name="optionsRadiosinline" id="optionsRadios5" value="option3" >
                    </a>
                </div>
                <div class="col-sm-6 col-md-3">
                    <a href="#" class="thumbnail" onclick="document.getElementById('able').className ='btn btn-primary btn-lg';document.getElementById('optionsRadios6').checked=true">
                        <img src="/wp-content/uploads/2014/06/kittens.jpg"
                             alt="通用的占位符缩略图">
                        <input type="radio" name="optionsRadiosinline" id="optionsRadios6" value="option4"  >
                    </a>
                </div>
            </div>
            <div  id= "upfile" style="display: none;padding-top: 50px">

                <h3>请上传文件</h3>
                <hr class="layui-bg-orange">

                <label for="file1"><img src="img/file.png" style="cursor: pointer"></label>
                   <input type="file" name="file1" id="file1"  style="display:none ">
            </div>



    </div>


</div>


<!--<div style="margin-top: 350px;float:right;margin-right: 50px">
        <a href="#" class="btn btn-primary btn-lg" role="button">上一步</a>
  <a id="able" href="#" class="btn btn-primary btn-lg disabled" role="button" style="margin-left: 50px;">下一步</a>
<br>

    </div>-->
<nav id="sub" class="navbar navbar-default navbar-fixed-bottom" role="navigation" style="height: 80px;display: none;margin-bottom: 0px">
    <div style="margin-top: 0px;margin-bottom: 10px;float:right;margin-right: 50px;">



        <div class="navbar-form navbar-left " role="search">
            <!--<button type="submit" class="btn btn-primary btn-lg">上一步</button>-->
            <div class="form-group" style="margin-left: 50px;margin-right: 20px">
                <input type="text" class="form-control" placeholder="数据名称" style="height: 40px">
            </div>
            <button type="submit" class="btn btn-primary btn-lg" >保存</button>
            <button type="submit" class="btn btn-primary btn-lg disabled">预览</button>
        </div>

        <br>

    </div>

</nav>
</form>
<nav id="last" class="navbar navbar-default navbar-fixed-bottom" role="navigation" style="height: 80px;margin-bottom: 0px">
    <div style="margin-top: 0px;margin-bottom: 10px;float:right;margin-right: 50px;">



        <form class="navbar-form navbar-left " role="search">
            <a href="#" class="btn btn-primary btn-lg" role="button">上一步</a>
            <a id="able" href="javascript:void(0);" onclick="document.getElementById('upfile').style.display='';document.getElementById('sub').style.display='';document.getElementById('last').style.display='none'" class="btn btn-primary btn-lg disabled" role="button" style="margin-left: 50px;">下一步</a>
        </form>

        <br>

    </div>

</nav>














</body>
</html>
