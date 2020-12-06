package ComputerSecurity;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import ComputerSecurity.main;
public class Alg1 {
	public static void RapidPOWInterface() {
		final JPanel panel = new JPanel();//панелька
		panel.setLayout(null);//сами задаем координаты
		JButton button1 = new JButton("Calculate"); // кнопка расчета
		JButton button2 = new JButton("EXIT"); //кнопка выхода
		panel.add(button1);// добавляем на панельку
		panel.add(button2);
		button1.setBounds(50, 50, 140, 50);//выставляем границы
		button2.setBounds(300, 300, 140, 50);
		final JTextField textField1 = new JTextField();//текстовые поля
			panel.add(textField1);
			textField1.setBounds(50, 120, 50, 30);
			textField1.setText("0");
		final JTextField textField2 = new JTextField();
			panel.add(textField2);
			textField2.setBounds(140, 120, 50, 30);
			textField2.setText("0");
		final JTextField textField3 = new JTextField();
			panel.add(textField3);
			textField3.setBounds(230, 120, 50, 30);
			textField3.setText("0");
		JLabel lab1 = new JLabel("X");//надписи
			panel.add(lab1); lab1.setHorizontalAlignment(JLabel.CENTER);
			lab1.setBounds(50, 110, 50, 10);
		JLabel lab2 = new JLabel("Y");
			panel.add(lab2); lab2.setHorizontalAlignment(JLabel.CENTER);
			lab2.setBounds(140, 110, 50, 10);
		JLabel lab3 = new JLabel("Z");
			panel.add(lab3); lab3.setHorizontalAlignment(JLabel.CENTER);
			lab3.setBounds(230, 110, 50, 10);
		button1.addActionListener(new ActionListener() {//при нажатии на кнопку
	
			@Override
			public void actionPerformed(ActionEvent e) {
				JTextField QPOWtext = new JTextField(String.valueOf(Alg1.RapidPOW(Integer.parseInt(textField1.getText()), Integer.parseInt(textField2.getText()), 
						Integer.parseInt(textField3.getText()))));//вызов функции возвед. в степень
				panel.add(QPOWtext);
				QPOWtext.setBounds(370, 90, 50, 30);
				int t = (int)Math.ceil(Math.log(Integer.parseInt(textField2.getText()))/Math.log(2));
				JTextField Ttext = new JTextField(String.valueOf(t));
				JLabel Tlab = new JLabel("t");     Tlab.setHorizontalAlignment(JLabel.CENTER);
				panel.add(Ttext);
				panel.add(Tlab);
				Ttext.setBounds(300, 90, 50, 30);
				Tlab.setBounds(300, 80, 50, 10);
				JTextField[] TextArr = new JTextField[t];//массив текстовых значений и надписей
				JLabel[] LabArr = new JLabel[t];
				TextArr[0] = new JTextField(textField1.getText());
				TextArr[0].setBounds(50, 160, 50, 30); 
				panel.add(TextArr[0]);
				LabArr[0] = new JLabel("AO");
				LabArr[0].setBounds(50, 150, 50, 10);     LabArr[0].setHorizontalAlignment(JLabel.CENTER);
				panel.add(LabArr[0]);
				for (int i = 1; i < t; i++) {
					TextArr[i] = new JTextField(String.valueOf(Square(Integer.parseInt(TextArr[i - 1].getText()), 
							Integer.parseInt(textField3.getText()))));
					LabArr[i] = new JLabel("A" + String.valueOf(i)); LabArr[i].setHorizontalAlignment(JLabel.CENTER);
					panel.add(TextArr[i]);
					panel.add(LabArr[i]);
					TextArr[i].setBounds(50 + 90 * i, 160, 50, 30);
					LabArr[i].setBounds(50 + 90 * i, 150, 50, 10);
				}
			}
		});
		button2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				panel.setVisible(false);
				main.ComboPanel.setVisible(true);
			}
		});
		main.frame.add(panel);
	}
	public static int RapidPOW(int a, int b, int c) {
		int k = 1, t;
		t = (int)Math.ceil(Math.log(b)/Math.log(2));
		int[] arr = new int[t];
		String binaryNumb = Integer.toBinaryString(b), split = "";
		String[] SbinaryNumb;
		SbinaryNumb = binaryNumb.split(split);
		arr[t - 1] = a;
		if (SbinaryNumb[t-1].equals("1")) {
			k = arr[t - 1];
		}
		for(int i = t - 2; i >= 0; i--) {
			arr[i] = Square(arr[i + 1], c);
		}
		for(int i = 0; i < t -1; i++) {
			if (SbinaryNumb[i].equals("1")) {
				k *= arr[i];
			}
		}
		k = Math.floorMod(k, c);
		return k;
	}
	public static int Square(int x, int y) {
		x = Math.floorMod((int)Math.pow(x, 2.0), y);
		return x;
	}
	public static void main(String[] args) {
		System.out.println(RapidPOW(16, 9, 23));
	}
}