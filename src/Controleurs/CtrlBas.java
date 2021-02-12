package Controleurs;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Modele.CModele;
import Vue.CVue;

public class CtrlBas implements ActionListener{
//	ATTRIBUTS
	CModele modele;
	CVue vue;
	
//	CONSTRUCTEUR
	public CtrlBas(CModele modele, CVue vue) {
		this.vue = vue;
		this.modele = modele;
	}	
//		METHODES
	public void actionPerformed(ActionEvent e) {
		if(!(this.modele.finJeu())) {
			System.out.println("MOVE DOWN ACTIVE");
			this.modele.movePlayerDown();
		}
		else {
			this.vue.disposeAll();
		}
	 	
	}
	
}
