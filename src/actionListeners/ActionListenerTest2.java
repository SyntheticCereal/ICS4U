package actionListeners;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class ActionListenerTest2 implements ActionListener, ChangeListener{

	public static void main(String[] args) {
		new ActionListenerTest2 ();
	}

	final int blueMin = 0;
	final int blueMax = 255;
	final int blueInit = 0;

	JFrame window = new JFrame ("Even Demon");
	JPanel panel = new JPanel ();
	JButton button = new JButton();
	int numsClick = 0;

	ActionListenerTest2 () {
		window = new JFrame ("Event Demo");
		window.setSize(1000, 800);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		panel = new JPanel();
		button = new JButton ("Yes");
		button.addActionListener(this); //Step 1

		JButton btnExit = new JButton("Exit");
		btnExit.addActionListener(this);
		btnExit.setActionCommand("Exit");

		JSlider colorSlider = new JSlider(JSlider.HORIZONTAL, blueMin, blueMax, blueInit);
		colorSlider.addChangeListener(this);
		colorSlider.setMajorTickSpacing(50);
		colorSlider.setMinorTickSpacing(1);
		colorSlider.setPaintTicks(true);
		colorSlider.setPaintLabels(true);

		panel.setBackground(Color.WHITE);
		panel.add(button);
		panel.add(btnExit);
		panel.add(colorSlider);
		window.add(panel);

		window.setVisible(true);

	}
	//inner class
	//Step 2
	//"implements" uses interface


	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand().equals("Exit")) {
			window.dispose();
			//System.exit(0); only for emergencies;
		}

		if (e.getSource() == button) {
			numsClick++;
			window.setTitle (numsClick + " clicks");
			panel.setBackground(Color.RED);
			if (numsClick%2 == 0) {
				panel.setBackground(Color.GREEN);
			}
		}
	}

	public void stateChanged(ChangeEvent e) {
		JSlider source = (JSlider)e.getSource();
		Color customColor1 = new Color(0,0,0);
			if (!source.getValueIsAdjusting()) {
				int blue = (int)source.getValue();
				customColor1 = new Color(0,0, blue);
				panel.setBackground(customColor1);
			}
	}
}
