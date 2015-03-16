/**
 * 
 */
package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import model.FichierComptes;

/**
 * @author Steffie Lim
 *
 */
public class FenetreVirement extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8441863554373191378L;
	private String numero;
	private FichierComptes fc;
	private Fenetre fen;
	private JPanel panTotal;
	private JPanel panInfo;
	private JPanel panComptes;
	private JPanel panComptesVirement;
	private JLabel num_client, nom_client, prenom_client;
	private JButton newCompte, refresh;
	
	public FenetreVirement(Fenetre f){
		super();
		this.fen = f;
	}

	public FenetreVirement(Fenetre fen, String[] info) {
		super();
		this.fen = fen;
		numero = info[0];
		fc = new FichierComptes();
		num_client = new JLabel(info[0]);
		nom_client = new JLabel(info[2]);
		prenom_client = new JLabel(info[3]);
		newCompte = new JButton(/*new createCompte(*/"Creer Compte")/*)*/;
		refresh = new JButton("Refresh");
		
		

		panTotal = new JPanel();
		//panTotal.setLayout(fen.getCl());
		
		panInfo = new JPanel();
		num_client = new JLabel(numero);
		init();
	}
	
	public void init(){
		fen.setTitle("Compte Banquaire " + numero);
		fen.setSize(700, 500);
		fen.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		fen.setLocationRelativeTo(null);
		
		panTotal = buildContentPane();
	}
	
	public JPanel buildContentPane(){
		//fc = fc.loadFile("./Resources/"+numero+".csv");
		Dimension taille_info = new Dimension(200,450);
		panInfo.add(nom_client);
		panInfo.add(prenom_client);
		panInfo.add(newCompte);
		panInfo.add(refresh);
		panInfo.setPreferredSize(taille_info);
		panInfo.setBackground(Color.WHITE);
		panInfo.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
		
		
		
		
		panTotal.add(panInfo, BorderLayout.EAST);
		
		return panTotal;
	}
	
}
