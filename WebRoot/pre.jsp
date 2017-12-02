<%--
  Created by IntelliJ IDEA.
  User: 爷爷好
  Date: 2017/12/2
  Time: 0:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <title>数据预测分析</title>
    <link rel="stylesheet" href="./plugins/layui/css/layui.css" media="all">
    <link rel="stylesheet" href="./plugins/font-awesome/css/font-awesome.min.css" media="all">
    <link rel="stylesheet" href="./build/css/app.css" media="all">
    <link rel="stylesheet" href="./build/css/themes/blue.css" media="all">
</head>
<body>
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
                <li class="layui-nav-item">
                    <a class="" href="index.3.html"><i class="fa fa-plug" aria-hidden="true"></i><span> 数据分析</span></a>

                </li>
                <li class="layui-nav-item layui-this">
                    <a href="pre.html"><i></i><span>数据预测</span></a>


                </li>
            </ul>
        </div>
    </div>
    <div class="layui-body" id="container">
        <!-- 内容主体区域 -->
        <div style="padding: 15px;">
            <table class="layui-table" lay-data="{height:315,url:'', page:true, id:'test'}" lay-filter="test">
                <thead>
                <tr>
                    <th lay-data="{checkbox:true}"></th>
                    <th lay-data="{field:'id', width:80, sort: true}">订单号</th>
                    <th lay-data="{field:'date', width:80, sort: true}">日期</th>
                    <th lay-data="{field:'area', width:80}">区域</th>
                    <th lay-data="{field:'province', width:80, sort: true}">省份</th>
                    <th lay-data="{field:'city',width:80}">城市</th>
                    <th lay-data="{field:'class',width:80}">产品类别</th>
                    <th lay-data="{field:'child-class', width:80,sort: true}">产品子类别</th>
                    <th lay-data="{field:'num',width:80, sort: true}">订单数量</th>
                    <th lay-data="{field:'total',width:80}">销售额</th>
                    <th lay-data="{field:'sale',width:80, sort: true}">折扣点</th>
                    <th lay-data="{field:'tras',width:80, sort: true}">运输方式</th>
                    <th lay-data="{field:'profit',width:80, sort: true}">利润</th>
                    <th lay-data="{field:'u_price',width:80, sort: true}">单价</th>
                    <th lay-data="{field:'t_cost',width:100, sort: true}">运输成本</th>
                </tr>
                </thead>
                <tr>
                    <td></td>
                    <td>1</td>
                    <td>2010-10-3</td>
                    <td>华北</td>
                    <td>河北</td>
                    <td>石家庄</td>
                    <td>办公用品</td>
                    <td>容器，箱子</td>
                    <td>6</td>
                    <td>261.540</td>
                    <td>0.040</td>
                    <td>火车</td>
                    <td>-213.250</td>
                    <td>38.040</td>
                    <td>35</td>

                </tr>
                <tr>
                    <td></td>
                    <td>1</td>
                    <td>2010-10-3</td>
                    <td>华北</td>
                    <td>河北</td>
                    <td>石家庄</td>
                    <td>办公用品</td>
                    <td>容器，箱子</td>
                    <td>6</td>
                    <td>261.540</td>
                    <td>0.040</td>
                    <td>火车</td>
                    <td>-213.250</td>
                    <td>38.040</td>
                    <td>35</td>

                </tr>

            </table>
            <div>
                <div class="bt">
                    <button data-method="selectMoudle" class="layui-btn" onclick="">选择模型</button>

                </div>


            </div>


        </div>
    </div>

    <!-- <div class="layui-footer">


     </div>-->
</div>

<script src="./plugins/layui/layui.js"></script>
<script src="./build/js/app.js"></script>
<script>


    layui.use('element', function(){
        var element = layui.element;

        //一些事件监听


        //…
    });
    layui.use('table', function() {
        var table = layui.table;
    });
    layui.use('layer', function(){
        var layer = layui.layer;
        var $ = layui.jquery;
        var active={
            selectMoudle:function(){
                layer.tab({
                    area: ['600px', '300px'],
                    tab: [{
                        title: 'TAB1',
                        content: '内容1'
                    }, {
                        title: 'TAB2',
                        content: '内容2'
                    }, {
                        title: 'TAB3',
                        content: '内容3'
                    }]
                });

            }


        };
        $('.bt .layui-btn').on('click', function () {
            var othis = $(this), method = othis.data('method');
            active[method] ? active[method].call(this, othis) : '';


        });

    });
</script>
</body>
</html>
