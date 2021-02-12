package Vue;

import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JToolBar;

import Controleurs.CtrlBas;
import Controleurs.CtrlChercher;
import Controleurs.CtrlDecollage;
import Controleurs.CtrlDroite;
import Controleurs.CtrlFinTour;
import Controleurs.CtrlGauche;
import Controleurs.CtrlHaut;
import Controleurs.CtrlPasserTour;
import Controleurs.CtrlRecupererArtefact;
import Modele.CModele;

/**
 * DEBUT DE LA CLASSE VUECOMMANDES
 * **/

public class VueCommandes extends JToolBar {
// ATTRIBUTS
	private CModele modele;
	private CVue vue;
	
//	CONSTRUCTEUR
	public VueCommandes(CModele modele, CVue vue) {
		// Dimensions utiles
		Dimension dim = new Dimension(50,50);
		Dimension dim2 = new Dimension (130, 50);
		this.modele = modele;
		
		//Initialisation de la Toolbar ainsi que des boutons
		this.setLayout(new FlowLayout(FlowLayout.CENTER));
		JButton boutonHaut = new JButton("^");
		boutonHaut.setPreferredSize(dim);
		JButton boutonBas = new JButton("v");
		boutonBas.setPreferredSize(dim);
		JButton boutonGauche = new JButton("<");
		boutonGauche.setPreferredSize(dim);
		JButton boutonDroite = new JButton(">");
		boutonDroite.setPreferredSize(dim);
		JButton boutonRecupererArtefact = new JButton("Récupérer un artefact");
		boutonRecupererArtefact.setPreferredSize(dim2);
		JButton boutonChercher = new JButton("Chercher une clé");
		boutonChercher.setPreferredSize(dim2);
		JButton finTour = new JButton("Fin de tour");
		finTour.setPreferredSize(dim2);
		JButton passerTour = new JButton("Passer son tour");
		passerTour.setPreferredSize(dim2);
		JButton decollage = new JButton("Decollage");
		decollage.setPreferredSize(dim2);
		
		//Ajout des boutons à la ToolBar
		this.add(boutonHaut);
		this.add(boutonBas);
		this.add(boutonGauche);
		this.add(boutonDroite);
		this.add(boutonRecupererArtefact);
		this.add(boutonChercher);
		this.add(finTour);
		this.add(passerTour);
		this.add(decollage);
		
		//Création des controleurs et association avec les boutons
		CtrlHaut ctrlHaut = new CtrlHaut(this.modele, this.vue);
		boutonHaut.addActionListener(ctrlHaut);
		CtrlBas ctrlBas = new CtrlBas(this.modele, this.vue);
		boutonBas.addActionListener(ctrlBas);
		CtrlGauche ctrlGauche = new CtrlGauche(this.modele, this.vue);
		boutonGauche.addActionListener(ctrlGauche);
		CtrlDroite ctrlDroite = new CtrlDroite(this.modele, this.vue);
		boutonDroite.addActionListener(ctrlDroite);
		CtrlChercher ctrlChercher = new CtrlChercher(this.modele, this.vue);
		boutonChercher.addActionListener(ctrlChercher);
		CtrlRecupererArtefact ctrlRecupererArtefact = new CtrlRecupererArtefact(this.modele, this.vue);
		boutonRecupererArtefact.addActionListener(ctrlRecupererArtefact);
		CtrlPasserTour ctrlPasserTour = new CtrlPasserTour(this.modele, this.vue);
		passerTour.addActionListener(ctrlPasserTour);
		CtrlFinTour ctrlFinTour = new CtrlFinTour(this.modele, this.vue);
		finTour.addActionListener(ctrlFinTour);
		CtrlDecollage ctrlDecollage = new CtrlDecollage(this.modele, this.vue);
		decollage.addActionListener(ctrlDecollage);
	}

}

/**
 * FIN DE LA CLASSE VUECOMMANDES
 * **/
