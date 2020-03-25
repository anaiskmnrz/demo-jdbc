/**
 * 
 */
package fr.diginamic.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;

/** Représentation 
 *
 * @author KOMINIARZ Anaïs
 *
 */
public class TestDelete {

	/**
	 * @param args
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 */
	public static void main(String[] args) throws SQLException, ClassNotFoundException {
		
		ResourceBundle db = ResourceBundle.getBundle("db");
        Class.forName(db.getString("db.driver"));
  
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
        
      
        // suppression du fournisseur 4 
        try {
        	statement.executeUpdate(" delete from fournisseur where id='4'");
        } catch(SQLException e) {
        	System.out.println("Message d'erreur : " + e.getMessage());
        	connection.close();
        	statement.close();
        }
        
        connection.close();
        statement.close();
        
        

	}

}
