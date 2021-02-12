package Interfaces;

import java.util.ArrayList;

/**
 * DEBUT DE LA CLASSE OBSERVABLE_2
 * **/

public abstract class Observable_2 {
//ATTRIBUTS
	
    private ArrayList<Observer_2> observers;
    public Observable_2() {
    	this.observers = new ArrayList<Observer_2>();
    }
    
//	CONSTRUCTEUR
    
    public void addObserver_2(Observer_2 o) {
    	observers.add(o);
    }

//	METHODES
    
    public void notifyObservers_2() {
		for(Observer_2 o : observers) {
		    o.update();
		}
    }
    
}

/**
 * FIN DE LA CLASSE OBSERVABLE_2
 * **/