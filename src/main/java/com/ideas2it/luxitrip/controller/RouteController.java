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
  
  @RequestMapping("/registerRoute") 
  public ModelAndView registerRoute(HttpServletRequest request, 
          HttpServletResponse response, Route route) 
          throws IOException, ServletException { 
      try {
          route.setOrigin(stopService.displayStop
                      (Integer.parseInt(request.getParameter("origin"))));
          route.setDestination(stopService.displayStop
                      (Integer.parseInt(request.getParameter("destination"))));
          routeService.createRoute(route); return displayAllRoutes(request,response); 
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
     * 
     * @param request
     * @param response
     * @return
     * @throws IOException
     * @throws ServletException
     */
    public ModelAndView displayBusBySourceAndDestination(HttpServletRequest request, 
            HttpServletResponse response) throws IOException, ServletException {
        return null;
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
}