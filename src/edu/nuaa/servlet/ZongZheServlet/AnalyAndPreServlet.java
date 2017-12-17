package edu.nuaa.servlet.ZongZheServlet;

import edu.nuaa.factory.DaoFactory;
import edu.nuaa.vo.ZongZheVo.Excel;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "AnalyAndPreServlet")
public class AnalyAndPreServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String srcpath =request.getParameter("srcpath");
        String appname = request.getParameter("appname");
        String apptype=request.getParameter("apptype");
        String path="";

        //Written by Zong
        //向下一个界面传递数据
        Excel orgexcel=new Excel();
        Excel preexcel=new Excel();
        try {
            orgexcel = DaoFactory.getExcelDaoInstance().getExcelDataFromMysql(appname+"原始数据集");

        } catch (Exception e) {
            e.printStackTrace();
            orgexcel=null;
        }
        try {
            preexcel = DaoFactory.getExcelDaoInstance().getExcelDataFromMysql(appname+"预测数据集");
        } catch (Exception e) {
            e.printStackTrace();
            preexcel=null;
        }
        if(srcpath.equals("pre")) path="analy.jsp";//导入完预测数据
        if(srcpath.equals("analy")) path="datapre2.jsp";//上传完文件

        request.setAttribute("appname",appname);
        request.setAttribute("apptype",apptype);
        request.setAttribute("predatainfo",preexcel);
        request.setAttribute("datainfo",orgexcel);//该函数是添加指定的属性并为其赋值，如果该属性已经存在，就直接赋值s
        request.getRequestDispatcher(path).forward(request,response);//那个get什么的函数是跳转到指定的URL地址
         }
}
