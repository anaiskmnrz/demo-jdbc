/**
 * 
 */
package fr.diginamic.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.ResourceBundle;

import fr.diginamic.jdb.entites.Fournisseur;

/** Test du select
 *
 * @author KOMINIARZ Anaïs
 *
 */
public class TestSelect {

	/**
	 * @param args
	 * @throws ClassNotFoundException 
	 * @throws SQLException 
	 */
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		
		
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
        
        
        ResultSet resultSet = null;
        try {
        	resultSet = statement.executeQuery("select * from fournisseur");
        } catch (SQLException e) {
        	System.out.println("Message d'erreur : " + e.getMessage());
        	connection.close();
        	statement.close();
        	resultSet.close(); 	
        }
        
        // récupération des fournisseurs
        ArrayList<Fournisseur> fournisseurs = new ArrayList<>();
        
        while (resultSet.next()) {
        	Fournisseur fournisseur = new Fournisseur(resultSet.getInt("id"), resultSet.getString("nom"));
        	fournisseurs.add(fournisseur);
        }
        
        connection.close();
        statement.close();
        resultSet.close();
        
        // affichage des fournisseurs
        for (Fournisseur fournisseur : fournisseurs) {
        	System.out.println(fournisseur);
        }
	}

}
