package com.ideas2it.luxitrip.dao;

import java.util.List;

import com.ideas2it.luxitrip.exception.CustomException;
import com.ideas2it.luxitrip.model.Stop;

public interface StopDao {
	/**
     * Method to add stop details
     * @param Stop stop - stop object with all details to save
     * @return int generated Id
     * @throws Exception - carry message for the exception
     */
	int addStop(Stop stop) throws CustomException ;
	
	/**
     * Method to retrive stop details
     * @param int stopId 
     * @return stop object 
     * @throws Exception - carry message for the exception
     */
	public Stop getStopById(int id) throws CustomException;
	
	 /**
     * Method to delete stop details
     * @param int deleteId - Id to delete the employee details
     * @throws UserException - carry message for the exception
     */
    void deleteStop(int deleteId) throws CustomException ;
    
    /**
     * Method to update stop details to the database
     * @param Stop stop to update the stop details
     * @throws Exception - carry message for the exception
     */
    public void updateStop(Stop stop) throws CustomException ;
	
    /**
     * Method to get all employee details in a list
     * @return List of all employees
     * @throws UserException - carry message for the exception
     */
    public List<Stop> getAllStops() throws CustomException;
}
