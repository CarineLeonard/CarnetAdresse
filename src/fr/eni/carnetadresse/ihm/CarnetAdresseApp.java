package fr.eni.carnetadresse.ihm;

import javax.swing.SwingUtilities;

public class CarnetAdresseApp {
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			
			@Override
			public void run() {
				ContactController.get().startApp(); 
								
				
			}
		});
	}
}
