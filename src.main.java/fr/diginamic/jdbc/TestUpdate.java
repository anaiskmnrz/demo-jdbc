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
        Class.forName(db.getString("db.driver"));
  
        Connection connection = DriverManager.getConnection(db.getString("db.url"), db.getString("db.user"), db.getString("db.pass"));
   
        Statement statement = connection.createStatement();
        
        // changement du nom du fournisseur 4
        statement.executeUpdate(" update fournisseur set nom = 'La Maison des Peintures' where id='4'");
	}

}
