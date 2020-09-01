package com.tim3.backendPSW.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.tim3.backendPSW.services.PacijentService;
import com.tim3.backendPSW.models.Pacijent;

@RestController
@CrossOrigin(origins = "*")
public class PacijentController {
	@Autowired
	private PacijentService pacijentService;
	
	@GetMapping("/getPacijentByUserId/{id}")
	public ResponseEntity<Pacijent> getPacijentByUserId(@PathVariable ("id") Long id) {
		Pacijent pacijent = pacijentService.getPacijentByUserId(id);
		return new ResponseEntity<Pacijent>(pacijent, HttpStatus.OK);
	}

}
