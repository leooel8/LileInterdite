package Vue;
import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JFrame;

import Interfaces.Observer;
import Modele.CModele;

public class CVue {
//	ATTRIBUTS
	private CModele modele;
	private JFrame general;
	private JFrame errors;
	private VueIle ile;
	private VueCommandes commandes;
	private VueInfos infos;
	private VueError vueError;
	private VueAssechage vueAssechage;
	
//	CONSTRUCTEUR
	public CVue(CModele modele) {
		this.modele = modele;
		
		//Création et initialisation des différentes frames 'general' et 'errors'
		this.general = new JFrame();
		this.general.setTitle("L'ile interdite");
		this.general.setLayout(new BorderLayout());
		this.general.setSize(new Dimension (1600, 900));
		
		this.errors = new JFrame();
		this.errors.setTitle("Panneau d'erreurs et d'assechage");
		this.errors.setLayout(new BorderLayout());
		this.errors.setSize(new Dimension(1000, 900));
		
		//Création et initialisation des différentes vues
		
		this.ile = new VueIle(modele);
		
		this.vueAssechage = new VueAssechage(modele, this);
		this.vueAssechage.setPreferredSize(new Dimension(600, 100));
		
		this.vueError = new VueError(modele);
		
		
		this.commandes = new VueCommandes(modele, this);
		this.commandes.setPreferredSize(new Dimension(1000, 100));
		
		this.infos = new VueInfos(modele);
		this.infos.setPreferredSize(new Dimension(1000, 100));
		
		//Ajouts des vues ausein des différentes frames
		this.general.add(this.ile,BorderLayout.CENTER);
		this.general.add(this.commandes, BorderLayout.SOUTH);
		this.general.add(this.infos, BorderLayout.NORTH);
		
		this.errors.add(this.vueError,BorderLayout.CENTER);
		this.errors.add(this.vueAssechage,BorderLayout.SOUTH);

		//Configuration des frames (modalitées de fermeture, d'ajouts de composants...)
		this.general.pack();
		this.general.setLocationRelativeTo(null);
		this.general.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.general.setVisible(true);
		
		this.errors.pack();
		this.errors.setLocationRelativeTo(null);
		this.errors.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.errors.setVisible(true);
		

	}

//	METHODES
	
	// Date: 04/06
	//METHODE NE FONCTIONNE PAS 
	//SENSEE FERMER LES FRAMES
	//APPELLEE PAR LES CONTROLEURS
	
	public void disposeAll() {
		this.general.dispose();
		this.errors.dispose();
		System.out.println("EXTINCTION DES FRAMES!");
	}
	
}
