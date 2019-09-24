package com.ideas2it.luxitrip.dao;

import java.util.List;

import com.ideas2it.luxitrip.exception.CustomException;
import com.ideas2it.luxitrip.model.User;

public interface UserDao {
	
	/**
	 * Method Used to insert the User detail from the User into the Database 
	 * @param user
	 * @throws CustomException
	 */
	void insertUser(User user) throws CustomException;
	
	/**
	 * Method used to soft delete the User from the database by using the userId 
	 * @param user
	 * @return the numberOfRowsAffected count 
	 * @throws CustomException
	 */
    int deleteUser(int userId) throws CustomException;
	
	/**
	 * Method used to update the user detail from the database by using the detail 
	 * from the user
	 * @param user
	 * @throws CustomException
	 */
	void updateUser(User user) throws CustomException;
	
	/** 
	 * Method used to get the List of user from the database
	 * @return the list of users
	 * @throws CustomException
	 */
    List<User> getUsers() throws CustomException;
    
    /**
     * Method used to get the User object in the specific userId
     * @param userId
     * @return the user object
     * @throws CustomException
     */
    User getUserById(int userId) throws CustomException;
 
    /**
     * Method used to count the number of Users in the database 
     * @return the users count in long
     * @throws CustomException
     */
    long countUser() throws CustomException;
    
	 /**
     * Method used to get the User object in the specific user Name
     * @param user name
     * @return the user object
     * @throws CustomException
     */
	User getUserByName(String userName) throws CustomException;

}