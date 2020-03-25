/**
 * 
 */
package fr.diginamic.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;

import fr.diginamic.jdb.entites.Fournisseur;
import fr.diginamic.jdbc.dao.FournisseurDaoJdbc;

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
		/*ResourceBundle db = ResourceBundle.getBundle("db");
		try {
			Class.forName(db.getString("db.driver"));
		} catch (ClassNotFoundException e){
			System.out.println("Message d'erreur : " + e.getMessage());
		}
  
      
        try (Connection connection = DriverManager.getConnection(db.getString("db.url"), db.getString("db.user"), db.getString("db.pass"));
        		Statement statement = connection.createStatement(); ){
        	
        	   // suppression du fournisseur 4 
            	statement.executeUpdate(" delete from fournisseur where id='4'");
            	
        } catch (SQLException e) {
        	System.out.println("Message d'erreur : " + e.getMessage());
        }
        */
		
		//méthode TP4
		
		FournisseurDaoJdbc f = new FournisseurDaoJdbc();
		Fournisseur f1 = new Fournisseur(4, "Pâtisserie en folie");
		try {
			f.delete(f1);
		} catch (SQLException | ClassNotFoundException e) {
			System.out.println(e.getMessage());
		}


	}

}
