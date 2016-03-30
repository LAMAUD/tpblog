package fr.treeptik.dao;

import java.util.List;

import fr.treeptik.model.Article;
import fr.treeptik.model.Commentaire;

public interface CommentaireDAO extends GenericDAO<Commentaire, Integer> {

	List<Commentaire> findCommentaryFrom(Integer id);

	List<Commentaire> findAll(Integer id);

	Long countByTextAndId(String texte, Integer id);

	Long countByText(String texte);
}
