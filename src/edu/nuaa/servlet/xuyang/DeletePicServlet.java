package servlet.xuyang;

import Daofactory.DaoFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "DeletePicServlet")
public class DeletePicServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("utf-8");
        Boolean DelPRS = false ;

        PrintWriter out = response.getWriter();

        int appid =  Integer.parseInt(request.getParameter("appid"));
        String path = request.getParameter("path");

        HttpSession session = request.getSession();

        try {
            if(DaoFactory.getAnReDaoInstance().DeleteRe(appid, path)==true){
                DelPRS = true;

            }
            else {
                DelPRS = false;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            out.print(DelPRS);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
