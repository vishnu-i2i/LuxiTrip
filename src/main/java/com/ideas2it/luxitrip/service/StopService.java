package com.ideas2it.luxitrip.service;

import java.util.List;

import com.ideas2it.luxitrip.exception.CustomException;
import com.ideas2it.luxitrip.model.Stop;

public interface StopService {
	
	 /**
     * Method to return the created stop Id
     * @param Stop stop 
     * @return stop object
     * @throws CustomException - carry message for the exception
     */
    public void createStop(Stop stop) throws CustomException;

    /**
     * Method to display Stop details
     * @param int displayId - Id to display the details
     * @return stop object
     * @throws CustomException - carry message for the exception
     */
    Stop displayStop(int displayId) throws CustomException;
    
    /**
     * Method to delete Stop details
     * @param int displayId - Id to display the details
     * @return stop object - updated employee details
     * @throws CustomException - carry message for the exception
     */
    void deleteStop(int deleteId) throws CustomException;
    
    /**
     * Method to return list of all Stops
     * @return stop List
     * @throws CustomException - carry message for the exception
     */
    List<Stop> displayAllStops() throws CustomException ;
}
