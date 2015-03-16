/**
 * 
 */
package controller;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.JButton;

import view.Connexion;

/**
 * @author Steffie Lim
 *
 */
public class AffichagePwd extends AbstractAction {
	
	private static final long serialVersionUID = 1L;
	private Connexion con;

	/**
	 * 
	 */
	public AffichagePwd(Connexion con, String s) {
		super(s);
		this.con = con;
	}
	
	public void actionPerformed(ActionEvent e){
		String pwd = new String(con.getChampPwd().getPassword());
		pwd += ((JButton)e.getSource()).getText();
		
		con.getChampPwd().setText(pwd);
		
		
	}
	
	

	
}
