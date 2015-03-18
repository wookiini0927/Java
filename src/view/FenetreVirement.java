/**
 * 
 */
package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
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
	private JPanel panResume; //panCompte+panVirement
	private JPanel panComptes; //panel des comptes client et beneficiaire
	private JPanel panVirement; //panel de questionnaire du virement
	private JPanel panLib, panChampLib;
	private JPanel panMontant, panMontLib;
	private JPanel panLabDate, panRadioBut;
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
		
		panTotal = new JPanel();

		panInfo = new JPanel();

		num_client = new JLabel(info[0]);
		nom_client = new JLabel(info[2]);
		prenom_client = new JLabel(info[3]);
		newCompte = new JButton(/*new createCompte(*/"Ajouter Compte")/*)*/;

		//panTotal.setLayout(fen.getCl());
		
//		num_client = new JLabel(numero);
		
		//panel compte + versement
		panResume = new JPanel();
		
		panComptes = new JPanel();
		
		compteDeb = new JLabel("Compte a debiter");
		compteVir = new JLabel("Compte a crediter");
		comptePerso = new JComboBox<String>(FichierComptes.initComptesPerso(fc.getListe_comptes()));
		compteBeneficiaire = new JComboBox<String>(FichierComptes.initComptesPerso(benef.getListe_comptes()));
		
		panVirement = new JPanel();
		
		panLib = new JPanel();
		panChampLib = new JPanel();
		panMontant = new JPanel();
		panMontLib = new JPanel();
		panLabDate = new JPanel();
		panRadioBut = new JPanel();
		
		libelle_virement = new JLabel("Libelle ");
		labMontant = new JLabel("Montant ");
		lab_date_Virement = new JLabel("Date d'effet du virement ");
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
		panInfo.setPreferredSize(taille_info);
		panInfo.setBackground(Color.WHITE);
		panInfo.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
		
		panInfo.add(nom_client);
		panInfo.add(prenom_client);
		panInfo.add(newCompte);
		
		
		panResume.setLayout(new GridLayout(2,1));
		
		//Panel des resumes de comptes et preference benificiaire
		panComptes.setPreferredSize(taille_panComptes);
		panComptes.setLayout(new GridLayout(2,2));
		panComptes.setBorder(BorderFactory.createLineBorder(Color.BLUE, 2));
		
		comptePerso.setEditable(false);
		compteBeneficiaire.setEditable(false);
		
		panComptes.add(compteDeb);
		panComptes.add(compteVir);
		panComptes.add(comptePerso);
		panComptes.add(compteBeneficiaire);
		
		GridLayout gl = new GridLayout(3,2);
		panVirement.setPreferredSize(taille_panVir);
		panVirement.setLayout(gl);
		panVirement.setBorder(BorderFactory.createLineBorder(Color.BLACK,1));
		panVirement.setBackground(Color.GREEN);

		FlowLayout align_gauche = new FlowLayout(FlowLayout.LEFT);
		FlowLayout align_droit = new FlowLayout(FlowLayout.RIGHT);

		panLib.setLayout(align_droit);
		panLib.add(libelle_virement);
		panChampLib.setLayout(align_gauche);
		panChampLib.add(champ_libelle);	
		
		panMontant.setLayout(align_droit);
		panMontant.add(labMontant);
		panMontLib.setLayout(align_gauche);
		panMontLib.add(champMontant);
		panMontLib.add(lab_euro);	
		
		panLabDate.setLayout(align_droit);
		panLabDate.add(lab_date_Virement);
		
		immediat = new JRadioButton("Immediat");
		immediat.setSelected(true);
		different = new JRadioButton("Differe");
		ButtonGroup bg = new ButtonGroup();
		bg.add(immediat);
		bg.add(different);
		
		panRadioBut.add(immediat);
		panRadioBut.add(different);
		
		panVirement.add(panLib);
		panVirement.add(panChampLib);
		panVirement.add(panMontant);
		panVirement.add(panMontLib);
		panVirement.add(panLabDate);
		panVirement.add(panRadioBut);

		panResume.add(panComptes);
		panResume.add(panVirement);
		
		
		panTotal.add(panInfo, BorderLayout.EAST);
		panTotal.add(panResume,BorderLayout.NORTH);
		//panTotal.add(panVirement/*,BorderLayout.WEST*/);
		
		return panTotal;
	}
	
}
