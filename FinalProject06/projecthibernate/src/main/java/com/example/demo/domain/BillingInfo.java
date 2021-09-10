package com.example.demo.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "billings")
@NamedQuery(name = "findAllBillingsInfo", query = "from BillingInfo")
public class BillingInfo implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "fullname", unique = true, nullable = false)
	private String fullname;

	@Column(name = "address", length = 300)
	private String address;

	@Column(name = "phonenumber", length = 9)
	private String phonenumber;

	@Column(name = "dni", length = 9)
	private String dni;

	@OneToOne(mappedBy = "billinginfo")
	private User user;

	public BillingInfo() {
	}

	public BillingInfo(Long id, String fullname, String address, String phonenumber, String dni) {
		this.id = id;
		this.fullname = fullname;
		this.address = address;
		this.phonenumber = phonenumber;
		this.dni = dni;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Long getId() {
		return id;
	}

	public String getFullname() {
		return fullname;
	}

	public String getAddress() {
		return address;
	}

	public String getPhonenumber() {
		return phonenumber;
	}

	public String getDni() {
		return dni;
	}

	public User getUser() {
		return user;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setFullname(String fullname) {
		this.fullname = fullname;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public void setPhonenumber(String phonenumber) {
		this.phonenumber = phonenumber;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "BillingInfo [id=" + id + ", fullname=" + fullname + ", address=" + address + ", phonenumber="
				+ phonenumber + ", dni=" + dni + ", user=" + user + "]";
	}

}