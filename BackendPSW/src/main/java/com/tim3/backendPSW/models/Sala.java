package com.tim3.backendPSW.models;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "sala")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class Sala {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "naziv")
	private String naziv;

	@Column(name = "brojsale")
	private String brojsale;

	@ManyToOne(cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
	@JoinColumn(name = "klinika_id")
	private Klinika klinika;
	
	@JsonIgnore
	@OneToMany()
	private Set<Pregled> pregledi = new HashSet<Pregled>();

	public Sala() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNaziv() {
		return naziv;
	}

	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}

	public String getBrojsale() {
		return brojsale;
	}

	public void setBrojsale(String brojsale) {
		this.brojsale = brojsale;
	}

	public Klinika getKlinika() {
		return klinika;
	}

	public void setKlinika(Klinika klinika) {
		if (sameAsOld(klinika))
			return;
		// set new owner
		Klinika oldKlinika = this.klinika;
		this.klinika = klinika;
		// remove from the old owner
		if (oldKlinika != null)
			oldKlinika.removeSala(this);
		// set myself into new owner
		if (klinika != null)
			klinika.addSala(this);
	}

	private boolean sameAsOld(Klinika klinika) {
		return this.klinika == null ? klinika == null : this.klinika.equals(klinika);
	}
	
	public Collection<Pregled> getPregledi() {
		return pregledi;
	}

	public void addPregled(Pregled pregled) {
		if (this.pregledi.contains(pregled))
			return;
		pregledi.add(pregled);
		pregled.setSala(this);
	}

	public void removePregled(Pregled pregled) {
		if (!pregledi.contains(pregled))
			return;
		pregledi.remove(pregled);
		pregled.setSala(null);
	}
}
