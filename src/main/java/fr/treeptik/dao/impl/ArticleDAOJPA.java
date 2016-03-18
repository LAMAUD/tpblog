package fr.treeptik.dao.impl;

import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Repository;

import fr.treeptik.dao.ArticleDAO;
import fr.treeptik.model.Article;

@Repository
public class ArticleDAOJPA extends GenericDAOJPA<Article, Integer> implements
		ArticleDAO {

	public ArticleDAOJPA() {
		super(Article.class);
	}

	@Override
	public List<Article> findPeriodeTemps(Date dateFrom, Date dateTo) {

		return entityManager
				.createQuery(
						"Select a from Article a Left Join Fetch a.auteur p Left Join fetch a.categorie c Left Join Fetch a.commentaire cc where a.creationDate between :dateFrom and :dateTo",
						Article.class).setParameter("dateFrom", dateFrom)
				.setParameter("dateTo", dateTo).getResultList();
	}

	@Override
	public List<Article> findArticleCommente() {

		return entityManager.createQuery(
				"Select a from Article a where a.commentaires IS NOT EMPTY",
				Article.class).getResultList();
	}

	@Override
	public Long countByTitreAndId(String titre, Integer id) {

		return entityManager
				.createQuery(
						"Select count(a) from Article a where a.titre LIKE ?1 and a.id<> ?2",
						Long.class).setParameter(1, titre).setParameter(2, id)
				.getSingleResult();
	}

	@Override
	public Long countByTitre(String titre) {

		return entityManager
				.createQuery(
						"Select count(a) from Article a where a.titre LIKE ?1 ",
						Long.class).setParameter(1, titre).getSingleResult();
	}

	@Override
	public Article findByTitre(String articleTitre) {

		return entityManager
				.createQuery("Select a from Article a where a.titre LIKE ?1 ",
						Article.class).setParameter(1, articleTitre)
				.getSingleResult();
	}

	@Override
	public List<Article> findAll(Integer id) {

		return entityManager
				.createQuery("Select a from Article a join fetch a.categorie c join fetch a.auteur aut where a.auteur.id LIKE ?1",
						Article.class).setParameter(1, id).getResultList();
	}
	
	@Override
	public List<Article> findAll() {

		return entityManager
				.createQuery("Select a from Article a join fetch a.categorie c join fetch a.auteur aut",
						Article.class).getResultList();
	}
}
