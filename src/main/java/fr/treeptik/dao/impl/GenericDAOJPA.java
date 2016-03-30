package fr.treeptik.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import fr.treeptik.dao.GenericDAO;
import fr.treeptik.exception.DAOException;

@Repository
public class GenericDAOJPA<T, Pk> implements GenericDAO<T, Pk> {

	@PersistenceContext
	public EntityManager entityManager;

//	public final static ApplicationContext context = new ClassPathXmlApplicationContext(
//			"applicationContext.xml");

	private Class<T> type;
	
	

	public GenericDAOJPA() {
		super();
	}

	public GenericDAOJPA(Class<T> type) {
		super();
		this.type = type;
	}

	@Override
	@Transactional
	public T save(T entite) throws DAOException {

		return entityManager.merge(entite);
	}

	@Override
	@Transactional
	public void removeById(Pk id) {
		
		entityManager
				.createQuery("delete from " + type.getName() + " where id=:id")
				.setParameter("id", id).executeUpdate();
		

	}

	@Override
	public T findById(Pk id) {

		return entityManager
				.createQuery(
						"SELECT t from " + type.getName() + " t where t.id=:id",
						type).setParameter("id", id).getSingleResult();
	}

	@Override
	public List<T> findAll() throws DAOException {

		return entityManager.createQuery(
				"SELECT t from " + type.getName() + " t", type).getResultList();

	}

	public EntityManager getEntityManager() {
		return entityManager;
	}

	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

//	public static ApplicationContext getContext() {
//		return context;
//	}

	
}
