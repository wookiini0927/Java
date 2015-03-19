/**
 * 
 */
package controller;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;

import view.FenetreVirement;

/**
 * @author slim
 *
 */
public class AbandonnerVirement extends AbstractAction {
	private FenetreVirement fv;

	/**
	 * @param name
	 */
	public AbandonnerVirement(FenetreVirement fv, String name) {
		super(name);
		this.fv = fv;
	}

	@Override
	public void actionPerformed(ActionEvent e){
		fv.getChamp_libelle().setText("");
		fv.getChampMontant().setText("");
		fv.getImmediat().setSelected(true);
		fv.getDifferent().setSelected(false);
	}
	
}
