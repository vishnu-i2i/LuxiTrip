package com.ideas2it.luxitrip.controller;

import java.util.Set;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.ideas2it.luxitrip.exception.CustomException;
import com.ideas2it.luxitrip.model.Bus;
import com.ideas2it.luxitrip.model.Fare;
import com.ideas2it.luxitrip.model.Reservation;
import com.ideas2it.luxitrip.model.Route;
import com.ideas2it.luxitrip.model.Schedule;
import com.ideas2it.luxitrip.model.Seat;
import com.ideas2it.luxitrip.model.Stop;
import com.ideas2it.luxitrip.model.User;
import com.ideas2it.luxitrip.service.FareService;
import com.ideas2it.luxitrip.service.ReservationService;
import com.ideas2it.luxitrip.service.RouteService;
import com.ideas2it.luxitrip.service.StopService;
import com.ideas2it.luxitrip.service.UserService;

@Controller
public class ReservationController {
    @Autowired
    StopService stopService;
    
    @Autowired
    ReservationService reservationService; 
    
    @Autowired
    RouteService routeService;
    
    @Autowired
    UserService userService;
    
    @Autowired
    FareService fareService;
    
    /**
     * 
     * @param request
     * @param response
     * @return
     */
    @RequestMapping("/getSchedules")
    public ModelAndView displayBusByOriginAndDestination(HttpServletRequest request,
            HttpServletResponse response) {
        ModelAndView model = new ModelAndView("busListForUser");
        try {
            HttpSession session = request.getSession();
            Stop origin = (Stop) request.getParameter("source");
            Stop destination = (Stop) request.getParameter("destination");
            session.setAtrribute("source",source);
            session.setAtrribute("destination",destination);
            Set<Schedule> schedules = reservationService.getSchedules(origin,destination);
            for(Schedule schedule : schedules) {
                System.out.println("After");
                System.out.println(schedule.getBus());
                System.out.println("finish");
            }
            model.addObject("schedules",schedules);
        } catch(CustomException exception) {
            model = new ModelAndView("ErrorPage","error",exception);
        }
        return model;
    }
    
    @RequestMapping("/ticketReservation")
    public ModelAndView bookingTickets(HttpServletRequest request,
    HttpServletResponse response) throws ServletException, IOException {
        Reservation reservation = new Reservation();
        Fare fare = new Fare();
        try {
            System.out.println("***888888888888888888888888888888888");
            HttpSession session = request.getSession(false);
            int originId =  (int) session.getAttribute("source");
            int destId =  (int) session.getAttribute("destination");
            int amount = routeService.calculateDistances(originId, destId);
            fare.setSource(stopService.retrieveStopById(originId));
            fare.setDestination(stopService.retrieveStopById(destId));
            fare.setPrice(amount);
            fare.setStatus(true);
            fareService.createFare(fare);
            reservation.setFare(fare);
        int scheduleId = Integer.parseInt(request.getParameter("scheduleId"));
        System.out.println(scheduleId);
        Schedule schedule = reservationService.retrieveScheduleById(scheduleId);
        reservation.setSchedule(schedule);
        Bus bus = schedule.getBus();
        reservation.setBus(bus);
        System.out.println(bus);
        int numberOfSeats = Integer.parseInt(request.getParameter("numberOfSeats"));
        System.out.println(numberOfSeats);
        List<Seat> bookedSeats = new ArrayList();
        for(Seat seat : bus.getSeats()) {
            if(seat.isAvailability() == true && numberOfSeats > 0) {
                bookedSeats.add(seat);
                seat.setAvailability(false);
                numberOfSeats--;
            }
        }
        reservation.setSeats(bookedSeats);
        float total = amount * numberOfSeats;
        int userId = (int) session.getAttribute("userId");
        User user = userService.retrieveUserById(userId);
        reservation.setUser(user);
        reservation.setTotalPrice(total);
        System.out.println(reservation.getBus() + "32543333333333333335");
        System.out.println(reservation.getFare() + "***************888888");
        System.out.println(reservation.getSchedule()  + "3333333333333333" );
        System.out.println(reservation.getSeats() + "344444444444");
        System.out.println(reservation.getUser() + "3444444444");
        reservationService.bookTicktes(reservation);
        return new ModelAndView("bookingConfirmation", "reservation", reservation );
        } catch(CustomException exception) {
            return new ModelAndView("Message", "message","heellsfrgfr" );
        }
    }
}
