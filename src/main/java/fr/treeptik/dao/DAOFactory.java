package fr.treeptik.dao;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import fr.treeptik.dao.impl.ArticleDAOJPA;
import fr.treeptik.dao.impl.AuteurDAOJPA;
import fr.treeptik.dao.impl.CategorieDAOJPA;
import fr.treeptik.dao.impl.CommentaireDAOJPA;

public class DAOFactory {
	


	public static String getSupport() {

		String support = null;
		FileReader propertieReader=null;
		try {
			propertieReader = new FileReader("support.properties");
		} catch (FileNotFoundException e1) {
			
			e1.printStackTrace();
		}

		Properties properties = new Properties();

		try {
			properties.load(propertieReader);
		} catch (IOException e) {
		
			e.printStackTrace();
		}

		support = properties.getProperty("support");
		
		return support;

	}

//	public static ArticleDAO createArticleDAO() {
//		ArticleDAO articleDAO = null;
//		
//		
//		String support = getSupport();
//		switch (support) {
//		case "jpa":
//			articleDAO = new ArticleDAOJPA();
//			break;
//
//		default:
//			break;
//		}
//
//		return articleDAO;
//
//	}
//
//	public static AuteurDAO createAuteurDAO() {
//		AuteurDAO auteurDAO = null;
//		
//		
//		String support = getSupport();
//		switch (support) {
//		case "jpa":
//			auteurDAO = new AuteurDAOJPA();
//			break;
//
//		default:
//			break;
//		}
//
//		return auteurDAO;
//
//	}
//
//	public static CategorieDAO createCategorieDAO() {
//		CategorieDAO categorieDAO = null;
//		
//		
//		String support = getSupport();
//		switch (support) {
//		case "jpa":
//			categorieDAO = new CategorieDAOJPA();
//			break;
//
//		default:
//			break;
//		}
//
//		return categorieDAO;
//
//	}
//	public static CommentaireDAO createCommentaireDAO() {
//		CommentaireDAO commentaireDAO = null;
//		
//		
//		String support = getSupport();
//		switch (support) {
//		case "jpa":
//			commentaireDAO = new CommentaireDAOJPA();
//			break;
//
//		default:
//			break;
//		}
//
//		return commentaireDAO;
//
//	}
}
