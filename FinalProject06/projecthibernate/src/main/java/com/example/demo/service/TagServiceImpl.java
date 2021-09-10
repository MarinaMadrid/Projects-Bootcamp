package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.demo.dao.TagDAO;
import com.example.demo.domain.Tag;
import com.example.demo.repository.TagRepository;

@Service
public class TagServiceImpl implements TagService  {

	
	private TagRepository tagRepository;
	private TagDAO tagDAO;

	
	public TagServiceImpl(TagRepository tagRepository, TagDAO tagDAO) {
		this.tagRepository = tagRepository;
		this.tagDAO = tagDAO;
	}
	

	@Override
	public Optional<Tag> findById(Long id) {
		if(id == null || id == 0)
			return Optional.empty();
		return this.tagDAO.findById(id);
	}
	
	
	@Override
	public Tag save(Tag tag) {
		if(tag == null)
			return tag;
		return this.tagRepository.save(tag);
	}
	
	
	@Override
	public Tag update(Tag tag) {
		return this.tagDAO.update(tag);
	}
	
	
	@Override
	public List<Tag> findAll() {
//		return this.tagDAO.findAllFromSession();
		return this.tagDAO.findAllFromEntityManager();
	}
	
	
	@Override
	public List<Tag> findAllByTagname(String tagname) {
		return this.tagDAO.findAllByTagname(tagname);
	}
	
	@Override
	public List<Tag> findAllByColor(String color) {
		return this.tagDAO.findAllByColor(color);
	}

}