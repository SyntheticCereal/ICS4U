/*
 * Chris Simpauco
 * MigLayout Program
 * Grade Tracker that allows for different inputs
 * Mr Harwood
 * September 9, 2021
 */

package MigLayoutTest;

import java.awt.Color;
import java.awt.Font;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import net.miginfocom.swing.MigLayout;

public class MigLayoutProgram {

	public static void main(String[] args) {
		new MigLayoutProgram();
	}
	
	JLabel title = new JLabel("Grade Tracker");
	JLabel name = new JLabel("Name: ");
	JLabel course = new JLabel("Course:");
	JLabel teacher = new JLabel("Teacher:");
	JLabel school = new JLabel("Select Your School:");
	JLabel grade = new JLabel("Grade (%):");
	JLabel gradeYear = new JLabel("Select Your Grade:");
	
	JTextField firstNameField = new JTextField("First", 10);
	JTextField lastNameField = new JTextField("Last", 15);
	JTextField courseField = new JTextField ("Course", 10);
	JTextField teacherNameField = new JTextField ("Teacher", 10);
	JTextField gradeField = new JTextField ("", 3);
	
	JRadioButton grade9Button = new JRadioButton("Grade 9");
	JRadioButton grade10Button = new JRadioButton("Grade 10");
	JRadioButton grade11Button = new JRadioButton("Grade 11");
	JRadioButton grade12Button = new JRadioButton("Grade 12");
	JRadioButton grade13Button = new JRadioButton("Grade 13");
	
	JButton confirm = new JButton("Confirm");
	JButton cancel = new JButton("Cancel");
	
	String highSchool[] = {"LCSS", "H.B Beal", "A.B Lucas", "Montcalm", "Banting", "Oakridge", "CCH", "MTS", "South", "SAB"};
	JComboBox schoolList = new JComboBox(highSchool);
//	schoolList.addActionListener(this);
	
	MigLayoutProgram() {
		JFrame frame = new JFrame ("School Grade Tracker");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		frame.add(BuildMigDashboard());
		frame.setSize(800,700);
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		frame.pack();
		frame.setVisible(true);
	}

	private JPanel BuildMigDashboard () {
		JPanel panel = new JPanel();
		panel.setLayout(new MigLayout("wrap 3"));
		BuildMigForm(panel);
		return panel;
	}
	
	private void BuildMigForm (JPanel panel) {
		panel.setBackground(Color.WHITE);
		
		panel.add(title, "center, wrap, skip 1");
		title.setFont(new Font ("", Font.PLAIN, 20));
		panel.add(name, "gapy 20");
		panel.add(lastNameField);
		panel.add(firstNameField);
		
		panel.add(course);
		panel.add(courseField, "wrap");
		
		panel.add(teacher);
		panel.add(teacherNameField, "wrap");
		
		panel.add(grade);
		panel.add(gradeField, "wrap");
		
		panel.add(school);
		panel.add(schoolList, "wrap");
		
		
		ButtonGroup group = new ButtonGroup();
		group.add(grade9Button);
		group.add(grade10Button);
		group.add(grade11Button);
		group.add(grade12Button);
		group.add(grade13Button);
		
		panel.add(gradeYear, "wrap, gapy 20");
		panel.add(grade9Button, "wrap");
		panel.add(grade10Button, "wrap");
		panel.add(grade11Button, "wrap");
		panel.add(grade12Button, "wrap");
		panel.add(grade13Button, "wrap");
		
		panel.add(confirm, "skip 2, align right, sizegroup button");
		panel.add(cancel, "skip 2, align right, sizegroup button");
	}
}
