package com.ideas2it.luxitrip.service.impl;

import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ideas2it.luxitrip.dao.ReservationDao;
import com.ideas2it.luxitrip.exception.CustomException;
import com.ideas2it.luxitrip.model.Bus;
import com.ideas2it.luxitrip.model.Fare;
import com.ideas2it.luxitrip.model.Midway;
import com.ideas2it.luxitrip.model.Reservation;
import com.ideas2it.luxitrip.model.Route;
import com.ideas2it.luxitrip.model.Schedule;
import com.ideas2it.luxitrip.model.Stop;
import com.ideas2it.luxitrip.model.User;
import com.ideas2it.luxitrip.service.FareService;
import com.ideas2it.luxitrip.service.ReservationService;
import com.ideas2it.luxitrip.service.RouteService;
import com.ideas2it.luxitrip.service.StopService;
import com.ideas2it.luxitrip.service.UserService;

@Service
public class ReservationServiceImpl implements ReservationService{
    
    @Autowired
    ReservationDao reservationDao;
    
    @Autowired
    RouteService routeService;
    
    @Autowired
    StopService stopService;
    
    @Autowired
    FareService fareService;
    
    @Autowired
    UserService userService;
    
    public Set<Bus> getBusesByOriginAndDestination(Stop origin,Stop destination)
            throws CustomException{
        Collection<Bus> originBuses = reservationDao.getBusesByOrigin(origin);
        Collection<Bus> destinationBuses = reservationDao.getBusesByDestination(destination);
        originBuses.addAll(destinationBuses);
        return (Set<Bus>) originBuses;
    }
    
    public Set<Schedule> getSchedules(Stop origin,Stop destination) 
            throws CustomException{
        Set<Schedule> schedules = new HashSet<>();
        List<Route> routes = routeService.retrieveAllRoutes();
        for (Route route : routes) {
            System.out.println(route);
            for (Schedule schedule : route.getSchedule()) {
               System.out.println(schedule);
                for (Midway midway : schedule.getMidway()) {
                    System.out.println(midway);
                    if(origin.equals(midway.getStop()) 
                            || destination.equals(midway.getStop())) {
                            schedules.add(schedule);
                            System.out.println(schedule);
                     }
                     schedules.add(schedule);
                }   
            }
        }
        return schedules;
    }
    
    public Schedule retrieveScheduleById(int id) throws CustomException {
        return reservationDao.getScheduleById(id);
    }
    
    public void bookTicktes(Reservation reservation) throws CustomException {
        reservationDao.insertBooking(reservation);
    }
    
    public Fare calculatePrice(int originId, int destinationId) throws CustomException {
        Fare fare = new Fare();
        int amount = routeService.calculateDistances(originId, destinationId);
        fare.setSource(stopService.retrieveStopById(originId));
        fare.setDestination(stopService.retrieveStopById(destinationId));
        fare.setPrice(amount);
        fare.setStatus(true);
        fareService.createFare(fare);
        return fare;
    }
    
    public float calculateTotalPrice(int originId, int destinationId, int numberOfSeats) throws CustomException {
        return (numberOfSeats * routeService.calculateDistances(originId, destinationId));
    }
    
    public Stop retrieveStopById(int id) throws CustomException {
        return stopService.retrieveStopById(id);
    }
    
    public User retrieveUserById(int id) throws CustomException {
        return userService.retrieveUserById(id);
    }
}