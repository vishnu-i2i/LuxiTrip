package com.ideas2it.luxitrip.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ideas2it.luxitrip.dao.RouteDao;
import com.ideas2it.luxitrip.exception.CustomException;
import com.ideas2it.luxitrip.model.Route;
import com.ideas2it.luxitrip.model.Seat;
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
    
    public void updateRoute(Route route) throws CustomException {
        routeDao.updateRoute(route);
    }
    
    public void deleteRoute(int id) throws CustomException {
        routeDao.deleteRoute(id);
    }
}
