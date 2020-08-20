package fr.eni.carnetadresse.bo;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class Perso extends Contact{
	
	private LocalDate datenaissance; 
	SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");

	/**
	 * Constructor full
	 * @param idContact
	 * @param nom
	 * @param prenom
	 * @param adresse
	 * @param adresse2
	 * @param codepostal
	 * @param ville
	 * @param portable
	 * @param fixe
	 * @param email
	 * @param civilite
	 * @param datenaissance
	 */
	public Perso(int idContact, String nom, String prenom, String adresse, String adresse2, String codepostal,
			String ville, String portable, String fixe, String email, String civilite, LocalDate datenaissance) {
		super(idContact, nom, prenom, adresse, adresse2, codepostal, ville, portable, fixe, email, civilite);
		this.datenaissance = datenaissance; 
	}
	
	/**
	 * Constructor without idContact
	 * @param nom
	 * @param prenom
	 * @param adresse
	 * @param adresse2
	 * @param codepostal
	 * @param ville
	 * @param portable
	 * @param fixe
	 * @param email
	 * @param civilite
	 * @param datenaissance
	 */
	public Perso(String nom, String prenom, String adresse, String adresse2, String codepostal,
			String ville, String portable, String fixe, String email, String civilite, LocalDate datenaissance) {
		super(nom, prenom, adresse, adresse2, codepostal, ville, portable, fixe, email, civilite);
		this.datenaissance = datenaissance; 
	}

	public Perso() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @return the datenaissance
	 */
	public LocalDate getDatenaissance() {
		return datenaissance;
	}

	/**
	 * @param datenaissance the datenaissance to set
	 */
	public void setDatenaissance(LocalDate datenaissance) {
		this.datenaissance = datenaissance;
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder(); 
		sb.append(super.toString());
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd MMMM yyyy");
		sb.append("Anniversaire : " + datenaissance.format(formatter) + "\n");
		
		return sb.toString();
		
	}

}
