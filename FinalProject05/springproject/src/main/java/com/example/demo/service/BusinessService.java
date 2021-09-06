package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import com.example.demo.domain.Business;


public interface BusinessService {
	
	// spring repository methods
	
	List<Business> findAll();

	Optional<Business> findById(Long id);
	
	Long count();
	
	Business save(Business business);
	
	void deleteById(Long id);
	
	void deleteAll();
	
	// custom methods
	
	List<Business> findByNameBusiness(String nameBusiness);
	
	List<Business> findByYearBusiness(Integer years);
	
	List<Business> findByNumUsersBusiness(Integer numUsers);
	
	List<Business> findByNumProductsBusiness(Integer numProducts);

	List<Business> createBilling();

	
}