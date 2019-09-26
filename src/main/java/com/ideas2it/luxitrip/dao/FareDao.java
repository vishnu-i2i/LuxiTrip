package com.ideas2it.luxitrip.dao;

import java.util.List;

import com.ideas2it.luxitrip.exception.CustomException;
import com.ideas2it.luxitrip.model.Fare;

public interface FareDao {

	/**
	 * Method used to insert the fare and its details into the database
	 * @param fare
	 * @throws CustomException
	 */
    void insertFare(Fare fare)throws CustomException;
	
    /**
	 * Method used to update the detail of fare in the database 
	 * @param fare
	 * @throws CustomException
	 */
    void updateFare(Fare fare)throws CustomException;
    
	/**
	 * Method to get the List of fares in the form of list 
	 * @return the fare details in list
	 * @throws CustomException
	 */
	List<Fare> getFares() throws CustomException;
	
	/**
     * Method used to get the fare detail by using the specific fare id
     * @param id
     * @return the fare detail
     * @throws CustomException
     */
	Fare getFareById(int id) throws CustomException;
}
