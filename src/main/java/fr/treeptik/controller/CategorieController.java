package fr.treeptik.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import fr.treeptik.dao.CategorieDAO;
import fr.treeptik.exception.DAOException;
import fr.treeptik.exception.ServiceException;
import fr.treeptik.model.Categorie;
import fr.treeptik.model.Categorie;
import fr.treeptik.model.Role;
import fr.treeptik.service.ServiceCategorie;
import fr.treeptik.validator.CategorieValidator;

@Controller
@RequestMapping("/categorie")
public class CategorieController {
	
//	Affiche ce qu'il se passe
	private final static Logger LOGGER = Logger
			.getLogger(CategorieController.class);
	
	@Autowired
	private CategorieDAO categorieDAO;
	
	@Autowired
	private ServiceCategorie serviceCategorie;
	
	@Autowired
	private CategorieValidator categorieValidator;
	
	@RequestMapping(value = "/categorie.do", method = RequestMethod.GET)
	public ModelAndView initForm() throws DAOException {


		ModelAndView modelAndView = new ModelAndView("categorie", "categorie",
				new Categorie());
		
		return modelAndView;
	}

	@RequestMapping(value = "/update.do", method = RequestMethod.GET)
	public ModelAndView updateForm(@RequestParam("id") Integer id)
			throws ServiceException, DAOException {

		Categorie categorie = serviceCategorie.findById(id);
		ModelAndView modelAndView = new ModelAndView("categorie", "categorie", categorie);
		
		return modelAndView;
	}

	@RequestMapping(value = "/list.do", method = RequestMethod.GET)
	public ModelAndView listClient(HttpServletRequest request)
			throws ServiceException, DAOException {
		
		return new ModelAndView("list-categorie", "categorie",
				serviceCategorie.read());
	}

	@RequestMapping(value = "/delete.do", method = RequestMethod.GET)
	public ModelAndView delete(@RequestParam("id") Integer id)
			throws ServiceException {
		serviceCategorie.delete(id);
		return new ModelAndView("redirect:list.do");
	}
	
	@RequestMapping(value = "/save.do", method = RequestMethod.GET)
	public ModelAndView saveClient(@Valid Categorie categorie, BindingResult result)
			throws ServiceException, DAOException {
		ModelAndView modelAndView = new ModelAndView("categorie");

		categorieValidator.validate(categorie, result);

		if (result.hasErrors()) {
			 for (ObjectError objectError : result.getAllErrors()) {
			 LOGGER.info(objectError.getDefaultMessage());
			 }

			 categorie.setName(null);
			
			modelAndView.addObject("categorie",categorie);
			
			return modelAndView;
		}
		categorie = serviceCategorie.create(categorie);
		modelAndView = new ModelAndView("redirect:list.do");
		return modelAndView;

}
}