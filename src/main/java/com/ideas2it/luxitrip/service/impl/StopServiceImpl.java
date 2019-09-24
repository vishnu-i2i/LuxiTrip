package com.ideas2it.luxitrip.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ideas2it.luxitrip.dao.StopDao;
import com.ideas2it.luxitrip.exception.CustomException;
import com.ideas2it.luxitrip.model.Stop;
import com.ideas2it.luxitrip.service.StopService;

@Service
public class StopServiceImpl implements StopService {
    
    @Autowired
    private StopDao stopDao;;
    
    /**
     * Method to return the created stop Id
     * @param Stop stop 
     * @return stop object
     * @throws CustomException - carry message for the exception
     */
    public void createStop(Stop stop) throws CustomException {
        stopDao.insertStop(stop);
    }

    /**
     * Method to display Stop details
     * @param int displayId - Id to display the details
     * @return stop object
     * @throws CustomException - carry message for the exception
     */
    public Stop retrieveStopById(int id) throws CustomException {
        return stopDao.getStopById(id);
    }

    /**
     * Method to delete Stop details
     * @param int displayId - Id to display the details
     * @return stop object - updated employee details
     * @throws CustomException - carry message for the exception
     */
    public void deleteStop(int id) throws CustomException{
        stopDao.deleteStop(id);
    }
    
    /**
     * Method to return list of all Stops
     * @return stop List
     * @throws CustomException - carry message for the exception
     */
    public List<Stop> retrieveAllStops() throws CustomException {
        return stopDao.getAllStops();
    }
}
