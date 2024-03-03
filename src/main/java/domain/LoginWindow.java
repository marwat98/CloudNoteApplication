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
	private static JPasswordField passwordFieldText;
	
	//method which connection with data base
    public void entityManagerFactory() {
    	entityManagerFactory = Persistence.createEntityManagerFactory("myToDo");
		entityManager = entityManagerFactory.createEntityManager();
    }
    //Size setting window
    public void loginWindowSettings() {
    	setTitle("ToDoNote");
    	setSize(700,700);
    	setLayout(null);
    }
    // Name application
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
    	passwordFieldText = new JPasswordField("");
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
				checkUserInDataBase(loginFieldText,passwordFieldText);
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
        		registerWindow.registerWindowSettings();
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
    public void checkUserInDataBase(JTextField loginField, JPasswordField passwordField) {    	
    	entityManagerFactory();		
        String login = loginField.getText();
        String password = new String(passwordField.getPassword()); 
        Query query = entityManager.createQuery("SELECT e FROM AddUser e WHERE e.login = :login AND e.password = :password");
        query.setParameter("login", login);
        query.setParameter("password", password); 
        
        try {
            AddUser user = (AddUser) query.getSingleResult();
            ApplicationWindow application = new ApplicationWindow();
            application.applicationWindowSettings();
            application.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            application.setLocationRelativeTo(null);
            application.setVisible(true);
            JOptionPane.showMessageDialog(null, "Logging correct", "Logging", JOptionPane.ERROR_MESSAGE);
        	dispose();  
        } catch (NoResultException nre) {
        	nre.printStackTrace();
            JOptionPane.showMessageDialog(null, "User doesn't exist", "Logging error", JOptionPane.ERROR_MESSAGE);
        } catch (Exception e) {
        	e.printStackTrace();
            JOptionPane.showMessageDialog(null, "There was a problem during login", "Error 1", JOptionPane.ERROR_MESSAGE);
        } finally {        	
        	entityManagerFactory.close();
        	entityManager.close();
        }
    }

 }
