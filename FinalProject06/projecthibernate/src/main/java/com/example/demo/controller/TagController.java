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

import com.example.demo.domain.Tag;
import com.example.demo.service.TagService;

@RestController
@RequestMapping("/api")
public class TagController {

	private final Logger log = LoggerFactory.getLogger(UserController.class);
	
	private TagService tagService;

	public TagController(TagService tagService) {
		this.tagService = tagService;
	}
	
	@GetMapping("/tags")
	public List<Tag> findAll(){
		return this.tagService.findAll();
	}
	
	@GetMapping("/tags/{id}")
	public ResponseEntity<Tag> findById(@PathVariable Long id) {
		log.info("REST request to find one tag");
		Optional<Tag> tagOpt = this.tagService.findById(id);
		if (tagOpt.isPresent())
			return ResponseEntity.ok(tagOpt.get());
		return ResponseEntity.notFound().build();
	}
	
	@GetMapping("/tags/tagname/{tagname}")
	public List<Tag> findAllByTagname(@PathVariable String tagname){
		return this.tagService.findAllByTagname(tagname);
	}
	
	@GetMapping("/tags/color/{color}")
	public List<Tag> findAllByColor(@PathVariable String color){
		return this.tagService.findAllByColor(color);
	}
	
	// Create
	@PostMapping("/tags")
	public ResponseEntity<Tag> create(@RequestBody Tag tag) {
		if (tag.getId() != null) {
			log.warn("Trying to create a new tag with existent id");
			return ResponseEntity.badRequest().build();
		}
		Tag result = this.tagService.save(tag);
		if (result != null && result.getId() != null) {
			return ResponseEntity.ok(result);
		}
		return ResponseEntity.internalServerError().build();
	}
	
	// Update 
	@PutMapping("/tags/{id}")
	public ResponseEntity<Tag> update(@RequestBody Tag tag) {
		if (tag.getId() == null) {
			return ResponseEntity.badRequest().build();
		}
		return ResponseEntity.ok(this.tagService.update(tag));
	}

	
}