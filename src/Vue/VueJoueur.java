package Vue;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.JPanel;

import Interfaces.Observer_2;
import Modele.Parametres;

/**
 * DEBUT DE LA CLASSE VUEJOUEUR
 * **/

public class VueJoueur extends JPanel implements Observer_2{
//	ATTRIBUTS
	private Parametres param;
	
//	CONSTRUCTEUR
	public VueJoueur(Parametres param) {
		this.param = param;
		this.param.addObserver_2(this);
	}
	
//	METHODES

	@Override
	public void update() {
		repaint();
		
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.setColor(Color.BLACK);
		g.setFont(new Font("Courier New", Font.BOLD, 20));
		
		//Affichage de la zone de choix du Nombre de joueur
		g.drawString("NOMBRE DE JOUEURS ", 20, 20);
		String use1 = "" + this.param.getNbrPlayer();
		g.drawString(use1, 900, 20);
	}

}

/**
 * DEBUT DE LA CLASSE VUEJOUEUR
 * **/