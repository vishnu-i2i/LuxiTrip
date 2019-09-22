package com.ideas2it.luxitrip.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ideas2it.luxitrip.dao.impl.BusDaoImpl;
import com.ideas2it.luxitrip.exception.CustomException;
import com.ideas2it.luxitrip.model.Bus;
import com.ideas2it.luxitrip.model.Seat;

@Service
public class BusServiceImpl {
	@Autowired
	private BusDaoImpl busDao = new BusDaoImpl();
	
	public boolean createBus(Bus bus) throws CustomException {
        return (busDao.insertBus(bus) == (bus.getId()));
    }
	
	public List<Bus> retrieveAllBuses() throws CustomException{
        return busDao.getAllBuses();
    }
	
    public void addSeat(Bus bus, Seat seat) {
        List<Seat> seats = bus.getSeats();
        seats.add(seat);
        bus.setSeats(seats);
    }
    
    public Bus retrieveBusById(int id) throws CustomException{
        return busDao.getBusById(id);
    }
    
    public void updateBus(Bus bus) throws CustomException {
        busDao.updateBus(bus);
    }
    
    public void deleteBus(Bus bus) throws CustomException {
        busDao.deleteBus(bus);
    }
}