package fr.eni.carnetadresse.ihm.ecranCarnet;

import java.util.List;

import javax.swing.table.AbstractTableModel;

import fr.eni.carnetadresse.bo.Contact;
import fr.eni.carnetadresse.bo.Perso;
import fr.eni.carnetadresse.bo.Pro;

public class CarnetModele extends AbstractTableModel{
	
	private List<Contact> carnet; 
	
	private final String[] entetes = { "Civ", "Nom", "Prénom", "Adresse", "Complément", "CP", "Ville", "Portable", "Fixe", "Email", "Anniversaire", "Entreprise" };	
	
	public CarnetModele(List<Contact> carnet) {
		this.carnet = carnet; 
	}
	
	@Override
	public int getColumnCount() {
		return entetes.length;
	}
	
	@Override
	public String getColumnName(int columnIndex) {
		return entetes[columnIndex];
	}

	@Override
	public int getRowCount() {
		return carnet.size();
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		Object val = null;
		switch (columnIndex) {
			case TableCarnet.COL_CIV: // civ
				 val = carnet.get(rowIndex).getCivilite(); break; 
			case TableCarnet.COL_NOM : // nom
				val = carnet.get(rowIndex).getNom();break; 
			case TableCarnet.COL_PRENOM : // prenom 
				val = carnet.get(rowIndex).getPrenom(); break; 
			case TableCarnet.COL_ADRESSE : // adresse 
				val = carnet.get(rowIndex).getAdresse();break; 
			case TableCarnet.COL_COMPL : // complt 
				val = carnet.get(rowIndex).getAdresse2();break; 
			case TableCarnet.COL_CP : // cp 
				val = carnet.get(rowIndex).getCodepostal();break; 
			case TableCarnet.COL_VILLE : // ville  
				val = carnet.get(rowIndex).getVille();break; 
			case TableCarnet.COL_PORTABLE : // portable 
				val = carnet.get(rowIndex).getPortable();break; 
			case TableCarnet.COL_FIXE : // fixe 
				val = carnet.get(rowIndex).getFixe();break; 
			case TableCarnet.COL_EMAIL : // email 
				val = carnet.get(rowIndex).getEmail();break; 
			case TableCarnet.COL_ANNIVERSAIRE : // anniversaire 
				if (carnet.get(rowIndex).getClass().equals(Perso.class)) {
					Perso perso = (Perso) carnet.get(rowIndex); 
					val = perso.getDatenaissance(); 
				} else {
					val= null; 
				} break; 
			case TableCarnet.COL_ENTREPRISE : // entreprise 
				if (carnet.get(rowIndex).getClass().equals(Pro.class)) {
					Pro pro = (Pro) carnet.get(rowIndex); 
					val = pro.getEntreprise(); 
				} else {
					val= null; 
				} break; 
		}
		return val; 
	}

}
