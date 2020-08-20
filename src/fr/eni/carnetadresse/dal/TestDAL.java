package fr.eni.carnetadresse.dal;

import java.time.LocalDate;
import java.util.List;

import fr.eni.carnetadresse.bo.Contact;
import fr.eni.carnetadresse.bo.Perso;
import fr.eni.carnetadresse.bo.Pro;


public class TestDAL {
	public static void main(String[] args) {
		ContactsDAO contactDAO = DAOFactory.getContactsDAO();
		
		Contact ct1 = new Perso ("QUAY-THEVENON", "ELLA","220 av de Bassens", "Appt 32", "73000", "CHAMBERY", "06 26 99 63 53", null, "leonard.carine@gmail.com", "Mme",LocalDate.of(2019,06,28));
		Contact ct2 = new Pro ("QUAY-THEVENON", "Marc", "220 av de Bassens", "Appt 32", "73000", "CHAMBERY", "06 82 37 34 35", null, "jules.quaythevenon@gmail.com", "M.", "MND");
		
		
		try {
			// ajouter des contacts : OK 			
			System.out.println("Ajout des contacts.......................... ");
			contactDAO.insert(ct1);
			System.out.println("Article ajouté  : " + ct1.toString() );
			contactDAO.insert(ct2);
			System.out.println("Article ajouté  : " + ct2.toString() );
			System.out.println(); 
			
			// select 1 par id : OK
			System.out.println("Select by id.................................");
			Contact c = contactDAO.selectById(ct1.getIdContact());
			System.out.println("Sélection du contact par id  : " + c.toString() );
			System.out.println(); 
			
			// select all : OK 
			System.out.println("Select all     .................................");
			List<Contact> contacts = contactDAO.selectAll();
			System.out.println("Sélection de toutes les données  : " + contacts.toString() );
			System.out.println(); 
			
			// select by name 
			System.out.println("Select by name.................................");
			List<Contact> contact2 = contactDAO.selectByNom("quay", "loé");
			System.out.println("Sélection du contact par nom  : " + contact2.toString() );
			System.out.println(); 			
			
			// select by département 
			System.out.println("Select by depetement.................................");
			List<Contact> contact3 = contactDAO.selectByDepartement("73");
			System.out.println("Sélection du contact par département  : " + contact2.toString() );
			System.out.println(); 
			
			// modif un contact 
			System.out.println("Modification d'un article  : " );
			System.out.println("Article avant modification : "  + ct2.toString());
			((Pro) ct2).setAdresse("chez mémé");
			((Pro) ct2).setVille("aix");
			contactDAO.update(ct2);
			System.out.println("Article après modification  : " + ct2.toString() );
			System.out.println();
			
			// suppression un article 
			
			System.out.println("Suppression de l'article  : " + ct2.toString());
			contactDAO.delete(ct2.getIdContact());
			contact2 = contactDAO.selectAll();
			contact2.toString();
			System.out.println("---------------------------------------------------------------");

			
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("erreur");
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}
}
