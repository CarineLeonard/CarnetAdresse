package fr.eni.carnetadresse.ihm.ecranCarnet;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import fr.eni.carnetadresse.ihm.ContactController;

import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JMenuBar;
import javax.swing.JButton;

public class EcranCarnet extends JFrame {

	private JPanel contentPane;
	private JScrollBar scrollBar;
	private JTable tableCarnet;
	private JMenuBar menuBar;
	private JButton btnContacts;
	private JButton btnCarnet;
	
	private CarnetModele modele;

	/**
	 * Create the frame.
	 */
	public EcranCarnet() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1500, 500);
		setJMenuBar(getMenuBar_1());
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new GridLayout(1, 0));
		
		TableCarnet tblCarnet = new TableCarnet(ContactController.get().getCarnet()); 
		JScrollPane scrollPane = new JScrollPane(tblCarnet);
		contentPane.add(scrollPane);
		
		setContentPane(contentPane);
	}
	
	private JScrollBar getScrollBar() {
		if (scrollBar == null) {
			scrollBar = new JScrollBar();
		}
		return scrollBar;
	}
	private JTable getTableCarnet() {
		if (tableCarnet == null) {
			tableCarnet = new JTable(modele);
		}
		return tableCarnet;
	}
	private JMenuBar getMenuBar_1() {
		if (menuBar == null) {
			menuBar = new JMenuBar();
			menuBar.add(getBtnContacts());
			menuBar.add(getBtnCarnet());
		}
		return menuBar;
	}
	private JButton getBtnContacts() {
		if (btnContacts == null) {
			btnContacts = new JButton("Contacts");
		
			btnContacts.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					ContactController.get().fenetreContact(); 
				}
			});
		}
		return btnContacts;
	}
	private JButton getBtnCarnet() {
		if (btnCarnet == null) {
			btnCarnet = new JButton("Carnet");
			btnCarnet.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					ContactController.get().fenetreCarnet(); 
				}
			});
		}
		return btnCarnet;
	}
}
