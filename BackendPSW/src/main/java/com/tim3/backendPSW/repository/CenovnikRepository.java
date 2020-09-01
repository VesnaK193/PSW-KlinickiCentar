package com.tim3.backendPSW.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tim3.backendPSW.models.Cenovnik;

public interface CenovnikRepository extends JpaRepository<Cenovnik, Long>{
	List<Cenovnik> findAllByTipPregledaId(Long id);
}
