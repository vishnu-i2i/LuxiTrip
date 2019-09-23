package com.ideas2it.luxitrip.dao.impl;

import java.util.List;

import javax.persistence.OptimisticLockException;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.LazyInitializationException;
import org.hibernate.Session;
import org.hibernate.SessionException;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ideas2it.luxitrip.dao.StopDao;
import com.ideas2it.luxitrip.exception.CustomException;
import com.ideas2it.luxitrip.model.Stop;

@Repository
public class StopDaoImpl implements StopDao {

    @Autowired
    private SessionFactory sessionFactory;
	/**
     * Method to add stop details
     * @param Stop stop - stop object with all details to save
     * @return int generated Id
     * @throws Exception - carry message for the exception
     */
	public int addStop(Stop stop) throws CustomException {
        Session session = sessionFactory.openSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            session.save(stop);
            transaction.commit();
            return stop.getId();
        } catch (LazyInitializationException UserException) {
            throw new CustomException("No session available");
        } catch (OptimisticLockException UserException) {
            throw new CustomException("server busy try after sometime");
        } catch (HibernateException UserException) {
            throw new CustomException("Details cannot be added");
        }
	    finally {
            try {
                session.close();
            } catch (SessionException UserException) {
                throw new CustomException("Session not properly closed");
            }
        }
    }
	
	/**
     * Method to retrive stop details
     * @param int stopId 
     * @return stop object 
     * @throws Exception - carry message for the exception
     */
	public Stop retriveStop(int stopId) throws CustomException {
		Session session = sessionFactory.openSession();
		Transaction transaction = null;
		try {
			transaction = session.beginTransaction();
			Stop stop = session.get(Stop.class,stopId);
			return stop;
		} catch (LazyInitializationException UserException) {
            throw new CustomException("No session available");
        } catch (OptimisticLockException UserException) {
            throw new CustomException("server busy try after sometime");
        } catch (HibernateException UserException) {
            throw new CustomException("Details cannot be added");
        }
	    finally {
            try {
                session.close();
            } catch (SessionException UserException) {
                throw new CustomException("Session not properly closed");
            }
        }
	}
	
	 /**
     * Method to delete stop details
     * @param int deleteId - Id to delete the employee details
     * @throws UserException - carry message for the exception
     */
    public void deleteStop(int deleteId) throws CustomException{
        Session session = sessionFactory.openSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            Stop stop = session.get(Stop.class, deleteId);
            session.delete(stop);
            transaction.commit();
	
	    }catch (LazyInitializationException UserException) {
            throw new CustomException("No session available");
        } catch (OptimisticLockException UserException) {
            throw new CustomException("server busy try after sometime");
        } catch (HibernateException UserException) {
            throw new CustomException("Details cannot be deleted");
        }
	    finally {
            try {
                session.close();
            } catch (SessionException UserException) {
                throw new CustomException("Session not properly closed");
            }                                
        }
    }
    
    /**
     * Method to update stop details to the database
     * @param Stop stop to update the stop details
     * @throws Exception - carry message for the exception
     */
    public void updateStop(Stop stop) throws CustomException {
	Session session = sessionFactory.openSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            session.update(stop);
            transaction.commit();
	    } catch (LazyInitializationException UserException) {
            throw new CustomException("No session available");
        } catch (OptimisticLockException UserException) {
            throw new CustomException("server busy try after sometime");
        } catch (HibernateException UserException) {
            throw new CustomException("Details cannot be updated");
        }
	    finally {
            try {
                session.close();
            } catch (SessionException UserException) {
                throw new CustomException("Session not properly closed");
            }
        }
    }
    
    /**
     * Method to get all employee details in a list
     * @return List of all employees
     * @throws UserException - carry message for the exception
     */
    public List<Stop> displayAllStop() throws CustomException {
        List<Stop> employees = null;
        Session session = sessionFactory.openSession();
        try {
            Criteria criteria = session.createCriteria(Stop.class).addOrder(Order.asc("name"));
            employees = criteria.list();
            return employees;
        } catch (LazyInitializationException UserException) {
            throw new CustomException("No session available");
        } catch (OptimisticLockException UserException) {
            throw new CustomException("server busy try after sometime");
        } catch (HibernateException UserException) {
            throw new CustomException("Details cannot be display");
        }
	    finally {
	        try {
                session.close();
            } catch (SessionException UserException) {
                throw new CustomException("Session not properly closed");
            }
        }
    }

}
