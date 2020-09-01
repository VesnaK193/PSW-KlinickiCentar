package com.tim3.backendPSW.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tim3.backendPSW.models.Cenovnik;
import com.tim3.backendPSW.models.Klinika;
import com.tim3.backendPSW.repository.CenovnikRepository;

@Service
public class CenovnikService {

	@Autowired
	private CenovnikRepository cenovnikRepository;

	public List<Cenovnik> getAllCenovnik() {
		return cenovnikRepository.findAll();
	}

	public List<Klinika> getAllKlinikaByTipPregleda(Long id) {
		List<Klinika> klinike = new ArrayList<>();
		List<Cenovnik> cenovnici = cenovnikRepository.findAllByTipPregledaId(id);
		for(Cenovnik c : cenovnici) {
			klinike.add(c.getKlinika());
		}
		return klinike;
	}
}
