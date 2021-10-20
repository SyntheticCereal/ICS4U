package timerprograms;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.Timer;

public class SimpleTimer {

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				new SimpleTimer();
			}
		} );

	}
	
	JLabel label = new JLabel("Time: ");
	Timer timer1 = new Timer(1000, new TimerAl());
	
	SimpleTimer () {
		JFrame window = new JFrame ("Time Example");
		window.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		window.setSize(700, 500);
		JPanel panel = new JPanel();
		
		panel.add(label);
		window.add(panel);
		
		window.setVisible(true);
		timer1.start();
	}
	
	class TimerAl implements ActionListener {
		int seconds = 0;
		
		@Override
		public void actionPerformed(ActionEvent e) {
			seconds++;
			label.setText("Time: " + seconds);
		}
	}
}
