package fr.eni.carnetadresse.dal;

import java.util.List;

import fr.eni.carnetadresse.bo.Contact;

public interface ContactsDAO {
	
	public Contact selectById (int idContact) throws DALException; 
		
	public List<Contact> selectByNom (String nom, String prenom) throws DALException;
	
	public List<Contact> selectByDepartement (String departement) throws DALException;
	
	public List<Contact> selectAll() throws DALException; 
	
	public void update(Contact contact) throws DALException; 
	
	public void insert(Contact contact) throws DALException;
	
	public void delete(int iDContact) throws DALException;

	
}
