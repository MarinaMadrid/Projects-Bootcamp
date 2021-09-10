package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.domain.BillingInfo;
import com.example.demo.service.BillingInfoService;


@RestController
@RequestMapping("/api")
public class BillingInfoController {

private final Logger log = LoggerFactory.getLogger(BillingInfoController.class);
	
	private BillingInfoService billingInfoService;

	public BillingInfoController(BillingInfoService billingInfoService) {
		this.billingInfoService = billingInfoService;
	}
	
	@GetMapping("/billings")
	public List<BillingInfo> findAll(){
		return this.billingInfoService.findAll();
	}
	
	@GetMapping("/billings/{id}")
	public ResponseEntity<BillingInfo> findById(@PathVariable Long id) {
		log.info("REST request to find one billingInfo");
		Optional<BillingInfo> billingInfoOpt = this.billingInfoService.findById(id);
		if (billingInfoOpt.isPresent())
			return ResponseEntity.ok(billingInfoOpt.get());
		return ResponseEntity.notFound().build();
	}
	
	@GetMapping("/billings/fullname/{fullname}")
	public List<BillingInfo> findAllByFullname(@PathVariable String fullname){
		return this.billingInfoService.findAllByFullname(fullname);
	}
	
	@GetMapping("/billings/address/{address}")
	public List<BillingInfo> findAllByAddress(@PathVariable String address){
		return this.billingInfoService.findAllByAddress(address);
	}
	
	@GetMapping("/billings/phonenumber/{phonenumber}")
	public List<BillingInfo> findAllByPhoneNumber(@PathVariable String phonenumber){
		return this.billingInfoService.findAllByPhoneNumber(phonenumber);
	}
	
	// Create
	@PostMapping("/billings")
	public ResponseEntity<BillingInfo> create(@RequestBody BillingInfo billingInfo) {
		if (billingInfo.getId() != null) {
			log.warn("Trying to create a new billingInfo with existent id");
			return ResponseEntity.badRequest().build();
		}
		BillingInfo result = this.billingInfoService.save(billingInfo);
		if (result != null && result.getId() != null) {
			return ResponseEntity.ok(result);
		}
		return ResponseEntity.internalServerError().build();
	}
	
	// Update 
	@PutMapping("/billings/{id}")
	public ResponseEntity<BillingInfo> update(@RequestBody BillingInfo billingInfo) {
		if (billingInfo.getId() == null) {
			return ResponseEntity.badRequest().build();
		}
		return ResponseEntity.ok(this.billingInfoService.update(billingInfo));
	}

	
}