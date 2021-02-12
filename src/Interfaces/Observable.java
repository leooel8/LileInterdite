package Interfaces;

import java.util.ArrayList;

/**
 * DEBUT DE LA CLASSE OBSERVABLE
 * **/

public abstract class Observable {
//	ATTRIBUTS
	
    private ArrayList<Observer> observers;
    public Observable() {
	this.observers = new ArrayList<Observer>();
    }
    
//	CONSTRUCTEUR
    
    public void addObserver(Observer o) {
	observers.add(o);
    }

//	METHODES
    
    public void notifyObservers() {
		for(Observer o : observers) {
		    o.update();
		}
    }
    
}

/**
 * FIN DE LA CLASSE OBSERVABLE
 * **/
