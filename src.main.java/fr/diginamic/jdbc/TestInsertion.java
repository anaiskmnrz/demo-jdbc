/**
 * 
 */
package fr.diginamic.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;

/** Test des insertions
 *
 * @author KOMINIARZ Anaïs
 *
 */
public class TestInsertion {

	/**
	 * @param args
	 * @throws ClassNotFoundException 
	 * @throws SQLException 
	 */
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		
		ResourceBundle db = ResourceBundle.getBundle("db");
        Class.forName(db.getString("db.driver"));

  
        Connection connection = DriverManager.getConnection(db.getString("db.url"), db.getString("db.user"), db.getString("db.pass"));

        // création d'un "statement" (outil pour faire des requêtes)
        Statement statement = connection.createStatement();

        // ajout d'un fournisseur 
        int nbLignesImpactées = statement.executeUpdate("insert into fournisseur(id,nom) values(4, 'La Maison de la Peinture')");
        
        connection.close();

	}

}
