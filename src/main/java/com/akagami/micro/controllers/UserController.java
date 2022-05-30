package com.akagami.micro.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.akagami.micro.domain.UserTemplate;
import com.akagami.micro.repositories.UserRepository;

@RestController
@RequestMapping("/user")
public class UserController {
	@Autowired
	private UserRepository repo;
	@PostMapping("/save")
	public ResponseEntity<?> addUser(@RequestBody UserTemplate user){
		UserTemplate savedUser = this.repo.save(user);
		return ResponseEntity.ok(savedUser);
	}
	@GetMapping("/")
	public ResponseEntity<?> getUsers(){
		return ResponseEntity.ok(this.repo.findAll());
	}
	@PostMapping("/findByCity")
	public ResponseEntity<?> getUsersOfCity(@RequestBody UserTemplate user){
		List<UserTemplate> usersOfCity = this.repo.findByCity(user.getCity());
		return ResponseEntity.ok(usersOfCity);
	}
	@PostMapping("/findByCollegeAndCity")
	public ResponseEntity<?> getUsersOfCollege(@RequestBody UserTemplate user){
		List<UserTemplate> usersOfCity = this.repo.findUsingCityAndCollege(user.getCity(), user.getCollege());
		return ResponseEntity.ok(usersOfCity);
	}
}
