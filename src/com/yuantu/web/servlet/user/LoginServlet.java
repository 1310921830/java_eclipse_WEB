package com.yuantu.web.servlet.user;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yuantu.entity.User;
import com.yuantu.service.UserService;
import com.yuantu.service.impl.UserServiceImpl;
import com.yuantu.util.Md5Util;


public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public LoginServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		// 设值请求编码格式
		request.setCharacterEncoding("utf-8");
		// 响应类型
		response.setContentType("text/html; charset=UTF-8");

		String username = request.getParameter("username");
		String pwd = request.getParameter("pwd");
		
		UserService userService = new UserServiceImpl();
		User user = userService.userLogin(username, Md5Util.encrypt(pwd));
		String message;
		if(null!=user) {
			message = "登录成功";
			RequestDispatcher dispatcher = request
					.getRequestDispatcher("/WEB-INF/user/loginShow.jsp");
			
			request.setAttribute("result", message);
			request.setAttribute("u", user);
			//请求转发
			dispatcher.forward(request, response);
		}else {
			message = "用户名或密码错误";
			RequestDispatcher dispatcher = request
					.getRequestDispatcher("/WEB-INF/user/login.jsp");
			
			request.setAttribute("result", message);
			//请求转发
			dispatcher.forward(request, response);
		}
		
	}

}
