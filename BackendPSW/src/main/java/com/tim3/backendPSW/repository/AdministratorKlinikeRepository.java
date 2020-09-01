package com.tim3.backendPSW.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tim3.backendPSW.models.AdministratorKlinike;

public interface AdministratorKlinikeRepository extends JpaRepository<AdministratorKlinike, Long>{	

	List<AdministratorKlinike> findAllByKlinikaId(Long id);
}
