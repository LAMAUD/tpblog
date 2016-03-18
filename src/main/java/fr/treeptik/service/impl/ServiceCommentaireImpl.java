package fr.treeptik.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.treeptik.dao.CommentaireDAO;
import fr.treeptik.exception.DAOException;
import fr.treeptik.model.Commentaire;
import fr.treeptik.service.ServiceCommentaire;

@Service
public class ServiceCommentaireImpl implements ServiceCommentaire {

	@Autowired
	private CommentaireDAO commentaireDAO;
	
	@Override
	public Commentaire create(Commentaire commentaire) throws DAOException {
		
		return commentaireDAO.save(commentaire);
		
	}
	
	@Override
	public List<Commentaire> read() throws DAOException {
		return commentaireDAO.findAll();
		
	}

	@Override
	public void delete(Integer id) {
		commentaireDAO.removeById(id);
		
	}

	@Override
	public Commentaire findById(Integer id) {
		return commentaireDAO.findById(id);
		
	}

	@Override
	public List<Commentaire> commentairesArticle(Integer id) {
		// TODO Auto-generated method stub
		return commentaireDAO.findCommentaryFrom(id);
	}

	public CommentaireDAO getCommentaireDAO() {
		return commentaireDAO;
	}

	public void setCommentaireDAO(CommentaireDAO commentaireDAO) {
		this.commentaireDAO = commentaireDAO;
	}

	@Override
	public List<Commentaire> read(Integer id) {
		
		return commentaireDAO.findAll(id);
	}


	
	
}
