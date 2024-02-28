package domain;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.swing.JFrame;

public class Main {
	public static void main(String [] args) {
		
		EntityManagerFactory entityManagerFactory= Persistence.createEntityManagerFactory("myToDoDataBase");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		
		LoginWindow loginWindow = new LoginWindow();
		loginWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		loginWindow.setLocationRelativeTo(null);
		loginWindow.setVisible(true);
		
		
		
		
	}

}
