package com.example.demo.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.demo.dao.UserDAO;
import com.example.demo.domain.User;
import com.example.demo.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {

	// private UserRepository userRepository;
	private UserDAO userDAO;
	
	public UserServiceImpl(UserRepository userRepository, UserDAO userDAO) {
		// this.userRepository = userRepository;
		this.userDAO = userDAO;
	}

	
	@Override
	public Optional<User> findById(Long id) {
		if(id == null || id == 0)
			return Optional.empty();
		return this.userDAO.findById(id);
	}
	
	
	@Override
	public User save(User user) {
		if(user == null)
			return user;	
		return this.userDAO.save(user);
	}
	
	
	@Override
	public User update(User user) {
		return this.userDAO.update(user);
	}
	
	
	@Override
	public List<User> findAll() {
		//return this.employeeDAO.findAllFromSession();
		 return this.userDAO.findAllFromEntityManager();
	}
	
	
	@Override
	public List<User> findAllByUsername(String username) {
		return this.userDAO.findAllByUsername(username);
	}
	
	
	@Override
	public List<User> findAllByUserlastname(String userlastname) {
		return this.userDAO.findAllByUserlastname(userlastname);
	}
	
	@Override
	public List<User> findAllByDNI(String dni) {
		return this.userDAO.findAllByDNI(dni);
	}
	
	@Override
	public List<User> findAllByActive(Boolean active) {
		return this.userDAO.findAllByActive(active);
	}
	
	@Override
	public List<User> findAllByBirthday(LocalDate birthday) {
		return this.userDAO.findAllByBirthday(birthday);
	}

	
}