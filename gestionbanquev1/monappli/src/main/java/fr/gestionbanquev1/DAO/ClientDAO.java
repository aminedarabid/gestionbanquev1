package fr.gestionbanquev1.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import fr.gestionbanquev1.model.Clients;
import fr.gestionbanquev1.model.DAO;

/**
 * @author Amine DARABID
 *
 */
public class ClientDAO {

	/**
	 * recupère le client dont le nom est passé en paramètre
	 * 
	 * @param name
	 * @return client
	 */
	public Clients getClientbdd(String name) {

		// Déclaration des variables
		DAO cnn = DAO.connexion();

		Connection cn = null;
		Statement st = null;
		ResultSet rs = null;
		int idbdd = 0;
		String nombdd = "";
		String prenombdd = "";
		Clients cli = new Clients(0, "", "");

		try {

			// Etape 1 : Chargement du driver
			Class.forName("com.mysql.jdbc.Driver");

			// Etape 2 : récupération de la connexion
			cn = DriverManager.getConnection(cnn.getUrl(), cnn.getLogin(), cnn.getPasswd());

			// Etape 3 : Création d'un statement
			st = cn.createStatement();

			String sql = "SELECT * FROM client where nomClient ='" + name + "';";

			// Etape 4 : exécution requête
			rs = st.executeQuery(sql);

			// Si récup données alors étapes 5 (parcours Resultset)
			if (rs.next()) {
				idbdd = rs.getInt("idClient");
				nombdd = rs.getString("nomclient");
				prenombdd = rs.getString("prenomclient");

				cli = new Clients(idbdd, nombdd, prenombdd);
			} else {
				idbdd = 0;
				nombdd = "";
				prenombdd = "";
				cli = new Clients(idbdd, nombdd, prenombdd);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		} finally {
			try {
				// Etape 6 : libérer ressources de la mémoire.
				cn.close();
				st.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return cli;
	}
}
