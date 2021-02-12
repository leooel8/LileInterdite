package Modele;

import java.util.ArrayList;

import Interfaces.Observable_2;

/**
 * DEBUT DE LA CLASSE PARAMETRES
 * **/

public class Parametres extends Observable_2{
//	ATTRIBUTS
	private int difficulte;
	private int taille;
	private int nbrPlayer;
	private boolean complet;
	
//	CONSTRUCTEUR
	public Parametres(){
		this.complet = false;
		this.difficulte = 1;
		this.taille = 6;
		this.nbrPlayer = 2;
	}
	
//	METHODES
	
	/**
	 * Méthodes 'Difficulte'
	 * **/
	
	public void upDifficulte() {
		if(this.difficulte >= 0 && this.difficulte < 3) {
			this.difficulte++;
			this.notifyObservers_2();
		}
	}
	
	public void downDifficulte() {
		if(this.difficulte > 1 && this.difficulte <= 3) {
			this.difficulte--;
			this.notifyObservers_2();
		}
	}
	
	public int getDifficulte() {
		return this.difficulte;
	}
	
	/**
	 * Méthodes 'Taille'
	 * **/
	
	public void upTaille() {
		if(this.taille >= 5 && this.taille < 8) {
			this.taille++;		
			this.notifyObservers_2();
		}
	}
	
	public void downTaille() {
		if(this.taille > 5 && this.taille <= 8) {
			this.taille--;	
			this.notifyObservers_2();
		}
	}
	
	public int getTaille() {
		return this.taille;
	}
	
	/**
	 * Méthodes 'nbrPlayer'
	 * **/
	
	public void upNbrPlayer() {
		System.out.println("IN: upNbrPlayer 1");
		if(this.nbrPlayer >= 2 && this.nbrPlayer < 4) {
			System.out.println("IN: upNbrPlayer 2");
			this.nbrPlayer++;	
			System.out.println("IN: upNbrPlayer -> upNbrPlayer++ DONE");
			this.notifyObservers_2();
		}
	}
	
	public void downNbrPlayer() {
		if(this.nbrPlayer > 2 && this.nbrPlayer <= 4) {
			this.nbrPlayer--;
			this.notifyObservers_2();
		}
	}
	
	public int getNbrPlayer() {
		return this.nbrPlayer;
	}
	
	/**
	 * Méthodes 'Complet'
	 * **/
	public boolean getComplet() {
		return this.complet;
	}
	
	public void setComplet(boolean use1) {
		this.complet = use1;
	}

}

/**
 * FIN DE LA CLASSE PARAMETRES
 * **/