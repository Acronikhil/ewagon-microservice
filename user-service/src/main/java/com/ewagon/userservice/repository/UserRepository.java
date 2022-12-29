package com.ewagon.userservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ewagon.userservice.entity.Users;
import com.ewagon.userservice.to.UserTo;

@Repository
public interface UserRepository extends JpaRepository<Users, Long> {

	public Users findByEmail(String email);
	
}
