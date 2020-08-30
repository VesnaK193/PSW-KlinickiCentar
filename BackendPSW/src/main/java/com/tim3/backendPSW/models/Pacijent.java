package com.tim3.backendPSW.models;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
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
@Table(name = "pacijent")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class Pacijent {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@OneToOne
	@JoinColumn(name = "user_id")
	private User user;

	@OneToOne
	@JoinColumn(name = "zdravstvenikarton_id")
	private ZdravstveniKarton zdravstveniKarton;
	
	@JsonIgnore
	@OneToMany//(mappedBy = "sala", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private Set<Pregled> pregledi = new HashSet<Pregled>();

	public Pacijent() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public ZdravstveniKarton getZdravstveniKarton() {
		return zdravstveniKarton;
	}

	public void setZdravstveniKarton(ZdravstveniKarton zdravstveniKarton) {
		this.zdravstveniKarton = zdravstveniKarton;
	}
	
	public Collection<Pregled> getPregledi() {
		return pregledi;
	}

	public void addPregled(Pregled pregled) {
		if (this.pregledi.contains(pregled))
			return;
		pregledi.add(pregled);
		pregled.setPacijent(this);
	}

	public void removePregled(Pregled pregled) {
		if (!pregledi.contains(pregled))
			return;
		pregledi.remove(pregled);
		pregled.setPacijent(null);
	}
}
