/**
 * 
 */
package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * @author slim
 *
 */
public class SaisieClient extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//TO DO...
	private JPanel pan_saisieClient;
	private JLabel text, num_client;
	private JTextField box1;
	
	public SaisieClient(){
		pan_saisieClient = new JPanel();
		pan_saisieClient = saisieClientSection();
	}

	public JPanel getPanSAisieClient(){
		return pan_saisieClient;
	}
	
	private JPanel saisieClientSection() {
		// TODO Auto-generated method stub
		JPanel panelSaisie = new JPanel();
		panelSaisie.setLayout(new FlowLayout());
		//panelSaisie.setLayout(new GridLayout(2,2));
		
		text = new JLabel("Saisir votre numero client\t");
		num_client = new JLabel("\tNumero Client : ");
		
		box1 = new JTextField("",2);
		box1.setEditable(true);
		
		panelSaisie.add(text);
		panelSaisie.add(num_client);
		panelSaisie.add(box1);
		panelSaisie.setBackground(Color.GRAY);
		this.setVisible(true);
		return panelSaisie;
	}
}
