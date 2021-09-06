package com.example.demo.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.domain.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{

	Optional<User> findById(Long id);
	
	List<User> findByUsername(String username);
	
	List<User> findByUserEmail(String userEmail);
	
	List<User> findByPassword(String password);
	
	List<User> findByUserPost(String userPost);
	
}