/**
 * 
 */
package model;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author slim
 *
 */
public class FichierClients {
		
	public FichierClients(){
		
	}
	
	/**
	 * Verifie si le numero client n'existe pas deja
	 * Compare le num au numeroclient de chaque client dans c
	 * 
	 * @param c Tableau de Clients
	 * @param num : numeroClient a comparer
	 * @return Si le numero client n'existe pas renvoi false
	 * 			sinon true
	 */
	public boolean verification(ArrayList<Client> c, String num){
		boolean est_egal = false;
		Client cl = null;
		int nc[] = null;
		String tmp="";
		int j=0;

		if (c.isEmpty()){
			return false;
		}
		
		while(j<c.size() && est_egal == false ){
			tmp = "";
			cl = c.get(j);
			nc =cl.getNumeroClient();

			for(int i=0;i<nc.length;i++){
				tmp += Integer.toString(nc[i]);
			}
			
			if(tmp.equals(num)){
				est_egal = true;
			}
			j++;
		}
		return est_egal;
	}
	
	/**
	 * Charge un fichier suppose existant et l'enregistre dans une arrayList<Client>
	 * 
	 * @param fileName
	 * @return un tableau de client
	 */
	public ArrayList<Client> loadFile(String fileName){
		ArrayList<Client> c = new ArrayList<Client>();
		InputStream is = null;
		Scanner sc = null;
		String line;
		String[] words;
		int nClient[] = null;
		int code[] = null;
		boolean exist_deja = false;
		
		try{
			is = FichierClients.class.getClassLoader().getResourceAsStream(fileName);
			sc = new Scanner(is);
			while(sc.hasNext()){
				nClient = new int[9];
				code = new int[4];
				exist_deja = false;
				line = sc.nextLine();
				words = line.split(";");
				if(words.length == 4){
					exist_deja = verification(c, words[0]);
					for (int i = 0; i<4; i++){
						//boucle qui permet de convertir le string en int pour le numeroClient
						for(int k = 0; k<words[0].length();k++){
							nClient[k] = Character.getNumericValue(words[0].charAt(k));
						}
						
						//boucle qui permet de convertir le string en int pour le code
						for(int j = 0; j<words[1].length();j++){
							code[j] = Character.getNumericValue(words[1].charAt(j));
						}
					}

					if(exist_deja == false){
						c.add(new Client(words[2],words[3], nClient, code));
					}
					/*
					 * else{
					 *	 traitement erreur
					 * }
					 */

				}	
			}
			sc.close();
		}
		catch(Exception e){
			System.err.println("Error:"+e.getMessage());
			if(sc!=null){
				sc.close();
			}
			return null;
		}
		return c;
	}

	
}
