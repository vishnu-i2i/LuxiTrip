package com.ideas2it.luxitrip.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ideas2it.luxitrip.dao.RouteDao;
import com.ideas2it.luxitrip.exception.CustomException;
import com.ideas2it.luxitrip.model.Midway;
import com.ideas2it.luxitrip.model.Route;
import com.ideas2it.luxitrip.model.Schedule;
import com.ideas2it.luxitrip.service.RouteService;

@Service
public class RouteServiceImpl implements RouteService{

    @Autowired
    private RouteDao routeDao;
    
    public boolean createRoute(Route route) throws CustomException {
        return (routeDao.insertRoute(route) == (route.getId()));
    }
    
    public List<Route> retrieveAllRoutes() throws CustomException{
        return routeDao.getAllRoutes();
    }
    
    public Route retrieveRouteById(int id) throws CustomException{
        return routeDao.getRouteById(id);
    }
    
    public void deleteRoute(int id) throws CustomException {
        routeDao.deleteRoute(id);
    }
     
    /**
     * Method used to calculate the Price for the travelling form souce to destination 
     * @param 
     */
    public int calculateDistances(int sourceId, int destinationId) throws CustomException {
        System.out.println(sourceId + "Madurai");
        System.out.println(destinationId + "chennai");
        int sourceDistance = 0;
        int destDistance = 0;
        List<Route> routes = routeDao.getAllRoutes();
        for(Route route : routes) {
            for(Schedule schedule : route.getSchedule()) {
                for(Midway midway : schedule.getMidway()) {
                    if(midway.getStop().getId() == sourceId) {
                        sourceDistance = midway.getDistance();
                    } else if(midway.getStop().getId() == destinationId) {
                        destDistance = midway.getDistance();
                    }
                }
            }
        }
        return (200 + (destDistance - sourceDistance ) * 2);
    }
}
