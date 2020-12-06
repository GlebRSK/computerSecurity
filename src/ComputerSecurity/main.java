package ComputerSecurity;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import ComputerSecurity.Alg1;
public class main {
	public static JFrame frame = new JFrame("Test frame");//общая рамка
	public static JPanel ComboPanel = new JPanel();
	public static JComboBox<Algorithm_type> ItemBox = new JComboBox<Algorithm_type>(Algorithm_type.values());
	public static void Inter() {
		ComboPanel.setLayout(null);
		JFrame.setDefaultLookAndFeelDecorated(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setPreferredSize(new Dimension(1366, 786));
		ComboPanel.add(ItemBox);
		ItemBox.setBounds(483, 293, 400, 100);
		frame.add(ComboPanel);
		Choose();
		frame.pack();
		frame.setVisible(true);
	}
	public static void main(String[] args) {
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			
			@Override
			public void run() {
				Inter();		
			}
		});
	}
	public static void Choose(){
		ItemBox.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				switch (ItemBox.getSelectedIndex()) {
				case 0: 
					ComboPanel.setVisible(false);
					Caesar.InterfaceCaeser();
					break;
				case 1:
					ComboPanel.setVisible(false);
					Alg1.RapidPOWInterface();
					break;
				case 2:
					ComboPanel.setVisible(false);
					Euclid.EuclidInterface();
					break;
				case 3:
					ComboPanel.setVisible(false);
					DiffieHellman.DiffieHelmanInterface();
					break;
				case 4:
					ComboPanel.setVisible(false);
					Elgamal.ElgamalInterface();
					break;
				case 5:
					break;
				case 6:
					break;
				default:
					break;
				}
			}
		});
	}
}

