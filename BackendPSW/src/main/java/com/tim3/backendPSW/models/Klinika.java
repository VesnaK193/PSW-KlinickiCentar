package com.tim3.backendPSW.models;

import java.util.ArrayList;
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
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "klinika")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class Klinika {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "naziv", nullable = false)
	private String naziv;

	@Column(name = "adresa", nullable = false)
	private String adresa;

	@Column(name = "opis", nullable = false)
	private String opis;

	@JsonIgnore
	@OneToMany(mappedBy = "klinika")
	private Collection<Lekar> lekari = new ArrayList<Lekar>();

	@JsonIgnore
	@OneToMany(mappedBy = "klinika")
	private Collection<Sala> sale = new ArrayList<Sala>();

	@JsonIgnore
	@OneToMany(mappedBy = "klinika", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private Set<AdministratorKlinike> adminiKlinike = new HashSet<AdministratorKlinike>();
	
	@JsonIgnore
	@OneToMany(mappedBy = "klinika", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private Set<Cenovnik> cenovnici = new HashSet<Cenovnik>();

	public Klinika() {
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

	public String getAdresa() {
		return adresa;
	}

	public void setAdresa(String adresa) {
		this.adresa = adresa;
	}

	public String getOpis() {
		return opis;
	}

	public void setOpis(String opis) {
		this.opis = opis;
	}

	public Collection<Lekar> getLekari() {
		return lekari;
	}

	public void addLekar(Lekar lekar) {
		if (this.lekari.contains(lekar))
			return;
		lekari.add(lekar);
		lekar.setKlinika(this);
	}

	public void removeLekar(Lekar lekar) {
		if (!lekari.contains(lekar))
			return;
		lekari.remove(lekar);
		lekar.setKlinika(null);
	}

	public Collection<Sala> getSale() {
		return sale;
	}

	public void addSala(Sala sala) {
		if (this.sale.contains(sala))
			return;
		sale.add(sala);
		sala.setKlinika(this);
	}

	public void removeSala(Sala sala) {
		if (!sale.contains(sala))
			return;
		sale.remove(sala);
		sala.setKlinika(null);
	}
	public Collection<Cenovnik> getCenovnici() {
		return cenovnici;
	}

	public void addCenovnik(Cenovnik cenovnik) {
		if (this.cenovnici.contains(cenovnik))
			return;
		cenovnici.add(cenovnik);
		cenovnik.setKlinika(this);
	}

	public void removeCenovnik(Cenovnik cenovnik) {
		if (!cenovnici.contains(cenovnik))
			return;
		cenovnici.remove(cenovnik);
		cenovnik.setKlinika(null);
	}

	@JsonIgnore
	public Set<AdministratorKlinike> getAdministratoriKlinike() {
		return adminiKlinike;
	}

	public void setAdministratoriKlinike(Set<AdministratorKlinike> adminiKlinike) {
		this.adminiKlinike = adminiKlinike;
	}
}