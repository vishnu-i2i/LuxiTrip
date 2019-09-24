package com.ideas2it.luxitrip.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;    
import org.hibernate.Session;    
import org.hibernate.SessionFactory;    
import org.hibernate.Transaction;
import org.hibernate.HibernateException;
import org.springframework.stereotype.Repository;

import com.ideas2it.luxitrip.dao.FareDao;
import com.ideas2it.luxitrip.exception.CustomException;
import com.ideas2it.luxitrip.model.Fare;

@Repository
public class FareDaoImpl implements FareDao {
    
    @Autowired 
    private SessionFactory sessionFactory;
	
    /**
     * Method used to insert the fare and its details into the database
     * @param fare
     * @throws CustomException
     */
    public void insertFare(Fare fare)throws CustomException {
        Session session = sessionFactory.openSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            session.save(fare);
            transaction.commit();
        } catch (HibernateException ex) {
            throw new CustomException("Unable to add " + fare.getId() + " value" + ex);
        } finally {
            try {
                session.close(); 
            } catch(Exception ex) {
                throw new CustomException("Unable to close session");
            }
        }
    } 

	/**
	 * Method used to update the detail of fare in the database 
	 * @param fare
	 * @throws CustomException
	 */
	public void updateFare(Fare fare)throws CustomException {
	    Session session = sessionFactory.openSession();
		Transaction transaction = null;
		try {
		    transaction = session.beginTransaction();
		    session.saveOrUpdate(fare);
		    transaction.commit();
		} catch(HibernateException ex) {
			throw new CustomException("Unable to update" + fare.getId() + "values");
		} finally {
			try {
				session.close();
			} catch(Exception ex) {
				throw new CustomException("Unable to close session");
			}
		}
	}
	
	/**
	 * Method to get the List of fares in the form of list 
	 * @return the fare details in list
	 * @throws CustomException
	 */
    public List<Fare> getFares() throws CustomException {
		Session session = sessionFactory.openSession();
		try{    
		    return (session.createQuery("from Fare", Fare.class).list());
		} catch(HibernateException ex) {
		    throw new CustomException("Unable to get all fares");
		} finally {
		    try {
		        session.close(); 
		    } catch(HibernateException ex) {
		        throw new CustomException("Unable to close session");
		    }
		}       
    }
    
    /**
     * Method used to get the fare detail by using the specific fare id
     * @param id
     * @return the fare detail
     * @throws CustomException
     */
    public Fare getFareById(int id) throws CustomException {
	    Session session = sessionFactory.openSession();
    	try {
    	    return (session.get(Fare.class, id));
        } catch(HibernateException ex) {
            throw new CustomException("The Fare is not registered");
        } finally {
            try {
                session.close(); 
            } catch(HibernateException ex) {
                throw new CustomException("Unable to close session");
            }
        }       
    }
    
}
