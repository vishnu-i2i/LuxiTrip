package com.ideas2it.luxitrip.dao;

import java.util.List;

import com.ideas2it.luxitrip.exception.CustomException;
import com.ideas2it.luxitrip.model.Bus;

public interface BusDao {
	
	/**
     * Inserts the bus data entered by the admin to the bus table 
     * and seats of bus in seat table with bus Id 
     * @param Bus object contains the data to be inserted into table
     * @return String id on successful addition of bus to the database
     */
	int insertBus(Bus bus) throws CustomException;
	
	/**
     * Retrieves the list of buses and their addresses from the bus table
     * and address table in database
     * @return List of all the Buses from table to the service class
     */
	List<Bus> getAllBuses() throws CustomException;
	
	/**
     * Gets the bus with the corresponding bus id from the table and 
     * returns to service 
     * @param id of the bus which is to be retrieved
     * @return Bus object with the corresponding id
     */
	public Bus getBusById(int id) throws CustomException;
	
	/**
     * Replaces the entry with matching bus Id with the new data contained 
     * in the bus object
     * @param POJO object Bus to be updated in database table
     */    
    public void updateBus(Bus bus) throws CustomException;
    
    /**
     * Deletes the bus by setting the status to false
     * @param Bus object which is to be deleted
     */
    public void deleteBus(Bus bus) throws CustomException;
}
