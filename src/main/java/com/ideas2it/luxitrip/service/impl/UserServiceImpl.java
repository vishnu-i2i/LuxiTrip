package com.ideas2it.luxitrip.service.impl;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;  

import com.ideas2it.luxitrip.dao.impl.UserDaoImpl;
import com.ideas2it.luxitrip.model.User;
import com.ideas2it.luxitrip.exception.CustomException;
import com.ideas2it.luxitrip.service.UserService;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserDaoImpl userDao;
	
	/**
	 * Method used to create the User with the User detail 
	 * @param User it get the user detail to store
	 * @throws CustomException
	 */
	public void createUser(User user) throws CustomException {
	    user.setRole("User");
		user.setStatus(true);
		System.out.println(user + "reached service");
		userDao.insertUser(user);
	}
	
	/**
	 * Method used to delete the user from the stroage in the given UserId
	 * @param userId
	 * @throws CustomException
	 */
	public void deleteUser(int userId) throws CustomException {
		if(0 == userDao.deleteUser(userId)) {
			throw new CustomException("Unable to delete " + userId);
		}
	}
	
	/**
	 * Method used to update the userDetail from the existing detail
	 * @param user
	 * @throws CustomException
	 */
	public void updateUser(User user) throws CustomException {
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
		if(user.getPassword().equals(password)) {
			if(user.getRole().equals("User")) {
				return "User";
			} else if(user.getRole().equals("Admin")) {
				return "Admin";
			}
		}
	    return "Invalid";
	}

}
