package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.example.demo.domain.Business;
import com.example.demo.repository.BusinessRepository;

@Service
public class BusinessServiceImpl implements BusinessService {

	private final Logger log = LoggerFactory.getLogger(BusinessServiceImpl.class);
	private BusinessRepository businessRepository;
	
	
	public BusinessServiceImpl(BusinessRepository businessRepository) {
		this.businessRepository = businessRepository;
	}
	
	@Override
	public List<Business> findAll() {
		log.info("Executing findAll businesses");
		return this.businessRepository.findAll();
	}

	@Override
	public Optional<Business> findById(Long id) {
		log.info("Executing findById");
		return this.businessRepository.findById(id);
	}

	@Override
	public List<Business> findByNameBusiness(String nameBusiness) {
		log.info("Executing findByNameBusiness");
		if(!StringUtils.hasLength(nameBusiness))
			return new ArrayList<>();
		return this.businessRepository.findByNameBusiness(nameBusiness);
	}
	
	@Override
	public Long count() {
		log.info("Get total number of businesses");
		return this.businessRepository.count();
	}

	@Override
	public Business save(Business business) {
		log.info("Creating / Updating a business");
		if(!this.validateBusiness(business)) 
			return null;
		Business businessDB = this.businessRepository.save(business);
		return businessDB;
	}
	
	private boolean validateBusiness(Business business) {
		// null validation
		if (business == null) {
			log.warn("Trying to create null business");
			return false;
		}		
		return true;
	}

	@Override
	public void deleteById(Long id) {
		log.info("Deleting a business by id");
		if (id == null || id < 0 || id == 0) {
			log.warn("Trying to delete user with wrong id");
			return;
		}

		try {
			this.businessRepository.deleteById(id);
		} catch (Exception e) {
			log.error("Error trying to delete a business by id {}", id, e);
		}

	}

	@Override
	public void deleteAll() {
		log.info("Deleting all businesses");
		this.businessRepository.deleteAll();
	}

	@Override
	public List<Business> findByYearBusiness(Integer years) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Business> findByNumUsersBusiness(Integer numUsers) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Business> findByNumProductsBusiness(Integer numProducts) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Business> createBilling() {
		// TODO Auto-generated method stub
		return null;
	}


}