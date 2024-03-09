package CloudNote;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import javax.swing.JTextField;
import javax.persistence.NoResultException;

public class AddUserService {
	
	private static final EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("myToDo");
	private static final EntityManager entityManager = entityManagerFactory.createEntityManager();;
	private static JTextField showLogin;
	
	public AddUser getUserByLogin(JTextField showLogin) {
		try {
			String login = showLogin.getText();
			String selectUser = "SELECT e FROM AddUser e WHERE e.login = :login";
			TypedQuery<AddUser> query = entityManager.createQuery(selectUser, AddUser.class);
			query.setParameter("login", login);
			return query.getSingleResult();
		} catch (NoResultException nre) {
			return null; 
		} finally {
			entityManagerFactory.close();
			entityManager.close();
		}
	}
}
