package com.tim3.backendPSW.models;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "cenovnik")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Cenovnik {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne(cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
	@JoinColumn(name = "klinika_id")
	private Klinika klinika;
	
	@ManyToOne(cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
	@JoinColumn(name = "tippregleda_id")
	private TipPregleda tipPregleda;
	
	@Column(name = "cena")
	private double cena;
	
	@Column(name = "popust")
	private int popust;
	
	public double getCena() {
		return cena;
	}

	public void setCena(double cena) {
		this.cena = cena;
	}

	public int getPopust() {
		return popust;
	}

	public void setPopust(int popust) {
		this.popust = popust;
	}

	public Klinika getKlinika() {
		return klinika;
	}

	public void setKlinika(Klinika klinika) {
		if (sameAsOldKlinika(klinika))
			return;
		// set new owner
		Klinika oldKlinika = this.klinika;
		this.klinika = klinika;
		// remove from the old owner
		if (oldKlinika != null)
			oldKlinika.removeCenovnik(this);
		// set myself into new owner
		if (klinika != null)
			klinika.addCenovnik(this);
	}

	private boolean sameAsOldKlinika(Klinika klinika) {
		return this.klinika == null ? klinika == null : this.klinika.equals(klinika);
	}
	
	public TipPregleda getTipPregleda() {
		return tipPregleda;
	}

	public void setTipPregleda(TipPregleda tipPregleda) {
		if (sameAsOldTipPregleda(tipPregleda))
			return;
		// set new owner
		TipPregleda oldKlinika = this.tipPregleda;
		this.tipPregleda = tipPregleda;
		// remove from the old owner
		if (oldKlinika != null)
			oldKlinika.removeCenovnik(this);
		// set myself into new owner
		if (tipPregleda != null)
			tipPregleda.addCenovnik(this);
	}

	private boolean sameAsOldTipPregleda(TipPregleda tipPregleda) {
		return this.tipPregleda == null ? tipPregleda == null : this.tipPregleda.equals(tipPregleda);
	}

}
