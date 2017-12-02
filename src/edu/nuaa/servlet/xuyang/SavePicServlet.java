package edu.nuaa.servlet.xuyang;

import edu.nuaa.factory.DaoFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "SavePicServlet")
public class SavePicServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        Boolean savepRS = false ;

        PrintWriter out = response.getWriter();

        int appid =  Integer.parseInt(request.getParameter("appid"));
        String path = request.getParameter("path");

        HttpSession session = request.getSession();

        try {
            if(DaoFactory.getAnReDaoInstance().SaveRe(appid, path)==true){
                savepRS = true;

            }
            else {
                savepRS = false;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            out.print(savepRS);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
