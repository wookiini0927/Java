/**
 * 
 */
package view;

import java.awt.BorderLayout;
import java.awt.CardLayout;
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
	private JPanel mainPanel;
	private CardLayout cl = new CardLayout();


	public Fenetre(String title, int hauteur, int largeur, boolean connex){
		super();
		is_Connexion = connex;
		mainPanel = new JPanel();
		mainPanel.setLayout(cl);

		init(title, largeur, hauteur, connex);	

	}
	
	public void init(String title, int largeur, int hauteur, boolean is_Connexion){
		
		this.setTitle(title);
		this.setSize(largeur, hauteur);
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		if(is_Connexion == true){
			mainPanel = buildConnexion();
		//	cl.show(mainPanel, "1");
			this.add(mainPanel);
			

		}
		else{
			setContentPane(buildPage());
		}
	}
	
	public JPanel buildConnexion(){
		Connexion c = new Connexion(this);
		
		mainPanel.add(c.init(), "1");
		cl.show(mainPanel, "1");
		return mainPanel;
	}
	
	public JPanel buildPage(){
		FenetreVirement fv = new FenetreVirement(this);
		mainPanel.add(fv.buildContentPane(), "2");
		
		cl.show(mainPanel,"2");
		return mainPanel;
	}

	/**
	 * @return the mainPanel
	 */
	public JPanel getMainPanel() {
		return mainPanel;
	}

	/**
	 * @param mainPanel the mainPanel to set
	 */
	public void setMainPanel(JPanel mainPanel) {
		this.mainPanel = mainPanel;
	}

	/**
	 * @return the cl
	 */
	public CardLayout getCl() {
		return cl;
	}

	/**
	 * @param cl the cl to set
	 */
	public void setCl(CardLayout cl) {
		this.cl = cl;
	}
	
	
	
}
