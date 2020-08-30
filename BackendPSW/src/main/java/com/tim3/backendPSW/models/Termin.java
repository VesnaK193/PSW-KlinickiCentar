package com.tim3.backendPSW.models;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "termin")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class Termin {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "termin", nullable = false)
	private Date termin;
	
	@OneToOne
	@JoinColumn(name = "pregled_id")
	private Pregled pregled;
	
	@ManyToOne(cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
	@JoinColumn(name = "radnikalendar_id")
	private RadniKalendar radniKalendar;
	
	public Termin() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getTermin() {
		return termin;
	}

	public void setTermin(Date termin) {
		this.termin = termin;
	}

	public Pregled getPregled() {
		return pregled;
	}

	public void setPregled(Pregled pregled) {
		this.pregled = pregled;
	}

	public RadniKalendar getRadniKalendar() {
		return radniKalendar;
	}

	public void setRadniKalendar(RadniKalendar radniKalendar) {
		if (sameAsOldRadniKalendar(radniKalendar))
			return;
		// set new owner
		RadniKalendar oldRadniKalendar = this.radniKalendar;
		this.radniKalendar = radniKalendar;
		// remove from the old owner
		if (oldRadniKalendar != null)
			oldRadniKalendar.removeTermin(this);
		// set myself into new owner
		if (radniKalendar != null)
			radniKalendar.addTermin(this);
	}

	private boolean sameAsOldRadniKalendar(RadniKalendar radniKalendar) {
		return this.radniKalendar == null ? radniKalendar == null : this.radniKalendar.equals(radniKalendar);
	}
}
