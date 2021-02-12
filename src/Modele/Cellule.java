package Modele;

import java.util.ArrayList;

import Usefull.Coord;
import Usefull.Etat;
import Usefull.TypeCell;

/**
 * DEBUT DE LA CLASSE CELLULE
 * **/

public class Cellule {
//	ATTRIBUTS
	private CModele modele;
	protected TypeCell type;
	protected Etat etat;
	private Coord coord;
	protected boolean occupied;
	protected ArrayList<Player> player;
	
//	CONSTRUCTEUR
	public Cellule(CModele modele, int x, int y) {
		this.modele = modele;
		this.coord = new Coord(x,y);
		this.type = TypeCell.Normale;
		this.etat = Etat.Emerge;
		this.occupied = false;
		this.player = new ArrayList<Player>();
	}
	
//	METHODES
	
	/**
	 * Méthodes d'initialisation
	 * **/
	
	public void init() {
		System.out.println("TEST");
		int index = 0;
		index = (int)(Math.random() * this.modele.typeCellTab.size());
		this.type = this.modele.typeCellTab.get(index);
		this.modele.typeCellTab.remove(index);
	}
	
	/**
	 * Méthodes 'get' et 'set'
	 * **/
	
	public int getPosX() {
		return this.coord.getX();
	}
	
	public int getPosY() {
		return this.coord.getY();
	}
	
	public Coord getPos() {
		return this.coord;
	}
	
	public TypeCell getType() {
		return this.type;
	}
	
	public void setType(TypeCell type) {
		this.type = type;
	}
	
	public Etat getEtat() {
		return this.etat;
	}
	
	public void setEtat(Etat etat) {
		this.etat = etat;
	}
	
	public boolean isOccupied() {
		return this.occupied;
	}
	
	public void getOccupied(boolean b) {
		this.occupied = b;
	}
	
	public void setPlayer(Player player) {
		this.player.add(player);
	}
	
	public Player getPlayer() {
		return this.player.get(0);
	}
	
	public ArrayList<Player> getPlayers(){
		return this.player;
	}
	
	public void removePlayer() {
		this.player.remove(this.modele.getCurrentPlayer());
		if(this.player.size() == 0) {
			this.getOccupied(false);
		}
	}
	
	/**
	 * Méthodes utiles au jeu
	 * **/
	
	public Etat innonde() {
		if(this.etat == Etat.Emerge) {
			this.etat = Etat.Innonde;
			return Etat.Innonde;
		}
		else {
			this.etat = Etat.Submerge;
			return Etat.Submerge;
		}
		
	}
	
/**
 * FIN DE LA CLASSE CELLULE
 * **/
}
