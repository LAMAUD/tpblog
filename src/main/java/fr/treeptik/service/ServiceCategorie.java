package fr.treeptik.service;

import java.util.List;

import fr.treeptik.exception.DAOException;
import fr.treeptik.model.Categorie;

public interface ServiceCategorie {
	
	public Categorie create(Categorie categorie) throws DAOException;
	public List<Categorie> read() throws DAOException;
	public void delete(Integer id);
	public Categorie findById(Integer id);

}
