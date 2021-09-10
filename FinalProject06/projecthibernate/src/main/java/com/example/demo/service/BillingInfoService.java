package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import com.example.demo.domain.BillingInfo;

public interface BillingInfoService {

	Optional<BillingInfo> findById(Long id);
	
	List<BillingInfo> findAll();
	
	List<BillingInfo> findAllByFullname(String fullname);
	
	List<BillingInfo> findAllByAddress(String address);
	
	List<BillingInfo> findAllByPhoneNumber(String phonenumber);
	
	
	BillingInfo save(BillingInfo billingInfo);
	
	BillingInfo update(BillingInfo billingInfo);
	
}