package com.example.demo.dao;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.demo.domain.Tag;

@Repository
public class TagDAOImpl implements TagDAO {

	@PersistenceContext
	private EntityManager entityManager; // JPA
	
	@Autowired
	private Session session; // Hibernate
	
	
	@Override
	public Tag update(Tag tag) {
		try {
			session.beginTransaction();
			session.merge(tag);
			session.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		}
		return tag;
	}
	
	
	@Override
	public Optional<Tag> findById(Long id) {
		try {
			Tag tag = session.find(Tag.class, id);
			if (tag != null)
				return Optional.of(tag);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return Optional.empty();
	}
	
	
	@Override
	public List<Tag> findAllFromSession() {
		String hql = "from Tag";
		return session.createQuery(hql, Tag.class).list();
	}


	@Override
	public List<Tag> findAllFromEntityManager() {
		String hql = "from Tag";
		return entityManager.createQuery(hql, Tag.class).getResultList();
	}
	
	
	@Override
	public List<Tag> findAllByTagname(String tagname) {
		// 1 - Criteria Query
		CriteriaBuilder builder = session.getCriteriaBuilder();
		CriteriaQuery<Tag> criteria = builder.createQuery(Tag.class);
		
		// from
		Root<Tag> root = criteria.from(Tag.class);
		criteria.select(root);
		
		// filtros: contiene un texto
		criteria.where(builder.like(root.get("tagname"), "%" + tagname + "%"));
		
		// 2 - Query normal que recibe los criterios: obtener resultados
		List<Tag> tags = session.createQuery(criteria).list();
		return tags;
	}
	
	@Override
	public List<Tag> findAllByColor(String color) {
		// 1 - Criteria Query
		CriteriaBuilder builder = session.getCriteriaBuilder();
		CriteriaQuery<Tag> criteria = builder.createQuery(Tag.class);
		
		// from
		Root<Tag> root = criteria.from(Tag.class);
		criteria.select(root);
		
		// filtros: contiene un texto
		criteria.where(builder.like(root.get("color"), "%" + color + "%"));
		
		// 2 - Query normal que recibe los criterios: obtener resultados
		List<Tag> tags = session.createQuery(criteria).list();
		return tags;
	}


}
	