package com.yuantu.web.servlet.manager;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class MgLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public MgLoginServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 设值请求编码格式
		request.setCharacterEncoding("utf-8");
		// 响应类型
		response.setContentType("text/html; charset=UTF-8");
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/manager/mgLogin.jsp");
		// 请求转发
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 设值请求编码格式
		request.setCharacterEncoding("utf-8");
		// 响应类型
		response.setContentType("text/html; charset=UTF-8");

		String username = request.getParameter("username");
		String pwd = request.getParameter("pwd");
		System.out.println("hhhhhh");
		if ("admin".equals(username) && "admin".equals(pwd)) {
			
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/manager/mgIndex.jsp");
			HttpSession session = request.getSession();
			session.setAttribute("isLogin", 1);
			
			// 请求转发
			dispatcher.forward(request, response);
		}else {
			//RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/manager/mgLogin.jsp");
			// 请求转发
			//dispatcher.forward(request, response);
			System.out.println("xxx");
			response.sendRedirect("/WEB03/MgLogin");
		}
	}

}
