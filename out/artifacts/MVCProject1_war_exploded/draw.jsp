<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'index.jsp' starting page</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>ECharts</title>
    
    <!-- 引入 echarts.js -->
    <script type="text/javascript" src="js/echarts.js"></script>
    <!-- 引入jquery.js -->
    <script type="text/javascript" src="js/jquery-1.12.4.js"></script>
  </head>
  
  <body>
  <!-- 为ECharts准备一个具备大小（宽高）的Dom -->
    <div id="main" style="width: 1000px;height:600px;"></div>
    
    <script type="text/javascript">
        
        var myChart = echarts.init(document.getElementById('main'));
         // 显示标题，图例和空的坐标轴
         myChart.setOption({
             title: {
                 text: '软件失效数据'
             },
             tooltip: {},
             legend: {
                 data:['失效时间']
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
         
         var names=[];    //类别数组（实际用来盛放X轴坐标值）
         var nums=[];    //销量数组（实际用来盛放Y坐标值）
         
         $.ajax({
         type : "post",
         async : true,            //异步请求（同步请求将会锁住浏览器，用户其他操作必须等待请求完成才可以执行）
         url : "TestServlet",    //请求发送到TestServlet处
         data : {},
         dataType : "json",        //返回数据形式为json
         success : function(result) {
             //请求成功时执行该函数内容，result即为服务器返回的json对象
             if (result) {
                    for(var i=0;i<result.length;i++){       
                       names.push(``);    //挨个取出类别并填入类别数组
                     }
                    for(var i=0;i<result.length;i++){       
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
         error : function(errorMsg) {
             //请求失败时执行该函数
         alert("图表请求数据失败!");
         myChart.hideLoading();
         }
    })

         
    </script>
  </body>
</html>
