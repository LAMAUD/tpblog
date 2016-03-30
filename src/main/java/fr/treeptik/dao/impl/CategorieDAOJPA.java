package fr.treeptik.dao.impl;

import javax.persistence.PersistenceException;

import org.springframework.stereotype.Repository;

import fr.treeptik.dao.CategorieDAO;
import fr.treeptik.exception.DAOException;
import fr.treeptik.model.Categorie;

@Repository
public class CategorieDAOJPA extends GenericDAOJPA<Categorie, Integer> implements CategorieDAO{

	public CategorieDAOJPA(){
		super(Categorie.class);
	}

	@Override
	public Long countByNameAndId(String categorieNom, Integer id) throws DAOException{
	try {
		return entityManager
				.createQuery(
						"Select count(c) from Categorie c WHERE c.name LIKE ?1 and c.id<> ?2",
						Long.class).setParameter(1, categorieNom).setParameter(2, id)
				.getSingleResult();
	} catch (PersistenceException e) {
		throw new DAOException("erreur findByName client", e);
	}
	}

	@Override
	public Long countByName(String categorieNom) throws DAOException {
		try {
			return entityManager
					.createQuery(
							"select count(c) from Categorie c WHERE c.name LIKE ?1",
							Long.class).setParameter(1, categorieNom)
					.getSingleResult();
		} catch (PersistenceException e) {
			throw new DAOException("erreur findByName client", e);
		}
	}
}
