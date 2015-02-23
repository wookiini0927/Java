package view;

import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class PadPass extends JFrame {
	
	String numero[] = {"0","1","2","3","4","5","6","7","8","9"};
	
	JButton[][] button = new JButton[5][5];
	//private JLabel name_case = new JLabel();
	//private Dimension taille_case = new Dimension(50,50);
	
	public PadPass(){
		this.setResizable(false);	
		for(int i = 0; i<button.length; i++){
			for(int j=0;j<button.length;j++){
				button[i][j] = new JButton(" ");
			}
		}
	}
	
}
