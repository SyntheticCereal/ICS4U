package actionListeners;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class ActionListenerTest {

	public static void main(String[] args) {
		new ActionListenerTest ();
	}

	JFrame window = new JFrame ("Even Demon");
	JPanel panel = new JPanel ();
	
	ActionListenerTest () {
		window = new JFrame ("Event Demo");
		window.setSize(500, 600);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		panel = new JPanel();
		JButton button = new JButton ("Yes");
		button.addActionListener(new MyAl() ); //Step 1
		
		panel.add(button);
		window.add(panel);
		
		window.setVisible(true);;
	}
	
	//inner class
	//Step 2
	//"implements" uses interface
	class MyAl implements ActionListener {
		int numsClick = 0;
		
		@Override
		public void actionPerformed(ActionEvent e) {
			numsClick++;
			window.setTitle (numsClick + " clicks");
			panel.setBackground(Color.RED);
			if (numsClick%2 == 0) {
				panel.setBackground(Color.GREEN);
			}
		}
		
	}
}
