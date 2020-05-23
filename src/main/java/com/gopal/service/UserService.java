package com.gopal.service;

import java.util.List;
import java.util.Optional;

import com.gopal.exception.UserAlreadyPresent;
import com.gopal.exception.UserNotAvailable;
import com.gopal.model.User;

public interface UserService {
	
	public boolean validateUser(String username , String password) throws UserNotAvailable;
	public User saveUser(User user) throws UserAlreadyPresent;
	public List<User> getAllUser();
	public User updateUser(User user)throws UserNotAvailable;
	public String deleteUser(String id);
	public Optional<User> getUser(String id)throws UserNotAvailable;
	

}
