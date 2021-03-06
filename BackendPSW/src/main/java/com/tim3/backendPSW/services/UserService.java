package com.tim3.backendPSW.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tim3.backendPSW.models.User;
import com.tim3.backendPSW.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	public List<User> getAllUsers() {
		return userRepository.findAll();
	}
	
	public List<User> getAllUsersOnHold() {
		return userRepository.findAllByRole("naCekanju");
	}
	
	public User getUserById(Long id) {
		return userRepository.getOne(id);
	}
	
	public User login(User user) {
		List<User> users = getAllUsers();
		User noviUser = new User();
		
		for(User u : users) {
			if(user.getEmail().toString().equals(u.getEmail().toString())  && user.getPassword().toString().equals(u.getPassword().toString()) ) {
				noviUser = u;
				break;
			}
		}
		
		return noviUser;
	}
	
	public User saveUser(User user) {
		User noviUser = new User();
		if(user.getId() == null) {
			noviUser.setRole("naCekanju");
		}else if (user.getRole().equals("naCekanju")) {
			noviUser.setRole("pacijent");
			noviUser.setId(user.getId());
		} else {
			noviUser.setRole(user.getRole());
			noviUser.setId(user.getId());
		}
		noviUser.setFirstname(user.getFirstname());
		noviUser.setLastname(user.getLastname());
		noviUser.setEmail(user.getEmail());
		noviUser.setPassword(user.getPassword());
		noviUser.setAddress(user.getAddress());
		noviUser.setCity(user.getCity());
		noviUser.setCountry(user.getCountry());
		noviUser.setPhone(user.getPhone());
		
		noviUser = userRepository.save(noviUser);
		return noviUser;
	}
	
	public User linkSent(User user) {
		User noviUser = new User();
		noviUser.setId(user.getId());
		noviUser.setRole("linkPoslat");
		noviUser.setFirstname(user.getFirstname());
		noviUser.setLastname(user.getLastname());
		noviUser.setEmail(user.getEmail());
		noviUser.setPassword(user.getPassword());
		noviUser.setAddress(user.getAddress());
		noviUser.setCity(user.getCity());
		noviUser.setCountry(user.getCountry());
		noviUser.setPhone(user.getPhone());
		
		noviUser = userRepository.save(noviUser);
		return noviUser;
	}
	
	public void rejectRequest(User user) {
		
		userRepository.deleteById(user.getId());
	}

}
