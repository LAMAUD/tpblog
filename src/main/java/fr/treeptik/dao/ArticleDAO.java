package fr.treeptik.dao;

import java.util.Date;
import java.util.List;

import fr.treeptik.model.Article;

public interface ArticleDAO extends GenericDAO<Article, Integer> {

	List<Article> findPeriodeTemps(Date DateFrom, Date dateTo);
	List<Article> findArticleCommente();
	Long countByTitreAndId(String titre, Integer id);
	Long countByTitre(String titre);
	Article findByTitre(String articleTitre);
	List<Article> findAll(Integer id);
}
