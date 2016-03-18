package fr.treeptik.service;

import java.util.List;

import fr.treeptik.exception.DAOException;
import fr.treeptik.model.Commentaire;

public interface ServiceCommentaire {
	
	public Commentaire create(Commentaire commentaire) throws DAOException;
	public List<Commentaire> read() throws DAOException;
	public void delete(Integer id);
	public Commentaire findById(Integer id);
	
	public List<Commentaire> commentairesArticle(Integer id);
	public List<Commentaire> read(Integer id);

}
