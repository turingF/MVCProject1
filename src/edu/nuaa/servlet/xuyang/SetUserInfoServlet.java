package edu.nuaa.servlet.xuyang;



import edu.nuaa.factory.DaoFactory;
import edu.nuaa.vo.XuYangVo.UserInfo;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


@SuppressWarnings("serial")
public class SetUserInfoServlet extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public SetUserInfoServlet() {
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

		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("utf-8");
		String account = request.getParameter("account");
		String password = request.getParameter("password");
		
		PrintWriter out = response.getWriter();
		
		
		boolean SetUserRS = false;
		
	
		
		UserInfo us = new UserInfo();

		try {
			us = DaoFactory.getUserDaoInstance().findUserByAccount(account);
			us.setPassword(password);
		} catch (Exception e) {
			e.printStackTrace();
		}


		try {
			
			SetUserRS = DaoFactory.getUserDaoInstance().setUserInfo(us);
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			out.print(SetUserRS);
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

		doGet(request, response);

}
}
