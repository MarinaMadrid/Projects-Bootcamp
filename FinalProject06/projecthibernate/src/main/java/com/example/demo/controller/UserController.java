package com.example.demo.controller;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.domain.User;
import com.example.demo.service.UserService;

@RestController
@RequestMapping("/api")
public class UserController {

	private final Logger log = LoggerFactory.getLogger(UserController.class);
	
	private UserService userService;

	public UserController(UserService userService) {
		this.userService = userService;
	}
	
	@GetMapping("/users")
	public List<User> findAll(){
		return this.userService.findAll();
	}
	
	@GetMapping("/users/{id}")
	public ResponseEntity<User> findById(@PathVariable Long id) {
		log.info("REST request to find one user");
		Optional<User> userOpt = this.userService.findById(id);
		if (userOpt.isPresent())
			return ResponseEntity.ok(userOpt.get());
		return ResponseEntity.notFound().build();
	}
	
	@GetMapping("/users/username/{username}")
	public List<User> findAllByUsername(@PathVariable String username){
		return this.userService.findAllByUsername(username);
	}
	
	@GetMapping("/users/userlastname/{userlastname}")
	public List<User> findAllByUserlastname(@PathVariable String userlastname){
		return this.userService.findAllByUserlastname(userlastname);
	}
	
	@GetMapping("/users/dni/{dni}")
	public List<User> findAllByDNI(@PathVariable String dni){
		return this.userService.findAllByDNI(dni);
	}

	@GetMapping("/users/active/{active}")
	public List<User> findAllByActive(@PathVariable Boolean active){
		return this.userService.findAllByActive(active);
	}
	
	@GetMapping("/users/birthday/{birthday}")
	public List<User> findAllByBirthday(@PathVariable LocalDate birthday){
		return this.userService.findAllByBirthday(birthday);
	}
	
	// Create
	@PostMapping("/users")
	public ResponseEntity<User> create(@RequestBody User user) {
		if (user.getId() != null) {
			log.warn("Trying to create a new user with existent id");
			return ResponseEntity.badRequest().build();
		}
		User result = this.userService.save(user);
		if (result != null && result.getId() != null) {
			return ResponseEntity.ok(result);
		}
		return ResponseEntity.internalServerError().build();
	}
	
	// Update 
	@PutMapping("/users/{id}")
	public ResponseEntity<User> update(@RequestBody User user) {
		if (user.getId() == null) {
			return ResponseEntity.badRequest().build();
		}
		return ResponseEntity.ok(this.userService.update(user));
	}

	
}