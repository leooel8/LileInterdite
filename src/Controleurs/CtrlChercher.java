package Controleurs;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Modele.CModele;
import Vue.CVue;

public class CtrlChercher implements ActionListener{
//	ATTRIBUTS
	CModele modele;
	CVue vue;
	
//	CONSTRUCTEUR
	public CtrlChercher(CModele modele, CVue vue) {
		this.modele = modele;
		this.vue = vue;
	}	
//		METHODES
	public void actionPerformed(ActionEvent e) {
		if(!(this.modele.finJeu())) {
			System.out.println("CHERCHER ACTIVE");
		 	this.modele.chercherCle();
		}
		else {
			this.vue .disposeAll();
		}
	}
	
}
