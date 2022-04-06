package com.group2.peterengland.controllers;

import java.util.List;

import javax.persistence.EntityNotFoundException;

import com.group2.peterengland.models.User;
import com.group2.peterengland.services.UserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/user")
public class UserController {

	private final UserServices userServices;
	
	@Autowired
	public UserController(UserServices userServices) {
		this.userServices = userServices;
	}
	
	//get list of all the users
	@GetMapping
	public List<User> getUsers() {
		return userServices.getAllUsers();
	}
	
	//add new user
	@PostMapping
	public String createUser(@RequestBody User user) {
		return userServices.createNewUser(user);
	}
	
	//get user by id
	@GetMapping("/{id}")
	public String getUser(@PathVariable int id) {
		try {
			User user = userServices.getUserById(id);
			return user.toString();
		} catch (EntityNotFoundException e) {
			return "No user with that id found";
		}
	}

	
	@PostMapping("/{id}")
	public String updateAddress(@PathVariable int id ,@RequestBody User user) {

		return userServices.updateUser(id, user);
	}

	@DeleteMapping
	public String deleteUser(@RequestParam int id) {
		return userServices.deleteUser(id);
	}
	
}
