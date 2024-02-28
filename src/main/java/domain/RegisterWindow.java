package domain;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerDateModel;

public class RegisterWindow extends JFrame {

	public static JLabel labelAddPassword, registerLabel, labelAddLogin, labelAddAgainPassword, addBirthDate, labelAddEmail, addSex;
	public static JTextField addLogin,addEmail;
	public static JPasswordField addPassword, addAgainPassword;
	public static JRadioButton male,female;
	public static JButton register, back;

	public RegisterWindow() {

		setTitle("ToDoNote");
		setSize(700, 700);
		setLayout(null);
		
		back = new JButton("Back");
		back.setBounds(0,0,120,30);
		add(back);
		
	    back.addActionListener(new ActionListener() {
	        @Override
	        public void actionPerformed(ActionEvent e) {
	        	
	        	LoginWindow loginWindow = new LoginWindow();
	    		loginWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    		loginWindow.setLocationRelativeTo(null);
	    		loginWindow.setVisible(true);
	    		dispose();
	        	
	        }
	    });
		

		registerLabel = new JLabel("Fill out the form below to create an account");
		registerLabel.setBounds(200, 0, 400, 200);
		registerLabel.setFont(new Font("Arial", Font.BOLD, 15));
		add(registerLabel);

		// Create login
		labelAddLogin = new JLabel("Add Login:");
		labelAddLogin.setBounds(10, 80, 150, 150);
		labelAddLogin.setFont(new Font("Arial", Font.BOLD, 15));
		addLogin = new JTextField("");
		addLogin.setBounds(160, 140, 400, 35);
		add(addLogin);
		add(labelAddLogin);

		// Create password
		labelAddPassword = new JLabel("Add Password:");
		labelAddPassword.setBounds(10, 145, 150, 150);
		labelAddPassword.setFont(new Font("Arial", Font.BOLD, 15));
		addPassword = new JPasswordField("");
		addPassword.setBounds(160, 200, 400, 35);
		add(addPassword);
		add(labelAddPassword);

		// Add again password
		labelAddAgainPassword = new JLabel("Again password:");
		labelAddAgainPassword.setBounds(10, 205, 150, 150);
		labelAddAgainPassword.setFont(new Font("Arial", Font.BOLD, 15));
		addAgainPassword = new JPasswordField("");
		addAgainPassword.setBounds(160, 260, 400, 35);
		add(addAgainPassword);
		add(labelAddAgainPassword);

		// Add Email
		labelAddEmail = new JLabel("Add Email:");
		labelAddEmail.setBounds(10, 265, 150, 150);
		labelAddEmail.setFont(new Font("Arial", Font.BOLD, 15));
		addEmail = new JTextField("");
		addEmail.setBounds(160, 320, 400, 35);
		add(addEmail);
		add(labelAddEmail);

		// Add birth date
		addBirthDate = new JLabel("Birth date:");
		addBirthDate.setBounds(10, 325, 150, 150);
		addBirthDate.setFont(new Font("Arial", Font.BOLD, 15));
		JSpinner dateSpinner = new JSpinner(new SpinnerDateModel());
		dateSpinner.setBounds(160, 380, 400, 35);
		dateSpinner.setEditor(new JSpinner.DateEditor(dateSpinner, "dd/MM/yyyy"));
		dateSpinner.setFont(new Font("Arial", Font.BOLD, 15));
		add(dateSpinner);
		add(addBirthDate);
		
		// Add Sex
		addSex = new JLabel("Sex:");
		addSex.setBounds(10, 405, 150, 150);
		addSex.setFont(new Font("Arial", Font.BOLD, 15));
		male = new JRadioButton("Male");
		male.setBounds(160, 440, 400, 35);
		female = new JRadioButton("Female");
		female.setBounds(160, 480, 400, 35);
		add(addSex);
		add(male);
		add(female);
		
		//Add button register
		register = new JButton("Register");
		register.setBounds(150, 550, 400, 50);
		add(register);
	}
}
