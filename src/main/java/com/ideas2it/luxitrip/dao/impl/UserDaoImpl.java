package com.ideas2it.luxitrip.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;    
import org.hibernate.Session;    
import org.hibernate.SessionFactory;    
import org.hibernate.Transaction;  
import org.hibernate.HibernateException;
import org.springframework.stereotype.Repository;
import org.hibernate.Query;

import com.ideas2it.luxitrip.model.User;
import com.ideas2it.luxitrip.exception.CustomException;
import com.ideas2it.luxitrip.dao.UserDao;


@Repository
public class UserDaoImpl implements UserDao {

    @Autowired
    private SessionFactory sessionFactory;

	/**
	 * Method used to register the userDetail from user into the database 
	 * @param user
	 * @throws CustomException
	 */
	public void insertUser(User user)throws CustomException {
	    Session session = sessionFactory.openSession();
	    Transaction transaction = null;
	    try {
            transaction = session.beginTransaction();
            session.save(user);
            transaction.commit();
        } catch (HibernateException ex) {
            throw new CustomException("Unable to add " + user.getId() + " value" + ex);
        } finally {
            try {
                session.close(); 
            } catch(Exception ex) {
                throw new CustomException("Unable to close session");
            }
        }
    } 
	
	/**
	 * Method used to update the user value in the userId from user into the database 
	 * @param user
	 * @throws CustomException
	 */
	public void updateUser(User user)throws CustomException {
	    Session session = sessionFactory.openSession();
		Transaction transaction = null;
		try {
		    transaction = session.beginTransaction();
		    session.saveOrUpdate(user);
		    transaction.commit();
		} catch(HibernateException ex) {
			throw new CustomException("Unable to update" + user.getId() + "values");
		} finally {
			try {
				session.close();
			} catch(Exception ex) {
				throw new CustomException("Unable to close session");
			}
		}
	}
	
	/** 
	 * Method used to get the List of users from the database
	 * @throws CustomException
	 */
    public List<User> getUsers() throws CustomException {
	    List<User> users = new ArrayList<User>();
	    Session session = sessionFactory.openSession();
	    try{    
	        Query query = session.createQuery("from User");
	        users = query.list();
	    } catch(HibernateException ex) {
	        throw new CustomException("Unable to get all users");
	    } finally {
	        try {
	            session.close(); 
	        } catch(HibernateException ex) {
	            throw new CustomException("Unable to close session");
	        }
	    }
	    return users;        
	}
	 
    /**
     * Method used to get the User detail by using the userId  
     * @param userId
     * @return the user detail 
     * @throws CustomException
     */
    public User getUserById(int id) throws CustomException {
        User user = null;
	    Session session = sessionFactory.openSession();
    	try {
            user = (User) session.get(User.class, id); 
        } catch(HibernateException ex) {
            throw new CustomException("The user is not registered");
        } finally {
            try {
                session.close(); 
            } catch(HibernateException ex) {
                throw new CustomException("Unable to close session");
            }
        }
        return user;        
    }

    /**
     * Method used to get the User detail by using the userName 
     * @param userName
     * @return the user detail 
     * @throws CustomException
     */
    public User getUserByName(String userName) throws CustomException {
        User user = null;
        Session session = sessionFactory.openSession();
        try {
            Query query = session.createQuery("from User u where u.name = : userName");
            query.setParameter("userName", userName);
            user = (User) query.uniqueResult();
        } catch(HibernateException ex) {
            throw new CustomException("The user is not registered");
        } finally {
            try {
                session.close();
            } catch(HibernateException ex) {
                throw new CustomException("unable to close Session");
            }
        }
        return user;
    }
    
    /**
     * Method used to soft delete the User detail from the database  
     * @param userId
     * @return the number of affected
     * @throws CustomException
     */
    public int deleteUser(int userId) throws CustomException {
	    Session session = sessionFactory.openSession();
		Transaction transaction = null;
    	int noOfRowAffected = 0;
    	try {
            transaction = session.beginTransaction();
    		Query query = session.createQuery("update User u set u.status = :status where u.id = :userId");
            query.setBoolean("status", false);
    		query.setParameter("userId", userId);
    		noOfRowAffected = query.executeUpdate();
            transaction.commit();
        } catch(HibernateException ex) {
            if(null != transaction) {
                transaction.rollback();
            }
            throw new CustomException("Unable to delete the given User");
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
     * Method used to count the number of users in the database 
     * @return the number of Users
     * @throws CustomException
     */
    public long countUser() throws CustomException {
	    Session session = sessionFactory.openSession();
    	Transaction transaction = null;
    	long count = 0L;
    	try {
            transaction = session.beginTransaction();
    		Query query = session.createQuery("select count(u.id) from User u ");
            count = (Long) query.iterate().next();
        } catch(HibernateException ex) {
            throw new CustomException("Unable to count User");
        } finally {
            try {
                session.close(); 
            } catch(HibernateException e) {
                throw new CustomException("Unable to close session");
            }
        }
        return count;        
    }
}