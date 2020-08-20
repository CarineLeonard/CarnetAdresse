package fr.eni.carnetadresse.ihm.ecranCarnet;

import java.awt.Dimension;
import java.util.List;

import javax.swing.JTable;
import javax.swing.ListSelectionModel;

import fr.eni.carnetadresse.bo.Contact;

public class TableCarnet extends JTable{
	
	public static final int COL_CIV = 0;
	public static final int COL_NOM = 1;
	public static final int COL_PRENOM = 2;
	public static final int COL_ADRESSE = 3;
	public static final int COL_COMPL = 4;
	public static final int COL_CP= 5;
	public static final int COL_VILLE = 6;
	public static final int COL_PORTABLE = 7;
	public static final int COL_FIXE = 8;
	public static final int COL_EMAIL = 9;
	public static final int COL_ANNIVERSAIRE = 10;
	public static final int COL_ENTREPRISE = 11;
	
	private List<Contact> carnet; 
	
	// private static ImageArticleTableCellRenderer imageArticleCellRenderer;
	


	public TableCarnet(List<Contact> carnet) {
		
		super(new CarnetModele(carnet)); 
		
        setPreferredScrollableViewportSize(new Dimension(1500, 600));
        setFillsViewportHeight(true);
        this.getColumnModel().getColumn(COL_CIV).setPreferredWidth(20);
        this.getColumnModel().getColumn(COL_NOM).setPreferredWidth(60);
        this.getColumnModel().getColumn(COL_PRENOM).setPreferredWidth(60);
        this.getColumnModel().getColumn(COL_ADRESSE).setPreferredWidth(100);
        this.getColumnModel().getColumn(COL_COMPL).setPreferredWidth(100);
        this.getColumnModel().getColumn(COL_CP).setPreferredWidth(30);
        this.getColumnModel().getColumn(COL_VILLE).setPreferredWidth(60);
        this.getColumnModel().getColumn(COL_PORTABLE).setPreferredWidth(60);
        this.getColumnModel().getColumn(COL_FIXE).setPreferredWidth(60);
        this.getColumnModel().getColumn(COL_EMAIL).setPreferredWidth(100);
        this.getColumnModel().getColumn(COL_ANNIVERSAIRE).setPreferredWidth(50);
        this.getColumnModel().getColumn(COL_ENTREPRISE).setPreferredWidth(50);
        
        this.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        
        // imageArticleCellRenderer= new ImageArticleTableCellRenderer();
        // this.getColumnModel().getColumn(COL_ICON).setCellRenderer(imageArticleCellRenderer); 
        
        this.setRowHeight(30);
        
	}

}
