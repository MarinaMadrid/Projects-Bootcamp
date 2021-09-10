package com.example.demo.dao;

import java.time.LocalDate;
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

import com.example.demo.domain.User;

@Repository
public class UserDAOImpl implements UserDAO {

	
	@PersistenceContext
	private EntityManager entityManager; //JPA
	
	@Autowired
	private Session session; //Hibernate
	
	
	@Override
	public Optional<User> findById(Long id) {
		try {
			User user = session.find(User.class, id);
			if (user != null)
				return Optional.of(user);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return Optional.empty();
	}
	
	
	@Override
	public User save(User user) {
		try {
			session.beginTransaction();
			session.save(user);
			session.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		}
		return user;
	}
	
	
	@Override
	public User update(User user) {
		try {
			session.beginTransaction();
			session.merge(user);
			session.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		}
		return user;
	}
	
	
	@Override
	public List<User> findAllFromSession() {
		String hql = "from User";
		return session.createQuery(hql, User.class).list();
	}


	@Override
	public List<User> findAllFromEntityManager() {
		String hql = "from User";
		return entityManager.createQuery(hql, User.class).getResultList();
	}
	
	
	@Override
	public List<User> findAllByUsername(String username) {
		// 1 - Criteria Query
		CriteriaBuilder builder = session.getCriteriaBuilder();
		CriteriaQuery<User> criteria = builder.createQuery(User.class);
		
		// from
		Root<User> root = criteria.from(User.class);
		criteria.select(root);
		
		// filtros: contiene un texto
		criteria.where(builder.like(root.get("username"), "%" + username + "%"));
		
		// 2 - Query normal que recibe los criterios: obtener resultados
		List<User> users = session.createQuery(criteria).list();
		return users;
	}


	@Override
	public List<User> findAllByUserlastname(String userlastname) {
		CriteriaBuilder builder = session.getCriteriaBuilder();
		CriteriaQuery<User> criteria = builder.createQuery(User.class);
		
		// from
		Root<User> root = criteria.from(User.class);
		criteria.select(root);
		
		// filtros: contiene un texto
		criteria.where(builder.like(root.get("userlastname"), "%" + userlastname + "%"));
		
		// 2 - Query normal que recibe los criterios: obtener resultados
		List<User> users = session.createQuery(criteria).list();
		return users;
	}
	
	@Override
	public List<User> findAllByDNI(String dni) {
		CriteriaBuilder builder = session.getCriteriaBuilder();
		CriteriaQuery<User> criteria = builder.createQuery(User.class);
		
		// from
		Root<User> root = criteria.from(User.class);
		criteria.select(root);
		
		// filtros: contiene un texto
		criteria.where(builder.like(root.get("dni"), "%" + dni + "%"));
		
		// 2 - Query normal que recibe los criterios: obtener resultados
		List<User> users = session.createQuery(criteria).list();
		return users;
	}
	
	@Override
	public List<User> findAllByActive(Boolean active) {
		CriteriaBuilder builder = session.getCriteriaBuilder();
		CriteriaQuery<User> criteria = builder.createQuery(User.class);
	
		// from
		Root<User> root = criteria.from(User.class);
		criteria.select(root);
		
		// filtros: contiene un texto
		criteria.where(builder.like(root.get("active"), "%" + active + "%"));
		
		// 2 - Query normal que recibe los criterios: obtener resultados
		List<User> users = session.createQuery(criteria).list();
		return users;
	}
	
	@Override
	public List<User> findAllByBirthday(LocalDate birthday) {
		CriteriaBuilder builder = session.getCriteriaBuilder();
		CriteriaQuery<User> criteria = builder.createQuery(User.class);
		
		// from
		Root<User> root = criteria.from(User.class);
		criteria.select(root);
		
		// filtros: contiene un texto
		criteria.where(builder.like(root.get("birthday"), "%" + birthday + "%"));
		
		// 2 - Query normal que recibe los criterios: obtener resultados
		List<User> users = session.createQuery(criteria).list();
		return users;
	}

	
}