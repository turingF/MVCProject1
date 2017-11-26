package edu.nuaa.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.nuaa.factory.DaoFactory;
import edu.nuaa.vo.User;

public class LoginServlet extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public LoginServlet() {
		super();
	}

	/**
	 * Destruction of the servlet. <br>
	 */
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

	/**
	 * The doGet method of the servlet. <br>
	 * 
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request
	 *            the request send by the client to the server
	 * @param response
	 *            the response send by the server to the client
	 * @throws ServletException
	 *             if an error occurred
	 * @throws IOException
	 *             if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String path = "index.jsp";
		List<String> info = new ArrayList<String>();
		int uid = 0;
		if(request.getParameter("uid") != null){
			uid = Integer.parseInt(request.getParameter("uid"));
		}else{
			info.add("用户id不能为空");
		}
		String password =request.getParameter("password");
		if(password == null || "".equals(password)){
			info.add("密码不能为空");
		}
		
		if(info.size() == 0){
			User user = new User();
			user.setUid(uid);
			user.setPassword(password);
			
			try {
				if(DaoFactory.getIUserDaoInstance().fingLogin(user)){
					info.add("用户登陆成功，欢迎"+user.getUsername()+"光临！");
				}else{
					info.add("用户登陆失败");
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		request.setAttribute("info", info);
		request.getRequestDispatcher(path).forward(request, response);
		
	}

	/**
	 * The doPost method of the servlet. <br>
	 * 
	 * This method is called when a form has its tag value method equals to
	 * post.
	 * 
	 * @param request
	 *            the request send by the client to the server
	 * @param response
	 *            the response send by the server to the client
	 * @throws ServletException
	 *             if an error occurred
	 * @throws IOException
	 *             if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		this.doGet(request, response);
	}

	/**
	 * Initialization of the servlet. <br>
	 * 
	 * @throws ServletException
	 *             if an error occurs
	 */
	public void init() throws ServletException {
		// Put your code here
	}

}
