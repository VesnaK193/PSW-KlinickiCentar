package com.tim3.backendPSW.services;

import java.util.ArrayList;
import java.util.List;

import javax.mail.MessagingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.stereotype.Service;

import com.tim3.backendPSW.models.AdministratorKlinike;
import com.tim3.backendPSW.models.Pregled;
import com.tim3.backendPSW.models.Termin;
import com.tim3.backendPSW.models.Sala;
import com.tim3.backendPSW.repository.AdministratorKlinikeRepository;
import com.tim3.backendPSW.repository.PregledRepository;
import com.tim3.backendPSW.repository.TerminRepository;


@Service
public class PregledService {
	@Autowired
	private PregledRepository pregledRepository;
	
	@Autowired
	private AdministratorKlinikeRepository administratorKlinikeRepository;
	
	@Autowired
	private TerminRepository terminRepository;
	
	@Autowired
	private EmailService emailService;
	
	public Pregled savePregledRequest(Pregled pregled) {
		Termin newTermin = pregled.getTermin();
		newTermin.setRadniKalendar(pregled.getLekar().getRadniKalendar());
		pregled.setSala(null);
		pregled.setTermin(terminRepository.save(newTermin));
		
		Pregled newPregled = pregledRepository.saveAndFlush(pregled);
		List<AdministratorKlinike> adminiKlinike = administratorKlinikeRepository.findAllByKlinikaId(pregled.getLekar().getKlinika().getId());
		for(AdministratorKlinike ak : adminiKlinike) {
			try {
				emailService.sendNotificationToAK(ak.getUser(), newPregled);
			} catch (MailException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (MessagingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return newPregled;
		
		
	}

	public List<Pregled> getAllPredefinisaniPreglediKlinike(Long id) {
		List<Pregled> sviPregledi = pregledRepository.findAll();
		List<Pregled> predefinisaniPregledi = new ArrayList<>();
		for(Pregled pregled : sviPregledi) {
			boolean pripadaKlinici = pregled.getLekar().getKlinika().getId() == id;
			boolean predefinisanPregled = pregled.getPacijent() == null;
			if(pripadaKlinici && predefinisanPregled)
				predefinisaniPregledi.add(pregled);
		}
		return predefinisaniPregledi;
	}

	public Pregled savePregled(Pregled pregled) {
		Pregled newPregled = pregledRepository.save(pregled);
		try {
			emailService.sendQuickReservNotification(newPregled);
		} catch (MailException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return newPregled;
	}

}
