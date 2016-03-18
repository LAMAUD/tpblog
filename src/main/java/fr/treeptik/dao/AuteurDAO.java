package fr.treeptik.dao;

import fr.treeptik.exception.DAOException;
import fr.treeptik.model.Auteur;

public interface AuteurDAO extends GenericDAO<Auteur, Integer> {
	
	public Auteur auteurAvecArticleLePlusCommente();

	public Long countByNameAndId(String nom, Integer id) throws DAOException;

	public Long countByName(String nom) throws DAOException;

	public Auteur findByName(String nom) throws DAOException;
}
