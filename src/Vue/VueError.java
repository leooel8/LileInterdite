package Vue;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JPanel;

import Interfaces.Observer;
import Modele.CModele;
import Usefull.TypeCell;

/**
 * DEBUT DE LA CLASSE VUEERROR
 * **/

public class VueError extends JPanel implements Observer{
//	ATTRIBUTS
	private CModele modele;
	
//	CONSTRUCTEUR
	public VueError(CModele modele) {
		this.modele = modele;
		Dimension dim = new Dimension(600, 990);
		this.modele.addObserver(this);
		this.setPreferredSize(dim);
	}

//	METHODES
	public void update() {
		if(!(this.modele.getErreur().getErrorNum() == 20)) {
			repaint();
		}
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		//Dessin du titre de la zone d'erreur
		g.setColor(Color.BLACK);
		g.setFont(new Font("Courier New", Font.BOLD, 20));
		g.drawString("ZONE D'AFFICHAGE DES ERREURS", 20, 20);
		g.setFont(new Font("Courier New", Font.ITALIC, 15));
		
		//Dessin de l'erreur (Déplacement impossible etc), ou d'une information utile aux joueurs
		String[] erreur = this.modele.getErreur().getErrorName().split("/br");
		for(int i = 0; i < erreur.length; i++) {
			g.drawString(erreur[i], 30, (i + 2) * 20);
		}
		
		//Affichage des clées et artefacts que possède le joueur courant
		g.drawString("Vous possédez la(les) clé(s) suivante(s) : ", 30 ,200);
		ArrayList<TypeCell> currentBag = this.modele.getCurrentPlayer().getBag();
		ArrayList<TypeCell> currentArtefacts = this.modele.getCurrentPlayer().getArtefacts();
		for(int i = 0; i < currentBag.size(); i++) {
			g.drawString("Clé " + currentBag.get(i).toString(), 50, 200 + ((1 + i) *20));
		}
		g.drawString("Vous possédez l'(les)artefact(s) suivant(s) : ", 30 ,400 + (currentBag.size() * 20));
		for(int i = 0; i < currentArtefacts.size(); i++) {
			g.drawString("Artefact" + currentArtefacts.get(i).toString(), 50, 400 + (currentBag.size() * 20) + ((2 + i) *20));
		}
		
		//Dessin du titre de la zone d'assechage
		g.setColor(Color.BLACK);
		g.drawString("ZONE DE CHOIX D'ASSECHAGE", 200, 750);
	}
	
}

/**
 * FIN DE LA CLASSE VUEERROR
 * **/
