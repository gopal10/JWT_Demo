package com.gopal.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gopal.exception.UserAlreadyPresent;
import com.gopal.exception.UserNotAvailable;
import com.gopal.model.User;
import com.gopal.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;
	
	@Override
	public User saveUser(User user) throws UserAlreadyPresent {
		User newUser;
		if(userRepository.existsById(user.getId())) {
			throw new UserAlreadyPresent("User Already Present");
		}
		else {
			newUser= (User) userRepository.save(user);
		}
		return newUser;
	}

	@Override
	public List<User> getAllUser() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User updateUser(User user) throws UserNotAvailable {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String deleteUser(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<User> getUser(String id) throws UserNotAvailable {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean validateUser(String username, String password) throws UserNotAvailable{
		User user= userRepository.validateUser(username, password);
		System.out.println("&&&&&&&&"+user);
		if(user != null)
			return true;
		else
		return false;
	}

}
