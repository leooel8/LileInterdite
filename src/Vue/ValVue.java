package Vue;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JPanel;

import Interfaces.Observer_2;
import Modele.Parametres;

/**
 * DEBUT DE LA CLASSE VALVUE
 * **/

public class ValVue extends JPanel{
//	ATTRIBUTS
	private Parametres param;
	private VueJoueur vueJoueur;
	private VueDiff vueDiff; 
	private VueTaille vueTaille;
	
//	CONSTRUCTEUR
	public ValVue(Parametres param) {
		this.param = param;
		
		this.setLayout(new BorderLayout());
		
		Dimension dim = new Dimension (1200,300);
		
		//Création, ajout et configuration des trois différentes zones de choix des paramètres du jeu
		VueJoueur pan_1 = new VueJoueur(param);
		this.add(pan_1, BorderLayout.NORTH);
		pan_1.setPreferredSize(dim);
		
		VueDiff pan_2 = new VueDiff(param);
		this.add(pan_2, BorderLayout.CENTER);
		pan_2.setPreferredSize(dim);
		
		VueTaille pan_3 = new VueTaille(param);
		this.add(pan_3, BorderLayout.SOUTH);
		pan_3.setPreferredSize(dim);
	}
	
}

/**
 * DEBUT DE LA CLASSE VALVUE
 * **/