package com.example.demo.dao;

import java.util.List;
import java.util.Optional;

import com.example.demo.domain.Tag;

public interface TagDAO {

	// Filtros
	Optional<Tag> findById(Long id);
	
	List<Tag> findAllFromSession();
	List<Tag> findAllFromEntityManager();
	
	List<Tag> findAllByTagname(String tagname);
	
	List<Tag> findAllByColor(String color);
	
	Tag update(Tag task);
	
}