package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import com.example.demo.domain.Tag;

public interface TagService {

	Optional<Tag> findById(Long id);
	
	List<Tag> findAll();
	
	List<Tag> findAllByTagname(String tagname);
	
	List<Tag> findAllByColor(String color);
	
	Tag save(Tag tag);
	
	Tag update(Tag tag);
	
}