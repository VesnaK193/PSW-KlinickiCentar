package com.tim3.backendPSW.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.tim3.backendPSW.models.Cenovnik;
import com.tim3.backendPSW.models.Klinika;
import com.tim3.backendPSW.services.CenovnikService;

@RestController
@CrossOrigin(origins = "*")
public class CenovnikController {
	
	
	@Autowired
	private CenovnikService cenovnikService;
	
	@GetMapping("/getAllCenovnik")
	public ResponseEntity<List<Cenovnik>> getAllCenovnik(){
		List<Cenovnik> cenovnici = cenovnikService.getAllCenovnik();
		
		return new ResponseEntity<List<Cenovnik>>(cenovnici, HttpStatus.OK);
	}
	
	@GetMapping("/getAllKlinikaByTipPregledaId/{id}")
	public ResponseEntity<List<Klinika>> getAllKlinikaByTipPregleda(@PathVariable ("id") Long id){
		List<Klinika> klinike = cenovnikService.getAllKlinikaByTipPregleda(id);
		
		return new ResponseEntity<List<Klinika>>(klinike, HttpStatus.OK);
	}

}
