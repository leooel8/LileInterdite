package Controleurs;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Modele.Parametres;

public class CtrlIncreaseUp implements ActionListener{
//	ATTRIBUTS
	Parametres param;
	
//	CONSTRUCTEUR
	public CtrlIncreaseUp(Parametres param) {
		this.param = param;
	}

//	METHODES	
	@Override
	public void actionPerformed(ActionEvent e) {
		this.param.upNbrPlayer();
	}

}
