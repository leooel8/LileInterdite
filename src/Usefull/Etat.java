package Usefull;

/**
 * Enum 'Etat': Diff�rents �tats que peuvent prendre les celulles du jeu
 * **/
public enum Etat {
	Emerge ("Emerge"),
	Innonde ("Innonde"),
	Submerge ("Submerge");
	
	private String name = "";
	
	Etat(String name){
		this.name = name;
	}
	
	public String toString() {
		return name;
	}
}
