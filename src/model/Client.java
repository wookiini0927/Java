package model;

import java.util.ArrayList;

public class Client {
	
	private String nom;
	private String prenom;
	private int numeroClient[];
	private int pwd[];
	private ArrayList<Comptes> tab_comptes;
	
	/**
	 * @param nom le nom du client
	 * @param prenom  le prenom client
	 * @param numeroClient le numero client de longueur 9
	 * @param pwd le code secret du client de longueur 4
	 */
	public Client(String nom, String prenom, int numeroClient[], int pwd[]) {
		this.nom = nom;
		this.prenom = prenom;
		this.numeroClient = new int[9];
		this.numeroClient = numeroClient;
		this.pwd = new int[4];
		this.pwd = pwd;
		this.tab_comptes = new ArrayList<Comptes>();
	}

	/**
	 * @return the nom
	 */
	public String getNom() {
		return nom;
	}

	/**
	 * @param nom the nom to set
	 */
	public void setNom(String nom) {
		this.nom = nom;
	}

	/**
	 * @return the prenom
	 */
	public String getPrenom() {
		return prenom;
	}

	/**
	 * @param prenom the prenom to set
	 */
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	/**
	 * @return the numeroClient
	 */
	public int[] getNumeroClient() {
		return numeroClient;
	}

	/**
	 * @param numeroClient the numeroClient to set
	 */
	public void setNumeroClient(int numeroClient[]) {
		this.numeroClient = numeroClient;
	}

	/**
	 * @return the pwd
	 */
	public int[] getPwd() {
		return pwd;
	}

	/**
	 * @param pwd the pwd to set
	 */
	public void setPwd(int pwd[]) {
		this.pwd = pwd;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	public String toString() {
		String nc="";
		String mdp="";
		
		for(int i=0; i<getNumeroClient().length; i++){
			nc += this.numeroClient[i];
		}
		
		for(int i=0; i<getPwd().length; i++){
			mdp += this.pwd[i];
		}
		return "Le Client " + nom + " " + prenom + ": numeroClient="
				+ nc + ", pwd=" + mdp;
	}
	
	
}
