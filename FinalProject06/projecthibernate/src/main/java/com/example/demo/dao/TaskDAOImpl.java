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

import com.example.demo.domain.Task;

@Repository
public class TaskDAOImpl implements TaskDAO {

	@PersistenceContext
	private EntityManager entityManager; //JPA

	@Autowired
	private Session session; //Hibernate

	@Override
	public Task update(Task task) {
		try {
			session.beginTransaction();
			session.merge(task);
			session.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		}
		return task;
	}

	@Override
	public Optional<Task> findById(Long id) {
		try {
			Task task = session.find(Task.class, id);
			if (task != null)
				return Optional.of(task);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return Optional.empty();
	}

	@Override
	public List<Task> findAllFromSession() {
		String hql = "from Task";
		return session.createQuery(hql, Task.class).list();
	}

	@Override
	public List<Task> findAllFromEntityManager() {
		String hql = "from Task";
		return entityManager.createQuery(hql, Task.class).getResultList();
	}

	@Override
	public List<Task> findAllByTitle(String title) {
		// 1 - Criteria Query
		CriteriaBuilder builder = session.getCriteriaBuilder();
		CriteriaQuery<Task> criteria = builder.createQuery(Task.class);

		// from
		Root<Task> root = criteria.from(Task.class);
		criteria.select(root);

		// filtros: contiene un texto
		criteria.where(builder.like(root.get("title"), "%" + title + "%"));

		// 2 - Query normal que recibe los criterios: obtener resultados
		List<Task> tasks = session.createQuery(criteria).list();
		return tasks;
	}

	@Override
	public List<Task> findAllByDescription(String description) {
		CriteriaBuilder builder = session.getCriteriaBuilder();
		CriteriaQuery<Task> criteria = builder.createQuery(Task.class);

		// from
		Root<Task> root = criteria.from(Task.class);
		criteria.select(root);

		// filtros: contiene un texto
		criteria.where(builder.like(root.get("description"), "%" + description + "%"));

		// 2 - Query normal que recibe los criterios: obtener resultados
		List<Task> tasks = session.createQuery(criteria).list();
		return tasks;
	}

	@Override
	public List<Task> findAllByFinished(Boolean finished) {
		CriteriaBuilder builder = session.getCriteriaBuilder();
		CriteriaQuery<Task> criteria = builder.createQuery(Task.class);

		// from
		Root<Task> root = criteria.from(Task.class);
		criteria.select(root);

		// filtros: contiene un texto
		criteria.where(builder.like(root.get("finished"), "%" + finished + "%"));

		// 2 - Query normal que recibe los criterios: obtener resultados
		List<Task> tasks = session.createQuery(criteria).list();
		return tasks;
	}

	@Override
	public List<Task> findAllByDeliveryDate(LocalDate deliverydate) {
		CriteriaBuilder builder = session.getCriteriaBuilder();
		CriteriaQuery<Task> criteria = builder.createQuery(Task.class);

		// from
		Root<Task> root = criteria.from(Task.class);
		criteria.select(root);

		// filtros: contiene un texto
		criteria.where(builder.like(root.get("deliverydate"), "%" + deliverydate + "%"));

		// 2 - Query normal que recibe los criterios: obtener resultados
		List<Task> tasks = session.createQuery(criteria).list();
		return tasks;
	}

}