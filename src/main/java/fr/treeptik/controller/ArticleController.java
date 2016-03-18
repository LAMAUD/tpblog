package fr.treeptik.controller;

import java.util.List;

import javax.persistence.EntityManager;
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
import fr.treeptik.dao.impl.GenericDAOJPA;
import fr.treeptik.exception.DAOException;
import fr.treeptik.exception.ServiceException;
import fr.treeptik.model.Article;
import fr.treeptik.model.Article;
import fr.treeptik.model.Auteur;
import fr.treeptik.model.Categorie;
import fr.treeptik.model.Role;
import fr.treeptik.service.ServiceArticle;
import fr.treeptik.service.ServiceAuteur;
import fr.treeptik.service.ServiceCategorie;
import fr.treeptik.validator.ArticleValidator;

@Controller
@RequestMapping("/article")
public class ArticleController {

	// Affiche ce qu'il se passe
	private final static Logger LOGGER = Logger
			.getLogger(AuteurController.class);

	@Autowired
	private ArticleValidator articleValidator;

	@Autowired
	private ServiceArticle serviceArticle;

	@Autowired
	private CategorieDAO categorieDAO;
	
	@Autowired
	private ServiceAuteur serviceAuteur;
	
	private Integer idDeploy;

	@RequestMapping(value = "/article.do", method = RequestMethod.GET)
	public ModelAndView initForm() throws DAOException {

		List<Categorie> categories = categorieDAO.findAll();
		ModelAndView modelAndView = new ModelAndView("article", "article",
				new Article());
		modelAndView.addObject("categories", categories);
		return modelAndView;
	}

	@RequestMapping(value = "/update.do", method = RequestMethod.GET)
	public ModelAndView updateForm(@RequestParam("id") Integer id)
			throws ServiceException, DAOException {

		Article article = serviceArticle.findById(id);
		ModelAndView modelAndView = new ModelAndView("article", "article",
				article);
		List<Categorie> categories = categorieDAO.findAll();
		modelAndView.addObject("categories", categories);
		return modelAndView;
	}

	@RequestMapping(value = "/articleList.do", method = RequestMethod.GET)
	public ModelAndView listArticle(HttpServletRequest request,
			@RequestParam("id") Integer id) throws ServiceException,
			DAOException {
		// String articleTitre = SecurityContextHolder.getContext()
		// .getAuthentication().getName();
		// if (request.getSession().getAttribute("userSessionId") == null) {
		// Article article = serviceArticle.findByTitre(articleTitre);
		// request.getSession().setAttribute("userSessionId", article.getId());
		// }
		idDeploy=id;
		return new ModelAndView("list-article", "article",
				serviceArticle.read(id));
	}

	@RequestMapping(value = "/delete.do", method = RequestMethod.GET)
	public ModelAndView delete(@RequestParam("id") Integer id)
			throws ServiceException {
		serviceArticle.delete(id);
		return new ModelAndView("redirect:list.do");
	}

	@RequestMapping(value = "/save.do", method = RequestMethod.GET)
	public ModelAndView saveArticle(@Valid Article article,
			BindingResult result)
			throws ServiceException, DAOException {
		ModelAndView modelAndView = new ModelAndView("article");

		articleValidator.validate(article, result);

		if (result.hasErrors()) {
			for (ObjectError objectError : result.getAllErrors()) {
				LOGGER.info(objectError.getDefaultMessage());
			}

			article.setTitre(null);
			article.setContenu(null);

			List<Categorie> categories = categorieDAO.findAll();
			modelAndView.addObject("categories", categories);
			modelAndView.addObject("article", article);

			return modelAndView;
		}
		
		Auteur auteur=serviceAuteur.findById(idDeploy);
		article.setAuteur(auteur);
		article = serviceArticle.create(article);
		String cheminArticle = "redirect:articleList.do?id=" + idDeploy;
		modelAndView = new ModelAndView(cheminArticle);
		return modelAndView;
	}
	
	@RequestMapping(value = "/list.do", method = RequestMethod.GET)
	public ModelAndView listArticleTot(HttpServletRequest request) throws ServiceException,
			DAOException {

		
		return new ModelAndView("list-article", "article",
				serviceArticle.read());
	}
	
	@RequestMapping(value = "/DetailArticle.do", method = RequestMethod.GET)
	public ModelAndView detailArticle(@RequestParam("id") Integer id)
			throws ServiceException {
		
		Article article = serviceArticle.findById(id);
		ModelAndView modelAndView = new ModelAndView("detail-article", "article", article);
		
		Auteur auteur=serviceAuteur.findById(idDeploy);
		modelAndView.addObject("auteur", auteur);
		return modelAndView;
	}
	
}
