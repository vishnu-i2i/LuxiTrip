package com.ideas2it.luxitrip.dao.impl;

import java.util.List;

import javax.persistence.PersistenceException;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ideas2it.luxitrip.dao.UserDao;
import com.ideas2it.luxitrip.exception.CustomException;
import com.ideas2it.luxitrip.model.User;


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
        }  catch (HibernateException ex) {
            throw new CustomException("Unable to add " + user.getId() + " value" + ex);
        } catch(PersistenceException ex) {
            throw new CustomException("UserName is already exists please try another name");
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
	    Session session = sessionFactory.openSession();
	    try{    
	        return (session.createQuery("from User", User.class).list());
	    } catch(HibernateException ex) {
	        throw new CustomException("Unable to get all users");
	    } finally {
	        try {
	            session.close(); 
	        } catch(HibernateException ex) {
	            throw new CustomException("Unable to close session");
	        }
	    }        
	}
	 
    /**
     * Method used to get the User detail by using the userId  
     * @param userId
     * @return the user detail 
     * @throws CustomException
     */
    public User getUserById(int id) throws CustomException {
	    Session session = sessionFactory.openSession();
    	try {
            return (session.get(User.class, id)); 
        } catch(HibernateException ex) {
            throw new CustomException("The user is not registered");
        } finally {
            try {
                session.close(); 
            } catch(HibernateException ex) {
                throw new CustomException("Unable to close session");
            }
        }       
    }

    /**
     * Method used to get the User detail by using the userName 
     * @param userName
     * @return the user detail 
     * @throws CustomException
     */
    public User getUserByName(String name) throws CustomException {
        Session session = sessionFactory.openSession();
        User user = null;
        try {
            Query query = session.createQuery("from User u where u.name = : userName");
            query.setParameter("userName", name);
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
}
