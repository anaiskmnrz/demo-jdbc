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
		
		/*ResourceBundle db = ResourceBundle.getBundle("db");
		try {
			Class.forName(db.getString("db.driver"));
		} catch (ClassNotFoundException e){
			System.out.println("Message d'erreur : " + e.getMessage());
		}

        try (Connection connection = DriverManager.getConnection(db.getString("db.url"), db.getString("db.user"), db.getString("db.pass"));
        		Statement statement = connection.createStatement();)
        {
            // insertion d'un nouveau fournisseur
           	statement.executeUpdate("insert into fournisseur(id,nom) values(4, 'La Maison de la Peinture')");
        } catch (SQLException e) {
        	System.out.println("Message d'erreur : " + e.getMessage());
        }*/
		
		//méthode TP4
	
		FournisseurDaoJdbc f = new FournisseurDaoJdbc();
		//Fournisseur f1 = new Fournisseur(4, "Patisserie en folie");
		Fournisseur f1 = new Fournisseur(4, "L'Espace création"); 
		// amène une erreur de syntaxe 
		try {
			f.insert(f1);
		} catch (SQLException | ClassNotFoundException e) {
			System.out.println(e.getMessage());
		}
	}

}
