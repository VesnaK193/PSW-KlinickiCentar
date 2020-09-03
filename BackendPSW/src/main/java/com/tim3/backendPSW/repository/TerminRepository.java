package com.tim3.backendPSW.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tim3.backendPSW.models.Termin;

public interface TerminRepository extends JpaRepository<Termin, Long>{
 List<Termin> findAllByRadniKalendarId(Long id);
}
