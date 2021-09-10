package com.example.demo.dao;

import java.util.List;
import java.util.Optional;

import com.example.demo.domain.BillingInfo;

public interface BillingInfoDAO {

	// Filtros
	Optional<BillingInfo> findById(Long id);
	
	List<BillingInfo> findAllFromSession();
	List<BillingInfo> findAllFromEntityManager();
	
	List<BillingInfo> findAllByFullname(String fullname);
	
	List<BillingInfo> findAllByAddress(String address);
	
	List<BillingInfo> findAllByPhoneNumber(String phonenumber);
	
	BillingInfo update(BillingInfo billingInfo);
	
}