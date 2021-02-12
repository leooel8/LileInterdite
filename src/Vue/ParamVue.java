package Vue;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.plaf.nimbus.NimbusLookAndFeel;

import Controleurs.CtrlJouer;
import Interfaces.Observer_2;
import Main.Main;
import Modele.Parametres;

/**
 * DEBUT DE LA CLASSE PARAMVUE
 * **/

public class ParamVue{
//	ATTRIBUTS
	private Parametres param;
	private JFrame general;
	private ButtonVue buttonVue;
	private ValVue valVue;
	private Main mainJeu;
	
	
//	CONSTRUCTEUR
	public ParamVue(Parametres param, Main main) {
		this.param = param;
		this.mainJeu = main;
		
		//Création et configuration de la frame
		this.general = new JFrame();
		this.general.setTitle("Paramètrage");
		this.general.setLayout(new BorderLayout());
		this.general.setSize(new Dimension (1600,900));
		
		//Création des différentes vues
		this.buttonVue = new ButtonVue(this.param);
		this.valVue = new ValVue(this.param);
		
		//Ajout et configuration des vues au sein de la frame
		this.general.add(this.buttonVue, BorderLayout.WEST);
		this.buttonVue.setPreferredSize(new Dimension(400,900));
		
		this.general.add(this.valVue, BorderLayout.CENTER);
		this.valVue.setPreferredSize(new Dimension(1200,900));
		
		//Ajout du bouton pour lancer le jeu
		JButton jouer = new JButton("JOUER");
		this.general.add(jouer, BorderLayout.EAST);
		
		//Création du controleur et association avec le bouton
		CtrlJouer ctrlJouer = new CtrlJouer(this);
		jouer.addActionListener(ctrlJouer);
		
		//Dernières configuration de la frame
		this.general.setLocationRelativeTo(null);
		this.general.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.general.setVisible(true);
	}
	
//	METHODES
	
	public void jouer() {
		System.out.println("jouer activé");
		this.general.dispose();
		this.param.setComplet(true);
		
		this.mainJeu.jouer(this.param);
	}
	
}

/**
 * FIN DE LA CLASSE PARAMVUE
 * **/