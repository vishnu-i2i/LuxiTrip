package com.ideas2it.luxitrip.service;

import java.util.List;

import com.ideas2it.luxitrip.exception.CustomException;
import com.ideas2it.luxitrip.model.Route;

public interface RouteService {
    
    /**
     * Calls the insertRoute method in the DAO class
     * @param: the route to be added in the list
     * @return boolean true after successful addition
     */
    boolean createRoute(Route route) throws CustomException;
    
    /**
     * Gets the list of routes from DAO and returns to the controller
     * @return: List of Route objects
     */
    List<Route> retrieveAllRoutes() throws CustomException;
    
    /**
     * Gets the Route object with the corresponding id from dao class
     * @param  Id of the object to be retrieved
     * @return Route Object containing the route id
     */
    public Route retrieveRouteById(int id) throws CustomException;
    
    /**
     * Calls the updateRoute method in DAO class
     * @param Route pojo Object with the new route details 
     */
    public void updateRoute(Route route) throws CustomException;
    
    /**
     * Calls the deleteRoute method in the DAO class
     * @param: Route Object which is to be deleted
     */
    public void deleteRoute(int id) throws CustomException;

}
