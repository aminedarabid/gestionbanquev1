package fr.gestionbanquev1.model;

/**
 * @author Amine DARABID
 *
 */
public class DAO {

	private String url;
	private String login;
	private String passwd;

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPasswd() {
		return passwd;
	}

	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}

	public DAO(String url, String login, String passwd) {
		this.url = url;
		this.login = login;
		this.passwd = passwd;
	}

	/**
	 * Initialise les variables de connexion à la base de données
	 * 
	 * @return cnn
	 */
	public static DAO connexion() {
		String url = "jdbc:mysql://localhost/gestionbanque";
		String login = "root";
		String passwd = "";
		DAO cnn = new DAO(url, login, passwd);
		return cnn;
	}
}
