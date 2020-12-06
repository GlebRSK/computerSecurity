package ComputerSecurity;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import java.util.Vector;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import ComputerSecurity.Alg1;

public class DiffieHellman {
	public static int Za;
	public static int Zb;
	public static int Ya;
	public static int Yb;
	public static void DiffieHelmanInterface() {
		final JPanel panel = new JPanel();
		panel.setLayout(null);
		
		JButton CalculateButton = new JButton("Calculate");
		CalculateButton.setBounds(300, 50, 140, 30);
		panel.add(CalculateButton);
		
		JButton ExitButton = new JButton("Exit");
		ExitButton.setBounds(300, 300, 140, 50);
		panel.add(ExitButton);
		
		JLabel Title = new JLabel("DIFFIE HELLMAN");
		Title.setBounds(0, 0, 1366, 60);
		Title.setHorizontalAlignment(JLabel.CENTER);
		panel.add(Title);
		
		final JTextField textField1 = new JTextField();//текстовые поля
		panel.add(textField1);
		textField1.setBounds(450, 110, 50, 30);
		
		final JTextField textField2 = new JTextField();
		panel.add(textField2);
		textField2.setBounds(570, 110, 50, 30);
		
		final JTextField textField3 = new JTextField();
		panel.add(textField3);
		textField3.setBounds(300, 110, 100, 30);
		
		JLabel lab1 = new JLabel("Sub A:");//надписи
		panel.add(lab1); lab1.setHorizontalAlignment(JLabel.CENTER);
		lab1.setBounds(450, 95, 50, 15);
		
		JLabel lab2 = new JLabel("Sub B:");
		panel.add(lab2); lab2.setHorizontalAlignment(JLabel.CENTER);
		lab2.setBounds(570, 95, 50, 15);
		
		JLabel lab3 = new JLabel("Xa:");
		panel.add(lab3); 
		lab3.setHorizontalAlignment(JLabel.CENTER);
		lab3.setVerticalAlignment(JLabel.CENTER);
		lab3.setBounds(430, 110, 20, 30);
		
		JLabel lab4 = new JLabel("Xb:");
		panel.add(lab4); 
		lab4.setHorizontalAlignment(JLabel.CENTER);
		lab4.setVerticalAlignment(JLabel.CENTER);
		lab4.setBounds(550, 110, 20, 30);
		
		JLabel lab5 = new JLabel("Enter q:");
		panel.add(lab5);
		lab5.setHorizontalAlignment(JLabel.CENTER);
		lab5.setVerticalAlignment(JLabel.TOP);
		lab5.setBounds(300, 95, 100, 15);
		CalculateButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				DiffieHellman(Integer.parseInt(textField3.getText()), 
						Integer.parseInt(textField1.getText()), 
							Integer.parseInt(textField2.getText()));
				final int[] data = {Ya, Yb, Za, Zb}; 
				final JTextField[] textField = new JTextField[4];
				final JLabel[] label = {new JLabel("Ya:"), new JLabel("Yb:"), new JLabel("Za:"), new JLabel("Zb:")};
				int x = 0, y = 0;
				for(int i = 0; i < 4; i++) {
					if ((i == 1) || (i == 3)) {
						 x = 120;
					} 
					else {
						x = 0;
					}
					if (i == 2) {
						y = 40;
					}
					textField[i] = new JTextField(String.valueOf(data[i]));
					panel.add(textField[i]);
					textField[i].setBounds(450 + x, 150 + y, 50, 30);
					panel.add(label[i]);
					label[i].setBounds(430 + x, 150 + y, 20, 30);
					label[i].setHorizontalAlignment(JLabel.CENTER);
					label[i].setVerticalAlignment(JLabel.CENTER);
				}
				JLabel Congratulations = new JLabel("Congratulations! Za = Zb = " + Za + ". Common key is the same");
				panel.add(Congratulations);
				Congratulations.setBounds(360, 220, 330, 30);
			}
		});
		ExitButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				panel.setVisible(false);
				main.ComboPanel.setVisible(true);
				
			}
		});
		main.frame.add(panel);
	}
	
	public static void DiffieHellman(int q, int Xa, int Xb) {
		int p = 2 * q + 1;
		boolean flag = true;
		
		Random myRand = new Random();
		int g  = myRand.nextInt(p - 1);
		while (flag) {
			if ((g > 1) && (Alg1.RapidPOW(g, q, p) != 1)) {
				Ya = Alg1.RapidPOW(g, Xa, p);
				Yb = Alg1.RapidPOW(g, Xb, p);
			    Za = Alg1.RapidPOW(Yb, Xa, p);
				Zb = Alg1.RapidPOW(Ya, Xb, p);
				flag = false;
			} else {
				g = myRand.nextInt(p - 1);		
			}
		}
	}
}
