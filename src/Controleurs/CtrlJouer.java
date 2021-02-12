package Controleurs;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Vue.ParamVue;

public class CtrlJouer implements ActionListener{
//	ATTRIBUTS
	ParamVue param;
	
//	CONSTRUCTEUR
	public CtrlJouer(ParamVue param) {
		this.param = param;
	}
//	METHODES

	@Override
	public void actionPerformed(ActionEvent arg0) {
		this.param.jouer();
		// TODO Auto-generated method stub
		
	}

}
