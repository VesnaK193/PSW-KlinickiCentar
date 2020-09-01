package com.tim3.backendPSW.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tim3.backendPSW.models.Cenovnik;
import com.tim3.backendPSW.models.Klinika;
import com.tim3.backendPSW.models.Pregled;
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

	public Cenovnik getCenaByKlinikaAndTip(Pregled pregled) {
		List<Cenovnik> cenovnici = cenovnikRepository.findAll();
		Cenovnik cenaPregleda = new Cenovnik();
		for(Cenovnik c : cenovnici) {
			boolean tipEquals = pregled.getTipPregleda().getId() == c.getTipPregleda().getId();
			boolean klinikaEquals = pregled.getLekar().getKlinika().getId() == c.getKlinika().getId();
			if(tipEquals && klinikaEquals) {
				cenaPregleda = c;
				break;
			}
		}
		return cenaPregleda;
	}
}
