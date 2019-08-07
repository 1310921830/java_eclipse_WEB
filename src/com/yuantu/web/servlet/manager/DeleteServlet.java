package com.yuantu.web.servlet.manager;

import java.io.IOException;
import java.io.PrintWriter;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.yuantu.service.UserService;
import com.yuantu.service.impl.UserServiceImpl;

public class DeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public DeleteServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// ��ֵ��������ʽ
		request.setCharacterEncoding("utf-8");
		// ��Ӧ����
		response.setContentType("application/json; charset=UTF-8");
		String uId =request.getParameter("id");
		System.out.println(uId);
		UserService userService = new UserServiceImpl();
		int result= userService.deleteUserById(uId);
		PrintWriter out = response.getWriter();
		String json = "{\"message\":";
		if(result>0) {
			json = json + "\"ɾ���ɹ�\","+"\"flag\":\"true\"}";
		}else {
			json = json + "\"ɾ��ʧ��\","+"\"flag\":\"false\"}";
		}
		System.out.println(json);
		out.print(json);
		
		//RequestDispatcher dispatcher = request.getRequestDispatcher("/MgShow");
		// ����ת��
		//dispatcher.forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("post");
		doGet(request, response);
	}

}
