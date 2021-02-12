package Usefull;

/**
 * Enum 'TypeCell': Diff�rents types de cellule
 * 
 * Note: Les types 'Cle' ne sont pas utilis�s
 * **/

public enum TypeCell {
	Feu ("Feu     "),
	Air ("Air     "),
	Terre ("Terre   "),
	Eau ("Eau     "),
	Normale("Normale "),
	CleFeu ("CleFeu  "),
	CleAir ("CleAir  "),
	CleTerre ("CleTerre"),
	CleEau ("CleEau  "),
	Helico ("Helico ");
	
	private String name = "";
	
	TypeCell(String name){
		this.name = name;
	}
	
	public String toString() {
		return name;
	}
}
