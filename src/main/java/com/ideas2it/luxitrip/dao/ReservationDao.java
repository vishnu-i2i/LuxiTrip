package com.ideas2it.luxitrip.dao;

import java.util.List;

import com.ideas2it.luxitrip.exception.CustomException;
import com.ideas2it.luxitrip.model.Bus;
<<<<<<< HEAD
=======
import com.ideas2it.luxitrip.model.Reservation;
import com.ideas2it.luxitrip.model.Schedule;
>>>>>>> feature-
import com.ideas2it.luxitrip.model.Stop;

public interface ReservationDao {
    List<Bus> getBusesByOrigin(Stop origin) 
            throws CustomException;
    
    List<Bus> getBusesByDestination(Stop destination) 
            throws CustomException;

    Reservation getReservationById(int id) throws CustomException;
    
    Schedule getScheduleById(int id) throws CustomException;
    
    void insertBooking(Reservation reservation)throws CustomException;
}
