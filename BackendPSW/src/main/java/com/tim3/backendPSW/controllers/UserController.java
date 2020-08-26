package com.tim3.backendPSW.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.tim3.backendPSW.models.User;
import com.tim3.backendPSW.services.UserService;

@RestController
@CrossOrigin(origins = "*")
public class UserController {

	@Autowired
	private UserService userService;
	
	@GetMapping("/getAllUsers")
	public ResponseEntity<List<User>> getAll(){
		List<User> users = userService.getAllUsers();
		
		return ( new ResponseEntity<List<User>>(users, HttpStatus.OK) );
	}
	
	@PostMapping("/login")
	public ResponseEntity<User> login(@RequestBody User user) {
		User noviUser = userService.login(user);
		
		return new ResponseEntity<User>(noviUser, HttpStatus.OK);
		
	}
	
	@PostMapping("/register")
	public ResponseEntity<User> register(@RequestBody User user) {
		User noviUser = userService.register(user);
		
		return new ResponseEntity<User>(noviUser, HttpStatus.OK);
		
		
	}
}
