package com.ideas2it.luxitrip.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;  
import org.springframework.stereotype.Service;

import com.ideas2it.luxitrip.dao.UserDao;
import com.ideas2it.luxitrip.model.Bus;
import com.ideas2it.luxitrip.model.Stop;
import com.ideas2it.luxitrip.model.User;
import com.ideas2it.luxitrip.exception.CustomException;
import com.ideas2it.luxitrip.service.BusService;
import com.ideas2it.luxitrip.service.StopService;
import com.ideas2it.luxitrip.service.UserService;

@Service
public class UserServiceImpl implements UserService {
    
    @Autowired
    private UserDao userDao;
    
    @Autowired
    private BusService busService;
    
    @Autowired
    private StopService stopService;
	
    /**
     * Method used to create the User with the User detail 
     * @param User it get the user detail to store
     * @throws CustomException
     */
    public void createUser(User user) throws CustomException {
        user.setStatus(true);
        System.out.println(user + "reached service");
        userDao.insertUser(user);
    }
	
    /**
     * Method used to delete the user from the storage in the given UserId
     * @param userId
     * @throws CustomException
     */
    public void deleteUser(int userId) throws CustomException {
        User user = userDao.getUserById(userId);
        user.setStatus(false);
        userDao.updateUser(user);
    }
	
    /**
     * Method used to update the userDetail from the existing detail
     * @param user
     * @throws CustomException
     */
    public void updateUser(User updatedUser) throws CustomException {
        User user = userDao.getUserById(updatedUser.getId());
        user.setName(updatedUser.getName());
        user.setEmailId(updatedUser.getEmailId());
        user.setNumber(updatedUser.getNumber());
        user.setStatus(true);
		userDao.updateUser(user);
    }
	
    /**
     * Method used to retrieve the List of users in the database in form of list	
     * @return the list of users
     * @throws CustomException
     */
    public List<User> retrieveUsers() throws CustomException {
        return userDao.getUsers();
    }
	
    /**
     * Method used to retrieve the User in the given userId
     * @param userId
     * @return the given User in the userId
     * @throws CustomException
     */
    public User retrieveUserById(int userId) throws CustomException {
        return userDao.getUserById(userId);
    }

    /**
     * Method used to retrieve the User in the given userName 
     * @param user Name
     * @return the given User in the user name
     * @throws CustomException
     */
    public User retrieveUserByName(String userName) throws CustomException {
        return userDao.getUserByName(userName);
    }

    /**
     * Method used to validate the user whether he is a admin or user to redirect to the specific page 
     * @param User details 
     * @param password to validate 
     * @return the user role
     * @throws CustomException
     */
    public String redirectPage(User user, String password) throws CustomException {
        if(null != user && user.getPassword().equals(password)) {
            if(user.getRole().equals("User")) {
                return "User";
            } else if(user.getRole().equals("Admin")) {
                return "Admin";
            }
        }
        throw new CustomException("User Name and Password Wrong");
    }
    
    /**
     * Method used to retrieve the list of buses from the bus service
     * @return the list of buses
     * @throws CustomException
     */
    public List<Bus> retrieveBuses() throws CustomException {
        return busService.retrieveAllBuses();   
    }
    
    /**
     * Method used to retrieve the list of stops from the stopService class
     * @return
     * @throws CustomException
     */
    public List<Stop> retrieveAllStops() throws CustomException {
        return stopService.retrieveAllStops();
    }
}
