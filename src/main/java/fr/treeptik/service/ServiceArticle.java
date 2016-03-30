package fr.treeptik.service;



import java.util.Date;
import java.util.List;

import fr.treeptik.exception.DAOException;
import fr.treeptik.model.Article;
import fr.treeptik.model.Auteur;


public interface ServiceArticle {
	
	public Article create(Article article) throws DAOException;
	public List<Article> read() throws DAOException;
	public void delete(Integer id);
	public Article findById(Integer id);
	
	public List<Article> articlesParusEntre(Date dateFrom, Date dateTo);
	public List<Article> articlesCommentes();
	public Article findByTitre(String articleTitre);
	public List<Article> read(Integer id);
}
