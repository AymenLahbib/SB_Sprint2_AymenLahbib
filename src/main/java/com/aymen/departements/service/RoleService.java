package com.aymen.departements.service;

import java.util.List;

import com.aymen.departements.entities.Role;


public interface RoleService {

	List <Role> findAll();
	Role findByRole(String role);



}
