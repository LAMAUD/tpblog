package fr.treeptik.validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;

import fr.treeptik.dao.AuteurDAO;
import fr.treeptik.exception.DAOException;
import fr.treeptik.model.Auteur;

@Component
public class AuteurValidator {

	
	@Autowired
	private AuteurDAO auteurDAO;

	public boolean supports(Class<?> arg0) {
		return arg0.getClass().equals(Auteur.class);
	}

	public void validate(Object auteur, Errors errors) {

		Auteur c = (Auteur) auteur;

		if (c.getNom() == null) {
			errors.rejectValue("nom","hack","Le nom est nul");
		}

		Integer id = c.getId();
		if (id != null) {

			try {
				Long countByNameAndId = auteurDAO.countByNameAndId(c.getNom(),
						id);

				if (countByNameAndId != 0) {
					errors.rejectValue("nom","hack", "Le nom est déjà pris");
				}

			} catch (DAOException e) {
				e.printStackTrace();
			}
		}
		else {
			try {
				Long countByNameAndId = auteurDAO.countByName(c.getNom());

				if (countByNameAndId != 0) {
					errors.rejectValue("nom", "hack","Le nom est déjà pris");
				}

			} catch (DAOException e) {
				e.printStackTrace();
			}
		}
	}


}
