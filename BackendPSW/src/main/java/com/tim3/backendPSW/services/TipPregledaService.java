package com.tim3.backendPSW.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tim3.backendPSW.models.TipPregleda;
import com.tim3.backendPSW.repository.TipPregledaRepository;

@Service
public class TipPregledaService {
	@Autowired
	private TipPregledaRepository tipPregledaRepository;

	public List<TipPregleda> getAllTipovePregleda() {
		return tipPregledaRepository.findAll();
	}
}
