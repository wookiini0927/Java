/**
 * 
 */
package controller;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;

import view.FenetreVirement;

/**
 * @author Steffie Lim
 *
 */
public class ValiderVirement extends AbstractAction {
	private FenetreVirement fv;

	/**
	 * @param name
	 */
	public ValiderVirement(FenetreVirement fv, String name) {
		super(name);
		this.fv = fv;
	}
	
	@Override
	public void actionPerformed(ActionEvent e){
		int i = 0;
		i = fv.getComptePerso().getSelectedIndex();
		
		System.out.println(i);
	}
	
	
}
