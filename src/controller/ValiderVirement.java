/**
 * 
 */
package controller;

import java.awt.event.ActionEvent;
import java.io.IOException;

import javax.swing.AbstractAction;
import javax.swing.JOptionPane;

import model.Comptes;
import model.History;
import view.FenetreVirement;

/**
 * @author Steffie Lim
 *
 */
public class ValiderVirement extends AbstractAction {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private FenetreVirement fv;
	private boolean done;

	/**
	 * @param name
	 */
	public ValiderVirement(FenetreVirement fv, String name) {
		super(name);
		this.fv = fv;
		this.done = false;
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e){
		String i, j;
		int k,m;
				
		i = (String) fv.getComboBoxComptePerso().getSelectedItem();
		j = (String) fv.getComboBoxCompteBenef().getSelectedItem();
		
		if(i.equalsIgnoreCase(j)){
			JOptionPane.showMessageDialog(fv, "Le compte beneficiaire est le meme que le compte debitaire", "Erreur", JOptionPane.ERROR_MESSAGE);
		}
		else{
			Double euro = 0.0;
			k = fv.getComboBoxComptePerso().getSelectedIndex();
			m = fv.getComboBoxCompteBenef().getSelectedIndex();
			
			Comptes client = fv.getFc().getListe_comptes().get(k);
			Comptes benef = fv.getBenef().getListe_comptes().get(m);
			
			try{
				euro = Double.parseDouble(fv.getChampMontant().getText());
				if(fv.getImmediat().isSelected()){
					
					done = client.versement(benef, euro);
					if(done){
						fv.getDoc().addToHistory(fv.getChamp_libelle().getText(),benef.getTitre(),benef.getIBAN(),euro);
						try {
							fv.getDoc().saveHistory(client.getSolde());
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}
				}
				
				System.out.println("client "+client);	
				System.out.println("benef " +benef);	

			}
			catch(NumberFormatException nfe){
				JOptionPane.showMessageDialog(fv, "Le montant n'est pas un nombre", "Erreur", JOptionPane.ERROR_MESSAGE);
			
			}
		
		}
	}
	
}
