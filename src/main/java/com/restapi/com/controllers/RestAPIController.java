package com.restapi.com.controllers;


import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.restapi.com.entities.UserEntity;
import com.restapi.com.projections.UserListProjection;
import com.restapi.com.repositories.UserRepository;

import exceptions.UserNotFound;

@RestController
public class RestAPIController {
	
	private final UserRepository userRepo;
	
	RestAPIController(UserRepository userRepo){
		this.userRepo = userRepo;
	}
	
	
	@GetMapping("/users")
    public Iterable<UserListProjection> getUsers() {
		return userRepo.findBy();
    }
	
	@PostMapping("/users")
	  UserEntity addUser(@RequestBody UserEntity newUser) {
	    return userRepo.save(newUser);
	  }
	
	@GetMapping("/users/{user_id}")
	UserEntity getUserDetails(@PathVariable Long user_id)
	{
		return userRepo.findById(user_id).orElseThrow(() -> new UserNotFound(user_id));
	}
	
	@PutMapping("/users/{user_id}")
	UserEntity updateUserDetails(@RequestBody UserEntity userValue, @PathVariable long user_id)
	{
		UserEntity userToUpdate = userRepo.findById(user_id).get();
		userToUpdate.setGender(userValue.getGender());
		userToUpdate.setName(userValue.getName());
		return userRepo.save(userToUpdate);
	}
	
	@DeleteMapping("users/{user_id}")
	void deleteUser(@PathVariable long user_id)
	{
		userRepo.deleteById(user_id);
	}
	
	
	//
	
}
