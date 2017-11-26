package edu.nuaa.servlet.xuyang;


import java.io.IOException;
import java.io.PrintWriter;


@SuppressWarnings("serial")
public class RegisterServlet extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public RegisterServlet() {
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
		PrintWriter out = response.getWriter();
		
		String account = request.getParameter("account");
		String password = request.getParameter("password");

		Boolean RegisRS = false;
		
		if(account==null||password==null){
			System.out.println("用户名或密码不能为空");
		}
		
		try {
			if (DaoFactory.getUserDaoInstance().register(account, password)==true) {
				RegisRS = true; // 注册成功
			} else {
				RegisRS = false; //注册失败
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			out.print(RegisRS);
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
