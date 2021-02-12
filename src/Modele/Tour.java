package Modele;

/**
 * DEBUT DE LA CLASSE TOUR
 * **/
public class Tour {
//	ATTRIBUTS
	private int etape;
	private int choix;
	
//	CONSTRUCTEUR
	public Tour() {
		this.etape = 0; 
		this.choix = 0;
	}
	
//	METHODES
	
	/**
	 * Méthodes 'get' et 'set'
	 * **/
	
	public int getEtape() {
		return this.etape;
	}
	
	public int getChoix() {
		return this.choix;
	}
	
	public void changeEtape() {
		this.etape++;
		if(this.etape == 2) {
			this.etape = 0;
		}
	}
	
	public void setChoix(int i) {
		this.choix = i;
	}
	
	public void setEtape(int i) {
		this.etape = i;
	}
	
	/**
	 * Méthodes utile au jeu
	 * **/
	
	public void changeChoix() {
		this.choix++;
		if(this.choix == 3) {
			this.choix = 0;
		}
	}

}

/**
 * FIN DE LA CLASSE TOUR
 * **/
