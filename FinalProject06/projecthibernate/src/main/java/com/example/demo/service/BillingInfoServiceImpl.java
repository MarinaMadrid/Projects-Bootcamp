package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.demo.dao.BillingInfoDAO;
import com.example.demo.domain.BillingInfo;
import com.example.demo.repository.BillingInfoRepository;

@Service
public class BillingInfoServiceImpl implements BillingInfoService {

	
	private BillingInfoRepository billingInfoRepository;
	private BillingInfoDAO billingInfoDAO;

	
	public BillingInfoServiceImpl(BillingInfoRepository billingInfoRepository, BillingInfoDAO billingInfoDAO) {
		this.billingInfoRepository = billingInfoRepository;
		this.billingInfoDAO = billingInfoDAO;
	}
	

	@Override
	public Optional<BillingInfo> findById(Long id) {
		if(id == null || id == 0)
			return Optional.empty();
		return this.billingInfoDAO.findById(id);
	}
	
	
	@Override
	public BillingInfo save(BillingInfo billingInfo) {
		
		if(billingInfo == null)
			return billingInfo;
		
		return this.billingInfoRepository.save(billingInfo);
	}
	
	
	@Override
	public BillingInfo update(BillingInfo billingInfo) {
		return this.billingInfoDAO.update(billingInfo);
	}
	
	
	@Override
	public List<BillingInfo> findAll() {
		return this.billingInfoDAO.findAllFromEntityManager();
	}
	
	
	@Override
	public List<BillingInfo> findAllByFullname(String fullname) {
		return this.billingInfoDAO.findAllByFullname(fullname);
	}
	
	
	@Override
	public List<BillingInfo> findAllByAddress(String address) {
		return this.billingInfoDAO.findAllByAddress(address);
	}
	
	@Override
	public List<BillingInfo> findAllByPhoneNumber(String phonenumber) {
		return this.billingInfoDAO.findAllByPhoneNumber(phonenumber);
	}

}