package com.example.demo.domain;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "users")
@NamedQuery(name = "findAllUsers", query = "from User")
public class User implements Serializable {

	private static final long serialVersionUID = 1L;

	// Atributos propios
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "username", unique = true, nullable = false)
	private String username;

	@Column(name = "userlastname")
	private String userlastname;

	@Column(name = "dni", length = 9)
	private String dni;

	@Column(name = "active")
	private Boolean active;

	@Column(name = "birthday")
	private LocalDate birthday;

	// asociaciones
	@JsonIgnore // ignora este atributo entero a la hora de transformar a json
	@OneToMany(mappedBy = "user") // no es owner, el mapeo se establece en la otra clase
	private List<Task> tasks = new ArrayList<>();

	@OneToOne
	@JoinColumn(name = "id_billinginfo", foreignKey = @ForeignKey(name = "fk_user_billinginfo"))
	private BillingInfo billinginfo;

	public User() {
	}

	public User(Long id, String username, String userlastname, String dni, Boolean active, LocalDate birthday) {
		this.id = id;
		this.username = username;
		this.userlastname = userlastname;
		this.dni = dni;
		this.active = active;
		this.birthday = birthday;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Long getId() {
		return id;
	}

	public String getUsername() {
		return username;
	}

	public String getUserlastname() {
		return userlastname;
	}

	public String getDni() {
		return dni;
	}

	public Boolean getActive() {
		return active;
	}

	public LocalDate getBirthday() {
		return birthday;
	}

	public List<Task> getTasks() {
		return tasks;
	}

	public BillingInfo getBillinginfo() {
		return billinginfo;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public void setUserlastname(String userlastname) {
		this.userlastname = userlastname;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public void setActive(Boolean active) {
		this.active = active;
	}

	public void setBirthday(LocalDate birthday) {
		this.birthday = birthday;
	}

	public void setTasks(List<Task> tasks) {
		this.tasks = tasks;
	}

	public void setBillinginfo(BillingInfo billinginfo) {
		this.billinginfo = billinginfo;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", userlastname=" + userlastname + ", dni=" + dni
				+ ", active=" + active + ", birthday=" + birthday + ", tasks=" + tasks + ", billinginfo=" + billinginfo
				+ "]";
	}

}
