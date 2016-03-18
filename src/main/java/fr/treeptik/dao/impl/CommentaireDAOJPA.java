package fr.treeptik.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import fr.treeptik.dao.CommentaireDAO;
import fr.treeptik.model.Article;
import fr.treeptik.model.Commentaire;

@Repository
public class CommentaireDAOJPA extends GenericDAOJPA<Commentaire, Integer>
		implements CommentaireDAO {

	public CommentaireDAOJPA() {
		super(Commentaire.class);
	}

	@Override
	public List<Commentaire> findCommentaryFrom(Integer id) {

		return entityManager
				.createQuery(
						"Select c from Commentaire c Join Fetch c.article a where a.id=:id",
						Commentaire.class).setParameter("id", id)
				.getResultList();
	}

	@Override
	public List<Commentaire> findAll(Integer id) {

		return entityManager
				.createQuery(
						"Select c from Commentaire c where c.article.id LIKE ?1",
						Commentaire.class).setParameter(1, id).getResultList();
	}

	@Override
	public Long countByTextAndId(String texte, Integer id) {

		return entityManager
				.createQuery(
						"Select count(c) from Commentaire c where c.texte Like ?1 and c.id Like ?2 ",
						Long.class).setParameter(1, texte).setParameter(2, id)
				.getSingleResult();
	}

	@Override
	public Long countByText(String texte) {
		
		return entityManager
				.createQuery(
						"Select count(c) from Commentaire c where c.texte Like ?1",
						Long.class).setParameter(1, texte).getSingleResult();
	}
}
