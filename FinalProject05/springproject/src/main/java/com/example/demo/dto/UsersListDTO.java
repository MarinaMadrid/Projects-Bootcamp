package com.example.demo.dto;

import java.util.List;

import com.example.demo.domain.User;

public class UsersListDTO {

	private List<User> users;
	
	public UsersListDTO() {}

	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}
	
}