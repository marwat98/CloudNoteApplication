import static org.mockito.Mockito.*;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.swing.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import CloudNote.AddUser;
import CloudNote.ApplicationWindow;
import CloudNote.LoginWindow;

public class ApplicationToDoTest {
	
	
	private EntityManagerFactory entityManagerFactory;
	private EntityManager entityManager;
	private Query query;
	private JTextField loginField = new JTextField();
	private JPasswordField passwordField = new JPasswordField();
	private ApplicationWindow application = new ApplicationWindow();
	private LoginWindow loginWindow = new LoginWindow();
 
	@BeforeEach
	void setUp() {
        entityManagerFactory = mock(EntityManagerFactory.class);
        entityManager = mock(EntityManager.class);
        query = mock(Query.class);

        when(entityManagerFactory.createEntityManager()).thenReturn(entityManager);
        when(entityManager.createQuery(anyString())).thenReturn(query);

        
        loginField.setText("marwat98");
        passwordField.setText("password2024D!");

	}

    @Test
    void shouldCorrectUser() {
    
    	AddUser mockitoUser = new AddUser();
        when(query.getSingleResult()).thenReturn(mockitoUser);
        
        loginWindow.checkUserInDataBase(loginField, passwordField);
        
        verify(query).setParameter("login", "marwat98");
        verify(query).setParameter("password", "password2024D!");
    }
    
    @Test
    void shouldWrongUser() {
    
    	AddUser mockitoUser = new AddUser();
        when(query.getSingleResult()).thenReturn(mockitoUser);
        
        loginWindow.checkUserInDataBase(loginField, passwordField);
        
        verify(query).setParameter("login", "wrongUser");
        verify(query).setParameter("password", "pass1!");
    }
}
