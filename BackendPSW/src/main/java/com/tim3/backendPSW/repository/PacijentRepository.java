package com.tim3.backendPSW.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tim3.backendPSW.models.Pacijent;

public interface PacijentRepository extends JpaRepository<Pacijent, Long>{

	Pacijent getOneByUserId(Long id);
}
