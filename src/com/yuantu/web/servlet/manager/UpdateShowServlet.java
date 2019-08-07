package com.yuantu.web.servlet.manager;

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

public class UpdateShowServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public UpdateShowServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 设值请求编码格式
		request.setCharacterEncoding("utf-8");
		// 响应类型
		response.setContentType("text/html; charset=UTF-8");
		String uId = request.getParameter("id");
		UserService userService = new UserServiceImpl();
		User user = userService.queryUserById(uId);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/manager/register.jsp");
		request.setAttribute("U", user);
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
		String id = request.getParameter("id");
		String username = request.getParameter("username");
		String pwd = request.getParameter("pwd1");
		String name = request.getParameter("name");
		String gender = request.getParameter("gender");
		String age = request.getParameter("age");
		UserService userService = new UserServiceImpl();
		User user = new User();
		user.setUserName(username);
		user.setPwd(Md5Util.encrypt(pwd));
		user.setName(name);
		user.setGender(gender);
		user.setAge(new Integer(age));
		String message;
		int result;
		// id不为空，说明是修改请求
		if (null != id && !"".equals(id)) {
			user.setuId(id);
			result = userService.updateUser(user);
			if (result > 0) {
				message = "修改成功";
			} else {
				message = "修改失败,可能用户名已存在";
			}

		} else {
			String id1 = UUID.randomUUID().toString();
			id1 = id1.replaceAll("-", "");
			user.setuId(id1);
			result = userService.saveUser(user);
			if (result == 0) {
				message = "用户名已存在";
			} else {
				message = username + ":注册成功";
			}
		}
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/manager/updateResult.jsp");
		request.setAttribute("result", message);
		dispatcher.forward(request, response);
	}

}
