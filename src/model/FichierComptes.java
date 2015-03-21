/**
 * 
 */
package model;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author Steffie Lim
 *
 */
public class FichierComptes {
	ArrayList<Comptes> liste_comptes;
	
	public FichierComptes(){
		liste_comptes = new ArrayList<Comptes>();
	}

	/**
	 * @return the liste_comptes
	 */
	public ArrayList<Comptes> getListe_comptes() {
		return liste_comptes;
	}

	/**
	 * @param liste_comptes the liste_comptes to set
	 */
	public void setListe_comptes(ArrayList<Comptes> liste_comptes) {
		this.liste_comptes = liste_comptes;
	}
	
	public static FichierComptes loadFile(String fileName){
		FichierComptes list_compt = new FichierComptes();
		InputStream is = null;
		BufferedReader br = null;
		String line;
		String[] words;
		//File csvFic = new File(fileName);
		
		try{
			is = new FileInputStream(fileName);
			InputStreamReader isr = new InputStreamReader(is);
			br = new BufferedReader(isr);

			while((line=br.readLine())!=null){
				words = line.split(";");
				list_compt.liste_comptes.add(new Comptes(words[0],words[1],Double.parseDouble(words[3]), Double.parseDouble(words[4]), Integer.parseInt(words[2])));
			}
			br.close();
		}
		catch(Exception e){
			System.err.println("Error : "+e.getMessage());
			return null;
		}
		
		
		return list_compt;
	}
	
	public static String[] initComptesPerso(ArrayList<Comptes> liste){
		String[] CompteDebit = new String[liste.size()];
		
		for(int i = 0; i<liste.size(); i++){
			CompteDebit[i] = liste.get(i).toString();
		}
		return CompteDebit;
	}

}
