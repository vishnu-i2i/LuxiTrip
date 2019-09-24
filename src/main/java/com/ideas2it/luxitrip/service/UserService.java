package com.ideas2it.luxitrip.service;

import java.util.List;

import com.ideas2it.luxitrip.exception.CustomException;
import com.ideas2it.luxitrip.model.User;

public interface UserService {
	
	/**
	 * Method used to create the User with the User detail 
	 * @param User it get the user detail to store
	 * @throws CustomException
	 */
    void createUser(User user) throws CustomException;
    
    /**
     * Method used to delete the user in the given UserId 
     * @param userId
     * @throws CustomException
     */
	void deleteUser(int userId) throws CustomException;
	
	/**
	 * Method used to update the userDetail from the Existing userdetail in the given userId
	 * @param user
	 * @throws CustomException
	 */
	void updateUser(User user) throws CustomException;
	
	/**
	 * Method used to retrieve the list of users in the database
	 * @return the list of users
	 * @throws CustomException
	 */
	List<User> retrieveUsers() throws CustomException;
	
	/**
	 * Method used to retrieve the user and its details in the given Specific UserId
	 * @param userId
	 * @return the user and its details
	 * @throws CustomException
	 */
	User retrieveUserById(int userId) throws CustomException;

    /**
	 * Method used to retrieve the User in the given userName 
	 * @param user Name
	 * @return the given User in the user name
	 * @throws CustomException
	 */
	User retrieveUserByName(String userName) throws CustomException;

	/**
	 * Method used to validate the user whether he is a admin or user to redirect to the specific page 
	 * @param User details 
	 * @param password to validate 
	 * @return the user role
	 * @throws CustomException
	 */
	String redirectPage(User user, String password) throws CustomException;

}
