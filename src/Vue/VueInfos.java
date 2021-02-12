package Vue;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.util.ArrayList;

import javax.swing.JLabel;

import Interfaces.Observer;
import Modele.CModele;
import Modele.Player;
import Usefull.TypeCell;


/**
 * DEBUT DE LA VUE INFOS
 * **/

public class VueInfos extends JLabel implements Observer{
// ATTRIBUTS
	CModele modele;
	private  int TAILLE = 100;
	
//	CONSTRUCTEUR
	public VueInfos(CModele modele) {
		this.modele = modele;
		modele.addObserver(this);
		Dimension dim = new Dimension(1600, 200);
		this.setPreferredSize(dim);
	}

	public void update() {
		if(!(this.modele.getErreur().getErrorNum() == 20)) {
			repaint();			
		}
	}
	
	//Cette méthode est appellée par repaint() pour décrir les infos actuelles du jeu (joueur courant etc)
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.setColor(Color.BLACK);
		g.setFont(new Font("Courier New", Font.BOLD, 15));
		g.drawString("ZONE INFOS", 20, 20);
		Player currentPlayer = this.modele.getCurrentPlayer();
		g.drawString(currentPlayer.toString(), 200, 20);
	}
	
}

/**
 * FIN DE LA CLASSE VUEINFOS
 * **/