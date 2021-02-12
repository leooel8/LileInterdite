package Controleurs;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Modele.CModele;
import Usefull.Direction;
import Vue.CVue;

public class CtrlAssecheDroite implements ActionListener{
//	ATTRIBUTS
	CModele modele;
	CVue vue;
	
//	CONSTRUCTEUR
	public CtrlAssecheDroite(CModele modele, CVue vue) {
		this.modele = modele;
		this.vue = vue;
	}	
//		METHODES
	public void actionPerformed(ActionEvent e) {
		if(!(this.modele.finJeu())) {
			this.modele.assecher(Direction.Droite);
			System.out.println("ASSECHE DROITE ACTIVE");
		}
		else {
			this.vue.disposeAll();
		}
	}
}
