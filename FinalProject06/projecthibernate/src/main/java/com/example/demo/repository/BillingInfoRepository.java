package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.domain.BillingInfo;

@Repository
public interface BillingInfoRepository extends JpaRepository<BillingInfo, Long> {

	// Filtros
	
	/*
	 * 
	 * BillingInfo save(BillingInfo billingInfo);
	 * BillingInfo update(BillingInfo billingInfo);
	 * 
	 * */

}