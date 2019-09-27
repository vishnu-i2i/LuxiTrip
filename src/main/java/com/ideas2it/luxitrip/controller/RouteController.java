package com.ideas2it.luxitrip.controller;


import java.io.IOException; 
import java.util.List;

import javax.servlet.ServletException; 
import javax.servlet.http.HttpServletRequest; 
import javax.servlet.http.HttpServletResponse; 
import javax.servlet.http.HttpSession;
  
import org.springframework.beans.factory.annotation.Autowired; 
import org.springframework.stereotype.Controller; 
import org.springframework.web.bind.annotation.RequestMapping; 
import org.springframework.web.servlet.ModelAndView;
  
import com.ideas2it.luxitrip.exception.CustomException; 
import com.ideas2it.luxitrip.model.Route; 
import com.ideas2it.luxitrip.model.Route;
import com.ideas2it.luxitrip.service.RouteService; 
import com.ideas2it.luxitrip.service.StopService;
  
@Controller 
public class RouteController {
  
  @Autowired 
  private RouteService routeService;
  
  @Autowired 
  private StopService stopService;
  
  /**
   * Method used to register the route and its details into the database
   * @param request
   * @param response
   * @param route
   * @return the list of routes
   * @throws IOException
   * @throws ServletException
   */
  @RequestMapping("/registerRoute") 
  public ModelAndView registerRoute(HttpServletRequest request, 
          HttpServletResponse response, Route route) 
          throws IOException, ServletException { 
      try {
          route.setOrigin(stopService.retrieveStopById
                      (Integer.parseInt(request.getParameter("origin"))));
          route.setDestination(stopService.retrieveStopById
                      (Integer.parseInt(request.getParameter("destination"))));
          routeService.createRoute(route); 
          return displayAllRoutes(request,response); 
      } catch (CustomException exception) { 
          return (new ModelAndView("ErrorPage","error",exception)); 
      } 
  }
  
    @RequestMapping("/fetchRoute") 
    public ModelAndView fetchRoute(HttpServletRequest request, 
            HttpServletResponse response) throws IOException, ServletException { 
        ModelAndView model = new ModelAndView("AddRoute"); 
        try { 
            Route route = routeService.retrieveRouteById(
                    Integer.parseInt(request.getParameter("id")));
            HttpSession session = request.getSession(); 
            session.setAttribute("route",route); 
        } catch (CustomException exception) { 
            model = new ModelAndView("ErrorPage","error",exception); 
        } return model; 
    }
  
 
     /**
      * Gets the list of routes from server and forwards the request, response
      * @param request contains the list of routes data in
      * @param response
      * @return
      * @throws IOException
      * @throws ServletException
      */
    @RequestMapping("displayAllRoutes") 
    public ModelAndView displayAllRoutes(HttpServletRequest request, 
            HttpServletResponse response) throws IOException, ServletException { 
        ModelAndView model = new ModelAndView("DisplayBuses"); 
        try { List<Route> routes = routeService.retrieveAllRoutes(); 
            model.addObject("routes", routes); 
        } catch (CustomException exception) { 
            model = new ModelAndView("ErrorPage","error",exception); 
        }
        return model; 
    }
 
    /** 
     * Soft deletes the Route from the list of routes by geting the object from the
     * entered route id
     */    
    @RequestMapping("deleteRoute") 
    public ModelAndView deleteRoute(HttpServletRequest request, 
           HttpServletResponse response) throws IOException, ServletException { 
       try {
           routeService.deleteRoute(Integer.parseInt(request.getParameter("id")));
           return displayAllRoutes(request,response); 
       } catch (CustomException exception) { 
           return (new ModelAndView("ErrorPage","error",exception)); 
       } 
    }
    
    /**
     * Method used to calculate the distance between the source and destinaion
     * @param request
     * @param response
     * @return
     * @throws ServletException
     * @throws IOException
     */
    @RequestMapping("/calculateDistances")
    public ModelAndView fareCalculation(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {
        try {
            routeService.calculateDistances(Integer.parseInt(request.getParameter("source")), 
                    Integer.parseInt(request.getParameter("destination")));
            return new ModelAndView("Message", "message", "The price details");
        } catch(CustomException ex) {
            return new ModelAndView("Message", "message", "error");
        }
    }
}