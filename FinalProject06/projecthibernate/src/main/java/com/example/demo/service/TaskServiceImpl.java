package com.example.demo.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.demo.dao.TaskDAO;
import com.example.demo.domain.Task;
import com.example.demo.repository.TaskRepository;

@Service
public class TaskServiceImpl implements TaskService  {
	
	private TaskRepository taskRepository;
	private TaskDAO taskDAO;

	
	public TaskServiceImpl(TaskRepository taskRepository, TaskDAO taskDAO) {
		this.taskRepository = taskRepository;
		this.taskDAO = taskDAO;
	}
	

	@Override
	public Optional<Task> findById(Long id) {
		if(id == null || id == 0)
			return Optional.empty();
		return this.taskDAO.findById(id);
	}
	
	
	@Override
	public Task save(Task task) {
		if(task == null)
			return task;
		return this.taskRepository.save(task);
	}
	
	
	@Override
	public Task update(Task task) {
		return this.taskDAO.update(task);
	}
	
	
	@Override
	public List<Task> findAll() {
		//return this.taskDAO.findAllFromSession();
		return this.taskDAO.findAllFromEntityManager();
		//return this.taskRepository.findAll();
	}
	
	
	@Override
	public List<Task> findAllByTitle(String title) {
		return this.taskDAO.findAllByTitle(title);
	}
	
	
	@Override
	public List<Task> findAllByDescription(String description) {
		return this.taskDAO.findAllByDescription(description);
	}
	
	@Override
	public List<Task> findAllByFinished(Boolean finished) {
		return this.taskDAO.findAllByFinished(finished);
	}
	
	@Override
	public List<Task> findAllByDeliveryDate(LocalDate deliverydate) {
		return this.taskDAO.findAllByDeliveryDate(deliverydate);
	}

	
}