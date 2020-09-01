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

import com.tim3.backendPSW.models.Cenovnik;
import com.tim3.backendPSW.models.Pregled;
import com.tim3.backendPSW.services.PregledService;

@RestController
@CrossOrigin(origins = "*")
public class PregledController {
	
	@Autowired
	private PregledService pregledService;
	
	@GetMapping("/getAllPredefinisaniPreglediKlinike/{id}")
	public ResponseEntity<List<Pregled>> getAllPredefinisaniPreglediKlinike(@PathVariable ("id") Long id){
		List<Pregled> pregledi = pregledService.getAllPredefinisaniPreglediKlinike(id);
		
		return new ResponseEntity<List<Pregled>>(pregledi, HttpStatus.OK);
	}
	
	@PostMapping("/postExaminationRequest")
	public ResponseEntity<Pregled> postExaminationRequest(@RequestBody Pregled pregled){
		Pregled newPregled = pregledService.savePregledRequest(pregled);
		
		return new ResponseEntity<Pregled>(newPregled, HttpStatus.OK);
	}
	
	@PostMapping("/postExamination")
	public ResponseEntity<Pregled> postExamination(@RequestBody Pregled pregled){
		Pregled newPregled = pregledService.savePregled(pregled);
		
		return new ResponseEntity<Pregled>(newPregled, HttpStatus.OK);
	}

}
