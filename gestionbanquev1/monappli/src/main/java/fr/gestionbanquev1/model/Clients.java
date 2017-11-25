package fr.gestionbanquev1.model;

/**
 * @author Amine DARABID
 *
 */
public class Clients {

	private int id;
	private String nom;
	private String prenom;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom.toUpperCase();
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public Clients(int id, String nom, String prenom) {
		this.id = id;
		this.nom = nom.toUpperCase();
		this.prenom = prenom;
	}
}
