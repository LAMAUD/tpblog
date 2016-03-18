package fr.treeptik.dao.impl;

import javax.persistence.PersistenceException;

import org.springframework.stereotype.Repository;

import fr.treeptik.dao.AuteurDAO;
import fr.treeptik.exception.DAOException;
import fr.treeptik.model.Auteur;

@Repository
public class AuteurDAOJPA extends GenericDAOJPA<Auteur, Integer> implements
		AuteurDAO {

	public AuteurDAOJPA() {
		super(Auteur.class);
	}

	public Auteur auteurAvecArticleLePlusCommente() {

		return entityManager
				.createQuery(
						"Select distinct aut FROM Auteur aut join aut.articles art join art.commentaires com group by art.auteur.id order by count(com.id) DESC ",
						Auteur.class).setMaxResults(1).getSingleResult();
	}

	@Override
	public Long countByNameAndId(String nom, Integer id) throws DAOException {
		try {
			return entityManager
					.createQuery(
							"Select count(a) from Auteur a WHERE a.nom LIKE ?1 and a.id<> ?2",
							Long.class).setParameter(1, nom)
					.setParameter(2, id).getSingleResult();
		} catch (PersistenceException e) {
			throw new DAOException("erreur findByName client", e);
		}

	}

	@Override
	public Long countByName(String nom) throws DAOException {
		try {
			return entityManager
					.createQuery(
							"select count(a) from Auteur a WHERE a.nom LIKE ?1",
							Long.class).setParameter(1, nom).getSingleResult();
		} catch (PersistenceException e) {
			throw new DAOException("erreur findByName client", e);
		}

	}

	@Override
	public Auteur findByName(String nom) throws DAOException {

		return entityManager
				.createQuery("Select a From Auteur a where a.nom=:nom",
						Auteur.class).setParameter("nom", nom)
				.getSingleResult();

	}
}
