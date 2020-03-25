/**
 * 
 */
package fr.diginamic.jdbc.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import fr.diginamic.jdb.entites.Fournisseur;

/** Représentation 
 *
 * @author KOMINIARZ Anaïs
 *
 */
public class FournisseurDaoJdbc implements FournisseurDao{

	//ArrayList<Fournisseur> fournisseurs = new ArrayList<>();
	
	@Override
	public List<Fournisseur> extraire() throws SQLException, ClassNotFoundException {
		ResourceBundle db = ResourceBundle.getBundle("db");
		Class.forName(db.getString("db.driver"));
  
		ArrayList<Fournisseur> fournisseurs = new ArrayList<>();
		
        Connection connection = DriverManager.getConnection(db.getString("db.url"), db.getString("db.user"), db.getString("db.pass"));
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("select * from fournisseur"); 
        
        connection.close();
        statement.close();
        
        // récupération des fournisseurs
        while (resultSet.next()) {
        	Fournisseur fournisseur = new Fournisseur(resultSet.getInt("id"), resultSet.getString("nom"));
        	fournisseurs.add(fournisseur);
        }
        resultSet.close();
        
        return fournisseurs;
	}

	@Override
	public void insert(Fournisseur fournisseur) throws SQLException, ClassNotFoundException {
		
		ResourceBundle db = ResourceBundle.getBundle("db");
		Class.forName(db.getString("db.driver"));
 
        Connection connection = DriverManager.getConnection(db.getString("db.url"), db.getString("db.user"), db.getString("db.pass"));
        Statement statement = connection.createStatement();
    	statement.executeUpdate("insert into fournisseur(id,nom) values("+ fournisseur.getId() + ", '" + fournisseur.getNom() +"')");
        connection.close();
        statement.close();
        
	}

	@Override
	public int update(String ancienNom, String nouveauNom) throws SQLException, ClassNotFoundException {
		ResourceBundle db = ResourceBundle.getBundle("db");
		Class.forName(db.getString("db.driver"));
 
        Connection connection = DriverManager.getConnection(db.getString("db.url"), db.getString("db.user"), db.getString("db.pass"));
        Statement statement = connection.createStatement();
    	int nbLignes = statement.executeUpdate(" update fournisseur set nom = '"+ nouveauNom + "' where nom= '" + ancienNom+"'");
        connection.close();
        statement.close();
		return nbLignes;
	}

	@Override
	public boolean delete(Fournisseur fournisseur) throws SQLException, ClassNotFoundException {
		ResourceBundle db = ResourceBundle.getBundle("db");
		Class.forName(db.getString("db.driver"));
 
        Connection connection = DriverManager.getConnection(db.getString("db.url"), db.getString("db.user"), db.getString("db.pass"));
        Statement statement = connection.createStatement();
        int nbLignes = statement.executeUpdate(" delete from fournisseur where id="+ fournisseur.getId());
        connection.close();
        statement.close();
        if (nbLignes == 1) {
        	return true;
        } return false;
	}

}
