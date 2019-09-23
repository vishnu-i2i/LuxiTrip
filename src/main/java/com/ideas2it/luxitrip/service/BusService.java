package com.ideas2it.luxitrip.service;

import java.util.List;

import com.ideas2it.luxitrip.exception.CustomException;
import com.ideas2it.luxitrip.model.Bus;
import com.ideas2it.luxitrip.model.Seat;

public interface BusService {
	
	/**
     * Calls the insertBus method in the DAO class
     * @param: the bus to be added in the list
     * @return boolean true after successful addition
     */
	boolean createBus(Bus bus) throws CustomException;
	
    /**
     * Gets the list of buses from DAO and returns to the controller
     * @return: List of Bus objects
     */
	List<Bus> retrieveAllBuses() throws CustomException;
	
    /**
     * Assigns the addresses list to the Bus object
     * @param address of the Address type and the Bus to which the address 
     *        is to be added
     */
	void addSeat(Bus bus, Seat seat);
	
	/**
     * Gets the Bus object with the corresponding id from dao class
     * @param  Id of the object to be retrieved
     * @return Bus Object containing the bus id
     */
	public Bus retrieveBusById(int id) throws CustomException;
	
	/**
     * Calls the updateBus method in DAO class
     * @param Bus pojo Object with the new bus details 
     */
	public void updateBus(Bus bus) throws CustomException;
	
	/**
     * Calls the deleteBus method in the DAO class
     * @param: Bus Object which is to be deleted
     */
	public void deleteBus(Bus bus) throws CustomException;
}
