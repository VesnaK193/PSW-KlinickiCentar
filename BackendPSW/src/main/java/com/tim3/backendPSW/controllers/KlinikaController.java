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

import com.tim3.backendPSW.models.Klinika;
import com.tim3.backendPSW.models.Lekar;
import com.tim3.backendPSW.models.PretragaKlinikaDTO;
import com.tim3.backendPSW.models.PretragaLekarDTO;
import com.tim3.backendPSW.services.KlinikaService;

@RestController
@CrossOrigin(origins = "*")
public class KlinikaController {
	
	@Autowired
	private KlinikaService klinikaService;

	@GetMapping("/getAllKlinikas")
	public ResponseEntity<List<Klinika>> getAllKlinikas(){
		List<Klinika> klinike = klinikaService.getAllKlinikas();
		
		return new ResponseEntity<List<Klinika>>(klinike, HttpStatus.OK);
	}
	
	@GetMapping("/getKlinikaById/{id}")
	public ResponseEntity<Klinika> getKlinikaById(@PathVariable ("id") Long id){
		Klinika klinika = klinikaService.getKlinikaById(id);
		
		return new ResponseEntity<Klinika>(klinika, HttpStatus.OK);
	}
	
	@CrossOrigin
	@PostMapping("/getSearchedKlinike")
	public ResponseEntity<List<Klinika>> getSearchedKlinike(@RequestBody PretragaKlinikaDTO pretraga){
		List<Klinika> klinike = klinikaService.getSearchedKlinike(pretraga);
		
		return new ResponseEntity<List<Klinika>>(klinike, HttpStatus.OK);
	}
}
