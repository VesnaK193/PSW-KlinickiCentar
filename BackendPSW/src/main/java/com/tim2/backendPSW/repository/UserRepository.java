package com.tim2.backendPSW.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tim2.backendPSW.models.User;

public interface UserRepository extends JpaRepository<User, Long>{	
}
