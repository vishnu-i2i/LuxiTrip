package com.ideas2it.luxitrip.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;  
import org.springframework.stereotype.Service;

import com.ideas2it.luxitrip.dao.FareDao;
import com.ideas2it.luxitrip.exception.CustomException;
import com.ideas2it.luxitrip.model.Fare;
import com.ideas2it.luxitrip.service.FareService;

@Service
public class FareServiceImpl implements FareService {
	
    @Autowired
	private FareDao fareDao;
	
    /**
     * Method used to create the Fare details into the database 
     * @param fare
     * @throws CustomException
     */
    public void createFare(Fare fare) throws CustomException {
        fare.setStatus(true);
        fareDao.insertFare(fare);	
    }
    
    /**
     * Method used to update the value of existing fare values 
     * @param fare updating values 
     * @throw CustomException
     */
    public void updateFare(Fare fare) throws CustomException {
        fareDao.updateFare(fare);
    }
    
    /** 
     * Method used to delete the value of fare by using the id 
     * @param fareId
     * @throws CustomException
     */
    public void deleteFare(int fareId) throws CustomException {
        Fare fare = fareDao.getFareById(fareId);
        fare.setStatus(false);
        fareDao.updateFare(fare);
    }
    
    /**
     * Method used to retrieve the list of fare objects into the database
     * @return the list of fares
     * @throws CustomException
     */
    public List<Fare> retrieveFares() throws CustomException {
        return fareDao.getFares();
    }
    
    /**
     * Method used to retrieve the fare and its details by using the fareId
     * @param id
     * @return
     * @throws CustomException
     */
    public Fare retrieveFareById(int id) throws CustomException {
        return fareDao.getFareById(id);
    }
    
}
