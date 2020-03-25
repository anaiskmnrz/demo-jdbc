/**
 * 
 */
package fr.diginamic.jdbc;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import fr.diginamic.jdb.entites.Fournisseur;
import fr.diginamic.jdbc.dao.FournisseurDaoJdbc;

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
		
		
		/*ResourceBundle db = ResourceBundle.getBundle("db");
		try {
			Class.forName(db.getString("db.driver"));
		} catch (ClassNotFoundException e){
			System.out.println("Message d'erreur : " + e.getMessage());
		}
  
		ArrayList<Fournisseur> fournisseurs = new ArrayList<>();
		
        try (Connection connection = DriverManager.getConnection(db.getString("db.url"), db.getString("db.user"), db.getString("db.pass"));
        	Statement statement = connection.createStatement();
        	ResultSet resultSet = statement.executeQuery("select * from fournisseur");)
        {	 
            // récupération des fournisseurs
            while (resultSet.next()) {
            	Fournisseur fournisseur = new Fournisseur(resultSet.getInt("id"), resultSet.getString("nom"));
            	fournisseurs.add(fournisseur);
            }
            
        } catch (SQLException e) {
        	System.out.println("Message d'erreur : " + e.getMessage());
        }
   
        
        // affichage des fournisseurs
        for (Fournisseur fournisseur : fournisseurs) {
        	System.out.println(fournisseur);
        }
	}*/
		
		//méthode TP4
		
		FournisseurDaoJdbc f = new FournisseurDaoJdbc();
		List<Fournisseur> fournisseurs = new ArrayList<>();
		try {
			fournisseurs = f.extraire();
		} catch (SQLException | ClassNotFoundException e) {
			System.out.println(e.getMessage());
		}
	
		for (Fournisseur fournisseur : fournisseurs) {
			System.out.println(fournisseur);
		}
		
	}
}
