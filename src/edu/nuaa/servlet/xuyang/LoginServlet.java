package edu.nuaa.servlet.xuyang;



import edu.nuaa.factory.DaoFactory;

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

		response.setCharacterEncoding("utf-8");
		request.setCharacterEncoding("utf-8");
		Boolean LoginRS = false ;
		
		PrintWriter out = response.getWriter();
		
		String account = request.getParameter("account");
		String password = request.getParameter("password");

		HttpSession session = request.getSession();
		
		try {
			if(DaoFactory.getUserDaoInstance().login(account, password)==true){
				LoginRS = true;  //登录成功
				session.setAttribute("uid",account);
				request.getRequestDispatcher("user.jsp").forward(request,response);
			}
			else {
			LoginRS = false; //登录失败
				request.getRequestDispatcher("index.jsp").forward(request,response);
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
