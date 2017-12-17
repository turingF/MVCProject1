

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.*,java.io.*" %>
<%@ page import="edu.nuaa.vo.ZongZheVo.Excel" %>

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
    <link rel="stylesheet" href="css/style_w.css">
    <script src="js/jquery-1.10.2.js" type="text/javascript"></script>
    <style>
        th  {
            white-space: nowrap;
        }
        td  {
            white-space: nowrap;
        }

    </style>
    <script type="text/javascript">
        function myf(){


            var bt1=document.getElementById('');
            bt1.className = "layui-btn";



            //bt1.setAttribute("data-method","selectMoudle");
            //var datam = bt1.getAttribute("data-method");
        }
    </script>
    <script type = "text/javascript">
        function getValue(obj) {

            var myselect = obj;
//            var id1 =
            var index = myselect.selectedIndex;
            var va = myselect.options[index].value;
            if (va =='2'){
                obj.parentNode.style.display = "none";

            }

        }


    </script>

</head>

<body class="kit-theme">

<%
    request.setCharacterEncoding("utf-8");
    Excel excel= (Excel) request.getAttribute("datainfo");//文章链表
    Excel preexcel=(Excel) request.getAttribute("predatainfo");
    if(preexcel==null) preexcel=new Excel();
    if(excel==null) excel=new Excel();
    String appname=(String)request.getAttribute("appname");
    String apptype=(String)request.getAttribute("apptype");
    request.setAttribute("datainfo",excel);
    request.setAttribute("srcpath","pre");
    System.out.println(excel.getDbname());
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
                <li class="layui-nav-item">
                    <form action="AnalyAndPreServlet" method="post">
                    <a class="" href="AnalyAndPreServlet?appname=<%=appname%>&apptype=<%=apptype%>&srcpath=pre" ><i class="fa fa-plug" aria-hidden="true"></i><span> 数据分析</span></a>
                    </form>
                </li>
                <li class="layui-nav-item layui-this">
                    <a href="datapre2.jsp"><i></i><span>数据预测</span></a>


                </li>
            </ul>
        </div>
    </div>
    <div class="layui-body" id="container">
        <!-- 内容主体区域 -->
        <div style="padding: 15px;">



            <div class ="layui-tab layui-tab-card ">
                <ul class="layui-tab-title">

                    <li class="layui-this">训练数据</li>
                    <li>预测数据</li>
                </ul>

                <div class="layui-tab-content">
                    <div class="layui-tab-item layui-show ">
                        <div style="height: 400px;overflow-y: scroll">
                            <table class="layui-table ">
                                <thead>
                                <tr>
                                    <%
                                        for(int i=0;i<excel.getHeaders().size();i++){
                                            Integer num = new Integer(i);

                                    %>




                                    <th>
                                        <span><%=excel.getHeaders().get(i)%></span>
                                        <a>
                                            <i id = "<%=num.toString()%>" class="pa layui-icon" data-method="setparam">&#xe625;</i>
                                        </a>

                                    </th>
                                    <%
                                        }

                                    %>

                                    <th>
                                        <button class="layui-btn">保存</button>
                                    </th>


                                </tr>
                                </thead>
                                <tbody>

                                <%
                                    for(int j = 0; j <excel.getDatas().size();j++ ){



                                %>

                                <tr>
                                    <%
                                        for(int i = 0;i<excel.getDatas().get(i).size();i++){


                                    %>


                                    <td><%=excel.getDatas().get(j).get(i)%></td>
                                    <%
                                        }
                                    %>


                                </tr>

                                <%
                                    }
                                %>

                                </tbody>

                            </table>
                            <div class="bt" style="margin-top:20px;"><button id="enable1" data-method="selectMoudle" class="layui-btn " >训练模型</button></div>
                        </div>
                    </div>
                    <div class="layui-tab-item">
                        <div style="height: 400px;overflow-y: scroll">

                            <table class="layui-table ">
                                <thead>
                                <tr>
                                    <%
                                        for(int i=0;i<preexcel.getHeaders().size();i++){


                                    %>




                                    <th>
                                        <span><%=preexcel.getHeaders().get(i)%></span>
                                        <a>
                                            <i  class="pa layui-icon" data-method="setparam">&#xe625;</i>
                                        </a>

                                    </th>
                                    <%
                                        }

                                    %>

                                    <th>
                                        <span>预测结果</span>
                                    </th>


                                </tr>
                                </thead>
                                <tbody>

                                <%
                                    for(int j = 0; j <preexcel.getDatas().size();j++ ){



                                %>

                                <tr>
                                    <%
                                        for(int i = 0;i<preexcel.getDatas().get(j).size();i++){


                                    %>


                                    <td><%=preexcel.getDatas().get(j).get(i)%></td>
                                    <%
                                        }
                                    %>
                                    <td></td>

                                </tr>

                                <%
                                    }
                                %>

                                </tbody>

                            </table>
                        </div>


                    </div>


                </div>

            </div>
            <div>


                <div class="layui-tab layui-tab-card">
                    <ul class="layui-tab-title">
                        <li class="layui-this">我的模型</li>


                    </ul>
                    <div class="layui-tab-content">
                        <div class="layui-tab-item layui-show">
                            <div id="fh5co-photos-section">
                                <div class="layui-fluid">
                                    <div class="layui-row layui-col-space20">






                                        <div class="layui-col-md3">
                                            <a href="#"  class="grid-photo img-popup" style="background-image: url(img/pic18.jpg);">
                                                <div class="desc">
                                                    <h3>酒店评级</h3>
                                                    <span>创建时间</span>
                                                </div>
                                            </a>
                                        </div>
                                        <div class="layui-col-md3">
                                            <a href="javascript:;" onclick="myf()" class="grid-photo img-popup" style="background-image: url(img/pic19.jpg);">
                                                <div class="desc">
                                                    <h3>电影评分</h3>
                                                    <span>创建时间</span>
                                                </div>
                                            </a>
                                        </div>
                                        <div class="layui-col-md3">
                                            <a href="javascript:;" onclick="myf()" class="grid-photo img-popup" style="background-image: url(img/pic20.jpg);">
                                                <div class="desc">
                                                    <h3>酒店评级</h3>
                                                    <span>创建时间</span>
                                                </div>
                                            </a>
                                        </div>
                                        <div class="layui-col-md3">
                                            <a href="javascript:;" onclick="myf()" class="grid-photo img-popup" style="background-image: url(img/pic21.jpg);">
                                                <div class="desc">
                                                    <h3>电影评分</h3>
                                                    <span>创建时间</span>
                                                </div>
                                            </a>
                                        </div>


                                    </div>
                                </div>
                            </div>
                        </div>


                    </div>
                </div>
                <form action="UploadFileServlet" enctype="multipart/form-data" method="post" >

                <div  class="bt">
                    <label for="prefile" style="cursor: pointer">
                        <div style="width:300px;height: 200px;border:dashed 1px; margin-bottom: 20px;" align="center">
                        <i class="layui-icon" style="font-size: 100px; color: #1E9FFF;">&#xe67c;</i>
                        <p>上传文件</p>
                        </div>

                    </label>
                    <input id="prefile" type="file" name="prefile" style="display: none">
                    <button type="submit" class="layui-btn ">提交预测数据</button>
                    <input name="srcpath" style="display: none" value="pre">
                    <input name="appname" style="display: none" value=<%=appname%>>
                    <input name="apptype" style="display: none" value=<%=apptype%>>
                </div>
                </form>
            </div>


        </div>




    </div>

    <!-- <div class="layui-footer">


     </div>-->
</div>



<div id="tan" class="layui-fluid" style="display:none;">





    <form class="layui-form" action="data_analysis.jsp">
        <%
            for(int i = 0; i <excel.getHeaders().size(); i ++) {
                Integer ii =  new Integer(i);
        %>
        <div id = <%="par"+ii.toString()%>>
            <div class="layui-form-item">

                <div class="layui-inline">
                <label class="layui-form-label"><%=excel.getHeaders().get(i)%></label>
                <div class="layui-input-inline" style="width:100px;">

                    <select id="<%="io"+ii.toString()%>" name="<%="io"+ii.toString()%>" lay-verify="required" onchange="getValue(this)">
                        <option value="">请选择输入输出层</option>
                        <option value="0">输出层</option>
                        <option value="1">输入层</option>
                        <option value="2">无</option>
                    </select>
                </div>
                <div class="layui-input-inline" style="width:100px;">

                    <select id="<%="datatype"+ii.toString()%>" name="<%="datatype"+ii.toString()%>" lay-verify="required" >
                        <option value="">请选择数据类型</option>
                        <option value="0">枚举型</option>
                        <option value="1">数据型</option>
                    </select>
                </div>
                <div class="layui-input-inline" style="width:100px;">

                    <input id="<%="col"+ii.toString()%>" type="text" name="<%="col"+ii.toString()%>" required lay-verify="required" placeholder="权重/枚举值" autocomplete="off" class="col layui-input">
                </div>
                </div>
            </div>


        </div>
        <%
            }
        %>



        <div class="layui-form-item">
            <label class="layui-form-label">选择算法</label>
            <div class="layui-input-block">
                <select name="algo" lay-verify="required">
                    <option value="">请选择已有算法</option>
                    <option value="0">bp</option>
                    <option value="1">svm</option>
                    <option value="2">rnn</option>
                    <option value="3">LSTM</option>
                    <option value="4">cnn</option>
                </select>
            </div>
        </div>




        <div class="layui-form-item">
            <div class="layui-input-block">
                <button class="layui-btn" >开始训练</button>
                <button type="button" class="layui-btn">提交</button>
                <button type="reset" class="layui-btn layui-btn-primary">重置</button>
            </div>
        </div>



    </form>


</div>




<script src="./plugins/layui/layui.js"></script>
<script src="./build/js/app.js"></script>
<script>




    layui.use('element', function(){
        var element = layui.element;

        //一些事件监听


        //…
    });


    layui.use('layer', function(){
        var layer = layui.layer;
        var $ = layui.jquery;
        var active={
            selectMoudle:function(){
                layer.open({
                    type: 1,
                    title: '训练模型',
                    shadeClose: true,


                    area: ['800px', '600px'],
                    content: $('#tan')



                });

            },

            setparam:function(){



                layer.open({
                    type:1,
                    title:'设置参数',
                    shadeClose:true,
                    area:['300px','200px'],
                    content: $('#par1')
                })
            }



        };
        $('.bt .layui-btn').on('click', function () {
            var othis = $(this), method = othis.data('method');
            active[method] ? active[method].call(this, othis) : '';


        });
        $('.pa').on('click',function(){
            var othis = $(this), method = othis.data('method');
            active[method] ? active[method].call(this,othis) : '';
        })

    });
    layui.use('form', function(){

    });
</script>




</body>


</html>