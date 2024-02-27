package domain;

import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.scene.control.Label;

public class LoginWindow extends JFrame {
	
	public LoginWindow() {
		
	setTitle("ToDoNote");
	setSize(700,700);
	setLayout(null);
	
	JLabel toDo = new JLabel("ToDoNote");
	toDo.setBounds(240,5,300,200);
	toDo.setFont(new Font("Arial", Font.BOLD, 50));
	add(toDo);
	
	// Login components
	JLabel labelLogin = new JLabel("Login:");
	labelLogin.setBounds(100,140,150,150);
	labelLogin.setFont(new Font("Arial", Font.BOLD, 20));
	JTextField loginFieldText = new JTextField("");
	loginFieldText.setBounds(240,198,250,35);
	add(loginFieldText);
	add(labelLogin);
	
	// Password components
	JLabel labelPassword = new JLabel("Password:");
	labelPassword.setBounds(100,230,150,120);
	labelPassword.setFont(new Font("Arial", Font.BOLD, 20));
	JTextField passwordFieldText = new JTextField("");
	passwordFieldText.setBounds(240,273,250,35);
	add(passwordFieldText);
	add(labelPassword);
	
	JButton signIn = new JButton("Sign in");
	signIn.setBounds(263, 330, 200, 40);
	add(signIn);
	
	
	JLabel registerNote = new JLabel("If you havent't account you can register click on button");
	registerNote.setBounds(190,550,350,40);
	add(registerNote);
	
	JButton signUp = new JButton("Sign up");
	signUp.setBounds(263, 600, 200, 40);
	add(signUp);
	
	
	
	}


}
