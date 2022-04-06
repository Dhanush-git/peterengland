package com.group2.peterengland.repositories;

import java.util.Optional;

import com.group2.peterengland.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
	
	public Optional<User> getUserByEmail(String email);
}
