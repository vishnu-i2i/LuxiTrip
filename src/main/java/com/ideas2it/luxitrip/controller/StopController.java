package com.ideas2it.luxitrip.controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.ideas2it.luxitrip.exception.CustomException;
import com.ideas2it.luxitrip.model.Stop;
import com.ideas2it.luxitrip.service.StopService;
@Controller
public class StopController {
	
    private static final Logger logger = Logger.getLogger(StopController.class);
    
    @Autowired
    private StopService stopService;
	
    /**
     * Method to add stop details
     * @param request-To get request from an user
     * @param response-To give a response about confirmation
     * @throws IOException - Error to handle for the given data
     * @throws ServletException - Error in request from and response for an user
     */
    @RequestMapping("/addStop")
    public ModelAndView addStop(HttpServletRequest request,
            HttpServletResponse response, Stop stop) throws ServletException, IOException {
        ModelAndView model = new ModelAndView("Message");
        try {
            stopService.addStop(stop);
            int id = stop.getId(); 
            String message = "Stop ID : " + id;
            model.addObject("message", message);
            return model;
        } catch(CustomException e) {
           String message = e.getMessage();
           logger.error(message);
           request.getSession().setAttribute("message", message);
           request.getRequestDispatcher("Message.jsp").forward(request,
                   response);
        } 
        return model;
    } 
	
	/**
     * Method to display the Particular stop details
     * @param request-To get request from an user
     * @param response-To give a response about confirmation
     * @throws IOException - Error to handle for the given data
     * @throws ServletException - Error in request from and response for an user
     */
    @RequestMapping("/displayStop")
    public ModelAndView displayStop(HttpServletRequest request,
        HttpServletResponse response) throws ServletException, IOException {
        Stop stop = new Stop();
        String id = request.getParameter("id");
        ModelAndView model = new ModelAndView("displayStopDetails");
        try {
            stop = stopService.displayStop(Integer.parseInt(id));
            model.addObject("stop",stop);
            return model;
        } catch(CustomException e) {
           String message = e.getMessage();
           logger.error(message);
           request.getSession().setAttribute("message", message);
           request.getRequestDispatcher("Message.jsp").forward(request,
                   response);
        }
        return model;
    }
    
    /**
     * Method to delete stop details
     * @param request-To get request from an user
     * @param response-To give a response about confirmation
     * @throws IOException - Error to handle for the given data
     * @throws ServletException - Error in request from and response for an user
     */
    @RequestMapping("/deleteStop")
    public ModelAndView deleteStop(HttpServletRequest request, 
            HttpServletResponse response) throws ServletException, IOException {
        ModelAndView model = new ModelAndView("Message");
        try {
            String id = request.getParameter("id");
            stopService.deleteStop(Integer.parseInt(id));
            String message = "Stop " + id + " Deleted";
            model.addObject("message",message);
            return model;
        } catch(CustomException e) {
            String message = e.getMessage();
            logger.error(message);
            request.getSession().setAttribute("message", message);
            request.getRequestDispatcher("Message.jsp").forward(request,
                   response);
        }
        return model; 
    }
    
    /**
     * Method to display all stop details
     * @param request-To get request from an user
     * @param response-To give a response about confirmation
     * @throws IOException - Error to handle for the given data
     * @throws ServletException - Error in request from and response for an user
     */
    @RequestMapping("/displayAllStop")
    public ModelAndView displayAllStop(HttpServletRequest request, 
            HttpServletResponse response) throws ServletException, IOException {
        ModelAndView model = new ModelAndView("AllEmployees");
        try {
            List<Stop> allEmployees = stopService.displayAllStops();
            model.addObject("allEmployeeList",allEmployees);
            return model;
        } catch(CustomException e) {
            String message = e.getMessage();
            logger.error(message);
            request.getSession().setAttribute("message", message);
            request.getRequestDispatcher("Message.jsp").forward(request,
                   response);
       }
       return model;
    } 
}
