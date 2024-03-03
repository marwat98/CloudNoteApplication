import domain.AddUser;
import domain.LoginWindow;
import static org.mockito.Mockito.*;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.swing.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

public class ApplicationToDoTest {
    
    @Mock
    private EntityManager entityManager;

    @InjectMocks
    private LoginWindow loginWindow;

    @BeforeEach
    public void setUp() {
    	MockitoAnnotations.openMocks(this);
    }

    @Test
    void shouldCheckUserInDataBase() {
        JTextField loginField = mock(JTextField.class);
        JPasswordField passwordField = mock(JPasswordField.class);
        Query query = mock(Query.class);
        
        // Konfiguracja
        when(loginField.getText()).thenReturn("testUser");
        when(passwordField.getPassword()).thenReturn("password".toCharArray());
        when(entityManager.createQuery(anyString())).thenReturn(query);
        when(query.setParameter(anyString(), any())).thenReturn(query);
        when(query.getSingleResult()).thenReturn(new AddUser());

        // Wywołanie testowanej metody
        loginWindow.checkUserInDataBase(loginField, passwordField);

        // Weryfikacja
        verify(entityManager).createQuery("SELECT e FROM AddUser e WHERE e.login = :login AND e.password = :password");
        verify(query).setParameter(eq("login"), eq("testUser"));
        verify(query).setParameter(eq("password"), eq("password"));
        verify(query).getSingleResult();
    }
}
