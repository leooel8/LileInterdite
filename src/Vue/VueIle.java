package Vue;

import java.awt.*;

import javax.swing.*;

import Interfaces.Observer;
import Modele.CModele;
import Modele.Cellule;
import Modele.Player;
import Usefull.Etat;
import Usefull.TypeCell;

public class VueIle extends JPanel implements Observer {
//	ATTRIBUTS
	private CModele modele;
	private  int TAILLE = 100;
	
// CONSTRUCTEUR
	public VueIle(CModele modele) {
		this.modele = modele;
		this.setLayout(new FlowLayout(FlowLayout.CENTER));
		this.modele.addObserver(this);
		Dimension dim = new Dimension(TAILLE * this.modele.getTaille(), 
				TAILLE * this.modele.getTaille() + 500);
		this.setPreferredSize(dim);
	}

//	METHODES
	
	public void update() {
		if(!(this.modele.getErreur().getErrorNum() == 20)) {
			System.out.println("repaint!!");
			System.out.println("TEST FIN  : ETAPE ->" + this.modele.getTour().getEtape() + "; CHOIX ->" + this.modele.getTour().getChoix());
			this.modele.showFullGrid();
			repaint();
		}
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		//Appelle la méthode paint() pour chaques cases
		for(int i = 1; i <= this.modele.getTaille(); i++) {
			for(int j = 1; j <= this.modele.getTaille(); j++) {
				System.out.println("I = " + i + "; J = " + j + ". Etat : " + this.modele.getCellule(i ,j).getEtat().toString());
				paint(g, modele.getCellule(i, j), (i) * this.TAILLE, (j - 1) * this.TAILLE);
				paintWater(g, modele.getCellule(i, j), i, j);
			}
		}
	}
	
	private void paint(Graphics g, Cellule c, int x, int y) {
		//Cas où la case contient un artefact
		Color BROWN = new Color(210,105,30);
		if(c.getType() == TypeCell.Feu) {
			g.setColor(Color.RED);
		}
		else if(c.getType() == TypeCell.Air) {
			g.setColor(Color.LIGHT_GRAY);
		}
		else if(c.getType() == TypeCell.Eau) {
			g.setColor(Color.BLUE);
		}
		else if(c.getType() == TypeCell.Terre) {
			g.setColor(BROWN);;
		}
		else {
			g.setColor(Color.WHITE);
		}
		
		g.fillRect(x + 4, y + 4, this.TAILLE - 4, this.TAILLE - 4);
		
		//Cas où la case contient l'Hélico
		
		if(c.getType() == TypeCell.Helico) {
			g.setColor(BROWN);
			g.drawLine(x + 20, y + 20, x + this.TAILLE - 20, y + this.TAILLE - 20);
			g.drawLine(x + this.TAILLE - 20, y + 20, x + 20, y + this.TAILLE - 20);
		}
		
		//Cas où la case est occupée
		
		if(c.isOccupied()) {
			if(c.getPlayer().isAlive()) {
				g.setColor(Color.BLACK);
				if(c.getPlayer().equals(this.modele.getCurrentPlayer())) {
					g.setColor(Color.GRAY);
				}
				System.out.println("Coordonnées player: X = " + c.getPosX() + " Y = " + c.getPosY());
				g.fillOval(x + (this.TAILLE/2)/2 , y + (this.TAILLE/2)/2, (this.TAILLE/2), (this.TAILLE/2));
				Player use1 = c.getPlayer();
				g.drawChars(use1.toChars(), 0, use1.toChars().length,(x + (this.TAILLE/2)), (y + (this.TAILLE/2) ));
			}
		}
	}
	
	//Cette méthode permet de coloriser les cases innondées ou submergées
	private void paintWater(Graphics g, Cellule c, int x, int y) {
		if(this.modele.getCellule(x, y).getEtat() == Etat.Innonde) {
			g.setColor(Color.CYAN);
			g.drawRect((x) * this.TAILLE + 2, (y - 1) * this.TAILLE + 2, this.TAILLE - 2, this.TAILLE - 2);
			g.drawRect((x) * this.TAILLE + 3, (y - 1) * this.TAILLE + 3, this.TAILLE - 4, this.TAILLE - 4);
			g.drawRect((x) * this.TAILLE + 4, (y - 1) * this.TAILLE + 4, this.TAILLE - 6, this.TAILLE - 6);
			g.drawRect((x) * this.TAILLE + 5, (y - 1) * this.TAILLE + 5, this.TAILLE - 8, this.TAILLE - 8);
		}
		else if(this.modele.getCellule(x, y).getEtat() == Etat.Submerge ) {
			g.setColor(Color.BLACK);
			g.drawRect((x) * this.TAILLE + 2, (y - 1) * this.TAILLE + 2, this.TAILLE - 2, this.TAILLE - 2);
			g.drawRect((x) * this.TAILLE + 3, (y - 1) * this.TAILLE + 3, this.TAILLE - 4, this.TAILLE - 4);
			g.drawRect((x) * this.TAILLE + 4, (y - 1) * this.TAILLE + 4, this.TAILLE - 6, this.TAILLE - 6);
			g.drawRect((x) * this.TAILLE + 5, (y - 1) * this.TAILLE + 5, this.TAILLE - 8, this.TAILLE - 8);
		}
	}
}
