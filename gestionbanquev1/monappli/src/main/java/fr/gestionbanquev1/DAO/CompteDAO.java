package fr.gestionbanquev1.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import fr.gestionbanquev1.model.Comptes;
import fr.gestionbanquev1.model.DAO;

/**
 * @author Amine DARABID
 *
 */
public class CompteDAO {

	/**
	 * r�cup�re en base de donn�es le solde de l'utilisateur
	 * 
	 * @param idclient
	 * @return
	 */
	public Comptes getSoldeBDD(Comptes cpt) {

		// D�claration des variables

		DAO cnn = DAO.connexion();

		Connection cn = null;
		Statement st = null;
		ResultSet rs = null;
		int idbdd = 0;
		int soldebdd = 0;
		int idclientbdd = 0;

		try {

			// Etape 1 : Chargement du driver
			Class.forName("com.mysql.jdbc.Driver");

			// Etape 2 : r�cup�ration de la connexion
			cn = DriverManager.getConnection(cnn.getUrl(), cnn.getLogin(), cnn.getPasswd());

			// Etape 3 : Cr�ation d'un statement
			st = cn.createStatement();

			String sql = "SELECT * FROM compte where idClient =" + cpt.getIdClient() + ";";

			// Etape 4 : ex�cution requ�te
			rs = st.executeQuery(sql);

			// Si r�cup donn�es alors �tapes 5 (parcours Resultset)

			if (rs.next()) {
				idbdd = rs.getInt("idcompte");
				soldebdd = rs.getInt("soldeCompte");
				idclientbdd = rs.getInt("idclient");
				cpt.setId(idbdd);
				cpt.setSolde(soldebdd);
				cpt.setIdClient(idclientbdd);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		} finally {
			try {
				// Etape 6 : lib�rer ressources de la m�moire.
				cn.close();
				st.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return cpt;
	}

	/**
	 * met � jour le solde de l'utilisateur en base de donn�es
	 * 
	 * @param newsolde
	 * @param idclient
	 */
	public void sauverEnBase(int newsolde, int idclient) {

		// D�claration des variables
		DAO cnn = DAO.connexion();
		Connection cn = null;
		Statement st = null;

		try {

			// Etape 1 : Chargement du driver
			Class.forName("com.mysql.jdbc.Driver");

			// Etape 2 : r�cup�ration de la connexion
			cn = DriverManager.getConnection(cnn.getUrl(), cnn.getLogin(), cnn.getPasswd());

			// Etape 3 : Cr�ation d'un statement
			st = cn.createStatement();

			String sql = "UPDATE compte SET soldeCompte = " + newsolde + " WHERE idClient = " + idclient;

			// Etape 4 : ex�cution requ�te
			st.executeUpdate(sql);

			// Si r�cup donn�es alors �tapes 5 (parcours Resultset)

		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		} catch (ClassNotFoundException e) {
			// TODO: handle exception
			e.printStackTrace();
			System.out.println(e.getMessage());
		} finally {
			try {
				// Etape 6 : lib�rer ressources de la m�moire.
				cn.close();
				st.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

}
