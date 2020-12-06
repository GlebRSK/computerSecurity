package ComputerSecurity;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Caesar {
	public static void InterfaceCaeser() {
		final JPanel panel = new JPanel();
		panel.setLayout(null);
		
		JLabel Title = new JLabel("Caesar cipher");
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
			textField1.setBounds(50, 120, 500, 30);
			
		final JTextField textField2 = new JTextField();
			panel.add(textField2);
			textField2.setBounds(570, 120, 50, 30);
		
		JLabel lab1 = new JLabel("Enter you message:");//надписи
			panel.add(lab1); lab1.setHorizontalAlignment(JLabel.CENTER);
			lab1.setBounds(50, 100, 550, 10);
			
		JLabel lab2 = new JLabel("Key:");
			panel.add(lab2); lab2.setHorizontalAlignment(JLabel.CENTER);
			lab2.setBounds(570, 100, 50, 10);
			
		CalculateButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				final JTextField textField3 = new JTextField();
				textField3.setBounds(50, 180, 500, 30);
				panel.add(textField3);
				
				JLabel lab3 = new JLabel("Your encrypted message:");
				lab3.setBounds(50, 160, 500, 30); lab3.setHorizontalAlignment(JLabel.CENTER);
				panel.add(lab3);
				textField3.setText(EncryptCaesar(textField1.getText(), Integer.parseInt(textField2.getText())));
				JButton DecryptButton = new JButton("DecryptButton");
				
				DecryptButton.setBounds(50, 240, 140, 30);
				panel.add(DecryptButton);
				DecryptButton.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						final DefaultListModel<String> listmodel = new DefaultListModel<String>();
						final JList<String> DecryptList = new JList<String>(listmodel);
						DecryptList.setBounds(700, 50, 560, 600);
						panel.add(DecryptList);
						
						final JButton add = new JButton("Add");
							add.setBounds(700, 650, 280, 30);
							panel.add(add);
						
						final JButton enough = new JButton("Enough");
							enough.setBounds(980, 650, 280, 30);
							panel.add(enough);
							
							add.addActionListener(new ActionListener() {
								int i = 1;
								
								@Override
								public void actionPerformed(ActionEvent e) {
								listmodel.addElement(DecryptCaesar(textField3.getText(),i));
								i++;
								
								}
							});
							enough.addActionListener(new ActionListener() {	
								
								@Override
								public void actionPerformed(ActionEvent e) {
									String s = "Congratulations! " 
											+ listmodel.getElementAt(listmodel.size() - 1)
											+ " is you decrypt the message.";
									listmodel.addElement(s);
								}
							});
					}
				});
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
	public static String EncryptCaesar(String message, int key) {
		char[] s = message.toLowerCase().toCharArray();
		String sCaeser = "";
		for(int i = 0; i < s.length; i++) {
			if (key > 0) {
				if (!Character.toString(s[i]).equals(" ")) {
					if (key + (int)s[i] > (int)'z') {
						int key1 = (int)s[i] + key - (int)'z' - 1; 
						sCaeser = sCaeser + (char)((int)'a' + key1);
					} 
					else {
						sCaeser = sCaeser + (char)((int)s[i] + key);
					}		
				} 
				else {
					sCaeser = sCaeser + (char)s[i];
				}
			} 
			else {
				if (!Character.toString(s[i]).equals(" ")) {
					if (key + (int)s[i] < (int)'a') {
						int key1 = (int)s[i] + key - (int)'a' + 1; 
						sCaeser = sCaeser + (char)((int)'z' + key1);
					} 
					else {
						sCaeser = sCaeser + (char)((int)s[i] + key);
					}		
				} 
				else {
					sCaeser = sCaeser + (char)s[i];
				}
			}
		}
		return sCaeser;
	}
	public static String DecryptCaesar(String message, int i) {
		char[] s = message.toLowerCase().toCharArray();
		String dCaeser = "";
		for (int j = 0; j < message.length(); j++) {
			if (!Character.toString(s[j]).equals(" ")) {
				if (i + (int)s[j] > (int)'z') {
					int key1 = (int)s[j] + i - (int)'z' - 1; 
					dCaeser = dCaeser + (char)((int)'a' + key1);
				} 
				else {
					dCaeser = dCaeser + (char)((int)s[j] + i);
				   }		
			} 
			else {
				dCaeser = dCaeser + (char)s[j];
			}
		}
	return dCaeser;
	}
}