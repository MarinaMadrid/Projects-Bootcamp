package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import com.example.demo.domain.User;


public interface UserService {

	// spring repository methods
	
	List<User> findAll();

	Optional<User> findById(Long id);
	
	Long count();
	
	User save(User user);
	
	void deleteById(Long id);
	
	void deleteAll();
	
	// custom methods
	
	List<User> findByUsername(String username);
	
	List<User> findByUserEmail(String userEmail);
	
	List<User> findByUserPost(String userPost);
	
}