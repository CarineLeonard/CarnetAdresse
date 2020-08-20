package fr.eni.carnetadresse.bo;

public class Entree {
	
	private Contact contact;

	
	/**
	 * Constructor 
	 * @param contact
	 */
	public Entree(Contact contact) {
		this.contact = contact;
	}

	/**
	 * @return the contact
	 */
	public Contact getContact() {
		return contact;
	}

	/**
	 * @param contact the contact to set
	 */
	public void setContact(Contact contact) {
		this.contact = contact;
	} 
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Contact : " + contact.getCivilite() + " " + contact.getPrenom() + " " + contact.getNom() + "\t " + contact.getAdresse() + " " + contact.getAdresse2() + " " + contact.getCodepostal() + " " 
				+ contact.getVille() + " \t Tél. : " + contact.getPortable() + " " + contact.getFixe() + " " + contact.getEmail());
		if (contact instanceof Perso) {
			Perso perso = (Perso) contact; 
			sb.append(perso.getDatenaissance());
		} else if (contact instanceof Pro) {
			Pro pro = (Pro) contact; 
			sb.append(pro.getEntreprise());
		}
		return sb.toString();
		
	}
	
	
}
