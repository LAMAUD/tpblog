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

import fr.treeptik.exception.DAOException;
import fr.treeptik.exception.ServiceException;
import fr.treeptik.model.Article;
import fr.treeptik.model.Auteur;
import fr.treeptik.model.Commentaire;
import fr.treeptik.model.Role;
import fr.treeptik.service.ServiceArticle;
import fr.treeptik.service.ServiceCommentaire;
import fr.treeptik.validator.CommentaireValidator;

@Controller
@RequestMapping("/commentaire")
public class CommentaireController {

	private final static Logger LOGGER = Logger
			.getLogger(CommentaireController.class);

	@Autowired
	private ServiceCommentaire serviceCommentaire;
	
	@Autowired
	private ServiceArticle serviceArticle;
	
	@Autowired
	private CommentaireValidator commentaireValidator;

	private Integer idDeploy;

	@RequestMapping(value = "/commentaire.do", method = RequestMethod.GET)
	public ModelAndView initForm() throws DAOException {

		ModelAndView modelAndView = new ModelAndView("commentaire",
				"commentaire", new Commentaire());

		return modelAndView;
	}

	@RequestMapping(value = "/update.do", method = RequestMethod.GET)
	public ModelAndView updateForm(@RequestParam("id") Integer id)
			throws ServiceException, DAOException {

		Commentaire commentaire = serviceCommentaire.findById(id);
		ModelAndView modelAndView = new ModelAndView("commentaire",
				"commentaire", commentaire);

		return modelAndView;
	}

	@RequestMapping(value = "/list.do", method = RequestMethod.GET)
	public ModelAndView listClient(HttpServletRequest request)
			throws ServiceException, DAOException {

		return new ModelAndView("list-commentaire", "commentaire",
				serviceCommentaire.read());
	}

	@RequestMapping(value = "/delete.do", method = RequestMethod.GET)
	public ModelAndView delete(@RequestParam("id") Integer id)
			throws ServiceException {
		serviceCommentaire.delete(id);
		return new ModelAndView("redirect:list.do");
	}

	@RequestMapping(value = "/save.do", method = RequestMethod.GET)
	public ModelAndView saveClient(@Valid Commentaire commentaire,
			BindingResult result) throws ServiceException, DAOException {
		ModelAndView modelAndView = new ModelAndView("commentaire");

		commentaireValidator.validate(commentaire, result);
		
		if (result.hasErrors()) {
			for (ObjectError objectError : result.getAllErrors()) {
				LOGGER.info(objectError.getDefaultMessage());
			}

			commentaire.setTexte(null);

			modelAndView.addObject("commentaire", commentaire);

			return modelAndView;
		}

		Article art = serviceArticle.findById(idDeploy);
		commentaire.setArticle(art);
		commentaire = serviceCommentaire.create(commentaire);
		String com = "redirect:ListCommentaire.do?id=" + idDeploy;
		modelAndView = new ModelAndView(com);
		return modelAndView;
	}

	@RequestMapping(value = "/ListCommentaire.do", method = RequestMethod.GET)
	public ModelAndView listArticle(HttpServletRequest request,
			@RequestParam("id") Integer id) throws ServiceException,
			DAOException {
		// String articleTitre = SecurityContextHolder.getContext()
		// .getAuthentication().getName();
		// if (request.getSession().getAttribute("userSessionId") == null) {
		// Article article = serviceArticle.findByTitre(articleTitre);
		// request.getSession().setAttribute("userSessionId", article.getId());
		// }
		idDeploy = id;
		return new ModelAndView("list-commentaire", "commentaire",
				serviceCommentaire.read(id));
	}

}
