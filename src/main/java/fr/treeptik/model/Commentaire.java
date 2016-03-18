package fr.treeptik.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Transient;


@Entity
public class Commentaire implements Serializable{
	
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	private String nom;
	private String email;
	private String texte;
	private Date creationDate;
	
	@Transient
	private Boolean validation;
	
	@ManyToOne(fetch=FetchType.LAZY)
	private Article article;
	
	public Commentaire() {
		super();
		this.creationDate = new Date();
	}
	
	

	public Commentaire(String nom, String email, String texte) {
		super();
		this.nom = nom;
		this.email = email;
		this.texte = texte;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Article getArticle() {
		return article;
	}

	public void setArticle(Article article) {
		this.article = article;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTexte() {
		return texte;
	}

	public void setTexte(String texte) {
		this.texte = texte;
	}

	public Date getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	public Boolean getValidation() {
		return validation;
	}

	public void setValidation(Boolean validation) {
		this.validation = validation;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}



	@Override
	public String toString() {
		return "Commentaire [id=" + id + ", nom=" + nom + ", email=" + email
				+ ", texte=" + texte + ", creationDate=" + creationDate
				+ ", validation=" + validation + ", article=" + article + "]";
	}

	
	
}
