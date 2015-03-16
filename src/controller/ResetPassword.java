/**
 * 
 */
package controller;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;

import view.Connexion;

/**
 * @author slim
 *
 */
public class ResetPassword extends AbstractAction{

	/**
	 * 
	 */
	private static final long serialVersionUID = 706726216277942381L;
	private Connexion con;
	
	public ResetPassword(Connexion con, String str){
		super(str);
		this.con = con;
	}
	
	public void actionPerformed(ActionEvent e){
		con.getChampPwd().setText("");
	}
}
