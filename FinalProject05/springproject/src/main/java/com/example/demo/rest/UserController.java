package com.example.demo.rest;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.domain.User;
import com.example.demo.dto.CountDTO;
import com.example.demo.service.UserService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@RestController
@RequestMapping("/api")

public class UserController {

	private final Logger log = LoggerFactory.getLogger(UserController.class);
	
	// dependencia
	private UserService userService;
	
	public UserController(UserService userService) {
		this.userService = userService;
	}
	

	/* ============= SPRING CRUD METHODS ================ */
	
	/**
	 * http://localhost:8080/api/users/1
	 */
	@GetMapping("/users/{id}")
	@ApiOperation("Finding an user by id")
	public ResponseEntity<User> findById(@ApiParam("Clave primaria usuario") @PathVariable Long id) {
		log.info("REST request to find one user");

		Optional<User> userOpt = this.userService.findById(id);
		
		if (userOpt.isPresent()) 
			return ResponseEntity.ok(userOpt.get());
		
		return ResponseEntity.notFound().build();	
	}
	
	/**
	 * http://localhost:8080/api/businesses
	 */
	@GetMapping("/users")
	@ApiOperation("Showing a list with all users")
	public List<User> findAll(){
		log.info("REST request to find all users");
		return this.userService.findAll();
	}
	
	// create one
	@PostMapping("/users")
	@ApiOperation("Creating a new user")
	public ResponseEntity<User> create(@RequestBody User user){
		log.info("REST request to create a new user");
		
		if (user.getId() != null) { 
			log.warn("Trying to create a new user with existent id");
			return ResponseEntity.badRequest().build();
		}

		return ResponseEntity.ok(this.userService.save(user));
		
	}
	
	// update 
	@PutMapping("/users/{id}")
	@ApiOperation("Updating an user")
	public ResponseEntity<User> update(@RequestBody User user) {
		log.info("REST request to update an existing user");
		if (user.getId() == null) { // NO HAY ID - POR TANTO NO EXISTE LA EMPRESA A ACTUALIZAR
			log.warn("Trying to update an existing user without id");
			return ResponseEntity.badRequest().build();
		}
		
		return ResponseEntity.ok(this.userService.save(user));
		
	}
	
	// delete one
	@DeleteMapping("/users/{id}")
	@ApiOperation("Deleting an user by id")
	public ResponseEntity<User> delete(@PathVariable Long id){
		log.info("REST request to delete an existing user");
		
		this.userService.deleteById(id);
		System.out.println("Se ha borrado el usuario.");
		return ResponseEntity.noContent().build();
		
	}
	
	// delete all
	@DeleteMapping("/users")
	@ApiOperation("Deleting all users")
	public ResponseEntity<User> deleteAll(){
		log.info("REST request to delete all users");
		
		this.userService.deleteAll();
		System.out.println("Se ha borrado todos los usuarios.");
		return ResponseEntity.noContent().build();
		
	}
	
	@GetMapping("/users/count")
	@ApiOperation("Returning the total number of users")
	public ResponseEntity<CountDTO> count(){
		log.info("REST request to count all users");
		Long count = this.userService.count();
		CountDTO dto = new CountDTO(count);
		dto.setMessage("Have a nice day :)");
		return ResponseEntity.ok(dto);
	}
	
	
	/* ============= CUSTOM CRUD METHODS ================ */

	@GetMapping("/users/name/{username}")
	@ApiOperation("Finding an user by name")
	public List<User> findByUsername(@PathVariable String username){
		return this.userService.findByUsername(username);
	}
	
	@GetMapping("/users/email/{email}")
	@ApiOperation("Finding an user by email")
	public List<User> findByUserEmail(@PathVariable String userEmail){
		return this.userService.findByUserEmail(userEmail);
	}
	
	@GetMapping("/users/post/{post}")
	@ApiOperation("Finding an user by post")
	public List<User> findByUserPost(@PathVariable String userPost){
		return this.userService.findByUserPost(userPost);
	}
	
}