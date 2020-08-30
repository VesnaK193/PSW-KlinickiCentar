package com.tim3.backendPSW.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tim3.backendPSW.models.Lekar;
import com.tim3.backendPSW.repository.LekarRepository;

@Service
public class LekarService {

	@Autowired
	private LekarRepository lekarRepository;

	public List<Lekar> getAllLekars() {
		return lekarRepository.findAll();
	}
}
