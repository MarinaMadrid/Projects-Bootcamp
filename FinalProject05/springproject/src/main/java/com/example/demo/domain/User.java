package com.example.demo.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import io.swagger.annotations.ApiModelProperty;

@Entity
@Table(name = "users")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@ApiModelProperty("Primary key")
	private Long id;

	@ApiModelProperty("The employee's username")
	private String username;

	@ApiModelProperty("The employee's email")
	private String userEmail;

	@ApiModelProperty("The employee's password")
	private String password;

	@ApiModelProperty("The employee's post")
	private String userPost;

	public User() {
	}

	public Long getId() {
		return id;
	}

	public String getUsername() {
		return username;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public String getPassword() {
		return password;
	}

	public String getUserPost() {
		return userPost;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setUserPost(String userPost) {
		this.userPost = userPost;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", email=" + userEmail + ", password=" + password
				+ ", post=" + userPost + "]";
	}

}