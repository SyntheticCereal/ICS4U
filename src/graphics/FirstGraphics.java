package graphics;

import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class FirstGraphics {

	public static void main(String[] args) {
		new FirstGraphics();
	}
	JFrame window;
	FirstGraphics(){
		window = new JFrame("I Love Graphics");
		window.setSize(800,600);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.YELLOW);
		panel.add(new JLabel("Welcome!"));
		JButton btnl = new JButton("Okay");
		panel.add(btnl);
		
		window.add(panel);
		
		//Have to make it visible
		window.setVisible(true);
	}

}
