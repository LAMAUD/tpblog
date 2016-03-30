package fr.treeptik.validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;

import fr.treeptik.dao.ArticleDAO;
import fr.treeptik.exception.DAOException;
import fr.treeptik.model.Article;

@Component
public class ArticleValidator {

	@Autowired
	private ArticleDAO articleDAO;
	
	public void validate(Object article, Errors errors) throws DAOException {

		Article c = (Article) article;

		if (c.getTitre() == null) {
			errors.rejectValue("titre","hack","Le titre est nul");
		}

		Integer id = c.getId();
		if (id != null) {

			Long countByNameAndId = articleDAO.countByTitreAndId(c.getTitre(),
					id);

			if (countByNameAndId != 0) {
				errors.rejectValue("titre","hack", "Le titre est déjà pris");
			}
		}
		else {
			Long countByNameAndId = articleDAO.countByTitre(c.getTitre());

			if (countByNameAndId != 0) {
				errors.rejectValue("titre", "hack","Le titre est déjà pris");
			}
		}
	}


}
