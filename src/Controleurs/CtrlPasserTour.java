package Controleurs;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Modele.CModele;
import Vue.CVue;

public class CtrlPasserTour implements ActionListener{
//	ATTRIBUTS
	CModele modele;
	CVue vue;
	
//	CONSTRUCTEUR
	public CtrlPasserTour(CModele modele, CVue vue) {
		this.modele = modele;
		this.vue = vue;
	}	
//		METHODES
	public void actionPerformed(ActionEvent e) {
		if(!(this.modele.finJeu())) {
			System.out.println("PASSER LE TOUR ACTIVE");
			this.modele.passerTour();
		}
		else {
			this.vue.disposeAll();
		}
	}
}
