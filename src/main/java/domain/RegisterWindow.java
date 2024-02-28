package domain;

import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class RegisterWindow extends JFrame {
	
	public RegisterWindow() {
		
	setTitle("ToDoNote");
	setSize(700,700);
	setLayout(null);
	
	JLabel register = new JLabel("Register right now while places are available");
	register.setBounds(200,0,400,200);
	register.setFont(new Font("Arial", Font.BOLD, 15));
	add(register);
	
	
	// Login components
	JLabel labelLogin = new JLabel("Login:");
	labelLogin.setBounds(100,50,150,150);
	labelLogin.setFont(new Font("Arial", Font.BOLD, 20));
	JTextField loginFieldText = new JTextField("");
	loginFieldText.setBounds(240,198,250,35);
	add(loginFieldText);
	add(labelLogin);

	}
}
