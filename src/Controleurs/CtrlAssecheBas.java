package Controleurs;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Modele.CModele;
import Usefull.Direction;
import Vue.CVue;

public class CtrlAssecheBas implements ActionListener{
//	ATTRIBUTS
	CModele modele;
	CVue vue;
	
//	CONSTRUCTEUR
	public CtrlAssecheBas(CModele modele, CVue vue) {
		this.modele = modele;
		this.vue = vue;
	}	
//		METHODES
	public void actionPerformed(ActionEvent e) {
		if(!(this.modele.finJeu())) {
			this.modele.assecher(Direction.Bas);
			System.out.println("ASSECHE BAS ACTIVE");
		}
		else {
			this.vue.disposeAll();
		}
	}
}
