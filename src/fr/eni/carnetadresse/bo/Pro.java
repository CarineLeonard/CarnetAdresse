package fr.eni.carnetadresse.bo;

public class Pro extends Contact{
	
	private String entreprise; 
	
	/**
	 * Constructor with all elements 
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
	 * @param entreprise
	 */
	public Pro(int idContact, String nom, String prenom, String adresse, String adresse2, String codepostal,
			String ville, String portable, String fixe, String email, String civilite, String entreprise) {
		super(idContact, nom, prenom, adresse, adresse2, codepostal, ville, portable, fixe, email, civilite);
		this.entreprise = entreprise; 
	}
	
	/** constructor without idcontact
	 * 
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
	 * @param entreprise
	 */
	public Pro (String nom, String prenom, String adresse, String adresse2, String codepostal,
			String ville, String portable, String fixe, String email, String civilite, String entreprise) {
		super(nom, prenom, adresse, adresse2, codepostal, ville, portable, fixe, email, civilite);
		this.entreprise = entreprise; 
	}

	/**
	 * @return the entreprise
	 */
	public String getEntreprise() {
		return entreprise;
	}

	/**
	 * @param entreprise the entreprise to set
	 */
	public void setEntreprise(String entreprise) {
		this.entreprise = entreprise;
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder(); 
		sb.append(super.toString());
		sb.append("Entreprise : " + entreprise + "\n");
		
		return sb.toString();
	}

}
