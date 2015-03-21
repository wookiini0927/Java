/**
 * 
 */
package model;

import java.io.*;
import java.util.ArrayList;

import javax.swing.JFileChooser;


/**
 * @author slim
 *
 */
public class History {
	
	private ArrayList<String> history;
	private String numero;

	
	public History(String numero) {
		this.numero = numero;
		history = new ArrayList<String>();
		history.add(this.numero+"\n");
		history.add("Libelle;Comptes;IBAN;Debit\n");
		
		
	}
	
	public void addToHistory(String libelle, String Comptes, String Iban, Double montantVerse){
		String strMV = Double.toString(montantVerse);
		String res = libelle+";"+Comptes+";"+Iban+";"+strMV+"\n";
		history.add(res);
	}
	
	/**
	 * 
	 * @param path
	 * @throws IOException
	 */
	public void saveHistory(Double montantActuel) throws IOException{
		File dest = new File("Doc/History"+numero+".csv");
		BufferedWriter output = new BufferedWriter(new FileWriter(dest));
		int line = 0;
		while(line<history.size()){
			
		
			try{
				output.write(history.get(line),0,history.get(line).length());	
			}
			catch(IOException e){
				e.printStackTrace();
			}
			line++;
		}
		output.close();
		
	}
}
