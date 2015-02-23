/**
 * 
 */
package controller;

import java.util.ArrayList;

import view.Fenetre;
import model.Client;
import model.Comptes;
import model.FichierClients;

/**
 * @author slim
 *
 */
public class testMain {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*ArrayList<Client> tmp = new ArrayList<Client>();
		int nc[]= {1,2,3,4,5,6,7,8,9};
		int mdp[] = {1,2,3,4};
		Client c1 = new Client("Lim","Steffie",nc,mdp);
		
		FichierClients fic = new FichierClients();
		tmp = fic.loadFile("./Resources/test_fichierclient.csv");
		
		
		for (Client c : tmp){
			System.out.println(c);
		}	
		
		//System.out.println(c1);
		 */

		//Fenetre f = new Fenetre();
		
		Comptes compte1 = new Comptes("Livret A");
		Comptes livret_j = new Comptes("Livret Jeune", 200);
 		
		System.out.println(compte1);
		System.out.println(livret_j);
		
		System.out.println("livret_j decouvert "+livret_j.isEst_a_decouvert());
		
		
		livret_j.versement(compte1, 300);
		
		System.out.println("versement de 300");
		
		System.out.println(compte1);
		System.out.println(livret_j);
		
		livret_j.versement(compte1,250);
		
		System.out.println(compte1);
		System.out.println(livret_j);
		
		

	}

}
