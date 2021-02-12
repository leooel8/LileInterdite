package Controleurs;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Modele.CModele;
import Vue.CVue;

public class CtrlHaut implements ActionListener{
//	ATTRIBUTS
	CModele modele;
	CVue vue;
	
//	CONSTRUCTEUR
	public CtrlHaut(CModele modele, CVue vue) {
		this.modele = modele;
		this.vue = vue;
	}	
//		METHODES
	public void actionPerformed(ActionEvent e) {
		if(!(this.modele.finJeu())) {
			System.out.println("MOVE UP ACTIVE");
			this.modele.movePlayerUp();
		}
		else {
			this.vue.disposeAll();
		}
	}
}
