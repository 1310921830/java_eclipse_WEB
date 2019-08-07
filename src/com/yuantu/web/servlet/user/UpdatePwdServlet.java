package com.yuantu.web.servlet.user;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yuantu.entity.User;
import com.yuantu.service.UserService;
import com.yuantu.service.impl.UserServiceImpl;
import com.yuantu.util.Md5Util;

public class UpdatePwdServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public UpdatePwdServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// ��ֵ��������ʽ
		request.setCharacterEncoding("utf-8");
		// ��Ӧ����
		response.setContentType("text/html; charset=UTF-8");
		String uId = request.getParameter("id");
		UserService userService = new UserServiceImpl();
		User user = userService.queryUserById(uId);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/user/updatePwd.jsp");
		request.setAttribute("U", user);
		// ����ת��
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// ��ֵ��������ʽ
		request.setCharacterEncoding("utf-8");
		// ��Ӧ����
		response.setContentType("application/json; charset=UTF-8");
		String uId = request.getParameter("id");
		String oldPwd = request.getParameter("oldPwd");
		String newPwd = request.getParameter("newPwd");
		UserService userService = new UserServiceImpl();
		User user = userService.queryUserById(uId);

		String json = "{\"message\":";
		// �����������
		if (user.getPwd().equals(Md5Util.encrypt(oldPwd))) {
			int result = userService.updateUserPwd(uId, Md5Util.encrypt(newPwd));
			if (result > 0) {
				json = json + "\"�޸ĳɹ�\"," + "\"flag\":\"true\"}";
			} else {
				json = json + "\"�޸�ʧ��\"," + "\"flag\":\"false\"}";
			}
		} else {
			json = json + "\"ԭ���������\"," + "\"flag\":\"false\"}";
		}
		PrintWriter out = response.getWriter();
		out.print(json);
	}

}
