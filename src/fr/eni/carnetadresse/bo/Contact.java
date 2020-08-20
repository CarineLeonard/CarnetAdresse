package fr.eni.carnetadresse.bo;

public abstract class Contact {
	
	private int idContact; 
	private String nom;
	private String prenom; 
	private String adresse;
	private String adresse2;
	private String codepostal; 
	private String ville; 
	private String portable; 
	private String fixe;
	private String email;
	private String civilite; 
	
	/**
	 * Constructor of a contact, whithout idContact 
	 * @param nom
	 * @param prenom
	 * @param adresse
	 * @param adresse2
	 * @param codepostal
	 * @param ville
	 * @param portable
	 * @param fixe
	 * @param email
	 */
	public Contact(String nom, String prenom, String adresse, String adresse2, String codepostal, String ville,
			String portable, String fixe, String email, String civilite) {
		this.nom = nom;
		this.prenom = prenom;
		this.adresse = adresse;
		this.adresse2 = adresse2;
		this.codepostal = codepostal;
		this.ville = ville;
		this.portable = portable;
		this.fixe = fixe;
		this.email = email;
		this.civilite = civilite; 
	}

	public Contact() {
		
	}
	
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
	 */
	public Contact(int idContact, String nom, String prenom, String adresse, String adresse2, String codepostal,
			String ville, String portable, String fixe, String email, String civilite) {
		this.idContact = idContact;
		this.nom = nom;
		this.prenom = prenom;
		this.adresse = adresse;
		this.adresse2 = adresse2;
		this.codepostal = codepostal;
		this.ville = ville;
		this.portable = portable;
		this.fixe = fixe;
		this.email = email;
		this.civilite = civilite; 
	}


	
	/**
	 * @return the idContact
	 */
	public Integer getIdContact() {
		return idContact;
	}


	/**
	 * @param idContact the idContact to set
	 */
	public void setIdContact(int idContact) {
		this.idContact = idContact;
	}


	/**
	 * @return the nom
	 */
	public String getNom() {
		return nom;
	}


	/**
	 * @param nom the nom to set
	 */
	public void setNom(String nom) {
		this.nom = nom;
	}


	/**
	 * @return the prenom
	 */
	public String getPrenom() {
		return prenom;
	}


	/**
	 * @param prenom the prenom to set
	 */
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}


	/**
	 * @return the adresse
	 */
	public String getAdresse() {
		return adresse;
	}


	/**
	 * @param adresse the adresse to set
	 */
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}


	/**
	 * @return the adresse2
	 */
	public String getAdresse2() {
		return adresse2;
	}


	/**
	 * @param adresse2 the adresse2 to set
	 */
	public void setAdresse2(String adresse2) {
		this.adresse2 = adresse2;
	}


	/**
	 * @return the codepostal
	 */
	public String getCodepostal() {
		return codepostal;
	}


	/**
	 * @param codepostal the codepostal to set
	 */
	public void setCodepostal(String codepostal) {
		this.codepostal = codepostal;
	}


	/**
	 * @return the ville
	 */
	public String getVille() {
		return ville;
	}


	/**
	 * @param ville the ville to set
	 */
	public void setVille(String ville) {
		this.ville = ville;
	}


	/**
	 * @return the portable
	 */
	public String getPortable() {
		return portable;
	}


	/**
	 * @param portable the portable to set
	 */
	public void setPortable(String portable) {
		this.portable = portable;
	}


	/**
	 * @return the fixe
	 */
	public String getFixe() {
		return fixe;
	}


	/**
	 * @param fixe the fixe to set
	 */
	public void setFixe(String fixe) {
		this.fixe = fixe;
	}


	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}


	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	} 
	
	/**
	 * @return the civilite
	 */
	public String getCivilite() {
		return civilite;
	}


	/**
	 * @param civilite the civilite to set
	 */
	public void setCivilite(String civilite) {
		this.civilite = civilite;
	}
	
	@Override
	public String toString() {
	StringBuilder sb = new StringBuilder(); 
	sb.append("Contact : \n");
	sb.append(civilite + " " + prenom + " " + nom + "\n");
	sb.append(adresse  + "\n");
	sb.append(adresse2 + "\n");
	sb.append(codepostal+ " " + ville +"\n");
	sb.append("Tél. : " + portable + "\n");
	sb.append("Tél. : " + fixe + "\n");
	sb.append(email + "\n");
		
		return sb.toString();
	}



	
}
