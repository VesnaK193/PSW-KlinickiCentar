package com.tim3.backendPSW.models;

import java.util.Date;

public class PretragaKlinikaDTO {
	private TipPregleda tipPregleda;
	private Date termin;
	private String adresa;
	private String naziv;
	
	public TipPregleda getTipPregleda() {
		return tipPregleda;
	}
	public void setTipPregleda(TipPregleda tipPregleda) {
		this.tipPregleda = tipPregleda;
	}
	public Date getTermin() {
		return termin;
	}
	public void setTermin(Date termin) {
		this.termin = termin;
	}
	public String getAdresa() {
		return adresa;
	}
	public void setAdresa(String adresa) {
		this.adresa = adresa;
	}
	public String getNaziv() {
		return naziv;
	}
	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}
	
	public PretragaKlinikaDTO(TipPregleda tipPregleda, Date termin,String adresa,String naziv) {
		super();
		this.tipPregleda = tipPregleda;
		this.termin = termin;
		this.adresa = adresa;
		this.naziv = naziv;
		
	}

}
