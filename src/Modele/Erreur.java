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
	 * M�thodes 'get' et 'set'
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
			this.errorName = "Zone d�j� submerg� : IMPOSSIBLE de l'ass�cher";
		}
		else if(errorNum == 2) {
			this.errorName = "Pas de cl� ici..";
		}
		else if(errorNum == 3) {
			this.errorName = "Pas d'erreur";
		}
		else if(errorNum == 4) {
			this.errorName = "Vous devez d'abord voud d�placer, r�cup�rer un artefact /brou assecher une zone"
					+ "(3 actions par tour MAX)";
		}
		else if(errorNum == 5) {
			this.errorName = "Vous avez d�ja avanc�, vous devez maintenant chercher une /brcl� ou passer votre tour";
		}
		else if(errorNum == 6) {
			this.errorName = "Bravo ! Vous avez trouv� la une nouvelle cl� !";
		}
		else if(errorNum == 7) {
			this.errorName = "Vous n'�tes pas sur une case 'Artefact', /br ou vous ne poss�dez pas la cl� correspondante ..";
		}
		else if(errorNum == 8) {
			this.errorName = "Bravo ! Vous avez obtenu un nouvel Artefact !";
		}
		else if(errorNum == 9) {
			this.errorName = "Vous ne pouvez plus r�cup�rer d'artefact. /brVous devez maintenant rechercher une cl� ou passer votre tour";
		}
		else if(errorNum == 10) {
			this.errorName = "Vous avez d�j� trouv� toutes les cl�s ! /brR�cup�rez vite touts les artefacts ! ";
		}
		else if(errorNum == 11) {
			this.errorName = "Vous ne pouvez pas d�coller! /brV�rifiez que vous avez bien r�cup�r� tout les artefacts.";
		}
		else if(errorNum == 12) {
			this.errorName = "La case choisie est d�j� submerg�. /brIl est impossible de la r�cup�rer. /brVeuillez choisir une autre case";
		}
		else if(errorNum == 13) {
			this.errorName = "Cette case n'est pas innond�. Veuillez choisir une autre case.";
		}
		else if(errorNum == 14) {
			this.errorName = "Vous ne pouvez plus ass�cher de case. /brVous devez maintenant chercher une cl�, /brou bien s�lectionner 'Fin de tour'";
		}
		else if(errorNum == 15) {
			this.errorName = "GAME OVER /brL'un des Artefacts a �t� submerg�..";
		}
		else if(errorNum == 16) {
			this.errorName = "GAME OVER /brL'un des joueurs est mort avec une cl� ou un artefact..";
		}
		else if(errorNum == 17) {
			this.errorName = "GAME OVER /brTout les joueurs sont morts..";
		}
		else if(errorNum == 20) {
			this.errorName = "NONE";
		}
		else if(errorNum == 21) {
			this.errorName = "BRAVO /br Vous avez gagn�!";
		}
	}

}

/**
 * FIN DE LA CLASSE ERREUR
 * **/
