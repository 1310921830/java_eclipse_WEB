package com.yuantu.web.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;


import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebFilter("/MgFilter")
public class MgFilter implements Filter {

	

	public MgFilter() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		// 设值请求编码格式
		request.setCharacterEncoding("utf-8");
		// 响应类型
		response.setContentType("text/html; charset=UTF-8");
		System.out.println("mg filter is working!");
		System.out.println(request.getRemoteAddr());
		HttpServletRequest request1 =(HttpServletRequest) request; 
		HttpServletResponse response1 = (HttpServletResponse) response;
		HttpSession session =request1.getSession(true);
		System.out.println(session.getAttribute("isLogin"));
		Object r = session.getAttribute("isLogin");
		
		if (null!=r && (int)r==1){ 
			chain.doFilter(request, response); 
		} else { 
			//RequestDispatcher dispatcher= request1.getRequestDispatcher("/WEB-INF/manager/mgLogin.jsp"); 
			// 请求转发
			//dispatcher.forward(request1, response1);
			response1.sendRedirect("/WEB03/MgLogin"); 
			} 
	  }
	 
	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
