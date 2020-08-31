package com.tim3.backendPSW.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.tim3.backendPSW.models.Lekar;
import com.tim3.backendPSW.models.PretragaLekarDTO;
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
	
	@GetMapping("/getAllLekarsByKlinikaId/{id}")
	public ResponseEntity<List<Lekar>> getAllLekarsByKlinikaId(@PathVariable ("id") Long id){
		List<Lekar> lekari = lekarService.getAllLekarsByKlinikaId(id);
		
		return new ResponseEntity<List<Lekar>>(lekari, HttpStatus.OK);
	}
	
	@CrossOrigin
	@PostMapping("/getSearchedLekars")
	public ResponseEntity<List<Lekar>> getSearchedLekars(@RequestBody PretragaLekarDTO pretraga){
		List<Lekar> lekari = lekarService.getSearchedLekars(pretraga);
		
		return new ResponseEntity<List<Lekar>>(lekari, HttpStatus.OK);
	}
}
