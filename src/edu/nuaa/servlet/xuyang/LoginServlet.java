package edu.nuaa.servlet.xuyang;



import edu.nuaa.factory.DaoFactory;
import org.omg.Messaging.SYNC_WITH_TRANSPORT;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;


@SuppressWarnings("serial")
public class LoginServlet extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public LoginServlet() {
		super();
	}

	/**
	 * The doGet method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("utf-8");
		Boolean LoginRS = false ;
		
		PrintWriter out = response.getWriter();
		
		String account = request.getParameter("account");
		String password = request.getParameter("password");


		HttpSession session = request.getSession();
		
		try {
			if(DaoFactory.getUserDaoInstance().login(account, password)==true){
				LoginRS = true;  //登录成功
				session.setAttribute("sessionId",account);

				RequestDispatcher ds;

				response.setContentType("text/html;charset=UTF-8");
				request.getRequestDispatcher("user.jsp").forward(request,response);

			}
			else {
			LoginRS = false; //登录失败


				RequestDispatcher ds;
				ds=request.getRequestDispatcher("index.jsp");
				response.setContentType("text/html;charset=UTF-8");
				ds.forward(request,response);

			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
		out.print(LoginRS);
		}
	}

	/**
	 * The doPost method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to post.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		this.doGet(request, response);
	}

}
