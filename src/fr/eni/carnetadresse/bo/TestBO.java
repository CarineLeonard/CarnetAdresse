package fr.eni.carnetadresse.bo;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class TestBO {
	public static void main(String[] args) {
		Contact ct1 = new Perso ("QUAY-THEVENON", "Iris","220 av de Bassens", "Appt 32", "73000", "CHAMBERY", "0626996353", null, "leonard.carine@gmail.com", "Mme",LocalDate.of(2019,06,28));
		Contact ct2 = new Pro ("QUAY-THEVENON", "Loé", "220 av de Bassens", "Appt 32", "73000", "CHAMBERY", "0682373435", null, "jules.quaythevenon@gmail.com", "M.", "MND");
		
		System.out.println(ct1.toString());
		System.out.println(ct2.toString());
		
		System.out.println("...............test contact........................");
		
		List<Contact> contacts = new ArrayList<Contact>();
		
		contacts.add(ct1);
		contacts.add(ct2);
		contacts.add(new Perso(1, "LEONARD", "Carine","220 av de Bassens", "Appt 32", "73000", "CHAMBERY", "0626996353", null, "leonard.carine@gmail.com", "Mme",LocalDate.of(1989,04,03)));
		contacts.add(new Pro(2, "QUAY-THEVENON", "Jules", "220 av de Bassens", "Appt 32", "73000", "CHAMBERY", "0682373435", null, "jules.quaythevenon@gmail.com", "M.", "MND")); 
		
		for (Contact contact : contacts) {
			System.out.println(contact.toString()); }
		
		System.out.println("..................test liste contacts.....................");
		
		CarnetAdresse carnet = new CarnetAdresse();
		
		carnet.addEntree(contacts.get(0));
		System.out.println(carnet.getEntree(0));
		System.out.println("...................test une entrée carnet ....................");
		
		carnet.addEntree(contacts.get(1));
		carnet.addEntree(contacts.get(2));
		System.out.println(carnet.toString());
		System.out.println("...................test le carnet ....................");
		
		carnet.removeContact(2);
		System.out.println(carnet.toString());
		
		System.out.println("...................supp ....................");
		
		carnet.updateContact(1, ct1);
		System.out.println(carnet.toString());
		
		System.out.println("................... modif ....................");
			
	}
}

