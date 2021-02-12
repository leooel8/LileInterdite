package Vue;

import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JToolBar;

import Controleurs.CtrlAssecheBas;
import Controleurs.CtrlAssecheDroite;
import Controleurs.CtrlAssecheGauche;
import Controleurs.CtrlAssecheHaut;
import Controleurs.CtrlAssecheHere;
import Modele.CModele;

/**
 * DEBUT DE LA CLASSE VUEASSECHAGE
 * **/

public class VueAssechage extends JToolBar{
// ATTRIBUTS
	protected CModele modele;
	private CVue vue;
	
//	CONSTRUCTEUR
	public VueAssechage (CModele modele, CVue vue) {
		//Dimension utile
		Dimension dim = new Dimension(100,50);
		
		this.modele = modele;
		this.vue = vue;
		
		this.setLayout(new FlowLayout(FlowLayout.CENTER));
		
		//Création des boutons et configuration de leurs tailles
		JButton assecheHere = new JButton("o");
		assecheHere.setPreferredSize(dim);
		JButton assecheHaut = new JButton("^");
		assecheHaut.setPreferredSize(dim);
		JButton assecheBas = new JButton("v");
		assecheBas.setPreferredSize(dim);
		JButton assecheGauche = new JButton("<");
		assecheGauche.setPreferredSize(dim);
		JButton assecheDroite = new JButton(">");
		assecheDroite.setPreferredSize(dim);
		
		//Ajout des boutons à la ToolBar
		this.add(assecheHaut);
		this.add(assecheBas);
		this.add(assecheGauche);
		this.add(assecheDroite);
		this.add(assecheHere);
		
		//Création des controleurs et association avec les boutons
		CtrlAssecheHaut ctrlAssecheHaut = new CtrlAssecheHaut(this.modele, this.vue);
		assecheHaut.addActionListener(ctrlAssecheHaut);
		CtrlAssecheBas ctrlAssecheBas = new CtrlAssecheBas(this.modele, this.vue);
		assecheBas.addActionListener(ctrlAssecheBas);
		CtrlAssecheGauche ctrlAssecheGauche = new CtrlAssecheGauche(this.modele, this.vue);
		assecheGauche.addActionListener(ctrlAssecheGauche);
		CtrlAssecheDroite ctrlAssecheDroite = new CtrlAssecheDroite(this.modele, this.vue);
		assecheDroite.addActionListener(ctrlAssecheDroite);
		CtrlAssecheHere ctrlAssecheHere = new CtrlAssecheHere(this.modele, this.vue);
		assecheHere.addActionListener(ctrlAssecheHere);
	}
	
}

/**
 * FIN DE LA CLASSE VUEASSECHAGE
 * **/