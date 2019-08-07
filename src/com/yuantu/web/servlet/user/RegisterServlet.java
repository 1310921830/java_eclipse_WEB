package com.yuantu.web.servlet.user;

import java.io.IOException;

import java.util.UUID;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yuantu.entity.User;

import com.yuantu.service.UserService;
import com.yuantu.service.impl.UserServiceImpl;
import com.yuantu.util.Md5Util;


public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public RegisterServlet() {
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

		String username =request.getParameter("username");
		String pwd1 =request.getParameter("pwd1");
		
		String name =request.getParameter("name");
		String gender =request.getParameter("gender");
		String age = request.getParameter("age");
		
		
		
		UserService userService = new UserServiceImpl();
		
		String id = UUID.randomUUID().toString();
		id = id.replaceAll("-", "");
		User user = new User(id,username,Md5Util.encrypt(pwd1),name,gender,Integer.parseInt(age));
		int result = userService.saveUser(user);
		String message;
		if(result==0) {
			message = "用户名已存在";
		}else {
			message = username+":注册成功";
		}
		
		
		RequestDispatcher dispatcher = request
				.getRequestDispatcher("/WEB-INF/user/regShow.jsp");
		
		request.setAttribute("result", message);

		dispatcher.forward(request, response);
	}

}
