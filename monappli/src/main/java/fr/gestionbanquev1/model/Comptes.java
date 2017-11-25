package fr.gestionbanquev1.model;

/**
 * @author Amine DARABID
 *
 */
public class Comptes {

	private int id;
	private int solde;
	private int idClient;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getSolde() {
		return solde;
	}

	public void setSolde(int solde) {
		this.solde = solde;
	}

	public int getIdClient() {
		return idClient;
	}

	public void setIdClient(int idClient) {
		this.idClient = idClient;
	}

	public Comptes(int id, int solde, int idClient) {
		this.id = id;
		this.solde = solde;
		this.idClient = idClient;
	}

}
