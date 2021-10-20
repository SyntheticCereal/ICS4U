package graphics;

import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class FlowLayoutTest {
	public static void main (String[] args)
	{
		new FlowLayoutTest();
	}

	JFrame window;
	FlowLayoutTest(){
		window = new JFrame("Flow Layout");
		window.setSize(400,400);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JPanel panel = new JPanel();
		panel.setBackground(Color.YELLOW);

		//Defaults to flow layout
		for (int i = 0; i < 10; i++) {
			panel.add(new JButton("HELLO!!!"));
		}

		window.add(panel);

		//Have to make it visible
		window.setVisible(true);
	}
}
