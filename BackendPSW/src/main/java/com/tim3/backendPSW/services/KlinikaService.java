package com.tim3.backendPSW.services;

import java.util.Date;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tim3.backendPSW.models.Klinika;
import com.tim3.backendPSW.models.Lekar;
import com.tim3.backendPSW.models.PretragaKlinikaDTO;
import com.tim3.backendPSW.models.Termin;
import com.tim3.backendPSW.repository.KlinikaRepository;
import com.tim3.backendPSW.repository.LekarRepository;
import com.tim3.backendPSW.repository.TerminRepository;

@Service
public class KlinikaService {

	@Autowired
	private KlinikaRepository klinikaRepository;

	@Autowired
	private LekarRepository lekarRepository;
	
	@Autowired
	private TerminRepository terminRepository;

	public List<Klinika> getAllKlinikas() {
		return klinikaRepository.findAll();
	}

	public Klinika getKlinikaById(Long id) {
		return klinikaRepository.getOne(id);
	}

	public List<Klinika> getSearchedKlinike(PretragaKlinikaDTO pretraga) {
		List<Klinika> klinike = klinikaRepository.findAll();
		List<Klinika> pretrazeni = new ArrayList<>();
		for(Klinika klinika:klinike) {
			Boolean nazivContains = !pretraga.getNaziv().isEmpty()?klinika.getNaziv().toLowerCase().contains(pretraga.getNaziv().toLowerCase()):true;
			Boolean adresaContains = !pretraga.getAdresa().isEmpty()?klinika.getAdresa().toLowerCase().contains(pretraga.getAdresa().toLowerCase()):true;
			Boolean klinikaImaSlobodnogLekaraZaPregled = false;
			List<Lekar> lekariKlinike = lekarRepository.findAllByKlinikaId(klinika.getId());
			for(Lekar lekar : lekariKlinike) {
				List<Termin> terminiLekara = terminRepository.findAllByRadniKalendarId(lekar.getRadniKalendar().getId());
				for(Termin termin : terminiLekara) {
					Date terminPosle = termin.getDatum();
					terminPosle.setTime(termin.getDatum().getTime() + 1800000);
					if(!(termin.getDatum().getTime()<pretraga.getTermin().getTime() && pretraga.getTermin().getTime() < terminPosle.getTime())) {
						klinikaImaSlobodnogLekaraZaPregled = true;
						break;
					}
				}
				if(klinikaImaSlobodnogLekaraZaPregled)
					break;
			}
			
			if(klinikaImaSlobodnogLekaraZaPregled && nazivContains && adresaContains)
				pretrazeni.add(klinika);			
		}
		return pretrazeni;
	}
}
