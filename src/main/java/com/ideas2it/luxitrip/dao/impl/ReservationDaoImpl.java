package com.ideas2it.luxitrip.dao.impl;

import java.util.List;

import javax.persistence.PersistenceException;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ideas2it.luxitrip.dao.ReservationDao;
import com.ideas2it.luxitrip.exception.CustomException;
import com.ideas2it.luxitrip.model.Bus;
import com.ideas2it.luxitrip.model.Reservation;
import com.ideas2it.luxitrip.model.Schedule;
import com.ideas2it.luxitrip.model.Stop;
import com.ideas2it.luxitrip.model.User;

@Repository
public class ReservationDaoImpl  implements ReservationDao{
    
    @Autowired
    SessionFactory sessionFactory;

    public List<Bus> getBusesByOrigin(Stop origin) 
            throws CustomException{
        Session session = sessionFactory.openSession();
        try {
            return session.createQuery("Select Bus.id from Schedule s " 
                    + " INNER JOIN Midway m where m.stop = :stop",Bus.class)
                    .setParameter("stop",origin)
                    .list();
        } catch (HibernateException exception) {
            throw new CustomException("No buses available" + exception);
        } finally {
            try {
                session.close();
            } catch (Exception e) {
                System.out.println(e);
            }
        }
    }
    
    public List<Bus> getBusesByDestination(Stop destination) 
            throws CustomException{
        Session session = sessionFactory.openSession();
        try {
            return session.createQuery("Select Bus from Schedule" +
                    "INNER JOIN Midway m where m.Stop = :stop",Bus.class)
                    .setParameter("stop",destination)
                    .list();
        } catch (HibernateException exception) {
            throw new CustomException("No buses available" + exception);
        } finally {
            try {
                session.close();
            } catch (Exception e) {
                System.out.println(e);
            }
        }
    }
     
    /**
     * Method used to get the Reservation detail by using the userId  
     * @param Id
     * @return the user detail 
     * @throws CustomException
     */
    public Reservation getReservationById(int id) throws CustomException {
        Session session = sessionFactory.openSession();
        try {
            return (session.get(Reservation.class, id)); 
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
    
    public Schedule getScheduleById(int id) throws CustomException {
        Session session = sessionFactory.openSession();
        try {
            return (session.get(Schedule.class, id)); 
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
    
    
    public void insertBooking(Reservation reservation)throws CustomException {
        Session session = sessionFactory.openSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            session.save(reservation);
            transaction.commit();
        }  catch (HibernateException ex) {
            throw new CustomException("Unable to book reservation" + ex);
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
}