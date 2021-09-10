package com.example.demo.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import com.example.demo.domain.Task;

public interface TaskService {

	Optional<Task> findById(Long id);
	
	List<Task> findAll();
	
	List<Task> findAllByTitle(String title);
	
	List<Task> findAllByDescription(String description);
	
	List<Task> findAllByFinished(Boolean finished);
	
	List<Task> findAllByDeliveryDate(LocalDate deliverydate);
	
	Task save(Task task);
	
	Task update(Task task);

}