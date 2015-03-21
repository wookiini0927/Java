/**
 * 
 */
package model;

import java.lang.Math;
import java.text.DecimalFormat;
import java.util.Random;


import javax.swing.JFrame;
import javax.swing.JOptionPane;

import view.Fenetre;

/**
 * @author slim
 *
 */
public class Comptes {
	private String titre;
	private String IBAN;
	private int type_compte;
	private double solde;
	private double decouvert;
	private boolean est_a_decouvert = false;
	private int cmpt_taxe =0;
	
	/**
	 * Constructeur par defaut
	 * 
	 * @param titre label du compte
	 */
	public Comptes(String titre, int type){
		this.titre = titre;
		this.IBAN = genererCompte();
		this.solde = 0;
		this.decouvert = 0;
		this.type_compte = type;
	}
	
	/**
	 * Constructeur definissant le solde initial
	 * 
	 * @param titre label du compte
	 * @param solde  solde du compte
	 */
	public Comptes(String titre, double solde, int type){
		this.titre = titre;
		this.IBAN = genererCompte();
		this.solde = solde;
		this.decouvert = 0;
		this.type_compte = type;
		
		if(this.solde < this.decouvert){
			this.est_a_decouvert = true;
		}

	}
	
	/**
	 * Constructeur definissant le decouvert autorise
	 * 
	 * @param titre label du compte
	 * @param solde solde du compte
	 * @param decouvert decouvert autorisŽ
	 */
	public Comptes(String titre, double solde, double decouvert, int type){
		this.titre = titre;
		this.IBAN = genererCompte();
		this.solde = solde;
		this.decouvert = decouvert;
		this.type_compte = type;
		
		if(this.solde < this.decouvert){
			this.est_a_decouvert = true;
		}
	}
	
	public Comptes(String titre, String IBAN, double solde, double decouvert, int type){
		this.titre = titre;
		this.IBAN = IBAN;
		this.solde = solde;
		this.decouvert = decouvert;
		
		if(this.solde < this.decouvert){
			this.est_a_decouvert = true;
		}
		
		this.type_compte = type;
	}

	/**
	 * @return the titre
	 */
	public String getTitre() {
		return titre;
	}

	/**
	 * @param titre the titre to set
	 */
	public void setTitre(String titre) {
		this.titre = titre;
	}

	/**
	 * @return the IBAN
	 */
	public String getIBAN() {
		return IBAN;
	}

	/**
	 * @param IBAN the IBAN to set
	 */
	public void setIBAN(String IBAN) {
		this.IBAN = IBAN;
	}

	/**
	 * @return the solde
	 */
	public double getSolde() {
		return solde;
	}

	/**
	 * @param solde the solde to set
	 */
	public void setSolde(double solde) {
		this.solde = solde;
	}

	/**
	 * @return the decouvert
	 */
	public double getDecouvert() {
		return decouvert;
	}

	/**
	 * @param decouvert the decouvert to set
	 */
	public void setDecouvert(double decouvert) {
		this.decouvert = decouvert;
	}
	
	
	/**
	 * @return the est_a_decouvert
	 */
	public boolean isEst_a_decouvert() {
		return est_a_decouvert;
	}

	/**
	 * @param est_a_decouvert the est_a_decouvert to set
	 */
	public void setEst_a_decouvert(boolean est_a_decouvert) {
		this.est_a_decouvert = est_a_decouvert;
	}

	
	/**
	 * @return the type_compte
	 */
	public int getType_compte() {
		return type_compte;
	}

	/**
	 * @param type_compte the type_compte to set
	 */
	public void setType_compte(int type_compte) {
		this.type_compte = type_compte;
	}

	/**
	 * @return the cmpt_taxe
	 */
	public int getCmpt_taxe() {
		return cmpt_taxe;
	}

	/**
	 * @param cmpt_taxe the cmpt_taxe to set
	 */
	public void setCmpt_taxe(int cmpt_taxe) {
		this.cmpt_taxe = cmpt_taxe;
	}

	/**
	 * Generer un numero de compte aleatoire
	 * 
	 * @return num_compte
	 */
	public String genererCompte(){
		String num_compte="";
		Random r = new Random();
		int i = 0;
		while(i<10)
		{
			num_compte += Integer.toString(r.nextInt(10));
			i++;
		}
		return num_compte;
	}
	
	/**
	 * Fonction de versement d'un compte a un autre
	 * 
	 * @param c Compte a credtier
	 * @param verse montant a verser
	 * @return false si le versement a ete fait, true sinon
	 */
	public boolean versement(Comptes c, double verse){	
		boolean done = false;
		
		//Versement alors que l'utilisateur est a decouvert
		if(this.est_a_decouvert == true){
			JFrame fen = new Fenetre("Projet JAVA 2014-2015", 600,400, false);
			int answer = JOptionPane.showConfirmDialog(fen, "Vous etes deja a decouvert!!!!\nVoulez vous poursuivre l'operation?", "Confirmer", JOptionPane.YES_NO_OPTION);
			
			switch(answer){
				case 0:						
					//MAJ du compte crediter
					crediter(c,verse);
					
					//MAJ du compte debiter
					debiter(this,verse);
					//S'il est au dessus du decouvert
					if(this.solde < this.decouvert){
						this.cmpt_taxe++;
					}
							
					done = true;
					break;
				case 1 :
					done = false;
					break;
				default :
					done = false;
					fen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
					break;
			}			
		}	

		//cas ou le montant est superieur au solde actuel
		else if(verse > this.solde){
			JFrame fen = new Fenetre("Projet JAVA 2014-2015", 600,400, false);
			int answer = JOptionPane.showConfirmDialog(fen, "Le versement est superieur ˆ votre solde disponible\nVoulez vous poursuivre l'operation?", "Confirmer", JOptionPane.YES_NO_OPTION);
			
			switch(answer){
				case 0:
					//MAJ du compte crediter
					crediter(c, verse);
					
					//MAJ du compte debiter
					debiter(this,verse);
					this.setEst_a_decouvert(true);
					if(this.solde < this.decouvert){
						this.cmpt_taxe++;
					}
					done = true;
					break;
				case 1 :
					done = false;
					break;
				default :
					done = false;
					fen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
					break;
			}
		}
				
		//Cas ou il n'y a aucun probleme
		else{
			//MAJ du compte crediter
			crediter(c,verse);
			
			//MAJ du compte debiter
			debiter(this,verse);
			JOptionPane.showMessageDialog(null, "Le versement a bien ete pris en compte", "Succes", JOptionPane.OK_OPTION);
			done = true;
		}
		
		return done;
	} 
	
	public void crediter(Comptes c, double montant){
		c.setSolde(c.getSolde()+montant);
		if(c.getSolde() >=0){
			c.setEst_a_decouvert(false);
			c.setCmpt_taxe(0);	
		}
	}

	public void debiter(Comptes c, double montant){
		final double val_taxe = 8.0;

		//MAJ du compte debiter
		if(c.solde>=c.decouvert){	
			c.setSolde(c.solde-montant);
		}
		else{
			c.setSolde(c.solde-montant-taxe(c.cmpt_taxe,val_taxe));
		}
	}
	
	public double taxe(int compteur, double val_taxe){
		return val_taxe*Math.pow(2.0,(double)compteur-1);
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		DecimalFormat df = new DecimalFormat();
		df.setMinimumFractionDigits(2);
		df.setDecimalSeparatorAlwaysShown(false);
		return titre + " " + IBAN + "\t\t\t" + df.format(solde) + "Euros";
	}
	
	
}
