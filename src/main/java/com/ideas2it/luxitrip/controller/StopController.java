package com.ideas2it.luxitrip.controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.bind.annotation.ModelAttribute;   

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
    public ModelAndView createStop(HttpServletRequest request, 
            HttpServletResponse response, @ModelAttribute("stop")Stop stop) throws ServletException, IOException {
        try {
            stopService.createStop(stop);
            return new ModelAndView("Message", "message", "Stop Added Successfully");
        } catch(CustomException e) {
           logger.error(e.getMessage());
           return new ModelAndView("Message", "message", e.getMessage());
        } 
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
        try {
            return new ModelAndView("displayStopDetails", "stop", 
                    stopService.retrieveStopById(Integer.parseInt(request.getParameter("id"))));
        } catch(CustomException e) {
            logger.error(e.getMessage());
            return new ModelAndView("Message", "message", e.getMessage());
        }
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
        try {
            stopService.deleteStop(Integer.parseInt(request.getParameter("id")));
            return new ModelAndView("Message", "message", "Stop deleted Successfully");
        } catch(CustomException e) {
            logger.error(e.getMessage());
            return new ModelAndView("Message", "message", e.getMessage());
        } 
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
        try {
            return new ModelAndView("AllEmployees", "stops", stopService.retrieveAllStops());
        } catch(CustomException e) {
            logger.error(e.getMessage());
            return new ModelAndView("Message", "message", e.getMessage());
       }
    } 
}
