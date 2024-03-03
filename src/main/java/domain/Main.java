package domain;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

public class Main {

	public static void main(String[] args) {

		LoginWindow loginWindow = new LoginWindow();
		loginWindow.loginWindowSettings();
		loginWindow.labelToDo();
		loginWindow.labelLogin();
		loginWindow.labelPassword();
		loginWindow.signIn();
		loginWindow.registerInformation();
		loginWindow.signUp();
		loginWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		loginWindow.setLocationRelativeTo(null);
		loginWindow.setVisible(true);
		
		}

	}

