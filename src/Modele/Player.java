package Modele;

import java.awt.Color;
import java.util.ArrayList;

import Usefull.Coord;
import Usefull.Etat;
import Usefull.TypeCell;

/**
 * DEBUT DE LA CLASSE PLAYER
 * **/

public class Player {
// ATTRIBUTS
	private CModele modele;
	protected String name;
	protected ArrayList<TypeCell> bag;
	protected Coord coord;
	protected ArrayList<TypeCell> artefacts;
	protected Color color;
	protected boolean alive;
//	protected Capacity capacity;
	
//	CONSTRUCTEURS
	public Player(CModele modele, String name, Coord pos, Color c) {
		this.modele = modele;
		this.name = name;
		this.coord = pos;
		this.color = c;
		this.bag = new ArrayList<TypeCell>();
		this.artefacts = new ArrayList<TypeCell>();
		this.alive = true;
	}
	
	public Player(CModele modele, String name, Coord pos) {
		this.modele = modele;
		this.name = name;
		this.coord = pos;
		this.color = Color.BLACK;
		this.bag = new ArrayList<TypeCell>();
		this.artefacts = new ArrayList<TypeCell>();
		this.alive = true;
	}
	
	public Player(CModele modele, Coord pos) {
		this.modele = modele;
		this.name = "NONE";
		this.coord = pos;
		this.color = Color.BLACK;
		this.bag = new ArrayList<TypeCell>();
		this.artefacts = new ArrayList<TypeCell>();
		this.alive = true;
	}
	
//	METHODES
	
	/**
	 * Méthodes d'initialisation
	 * **/
	
	public void addKey(TypeCell type) {
		this.bag.add(type);
	}
	
	public void addArtefacts(TypeCell type) {
		this.artefacts.add(type);
	}
	
	/**
	 * Méthodes 'get' et 'set'
	 * **/
	
	public String toString() {
		return this.name;
	}
	public char[] toChars() {
		char[] res = new char[this.name.length()];
		for(int i = 0; i < this.name.length(); i++) {
			this.name.charAt(i);
		}
		return res;
	}
	
	public Coord getPosition() {
		return this.coord;
	}
	
	public ArrayList<TypeCell> getBag(){
		return this.bag;
	}
	
	public ArrayList<TypeCell> getArtefacts(){
		return this.artefacts;
	}
	
	public boolean isAlive() {
		return this.alive;
	}
	
	public String getName() {
		return this.name;
	}
	
	/**
	 * Méthodes de visualisation
	 * **/
	
	public void showPlayer(int n) {
		System.out.println("Player n°" + n + " : Name : " + this.name);
		System.out.println("              Coordonnées : X = " + this.coord.getX() + " ; Y = " + this.coord.getY());
		System.out.print("              Has keys of : ");
		for(int i = 0; i < this.bag.size(); i++) {
			System.out.print(this.bag.get(i).toString() + ";");
		}
		
		System.out.print("              Has artefacts of : ");
		for(int i = 0; i < this.artefacts.size(); i++) {
			System.out.print(this.artefacts.get(i).toString() + ";");
		}
	}
	
	/**
	 * Méthodes utiles au jeu
	 * **/
	
	public boolean moveUp() {
		if(this.coord.getY() - 1 > 0 && this.modele.getCellule(this.coord.getX(), this.coord.getY() - 1).getEtat() != Etat.Submerge) {
			this.coord.moveYDown();
			return true;
		}
		else {
			return false;
		}
	}
	
	public boolean moveDown() {
		if(this.coord.getY() + 1 <= this.modele.getTaille() && this.modele.getCellule(this.coord.getX(), this.coord.getY() + 1).getEtat() != Etat.Submerge) {
			this.coord.moveYUp();
			return true;
		}
		else {
			return false;
		}
	}
	
	public boolean moveLeft() {
		if(this.coord.getX() - 1 > 0 && this.modele.getCellule(this.coord.getX() - 1, this.coord.getY()).getEtat() != Etat.Submerge) {
			this.coord.moveXDown();
			return true;
		}
		else {
			return false;
		}
	}
	
	public boolean moveRight() {
		if(this.coord.getX() + 1 <= this.modele.getTaille() && this.modele.getCellule(this.coord.getX() + 1, this.coord.getY()).getEtat() != Etat.Submerge) {
			this.coord.moveXUp();
			return true;
		}
		else {
			return false;
		}
	}
	
	public void noyer() {
		this.alive = false;
	}
	
	public boolean equals(Player p) {
		if(this.name == p.getName() && this.getPosition().equals(p.getPosition())) {
			return true;
		}
		else {
			return false;
		}
	}
	
}

/**
 * FIN DE LA CLASSE PLAYER
 * **/