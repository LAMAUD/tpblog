package fr.treeptik.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.treeptik.dao.CategorieDAO;
import fr.treeptik.exception.DAOException;
import fr.treeptik.model.Categorie;
import fr.treeptik.service.ServiceCategorie;

@Service
public class ServiceCategorieImpl implements ServiceCategorie{

	@Autowired
	private CategorieDAO categorieDAO;
	
	@Override
	public Categorie create(Categorie categorie) throws DAOException {
		
		return categorieDAO.save(categorie);
		
	}
	
	@Override
	public List<Categorie> read() throws DAOException {
		return categorieDAO.findAll();
		
	}



	@Override
	public void delete(Integer id) {
		categorieDAO.removeById(id);
		
	}



	@Override
	public Categorie findById(Integer id) {
		return categorieDAO.findById(id);
		
	}


	public CategorieDAO getCategorieDAO() {
		return categorieDAO;
	}

	public void setCategorieDAO(CategorieDAO categorieDAO) {
		this.categorieDAO = categorieDAO;
	}



	
	
	
}
