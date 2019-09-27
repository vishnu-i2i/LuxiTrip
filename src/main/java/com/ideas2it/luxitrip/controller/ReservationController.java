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
import com.ideas2it.luxitrip.model.Reservation;
import com.ideas2it.luxitrip.model.Schedule;
import com.ideas2it.luxitrip.model.Seat;
import com.ideas2it.luxitrip.model.Stop;
import com.ideas2it.luxitrip.service.ReservationService;
import com.ideas2it.luxitrip.service.RouteService;

@Controller
public class ReservationController {
    
    @Autowired
    ReservationService reservationService; 
    
    @Autowired
    RouteService routeService;
    
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
            Stop origin =  reservationService.retrieveStopById(Integer.parseInt(request.getParameter("source")));
            Stop destination =  reservationService.retrieveStopById(Integer.parseInt(request.getParameter("destination")));
            session.setAttribute("source", origin.getId());
            session.setAttribute("destination", destination.getId());
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
        try {
            HttpSession session = request.getSession(false);
            int originId =  (int) session.getAttribute("source");
            int destId =  (int) session.getAttribute("destination");
             int amount = routeService.calculateDistances(originId, destId);
            reservation.setFare(reservationService.calculatePrice(originId, destId));
            Schedule schedule = reservationService.retrieveScheduleById(Integer.parseInt(request.getParameter("scheduleId")));
            reservation.setSchedule(schedule);
            Bus bus = schedule.getBus();
            reservation.setBus(bus);
            int numberOfSeats = Integer.parseInt(request.getParameter("numberOfSeats"));
            List<Seat> bookedSeats = new ArrayList();
            for(Seat seat : bus.getSeats()) {
                if(seat.isAvailability() == true && numberOfSeats > 0) {
                    bookedSeats.add(seat);
                    seat.setAvailability(true);
                    numberOfSeats--;
                }
            }
            reservation.setSeats(bookedSeats);
            float price = numberOfSeats * amount;
            
            float totalPrice = reservationService.calculateTotalPrice(originId, destId, numberOfSeats);
            reservation.setUser(reservationService.
                    retrieveUserById((int) session.getAttribute("userId")));
            reservation.setTotalPrice(price);
            reservationService.bookTicktes(reservation);
            return new ModelAndView("bookingConfirmation", "reservation", reservation );
        } catch(CustomException exception) {
            return new ModelAndView("Message", "message"," Not booked" );
        }
    }
}
