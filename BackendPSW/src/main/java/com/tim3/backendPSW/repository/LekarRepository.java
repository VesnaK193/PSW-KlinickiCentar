package com.tim3.backendPSW.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tim3.backendPSW.models.Lekar;

public interface LekarRepository extends JpaRepository<Lekar, Long>{

	List<Lekar> findAllByKlinikaId(Long id);
}
