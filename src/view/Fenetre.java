/**
 * 
 */
package view;

import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * @author slim
 *
 */
public class Fenetre extends JFrame{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	PadPass boite = new PadPass();
	
	public Fenetre(){
		super();
		
		init();

	}
	
	public Fenetre(String titre, JLabel message){
		this.setTitle(titre);
		this.setSize(500,300);
		this.setLocationRelativeTo(getParent());
		Container c = getContentPane();
		c.setLayout(new FlowLayout());
		c.add(message);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
	
	public void init(){
		//Titre de la fenetre
		this.setTitle("Projet Java 2014-2015");
		
		//Dimension de la fenetre
		this.setSize(600, 480);
		
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JPanel pan = new JPanel();
		pan.setBackground(Color.DARK_GRAY);
		
		SaisieClient boite1 = new SaisieClient();
		
		this.setContentPane(boite1.getPanSAisieClient());
		//this.setContentPane(boite1);
		this.setVisible(true);
	}
	
	public JPanel numeroClientField(){
		JPanel pan_client = new JPanel();
		pan_client.setLayout(new FlowLayout());
		
		JLabel text = new JLabel("Saisie numero client");
		
		pan_client.add(text);
		
		return pan_client;
	}
}
