package Controleurs;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Modele.Parametres;

public class CtrlIncreaseUp_3 implements ActionListener{
//	ATTRIBUTS
	Parametres param;
	
//	CONSTRUCTEUR
	public CtrlIncreaseUp_3(Parametres param) {
		this.param = param;
	}

//	METHODES	
	@Override
	public void actionPerformed(ActionEvent e) {
		this.param.upTaille();		
	}

}
