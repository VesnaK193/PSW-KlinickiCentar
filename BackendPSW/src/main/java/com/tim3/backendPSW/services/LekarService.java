package com.tim3.backendPSW.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tim3.backendPSW.models.Lekar;
import com.tim3.backendPSW.models.PretragaLekarDTO;
import com.tim3.backendPSW.repository.LekarRepository;

@Service
public class LekarService {

	@Autowired
	private LekarRepository lekarRepository;

	public List<Lekar> getAllLekars() {
		return lekarRepository.findAll();
	}

	public List<Lekar> getAllLekarsByKlinikaId(Long id) {
		return lekarRepository.findAllByKlinikaId(id);
	}

	public List<Lekar> getSearchedLekars(PretragaLekarDTO pretraga) {
		List<Lekar> lekari = lekarRepository.findAllByKlinikaId(pretraga.getIdKlinike());
		List<Lekar> pretrazeni = new ArrayList<>();
		for(Lekar lekar:lekari) {
			Boolean firstnameContains = !pretraga.getIme().isEmpty()?lekar.getUser().getFirstname().toLowerCase().contains(pretraga.getIme().toLowerCase()):true;
			Boolean lastnameContains = !pretraga.getPrezime().isEmpty()?lekar.getUser().getLastname().toLowerCase().contains(pretraga.getPrezime().toLowerCase()):true;
			
			if(firstnameContains && lastnameContains)
				pretrazeni.add(lekar);
			
		}
		return pretrazeni;
	}
}
