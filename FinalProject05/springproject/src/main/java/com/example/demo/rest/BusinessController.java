package com.example.demo.rest;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.domain.Business;
import com.example.demo.dto.CountDTO;
import com.example.demo.service.BusinessService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@RestController
@RequestMapping("/api")

public class BusinessController {
	
	private final Logger log = LoggerFactory.getLogger(BusinessController.class);

	// dependencia
	private BusinessService businessService; 
	
	public BusinessController(BusinessService businessService) {
		this.businessService = businessService;
	}
	

	/* ============= SPRING CRUD METHODS ================ */
	
	/**
	 * http://localhost:8080/api/businesses/1
	 */
	@GetMapping("/businesses/{id}")
	@ApiOperation("Finding a business by id")
	public ResponseEntity<Business> findById(@ApiParam("The business's primary key") @PathVariable Long id) {
		log.info("REST request to find one empresa");
		Optional<Business> businessOpt = this.businessService.findById(id);
		
		if (businessOpt.isPresent()) 
			return ResponseEntity.ok(businessOpt.get());
		return ResponseEntity.notFound().build();	
	}
	
	/**
	 * http://localhost:8080/api/businesses
	 */
	@GetMapping("/businesses")
	@ApiOperation("Showing a list with all businesses")
	public List<Business> findAll(){
		log.info("REST request to find all empresas");
		return this.businessService.findAll();
	}
	
	// create one
	@PostMapping("/businesses")
	@ApiOperation("Creating a new bsuiness")
	public ResponseEntity<Business> create(@RequestBody Business business){
		log.info("REST request to create a new business");
		
		if (business.getId() != null) { // HAY ID - LA EMPRESA YA EXISTE NO PUEDO CREARLA DE NUEVO
			log.warn("Trying to create a new business with existent id");
			return ResponseEntity.badRequest().build();
		}
		return ResponseEntity.ok(this.businessService.save(business));
	}
	
	// update 
	@PutMapping("/businesses")
	@ApiOperation("Updating a business")
	public ResponseEntity<Business> update(@RequestBody Business business) {
		log.info("REST request to update an existing business");
		if (business.getId() == null) { // NO HAY ID - POR TANTO NO EXISTE LA EMPRESA A ACTUALIZAR
			log.warn("Trying to update an existing business without id");
			return ResponseEntity.badRequest().build();
		}
		return ResponseEntity.ok(this.businessService.save(business));
	}
	
	// delete one
	@DeleteMapping("/businesses/{id}")
	@ApiOperation("Deleting a business for id")
	public ResponseEntity<Business> delete(@PathVariable Long id){
		log.info("REST request to delete an existing business");
		this.businessService.deleteById(id);
		return ResponseEntity.noContent().build();
	}
	
	// delete all
	@DeleteMapping("/businesses")
	@ApiOperation("Deleting all businesses")
	public ResponseEntity<Business> deleteAll(){
		log.info("REST request to delete all businesses");
		
		this.businessService.deleteAll();
		
		return ResponseEntity.noContent().build();
		
	}
	
	@GetMapping("/businesses/count")
	@ApiOperation("Returning the total number of businesses")
	public ResponseEntity<CountDTO> count(){
		log.info("REST request to count all businesses");
		Long count = this.businessService.count();
		CountDTO dto = new CountDTO(count);
		dto.setMessage("Have a nice day :)");
		return ResponseEntity.ok(dto);
	}
	
	
	/* ============= CUSTOM CRUD METHODS ================ */

	
	@GetMapping("/businesses/name/{namebusiness}")
	@ApiOperation("Finding a business by name")
	public List<Business> findByNameBusiness(@PathVariable String nameBusiness){
		return this.businessService.findByNameBusiness(nameBusiness);
	}
	
	@GetMapping("/businesses/year/{namebusiness}")
	@ApiOperation("Finding a business by years in the market")
	public List<Business> findByYearBusiness(@PathVariable Integer years){
		return this.businessService.findByYearBusiness(years);
	}
	
	@GetMapping("/businesses/users/{namebusiness}")
	@ApiOperation("Finding a business by number of employees")
	public List<Business> findByNumUsersBusiness(@PathVariable Integer numUsers){
		return this.businessService.findByNumUsersBusiness(numUsers);
	}
	
	@GetMapping("/businesses/products/{namebusiness}")
	@ApiOperation("Finding a business by number of generated products")
	public List<Business> findByNumProductsBusiness(@PathVariable Integer numProducts){
		return this.businessService.findByNumProductsBusiness(numProducts);
	}
	
	@GetMapping("/businesses/billing")
	@ApiOperation("Generating the billing of all businesses")
	public List<Business> createBilling() {
		log.info("REST request to billing all businesss");
		List<Business> businesses = this.businessService.findAll();
		for (Business business : businesses) {
			Integer calculationBusiness = (business.getNumUsers() * business.getNumProducts()) / business.getYears();
			business.setBilling(calculationBusiness);
		}
		return businesses;
	}
	
}