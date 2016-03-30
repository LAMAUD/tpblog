package fr.treeptik.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Transient;

@Entity
public class Article implements Serializable {
	
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	private String titre;
	
	@Column(columnDefinition="TEXT")
	private String chapeau;
	
	@Column(columnDefinition="TEXT")
	private String contenu;
	private Date creationDate;
	
	@Transient
	private Boolean enLigne;
	
	@ManyToOne(fetch=FetchType.LAZY)
	private Categorie categorie;
	
	@ManyToOne(fetch=FetchType.LAZY)
	private Auteur auteur;

	@OneToMany (mappedBy="article")
	private List<Commentaire> commentaires;
	
	
	public Article() {
		super();
		this.creationDate = new Date();
		
	}
	
	

	public Article(String titre, String chapeau, String contenu) {
		super();
		this.titre = titre;
		this.chapeau = chapeau;
		this.contenu = contenu;
	}



	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitre() {
		return titre;
	}

	public void setTitre(String titre) {
		this.titre = titre;
	}

	public String getChapeau() {
		return chapeau;
	}

	public void setChapeau(String chapeau) {
		this.chapeau = chapeau;
	}

	public String getContenu() {
		return contenu;
	}

	public void setContenu(String contenu) {
		this.contenu = contenu;
	}

	public Date getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	public Boolean getEnLigne() {
		return enLigne;
	}

	public void setEnLigne(Boolean enLigne) {
		this.enLigne = enLigne;
	}

	public Categorie getCategorie() {
		return categorie;
	}

	public void setCategorie(Categorie categorie) {
		this.categorie = categorie;
	}

	public Auteur getAuteur() {
		return auteur;
	}

	public void setAuteur(Auteur auteur) {
		this.auteur = auteur;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public List<Commentaire> getCommentaires() {
		
		if(commentaires == null){
			commentaires = new ArrayList<Commentaire>();
		}
		return commentaires;
	}

	public void setCommentaires(List<Commentaire> commentaires) {
		this.commentaires = commentaires;
	}



	@Override
	public String toString() {
		return "Article [id=" + id + ", titre=" + titre + ", chapeau="
				+ chapeau + ", contenu=" + contenu + ", creationDate="
				+ creationDate + ", enLigne=" + enLigne + ", categorie="
				+ categorie + ", auteur=" + auteur + ", commentaires="
				+ commentaires + "]";
	}
	
	

}
