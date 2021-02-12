package Modele;

import java.awt.Color;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import com.mgnt.utils.TimeUtils;

import Interfaces.Observable;
import Usefull.Coord;
import Usefull.Direction;
import Usefull.Etat;
import Usefull.TypeCell;

/**
 * DEBUT DE LA CLASSE CMODELE
 * **/

public class CModele extends Observable{
//	ATTRIBUTS
	private Parametres parametres;
	public int TAILLE;
	private Cellule[][] cellules;
	public ArrayList<TypeCell> typeCellTab = new ArrayList<TypeCell>();
	protected ArrayList<Player> players;
	protected int currentPlayerIndex;
	protected Tour tour;
	protected Erreur erreur;
	protected ArrayList<TypeCell> keyArray = new ArrayList<TypeCell>();
	private int keyChance = 0;
	private boolean finJeu;
	
//	CONSTRUCTEUR
	public CModele(Parametres param) {
		this.parametres = param;
		this.TAILLE = this.parametres.getTaille();
		cellules = new Cellule[TAILLE + 2][TAILLE + 2];
		for(int i = 0; i < TAILLE + 2; i++) {
			for(int j = 0; j < TAILLE + 2; j++) {
				cellules[i][j] = new Cellule(this, i, j);
			}
		}
		this.currentPlayerIndex = 0;
		this.players = new ArrayList<Player>();
		for(int i = 0; i < this.parametres.getNbrPlayer(); i++) {
			String name = "Player " + (i + 1);
			this.addPlayer(name, Color.BLACK);
		}
		
		if(this.parametres.getDifficulte() == 1) {
			this.keyChance = 80;
		}
		else if(this.parametres.getDifficulte() == 2) {
			this.keyChance = 50;
		}
		else if(this.parametres.getDifficulte() == 3) {
			this.keyChance = 30;
		}
		
		this.tour = new Tour();
		this.erreur = new Erreur();
		this.keyArray = creatTab();
		this.finJeu = false;
	}
	
//	METHODES
	
	/**
	 * Méthodes d'initialisation
	 * **/
	public void init() {
		this.createTypeCellTab();
		int use1 = 0;
		for(int i = 1; i <= TAILLE; i++) {
			for(int j = 1; j <= TAILLE; j++) {
				System.out.println("Init " + use1);
				cellules[i][j].init();
				use1++;
			}
		}
	}
	
	public void createTypeCellTab() {
		this.typeCellTab.add(TypeCell.Feu);
		this.typeCellTab.add(TypeCell.Air);
		this.typeCellTab.add(TypeCell.Terre);
		this.typeCellTab.add(TypeCell.Eau);
		this.typeCellTab.add(TypeCell.Helico);
		for(int i = 0; i < (this.TAILLE * this.TAILLE ) - 5; i++){
			this.typeCellTab.add(TypeCell.Normale);
		}
	}
	
	public void addPlayer(String name, Color color) {
		boolean ok = false;
		int posX = 0;
		int posY = 0;
		while(!ok) {
			posX = (int)(Math.random() * (this.TAILLE));
			posY = (int)(Math.random() * (this.TAILLE));
			posX++;
			posY++;
			
			if(!(this.cellules[posX][posY].isOccupied())) {
			TypeCell use1 = this.getCellule(posX, posY).getType();
				if(use1 != TypeCell.Air && use1 != TypeCell.Eau && use1 != TypeCell.Feu && use1 != TypeCell.Terre) {
					if(this.players.size() < 4) {
						Coord coord = new Coord(posX, posY);
						Player player = new Player(this, name, coord, color);
						this.players.add(player);
						ok = true;
						System.out.println("JOUEUR '" + name + "' AJOUTE : X = " + posX + "; Y = " + posY);
						this.cellules[posX][posY].getOccupied(true);
						this.cellules[posX][posY].setPlayer(player);
					}
					else {
						System.out.println("TROP DE JOUEURS, LE JOUEUR '" + name + "' NE PEUT ETRE AJOUTE");
					}
				}
			}
		}
	}
	
	public ArrayList<TypeCell> creatTab(){
		ArrayList<TypeCell> res = new ArrayList<TypeCell>();
		res.add(TypeCell.Air);
		res.add(TypeCell.Feu);
		res.add(TypeCell.Terre);
		res.add(TypeCell.Eau);
		return res;
	}
	
	/**
	 * Méthodes 'get'
	 * **/
	
	public int getTaille() {
		return this.TAILLE;
	}
	
	public Cellule getCellule(int i, int j) {
		return this.cellules[i][j];
	}
	
	public Erreur getErreur() {
		return this.erreur;
	}
	
	public ArrayList<Player> getPlayerTab(){
		return this.players;
	}
	
	public Player getCurrentPlayer() {
		return this.players.get(this.currentPlayerIndex);
	}
	
	public Tour getTour() {
		return this.tour;
	}
	
	public boolean getFinJeu() {
		return this.finJeu;
	}
	
	
	
	/**
	 * Méthodes de visualisation
	 * **/
	
	public void showTypeCellTab() {
		System.out.println("VUE DU TABLEAU");
		for(int i = 0; i < this.typeCellTab.size(); i++) {
			System.out.print("Case : " + i + " -> ");
			System.out.println(this.typeCellTab.get(i).toString());
		}
		System.out.println("FIN DE LA VUE");
	}
	
	public void showFullGrid() {
		for(int i = 0; i < this.cellules.length; i++) {
			System.out.println("================================================================================================================");
			for(int j = 0; j < this.cellules.length; j++) {
				System.out.print("|| Case : [" + i + "][" + j + "] ->"  + this.cellules[i][j].getEtat().toString() + "||");
			}
			System.out.println("");
		}
		System.out.println("================================================================================================================");
	}
	
	public void showGrid() {
		for(int i = 1; i <= this.TAILLE; i++) {
			System.out.println("================================================================================================================");
			for(int j = 1; j <= this.TAILLE; j++) {
				System.out.print("|| Case : [" + i + "][" + j + "] ->"  + this.cellules[i][j].getType().toString() + "||");
			}
			System.out.println("");
		}
		System.out.println("================================================================================================================");
	}
	
	public void showStates() {
		for(int i = 1; i <= this.TAILLE; i++) {
			System.out.println("================================================================================================================");
			for(int j = 1; j <= this.TAILLE; j++) {
				System.out.print("|| Case : [" + i + "][" + j + "] ->"  + this.cellules[i][j].getEtat().toString() + "||");
			}
			System.out.println("");
		}
		System.out.println("================================================================================================================");
	}
	
	public void showPlayers() {
		for(int i = 0; i < this.getPlayerTab().size(); i++) {
			Player current = this.players.get(i);
			System.out.println("Player " + (i + 1) + " -> X = " + current.getPosition().getX() + "; Y = " + current.getPosition().getY());
		}
	}

	
	/**
	 * Méthodes utiles au jeu
	 * **/
	
	public void innondeCases() {
		int posX = 0;
		int posY = 0;
		
		Coord use1 = new Coord(0, 0);
		Coord use2 = new Coord(0, 0);
		Coord use3 = new Coord(0, 0);
		for(int i = 0; i < 3; i++) {
			posX = (int)(Math.random() * this.TAILLE);
			posY = (int)(Math.random() * this.TAILLE);
			posX++;
			posY++;
			if(i == 0) {
				use1 = new Coord(posX, posY);
				if(this.cellules[posX][posY].innonde() == Etat.Submerge && this.cellules[posX][posY].isOccupied()) {
					this.cellules[posX][posY].getPlayer().noyer();
					System.out.println(this.cellules[posX][posY].getPlayer().toString() + " est mort noyé!");
				}
			}
			if(i == 1) {
				use2 = new Coord(posX, posY);
				if(use2.equals(use1)) {
					i--;
				}
				else {
					if(this.cellules[posX][posY].innonde() == Etat.Submerge && this.cellules[posX][posY].isOccupied()) {
						this.cellules[posX][posY].getPlayer().noyer();
						System.out.println(this.cellules[posX][posY].getPlayer().toString() + " est mort noyé!");
					}
				}
			}
			if(i == 2) {
				use3 = new Coord(posX, posY);
				if(use3.equals(use1) || use3.equals(use2)) {
					i--;
				}
				else {
					if(this.cellules[posX][posY].innonde() == Etat.Submerge && this.cellules[posX][posY].isOccupied()) {
						this.cellules[posX][posY].getPlayer().noyer();
						System.out.println(this.cellules[posX][posY].getPlayer().toString() + " est mort noyé!");
					}
				}
			}
		}
	}
	
	public void finChoix() {
		if(this.tour.getEtape() == 0) {
			this.tour.changeChoix();
			if(this.tour.getChoix() == 0) {
				this.tour.changeEtape();
			}
		}
		else {
			System.out.println("OK CHANGEMENT DE JOUEUR");
			this.tour.setEtape(0);
			this.tour.setChoix(0);
			System.out.println("Etape ->" + this.tour.getEtape() + "; Choix -> " + this.tour.getChoix());
			this.currentPlayerIndex++;
			if(this.currentPlayerIndex == this.players.size()) {
				this.currentPlayerIndex = 0;
			}
		}
	}

	public void avance() {
		innondeCases();
		this.finJeu = finJeu();
		notifyObservers();
		if(this.finJeu) {
			TimeUtils.sleepFor(2, TimeUnit.SECONDS);
			this.erreur.setError(20);
		}
		
		if(this.winJeu()) {
			TimeUtils.sleepFor(2, TimeUnit.SECONDS);
			this.erreur.setError(20);
		}
	}
	
	public Coord getNextCell(Direction dir) {
		Player currentPlayer = this.getCurrentPlayer();
		Coord currentPos = currentPlayer.getPosition();
		Coord res;
		if(dir == Direction.Haut) {
			res = new Coord(currentPos.getX(), currentPos.getY() - 1);
			return res;
		}
		else if(dir == Direction.Bas) {
			res = new Coord(currentPos.getX(), currentPos.getY() + 1);
			return res;
		}
		else if(dir == Direction.Gauche) {
			res = new Coord(currentPos.getX() - 1, currentPos.getY());
			return res;
		}
		else if(dir == Direction.Here) {
			res = new Coord(currentPos.getX(), currentPos.getY());
			return res;
		}
		else {
			res = new Coord(currentPos.getX() + 1, currentPos.getY());
			return res;
		}
	}
	
	public boolean finJeu() {
		ArrayList<TypeCell> artefactTab = creatTab();
		ArrayList<TypeCell> keyTab = creatTab();
		
		Cellule currentCell;
		
		Player currentPlayer;
		int countDead = 0;
		
		System.out.println("===================================");
		System.out.println("		TEST FIN JEU               ");
		
		for(int i = 1; i <= this.TAILLE; i++) {
			for(int j = 1; j <= this.TAILLE; j++) {
				
				currentCell = this.cellules[i][j];
				System.out.println();
				System.out.println("I -> " + i + " J -> " + j);
				System.out.println("Etat -> " + currentCell.getEtat().toString());
				System.out.println("Type -> " + currentCell.getType().toString());
				System.out.println();
				if(currentCell.getEtat() == Etat.Submerge) {
					if(currentCell.getType() != TypeCell.Normale) {
						System.out.println("I -> " + i + " J -> " + j);
						System.out.println("Etat -> " + currentCell.getEtat().toString());
						System.out.println("Type -> " + currentCell.getType().toString());
						System.out.println("FIN JEU: ARTEFACT ou HELICO SUBMERGE");
						this.erreur.setError(15);
						return true;
					}
				}
				
			}
			
			System.out.println("===================================");
		}
		
		for(int i = 0; i < this.players.size(); i++) {
			currentPlayer = this.players.get(i);
			if(!currentPlayer.isAlive()) {
				countDead++;
				if(!(currentPlayer.getBag().isEmpty() && currentPlayer.getArtefacts().isEmpty())) {
					System.out.println("FIN JEU: PLAYER MORT AVEC UNE CLE OU UN ARTEFACT");
					this.erreur.setError(16);
					return true;
				}
			}
		}
		
		if(countDead == this.players.size() + 1) {
			System.out.println("FIN JEU: TOUT LES JOUEURS SONT MORTS");
			this.erreur.setError(17);
			return true;
		}
		
		return false;
	}
	
	public boolean winJeu() {
		ArrayList<Player> use1 = new ArrayList<Player>();
		ArrayList<TypeCell> artefactTab = creatTab();
		for(int i = 1; i <= this.TAILLE; i++) {
			for(int j = 1; j <= this.TAILLE; j++) {
				if(this.cellules[i][j].getType() == TypeCell.Helico) {
					use1 = this.cellules[i][j].getPlayers();
				}
			}
		}
		
		for(int i = 0; i < use1.size(); i++) {
			Player use2 = use1.get(i);
			for(int j = 0; j < use2.getArtefacts().size(); j++) {
				artefactTab.remove(use2.getArtefacts().get(j));
			}
		}
		
		if(artefactTab.isEmpty()) {
			this.erreur.setError(21);
			return true;
		}
		
		return false;
	}
	
	/**
	 * Méthodes de choix et de jeu
	 * **/
	
	public void movePlayerUp() {
		if(this.tour.getEtape() == 0) {
			System.out.println("OK MOVE");
			Player currentPlayer = this.players.get(this.currentPlayerIndex);
			Coord coordCurrent = currentPlayer.getPosition();
			this.cellules[coordCurrent.getX()][coordCurrent.getY()].removePlayer();
			
			boolean use2 = this.players.get(this.currentPlayerIndex).moveUp();
			
			Player afterPlayer = this.players.get(this.currentPlayerIndex);
			Coord coordAfter = afterPlayer.getPosition();
			this.cellules[coordAfter.getX()][coordAfter.getY()].setPlayer(afterPlayer);
			this.cellules[coordAfter.getX()][coordAfter.getY()].getOccupied(true);
			if(!use2) {
				this.erreur.setError(0);
				System.out.println("ERROR: MOVE UP IMPOSSIBLE pour Player : " + (this.currentPlayerIndex + 1));
			}
			else {
				this.erreur.setError(3);
				finChoix();
			}
		}
		else {
			this.erreur.setError(5);
		}
		notifyObservers();
		showPlayers();
	}
	
	public void movePlayerDown() {
		if(this.tour.getEtape() == 0) {
			System.out.println("OK MOVE");
			Player currentPlayer = this.players.get(this.currentPlayerIndex);
			Coord coordCurrent = currentPlayer.getPosition();
			this.cellules[coordCurrent.getX()][coordCurrent.getY()].removePlayer();
			
			boolean use2 = this.players.get(this.currentPlayerIndex).moveDown();
			
			Player afterPlayer = this.players.get(this.currentPlayerIndex);
			Coord coordAfter = afterPlayer.getPosition();
			this.cellules[coordAfter.getX()][coordAfter.getY()].setPlayer(afterPlayer);
			this.cellules[coordAfter.getX()][coordAfter.getY()].getOccupied(true);
			if(!use2) {
				this.erreur.setError(0);
				System.out.println("ERROR: MOVE DOWN IMPOSSIBLE pour Player : " + (this.currentPlayerIndex + 1));
			}
			else {
				this.erreur.setError(3);
				finChoix();
			}
		}
		else {
			this.erreur.setError(5);
		}
		notifyObservers();
		showPlayers();
	}
	
	public void movePlayerLeft() {
		if(this.tour.getEtape() == 0) {
			System.out.println("OK MOVE");
			Player currentPlayer = this.players.get(this.currentPlayerIndex);
			Coord coordCurrent = currentPlayer.getPosition();
			this.cellules[coordCurrent.getX()][coordCurrent.getY()].removePlayer();
			
			boolean use2 = this.players.get(this.currentPlayerIndex).moveLeft();
			
			Player afterPlayer = this.players.get(this.currentPlayerIndex);
			Coord coordAfter = afterPlayer.getPosition();
			this.cellules[coordAfter.getX()][coordAfter.getY()].setPlayer(afterPlayer);
			this.cellules[coordAfter.getX()][coordAfter.getY()].getOccupied(true);
			if(!use2) {
				this.erreur.setError(0);
				System.out.println("ERROR: MOVE LEFT IMPOSSIBLE pour Player : " + (this.currentPlayerIndex + 1));
			}
			else {
				this.erreur.setError(3);
				finChoix();
			}
		}
		else {
			this.erreur.setError(5);
		}
		notifyObservers();
		showPlayers();
	}
	
	public void movePlayerRight() {
		if(this.tour.getEtape() == 0) {
			System.out.println("OK MOVE");
			Player currentPlayer = this.players.get(this.currentPlayerIndex);
			Coord coordCurrent = currentPlayer.getPosition();
			this.cellules[coordCurrent.getX()][coordCurrent.getY()].removePlayer();
			
			boolean use2 = this.players.get(this.currentPlayerIndex).moveRight();
			
			Player afterPlayer = this.players.get(this.currentPlayerIndex);
			Coord coordAfter = afterPlayer.getPosition();
			this.cellules[coordAfter.getX()][coordAfter.getY()].setPlayer(afterPlayer);
			this.cellules[coordAfter.getX()][coordAfter.getY()].getOccupied(true);
			if(!use2) {
				this.erreur.setError(0);
				System.out.println("ERROR: MOVE RIGHT IMPOSSIBLE pour Player : " + (this.currentPlayerIndex + 1));
			}
			else {
				this.erreur.setError(3);
				finChoix();
			}
		}
		else {
			this.erreur.setError(5);
		}
		notifyObservers();
		showPlayers();
	}
	
	public void recupererArtefact() {
		if(this.tour.getEtape() == 0) {
			Player currentPlayer = this.players.get(this.currentPlayerIndex);
			Coord currentCoord = currentPlayer.getPosition();
			ArrayList<TypeCell> currentBag = currentPlayer.getBag();
			Cellule currentCell = this.cellules[currentCoord.getX()][currentCoord.getY()];
			TypeCell cellType = currentCell.getType(); 
			if(currentBag.contains(cellType)) {
				currentPlayer.addArtefacts(cellType);
				currentCell.setType(TypeCell.Normale);
				finChoix();
				this.erreur.setError(8);
				notifyObservers();
				TimeUtils.sleepFor(2, TimeUnit.SECONDS);
			}
			else {
				this.erreur.setError(7);
				notifyObservers();
			}
		}
		else {
			this.erreur.setError(9);
			notifyObservers();
		}
	}
	
	public void passerTour() {
		this.tour.setChoix(0);
		
		this.tour.setEtape(0);
		this.currentPlayerIndex++;
		if(this.currentPlayerIndex == this.players.size()) {
			this.currentPlayerIndex = 0;
		}
		this.avance();
	}
	
	public void finTour() {
		passerTour();
	}
	
	public void chercherCle() {
		if(this.tour.getEtape() == 1) {
			int chance = (int)(Math.random() * 100);
			if(chance <= this.keyChance) {
				if(this.keyArray.size() != 0) {
					int keyIndex = (int)(Math.random() * this.keyArray.size());
					TypeCell key = this.keyArray.get(keyIndex);
					this.players.get(this.currentPlayerIndex).addKey(key);
					this.keyArray.remove(key);
					this.erreur.setError(6);
				}
				else {
					this.erreur.setError(10);
				}
			}
			else {
				this.erreur.setError(2);
			}
			finChoix();
			avance();
		}
		else {
			this.erreur.setError(4);
			notifyObservers();
		}
	}
	
	public void assecher(Direction dir) {
		if(this.tour.getEtape() == 0) {
			Player currentP = this.getCurrentPlayer();
			Coord currentPos = currentP.getPosition();
			Coord nextPos = this.getNextCell(dir);
			Cellule nextCell = this.cellules[nextPos.getX()][nextPos.getY()];
			if(nextCell.getEtat() == Etat.Innonde) {
				nextCell.setEtat(Etat.Emerge);
				finChoix();
				notifyObservers();
			}
			else if(nextCell.getEtat() == Etat.Submerge) {
				this.erreur.setError(12);
				notifyObservers();
			}
			else {
				this.erreur.setError(13);
				notifyObservers();
			}
		}
		else {
			this.erreur.setError(14);
			notifyObservers();
		}
	}
	
}

/**
 * FIN DE LA CLASSE CMODELE
 * **/
