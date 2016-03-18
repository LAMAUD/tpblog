package fr.treeptik.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.treeptik.dao.AuteurDAO;
import fr.treeptik.exception.DAOException;
import fr.treeptik.model.Auteur;
import fr.treeptik.service.ServiceAuteur;

@Service
public class ServiceAuteurImpl implements ServiceAuteur{

	@Autowired
	private AuteurDAO auteurDAO;
	
	@Override
	public Auteur create(Auteur auteur) throws DAOException {
		
		return auteurDAO.save(auteur);
	}
	
	@Override
	public List<Auteur> read() throws DAOException {
		return auteurDAO.findAll();
		
	}


	@Override
	public void delete(Integer id) {
		auteurDAO.removeById(id);
		
	}


	@Override
	public Auteur findById(Integer id) {
		return auteurDAO.findById(id);
		
	}
	
	

	public AuteurDAO getAuteurDAO() {
		return auteurDAO;
	}

	public void setAuteurDAO(AuteurDAO auteurDAO) {
		this.auteurDAO = auteurDAO;
	}

	@Override
	public Auteur auteurAyantArticleplusCommente() {
		
		return auteurDAO.auteurAvecArticleLePlusCommente();
	}

	@Override
	public Auteur findByName(String auteurNom) throws DAOException {
		
		return auteurDAO.findByName(auteurNom);
	}

	@Override
	public Object findAll() throws DAOException {
		
		return auteurDAO.findAll();
	}


	
}
