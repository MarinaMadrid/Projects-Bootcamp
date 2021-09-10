package com.example.demo.dao;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import com.example.demo.domain.Task;

public interface TaskDAO {

	// Filtros
	Optional<Task> findById(Long id);
	
	List<Task> findAllFromSession();
	List<Task> findAllFromEntityManager();
	
	List<Task> findAllByTitle(String title);
	
	List<Task> findAllByDescription(String description);
	
	List<Task> findAllByFinished(Boolean finished);
	
	List<Task> findAllByDeliveryDate(LocalDate deliverydate);
	
	Task update(Task task);
	
}