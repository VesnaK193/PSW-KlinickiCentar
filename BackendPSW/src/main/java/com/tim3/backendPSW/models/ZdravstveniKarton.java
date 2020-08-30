package com.tim3.backendPSW.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "zdravstvenikarton")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class ZdravstveniKarton {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@OneToOne
	private Pacijent pacijent;

	@Column(name = "dioptrija")
	private String dioptrija;

	@Column(name = "alergija")
	private String alergija;

	@Column(name = "visina")
	private String visina;

	@Column(name = "tezina")
	private String tezina;

	@Column(name = "krvnagrupa")
	private String krvnaGrupa;

	public ZdravstveniKarton() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Pacijent getPacijent() {
		return pacijent;
	}

	public void setPacijent(Pacijent pacijent) {
		this.pacijent = pacijent;
	}

	public String getDioptrija() {
		return dioptrija;
	}

	public void setDioptrija(String dioptrija) {
		this.dioptrija = dioptrija;
	}

	public String getAlergija() {
		return alergija;
	}

	public void setAlergija(String alergija) {
		this.alergija = alergija;
	}

	public String getVisina() {
		return visina;
	}

	public void setVisina(String visina) {
		this.visina = visina;
	}

	public String getTezina() {
		return tezina;
	}

	public void setTezina(String tezina) {
		this.tezina = tezina;
	}

	public String getKrvnaGrupa() {
		return krvnaGrupa;
	}

	public void setKrvnaGrupa(String krvnaGrupa) {
		this.krvnaGrupa = krvnaGrupa;
	}
}
