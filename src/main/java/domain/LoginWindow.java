package domain;

import java.awt.Font;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;


import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.scene.control.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginWindow extends JFrame {
	
	private static EntityManagerFactory entityManagerFactory;
	private static EntityManager entityManager;
	private static AddUser user;
	private static JTextField loginFieldText;

    public void windowSettings() {
    	setTitle("ToDoNote");
    	setSize(700,700);
    	setLayout(null);
    }
    
    public void labelToDo() {
    	JLabel toDo = new JLabel("ToDoNote");
    	toDo.setBounds(240,5,300,200);
    	toDo.setFont(new Font("Arial", Font.BOLD, 50));
    	add(toDo);
    }
    // Login components
    public void labelLogin() {
    	JLabel labelLogin = new JLabel("Login:");
    	labelLogin.setBounds(100,140,150,150);
    	labelLogin.setFont(new Font("Arial", Font.BOLD, 20));
    	loginFieldText = new JTextField("");
    	loginFieldText.setBounds(240,198,250,35);
    	add(loginFieldText);
    	add(labelLogin);
    }
    // Password components
    public void labelPassword() {
    	JLabel labelPassword = new JLabel("Password:");
    	labelPassword.setBounds(100,230,150,120);
    	labelPassword.setFont(new Font("Arial", Font.BOLD, 20));
    	JPasswordField passwordFieldText = new JPasswordField("");
    	passwordFieldText.setBounds(240,273,250,35);
    	add(passwordFieldText);
    	add(labelPassword);
    }
    // Button SignIn
    public void signIn() {
    	JButton signIn = new JButton("Sign in");
    	signIn.setBounds(263, 330, 200, 40);
    	add(signIn);
    	
    	signIn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				checkUserInDataBase(loginFieldText);
			}
    	});
   
    	}

    // Information about register possibility
    public void registerInformation() {
    	JLabel registerInformation = new JLabel("If you havent't account you can register click on button");
    	registerInformation.setBounds(190,550,350,40);
    	add(registerInformation);
    }
    // Button SignUp
    public void signUp() {
    	JButton signUp = new JButton("Sign up");
    	signUp.setBounds(263, 600, 200, 40);
    	add(signUp);
    	
    	//Action that opens the Registration Form
        signUp.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	
        		RegisterWindow registerWindow = new RegisterWindow();
        		registerWindow.windowSettings();
        		registerWindow.back();
        		registerWindow.registerLabel();
        		registerWindow.labelAddLogin();
        		registerWindow.informationAboutLogin();
        		registerWindow.labelAddPassword();
        		registerWindow.againAddPassword();
        		registerWindow.informationAboutPassword();
        		registerWindow.labelAddEmail();
        		registerWindow.birthDate();
        		registerWindow.gender();
        		registerWindow.registerButton();
        		registerWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        		registerWindow.setLocationRelativeTo(null);
        		registerWindow.setVisible(true);
				dispose();
            	
            	}
        	});
    	}
    private void checkUserInDataBase(JTextField loginField) {
        String login = loginField.getText(); 
        Query query = entityManager.createQuery("SELECT e FROM AddUser e WHERE e.login = :login");
        query.setParameter("login", login);
        try {
            AddUser user = (AddUser) query.getSingleResult();
            AplicationLabel aplication = new AplicationLabel();  
            aplication.windowSettings();
        } catch (NoResultException nre) {
        	JOptionPane.showMessageDialog(null, "Użytkownik nie istnieje.", "Błąd logowania", JOptionPane.ERROR_MESSAGE);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Wystąpił problem podczas logowania.", "Error 1", JOptionPane.ERROR_MESSAGE);
        } 
    }

 }
