package graphics;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class BorderLayoutTest {
	public static void main (String []args) {
		new BorderLayoutTest();
	}
	
	BorderLayoutTest() {
		JFrame window = new JFrame ("Border Layout Test");
		window.setSize(900,700);
		window.setLocationRelativeTo(null);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panelW = new JPanel();
		panelW.setBackground(Color.orange);
		panelW.add(new JLabel ("West Panel"));
		window.add(panelW, BorderLayout.WEST);
		
		JPanel panelN = new JPanel();
		panelN.setBackground(Color.red);
		panelN.add(new JLabel ("North Panel"));
		window.add(panelN, BorderLayout.NORTH);
		
		JPanel panelE = new JPanel();
		panelE.setBackground(Color.blue);
		panelE.add(new JLabel ("East Panel"));
		window.add(panelE, BorderLayout.EAST);
		
		JPanel panelS = new JPanel();
		panelS.setBackground(Color.green);
		panelS.add(new JLabel ("South Panel"));
		window.add(panelS, BorderLayout.SOUTH);
		
		JPanel panelC = new JPanel();
		panelC.setLayout(new GridLayout(2,5, 10, 10));
		panelC.setBackground(Color.yellow);
		//panelC.add(new JLabel ("Center Panel"));
		for (int i=0; i <10; i++) {
			panelC.add(new JButton ("Hi"));
		}
		window.add(panelC, BorderLayout.CENTER);
		
		window.setVisible(true);
	}
}
