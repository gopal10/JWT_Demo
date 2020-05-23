package com.gopal.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.gopal.exception.UserNotAvailable;
import com.gopal.model.User;
import com.gopal.service.UserServiceImpl;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@RestController
@RequestMapping("auth/v1")
public class UserAuthController {
	
	private Map<String, String > map = new HashMap<>();
	@Autowired
	private UserServiceImpl userService;	
	
	@GetMapping("/")
	public String ServerStart() {
		return "Authentication Server is running";
	}
	
	@PostMapping("/login")
	public ResponseEntity<?> doLogin(@RequestBody User user){
		
		try {
		String jwtToken = generateToken(user.getUsername(), user.getPassword());
		map.put("message", "User Successfully logged in token generated");
		map.put("token", jwtToken);
		} 
		catch(Exception e) {
		map.put("message", e.getMessage());	
		map.put("token", null);
		return new ResponseEntity<>(map, HttpStatus.UNAUTHORIZED);
		}
		return new ResponseEntity<>(map, HttpStatus.ACCEPTED);
	}
	
	private String generateToken(String username, String password) throws ServletException, UserNotAvailable {
		String jwtToken="";
		if(username==null || password ==null) {
			throw new ServletException("Please send username or password (Non empty)");
		}
		
		boolean flag= userService.validateUser(username, password);
		if(!flag) {
			throw new ServletException("Invalid Credentials");
		}
		else {
			jwtToken =Jwts.builder()
					.setSubject(username)
					.setIssuedAt(new Date())
					.setExpiration(new Date(System.currentTimeMillis()+50000))
					.signWith(SignatureAlgorithm.HS256, "secret Key")
					.compact();
		}
		
		return jwtToken;
	}
	
}
