package fr.treeptik.service;

import java.util.List;

import fr.treeptik.exception.DAOException;
import fr.treeptik.model.Auteur;

public interface ServiceAuteur {

	public Auteur create(Auteur auteur) throws DAOException;
	public List<Auteur> read() throws DAOException;
	public void delete(Integer id);
	public Auteur findById(Integer id);
	public Auteur auteurAyantArticleplusCommente();
	public Auteur findByName(String clientNom) throws DAOException;
	public Object findAll() throws DAOException;
}
