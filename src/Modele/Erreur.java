package Modele;

/**
 * DEBUT DE LA CLASSE ERREUR
 * **/

public class Erreur {
//	ATTRIBUTS
	private String errorName;
	private int errorNum;
	
//	CONSTRUCTEUR
	public Erreur() {
		this.errorNum = 5;
		this.errorName = "Pas d'erreur";
	}
	
//	METHODES
	
	/**
	 * Méthodes 'get' et 'set'
	 * **/
	
	public int getErrorNum() {
		return this.errorNum;
	}
	
	public String getErrorName() {
		return this.errorName;
	}
	
	public void setError(int errorNum) {
		this.errorNum = errorNum;
		if(errorNum == 0) {
			this.errorName = "Move IMPOSSIBLE";
		}
		else if(errorNum == 1) {
			this.errorName = "Zone déjà submergé : IMPOSSIBLE de l'assécher";
		}
		else if(errorNum == 2) {
			this.errorName = "Pas de clé ici..";
		}
		else if(errorNum == 3) {
			this.errorName = "Pas d'erreur";
		}
		else if(errorNum == 4) {
			this.errorName = "Vous devez d'abord voud déplacer, récupérer un artefact /brou assecher une zone"
					+ "(3 actions par tour MAX)";
		}
		else if(errorNum == 5) {
			this.errorName = "Vous avez déja avancé, vous devez maintenant chercher une /brclé ou passer votre tour";
		}
		else if(errorNum == 6) {
			this.errorName = "Bravo ! Vous avez trouvé la une nouvelle clé !";
		}
		else if(errorNum == 7) {
			this.errorName = "Vous n'êtes pas sur une case 'Artefact', /br ou vous ne possédez pas la clé correspondante ..";
		}
		else if(errorNum == 8) {
			this.errorName = "Bravo ! Vous avez obtenu un nouvel Artefact !";
		}
		else if(errorNum == 9) {
			this.errorName = "Vous ne pouvez plus récupérer d'artefact. /brVous devez maintenant rechercher une clé ou passer votre tour";
		}
		else if(errorNum == 10) {
			this.errorName = "Vous avez déjà trouvé toutes les clés ! /brRécupérez vite touts les artefacts ! ";
		}
		else if(errorNum == 11) {
			this.errorName = "Vous ne pouvez pas décoller! /brVérifiez que vous avez bien récupéré tout les artefacts.";
		}
		else if(errorNum == 12) {
			this.errorName = "La case choisie est déjà submergé. /brIl est impossible de la récupérer. /brVeuillez choisir une autre case";
		}
		else if(errorNum == 13) {
			this.errorName = "Cette case n'est pas innondé. Veuillez choisir une autre case.";
		}
		else if(errorNum == 14) {
			this.errorName = "Vous ne pouvez plus assécher de case. /brVous devez maintenant chercher une clé, /brou bien sélectionner 'Fin de tour'";
		}
		else if(errorNum == 15) {
			this.errorName = "GAME OVER /brL'un des Artefacts a été submergé..";
		}
		else if(errorNum == 16) {
			this.errorName = "GAME OVER /brL'un des joueurs est mort avec une clé ou un artefact..";
		}
		else if(errorNum == 17) {
			this.errorName = "GAME OVER /brTout les joueurs sont morts..";
		}
		else if(errorNum == 20) {
			this.errorName = "NONE";
		}
		else if(errorNum == 21) {
			this.errorName = "BRAVO /br Vous avez gagné!";
		}
	}

}

/**
 * FIN DE LA CLASSE ERREUR
 * **/
