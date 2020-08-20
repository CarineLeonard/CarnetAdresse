package fr.eni.carnetadresse.bll;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import fr.eni.carnetadresse.bo.Contact;
import fr.eni.carnetadresse.bo.Perso;
import fr.eni.carnetadresse.dal.ContactsDAO;
import fr.eni.carnetadresse.dal.DAOFactory;

public class CarnetManager {
	
	private ContactsDAO contactDAO;

	/**
	 * Constructor 
	 */
	public CarnetManager() throws BLLException {
		this.contactDAO = DAOFactory.getContactsDAO();
	} 
	
	public List<Contact> getCarnet () throws BLLException {
		List<Contact> listCon = new ArrayList<Contact>(); 
		try {
			listCon = contactDAO.selectAll();
		} catch (Exception e) {
			throw new BLLException("Echec recuperation carnet", e);
		}
		return listCon;
		
	}
	
	public void getContact (int index) throws BLLException {
		try {
			contactDAO.selectById(index);
		} catch (Exception e) {
			throw new BLLException("getcontact failed", e);
		}
	}
	public void getContactByNom (String nom, String prenom) throws BLLException {
		try {
			contactDAO.selectByNom(nom, prenom);
		} catch (Exception e) {
			throw new BLLException("getcontact by name failed", e);
		}
	}
	public void getContactByDepartement(String dpt) throws BLLException {
		try {
			contactDAO.selectByDepartement(dpt);
		} catch (Exception e) {
			throw new BLLException("getcontact by departement failed", e);
		}
	}
	
	public void addContact (Contact c) throws BLLException {
		if (c.getIdContact() == null ) {
			throw new BLLException("Contact déjà existant");
		}
		try {
			validerContact(c);
			contactDAO.insert(c);
		} catch (Exception e) {
			throw new BLLException("Echec add contact", e);
		}
	}
	public void updateContact (Contact c) throws BLLException {
		try {
			validerContact(c);
			contactDAO.update(c);
		} catch (Exception e) {
			throw new BLLException("Echec update contact"+ c, e);
		}
		
	}
	public void removeContact (Contact c) throws BLLException {
		try {
			contactDAO.delete(c.getIdContact());
		} catch (Exception e) {
			throw new BLLException("Echec delete contact"+ c, e);
		}
		
	}
	public void validerContact (Contact c) throws BLLException {
		boolean valide = true; 
		StringBuilder sb = new StringBuilder();
		
		if (c==null) {
			throw new BLLException("Contact null");
		}
		if (c.getCivilite()==null || c.getCivilite().trim().length()==0) {
			sb.append("La civilité est obligatoire. \n"); 
			valide = false; 
		}
		if (c.getNom()==null || c.getNom().trim().length()==0) {
			sb.append("Le nom est obligatoire. \n"); 
			valide = false; 
		}
		if (c.getPrenom()==null || c.getPrenom().trim().length()==0) {
			sb.append("Le prénom est obligatoire. \n"); 
			valide = false; 
		}
		if (c.getAdresse()==null || c.getAdresse().trim().length()==0) {
			sb.append("L'adresse est obligatoire. \n"); 
			valide = false; 
		}
		if (c.getCodepostal()==null || c.getCodepostal().trim().length()==0) {
			sb.append("Le code postal est obligatoire. \n"); 
			valide = false; 
		}
		if (c.getVille()==null || c.getVille().trim().length()==0) {
			sb.append("La ville est obligatoire. \n"); 
			valide = false; 
		}
		if (c instanceof Perso && (((Perso) c).getDatenaissance() == null)) {
			 // LocalDate.of(2019,06,28))
			((Perso)c).setDatenaissance(LocalDate.of(1970, 01, 01));
		}
		if (!valide) {
			throw new BLLException(sb.toString());
		}
	}
}
