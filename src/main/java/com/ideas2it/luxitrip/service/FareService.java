package com.ideas2it.luxitrip.service;

import java.util.List;

import com.ideas2it.luxitrip.exception.CustomException;
import com.ideas2it.luxitrip.model.Fare;

public interface FareService {

	/**
     * Method used to create the Fare details into the database 
     * @param fare
     * @throws CustomException
     */
    public void createFare(Fare fare) throws CustomException;
    
    /**
     * Method used to update the value of existing fare values 
     * @param fare updating values 
     * @throw CustomException
     */
    public void updateFare(Fare fare) throws CustomException;
    
    /**
     * Method used to delete the value of fare by using the id 
     * @param fareId
     * @throws CustomException
     */
    public void deleteFare(int fareId) throws CustomException;
    
    /**
     * Method used to retrieve the list of fare objects into the database
     * @return the list of fares
     * @throws CustomException
     */
    public List<Fare> retrieveFares() throws CustomException;
    
    /**
     * Method used to retrieve the fare and its details by using the fareId
     * @param id
     * @return
     * @throws CustomException
     */
    public Fare retrieveFareById(int id) throws CustomException;
}
