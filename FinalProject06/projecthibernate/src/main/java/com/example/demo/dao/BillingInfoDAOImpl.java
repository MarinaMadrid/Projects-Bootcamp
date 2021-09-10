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

import com.example.demo.domain.BillingInfo;

@Repository
public class BillingInfoDAOImpl implements BillingInfoDAO {

	@PersistenceContext
	private EntityManager entityManager; // JPA
	
	@Autowired
	private Session session; // Hibernate
	
	@Override
	public BillingInfo update(BillingInfo billingInfo) {
		try {
			session.beginTransaction();
			session.merge(billingInfo);
			session.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		}
		return billingInfo;
	}
	
	
	@Override
	public Optional<BillingInfo> findById(Long id) {
		try {
			BillingInfo billingInfo = session.find(BillingInfo.class, id);
			if (billingInfo != null)
				return Optional.of(billingInfo);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return Optional.empty();
	}
	
	
	@Override
	public List<BillingInfo> findAllFromSession() {
		String hql = "from BillingInfo";
		return session.createQuery(hql, BillingInfo.class).list();
	}


	@Override
	public List<BillingInfo> findAllFromEntityManager() {
		String hql = "from BillingInfo";
		return entityManager.createQuery(hql, BillingInfo.class).getResultList();
	}
	
	
	@Override
	public List<BillingInfo> findAllByFullname(String fullname) {
		// 1 - Criteria Query
		CriteriaBuilder builder = session.getCriteriaBuilder();
		CriteriaQuery<BillingInfo> criteria = builder.createQuery(BillingInfo.class);
		
		// from
		Root<BillingInfo> root = criteria.from(BillingInfo.class);
		criteria.select(root);
		
		// filtros: contiene un texto
		criteria.where(builder.like(root.get("fullname"), "%" + fullname + "%"));
		
		// 2 - Query normal que recibe los criterios: obtener resultados
		List<BillingInfo> billingInfo = session.createQuery(criteria).list();
		return billingInfo;
	}


	@Override
	public List<BillingInfo> findAllByAddress(String address) {
		CriteriaBuilder builder = session.getCriteriaBuilder();
		CriteriaQuery<BillingInfo> criteria = builder.createQuery(BillingInfo.class);
		
		// from
		Root<BillingInfo> root = criteria.from(BillingInfo.class);
		criteria.select(root);
		
		// filtros: contiene un texto
		criteria.where(builder.like(root.get("address"), "%" + address + "%"));
		
		// 2 - Query normal que recibe los criterios: obtener resultados
		List<BillingInfo> billingInfo = session.createQuery(criteria).list();
		return billingInfo;
	}
	
	@Override
	public List<BillingInfo> findAllByPhoneNumber(String phonenumber) {
		CriteriaBuilder builder = session.getCriteriaBuilder();
		CriteriaQuery<BillingInfo> criteria = builder.createQuery(BillingInfo.class);
		
		// from
		Root<BillingInfo> root = criteria.from(BillingInfo.class);
		criteria.select(root);
		
		// filtros: contiene un texto
		criteria.where(builder.like(root.get("phonenumber"), "%" + phonenumber + "%"));
		
		// 2 - Query normal que recibe los criterios: obtener resultados
		List<BillingInfo> billingInfo = session.createQuery(criteria).list();
		return billingInfo;
	}
	
	
}