package Controleurs;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Modele.CModele;
import Vue.CVue;

public class CtrlAssecher implements ActionListener{
//	ATTRIBUTS
	CModele modele;
	CVue vue;
	
//	CONSTRUCTEUR
	public CtrlAssecher(CModele modele, CVue vue) {
		this.modele = modele;
		this.vue = vue;
	}	
//		METHODES
	public void actionPerformed(ActionEvent e) {
	 	System.out.println("ASSECHER ACTIVE");
	}
	
}
