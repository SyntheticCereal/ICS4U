package graphics;

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;


public class GridLayoutTest {
	public static void main (String[] args)
	{
		new GridLayoutTest();
	}

	JFrame window;
	GridLayoutTest(){
		window = new JFrame("Flow Layout");
		window.setSize(600,600);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JPanel panel = new JPanel();
		panel.setBackground(Color.YELLOW);

		panel.setLayout(new GridLayout(2,3));
		//Defaults to flow layout
		for (int i = 0; i < 7; i++) {
			panel.add(new JButton("HELLO!!! " + i));
		}

		window.add(panel);

		//Have to make it visible
		window.setVisible(true);
	}
}