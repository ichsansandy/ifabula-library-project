package com.ifabula.library.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ifabula.library.model.Role;

public interface RoleRepository extends JpaRepository<Role, Long>{
	
}
