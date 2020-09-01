package com.tim3.backendPSW.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tim3.backendPSW.models.TipPregleda;
import com.tim3.backendPSW.services.TipPregledaService;

@RestController
@CrossOrigin(origins = "*")
public class TipPregledaController {
	@Autowired
	private TipPregledaService tipPregledaService;
	
	@GetMapping("/getAllTipovePregleda")
	public ResponseEntity<List<TipPregleda>> getAllTipovePregleda(){
		List<TipPregleda> tipovi = tipPregledaService.getAllTipovePregleda();
		
		return new ResponseEntity<List<TipPregleda>>(tipovi, HttpStatus.OK);
	}
}
