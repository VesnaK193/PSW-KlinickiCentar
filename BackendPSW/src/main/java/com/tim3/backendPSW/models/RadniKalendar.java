package com.tim3.backendPSW.models;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "radnikalendar")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class RadniKalendar {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@OneToOne
	private Lekar lekar;
	
	@JsonIgnore
	@OneToMany(mappedBy = "radniKalendar")
	private Collection<Termin> termini = new ArrayList<Termin>();
	
	public RadniKalendar() {
		super();
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Collection<Termin> getTermini() {
		return termini;
	}

	public void addTermin(Termin termin) {
		if (this.termini.contains(termin))
			return;
		termini.add(termin);
		termin.setRadniKalendar(this);
	}

	public void removeTermin(Termin termin) {
		if (!termini.contains(termin))
			return;
		termini.remove(termin);
		termin.setRadniKalendar(null);
	}

	public Lekar getLekar() {
		return lekar;
	}

	public void setLekar(Lekar lekar) {
		this.lekar = lekar;
	}
	
	
}
