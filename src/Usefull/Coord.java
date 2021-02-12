package Usefull;

/**
 * Enum 'Coord': type pour stocker une coordonnée
 * **/

public class Coord {
//	ATTRIBUTS
	private int x;
	private int y;
	
//	CONSTRUCTEUR
	public Coord(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
//	METHODES
	public int getX() {
		return this.x;
	}
	
	public int getY() {
		return this.y;
	}
	
	public void moveXUp() {
		this.x++;
	}
	
	public void moveXDown() {
		this.x--;
	}
	
	public void moveYUp() {
		this.y++;
	}
	
	public void moveYDown() {
		this.y--;
	}
	
	public boolean equals(Coord coord) {
		if(this.x == coord.getX() && this.y == coord.getY()) {
			return true;
		}
		return false;
	}
}
