package com.tim3.backendPSW.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tim3.backendPSW.models.Lekar;
import com.tim3.backendPSW.services.LekarService;

@RestController
@CrossOrigin(origins = "*")
public class LekarController {

	@Autowired
	private LekarService lekarService;
	
	@GetMapping("/getAllLekars")
	public ResponseEntity<List<Lekar>> getAllLekars(){
		List<Lekar> lekars = lekarService.getAllLekars();
		
		return new ResponseEntity<List<Lekar>>(lekars, HttpStatus.OK);
	}
}
