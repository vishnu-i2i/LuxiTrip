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
	public void updateFare(Fare fare) throws CustomException {
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
	 * Method used to delete the given fare from the table 
	 * @param fareId
	 * @return the number of affected in table in integer 
	 * @throws CustomException
	 */
	public int deleteFare(int fareId) throws CustomException {
	    Session session = sessionFactory.openSession();
		Transaction transaction = null;
    	int noOfRowAffected = 0;
    	try {
            transaction = session.beginTransaction();
    		Query query = session.createQuery("update Fare f set f.status = :status where f.id = :fareId");
            query.setBoolean("status", false);
    		query.setParameter("fareId", fareId);
    		noOfRowAffected = query.executeUpdate();
            transaction.commit();
        } catch(HibernateException ex) {
            if(null != transaction) {
                transaction.rollback();
            }
            throw new CustomException("Unable to delete the given Fare");
        } finally {
            try {
                session.close(); 
            } catch(HibernateException e) {
                throw new CustomException("Unable to close session");
            }
        }
        return noOfRowAffected;
    }
	
	/**
	 * Method to get the List of fares in the form of list 
	 * @return the fare details in list
	 * @throws CustomException
	 */
    public List<Fare> getFares() throws CustomException {
	    List<Fare> fares = new ArrayList<Fare>();
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
