/**
 * 
 */
package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * @author Steffie Lim
 * Fenetre de tous le programme
 *
 */
public class Fenetre extends JFrame{
	
	private static final long serialVersionUID = 1L;
	boolean is_Connexion;
	JPanel mainPanel;

	public Fenetre(String title, int hauteur, int largeur, boolean connex){
		super();
		is_Connexion = connex;
		mainPanel = new JPanel();
		init(title, largeur, hauteur, connex);	

	}
	
	public void init(String title, int largeur, int hauteur, boolean is_Connexion){
		
		this.setTitle(title);
		this.setSize(largeur, hauteur);
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		if(is_Connexion == true){
			setContentPane(buildConnexion());

		}
		else{
			setContentPane(buildPage());
		}
	}
	
	public JPanel buildConnexion(){
		Connexion c = new Connexion(this);
		
		mainPanel.add(c.init());
		
		return mainPanel;
	}
	
	public JPanel buildPage(){
		return mainPanel;
	}
	
}
