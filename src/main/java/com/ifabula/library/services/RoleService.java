package com.ifabula.library.services;

import java.util.List;

import javax.transaction.Transactional;

import com.ifabula.library.model.Role;
import com.ifabula.library.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class RoleService {
	@Autowired
	private RoleRepository repository;
	public List<Role> listAll(){
		System.out.println("hasil: " + repository.findAll());
		return repository.findAll();
	}
}
