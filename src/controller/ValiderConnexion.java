/**
 * 
 */
package controller;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;

import view.Connexion;

/**
 * @author Steffie Lim
 *
 */
public class ValiderConnexion extends AbstractAction {

	
	private static final long serialVersionUID = 1189669548443745909L;
	private Connexion con;
	
	/**
	 * 
	 * @param con
	 * @param str
	 */
	public ValiderConnexion(Connexion con, String str) {
		// TODO Auto-generated constructor stub
		super(str);
		this.con=con;
	}
	
	public void actionPerformed(ActionEvent e){
		
	}

}
