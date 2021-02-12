package Controleurs;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Modele.CModele;
import Vue.CVue;

public class CtrlFinTour implements ActionListener{
//	ATTRIBUTS
	CModele modele;
	CVue vue;
	
//	CONSTRUCTEUR
	public CtrlFinTour(CModele modele, CVue vue) {
		this.modele = modele;
		this.vue = vue;
	}	
//		METHODES
	public void actionPerformed(ActionEvent e) {
		if(!(this.modele.finJeu())) {
			System.out.println("FIN DE TOUR ACTIVE");
		 	this.modele.finTour();
		}
		else {
			this.vue.disposeAll();
		}
	}
	
}
