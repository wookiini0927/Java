/**
 * 
 */
package model;

import java.lang.Math;

import java.util.Arrays;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import view.Fenetre;

/**
 * @author slim
 *
 */
public class Comptes {
	private String titre;
	private int numero_compte[] = new int[11];
	private double solde;
	private double decouvert;
	private boolean est_a_decouvert = false;
	private int cmpt_taxe =0;
	
	/**
	 * Constructeur par defaut
	 * 
	 * @param titre label du compte
	 */
	public Comptes(String titre){
		this.titre = titre;
		this.numero_compte = genererCompte();
		this.solde = 0;
		this.decouvert = -400;
	}
	
	/**
	 * Constructeur definissant le solde initial
	 * 
	 * @param titre label du compte
	 * @param solde  solde du compte
	 */
	public Comptes(String titre, double solde){
		this.titre = titre;
		this.numero_compte = genererCompte();
		this.solde = solde;
		this.decouvert = 0;
		
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
	public Comptes(String titre, double solde, double decouvert){
		this.titre = titre;
		this.numero_compte = genererCompte();
		this.solde = solde;
		this.decouvert = decouvert;
		
		if(this.solde < this.decouvert){
			this.est_a_decouvert = true;
		}
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
	 * @return the numero_compte
	 */
	public int[] getNumero_compte() {
		return numero_compte;
	}

	/**
	 * @param numero_compte the numero_compte to set
	 */
	public void setNumero_compte(int[] numero_compte) {
		this.numero_compte = numero_compte;
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
	public int[] genererCompte(){
		int[] num_compte = new int[11];
		Random r = new Random();
		
		for(int i = 0; i<num_compte.length;i++)
		{
			num_compte[i] = r.nextInt(10);
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
			JFrame fen = new Fenetre();
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
			JFrame fen = new Fenetre();
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
		
		String nc="";
		
		for(int i=0; i<getNumero_compte().length; i++){
			nc += this.numero_compte[i];
		}
		return "Comptes [titre=" + titre + ", numero_compte="
				+ nc + ", solde=" + solde
				+ ", decouvert=" + decouvert + ",cmpt_taxe= " + cmpt_taxe + "]";
	}
	
	
}
