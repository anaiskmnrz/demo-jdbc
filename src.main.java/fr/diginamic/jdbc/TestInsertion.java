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
		try {
			Class.forName(db.getString("db.driver"));
		} catch (ClassNotFoundException e){
			System.out.println("Message d'erreur : " + e.getMessage());
		}
  
        Connection connection = null; 
        try {
        	connection = DriverManager.getConnection(db.getString("db.url"), db.getString("db.user"), db.getString("db.pass"));
        } catch (SQLException e) {
        	System.out.println("Message d'erreur : " + e.getMessage());
        	connection.close();
        }
        
        Statement statement = null;
        
        try {
        	statement = connection.createStatement();
        } catch (SQLException e){
        	System.out.println("Message d'erreur : " + e.getMessage());
        	connection.close();
        	statement.close();
        }
        
        // insertion d'un nouveau fournisseur
        try {
        	statement.executeUpdate("insert into fournisseur(id,nom) values(4, 'La Maison de la Peinture')");
        } catch(SQLException e) {
        	System.out.println("Message d'erreur : " + e.getMessage());
        	connection.close();
        	statement.close();
        }
        
        connection.close();
        statement.close();
 
	}

}
