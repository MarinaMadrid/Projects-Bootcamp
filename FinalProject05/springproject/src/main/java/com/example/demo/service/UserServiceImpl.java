package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.example.demo.domain.User;
import com.example.demo.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {

	private final Logger log = LoggerFactory.getLogger(UserServiceImpl.class);
	
	private UserRepository userRepository;


	public UserServiceImpl(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	@Override
	public List<User> findAll() {
		log.info("Executing findAll users");
		return this.userRepository.findAll();
	}

	@Override
	public Optional<User> findById(Long id) {
		log.info("Executing findById");
		return this.userRepository.findById(id);
	}

	@Override
	public Long count() {
		log.info("Get total number of users");
		return this.userRepository.count();
	}

	@Override
	public User save(User user) {
		log.info("Creating / Updating a user");
		if(!this.validateUser(user)) 
			return null;
		User userDB = this.userRepository.save(user);
		return userDB;
	}

	private boolean validateUser(User user) {
		// null validation
		if (user == null) {
			log.warn("Trying to create null user");
			return false;
		}
		return true;
	}
	
	@Override
	public void deleteById(Long id) {
		log.info("Deleting user by id");
		if (id == null || id < 0 || id == 0) {
			log.warn("Trying to delete user with wrong id");
			return;
		}
		try {
			this.userRepository.deleteById(id);
		} catch (Exception e) {
			log.error("Error trying to delete user by id {}", id, e);
		}

	}

	@Override
	public void deleteAll() {
		log.info("Deleting all users");
		this.userRepository.deleteAll();
	}

	@Override
	public List<User> findByUsername(String username) {
		log.info("Executing findByUsername");
		if(!StringUtils.hasLength(username))
			return new ArrayList<>();
		return this.userRepository.findByUsername(username);
	}

	@Override
	public List<User> findByUserEmail(String userEmail) {
		log.info("Executing findByUserEmail");
		if(!StringUtils.hasLength(userEmail))
			return new ArrayList<>();
		return this.userRepository.findByUserEmail(userEmail);
	}

	@Override
	public List<User> findByUserPost(String userPost) {
		log.info("Executing findByUserPost");
		if(!StringUtils.hasLength(userPost))
			return new ArrayList<>();
		return this.userRepository.findByUserPost(userPost);
	}

}