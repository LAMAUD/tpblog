package fr.treeptik.validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;

import fr.treeptik.dao.CategorieDAO;
import fr.treeptik.exception.DAOException;
import fr.treeptik.model.Categorie;

@Component
public class CategorieValidator {

	
	@Autowired
	private CategorieDAO categorieDAO;

	public boolean supports(Class<?> arg0) {
		return arg0.getClass().equals(Categorie.class);
	}

	public void validate(Object categorie, Errors errors) {

		Categorie c = (Categorie) categorie;

		if (c.getName() == null) {
			errors.rejectValue("name","hack","Le nom est nul");
		}

		Integer id = c.getId();
		if (id != null) {

			try {
				Long countByNameAndId = categorieDAO.countByNameAndId(c.getName(),
						id);

				if (countByNameAndId != 0) {
					errors.rejectValue("name","hack", "Le nom est déjà pris");
				}

			} catch (DAOException e) {
				e.printStackTrace();
			}
		}
		else {
			try {
				Long countByNameAndId = categorieDAO.countByName(c.getName());

				if (countByNameAndId != 0) {
					errors.rejectValue("name", "hack","Le nom est déjà pris");
				}

			} catch (DAOException e) {
				e.printStackTrace();
			}
		}
	}
}
