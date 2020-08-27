package com.tim3.backendPSW.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tim3.backendPSW.models.User;

public interface UserRepository extends JpaRepository<User, Long>{	

	List<User> findAllByRole(String role);
	List<User> findAllById(Long id);
}
