package com.example.demo.dto;

import java.util.List;

import com.example.demo.domain.Business;

public class BusinessesListDTO {

	private List<Business> businesses;

	public BusinessesListDTO() {}

	public List<Business> getEmpresas() {
		return businesses;
	}

	public void setEmpresas(List<Business> businesses) {
		this.businesses = businesses;
	}

}
