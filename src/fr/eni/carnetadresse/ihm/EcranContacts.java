package fr.eni.carnetadresse.ihm;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import fr.eni.carnetadresse.bo.Contact;
import fr.eni.carnetadresse.bo.Perso;
import fr.eni.carnetadresse.bo.Pro;

import javax.swing.JTabbedPane;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import javax.swing.JTextField;
import java.awt.Insets;
import javax.swing.JToggleButton;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Calendar;
import java.awt.event.ActionEvent;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.JScrollBar;
import javax.swing.JRadioButton;

public class EcranContacts extends JFrame {

	private JPanel contentPane;
	private JLabel lblCiv;
	private JTextField textFieldCiv;
	private JLabel lblNom;
	private JTextField textFieldNom;
	private JLabel lblPrenom;
	private JTextField textFieldPrenom;
	private JLabel lblAdresse;
	private JTextField textFieldadresse;
	private JLabel lblcomplt;
	private JTextField textFieldComplt;
	private JLabel lblcodepostal;
	private JTextField textFieldcp;
	private JLabel lblville;
	private JTextField textFieldville;
	private JLabel lblidcontact;
	private JTextField textFieldidcontact;
	private JLabel lblportable;
	private JTextField textFieldportable;
	private JLabel lblfixe;
	private JTextField textFieldfixe;
	private JLabel lblemail;
	private JTextField textFieldemail;
	private JLabel lbldatenaissance;
	private JTextField textFielddatenaissance;
	private JLabel lblentreprise;
	private JTextField textFieldentreprise;
	private JPanel panelboutons;
	private JButton btnNouveau;
	private JButton btnprecedent;
	private JButton btnsuivant;
	private JButton btnenregistrer;
	private JButton Supprimer;
	private JMenuBar menuBar;
	private JButton btncontacts;
	private JButton btncarnet;
	private Integer idCourant; 
	private JLabel lbltype;
	private JPanel panelradio;
	private JRadioButton rdbtnpro;
	private JRadioButton rdbtperso;
	


	/**
	 * Create the frame.
	 */
	public EcranContacts() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 660, 409);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setTitle("Contacts");
		setJMenuBar(getMenuBar_1());
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0, 0};
		gbl_contentPane.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_contentPane.columnWeights = new double[]{0.0, 1.0, 0.0, 0.0, 0.0, 1.0, 0.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 1.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		GridBagConstraints gbc_lblidcontact = new GridBagConstraints();
		gbc_lblidcontact.anchor = GridBagConstraints.EAST;
		gbc_lblidcontact.insets = new Insets(0, 0, 5, 5);
		gbc_lblidcontact.gridx = 0;
		gbc_lblidcontact.gridy = 0;
		contentPane.add(getLblidcontact(), gbc_lblidcontact);
		GridBagConstraints gbc_textFieldidcontact = new GridBagConstraints();
		gbc_textFieldidcontact.insets = new Insets(0, 0, 5, 5);
		gbc_textFieldidcontact.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldidcontact.gridx = 1;
		gbc_textFieldidcontact.gridy = 0;
		contentPane.add(getTextFieldidcontact(), gbc_textFieldidcontact);
		GridBagConstraints gbc_lblCiv = new GridBagConstraints();
		gbc_lblCiv.insets = new Insets(0, 0, 5, 5);
		gbc_lblCiv.anchor = GridBagConstraints.EAST;
		gbc_lblCiv.gridx = 0;
		gbc_lblCiv.gridy = 1;
		contentPane.add(getLblCiv(), gbc_lblCiv);
		GridBagConstraints gbc_textFieldCiv = new GridBagConstraints();
		gbc_textFieldCiv.anchor = GridBagConstraints.WEST;
		gbc_textFieldCiv.insets = new Insets(0, 0, 5, 5);
		gbc_textFieldCiv.gridx = 1;
		gbc_textFieldCiv.gridy = 1;
		contentPane.add(getTextFieldCiv(), gbc_textFieldCiv);
		GridBagConstraints gbc_lblPrenom = new GridBagConstraints();
		gbc_lblPrenom.insets = new Insets(0, 0, 5, 5);
		gbc_lblPrenom.anchor = GridBagConstraints.EAST;
		gbc_lblPrenom.gridx = 2;
		gbc_lblPrenom.gridy = 1;
		contentPane.add(getLblPrenom(), gbc_lblPrenom);
		GridBagConstraints gbc_textFieldPrenom = new GridBagConstraints();
		gbc_textFieldPrenom.insets = new Insets(0, 0, 5, 5);
		gbc_textFieldPrenom.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldPrenom.gridx = 3;
		gbc_textFieldPrenom.gridy = 1;
		contentPane.add(getTextFieldPrenom(), gbc_textFieldPrenom);
		GridBagConstraints gbc_lblNom = new GridBagConstraints();
		gbc_lblNom.insets = new Insets(0, 0, 5, 5);
		gbc_lblNom.anchor = GridBagConstraints.EAST;
		gbc_lblNom.gridx = 4;
		gbc_lblNom.gridy = 1;
		contentPane.add(getLblNom(), gbc_lblNom);
		GridBagConstraints gbc_textFieldNom = new GridBagConstraints();
		gbc_textFieldNom.insets = new Insets(0, 0, 5, 5);
		gbc_textFieldNom.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldNom.gridx = 5;
		gbc_textFieldNom.gridy = 1;
		contentPane.add(getTextFieldNom(), gbc_textFieldNom);
		GridBagConstraints gbc_lblAdresse = new GridBagConstraints();
		gbc_lblAdresse.anchor = GridBagConstraints.EAST;
		gbc_lblAdresse.insets = new Insets(0, 0, 5, 5);
		gbc_lblAdresse.gridx = 0;
		gbc_lblAdresse.gridy = 2;
		contentPane.add(getLblAdresse(), gbc_lblAdresse);
		GridBagConstraints gbc_textFieldadresse = new GridBagConstraints();
		gbc_textFieldadresse.gridwidth = 5;
		gbc_textFieldadresse.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldadresse.insets = new Insets(0, 0, 5, 5);
		gbc_textFieldadresse.gridx = 1;
		gbc_textFieldadresse.gridy = 2;
		contentPane.add(getTextFieldadresse(), gbc_textFieldadresse);
		GridBagConstraints gbc_lblcomplt = new GridBagConstraints();
		gbc_lblcomplt.anchor = GridBagConstraints.EAST;
		gbc_lblcomplt.insets = new Insets(0, 0, 5, 5);
		gbc_lblcomplt.gridx = 0;
		gbc_lblcomplt.gridy = 3;
		contentPane.add(getLblcomplt(), gbc_lblcomplt);
		GridBagConstraints gbc_textFieldComplt = new GridBagConstraints();
		gbc_textFieldComplt.gridwidth = 5;
		gbc_textFieldComplt.insets = new Insets(0, 0, 5, 5);
		gbc_textFieldComplt.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldComplt.gridx = 1;
		gbc_textFieldComplt.gridy = 3;
		contentPane.add(getTextFieldComplt(), gbc_textFieldComplt);
		GridBagConstraints gbc_lblcodepostal = new GridBagConstraints();
		gbc_lblcodepostal.anchor = GridBagConstraints.EAST;
		gbc_lblcodepostal.insets = new Insets(0, 0, 5, 5);
		gbc_lblcodepostal.gridx = 0;
		gbc_lblcodepostal.gridy = 4;
		contentPane.add(getLblcodepostal(), gbc_lblcodepostal);
		GridBagConstraints gbc_textFieldcp = new GridBagConstraints();
		gbc_textFieldcp.insets = new Insets(0, 0, 5, 5);
		gbc_textFieldcp.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldcp.gridx = 1;
		gbc_textFieldcp.gridy = 4;
		contentPane.add(getTextFieldcp(), gbc_textFieldcp);
		GridBagConstraints gbc_lblville = new GridBagConstraints();
		gbc_lblville.anchor = GridBagConstraints.EAST;
		gbc_lblville.insets = new Insets(0, 0, 5, 5);
		gbc_lblville.gridx = 2;
		gbc_lblville.gridy = 4;
		contentPane.add(getLblville(), gbc_lblville);
		GridBagConstraints gbc_textFieldville = new GridBagConstraints();
		gbc_textFieldville.insets = new Insets(0, 0, 5, 5);
		gbc_textFieldville.gridwidth = 3;
		gbc_textFieldville.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldville.gridx = 3;
		gbc_textFieldville.gridy = 4;
		contentPane.add(getTextFieldville(), gbc_textFieldville);
		GridBagConstraints gbc_lblportable = new GridBagConstraints();
		gbc_lblportable.anchor = GridBagConstraints.EAST;
		gbc_lblportable.insets = new Insets(0, 0, 5, 5);
		gbc_lblportable.gridx = 0;
		gbc_lblportable.gridy = 5;
		contentPane.add(getLblportable(), gbc_lblportable);
		GridBagConstraints gbc_textFieldportable = new GridBagConstraints();
		gbc_textFieldportable.gridwidth = 3;
		gbc_textFieldportable.insets = new Insets(0, 0, 5, 5);
		gbc_textFieldportable.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldportable.gridx = 1;
		gbc_textFieldportable.gridy = 5;
		contentPane.add(getTextFieldportable(), gbc_textFieldportable);
		GridBagConstraints gbc_lblfixe = new GridBagConstraints();
		gbc_lblfixe.anchor = GridBagConstraints.EAST;
		gbc_lblfixe.fill = GridBagConstraints.VERTICAL;
		gbc_lblfixe.insets = new Insets(0, 0, 5, 5);
		gbc_lblfixe.gridx = 4;
		gbc_lblfixe.gridy = 5;
		contentPane.add(getLblfixe(), gbc_lblfixe);
		GridBagConstraints gbc_textFieldfixe = new GridBagConstraints();
		gbc_textFieldfixe.insets = new Insets(0, 0, 5, 5);
		gbc_textFieldfixe.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldfixe.gridx = 5;
		gbc_textFieldfixe.gridy = 5;
		contentPane.add(getTextFieldfixe(), gbc_textFieldfixe);
		GridBagConstraints gbc_lblemail = new GridBagConstraints();
		gbc_lblemail.anchor = GridBagConstraints.EAST;
		gbc_lblemail.insets = new Insets(0, 0, 5, 5);
		gbc_lblemail.gridx = 0;
		gbc_lblemail.gridy = 6;
		contentPane.add(getLblemail(), gbc_lblemail);
		GridBagConstraints gbc_textFieldemail = new GridBagConstraints();
		gbc_textFieldemail.insets = new Insets(0, 0, 5, 5);
		gbc_textFieldemail.gridwidth = 5;
		gbc_textFieldemail.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldemail.gridx = 1;
		gbc_textFieldemail.gridy = 6;
		contentPane.add(getTextFieldemail(), gbc_textFieldemail);
		GridBagConstraints gbc_lbldatenaissance = new GridBagConstraints();
		gbc_lbldatenaissance.anchor = GridBagConstraints.EAST;
		gbc_lbldatenaissance.insets = new Insets(0, 0, 5, 5);
		gbc_lbldatenaissance.gridx = 0;
		gbc_lbldatenaissance.gridy = 7;
		contentPane.add(getLbldatenaissance(), gbc_lbldatenaissance);
		GridBagConstraints gbc_textFielddatenaissance = new GridBagConstraints();
		gbc_textFielddatenaissance.insets = new Insets(0, 0, 5, 5);
		gbc_textFielddatenaissance.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFielddatenaissance.gridx = 1;
		gbc_textFielddatenaissance.gridy = 7;
		contentPane.add(getTextFielddatenaissance(), gbc_textFielddatenaissance);
		GridBagConstraints gbc_lblentreprise = new GridBagConstraints();
		gbc_lblentreprise.insets = new Insets(0, 0, 5, 5);
		gbc_lblentreprise.gridx = 3;
		gbc_lblentreprise.gridy = 7;
		contentPane.add(getLblentreprise(), gbc_lblentreprise);
		GridBagConstraints gbc_textFieldentreprise = new GridBagConstraints();
		gbc_textFieldentreprise.insets = new Insets(0, 0, 5, 5);
		gbc_textFieldentreprise.gridwidth = 2;
		gbc_textFieldentreprise.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldentreprise.gridx = 4;
		gbc_textFieldentreprise.gridy = 7;
		contentPane.add(getTextFieldentreprise(), gbc_textFieldentreprise);
		GridBagConstraints gbc_lbltype = new GridBagConstraints();
		gbc_lbltype.insets = new Insets(0, 0, 5, 5);
		gbc_lbltype.gridx = 0;
		gbc_lbltype.gridy = 8;
		contentPane.add(getLbltype(), gbc_lbltype);
		GridBagConstraints gbc_panelradio = new GridBagConstraints();
		gbc_panelradio.gridwidth = 5;
		gbc_panelradio.insets = new Insets(0, 0, 5, 5);
		gbc_panelradio.fill = GridBagConstraints.BOTH;
		gbc_panelradio.gridx = 1;
		gbc_panelradio.gridy = 8;
		contentPane.add(getPanelradio(), gbc_panelradio);
		GridBagConstraints gbc_panelboutons = new GridBagConstraints();
		gbc_panelboutons.gridwidth = 6;
		gbc_panelboutons.insets = new Insets(0, 0, 0, 5);
		gbc_panelboutons.fill = GridBagConstraints.BOTH;
		gbc_panelboutons.gridx = 0;
		gbc_panelboutons.gridy = 9;
		contentPane.add(getPanelboutons(), gbc_panelboutons);
	}
	private JLabel getLblCiv() {
		if (lblCiv == null) {
			lblCiv = new JLabel("Civilité : ");
		}
		return lblCiv;
	}
	private JTextField getTextFieldCiv() {
		if (textFieldCiv == null) {
			textFieldCiv = new JTextField();
			textFieldCiv.setColumns(10);
		}
		return textFieldCiv;
	}
	private JLabel getLblNom() {
		if (lblNom == null) {
			lblNom = new JLabel("Nom :");
		}
		return lblNom;
	}
	private JTextField getTextFieldNom() {
		if (textFieldNom == null) {
			textFieldNom = new JTextField();
			textFieldNom.setColumns(10);
		}
		return textFieldNom;
	}
	private JLabel getLblPrenom() {
		if (lblPrenom == null) {
			lblPrenom = new JLabel("Prenom :");
		}
		return lblPrenom;
	}
	private JTextField getTextFieldPrenom() {
		if (textFieldPrenom == null) {
			textFieldPrenom = new JTextField();
			textFieldPrenom.setColumns(10);
		}
		return textFieldPrenom;
	}
	private JLabel getLblAdresse() {
		if (lblAdresse == null) {
			lblAdresse = new JLabel("Adresse : ");
		}
		return lblAdresse;
	}
	private JTextField getTextFieldadresse() {
		if (textFieldadresse == null) {
			textFieldadresse = new JTextField();
			textFieldadresse.setColumns(10);
		}
		return textFieldadresse;
	}
	private JLabel getLblcomplt() {
		if (lblcomplt == null) {
			lblcomplt = new JLabel("Complément : ");
		}
		return lblcomplt;
	}
	private JTextField getTextFieldComplt() {
		if (textFieldComplt == null) {
			textFieldComplt = new JTextField();
			textFieldComplt.setColumns(10);
		}
		return textFieldComplt;
	}
	private JLabel getLblcodepostal() {
		if (lblcodepostal == null) {
			lblcodepostal = new JLabel("CP : ");
		}
		return lblcodepostal;
	}
	private JTextField getTextFieldcp() {
		if (textFieldcp == null) {
			textFieldcp = new JTextField();
			textFieldcp.setColumns(10);
		}
		return textFieldcp;
	}
	private JLabel getLblville() {
		if (lblville == null) {
			lblville = new JLabel("Ville : ");
		}
		return lblville;
	}
	private JTextField getTextFieldville() {
		if (textFieldville == null) {
			textFieldville = new JTextField();
			textFieldville.setColumns(10);
		}
		return textFieldville;
	}
	private JLabel getLblidcontact() {
		if (lblidcontact == null) {
			lblidcontact = new JLabel("N° contact : ");
		}
		return lblidcontact;
	}
	private JTextField getTextFieldidcontact() {
		if (textFieldidcontact == null) {
			textFieldidcontact = new JTextField();
			textFieldidcontact.setColumns(10);
			textFieldidcontact.setEnabled(false);
		}
		return textFieldidcontact;
	}
	private JLabel getLblportable() {
		if (lblportable == null) {
			lblportable = new JLabel("Portable : ");
		}
		return lblportable;
	}
	private JTextField getTextFieldportable() {
		if (textFieldportable == null) {
			textFieldportable = new JTextField();
			textFieldportable.setColumns(10);
		}
		return textFieldportable;
	}
	private JLabel getLblfixe() {
		if (lblfixe == null) {
			lblfixe = new JLabel("Fixe : ");
		}
		return lblfixe;
	}
	private JTextField getTextFieldfixe() {
		if (textFieldfixe == null) {
			textFieldfixe = new JTextField();
			textFieldfixe.setColumns(10);
		}
		return textFieldfixe;
	}
	private JLabel getLblemail() {
		if (lblemail == null) {
			lblemail = new JLabel("Email : ");
		}
		return lblemail;
	}
	private JTextField getTextFieldemail() {
		if (textFieldemail == null) {
			textFieldemail = new JTextField();
			textFieldemail.setColumns(10);
		}
		return textFieldemail;
	}
	private JLabel getLbldatenaissance() {
		if (lbldatenaissance == null) {
			lbldatenaissance = new JLabel("Anniversaire :");
		}
		return lbldatenaissance;
	}
	private JTextField getTextFielddatenaissance() {
		if (textFielddatenaissance == null) {
			textFielddatenaissance = new JTextField();
			textFielddatenaissance.setColumns(10);
		}
		return textFielddatenaissance;
	}
	private JLabel getLblentreprise() {
		if (lblentreprise == null) {
			lblentreprise = new JLabel("Entreprise :");
		}
		return lblentreprise;
	}
	private JTextField getTextFieldentreprise() {
		if (textFieldentreprise == null) {
			textFieldentreprise = new JTextField();
			textFieldentreprise.setColumns(10);
		}
		return textFieldentreprise;
	}
	private JPanel getPanelboutons() {
		if (panelboutons == null) {
			panelboutons = new JPanel();
			panelboutons.add(getSupprimer());
			panelboutons.add(getBtnprecedent());
			panelboutons.add(getBtnNouveau());
			panelboutons.add(getBtnsuivant());
			panelboutons.add(getBtnenregistrer());
		}
		return panelboutons;
	}
	private JButton getBtnNouveau() {
		if (btnNouveau == null) {
			btnNouveau = new JButton("Nouveau");
			btnNouveau.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					ContactController.get().create(); 
				}
			});
		}
		return btnNouveau;
	}
	private JButton getBtnprecedent() {
		if (btnprecedent == null) {
			btnprecedent = new JButton("Précédent");
			btnprecedent.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					ContactController.get().precedent(); 
				}
			});
		}
		return btnprecedent;
	}
	private JButton getBtnsuivant() {
		if (btnsuivant == null) {
			btnsuivant = new JButton("Suivant");
			btnsuivant.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					ContactController.get().suivant(); 
				}
			});
		}
		return btnsuivant;
	}
	private JButton getBtnenregistrer() {
		if (btnenregistrer == null) {
			btnenregistrer = new JButton("Enregistrer");
			btnenregistrer.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					ContactController.get().save(); 
					try {
						verfierDate();
					} catch (ParseException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} 
				}
			});
		}
		return btnenregistrer;
	}
	protected void verfierDate() throws ParseException {
		Calendar cal = Calendar.getInstance();
		cal.setLenient(false);
		
		String text = getTextFielddatenaissance().getText();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		java.util.Date textFieldAsDate = null;
		textFieldAsDate = sdf.parse(text);
		cal.setTime(textFieldAsDate);
		try {
			cal.getTime();
		} catch (Exception e) {
			System.out.println("invalid date, please write like 2020-07-14");
		}
		// vérifier format + message d'erreur (2020-06-20)
				// LocalDate.parse(getTextFielddatenaissance().getText())) ;
				// stmt.setDate(11, Date.valueOf((LocalDate)perso.getDatenaissance()));
				// rs.getDate("datenaissance").toLocalDate())
		
	}
	private JButton getSupprimer() {
		if (Supprimer == null) {
			Supprimer = new JButton("Supprimer");
			Supprimer.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					System.out.println(idCourant);
					ContactController.get().delete(idCourant); 				}
			});
		}
		return Supprimer;
	}
	private JMenuBar getMenuBar_1() {
		if (menuBar == null) {
			menuBar = new JMenuBar();
			menuBar.add(getBtncontacts());
			menuBar.add(getBtncarnet());
		}
		return menuBar;
	}
	private JButton getBtncontacts() {
		if (btncontacts == null) {
			btncontacts = new JButton("Contacts");
			btncontacts.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					ContactController.get().fenetreContact(); 
				}
			});
		}
		return btncontacts;
	}
	private JButton getBtncarnet() {
		if (btncarnet == null) {
			btncarnet = new JButton("Carnet");
			btncarnet.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					ContactController.get().fenetreCarnet(); 
				}
			});
		}
		return btncarnet;
	}
	
	/**
	 * Methode pour afficher un contact ! 
	 * @param c
	 */
	public void afficherContact(Contact c) {
		idCourant = c.getIdContact(); 
		System.out.println("id courant :"+ idCourant);
		getTextFieldNom().setText(c.getNom()+"");
		getTextFieldPrenom().setText(c.getPrenom()+"");
		getTextFieldadresse().setText(c.getAdresse()+"");
		getTextFieldComplt().setText(c.getAdresse2()+"");
		getTextFieldcp().setText(c.getCodepostal()+"");
		getTextFieldville().setText(c.getVille()+"");
		getTextFieldportable().setText(c.getPortable()+"");
		getTextFieldfixe().setText(c.getFixe()+"");
		getTextFieldemail().setText(c.getEmail()+"");
	
		if (c.getClass().equals(Perso.class)) {
			Perso perso = (Perso) c; 
			getLblentreprise().setEnabled(false);
			getLbldatenaissance().setEnabled(true);
			getRdbtperso().setSelected(true);
			getRdbtnpro().setSelected(false);
			
			Date dateAnniv = (Date.valueOf((LocalDate)perso.getDatenaissance()));
			DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");  
			String strDate = dateFormat.format(dateAnniv);
			getTextFielddatenaissance().setText(strDate);
						
		} else {
			Pro pro = (Pro) c; 
			getLblentreprise().setEnabled(true);
			getLbldatenaissance().setEnabled(false);
			getRdbtperso().setSelected(false);
			getRdbtnpro().setSelected(true);
			getTextFieldentreprise().setText(pro.getEntreprise());
		}
		
		getTextFieldidcontact().setText(String.valueOf(idCourant));
		getTextFieldCiv().setText(c.getCivilite()+ "");
	}
	
	/**
	 * Methode pour afficher un nouveau contact
	 */
	public void afficherNouveau() {
		Perso p = new Perso("", "", "", null, "", "","", null, null, "", LocalDate.of(1970,01,01)); 
		afficherContact(p); 		
	}
	
	
	
	
	private JLabel getLbltype() {
		if (lbltype == null) {
			lbltype = new JLabel("Type :");
		}
		return lbltype;
	}
	private JPanel getPanelradio() {
		if (panelradio == null) {
			panelradio = new JPanel();
			panelradio.add(getRdbtperso());
			panelradio.add(getRdbtnpro());
		}
		return panelradio;
	}
	private JRadioButton getRdbtnpro() {
		if (rdbtnpro == null) {
			rdbtnpro = new JRadioButton("Contact professionnel");
			rdbtnpro.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					getRdbtperso().setSelected(false);
					getTextFielddatenaissance().setEnabled(false);
					getLbldatenaissance().setEnabled(false);
					getTextFieldentreprise().setEnabled(true);
					getLblentreprise().setEnabled(true);
				}
			});
			rdbtnpro.setSelected(false);
		}
		
		return rdbtnpro;
	}
	private JRadioButton getRdbtperso() {
		if (rdbtperso == null) {
			rdbtperso = new JRadioButton("Contact personnel");
			rdbtperso.setSelected(false);
			rdbtperso.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					getRdbtnpro().setSelected(false);
					getTextFielddatenaissance().setEnabled(true);
					getLbldatenaissance().setEnabled(true);
					getTextFieldentreprise().setEnabled(false);
					getLblentreprise().setEnabled(false);
				}
			});
		}
		
		return rdbtperso;
	}
	public Contact getContact() {
		Contact con = null ; 
		if (getRdbtperso().isSelected()) {
			con = new Perso (
					idCourant,					
					getTextFieldNom().getText(), getTextFieldPrenom().getText(), 
					getTextFieldadresse().getText(), getTextFieldComplt().getText(), getTextFieldcp().getText(), getTextFieldville().getText(), 
					getTextFieldportable().getText(), getTextFieldfixe().getText(), getTextFieldemail().getText(), getTextFieldCiv().getText(),
					LocalDate.parse(getTextFielddatenaissance().getText())
					) ; 
					
		} else {
			con = new Pro(idCourant,  getTextFieldNom().getText(), getTextFieldPrenom().getText(), 
					getTextFieldadresse().getText(), getTextFieldComplt().getText(), getTextFieldcp().getText(), getTextFieldville().getText(), 
					getTextFieldportable().getText(), getTextFieldfixe().getText(), getTextFieldemail().getText(), getTextFieldCiv().getText(),
					getTextFieldentreprise().getText());
		}
		
		return con;
	}
	public void infoErreur(String msg) {
		JOptionPane.showMessageDialog(EcranContacts.this, msg, "", JOptionPane.ERROR_MESSAGE);
		
	}
}
