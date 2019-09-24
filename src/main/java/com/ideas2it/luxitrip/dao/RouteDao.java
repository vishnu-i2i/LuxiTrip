package com.ideas2it.luxitrip.dao;

import java.util.List;

import com.ideas2it.luxitrip.exception.CustomException;
import com.ideas2it.luxitrip.model.Route;

public interface RouteDao {


    /**
     * Inserts the route data entered by the admin to the route table  
     * @param Route object contains the data to be inserted into table
     * @return String id on successful addition of route to the database
     */
    int insertRoute(Route route) throws CustomException;
    
    /**
     * Retrives the list of routes from the route table
     * @return List of all the Routes from table to the service class
     */
    List<Route> getAllRoutes() throws CustomException;
    
    /**
     * Gets the route with the corresponding route id from the table and returns
     * to service
     * @param id of the route which is to be retrived
     * @return Route object with the corresponding id
     */
    public Route getRouteById(int id) throws CustomException;
    
    /**
     * Replaces the entry with matching route Id with the new data contained 
     * in the route object
     * @param Route object to be updated in database table
     */
    public void updateRoute(Route route) throws CustomException;
    
    /**
     * Deletes the route by setting the status to false
     * @param Route object which is to be deleted
     */
    public void deleteRoute(int id) throws CustomException;
}
