package com.akagami.micro.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.akagami.micro.models.User;
import com.akagami.micro.services.UserService;

@RestController
@RequestMapping("/api/v1/")
public class UserEntityController {

	@Autowired
	private final UserService userService;
	
	public UserEntityController(UserService userService)
	{
		this.userService = userService;
	}
	
	@PostMapping("/save")
	public User saveUser(@RequestBody User user){
		
		return userService.saveUser(user);
	}
	@GetMapping("/users")
	public List<User> getAllUsers(){
		return userService.getAllUsers();
	}
	@GetMapping("/user/{id}")
	public ResponseEntity<User> getUserById(@PathVariable("id") String id){
		
		User user = new User();
		user = userService.getUserById(id);
		return ResponseEntity.ok(user);
	}
	@DeleteMapping("/user/delete/{id}")
	public ResponseEntity<Map<String, Boolean>> deleteUser(@PathVariable("id") String id){
		boolean deleted = false;
		deleted = userService.deleteUser(id);
		Map<String, Boolean> responseMap = new HashMap<>();
		responseMap.put("deleted", deleted);
		return ResponseEntity.ok(responseMap);
	}
	
	@PutMapping("/user/update/{id}")
	public ResponseEntity<User> updateUser(@PathVariable("id") String id, @RequestBody User user)
	{
		user = userService.updateUser(id, user);
		return ResponseEntity.ok(user);
	}
}
