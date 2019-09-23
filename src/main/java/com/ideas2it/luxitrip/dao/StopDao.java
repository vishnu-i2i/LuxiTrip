package com.ideas2it.luxitrip.dao;

import java.util.List;

import com.ideas2it.luxitrip.exception.CustomException;
import com.ideas2it.luxitrip.model.Stop;

public interface StopDao {
    
    int addStop(Stop stop) throws CustomException;
    
    Stop retriveStop(int stopId) throws CustomException;
    
    void deleteStop(int deleteId) throws CustomException;
    
    void updateStop(Stop stop) throws CustomException;
    
    List<Stop> displayAllStop() throws CustomException;

}
