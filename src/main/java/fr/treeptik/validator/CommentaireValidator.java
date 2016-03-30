package fr.treeptik.validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;

import fr.treeptik.dao.CategorieDAO;
import fr.treeptik.dao.CommentaireDAO;
import fr.treeptik.exception.DAOException;
import fr.treeptik.model.Commentaire;

@Component
public class CommentaireValidator {

	
	@Autowired
	private CommentaireDAO commentaireDAO;

	public boolean supports(Class<?> arg0) {
		return arg0.getClass().equals(Commentaire.class);
	}

	public void validate(Object commentaire, Errors errors) throws DAOException {

		Commentaire c = (Commentaire) commentaire;

		if (c.getTexte() == null) {
			errors.rejectValue("texte","hack","Le texte est nul");
		}

		Integer id = c.getId();
		if (id != null) {

			Long countByNameAndId = commentaireDAO.countByTextAndId(c.getTexte(),
					id);

			if (countByNameAndId != 0) {
				errors.rejectValue("text","hack", "Le nom est déjà pris");
			}
		}
		else {
			Long countByNameAndId = commentaireDAO.countByText(c.getTexte());

			if (countByNameAndId != 0) {
				errors.rejectValue("text", "hack","Le nom est déjà pris");
			}
		}
	}


}
