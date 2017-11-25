package fr.gestionbanquev1.service;

import java.sql.SQLException;

import fr.gestionbanquev1.DAO.ClientDAO;
import fr.gestionbanquev1.DAO.CompteDAO;
import fr.gestionbanquev1.model.Clients;
import fr.gestionbanquev1.model.Comptes;

/**
 * @author Amine DARABID
 *
 */
public class ClientServices {

	/**
	 * verifie si le nom entrée par l'utilsateur existe dans la base de données
	 * 
	 * @param name
	 * @return client
	 */
	public Clients authentification(String name) throws SQLException {

		// appel de la fonction getclient dans la classe clientdao
		ClientDAO nameclient = new ClientDAO();
		Clients cli = nameclient.getClientbdd(name);
		return cli;
	}

	// /**
	// * récupère le solde de l'utilisateur
	// * @param cli
	// * @param cpt
	// * @return solde
	// */
	// public int consulterSoldeold(Clients cli, Comptes cpt) {
	// // Client cli = new Client(id, nom, prenom, solde)
	// int idclient = cli.getId();
	// if (idclient == cli.getId()) {
	// return cpt.getSolde();
	// } else {
	// return 0;
	// }
	// }

	/**
	 * récupère le solde de l'utilisateur dans la base de données
	 * 
	 * @param cli
	 * @return solde
	 */
	public Comptes consulterSolde(Clients cli) throws SQLException {
		Comptes cpt = new Comptes(0, 0, cli.getId());
		// appel de la fonction getSoldeBDD dans la classe comptedao
		CompteDAO solde = new CompteDAO();
		return solde.getSoldeBDD(cpt);
	}

	// /**
	// * déduit du solde la somme
	// * @param solde
	// * @param somme
	// * @param cli
	// * @return nouveau solde
	// */
	// public int retirerArgent2(int solde, int somme, Clients cli) {
	// int idclient = cli.getId();
	// Comptes compte = new Comptes(idclient);
	// compte.setSolde(solde - somme);
	// return solde - somme;
	// }

	/**
	 * réduit du solde la somme dans la base de données
	 * 
	 * @param solde
	 * @param somme
	 * @param cli
	 * @return nouveau solde
	 */
	public Comptes retirerArgent(int somme, Comptes cpt, Clients cli) throws SQLException {
		CompteDAO currentsolde = new CompteDAO();
		int newsolde = 0;
		try {
			newsolde = cpt.getSolde() - somme;
			// appel de la fonction sauverEnBase dans la classe comptedao
			currentsolde.sauverEnBase(newsolde, cpt.getIdClient());
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return consulterSolde(cli);
	}
}
