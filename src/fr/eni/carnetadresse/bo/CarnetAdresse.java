package fr.eni.carnetadresse.bo;

import java.util.ArrayList;
import java.util.List;

public class CarnetAdresse {
	
	List<Entree> carnetadresse; 

	
	/** Constructor full 
	 *  @param carnetadresse
	 * @param contact
	 */
	public CarnetAdresse() {
		carnetadresse = new ArrayList<Entree>();
	}
	
	public int getIndex(String nom, String prenom) {
		int index = 0;
		int i =0;
		
		for (Entree e : carnetadresse) {
			if ((this.getEntree(index).getContact().getNom().equalsIgnoreCase(nom)) && (this.getEntree(index).getContact().getPrenom().equalsIgnoreCase(prenom))) {
				index = i; 
			}
			i++; 
		}
		
		return index;
	}
	
	public Entree getEntree(int index) {
		return carnetadresse.get(index);	
	}
	
	public List<Entree> getCarnetAdresse () {
		return carnetadresse;
	}
	
	public void addEntree (Contact contact) {
		Entree nouvelle = new Entree(contact);
		carnetadresse.add(nouvelle);		
	}
	
	public void removeContact (int index) {
		carnetadresse.remove(index);
	}
	
	public void updateContact (int index, Contact contact) {				
		Entree modifiee = new Entree(contact);
		carnetadresse.remove(index);
		carnetadresse.add(index, modifiee);		
	}
	
	@Override 
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Carnet d'adresse \n\n");
		for (Entree e : carnetadresse) {
			if (e !=null) {
				sb.append("Entrée n°" + carnetadresse.indexOf(e)+ " : \n");
				sb.append(e.toString());
				sb.append("\n");
			} else break; 
		} 
		sb.append("\n");		
		
		return sb.toString();
	}
	
}
