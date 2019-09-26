package com.ideas2it.luxitrip.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException; 
import org.hibernate.Session; 
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ideas2it.luxitrip.dao.RouteDao;
import com.ideas2it.luxitrip.exception.CustomException;
import com.ideas2it.luxitrip.model.Route;
import com.ideas2it.luxitrip.model.Seat;

@Repository
public class RouteDaoImpl implements RouteDao{
    
    @Autowired
    private SessionFactory sessionFactory;
    
    public int insertRoute(Route route) throws CustomException {
        int routeId = 1;
        Session session = sessionFactory.openSession();
        System.out.println(session);
        Transaction transact = null;
        List<Route> routes = new ArrayList<>();
        try {
            transact = session.beginTransaction();
            routeId = (int)session.save(route);
            routes.add(route);
            transact.commit();
        } catch (HibernateException exception) {
            if (transact!=null) {
                transact.rollback();
            }
            throw new CustomException("Unable to add Route " + exception);
        } finally {
            try {
                session.close();
            } catch (Exception e) {
                System.out.println(e);
            } 
        }
        return routeId;
    }
    
    
    public List<Route> getAllRoutes() throws CustomException {
        Session session = sessionFactory.openSession();
        try {
            List routes = session.createQuery("FROM Route").list(); 
            return routes;
        } catch (HibernateException exception) {
            throw new CustomException("Unable to get Route" + exception);
        } finally {
            try {
                session.close();
            } catch (Exception e) {
                System.out.println(e);
            }
        }
    }
    
    public Route getRouteById(int id) throws CustomException {
        Session session = sessionFactory.openSession();
        Route route = null;
        try {
            route = session.get(Route.class , id);
        } catch (HibernateException exception) {
            throw new CustomException("Unable to get Route" + exception);
        } finally {
            try {
                session.close();
            } catch (Exception e) {
                System.out.println(e);
            }
        }
        return route;
    }
    
    /**
     * Replaces the entry with matching route Id with the new data contained 
     * in the route object
     * @param POJO object Route to be updated in database table
     */    
    public void updateRoute(Route route) throws CustomException{
        Session session = sessionFactory.openSession();
        Transaction transact = null;
        try {
            transact = session.beginTransaction();
            session.update(route); 
            transact.commit();
        } catch (HibernateException exception) {
            if (transact!=null) {
                transact.rollback();
            }
            throw new CustomException("Unable to update Route" + exception);
        } finally {
            try {
                session.close();
            } catch (Exception e) {
                System.out.println(e);
            } 
        }
    }
    
    /**
     * Deletes the route by setting the status to false
     * @param Route object which is to be deleted
     */
    public void deleteRoute(int id) throws CustomException{
        Session session = sessionFactory.openSession();
        Transaction transact = null;
        try {
            transact = session.beginTransaction();
            session.update(id);
            transact.commit();
        } catch (HibernateException exception) {
            if (transact!=null) {
                transact.rollback();
            }
            throw new CustomException("Unable to Delete Route" + exception);
        } finally {
            try {
                session.close();
            } catch (Exception e) {
                System.out.println(e);
            }
        }
    }   

}
