/**
 * 
 */
package controller;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.JOptionPane;

import model.Client;
import model.FichierClients;
import view.Connexion;
import view.Fenetre;
import view.FenetreVirement;

/**
 * @author Steffie Lim
 *
 */
public class ValiderConnexion extends AbstractAction {

	
	private static final long serialVersionUID = 1189669548443745909L;
	private Fenetre f;
	private Connexion con;
	private FichierClients fc;
	
	/**
	 * 
	 * @param con
	 * @param str
	 */
	public ValiderConnexion(Connexion con, Fenetre fen, String str) {
		// TODO Auto-generated constructor stub
		super(str);
		this.f = fen;
		this.con=con;
		fc = new FichierClients();
	}
	
	public void actionPerformed(ActionEvent e){
		String nc = con.getNum_client().getText();
		String pwd = new String(con.getChampPwd().getPassword());
		String[] info = new String[4];

		
		if(nc.trim().equals("")){
			JOptionPane.showMessageDialog(null, "Le numero client n'est pas renseigné", "Erreur", JOptionPane.ERROR_MESSAGE);;
		}
		else if(pwd.trim().equals("")){
			JOptionPane.showMessageDialog(null, "Le mot de passe n'est pas renseigne", "Erreur", JOptionPane.ERROR_MESSAGE);
		}
		else if(fc.loadConnexion("./Resources/test_fichierclient.csv", nc, pwd, info) == false){
			JOptionPane.showMessageDialog(null, "Les identifiants sont incorrects", "Erreur", JOptionPane.ERROR_MESSAGE);			
		}
		else if(fc.loadConnexion("./Resources/test_fichierclient.csv", nc, pwd, info) == true){
			FenetreVirement fv = new FenetreVirement(f, info);	
			f.getMainPanel().add(fv.buildContentPane(),"2");
			f.getCl().show(f.getMainPanel(),"2");
			
			//JOptionPane.showMessageDialog(null, "Les identifiants sont corrects", "Success", JOptionPane.PLAIN_MESSAGE);						
		}
		
		
		
	}

}
