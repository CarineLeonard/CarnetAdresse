package fr.eni.carnetadresse.dal;

import fr.eni.carnetadresse.dal.jdbc.ContactsDAOJdbcImpl;

public class DAOFactory {
	
	public static ContactsDAO getContactsDAO() {
		ContactsDAO contactDAO = new ContactsDAOJdbcImpl();
		return contactDAO; 
	}

}
