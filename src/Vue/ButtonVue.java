package Vue;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JPanel;

import Controleurs.CtrlIncreaseDown;
import Controleurs.CtrlIncreaseDown_2;
import Controleurs.CtrlIncreaseDown_3;
import Controleurs.CtrlIncreaseUp;
import Controleurs.CtrlIncreaseUp_2;
import Controleurs.CtrlIncreaseUp_3;
import Modele.Parametres;

/**
 * DEBUT DE LA CLASSE BUTTONVUE
 * **/

public class ButtonVue extends JPanel{
//	ATTRIBUTS
	private Parametres param;
	
//	CONSTRUCTEUR
	public ButtonVue(Parametres param) {
		this.param = param;
		
		//Dimensions utiles
		Dimension dim = new Dimension(100,100);
		Dimension dim2 = new Dimension (100,300);
		
		this.setLayout(new BorderLayout());
		
		//Création des trois différents Panels qui vont contenir les boutons de choix des paramètres de jeu
		//et ajout au Panel général
		JPanel pan_1 = new JPanel();
		pan_1.setLayout(new BorderLayout());
		this.add(pan_1, BorderLayout.NORTH);
		pan_1.setPreferredSize(dim2);
		
		JPanel pan_2 = new JPanel();
		pan_2.setLayout(new BorderLayout());
		this.add(pan_2, BorderLayout.CENTER);
		pan_2.setPreferredSize(dim2);
		
		JPanel pan_3 = new JPanel();
		pan_3.setLayout(new BorderLayout());
		this.add(pan_3, BorderLayout.SOUTH);
		pan_3.setPreferredSize(dim2);
		
		//Création des différents boutons de choix de paramètre
		JButton increaseUp_1 = new JButton("^");
		JButton increaseDown_1 = new JButton("v");
		JButton increaseUp_2 = new JButton("^");
		JButton increaseDown_2 = new JButton("v");
		JButton increaseUp_3 = new JButton("^");
		JButton increaseDown_3 = new JButton("v");
		
		//Ajout des boutons aux différents Panels
		pan_1.add(increaseUp_1 ,BorderLayout.WEST);
		pan_1.add(increaseDown_1 ,BorderLayout.EAST);
		pan_2.add(increaseUp_2 ,BorderLayout.WEST);
		pan_2.add(increaseDown_2 ,BorderLayout.EAST);
		pan_3.add(increaseUp_3 ,BorderLayout.WEST);
		pan_3.add(increaseDown_3 ,BorderLayout.EAST);
		
		//Configuration des tailles des boutons
		increaseUp_1.setPreferredSize(dim);
		increaseDown_1.setPreferredSize(dim);
		increaseUp_2.setPreferredSize(dim);
		increaseDown_2.setPreferredSize(dim);
		increaseUp_3.setPreferredSize(dim);
		increaseDown_3.setPreferredSize(dim);
		
		//Création des controleurs
		CtrlIncreaseUp ctrlIncreaseUp = new CtrlIncreaseUp(this.param);
		CtrlIncreaseDown ctrlIncreaseDown = new CtrlIncreaseDown(this.param);
		CtrlIncreaseUp_2 ctrlIncreaseUp_2 = new CtrlIncreaseUp_2(this.param);
		CtrlIncreaseDown_2 ctrlIncreaseDown_2 = new CtrlIncreaseDown_2(this.param);
		CtrlIncreaseUp_3 ctrlIncreaseUp_3 = new CtrlIncreaseUp_3(this.param);
		CtrlIncreaseDown_3 ctrlIncreaseDown_3 = new CtrlIncreaseDown_3(this.param);
		
		//Association des controleurs avec les différents boutons
		increaseUp_1.addActionListener(ctrlIncreaseUp);
		increaseDown_1.addActionListener(ctrlIncreaseDown);
		increaseUp_2.addActionListener(ctrlIncreaseUp_2);
		increaseDown_2.addActionListener(ctrlIncreaseDown_2);
		increaseUp_3.addActionListener(ctrlIncreaseUp_3);
		increaseDown_3.addActionListener(ctrlIncreaseDown_3);
	}

}

/**
 * FIN DE LA CLASSE BUTTONVUE
 * **/