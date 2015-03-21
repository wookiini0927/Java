package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.io.IOException;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import controller.AbandonnerVirement;
import controller.ValiderVirement;
import model.FichierComptes;
import model.History;

/**
 * @author Steffie Lim
 *
 */
public class FenetreVirement extends JPanel {


	private static final long serialVersionUID = -8441863554373191378L;
	
	private String numero;
	private FichierComptes fc, benef;
	private History doc;
	private Fenetre fen;
	private JPanel panTotal; //panel de tous les elements
	private JPanel panInfo; //panel de gauche info du client et divers options
	private JPanel panResume; //panCompte+panVirement
	private JPanel panComptes; //panel des comptes client et beneficiaire
	private JPanel panVirement; //panel de questionnaire du virement
	private JPanel panLib, panChampLib;
	private JPanel panMontant, panMontLib;
	private JPanel panLabDate, panRadioBut;
	private JPanel panBoutonValider, panBoutonAbandon;
	private JLabel num_client, nom_client, prenom_client;
	private JLabel compteDeb, compteVir;
	private JLabel libelle_virement, labMontant, lab_date_Virement, lab_euro;
	private JTextField champMontant, champ_libelle;
	private JButton newCompte, valider, abandon;
	//private JRadioButton immediat, different;
	private JCheckBox immediat;
	private JComboBox<String> ComboBoxComptePerso, ComboBoxCompteBenef;
	
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
		doc = new History(numero);
		
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
		ComboBoxComptePerso = new JComboBox<String>(FichierComptes.initComptesPerso(fc.getListe_comptes()));
		ComboBoxCompteBenef = new JComboBox<String>(FichierComptes.initComptesPerso(benef.getListe_comptes()));
		
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
		
		panBoutonValider = new JPanel();
		panBoutonAbandon = new JPanel();
		valider = new JButton(new ValiderVirement(this,"Valider"));
		abandon = new JButton(new AbandonnerVirement(this,"Abandonner"));

		init();
	}
	
	public void init(){
		fen.setTitle("Compte Bancaire " + numero);
		fen.setSize(800, 600);
		fen.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		fen.setLocationRelativeTo(null);
		
		panTotal = buildContentPane();
	}
	
	public JPanel buildContentPane(){
		Dimension taille_info = new Dimension(180,450);
		Dimension taille_panComptes = new Dimension(600,200);
		Dimension taille_panVir = new Dimension(600,200);
		
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
		
		ComboBoxComptePerso.setEditable(false);
		ComboBoxCompteBenef.setEditable(false);
		
		panComptes.add(compteDeb);
		panComptes.add(compteVir);
		panComptes.add(ComboBoxComptePerso);
		panComptes.add(ComboBoxCompteBenef);
		
		GridLayout gl = new GridLayout(4,2);
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
		
		panRadioBut.setLayout(align_gauche);
		//immediat = new JRadioButton("Immediat", true);
		//immediat.setSelected(true);
		//different = new JRadioButton("Differe");
		
		/*ButtonGroup bg = new ButtonGroup();
		bg.add(immediat);
		bg.add(different);
		panRadioBut.add(immediat);
		panRadioBut.add(different);*/

		immediat = new JCheckBox("Immediat", true);

		panRadioBut.add(immediat);
		
		
		
		panBoutonValider.setLayout(align_droit);
		panBoutonValider.add(valider);
		
		panBoutonAbandon.setLayout(align_gauche);
		panBoutonAbandon.add(abandon);

		
		panVirement.add(panLib);
		panVirement.add(panChampLib);
		panVirement.add(panMontant);
		panVirement.add(panMontLib);
		panVirement.add(panLabDate);
		panVirement.add(panRadioBut);
		panVirement.add(panBoutonValider);
		panVirement.add(panBoutonAbandon);
		
			
		panResume.add(panComptes);
		panResume.add(panVirement);
		
		
		panTotal.add(panInfo, BorderLayout.EAST);
		panTotal.add(panResume,BorderLayout.NORTH);
		
		return panTotal;
	}
	
	

	/**
	 * @return the numero
	 */
	public String getNumero() {
		return numero;
	}

	/**
	 * @param numero the numero to set
	 */
	public void setNumero(String numero) {
		this.numero = numero;
	}

	
	/**
	 * @return the doc
	 */
	public History getDoc() {
		return doc;
	}

	/**
	 * @param doc the doc to set
	 */
	public void setDoc(History doc) {
		this.doc = doc;
	}

	/**
	 * @return the champMontant
	 */
	public JTextField getChampMontant() {
		return champMontant;
	}

	/**
	 * @param champMontant the champMontant to set
	 */
	public void setChampMontant(JTextField champMontant) {
		this.champMontant = champMontant;
	}

	/**
	 * @return the champ_libelle
	 */
	public JTextField getChamp_libelle() {
		return champ_libelle;
	}

	/**
	 * @param champ_libelle the champ_libelle to set
	 */
	public void setChamp_libelle(JTextField champ_libelle) {
		this.champ_libelle = champ_libelle;
	}

	/**
	 * @return the immediat
	 */
	public JCheckBox getImmediat() {
		return immediat;
	}

	/**
	 * @param immediat the immediat to set
	 */
	public void setImmediat(JCheckBox immediat) {
		this.immediat = immediat;
	}

	/**
	 * @return the different
	 */
	/*public JRadioButton getDifferent() {
		return different;
	}*/

	/**
	 * @param different the different to set
	 */
	/*public void setDifferent(JRadioButton different) {
		this.different = different;
	}*/

	/**
	 * @return the ComboBoxComptePerso
	 */
	public JComboBox<String> getComboBoxComptePerso() {
		return ComboBoxComptePerso;
	}

	/**
	 * @param ComboBoxComptePerso the ComboBoxComptePerso to set
	 */
	public void setComboBoxComptePerso(JComboBox<String> ComboBoxComptePerso) {
		this.ComboBoxComptePerso = ComboBoxComptePerso;
	}

	/**
	 * @return the ComboBoxCompteBenef
	 */
	public JComboBox<String> getComboBoxCompteBenef() {
		return ComboBoxCompteBenef;
	}

	/**
	 * @param ComboBoxCompteBenef the ComboBoxCompteBenef to set
	 */
	public void setComboBoxCompteBenef(JComboBox<String> ComboBoxCompteBenef) {
		this.ComboBoxCompteBenef = ComboBoxCompteBenef;
	}

	/**
	 * @return the fc
	 */
	public FichierComptes getFc() {
		return fc;
	}

	/**
	 * @param fc the fc to set
	 */
	public void setFc(FichierComptes fc) {
		this.fc = fc;
	}

	/**
	 * @return the benef
	 */
	public FichierComptes getBenef() {
		return benef;
	}

	/**
	 * @param benef the benef to set
	 */
	public void setBenef(FichierComptes benef) {
		this.benef = benef;
	}
	
	
	
	
	
}
