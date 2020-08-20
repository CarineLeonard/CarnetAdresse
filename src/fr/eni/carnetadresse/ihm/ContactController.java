package fr.eni.carnetadresse.ihm;

import java.util.List;

import fr.eni.carnetadresse.bll.BLLException;
import fr.eni.carnetadresse.bll.CarnetManager;
import fr.eni.carnetadresse.bo.Contact;
import fr.eni.carnetadresse.bo.Perso;
import fr.eni.carnetadresse.ihm.ecranCarnet.EcranCarnet;

public class ContactController {
	
	private EcranContacts ecrContact; 
	private int indexCarnet; 
	private CarnetManager mger; 
	public static List<Contact> carnet; 
	private static ContactController instance; 
	private EcranCarnet ecrCarnet; 
	
	/**
	 * Constructor 
	 */
	private ContactController() {
		try {
			mger = new CarnetManager(); 
			carnet = mger.getCarnet();			
		} catch (BLLException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * méthode unique instance : singleton
	 */
	public static synchronized ContactController get() {
		if (instance ==null) {
			instance = new ContactController(); 
		}
		return instance; 
	}
	
	public void startApp() {
		ecrContact = new EcranContacts();
		afficherPremierContact(); 
		ecrContact.setVisible(false); 
		
		ecrCarnet = new EcranCarnet();
		ecrCarnet.setVisible(true); 
		
	}
	
	public void fenetreContact() {
		ecrContact.setVisible(true); 
		ecrCarnet.setVisible(false); 
	}
	
	public void fenetreCarnet() {
		ecrCarnet.setVisible(true); 
		ecrContact.setVisible(false); 
		
	}

	private void afficherPremierContact() {
		if (carnet.size()>0) {
			indexCarnet = 0; 
			ecrContact.afficherContact(carnet.get(indexCarnet)); 
		} else {
			indexCarnet = -1; 
			ecrContact.afficherNouveau(); 
		}
		
	}

	public void create() {
		indexCarnet = carnet.size();
		ecrContact.afficherNouveau();
		
	}

	/**
	 * afficher le précédent (index d'avant)
	 */
	public void precedent() {
		if (indexCarnet > 0) {
			indexCarnet--;
			ecrContact.afficherContact(carnet.get(indexCarnet));
		}
	}

	/**
	 * afficher le suivant : index d'après ! 
	 */
	public void suivant() {
		if (indexCarnet < carnet.size()-1) {
			indexCarnet++;
			ecrContact.afficherContact(carnet.get(indexCarnet));
		}
		
	}

	public void save() {
		Contact contactaffiche = ecrContact.getContact(); 
		try {
			if (contactaffiche.getIdContact() == 0) {
				mger.addContact(contactaffiche);
				System.out.println("contact " + contactaffiche);
				carnet.add(contactaffiche);
				ecrContact.afficherContact(contactaffiche);
			} else {
				mger.updateContact(contactaffiche);
				carnet.set(indexCarnet, contactaffiche);
			}
		} catch (BLLException e) {
			ecrContact.infoErreur("Erreur enregistrement.");
			e.printStackTrace();
		}
	}


	public void delete(Integer idCourant) {
		Contact con = new Perso();
		con.setIdContact(idCourant);
		
		try {
			mger.removeContact(con);
			carnet.remove(indexCarnet);
		} catch (BLLException e) {
			ecrContact.infoErreur("Erreur suppression.");
			e.printStackTrace();
		}
		if (indexCarnet < carnet.size()) {
			ecrContact.afficherContact(carnet.get(indexCarnet));
		} else if (indexCarnet > 0){
			indexCarnet--;
			ecrContact.afficherContact(carnet.get(indexCarnet));
		} else {
			ecrContact.afficherNouveau();
		}
	}

	/**
	 * @return the carnet
	 */
	public static List<Contact> getCarnet() {
		return carnet;
	}


	
	
}
