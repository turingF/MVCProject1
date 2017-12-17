<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="edu.nuaa.vo.ZongZheVo.Excel" %>
<%@ page import="javax.xml.bind.annotation.XmlElementDecl" %><%--
  Created by IntelliJ IDEA.
  User: 爷爷好
  Date: 2017/12/2
  Time: 0:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>


<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <title>数据预测分析</title>
    <!-- 新 Bootstrap4 核心 CSS 文件 -->
    <link rel="stylesheet" href="https://cdn.bootcss.com/bootstrap/4.0.0-beta/css/bootstrap.min.css">

    <!-- jQuery文件。务必在bootstrap.min.js 之前引入 -->
    <script src="https://cdn.bootcss.com/jquery/3.2.1/jquery.min.js"></script>

    <!-- popper.min.js 用于弹窗、提示、下拉菜单 -->
    <script src="https://cdn.bootcss.com/popper.js/1.12.5/umd/popper.min.js"></script>

    <!-- 最新的 Bootstrap4 核心 JavaScript 文件 -->
    <script src="https://cdn.bootcss.com/bootstrap/4.0.0-beta/js/bootstrap.min.js"></script>
    <link rel="stylesheet" href="./plugins/layui/css/layui.css" media="all">
    <link rel="stylesheet" href="./plugins/font-awesome/css/font-awesome.min.css" media="all">
    <link rel="stylesheet" href="./build/css/app.css" media="all">
    <link rel="stylesheet" href="./build/css/themes/blue.css" media="all">
    <link rel="stylesheet" href="css/bootstrap.min.css">
    <link href="css/bootstrap.css" rel="stylesheet" />
    <link rel="stylesheet" href="http://netdna.bootstrapcdn.com/font-awesome/4.0.3/css/font-awesome.css">
    <script src="js/bootstrap.js" type="text/javascript"></script>
    <script type="text/javascript" src="js/echarts.js"></script>
    <!-- 引入jquery.js -->
    <script type="text/javascript" src="js/jquery-1.12.4.js"></script>
    <style>
        .drop-target {
            box-sizing: content-box;
            width: 200px;
            height: 10px;
            border:1px dashed;
            margin-left:90px;
            padding: 20px;
        }
        .drop-target1 {
            box-sizing: content-box;
            width: 200px;
            height: 10px;
            border:1px dashed;
            margin-left:90px;
            padding: 20px;
        }
        .tuozhuai{
            float: left;

            margin-top: -10px;
            margin-left: 10px;

        }
    </style>
</head>
<body>

<%
    request.setCharacterEncoding("utf-8");
    Excel excel=(Excel) request.getAttribute("datainfo");//文章链表
    if(excel==null) excel=new Excel();
    String appname=(String)request.getAttribute("appname");
    String apptype=(String)request.getAttribute("apptype");
    request.setAttribute("datainfo",excel);
    request.setAttribute("srcpath","analy");
    List data=new ArrayList();

    data.add("123");
    data.add("456");
    data.add("789");
%>


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

                    <a class="" href="AnalyAndPreServlet?appname=<%=appname%>&apptype=<%=apptype%>&srcpath=analy"><i></i><span>数据预测</span></a>
              <!--  <li><a href="javascript:login_out()" onclick="openRegisterModal();"><span class="glyphicon glyphicon-log-in"></span> 注销</a><>
            </ul>-->

            <%--<!-- 跳转预测界面 -->--%>
            <%--<script type="text/javascript">--%>
                <%--function ToPre()--%>
                <%--{--%>
                    <%--<jsp:forward page="datapre2.jsp"/>--%>
                   <%--// window.location.href="index.jsp";--%>
                <%--}--%>
            <%--</script>--%>




            </li>
            </ul>
        </div>
    </div>

    <div class="layui-body" id="container">
        <!-- 内容主体区域 -->

        <div style="padding: 15px;">
            <div class="layui-row">
                <div class="layui-col-md4" style=" float: left">
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
                                                    <span> <%=excel.getDbname()%></span>
                                                </a>
                                                <dl class="layui-nav-child" id="drag-elements">
                                                    <dd>
                                                        <span style="color:black;">维度 </span>
                                                    </dd>
                                                    <% for ( int i=0;i<excel.getHeaders().size();i++)
                                                    {
                                                        System.out.print(excel.getHeaders().get(i));
                                                    %>
                                                    <dd >
                                                        <a href="">
                                                            <i class="layui-icon"></i>


                                                            <div class="draglist" title="拖拽我" draggable="true"><%=excel.getHeaders().get(i)%></div>


                                                        </a>
                                                    </dd><%}%>
                                                    <dd>
                                                        <a href="javascript:;">
                                                            <i class="layui-icon"></i>
                                                            <div class="draglist" title="拖拽我" draggable="true">区域</div>
                                                        </a>
                                                    </dd>
                                                    <dd>
                                                        <a href="javascript:;">
                                                            <i class="layui-icon"></i>
                                                            <div class="draglist" title="拖拽我" draggable="true">区域</div>
                                                        </a>
                                                    </dd>
                                                    <dd>

                                                        <span style="color:black;">度量 </span>

                                                    </dd>

                                                    <dd >
                                                        <a href="">
                                                            <i class="layui-icon"></i>
                                                            <div class="draglist" title="拖拽我" draggable="true">区域</div>
                                                        </a>
                                                    </dd>
                                                    <dd>
                                                        <a href="javascript:;">
                                                            <i class="layui-icon"></i>
                                                            <div class="draglist" title="拖拽我" draggable="true">区域</div>
                                                        </a>
                                                    </dd>
                                                    <dd>
                                                        <a href="javascript:;">
                                                            <i class="layui-icon"></i>
                                                            <div class="draglist" title="拖拽我" draggable="true">区域</div>
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

                <div class="layui-col-md8" style="float: left">
                    <div class="layui-tab layui-tab-card">
                        <ul class="layui-tab-title">
                            <li class="layui-this">图表</li>

                        </ul>
                        <div class="layui-tab-content" style="height:auto">
                            <div class="layui-tab-item layui-show">
                                <form class="" action="">
                                    <div>
                                        <div class="dustbin" style="float:left;">
                                            <label class="layui-form-label">行：</label>
                                            <div class="drop-target" id="drop-target" >

                                            </div>

                                        </div>
                                        <div class="dustbin1"  style="float:left;" >
                                            <label class="layui-form-label">列：</label>
                                            <div class="drop-target1" id="drop-target1">

                                            </div>

                                        </div>



                                    </div>
                                    <div style="float: right;margin-top: 10px;margin-bottom: 10px">
                                        <button type="button" class="btn btn-success" onclick="create1();">曲线图</button>
                                        <button type="button" class="btn btn-success" onclick="create2();">柱状图</button>

                                        <button type="button" class="btn btn-warning" onclick="create3();">面积图</button>
                                        <button type="button" class="btn btn-danger" >图四</button>
                                        <button type="button" class="btn btn-dark">图五</button>
                                        <button type="button" class="btn btn-light">图六</button>
                                    </div>

                                    <hr>



                                </form>
                                <!--这里放图表-->

                                <div id="main" style="width: auto;height: 500px" ></div>

                                <script type="text/javascript">
function create1() {


    var myChart = echarts.init(document.getElementById('main'));
    // 显示标题，图例和空的坐标轴
    myChart.setOption({
        title: {
            text: '软件失效数据'
        },
        tooltip: {},
        legend: {
            data: ['失效时间']
        },
        xAxis: {
            data: []
        },
        yAxis: {},
        series: [{
            name: '失效时间',
            type: 'line',
            data: []
        }]
    });

    myChart.showLoading();    //数据加载完之前先显示一段简单的loading动画

    var names = [];    //类别数组（实际用来盛放X轴坐标值）
    var nums = [];    //销量数组（实际用来盛放Y坐标值）

    $.ajax({
        type: "post",
        async: true,            //异步请求（同步请求将会锁住浏览器，用户其他操作必须等待请求完成才可以执行）
        url: "TestServlet",    //请求发送到TestServlet处
        data: {},
        dataType: "json",        //返回数据形式为json
        success: function (result) {
            //请求成功时执行该函数内容，result即为服务器返回的json对象
            if (result) {
                for (var i = 0; i < result.length; i++) {
                    names.push(result[i].name);    //挨个取出类别并填入类别数组
                }
                for (var i = 0; i < result.length; i++) {
                    nums.push(result[i].num);    //挨个取出销量并填入销量数组
                }
                myChart.hideLoading();    //隐藏加载动画
                myChart.setOption({        //加载数据图表
                    xAxis: {
                        data: names
                    },
                    series: [{
                        // 根据名字对应到相应的系列
                        name: '失效时间',
                        data: nums
                    }]
                });

            }

        },
        error: function (errorMsg) {
            //请求失败时执行该函数
            alert("图表请求数据失败!");
            myChart.hideLoading();
        }
    })
}



function create2() {


    var myChart = echarts.init(document.getElementById('main'));
    // 显示标题，图例和空的坐标轴
    myChart.setOption({
        title: {
            text: '软件失效数据'
        },
        tooltip: {},
        legend: {
            data: ['失效时间']
        },
        xAxis: {
            data: []
        },
        yAxis: {},
        series: [{
            name: '失效时间',
            type: 'bar',
            data: []
        }]
    });

    myChart.showLoading();    //数据加载完之前先显示一段简单的loading动画

    var names = [];    //类别数组（实际用来盛放X轴坐标值）
    var nums = [];    //销量数组（实际用来盛放Y坐标值）

    $.ajax({
        type: "post",
        async: true,            //异步请求（同步请求将会锁住浏览器，用户其他操作必须等待请求完成才可以执行）
        url: "TestServlet",    //请求发送到TestServlet处
        data: {},
        dataType: "json",        //返回数据形式为json
        success: function (result) {
            //请求成功时执行该函数内容，result即为服务器返回的json对象
            if (result) {
                for (var i = 0; i < result.length; i++) {
                    names.push(result[i].name);    //挨个取出类别并填入类别数组
                }
                for (var i = 0; i < result.length; i++) {
                    nums.push(result[i].num);    //挨个取出销量并填入销量数组
                }
                myChart.hideLoading();    //隐藏加载动画
                myChart.setOption({        //加载数据图表
                    xAxis: {
                        data: names
                    },
                    series: [{
                        // 根据名字对应到相应的系列
                        name: '失效时间',
                        data: nums
                    }]
                });

            }

        },
        error: function (errorMsg) {
            //请求失败时执行该函数
            alert("图表请求数据失败!");
            myChart.hideLoading();
        }
    })
}






function create3() {


    var myChart = echarts.init(document.getElementById('main'));
    // 显示标题，图例和空的坐标轴
    myChart.setOption({
        tooltip: {
            trigger: 'axis',
            position: function (pt) {
                return [pt[0], '10%'];
            }
        },
        title: {
            left: 'center',
            text: '大数据量面积图',
        },
        toolbox: {
            feature: {
                dataZoom: {
                    yAxisIndex: 'none'
                },
                restore: {},
                saveAsImage: {}
            }
        },
        xAxis: {
            type: 'category',
            boundaryGap: false,
            data: [],


        },
        yAxis: {
            type: 'value',
            boundaryGap: [0, '100%']
        },
        dataZoom: [{
            type: 'inside',
            start: 0,
            end: 10
        }, {
            start: 0,
            end: 10,
            handleIcon: 'M10.7,11.9v-1.3H9.3v1.3c-4.9,0.3-8.8,4.4-8.8,9.4c0,5,3.9,9.1,8.8,9.4v1.3h1.3v-1.3c4.9-0.3,8.8-4.4,8.8-9.4C19.5,16.3,15.6,12.2,10.7,11.9z M13.3,24.4H6.7V23h6.6V24.4z M13.3,19.6H6.7v-1.4h6.6V19.6z',
            handleSize: '80%',
            handleStyle: {
                color: '#fff',
                shadowBlur: 3,
                shadowColor: 'rgba(0, 0, 0, 0.6)',
                shadowOffsetX: 2,
                shadowOffsetY: 2
            }
        },
            {
                type: 'inside',
                start: 0,
                end: 10,
                yAxisIndex: 0,
            }, {
                yAxisIndex: 0,
                start: 0,
                end: 10,
                handleIcon: 'M10.7,11.9v-1.3H9.3v1.3c-4.9,0.3-8.8,4.4-8.8,9.4c0,5,3.9,9.1,8.8,9.4v1.3h1.3v-1.3c4.9-0.3,8.8-4.4,8.8-9.4C19.5,16.3,15.6,12.2,10.7,11.9z M13.3,24.4H6.7V23h6.6V24.4z M13.3,19.6H6.7v-1.4h6.6V19.6z',
                handleSize: '80%',
                handleStyle: {
                    color: '#fff',
                    shadowBlur: 3,
                    shadowColor: 'rgba(0, 0, 0, 0.6)',
                    shadowOffsetX: 2,
                    shadowOffsetY: 2
                }
            }],
        series: [
            {
                name:'模拟数据',
                type:'line',
                smooth:true,
                symbol: 'none',
                sampling: 'average',
                itemStyle: {
                    normal: {
                        color: 'rgb(255, 70, 131)'
                    }
                },
                areaStyle: {
                    normal: {
                        color: new echarts.graphic.LinearGradient(0, 0, 0, 1, [{
                            offset: 0,
                            color: 'rgb(255, 158, 68)'
                        }, {
                            offset: 1,
                            color: 'rgb(255, 70, 131)'
                        }])
                    }
                },
                data: []
            }
        ]
    });

    myChart.showLoading();    //数据加载完之前先显示一段简单的loading动画

    var names = [];    //类别数组（实际用来盛放X轴坐标值）
    var nums = [];    //销量数组（实际用来盛放Y坐标值）

    $.ajax({
        type: "post",
        async: true,            //异步请求（同步请求将会锁住浏览器，用户其他操作必须等待请求完成才可以执行）
        url: "TestServlet",    //请求发送到TestServlet处
        data: {},
        dataType: "json",        //返回数据形式为json
        success: function (result) {
            //请求成功时执行该函数内容，result即为服务器返回的json对象
            if (result) {
                for (var i = 0; i < result.length; i++) {
                    names.push(result[i].name);    //挨个取出类别并填入x数组
                }
                for (var i = 0; i < result.length; i++) {
                    nums.push(result[i].num);    //挨个取出销量并填入y数组
                }
                myChart.hideLoading();    //隐藏加载动画
                myChart.setOption({        //加载数据图表
                    xAxis: {
                        data: names
                    },
                    series: [{
                        // 根据名字对应到相应的系列
                        name: '失效时间',
                        data: nums
                    }]
                });

            }

        },
        error: function (errorMsg) {
            //请求失败时执行该函数
            alert("图表请求数据失败!");
            myChart.hideLoading();
        }
    })
}



function create4() {


    var myChart = echarts.init(document.getElementById('main'));
    // 显示标题，图例和空的坐标轴
    myChart.setOption({
        title : {
            text: '分布图',
            //subtext: '抽样调查来自: Heinz  2003'
        },
        grid: {
            left: '3%',
            right: '7%',
            bottom: '3%',
            containLabel: true
        },
        tooltip : {
            // trigger: 'axis',
            showDelay : 0,
            formatter : function (params) {
                if (params.value.length > 1) {
                    return params.seriesName + ' :<br/>'
                        + params.value[0] + 'cm '
                        + params.value[1] + 'kg ';
                }
                else {
                    return params.seriesName + ' :<br/>'
                        + params.name + ' : '
                        + params.value + 'kg ';
                }
            },
            axisPointer:{
                show: true,
                type : 'cross',
                lineStyle: {
                    type : 'dashed',
                    width : 1
                }
            }
        },
        toolbox: {
            feature: {
                dataZoom: {},
                brush: {
                    type: ['rect', 'polygon', 'clear']
                }
            }
        },
        brush: {
        },
        legend: {
            data: ['女性','男性'],
            left: 'center'
        },
        xAxis : [
            {
                type : 'value',
                scale:true,
                axisLabel : {
                    formatter: '{value} cm'
                },
                splitLine: {
                    show: false
                }
            }
        ],
        yAxis : [
            {
                type : 'value',
                scale:true,
                axisLabel : {
                    formatter: '{value} kg'
                },
                splitLine: {
                    show: false
                }
            }
        ],
        series : [
            {
                name:'女性',
                type:'scatter',
                data: [[161.2, 51.6], [167.5, 59.0], [159.5, 49.2], [157.0, 63.0], [155.8, 53.6],
                    [170.0, 59.0], [159.1, 47.6], [166.0, 69.8], [176.2, 66.8], [160.2, 75.2],
                    [172.5, 55.2], [170.9, 54.2], [172.9, 62.5], [153.4, 42.0], [160.0, 50.0],
                    [147.2, 49.8], [168.2, 49.2], [175.0, 73.2], [157.0, 47.8], [167.6, 68.8],
                    [159.5, 50.6], [175.0, 82.5], [166.8, 57.2], [176.5, 87.8], [170.2, 72.8],
                    [174.0, 54.5], [173.0, 59.8], [179.9, 67.3], [170.5, 67.8], [160.0, 47.0],
                    [154.4, 46.2], [162.0, 55.0], [176.5, 83.0], [160.0, 54.4], [152.0, 45.8],
                    [162.1, 53.6], [170.0, 73.2], [160.2, 52.1], [161.3, 67.9], [166.4, 56.6],
                    [168.9, 62.3], [163.8, 58.5], [167.6, 54.5], [160.0, 50.2], [161.3, 60.3],
                    [167.6, 58.3], [165.1, 56.2], [160.0, 50.2], [170.0, 72.9], [157.5, 59.8],
                    [167.6, 61.0], [160.7, 69.1], [163.2, 55.9], [152.4, 46.5], [157.5, 54.3],
                    [168.3, 54.8], [180.3, 60.7], [165.5, 60.0], [165.0, 62.0], [164.5, 60.3],
                    [156.0, 52.7], [160.0, 74.3], [163.0, 62.0], [165.7, 73.1], [161.0, 80.0],
                    [162.0, 54.7], [166.0, 53.2], [174.0, 75.7], [172.7, 61.1], [167.6, 55.7],
                    [151.1, 48.7], [164.5, 52.3], [163.5, 50.0], [152.0, 59.3], [169.0, 62.5],
                    [164.0, 55.7], [161.2, 54.8], [155.0, 45.9], [170.0, 70.6], [176.2, 67.2],
                    [170.0, 69.4], [162.5, 58.2], [170.3, 64.8], [164.1, 71.6], [169.5, 52.8],
                    [163.2, 59.8], [154.5, 49.0], [159.8, 50.0], [173.2, 69.2], [170.0, 55.9],
                    [161.4, 63.4], [169.0, 58.2], [166.2, 58.6], [159.4, 45.7], [162.5, 52.2],
                    [159.0, 48.6], [162.8, 57.8], [159.0, 55.6], [179.8, 66.8], [162.9, 59.4],
                    [161.0, 53.6], [151.1, 73.2], [168.2, 53.4], [168.9, 69.0], [173.2, 58.4],
                    [171.8, 56.2], [178.0, 70.6], [164.3, 59.8], [163.0, 72.0], [168.5, 65.2],
                    [166.8, 56.6], [172.7, 105.2], [163.5, 51.8], [169.4, 63.4], [167.8, 59.0],
                    [159.5, 47.6], [167.6, 63.0], [161.2, 55.2], [160.0, 45.0], [163.2, 54.0],
                    [162.2, 50.2], [161.3, 60.2], [149.5, 44.8], [157.5, 58.8], [163.2, 56.4],
                    [172.7, 62.0], [155.0, 49.2], [156.5, 67.2], [164.0, 53.8], [160.9, 54.4],
                    [162.8, 58.0], [167.0, 59.8], [160.0, 54.8], [160.0, 43.2], [168.9, 60.5],
                    [158.2, 46.4], [156.0, 64.4], [160.0, 48.8], [167.1, 62.2], [158.0, 55.5],
                    [167.6, 57.8], [156.0, 54.6], [162.1, 59.2], [173.4, 52.7], [159.8, 53.2],
                    [170.5, 64.5], [159.2, 51.8], [157.5, 56.0], [161.3, 63.6], [162.6, 63.2],
                    [160.0, 59.5], [168.9, 56.8], [165.1, 64.1], [162.6, 50.0], [165.1, 72.3],
                    [166.4, 55.0], [160.0, 55.9], [152.4, 60.4], [170.2, 69.1], [162.6, 84.5],
                    [170.2, 55.9], [158.8, 55.5], [172.7, 69.5], [167.6, 76.4], [162.6, 61.4],
                    [167.6, 65.9], [156.2, 58.6], [175.2, 66.8], [172.1, 56.6], [162.6, 58.6],
                    [160.0, 55.9], [165.1, 59.1], [182.9, 81.8], [166.4, 70.7], [165.1, 56.8],
                    [177.8, 60.0], [165.1, 58.2], [175.3, 72.7], [154.9, 54.1], [158.8, 49.1],
                    [172.7, 75.9], [168.9, 55.0], [161.3, 57.3], [167.6, 55.0], [165.1, 65.5],
                    [175.3, 65.5], [157.5, 48.6], [163.8, 58.6], [167.6, 63.6], [165.1, 55.2],
                    [165.1, 62.7], [168.9, 56.6], [162.6, 53.9], [164.5, 63.2], [176.5, 73.6],
                    [168.9, 62.0], [175.3, 63.6], [159.4, 53.2], [160.0, 53.4], [170.2, 55.0],
                    [162.6, 70.5], [167.6, 54.5], [162.6, 54.5], [160.7, 55.9], [160.0, 59.0],
                    [157.5, 63.6], [162.6, 54.5], [152.4, 47.3], [170.2, 67.7], [165.1, 80.9],
                    [172.7, 70.5], [165.1, 60.9], [170.2, 63.6], [170.2, 54.5], [170.2, 59.1],
                    [161.3, 70.5], [167.6, 52.7], [167.6, 62.7], [165.1, 86.3], [162.6, 66.4],
                    [152.4, 67.3], [168.9, 63.0], [170.2, 73.6], [175.2, 62.3], [175.2, 57.7],
                    [160.0, 55.4], [165.1, 104.1], [174.0, 55.5], [170.2, 77.3], [160.0, 80.5],
                    [167.6, 64.5], [167.6, 72.3], [167.6, 61.4], [154.9, 58.2], [162.6, 81.8],
                    [175.3, 63.6], [171.4, 53.4], [157.5, 54.5], [165.1, 53.6], [160.0, 60.0],
                    [174.0, 73.6], [162.6, 61.4], [174.0, 55.5], [162.6, 63.6], [161.3, 60.9],
                    [156.2, 60.0], [149.9, 46.8], [169.5, 57.3], [160.0, 64.1], [175.3, 63.6],
                    [169.5, 67.3], [160.0, 75.5], [172.7, 68.2], [162.6, 61.4], [157.5, 76.8],
                    [176.5, 71.8], [164.4, 55.5], [160.7, 48.6], [174.0, 66.4], [163.8, 67.3]
                ],
                markArea: {
                    silent: true,
                    itemStyle: {
                        normal: {
                            color: 'transparent',
                            borderWidth: 1,
                            borderType: 'dashed'
                        }
                    },
                    data: [[{
                        name: '女性分布区间',
                        xAxis: 'min',
                        yAxis: 'min'
                    }, {
                        xAxis: 'max',
                        yAxis: 'max'
                    }]]
                },
                markPoint : {
                    data : [
                        {type : 'max', name: '最大值'},
                        {type : 'min', name: '最小值'}
                    ]
                },
                markLine : {
                    lineStyle: {
                        normal: {
                            type: 'solid'
                        }
                    },
                    data : [
                        {type : 'average', name: '平均值'},
                        { xAxis: 160 }
                    ]
                }
            },

        ]
    });

//    myChart.showLoading();    //数据加载完之前先显示一段简单的loading动画
//
//    var names = [];    //类别数组（实际用来盛放X轴坐标值）
//    var nums = [];    //销量数组（实际用来盛放Y坐标值）
//
//    $.ajax({
//        type: "post",
//        async: true,            //异步请求（同步请求将会锁住浏览器，用户其他操作必须等待请求完成才可以执行）
//        url: "TestServlet",    //请求发送到TestServlet处
//        data: {},
//        dataType: "json",        //返回数据形式为json
//        success: function (result) {
//            //请求成功时执行该函数内容，result即为服务器返回的json对象
//            if (result) {
//                for (var i = 0; i < result.length; i++) {
//                    names.push(result[i].name);    //挨个取出类别并填入x数组
//                }
//                for (var i = 0; i < result.length; i++) {
//                    nums.push(result[i].num);    //挨个取出销量并填入y数组
//                }
//                myChart.hideLoading();    //隐藏加载动画
//                myChart.setOption({        //加载数据图表
//                    xAxis: {
//                        data: names
//                    },
//                    series: [{
//                        // 根据名字对应到相应的系列
//                        name: '失效时间',
//                        data: nums
//                    }]
//                });
//
//            }
//
//        },
//        error: function (errorMsg) {
//            //请求失败时执行该函数
//            alert("图表请求数据失败!");
//            myChart.hideLoading();
//        }
//    })
}

                                </script>




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
    var ele = function(selector) {
        if (!selector) { return []; }
        var arrEle = [];
        if (document.querySelectorAll) {
            arrEle = document.querySelectorAll(selector);
        } else {
            var oAll = document.getElementsByTagName("div"), lAll = oAll.length;
            if (lAll) {
                var i = 0;
                for (i; i<lAll; i+=1) {
                    if (/^\./.test(selector)) {
                        if (oAll[i].className === selector.replace(".", "")) {
                            arrEle.push(oAll[i]);
                        }
                    } else if(/^#/.test(selector)) {
                        if (oAll[i].id === selector.replace("#", "")) {
                            arrEle.push(oAll[i]);
                        }
                    }
                }
            }
        }
        return arrEle;
    };

    var eleDustbin = ele(".drop-target")[0], eleDrags = ele(".draglist"), lDrags = eleDrags.length, eleRemind = ele(".dragremind")[0], eleDrag = null,eleDustbin1 = ele(".drop-target1")[0];
    for (var i=0; i<lDrags; i+=1) {
        eleDrags[i].onselectstart = function() {
            return false;
        };
        eleDrags[i].ondragstart = function(ev) {
            ev.dataTransfer.effectAllowed = "move";
            ev.dataTransfer.setData("text", ev.target.innerHTML);
            ev.dataTransfer.setDragImage(ev.target, 0, 0);
            eleDrag = ev.target;
            return true;
        };
        eleDrags[i].ondragend = function(ev) {
            ev.dataTransfer.clearData("text");
            eleDrag = null;
            return false
        };
    }
    eleDustbin.ondragover = function(ev) {
        ev.preventDefault();
        return true;
    };

    eleDustbin.ondragenter = function(ev) {
        this.style.color = "#37a000";
        return true;
    };
    eleDustbin.ondrop = function(ev) {
        if (eleDrag) {

            var o=document.getElementById("drop-target");
            var p1=document.createElement("div");
            p1.innerHTML='<strong>"' + eleDrag.innerHTML + '"</strong>';
            o.appendChild(p1);
            //eleRemind.innerHTML = '<strong>"' + eleDrag.innerHTML + '"</strong>被扔进了垃圾箱';

            //eleDrag.parentNode.removeChild(eleDrag);
        }
        this.style.color = "#000000";
        return false;
    };
    eleDustbin1.ondragover = function(ev) {
        ev.preventDefault();
        return true;
    };

    eleDustbin1.ondragenter = function(ev) {
        this.style.color = "#37a000";
        return true;
    };
    eleDustbin1.ondrop = function(ev) {
        if (eleDrag) {

            var o=document.getElementById("drop-target1");
            var p1=document.createElement("a");
            p1.className="btn btn-info tuozhuai";
            p1.setAttribute("onclick","back(this)");
          //var p2=document.createElement("button");
           //p2.className="btn-default";
           //p2.innerHTML=eleDrag.innerHTML;
           //o.appendChild(p2)
            p1.innerHTML='' + eleDrag.innerHTML + '';
            o.appendChild(p1);
            //eleRemind.innerHTML = '<strong>"' + eleDrag.innerHTML + '"</strong>被扔进了垃圾箱';

            //eleDrag.parentNode.removeChild(eleDrag);
        }
        this.style.color = "#000000";
        return false;
    };
    function back(obj) {

        obj.parentNode.removeChild(obj);
    }




</script>

</body>
</html>
