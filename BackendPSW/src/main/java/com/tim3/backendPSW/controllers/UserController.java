package com.tim3.backendPSW.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.mail.MessagingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.MailException;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.tim3.backendPSW.models.User;
import com.tim3.backendPSW.services.EmailService;
import com.tim3.backendPSW.services.UserService;

@RestController
@CrossOrigin(origins = "*")
public class UserController {

	@Autowired
	private UserService userService;
	
	@Autowired
	private EmailService emailService;
	
	@GetMapping("/getAllUsers")
	public ResponseEntity<List<User>> getAll(){
		List<User> users = userService.getAllUsers();
		
		return ( new ResponseEntity<List<User>>(users, HttpStatus.OK) );
	}
	
	@GetMapping("/getAllUsersOnHold")
	public ResponseEntity<List<User>> getAllUsersOnHold(){
		List<User> users = userService.getAllUsersOnHold();
		
		return ( new ResponseEntity<List<User>>(users, HttpStatus.OK) );
	}
	
	@PostMapping("/getUserById")
	public ResponseEntity<User> getUserById(@RequestBody Long id){
		User user = userService.getUserById(id);
		
		return new ResponseEntity<User>(user, HttpStatus.OK);
	}
	
	@PostMapping("/login")
	public ResponseEntity<User> login(@RequestBody User user) {
		User noviUser = userService.login(user);
		
		return new ResponseEntity<User>(noviUser, HttpStatus.OK);
		
	}
	
	@PostMapping("/saveUser")
	public ResponseEntity<User> saveUser(@RequestBody User user) {
		User noviUser = userService.saveUser(user);
		
		return new ResponseEntity<User>(noviUser, HttpStatus.OK);
	}
	
	@PostMapping("/sendLink")
	public ResponseEntity<User> sendLink(@RequestBody User user) {
		try {
			emailService.sendLink(user);
		} catch (Exception e) {
			System.out.println("Greska prilikom slanja maila!" + e.getMessage());
		}
		User noviUser = userService.linkSent(user);
		return new ResponseEntity<User>(noviUser, HttpStatus.OK);
	}
	
	@PostMapping("/rejectRequest")
	public ResponseEntity<User> rejectRequest(@RequestBody User user) {
		try {
			emailService.rejectRequest(user);
		} catch (Exception e) {
			System.out.println("Greska prilikom slanja maila!" + e.getMessage());
		}
		userService.rejectRequest(user);
		return new ResponseEntity<User>(user, HttpStatus.OK);
	}
}
