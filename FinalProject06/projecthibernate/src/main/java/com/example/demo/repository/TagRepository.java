package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.domain.Tag;

@Repository
public interface TagRepository extends JpaRepository<Tag, Long> {

	// Filtros
	
	/*
	 * 
	 * Tag save(Tag tag);
	 * Tag update(Tag tag);
	 * 
	 * */
	
}