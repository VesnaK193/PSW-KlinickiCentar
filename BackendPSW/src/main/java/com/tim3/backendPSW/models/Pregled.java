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
@Table(name = "pregled")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Pregled {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@OneToOne
	@JoinColumn(name = "termin_id")
	private Termin termin;
	
	@ManyToOne(cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
	@JoinColumn(name = "sala_id")
	private Sala sala;

	@ManyToOne(cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
	@JoinColumn(name = "lekar_id")
	private Lekar lekar;

	@ManyToOne(cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
	@JoinColumn(name = "pacijent_id")
	private Pacijent pacijent;
	
	@ManyToOne(cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
	@JoinColumn(name = "tippregleda_id")
	private TipPregleda tipPregleda;

	@Column(name = "cena")
	private double cena;
	
	@Column(name = "popust")
	private int popust;

	public Pregled() {
		super();
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	//----Termin---------------------------------
	
	public Termin getTermin() {
		return termin;
	}

	public void setTermin(Termin termin) {
		this.termin = termin;
	}

	//----Sala---------------------------------

	public Sala getSala() {
		return sala;
	}

	public void setSala(Sala sala) {
		if (sameAsOldSala(sala))
			return;
		// set new owner
		Sala oldSala = this.sala;
		this.sala = sala;
		// remove from the old owner
		if (oldSala != null)
			oldSala.removePregled(this);
		// set myself into new owner
		if (sala != null)
			sala.addPregled(this);
	}

	private boolean sameAsOldSala(Sala sala) {
		return this.sala == null ? sala == null : this.sala.equals(sala);
	}

	//----Lekar---------------------------------

	public Lekar getLekar() {
		return lekar;
	}

	public void setLekar(Lekar lekar) {
		if (sameAsOldLekar(lekar))
			return;
		// set new owner
		Lekar oldLekar = this.lekar;
		this.lekar = lekar;
		// remove from the old owner
		if (oldLekar != null)
			oldLekar.removePregled(this);
		// set myself into new owner
		if (lekar != null)
			lekar.addPregled(this);
	}

	private boolean sameAsOldLekar(Lekar lekar) {
		return this.lekar == null ? lekar == null : this.lekar.equals(lekar);
	}

	//----Pacijent---------------------------------

	public Pacijent getPacijent() {
		return pacijent;
	}

	public void setPacijent(Pacijent pacijent) {
		if (sameAsOldPacijent(pacijent))
			return;
		// set new owner
		Pacijent oldPacijent = this.pacijent;
		this.pacijent = pacijent;
		// remove from the old owner
		if (oldPacijent != null)
			oldPacijent.removePregled(this);
		// set myself into new owner
		if (pacijent != null)
			pacijent.addPregled(this);
	}

	private boolean sameAsOldPacijent(Pacijent pacijent) {
		return this.pacijent == null ? pacijent == null : this.pacijent.equals(pacijent);
	}

	//----TipPregleda---------------------------------

	public TipPregleda getTipPregleda() {
		return tipPregleda;
	}

	public void setTipPregleda(TipPregleda tipPregleda) {
		if (sameAsOldTipPregleda(tipPregleda))
			return;
		// set new owner
		TipPregleda oldTipPregleda = this.tipPregleda;
		this.tipPregleda = tipPregleda;
		// remove from the old owner
		if (oldTipPregleda != null)
			oldTipPregleda.removePregled(this);
		// set myself into new owner
		if (tipPregleda != null)
			tipPregleda.addPregled(this);
	}

	private boolean sameAsOldTipPregleda(TipPregleda tipPregleda) {
		return this.tipPregleda == null ? tipPregleda == null : this.tipPregleda.equals(tipPregleda);
	}

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
	
	
}
