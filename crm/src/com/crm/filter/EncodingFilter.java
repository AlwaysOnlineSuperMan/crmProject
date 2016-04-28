package com.crm.filter;

import java.io.IOException;
import java.util.Enumeration;
import java.util.Map;
import java.util.Set;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class EncodingFilter implements Filter {

	public void init(FilterConfig filterConfig) throws ServletException {
		System.out.println("编码过滤已开始初始化。。。。");
	}

	public void doFilter(ServletRequest req, ServletResponse res,
			FilterChain chain) throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest)req;
		HttpServletResponse response = (HttpServletResponse)res;
		String method = request.getMethod();
		//System.out.println("此次"+method+"请求,编码过滤已开始。。。。");
		if(method.equalsIgnoreCase("post")) {
			request.setCharacterEncoding("utf-8");
		} else if(method.equalsIgnoreCase("get")) {
			Enumeration names = request.getParameterNames();
			while(names.hasMoreElements()) {
				String name = (String)names.nextElement();
				String[] values = request.getParameterValues(name);
				for(int i = 0; i < values.length; i++) {
					values[i] = new String(values[i].getBytes("iso8859-1"),"utf-8");
				}
			}
		}
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=utf-8");
		//System.out.println("此次"+method+"请求,编码过滤已完成。。。。");
		chain.doFilter(request,response);
		//System.out.println("此次"+method+"请求,编码响应已完成。。。。");
	}

	public void destroy() {
		System.out.println("编码过滤已销毁。。。。");
	}

}
