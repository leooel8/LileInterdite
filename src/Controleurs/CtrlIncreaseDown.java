package Controleurs;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Modele.Parametres;

public class CtrlIncreaseDown implements ActionListener {
//	ATTRIBUTS
	Parametres param;
	
//	CONSTRUCTEUR
	public CtrlIncreaseDown(Parametres param) {
		this.param = param;
	}

//	METHODES	
	@Override
	public void actionPerformed(ActionEvent e) {
		this.param.downNbrPlayer();
		
	}
	
}
