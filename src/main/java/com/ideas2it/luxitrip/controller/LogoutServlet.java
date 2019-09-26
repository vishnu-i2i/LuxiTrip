package com.ideas2it.luxitrip.controller;

import java.io.IOException;
import java.io.PrintWriter;  

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;  
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.bind.annotation.RequestMapping;
/**
 * Servlet implementation class LogoutServlet
 */
@Controller
public class LogoutServlet {
    
    @RequestMapping("/logout")
    public ModelAndView logout(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");  
        PrintWriter out=response.getWriter();  
        ModelAndView model = new ModelAndView("login");     
        HttpSession session=request.getSession();  
        session.invalidate();              
        return model;
    }
}
