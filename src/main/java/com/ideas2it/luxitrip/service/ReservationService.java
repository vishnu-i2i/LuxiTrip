package com.ideas2it.luxitrip.service;

import java.util.Set;

import com.ideas2it.luxitrip.exception.CustomException;
import com.ideas2it.luxitrip.model.Bus;
import com.ideas2it.luxitrip.model.Fare;
import com.ideas2it.luxitrip.model.Reservation;
import com.ideas2it.luxitrip.model.Schedule;
import com.ideas2it.luxitrip.model.Stop;
import com.ideas2it.luxitrip.model.User;

public interface ReservationService {
    
    Set<Bus> getBusesByOriginAndDestination(Stop origin,Stop destination)
            throws CustomException;

    Set<Schedule> getSchedules(Stop origin,Stop destination) throws CustomException;
    
    Schedule retrieveScheduleById(int id) throws CustomException;
    
    void bookTicktes(Reservation reservation) throws CustomException;
    Fare calculatePrice(int originId, int destId) throws CustomException;
    float calculateTotalPrice(int originId, int destinationId, int numberOfSeats) throws CustomException ;
    Stop retrieveStopById(int id) throws CustomException;
    User retrieveUserById(int id) throws CustomException;
}
