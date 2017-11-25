package fr.gestionbanquev1.gestionbanque;

import java.sql.SQLException;
import java.util.Scanner;

import fr.gestionbanquev1.model.Clients;
import fr.gestionbanquev1.model.Comptes;
import fr.gestionbanquev1.service.ClientServices;

/**
 * @author Amine DARABID
 *
 */

public class GestionBanque {

	/**
	 * Point d'entrée de l'application
	 * 
	 * @param args
	 * @throws SQLException
	 */
	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub
		// Comptes cpt = new Comptes(1, 100, 1);
		// Clients cli = new Clients(1, "DARABID", "Amine");

		// déclaration des variables
		Clients cli = new Clients(0, "", "");
		ClientServices CS = new ClientServices();
		String name = "";
		Scanner sc = new Scanner(System.in);
		int test = 0;
		int essaie = 3;
		boolean existe = false;
		int choix = 0;
		Comptes cpt = new Comptes(0, 0, 0);
		int somme = 0;

		System.out.println("Gestion de votre compte");
		System.out.println("*************************");

		// authentification de l'utilisateur (3 essaies)
		for (test = 0; test < 3; test++) {
			System.out.println("Veuillez indiquer votre nom:(" + essaie + " essaies)");
			name = sc.nextLine().toUpperCase();
			cli = CS.authentification(name);
			if (cli.getId()==0  && cli.getNom() =="" && cli.getPrenom()=="") {
				System.out.println("L'utilisateur est inexistant dans notre base de données.");
				essaie--;
			} else {
				existe = true;
				break;
			}
		}

		// si le client existe dans la base de données, le menu s'affiche
		if (existe) {
			System.out.println("*************************");
			System.out.println("Bienvenue " + cli.getPrenom() + " " + cli.getNom());
			System.out.println("*************************");
			System.out.println("Que voulez-vous faire (1 ou 2):");
			System.out.println("Choix 1: Consulter son solde");
			System.out.println("Choix 2: Retrait d'argent");

			// recuparation du choix du menu
			choix = sc.nextInt();

			// en fonction du choix : consuler son solde ou retrait d'argent
			switch (choix) {
			case 1:

				// appel de la fonction consultersolde() dans la classe clientservices
				cpt = CS.consulterSolde(cli);
				System.out.println("Votre solde est de : " + cpt.getSolde()+"€.");
				break;

			case 2:
				// appel de la fonction consultersolde() dans la classe clientservices
				cpt = CS.consulterSolde(cli);

				// si le solde est superieur à 0
				if (cpt.getSolde() > 0) {

					// demande à l'utilisateur la somme du retrait d'argent
					System.out.println("Somme du retrait: ");
					somme = sc.nextInt();

					// si la somme est supérieur à 0
					if (somme > 0) {
						// si la somme est inférieur au solde
						if (somme < cpt.getSolde()) {
							// appel de la fonction retirerargent() dans la classe clientservices
							cpt = CS.retirerArgent(somme, cpt, cli);
							System.out.println("Votre nouveau solde est de : " + cpt.getSolde() + "€.");
						} else {
							System.out.println("La somme est superieur au solde.");
						}
					} else {
						System.out.println("La somme de retrait dois être supérieur à 0€.");
					}
				} else {
					System.out.println("Impossible de retirer de l'argent, le montant de votre solde est:"
							+ cpt.getSolde() + "€.");
				}
				break;

			default:
				System.out.println("Choix, non existant dans le menu.");
				break;
			}
			sc.close();
		} else {
			System.out.println("Vous venez de tenter 3 fois, votre compte est bloqué.");
		}

		System.out.println("*************************");
		System.out.println("Merci, au revoir.");
	}

}
