package ComputerSecurity;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Euclid {
	public static void EuclidInterface() {
		final JPanel panel = new JPanel();
		panel.setLayout(null);
		
		JLabel Title = new JLabel("Euclid");
		Title.setBounds(0, 0, 1366, 60); Title.setHorizontalAlignment(JLabel.CENTER);
		panel.add(Title);
		
		JButton CalculateButton = new JButton("Calculate");
		CalculateButton.setBounds(50, 50, 140, 50);
		panel.add(CalculateButton);
		
		JButton ExitButton = new JButton("Exit");
		ExitButton.setBounds(300, 300, 140, 50);
		panel.add(ExitButton);
		
		final JTextField textField1 = new JTextField();//текстовые поля
		panel.add(textField1);
		textField1.setBounds(50, 120, 50, 30);
		
		final JTextField textField2 = new JTextField();
		panel.add(textField2);
		textField2.setBounds(140, 120, 50, 30);
		
		JLabel lab1 = new JLabel("U");//надписи
		panel.add(lab1); lab1.setHorizontalAlignment(JLabel.CENTER);
		lab1.setBounds(50, 110, 50, 10);
		
		JLabel lab2 = new JLabel("V");
		panel.add(lab2); lab2.setHorizontalAlignment(JLabel.CENTER);
		lab2.setBounds(140, 110, 50, 10);
		
		CalculateButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				JTextField result = new JTextField();
				result.setBounds(230, 120, 50, 30);
				panel.add(result);
				result.setText(String.valueOf(EuAlg(Integer.parseInt(textField1.getText()) - 1, 
						Integer.parseInt(textField2.getText()))));
				
				JLabel Lresult = new JLabel("Result");
				Lresult.setBounds(230, 110, 50, 10); Lresult.setHorizontalAlignment(JLabel.CENTER);
				panel.add(Lresult);
			}
		});
		
		ExitButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				panel.setVisible(false);
				main.ComboPanel.setVisible(true);
			}
		});
		main.frame.add(panel);
	}
	public static int EuAlg(int x, int y) {
		int U = x, V = y, T = Math.floorMod(x, y), q = Math.floorDiv(x, y), i11 = 1, i12 = 0, i21 = 0, i22 = 1;
		while (T != 0) {
			U = V;
			V = T;
			T = Math.floorMod(U, V);
			int temp1 = i21, temp2 = i22;
			i21 = i11 - i21*q;
			i11 = temp1;
			i22 = i12 - i22*q;
			i12 = temp2;
			q = Math.floorDiv(U, V);
		}
		int k;
		if(i22 < 0) {
			k = i22 + x;
		}else {
			k = i22;
		}
		return k;
	}
	public static void main(String[] args) {
		System.out.println(EuAlg(22, 3));
		System.out.println(Math.floorDiv(18, 7));
	}
}