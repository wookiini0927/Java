/**
 * 
 */
package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import controller.AffichagePwd;
import controller.ResetPassword;
import controller.ValiderConnexion;
import controller.testNumClient;

/**
 * @author Steffie Lim
 *
 */
public class Connexion extends JPanel{

	private static final long serialVersionUID = 1L;
	
	String numero[] = {"0","1","2","3","4","5","6","7","8","9"};
	private Fenetre fen;
	private JPanel panCon; //Panel general de connexion
	private JPanel pan_saisieClient; //Panel general de la saisieClient
	private JPanel panNClient;
	private JPanel panPassField;
	private JPanel panPwd; //Panel general du mot de passe
	private JPanel boitier; //panel de la matrice
	private JPanel panLabelPwd;
	private JPanel panValid;
	private JPanel panReset;
	private JLabel nClient; //Label du numero client
	private JLabel labelDmdPwd;
	private JLabel labelPwd;
	private JTextField num_client; //Champ du numero client
	private JPasswordField champPwd; //champ du pwd
	JButton[] button; //tableau des boutons pour le boitier
	private JButton valider;
	private JButton reset;
	
	private Dimension taille_case = new Dimension(50,40); //Dimension d'une case

	/**
	 * @param f Fenetre parent
	 * 
	 */
	public Connexion(Fenetre f) {
		super();
		// TODO Auto-generated constructor stub
		fen = f;
		
		panCon = new JPanel(); 
		panCon.setPreferredSize(fen.getSize()); //prend la taille du frame
		//panCon.setBackground(Color.orange);
		
		pan_saisieClient = new JPanel(); //panel pour la saisie
		
		panNClient = new JPanel();
		nClient=new JLabel("Numero Client");
		num_client = new JTextField("", 11);
		
		panPassField = new JPanel();
		labelPwd = new JLabel("Password");
		champPwd = new JPasswordField(5);

		
		panPwd = new JPanel(); //panel pour le mdp	
		panLabelPwd = new JPanel();
		boitier = new JPanel();
		labelDmdPwd = new JLabel("Veuillez entrer votre code secret");
		button = new JButton[25];
		
		panValid = new JPanel();
		valider = new JButton(new ValiderConnexion(this, fen, "Valider"));
		
		panReset = new JPanel();
		reset = new JButton(new ResetPassword(this,"Reset"));
		
	}
	
	/**
	 * cree le panel de connexion
	 * @return panCon 
	 */
	public JPanel init(){
		pan_saisieClient.setLayout(new GridBagLayout());
		pan_saisieClient.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
		//pan_saisieClient.setBackground(Color.CYAN);
		
		panNClient.add(nClient);
		panNClient.add(num_client);
		
		panPassField.add(labelPwd);
		
		champPwd.setEchoChar('*');
		champPwd.setEditable(false);
		panPassField.add(champPwd);
		panValid.add(valider);
		
		pan_saisieClient.add(panNClient);
		pan_saisieClient.add(panPassField);
		pan_saisieClient.add(panValid);

		
		Dimension taille_panPwd = new Dimension(300, 350);
		panPwd.setPreferredSize(taille_panPwd);
		//panPwd.setBackground(Color.green);
		//panLabelPwd.setBorder(BorderFactory.createLineBorder(Color.BLUE,5));
		panLabelPwd.add(labelDmdPwd);
		
		boitier.setLayout(new GridLayout(5,5));
		//boitier.setBackground(Color.blue);
		
		for(int i = 0; i<button.length; i++){
			button[i] = new JButton(); //chaque case du tableau devient un bouton
			button[i].setPreferredSize(taille_case); //definie la taille de chaque case
			boitier.add(button[i]); //ajout au panel dediŽ a la matrice du boitier
			
		}
		
		//Transforme le tableau numero en un arraylist
		ArrayList<String> num_list = new ArrayList<String>(Arrays.asList(numero));
		Random r = new Random();
		
		int cmpt = 0; //compteur pour ne pas depasser les 10 chiffres
		int choix_cases = 0; //variable pour choisir quel bouton aura un chiffre
		int choix_chiffres = 0; //variable pour selectionner le chiffre de l'arraylist
		
		while(cmpt<10){
			choix_cases = r.nextInt(24); //random sur 24 (pour 25 cases)
			choix_chiffres = r.nextInt(num_list.size()); //random sur la taille du tableau restant
			
			if(button[choix_cases].getText() == ""){
				button[choix_cases].setText(num_list.get(choix_chiffres));
				button[choix_cases].addActionListener(new AffichagePwd(this, num_list.get(choix_chiffres)));
				num_list.remove(choix_chiffres);
				cmpt++;
			}
		}
		
		panReset.add(reset);
		
		panPwd.add(panLabelPwd);
		panPwd.add(boitier);
		panPwd.add(panReset);
		
		panCon.add(pan_saisieClient);
		panCon.add(panPwd);
		
		
		return panCon;
	}

	/**
	 * @return the num_client
	 */
	public JTextField getNum_client() {
		return num_client;
	}


	/**
	 * @return the champPwd
	 */
	public JPasswordField getChampPwd() {
		return champPwd;
	}


	
	
}
