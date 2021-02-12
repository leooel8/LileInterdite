package Main;

import java.awt.Color;
import java.awt.EventQueue;
import java.util.concurrent.TimeUnit;

import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.plaf.nimbus.NimbusLookAndFeel;

import com.mgnt.utils.TimeUtils;

import Modele.CModele;
import Modele.Parametres;
import Vue.CVue;
import Vue.ParamVue;

/**
 * DEBUT DE LA CLASSE MAIN
 * 
 * Cette classe permet, une fois son Main exécuté, de lancer une partie du jeu
 * 
 * **/

public class Main {

//	CONSTRUCTEUR
	
	public Main() {
		
	}
	
//	METHODES
	
	public void jouer(Parametres param) {
		int time = 1;
		//Création du modèle du jeu
		CModele modele = new CModele(param);

		TimeUtils.sleepFor(time, TimeUnit.SECONDS);
		
		//Initialisation du modèle
		modele.init();
		
		TimeUtils.sleepFor(time, TimeUnit.SECONDS);
		
		//Création de la Vue du jeu
		CVue vue = new CVue(modele);
		
		TimeUtils.sleepFor(time, TimeUnit.SECONDS);
		
		//Visualisation utile au débuggage
		modele.showGrid();
		modele.showFullGrid();
		
		TimeUtils.sleepFor(time, TimeUnit.SECONDS);
		
	}

	public static void main(String[] args) {
		EventQueue.invokeLater(() -> {
			
			try {
				UIManager.setLookAndFeel(new NimbusLookAndFeel());
			} catch (UnsupportedLookAndFeelException e) {
				e.printStackTrace();
			}
			Main mainJeu = new Main();
			
			Parametres param = new Parametres();
			ParamVue paramVue = new ParamVue(param, mainJeu);
			
			

		});
	}
	
}

/**
 * FIN DE LA CLASSE MAIN
 * **/