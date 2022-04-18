package com.group2.peterengland.services;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import com.group2.peterengland.models.User;
import com.group2.peterengland.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServices {

	private final UserRepository userRepository;
	
	@Autowired
	public UserServices(UserRepository userRepository) {
		this.userRepository = userRepository;
	}
	
	public String createNewUser(User user) {
		Optional<User> optionalUser = userRepository.getUserByEmail(user.getEmail());
		
		if( optionalUser.isPresent() && optionalUser.get().getEmail().equals(user.getEmail())) {
			return "User already exists";
		}else {
			userRepository.save(user);
			return "new user added";
		}
	}
	
	public List<User> getAllUsers(){
		return userRepository.findAll();
	}
	
	public User getUserById(Integer id) throws EntityNotFoundException{
		return userRepository.getById(id);
	}

	public String updateUserAddress(Integer id, String address) {
		
		try {
			User user = userRepository.getById(id);
			user.setAddress(address);
			userRepository.save(user);
			
			return user.toString();
		} catch (Exception e) {
			return "No user with that id found";
		}

	}

	public String updateUser(Integer id,User n_user) {
		try {
			User user = userRepository.getById(id);
			user.setName(n_user.getName());
			user.setAddress(n_user.getAddress());
			user.setEmail(n_user.getEmail());
			userRepository.save(user);
			return user.toString();
		} catch (Exception e) {
			return "No user with that id found";
		}
	}

	public String deleteUser(int id) {
		try {
			userRepository.deleteById(id);
			return "user deleted";
		}catch (Exception e) {
			return "no user with that id found";
		}
	}
}
