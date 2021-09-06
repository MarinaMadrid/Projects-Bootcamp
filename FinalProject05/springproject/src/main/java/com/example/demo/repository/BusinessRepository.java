package com.example.demo.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.domain.Business;

@Repository
public interface BusinessRepository extends JpaRepository<Business, Long>{

	Optional<Business> findById(Long id);
	
	List<Business> findByNameBusiness(String nameBusiness);
	
	List<Business> findByYears(Integer years);
	
	List<Business> findByNumUsers(Integer numUsers);
	
	List<Business> findByNumProducts(Integer numProducts);
	
	List<Business> findByBilling(Integer billing);

}