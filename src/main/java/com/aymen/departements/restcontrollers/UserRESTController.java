package com.aymen.departements.restcontrollers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.aymen.departements.entities.User;
import com.aymen.departements.service.UserService;



@RestController
@RequestMapping("/api")
@CrossOrigin
public class UserRESTController {

	
	UserService userService;
	
	
	
	/*
	 @Override
	public User addRoleToUser(String username, String rolename) {
		User usr = UserRepository.findByUsername(username);
		Role r = roleRep.findByRole(rolename);
		
		usr.getRoles().add(r);
		return usr;
	}
	 */
	
	//@RequestMapping(method = RequestMethod.PUT)
	@RequestMapping(value="/{nom}/{role}",method = RequestMethod.PUT)
	public User changeUser(@PathVariable("nom") String nom, @PathVariable("role") String role ) {
		
	User abc= userService.addRoleToUser(nom,role);
	return userService.updateUser(abc);
	}
}
