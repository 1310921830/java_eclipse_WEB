package com.yuantu.web.servlet.manager;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.yuantu.entity.User;
import com.yuantu.service.UserService;
import com.yuantu.service.impl.UserServiceImpl;

public class MgShowServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public MgShowServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 设值请求编码格式
		request.setCharacterEncoding("utf-8");
		// 响应类型
		response.setContentType("text/html; charset=UTF-8");
		String username = request.getParameter("username");
		
		String name = request.getParameter("name");
		UserService userService = new UserServiceImpl();
		List<User> list = userService.queryByNames(username, name);
		request.setAttribute("userList", list);
		request.setAttribute("uname", username);
		request.setAttribute("name", name);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/manager/mgShow.jsp");
		// 请求转发
		dispatcher.forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
