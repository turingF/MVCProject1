package edu.nuaa.servlet.ZongZheServlet;

import com.jspsmart.upload.SmartUpload;
import com.jspsmart.upload.SmartUploadException;
import edu.nuaa.tool.IPTimeStamp;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "UploadFileServlet")
public class UploadFileServlet extends HttpServlet {
    private ServletConfig config;
    public UploadFileServlet() {
        super();
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //获取用户id
        HttpSession session=request.getSession();
//        int uid= (int) session.getAttribute("uid");
        //Written by Li
        //用户上传文件

        SmartUpload su = new SmartUpload(); //初始化上传操作
        su.initialize(getServletConfig(),   request,   response);//上传准备
        try {
            su.upload();
        } catch (SmartUploadException e) {
            e.printStackTrace();
        }
        //将上传文件保存在upload文件夹中，该文件夹是手动创建的。
        String srcpath= su.getRequest().getParameter("srcpath");
        String apptype = su.getRequest().getParameter("optionsRadiosinline");//获取文件类型
        String appname= su.getRequest().getParameter("appname");//获取文件类型
        if(apptype==null) apptype= su.getRequest().getParameter("apptype");//获取文件类型
        String uploadpath="";
        //将上传文件保存在upload文件夹中，该文件夹是手动创建的。
        IPTimeStamp its = new IPTimeStamp();
        String ext = su.getFiles().getFile(0).getFileExt();
        String filename = its.getIPTimeRand()+"."+ext;
        uploadpath=getServletContext().getRealPath("/")+"upload"+java.io.File.separator +filename;
        try {
            su.getFiles().getFile(0).saveAs(uploadpath);
        } catch (SmartUploadException e) {
        }
        String path=null;
        switch(apptype)
        {
            /**
             *   request.setAttribute("info", "登录失败");
             RequestDispatcher ds = request.getRequestDispatcher("login.jsp");
             ds.forward(request, response);
             */

            case "excel":{
                path="SaveExcelServlet";
                request.setAttribute("apptype",apptype);
                request.setAttribute("filename",appname);
                request.setAttribute("filepath",uploadpath);
                request.setAttribute("srcpath",srcpath);
//                request.setAttribute("uid",uid);
                RequestDispatcher ds = request.getRequestDispatcher(path);
                ds.forward(request,response);//那个get什么的函数是跳转到指定的URL地址
            }break;
            case "csv":{

            }break;
        }

    }
}
