package fr.treeptik.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.treeptik.dao.ArticleDAO;
import fr.treeptik.exception.DAOException;
import fr.treeptik.model.Article;
import fr.treeptik.service.ServiceArticle;

@Service
public class ServiceArticleImpl implements ServiceArticle{

	@Autowired
	private ArticleDAO articleDAO;
	
	@Override
	public Article create(Article article) throws DAOException {
		
		return articleDAO.save(article);
	}

	@Override
	public List<Article> read() throws DAOException {
		return articleDAO.findAll();
		
	}

	@Override
	public void delete(Integer id) {
		articleDAO.removeById(id);
		
	}

	@Override
	public Article findById(Integer id) {
		return articleDAO.findById(id);
		
	}
	
	@Override
	public List<Article> articlesParusEntre(Date dateFrom, Date dateTo) {
		
		return articleDAO.findPeriodeTemps(dateFrom, dateTo);
	}

	public ArticleDAO getArticleDAO() {
		return articleDAO;
	}

	public void setArticleDAO(ArticleDAO articleDAO) {
		this.articleDAO = articleDAO;
	}

	@Override
	public List<Article> articlesCommentes() {
		
		return articleDAO.findArticleCommente();
	}

	@Override
	public Article findByTitre(String articleTitre) {
		
		return articleDAO.findByTitre(articleTitre);
	}

	@Override
	public List<Article> read(Integer id) {
		
		return articleDAO.findAll(id);
	}


}
