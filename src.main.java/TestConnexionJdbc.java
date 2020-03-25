import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;

/**
 * 
 */

/** Test de la connexion jdbc
 *
 * @author KOMINIARZ Ana�s
 *
 */
public class TestConnexionJdbc {

	/**
	 * @param args
	 * @throws ClassNotFoundException 
	 * @throws SQLException 
	 */
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		
		// connexion � la base de donn�es compta sans utiliser un fichier externe
		
		/*DriverManager.registerDriver(new Driver());
		Connection connection = DriverManager.getConnection("jdbc:mariadb://localhost:3306/compta", "root", "");
		
		System.out.println(connection);
		connection.close(); */
		
		// connexion en utilisant un fichier externe 
		 // �tape 0 - lecture fichier "db.properties"
        ResourceBundle db = ResourceBundle.getBundle("db");

        // �tape 1 - enregistrer le pilote
        Class.forName(db.getString("db.driver"));

        // �tape 2 - cr�er la connexion
        Connection connection = DriverManager.getConnection(db.getString("db.url"), db.getString("db.user"), db.getString("db.pass"));

        // afficher la connexion
        System.out.println(connection);
        
        // fermer la connexion
        connection.close();
		
		

		
	}

}
