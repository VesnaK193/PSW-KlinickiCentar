package com.tim3.backendPSW.services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tim3.backendPSW.models.Pacijent;
import com.tim3.backendPSW.repository.PacijentRepository;

@Service
public class PacijentService {
	@Autowired
	private PacijentRepository pacijentRepository;
	
	public Pacijent getPacijentByUserId(Long id) {
		return pacijentRepository.getOneByUserId(id);
	}

}
