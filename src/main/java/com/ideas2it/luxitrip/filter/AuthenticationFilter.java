package com.ideas2it.luxitrip.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.RequestDispatcher;


public class AuthenticationFilter implements Filter {
	public void init(FilterConfig fConfig) throws ServletException { }
	
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
	    HttpServletRequest httpRequest = (HttpServletRequest) request;
	    HttpServletResponse httpResponse = (HttpServletResponse) response;
        HttpSession session = httpRequest.getSession(false);
        boolean isLoggedIn = (session != null && session.getAttribute("userId") != null);
		String loginURI = httpRequest.getContextPath() + "/login"; 
		String signUpURI = httpRequest.getContextPath() + "/registerUser";
        boolean isLoginRequest = httpRequest.getRequestURI().equals(loginURI);
		boolean isSignUpRequest = httpRequest.getRequestURI().equals(signUpURI);
        if(isLoggedIn) {
            chain.doFilter(request, response);  
        } else if(isLoginRequest || isSignUpRequest) {
            chain.doFilter(request, response);
        } else {
            RequestDispatcher dispatcher = httpRequest.getRequestDispatcher
                                               ("/jsp/login.jsp");
            dispatcher.forward(httpRequest, httpResponse);
        }
	}

	public void destroy() { }

}


