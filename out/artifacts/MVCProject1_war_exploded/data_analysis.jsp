<%--
  Created by IntelliJ IDEA.
  User: 37442
  Date: 2017/11/29
  Time: 20:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <title>数据预测分析</title>
    <link rel="stylesheet" href="./plugins/layui/css/layui.css" media="all">
    <link rel="stylesheet" href="./plugins/font-awesome/css/font-awesome.min.css" media="all">
    <link rel="stylesheet" href="./build/css/app.css" media="all">
    <link rel="stylesheet" href="./build/css/themes/blue.css" media="all">

    <style>
        .drop-target {
            box-sizing: border-box;
            width: 200px;
            height: 10px;
            border:1px dashed;
            margin-left:90px;
            padding: 20px;
        }
    </style>
</head>

<body class="kit-theme">
<div class="layui-layout layui-layout-admin kit-layout-admin">
    <div class="layui-header">
        <div class="layui-logo">人工智能</div>
        <div class="layui-logo kit-logo-mobile">K</div>
        <ul class="layui-nav layui-layout-left kit-nav" kit-one-level>
            <li class="layui-nav-item"><a href="javascript:;"></a></li>
            <li class="layui-nav-item"><a href="javascript:;"></a></li>
        </ul>
        <ul class="layui-nav layui-layout-right kit-nav">
            <li class="layui-nav-item"><a href="javascript:;" id="pay"><i class="fa fa-gratipay" aria-hidden="true"></i> </a></li>
            <li class="layui-nav-item">
                <a href="javascript:;">
                    <img src="http://m.zhengjinfan.cn/images/0.jpg" class="layui-nav-img"> wlp
                </a>
                <dl class="layui-nav-child">
                    <dd><a href="javascript:;">个人信息</a></dd>
                    <dd><a href="javascript:;">我的应用</a></dd>
                </dl>
            </li>
            <li class="layui-nav-item"><a href="javascript:;"><i class="fa fa-sign-out" aria-hidden="true"></i> 注销</a></li>
        </ul>
    </div>

    <div class="layui-side layui-bg-black kit-side">
        <div class="layui-side-scroll">
            <div class="kit-side-fold"><i class="fa fa-navicon" aria-hidden="true"></i></div>
            <!-- 左侧导航区域（可配合layui已有的垂直导航） -->
            <ul class="layui-nav layui-nav-tree" lay-filter="kitNavbar" kit-navbar>
                <li class="layui-nav-item layui-this">
                    <a class="" href="index.3.html"><i class="fa fa-plug" aria-hidden="true"></i><span> 数据分析</span></a>

                </li>
                <li class="layui-nav-item">
                    <a href="pre.html"><i></i><span>数据预测</span></a>


                </li>
            </ul>
        </div>
    </div>
    <div class="layui-body" id="container">
        <!-- 内容主体区域 -->
        <div style="padding: 15px;">
            <div class="layui-row">
                <div class="layui-col-md4">
                    <div class="layui-tab layui-tab-card " style="width:279px; margin-left:10px;">
                        <ul class="layui-tab-title">
                            <li class="layui-this">我的数据</li>
                            <li>公共数据</li>
                            <li>示例数据</li>
                        </ul>
                        <div class="layui-tab-content" style="height:500px;">
                            <div class="layui-tab-item layui-show">

                                <div class="kit-side">
                                    <div class="layui-side-scroll">

                                        <!-- 左侧导航区域（可配合layui已有的垂直导航） -->
                                        <ul class="layui-nav layui-nav-tree" lay-filter="kitNavbar" kit-navbar>
                                            <li class="layui-nav-item">
                                                <a class="" href="javascript:;">
                                                    <i class="fa fa-plug" aria-hidden="true"></i>
                                                    <span> 某公司的销售数据</span>
                                                </a>
                                                <dl class="layui-nav-child" id="drag-elements">

                                                    <dd>


                                                        <span style="color:black;">维度 </span>

                                                    </dd>

                                                    <dd >
                                                        <a href="">
                                                            <i class="layui-icon"></i>
                                                            <span> 区域</span>
                                                        </a>
                                                    </dd>
                                                    <dd>
                                                        <a href="javascript:;">
                                                            <i class="layui-icon"></i>
                                                            <span> 日期</span>
                                                        </a>
                                                    </dd>
                                                    <dd>
                                                        <a href="javascript:;">
                                                            <i class="layui-icon"></i>
                                                            <span> 省市</span>
                                                        </a>
                                                    </dd>
                                                    <dd>

                                                        <span style="color:black;">度量 </span>

                                                    </dd>

                                                    <dd >
                                                        <a href="">
                                                            <i class="layui-icon"></i>
                                                            <span> 销售额</span>
                                                        </a>
                                                    </dd>
                                                    <dd>
                                                        <a href="javascript:;">
                                                            <i class="layui-icon"></i>
                                                            <span> 利润</span>
                                                        </a>
                                                    </dd>
                                                    <dd>
                                                        <a href="javascript:;">
                                                            <i class="layui-icon"></i>
                                                            <span> 单价</span>
                                                        </a>
                                                    </dd>

                                                </dl>
                                            </li>
                                        </ul>
                                    </div>
                                </div>
                            </div>
                            <div class="layui-tab-item">2</div>
                            <div class="layui-tab-item">3</div>
                        </div>
                    </div>
                </div>

                <div class="layui-col-md8" style="margin-left:-30px;">
                    <div class="layui-tab layui-tab-card">
                        <ul class="layui-tab-title">
                            <li class="layui-this">拖拽</li>

                        </ul>
                        <div class="layui-tab-content" style="height:500px;">
                            <div class="layui-tab-item layui-show">
                                <form class="layui-form" action="">
                                    <div>
                                        <div class="layui-form-item" style="float:left;">
                                            <label class="layui-form-label">行：</label>
                                            <div class="drop-target">

                                            </div>

                                        </div>
                                        <div style="float:left;">
                                            <label class="layui-form-label">列：</label>
                                            <div class="drop-target">

                                            </div>

                                        </div>
                                    </div>
                                    <hr>



                                </form>
                                <!--这里放图表-->


                            </div>

                        </div>




                    </div>
                    <div class="">
                        <button class="layui-btn">增加</button>

                    </div>

                </div>

            </div>


        </div>
    </div>

    <!-- <div class="layui-footer">


     </div>-->
</div>
<script type="text/javascript">
    var cnzz_protocol = (("https:" == document.location.protocol) ? " https://" : " http://");
    document.write(unescape("%3Cspan id='cnzz_stat_icon_1264021086'%3E%3C/span%3E%3Cscript src='" + cnzz_protocol + "s22.cnzz.com/z_stat.php%3Fid%3D1264021086%26show%3Dpic1' type='text/javascript'%3E%3C/script%3E"));
</script>
<script src="./plugins/layui/layui.js"></script>
<script src="./build/js/app.js"></script>
<script>


    layui.use('element', function(){
        var element = layui.element;

        //一些事件监听


        //…
    });

</script>

<script>
    //获取目标元素
    var target = document.querySelector('.drop-target');
    //获取需要拖放的元素
    var dragElements = document.querySelectorAll('#drag-elements dd a');
    //临时记录被拖放的元素
    var elementDragged = null;
    //循环监听被拖放元素的开始拖放和结束拖放事件
    for (var i = 0; i < dragElements.length; i++) {
        //开始拖放事件监听
        dragElements[i].addEventListener('dragstart', function(e) {
            //设置当前拖放元素的数据参数
            e.dataTransfer.setData('text', this.innerHTML);
            //保存当前拖放对象
            elementDragged = this;
        });
        //结束拖放事件监听
        dragElements[i].addEventListener('dragend', function(e) {
            //注销当前拖放对象
            elementDragged = null;
        });
    }
    //目标元素监听被拖放元素进入事件
    target.addEventListener('dragover', function(e) {
        //阻止浏览器默认行为
        e.preventDefault();
        //设置鼠标样式
        e.dataTransfer.dropEffect = 'move';
        return false;
    });
    //目标元素监听当被拖放元素落下时刻事件
    target.addEventListener('drop', function(e) {
        //阻止默认行为
        e.preventDefault();
        //阻止默认行为
        e.stopPropagation();
        //获取当前被拖放元素的存放数据参数
        this.innerHTML =e.dataTransfer.getData('text');
        //删除被拖放元素
        document.querySelector('#dragelements').
        removeChild(elementDragged);
        return false;
    });
</script>


</body>

</html>
