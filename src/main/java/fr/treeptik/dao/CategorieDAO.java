package fr.treeptik.dao;

import fr.treeptik.exception.DAOException;
import fr.treeptik.model.Categorie;

public interface CategorieDAO extends GenericDAO<Categorie, Integer>{

	
	Long countByNameAndId(String categorieNom, Integer id) throws DAOException;
	
	Long countByName(String categorieNom) throws DAOException;
}
