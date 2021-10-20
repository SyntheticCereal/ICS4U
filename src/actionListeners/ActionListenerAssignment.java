package actionListeners;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class ActionListenerAssignment implements ActionListener, ChangeListener{

	final int blueMin = 0;
	final int blueMax = 255;
	final int blueInit = 0;

	public static void main(String[] args) {
		new ActionListenerAssignment ();
	}

	JFrame window = new JFrame ("Event Demo");
	JPanel panel = new JPanel ();
	JLabel title = new JLabel("Hello");

	ActionListenerAssignment () {
		window = new JFrame ("Event Demo");
		window.setSize(500, 600);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JButton btnExit = new JButton("Exit");
		btnExit.addActionListener(new MyAl());
		btnExit.setActionCommand("Exit");

		panel = new JPanel();
		JButton button = new JButton ("Yes");
		button.addActionListener(new MyAl() ); //Step 1

		JButton white = new JButton("White");
		white.addActionListener(new MyAl2());
		
		JButton black = new JButton("Black");
		black.addActionListener(new MyAl3());
		
		JButton titleBtn = new JButton("Title");
		titleBtn.addActionListener(new MyAl2());
		titleBtn.addActionListener(new MyAl3());

		JSlider colorSlider = new JSlider(JSlider.HORIZONTAL, blueMin, blueMax, blueInit);
		colorSlider.addChangeListener(this);
		colorSlider.setMajorTickSpacing(50);
		colorSlider.setMinorTickSpacing(1);
		colorSlider.setPaintTicks(true);
		colorSlider.setPaintLabels(true);

		panel.add(title);
		panel.add(titleBtn);
		panel.add(button);
		panel.add(black);
		panel.add(white);
		panel.add(btnExit);
		panel.add(colorSlider);
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

			if (e.getActionCommand().equals("Exit")) {
				window.dispose();
				//System.exit(0); only for emergencies;
			}

			numsClick++;
			window.setTitle (numsClick + " clicks");
			panel.setBackground(Color.RED);
			if (numsClick%2 == 0) {
				panel.setBackground(Color.GREEN);
			}
		}

	}

	class MyAl2 implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			if (e.getActionCommand().equals("White")) {
				panel.setBackground(Color.WHITE);
			}
			if (e.getActionCommand().equals("Title")) {
				title.setText("Hi!");
			}
		}
	}
	
	class MyAl3 implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			if (e.getActionCommand().equals("Black")) {
				panel.setBackground(Color.BLACK);
			}
			
			if (e.getActionCommand().equals("Title")) {
				title.setFont(new Font ("Comic Sans MS", Font.BOLD, 20));
			}
		}
	}

	@Override
	public void stateChanged(ChangeEvent e) {
		JSlider source = (JSlider)e.getSource();
		Color customColor1 = new Color(0,0,0);
		if (!source.getValueIsAdjusting()) {
			int blue = (int)source.getValue();
			customColor1 = new Color(0,0, blue);
			panel.setBackground(customColor1);
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
	}
}