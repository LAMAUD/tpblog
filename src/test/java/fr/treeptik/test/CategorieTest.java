package fr.treeptik.test;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import fr.treeptik.dao.CategorieDAO;
import fr.treeptik.exception.DAOException;
import fr.treeptik.model.Auteur;
import fr.treeptik.model.Categorie;
import fr.treeptik.service.ServiceCategorie;


@RunWith(SpringJUnit4ClassRunner.class)

@ContextConfiguration(locations={"classpath:test-context.xml"})
public class CategorieTest {

	private Categorie categorie1;
	private Categorie categorie2;
	private Categorie categorie3;
	private Categorie categorie4;
	private Auteur auteur;
	
	@Autowired
	ServiceCategorie serviceCategorie;
	
	@Before
	public void setUp() throws DAOException{
		

		
		categorie1 = new Categorie();
		categorie1.setId(1);
		categorie1.setName("Livres");
		categorie1.setUrl("www.livre.com");
		categorie1 =serviceCategorie.create(categorie1);
		
		
		categorie2 = new Categorie();
		categorie2.setId(2);
		categorie2.setName("roman");
		categorie2.setUrl("www.roman.com");
//		serviceCategorie.create(categorie2);
		
		
		categorie3 = new Categorie();
		categorie3.setId(3);
		categorie3.setName("magazine");
		categorie3.setUrl("www.magazine.com");
//		serviceCategorie.create(categorie3);
		
		categorie4 = new Categorie();
		categorie4.setId(4);
		categorie4.setName("magazine");
		categorie4.setUrl("www.magazine.com");
//		serviceCategorie.create(categorie4);
		
		auteur = new Auteur();
		auteur.setEmail("cedr629@hotmail.fr");
		auteur.setNom("LAMAUD");
		auteur.setPassword("HIHIHI");
		auteur.setPrenom("Cedric");
		
	}
	
	@Test
	public void persistence() throws DAOException{
		
		Categorie categorieTest1 = serviceCategorie.findById(1);
		assertEquals("Les objets sont égaux ? ", categorie1, categorieTest1);
		
		Categorie categorieTest2 = serviceCategorie.findById(2);
		assertEquals("Les objets sont égaux ? ", categorie2, categorieTest2);
		
		Categorie categorieTest3 = serviceCategorie.findById(3);
		assertEquals("Les objets sont égaux ? ", categorie3, categorieTest3);
		
		Categorie categorieTest4 = serviceCategorie.findById(4);
		assertEquals("Les objets sont égaux ? ", categorie4, categorieTest4);
		
	}
	
}
