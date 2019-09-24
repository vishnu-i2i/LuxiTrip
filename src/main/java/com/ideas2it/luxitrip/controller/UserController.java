package com.ideas2it.luxitrip.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse; 
import javax.servlet.annotation.WebServlet;  
import javax.servlet.http.HttpServlet;  
import javax.servlet.http.HttpSession; 
import javax.servlet.RequestDispatcher;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.beans.factory.annotation.Autowired;    
import org.springframework.stereotype.Controller;    
import org.springframework.web.bind.annotation.ModelAttribute;   
import org.springframework.web.bind.annotation.RequestMapping; 

import com.ideas2it.luxitrip.service.impl.UserServiceImpl;
import com.ideas2it.luxitrip.model.User;
import com.ideas2it.luxitrip.exception.CustomException;

@Controller
public class UserController {
	@Autowired
	private UserServiceImpl userService;

    /**
	 * Method used to validate the user by using the userName and password in the database
	 * @param request
	 * @param response
	 * @return the confirmation to the User 
	 * @throws ServletException
	 * @throws IOException
	 */
    @RequestMapping("validateUser")
	public ModelAndView validateUser(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
        try {
			String name = request.getParameter("userName");
			String password = request.getParameter("password");
			User user = userService.retrieveUserByName(name);
			String role = userService.redirectPage(user, password); 
			if(role.equals("Admin")) {

			} else if(role.equals("User")) {
				HttpSession session = request.getSession();
                session.setAttribute("userId", user.getId());
			    return new ModelAndView("cinemax", "user", user);
			} else {
				return new ModelAndView("Message", "message", "Your emailId and password is Wrong");
			}
		} catch(CustomException ex) {
			return new ModelAndView("Message", "message", "User name and password is wrong");
		}
		return new ModelAndView("Message", "message", "Reach agala");
	}
	/**
	 * Method used to register the user and its detail in the database
	 * @param request
	 * @param response
	 * @return the confirmation to the User 
	 * @throws ServletException
	 * @throws IOException
	 */
	@RequestMapping("/registerUser")
	public ModelAndView registerUser(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		User user = new User();
        try {
			String name = request.getParameter("name");
			String password = request.getParameter("password");
			String number = request.getParameter("number");
			String emailId = request.getParameter("emailId");
			user.setName(name);
			user.setNumber(number);
			user.setPassword(password);
			user.setEmailId(emailId);
			userService.createUser(user);
		    return new ModelAndView("Message", "message", "User Added Successfully");
		} catch (CustomException ex) {
		    return new ModelAndView("error",  "error", ex);
		}
    }
	
	/**
	 *  Method used to display the list of users in the database 
	 * @return the list of users
	 * @throws ServletException
	 * @throws IOException
	 */
	@RequestMapping("/displayUsers")
	public ModelAndView displayUsers() throws ServletException, IOException {
	    try {
		    List<User> users = userService.retrieveUsers();
		    return new ModelAndView("userPage", "users", users);
		} catch (CustomException ex) {
			return new ModelAndView("error", "error", ex);
		}
	}
	
	/**
	 * Method used to get the User from the database by using the userId
	 * @param request
	 * @param response
	 * @return the userObject to the requested page
	 * @throws ServletException
	 * @throws IOException
	 */
	@RequestMapping("/displayUserToUpdate")
	public ModelAndView getUser(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
        int userId = (Integer.parseInt(request.getParameter("userId")));
        try {
        	User user = userService.retrieveUserById(userId);
        	return new ModelAndView("updateUserForm", "user", user);
        } catch(CustomException ex) {
        	return new ModelAndView("error", "error", ex);
        }
	}

    /**
	 * Method used to get the the User by using the userName
	 * @param request
	 * @param response
	 * @return the userObject to the requested page
	 * @throws ServletException
	 * @throws IOException
	 */
	public ModelAndView getUserByName(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
	    String name = request.getParameter("userName");
		try {
			User user = userService.retrieveUserByName(name);
			return new ModelAndView("", "user", user);
		} catch(CustomException ex) {
			return new ModelAndView("error", "error", ex);
		}
	}
	
	/**
	 * Method used to update the user detail from the existing user detail
	 * @param user - it get the updated user detail
	 * @return the confirmation to the user
	 * @throws ServletException
	 * @throws IOException
	 */
	public ModelAndView updateUser(@ModelAttribute("user")User user) 
			throws ServletException, IOException {
		try {
	 	    userService.updateUser(user);
		    return new ModelAndView("Message", "message", "User updated successfully");
	    } catch(CustomException ex) {
	    	return new ModelAndView("error", "error", ex);
	    }
	}
	
	/**
	 * Method used to delete the User from the database by using the UserId 
	 * given from the User
	 * @return the confirmation to the user
	 * @throws ServletException
	 * @throws IOException
	 */
	@RequestMapping("/removeUser")
	public ModelAndView deleteUser(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
	    int userId = (Integer.parseInt(request.getParameter("userId")));
	    try {
	    	userService.deleteUser(userId);
	    	return new ModelAndView("Message", "message", "User deleted Successfully");
	    } catch(CustomException ex) {
	    	return new ModelAndView("error", "error", ex);
	    }
	}

}
