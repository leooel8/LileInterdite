package Usefull;

/**
 * Enum 'Direction': Utiles pour certaines foncitons de déplacements
 * **/

public enum Direction {
	Gauche ("Gauche"),
	Droite ("Droite"),
	Haut ("Haut"),
	Bas ("Bas"),
	Here ("Here");
	
	private String name = "";
	
	Direction(String name){
		this.name = name;
	}
	
	public String toString() {
		return name;
	}
}
