package fr.treeptik.dao;

import java.util.List;

import javax.persistence.EntityManager;

import fr.treeptik.exception.DAOException;

public interface GenericDAO<T, Pk> {
	
	public EntityManager getEntityManager();
	T save(T entite) throws DAOException;
	void removeById(Pk id);
	T findById(Pk id);
	List<T> findAll() throws DAOException;
}
