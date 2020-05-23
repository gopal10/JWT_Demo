package com.gopal.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gopal.exception.UserAlreadyPresent;
import com.gopal.model.User;
import com.gopal.service.UserServiceImpl;

@RestController
@RequestMapping("api/v1/gopal")
public class UserController {
	
	@Autowired 
	public UserServiceImpl userservice;
	
	@PostMapping("/save")
	public ResponseEntity<User> saveController(@RequestBody User user) throws UserAlreadyPresent{
		User newUser;
		newUser= userservice.saveUser(user);
		System.out.println("***********"+ user);
		return new ResponseEntity<User>(newUser, HttpStatus.OK);
	}

}
