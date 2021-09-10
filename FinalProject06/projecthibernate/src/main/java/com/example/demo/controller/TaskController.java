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

import com.example.demo.domain.Task;
import com.example.demo.service.TaskService;

@RestController
@RequestMapping("/api")
public class TaskController {

	private final Logger log = LoggerFactory.getLogger(UserController.class);
	
	private TaskService taskService;

	public TaskController(TaskService taskService) {
		this.taskService = taskService;
	}
	
	@GetMapping("/tasks")
	public List<Task> findAll(){
		return this.taskService.findAll();
	}
	
	@GetMapping("/tasks/{id}")
	public ResponseEntity<Task> findById(@PathVariable Long id) {
		log.info("REST request to find one task");
		Optional<Task> taskOpt = this.taskService.findById(id);
		if (taskOpt.isPresent())
			return ResponseEntity.ok(taskOpt.get());
		return ResponseEntity.notFound().build();
	}
	
	@GetMapping("/tasks/title/{title}")
	public List<Task> findAllByTitle(@PathVariable String title){
		return this.taskService.findAllByTitle(title);
	}
	
	@GetMapping("/tasks/description/{description}")
	public List<Task> findAllByDescription(@PathVariable String description){
		return this.taskService.findAllByDescription(description);
	}
	
	@GetMapping("/tasks/finished/{finished}")
	public List<Task> findAllFinished(@PathVariable Boolean finished){
		return this.taskService.findAllByFinished(finished);
	}
	
	@GetMapping("/tasks/deliverydate/{deliverydate}")
	public List<Task> findAllDeliveryDate(@PathVariable LocalDate deliverydate){
		return this.taskService.findAllByDeliveryDate(deliverydate);
	}
	
	// Create
	@PostMapping("/tasks")
	public ResponseEntity<Task> create(@RequestBody Task task) {
		if (task.getId() != null) {
			log.warn("Trying to create a new task with existent id");
			return ResponseEntity.badRequest().build();
		}
		Task result = this.taskService.save(task);
		if (result != null && result.getId() != null) {
			return ResponseEntity.ok(result);
		}
		return ResponseEntity.internalServerError().build();
	}
	
	// Update 
	@PutMapping("/tasks/{id}")
	public ResponseEntity<Task> update(@RequestBody Task task) {
		if (task.getId() == null) {
			return ResponseEntity.badRequest().build();
		}
		return ResponseEntity.ok(this.taskService.update(task));
	}

}