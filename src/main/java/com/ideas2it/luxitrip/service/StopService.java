package com.ideas2it.luxitrip.service;

import java.util.List;

import com.ideas2it.luxitrip.exception.CustomException;
import com.ideas2it.luxitrip.model.Stop;

public interface StopService {

    int addStop(Stop stop) throws CustomException;
    
    Stop displayStop(int displayId) throws CustomException;
    
    void deleteStop(int deleteId) throws CustomException;
    
    List<Stop> displayAllStops() throws CustomException;
    
}
