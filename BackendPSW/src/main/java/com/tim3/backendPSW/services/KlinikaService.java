package com.tim3.backendPSW.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tim3.backendPSW.models.Klinika;
import com.tim3.backendPSW.repository.KlinikaRepository;

@Service
public class KlinikaService {

	@Autowired
	private KlinikaRepository klinikaRepository;

	public List<Klinika> getAllKlinikas() {
		return klinikaRepository.findAll();
	}

	public Klinika getKlinikaById(Long id) {
		return klinikaRepository.getOne(id);
	}
}
