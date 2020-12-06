package ComputerSecurity;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import ComputerSecurity.Alg1;
public class Elgamal {
	public static void ElgamalInterface() {
		final JPanel panel = new JPanel();
		panel.setLayout(null);
		
		JButton CalculateButton = new JButton("Calculate");
		CalculateButton.setBounds(50, 50, 140, 30);
		panel.add(CalculateButton);
		
		JButton ExitButton = new JButton("Exit");
		ExitButton.setBounds(300, 300, 140, 50);
		panel.add(ExitButton);
		
		JLabel Title = new JLabel("ElGAMAL");
		Title.setBounds(0, 0, 1366, 60);
		Title.setHorizontalAlignment(JLabel.CENTER);
		panel.add(Title);
		
		final JTextField textField1 = new JTextField();
		panel.add(textField1);
		textField1.setBounds(50, 120, 50, 30);
		
		final JTextField textField2 = new JTextField();
		panel.add(textField2);
		textField2.setBounds(50, 180, 90, 30);
		
		JLabel lab1 = new JLabel("Q");//надписи
		panel.add(lab1); lab1.setHorizontalAlignment(JLabel.CENTER);
		lab1.setBounds(50, 110, 50, 10);
		
		JLabel lab2 = new JLabel("message A:");
		panel.add(lab2); lab2.setHorizontalAlignment(JLabel.CENTER);
		lab2.setBounds(50, 170, 90, 10);
		
		CalculateButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				JTextField textfield3 = new JTextField(String.valueOf(
						Elgamal(Integer.parseInt(textField2.getText()),
								Integer.parseInt(textField1.getText()))));
				panel.add(textfield3);
				textfield3.setBounds(170, 180, 90, 30);
				
				JLabel lab3 = new JLabel("message B:");
				panel.add(lab3);
				lab3.setBounds(170, 170, 90, 10);
				if (Integer.parseInt(textField2.getText()) == Integer.parseInt(textField2.getText())) {
					JLabel lab4 = new JLabel("Congratulations! message A = message B= " + 
										 textfield3.getText() + 
										". Sub B decrypt message from sub A.");
					panel.add(lab4);
					lab4.setBounds(50, 230, 700, 20);
				}
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
	public static int Elgamal(int m, int q) {
		Random myRand = new Random();
		boolean flag = true;
		int p = 2 * q + 1, g = myRand.nextInt(p - 1), k = myRand.nextInt(p - 3) + 1;
		int Cb = myRand.nextInt(p - 4) + 3;
		int _m = 0;
		while (Function.SimpleNumb(Cb)) {
			Cb = myRand.nextInt(p - 4) + 3;
		}
		while(flag) {
			if((g > 1) && (Alg1.RapidPOW(g, q, p) != 1)) {
				int Db = Alg1.RapidPOW(g, Cb, p);
				int r = Alg1.RapidPOW(g, k, p), e = Math.floorMod(m * Alg1.RapidPOW(Db, k, p),p);
				_m = Math.floorMod(e * Alg1.RapidPOW(r, p - 1 - Cb, p), p);
				flag = false;
			} 
			else {
				g = myRand.nextInt(p - 1);
			}
		}
		return _m;
	}
	
}
