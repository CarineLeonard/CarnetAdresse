package fr.eni.carnetadresse.bll;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import fr.eni.carnetadresse.bo.Contact;
import fr.eni.carnetadresse.bo.Perso;
import fr.eni.carnetadresse.bo.Pro;


public class TestBLL {
	
	public static void main(String[] args) throws BLLException {


	List<Contact> carnet = new ArrayList<>();
	Contact ct1 = new Perso ("QUAY-THEVENON", "ELLA","220 av de Bassens", "Appt 32", "73000", "CHAMBERY", "06 26 99 63 53", null, "leonard.carine@gmail.com", "Mme",LocalDate.of(2019,06,28));
	Contact ct2 = new Pro ("QUAY-THEVENON", "Marc", "220 av de Bassens", "Appt 32", "73000", "CHAMBERY", "06 82 37 34 35", null, "jules.quaythevenon@gmail.com", "M.", "MND");
	
	carnet.add(ct1); 
	carnet.add(ct2); 
	carnet.add(new Perso("AMI", "Test", "2 rue", null, "73000", "CHAMBERY", "06 06 ", "04 04 79 ", null, "Mme",null));
	carnet.add(new Pro("PROF", "Test", "2 rue", null, "73000", "CHAMBERY", "06 06 ", "04 04 79 ", null, "Mme", "ENI"));
	System.out.println("ok 4 ajouts liste");
	
	CarnetManager mger = new CarnetManager();

	// Ajout 
	try {
		for (Contact con : carnet) {
			mger.addContact(con);
		} 
		System.out.println(mger.getCarnet());

	} catch (BLLException e) {
		e.printStackTrace();
	}
	System.out.println(); 

	// Modification 
	try {
		((Perso) ct1).setAdresse("3 rue de la biche");
		((Perso) ct1).setCivilite("M.");
		mger.updateContact(ct1);
		System.out.println("Article après modification  : " + ct1.toString());
	} catch (BLLException e) {
		e.printStackTrace();
	}
	System.out.println();

	// Suppression d'un article
	try {
		mger.removeContact(ct2);
		System.out.println("ok suppression");
		System.out.println(mger.getCarnet());
	} catch (BLLException e) {
		e.printStackTrace();
	}
}

	
}
	
