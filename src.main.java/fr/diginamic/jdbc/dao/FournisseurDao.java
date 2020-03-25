/**
 * 
 */
package fr.diginamic.jdbc.dao;

import java.sql.SQLException;
import java.util.List;

import fr.diginamic.jdb.entites.Fournisseur;

/**
 * Interface fournisseur Data Acess Object
 *
 * @author KOMINIARZ Anaïs
 *
 */
public interface FournisseurDao {

	/**
	 * @return une liste de fournisseurs récupérée sur notre base de données
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 */
	List<Fournisseur> extraire() throws SQLException, ClassNotFoundException;

	/**
	 * @param fournisseur un fournisseur à ajouter à notre base de données
	 * @throws SQLException, ClassNotFoundException 
	 */
	void insert(Fournisseur fournisseur) throws SQLException, ClassNotFoundException;

	/**
	 * change le nom du fournisseur dans la base de données
	 * 
	 * @param ancienNom 	ancien Nom du fournisseur
	 * @param nouveauNom	nouveau nom du fournisseur
	 * @return le nombre de lignes mises à jour
	 * @throws NotClassFoundException 
	 * @throws SQLException 
	 */
	int update(String ancienNom, String nouveauNom) throws SQLException, ClassNotFoundException;

	/**
	 * 
	 * @param fournisseur 	fournisseur à supprimer
	 * @return 				true si la suppression a eu lieu, false sinon 
	 * @throws ClassNotFoundException 
	 * @throws SQLException 
	 */
	boolean delete(Fournisseur fournisseur) throws SQLException, ClassNotFoundException;
}
