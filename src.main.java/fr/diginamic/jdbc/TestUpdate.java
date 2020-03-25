/**
 * 
 */
package fr.diginamic.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;

/** Test des updates 
 *
 * @author KOMINIARZ Anaïs
 *
 */
public class TestUpdate {

	/**
	 * @param args
	 * @throws ClassNotFoundException 
	 * @throws SQLException 
	 */
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		ResourceBundle db = ResourceBundle.getBundle("db");
      
		try {
			Class.forName(db.getString("db.driver"));
		} catch (ClassNotFoundException e){
			System.out.println("Message d'erreur : " + e.getMessage());
		}
  

        try(Connection connection = DriverManager.getConnection(db.getString("db.url"), db.getString("db.user"), db.getString("db.pass"));
        		Statement statement = connection.createStatement(); ) {
        	 
            // changement du nom du fournisseur 4
        	 statement.executeUpdate(" update fournisseur set nom = 'La Maison des Peintures' where id='4'");
        	 
        } catch (SQLException e) {
        	System.out.println("Message d'erreur : " + e.getMessage());
        }
 

	}

}
