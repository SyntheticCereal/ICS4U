package graphics;

import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class ActionListenerProgram {
	public static void main (String[] args) {
		new ActionListenerProgram();
	}
	
	ActionListenerProgram() {
		JFrame frame = new JFrame ("Action Listener");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(700,1000);
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.GREEN);
		
		JButton yesBtn = new JButton("Yes");
	}
}
