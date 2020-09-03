package com.tim3.backendPSW.models;

import java.util.Date;

public class PretragaLekarDTO {
	private Long idKlinike;
	private String ime;
	private String prezime;
	private Date termin;
	private Long tipPregleda;
	
	public Long getIdKlinike() {
		return idKlinike;
	}
	public void setIdKlinike(Long idKlinike) {
		this.idKlinike = idKlinike;
	}
	public String getIme() {
		return ime;
	}
	public void setIme(String ime) {
		this.ime = ime;
	}
	public String getPrezime() {
		return prezime;
	}
	public void setPrezime(String prezime) {
		this.prezime = prezime;
	}
	public Date getTermin() {
		return termin;
	}
	public void setTermin(Date termin) {
		this.termin = termin;
	}
	public Long getTipPregleda() {
		return tipPregleda;
	}
	public void setTipPregleda(Long tipPregleda) {
		this.tipPregleda = tipPregleda;
	}

	
}
