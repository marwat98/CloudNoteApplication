package domain;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class Main {
	public static void main(String [] args) {
		SwingUtilities.invokeLater(RegisterWindow::new);
		EntityManagerFactory entityManagerFactory= Persistence.createEntityManagerFactory("myToDo");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		
		LoginWindow loginWindow = new LoginWindow();
		loginWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		loginWindow.setLocationRelativeTo(null);
		loginWindow.setVisible(true);
		
		AddUser user = new AddUser();
		
		entityManager.getTransaction().begin();
		entityManager.persist(user);
		entityManager.getTransaction().commit();
		
		entityManagerFactory.close();
		entityManager.close();
		
		
		
		
	}

}
