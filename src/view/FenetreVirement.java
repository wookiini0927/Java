/**
 * 
 */
package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagLayout;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import controller.Refresh;
import model.Comptes;
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
	private FichierComptes fc, benef;
	private Fenetre fen;
	private JPanel panTotal; //panel de tous les elements
	private JPanel panInfo; //panel de gauche info du client et divers options
	private JPanel panComptes; //panel total des comptes virement et du client
	private JPanel panVirement; //panel de questionnaire du virement
	private JPanel panLib;
	private JPanel panResume;
	private JLabel num_client, nom_client, prenom_client;
	private JLabel compteDeb, compteVir;
	private JLabel libelle_virement, labMontant, lab_date_Virement, lab_euro;
	private JTextField champMontant, champ_libelle;
	private JButton newCompte;
	private JRadioButton immediat, different;
	private JComboBox<String> comptePerso, compteBeneficiaire;
	
	public FenetreVirement(Fenetre f){
		super();
		this.fen = f;
	}

	public FenetreVirement(Fenetre fen, String[] info) {
		super();
		this.fen = fen;
		numero = info[0];
		fc = new FichierComptes();
		fc = FichierComptes.loadFile("Doc/"+numero+".csv");
		benef = new FichierComptes();
		benef = FichierComptes.loadFile("Doc/CompteBeneficiaire"+numero+".csv");
		
		num_client = new JLabel(info[0]);
		nom_client = new JLabel(info[2]);
		prenom_client = new JLabel(info[3]);
		newCompte = new JButton(/*new createCompte(*/"Ajouter Compte")/*)*/;

		panTotal = new JPanel();
		//panTotal.setLayout(fen.getCl());
		
		panInfo = new JPanel();
		num_client = new JLabel(numero);
		
		
		//panel compte + versement
		panResume = new JPanel();
		panComptes = new JPanel();
		compteDeb = new JLabel("Compte a debiter");
		compteVir = new JLabel("Compte a crediter");
		comptePerso = new JComboBox<String>(FichierComptes.initComptesPerso(fc.getListe_comptes()));
		compteBeneficiaire = new JComboBox<String>(FichierComptes.initComptesPerso(benef.getListe_comptes()));
		
		panVirement = new JPanel();
		panLib = new JPanel();
		libelle_virement = new JLabel("Libelle");
		labMontant = new JLabel("Montant : ");
		lab_date_Virement = new JLabel("Date d'effet du virement");
		lab_euro = new JLabel("EUR");
		champMontant = new JTextField("",10);
		champ_libelle = new JTextField("",10);

		init();
	}
	
	public void init(){
		fen.setTitle("Compte Bancaire " + numero);
		fen.setSize(700, 500);
		fen.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		fen.setLocationRelativeTo(null);
		
		panTotal = buildContentPane();
	}
	
	public JPanel buildContentPane(){
		Dimension taille_info = new Dimension(180,450);
		Dimension taille_panComptes = new Dimension(450,200);
		Dimension taille_panVir = new Dimension(450,200);
		
		panTotal.setBackground(Color.red);
		//Panel d'info sur le client a gauche
		panInfo.add(nom_client);
		panInfo.add(prenom_client);
		panInfo.add(newCompte);
		panInfo.setPreferredSize(taille_info);
		panInfo.setBackground(Color.WHITE);
		panInfo.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
		
		
		panResume.setLayout(new GridLayout(2,1));
		//Panel des resumes de comptes et preference benificiaire
		panComptes.setPreferredSize(taille_panComptes);
		panComptes.setLayout(new GridLayout(2,2));
		panComptes.setBorder(BorderFactory.createLineBorder(Color.BLUE, 2));
		
		
		comptePerso.setEditable(false);
		compteBeneficiaire.setEditable(false);
		//comptePerso.setBorder(BorderFactory.createLineBorder(Color.black, 1));
		//compteBeneficiaire.setBorder(BorderFactory.createLineBorder(Color.black, 1));
		
		panComptes.add(compteDeb);
		panComptes.add(compteVir);
		panComptes.add(comptePerso);
		panComptes.add(compteBeneficiaire);
		
		//GridLayout gl = new GridLayout(3,2);
		panVirement.setPreferredSize(taille_panVir);
		panVirement.setLayout(new GridBagLayout());
		panVirement.setBorder(BorderFactory.createLineBorder(Color.BLACK,1));
		//panVirement.add(libelle_virement);
		
		panVirement.setLayout(new GridBagLayout());
		panVirement.setBackground(Color.GREEN);
		panVirement.add(libelle_virement);
		panVirement.add(champ_libelle);		
		//panVirement.add(panLib);
		
		panVirement.add(labMontant);
		panVirement.add(lab_euro);

		panVirement.add(champMontant);
		panVirement.add(lab_date_Virement);
		
		immediat = new JRadioButton("Immediat");
		immediat.setSelected(true);
		different = new JRadioButton("Differe");
		
		ButtonGroup bg = new ButtonGroup();
		bg.add(immediat);
		bg.add(different);
		
		/*panVirement.add(immediat);
		panVirement.add(different);*/

		panResume.add(panComptes);
		panResume.add(panVirement);
		
		
		panTotal.add(panInfo, BorderLayout.EAST);
		panTotal.add(panResume,BorderLayout.NORTH);
		//panTotal.add(panVirement/*,BorderLayout.WEST*/);
		
		return panTotal;
	}
	
}
