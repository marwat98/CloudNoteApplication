package CloudNote;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.text.SimpleDateFormat;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerDateModel;

public class RegisterWindow extends JFrame {

	private static JFrame frame;
	private static JLabel labelAddPassword, registerLabel, labelAddLogin, labelAddAgainPassword, addBirthDate,
			labelAddEmail, addSex,informationAboutPassword,informationAboutLogin;
	private static JTextField addLogin, addEmail;
	private static JPasswordField addPassword, addAgainPassword;
	private static JRadioButton male, female;
	private static JButton register, back;
	private static JSpinner dateSpinner;
	private static EntityManagerFactory entityManagerFactory;
	private static EntityManager entityManager;
	private static AddUser user;
	
	// Size settings register window
	public void registerWindowSettings() {
		setTitle("CloudNote");
    	setSize(700,700);
    	setLayout(null);
	}
	// Back to the Login Window
	public void back() {
		back = new JButton("Back");
		back.setBounds(0, 0, 120, 30);
		add(back);

		back.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
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
				dispose();
			}
		});
	}
	// Registration information
	public void registerLabel() {
		registerLabel = new JLabel("Fill out the form below to create an account");
		registerLabel.setBounds(200, 0, 400, 200);
		registerLabel.setFont(new Font("Arial", Font.BOLD, 15));
		add(registerLabel);
	}
	// Create login
	public void labelAddLogin() {
		labelAddLogin = new JLabel("Add Login:");
		labelAddLogin.setBounds(10, 80, 150, 150);
		labelAddLogin.setFont(new Font("Arial", Font.BOLD, 15));
		addLogin = new JTextField("");
		addLogin.setBounds(160, 140, 400, 35);
		add(addLogin);
		add(labelAddLogin);
	}
	public void informationAboutLogin() {
		informationAboutLogin = new JLabel("<html>Login can be a max <br> of 10 characters</html>");
		informationAboutLogin.setBounds(570,85,150,150);
		add(informationAboutLogin);
	}
	// Create password
	public void labelAddPassword() {
		labelAddPassword = new JLabel("Add Password:");
		labelAddPassword.setBounds(10, 145, 150, 150);
		labelAddPassword.setFont(new Font("Arial", Font.BOLD, 15));
		addPassword = new JPasswordField("");
		addPassword.setBounds(160, 200, 400, 35);
		add(addPassword);
		add(labelAddPassword);
	}
	// Information about password specification
	public void informationAboutPassword() {
		informationAboutPassword = new JLabel("<html>Must been: <br> 1 special character <br> 1 big letter</html>");
		informationAboutPassword.setBounds(570, 170, 150, 150);
		add(informationAboutPassword);
	}
	// Add again password
	public void againAddPassword() {
		labelAddAgainPassword = new JLabel("Again password:");
		labelAddAgainPassword.setBounds(10, 205, 150, 150);
		labelAddAgainPassword.setFont(new Font("Arial", Font.BOLD, 15));
		addAgainPassword = new JPasswordField("");
		addAgainPassword.setBounds(160, 260, 400, 35);
		add(addAgainPassword);
		add(labelAddAgainPassword);
	}
	// Add Email
	public void labelAddEmail() {
		labelAddEmail = new JLabel("Add Email:");
		labelAddEmail.setBounds(10, 265, 150, 150);
		labelAddEmail.setFont(new Font("Arial", Font.BOLD, 15));
		addEmail = new JTextField("");
		addEmail.setBounds(160, 320, 400, 35);
		add(addEmail);
		add(labelAddEmail);
	}
	// Add birth date
	public void birthDate() {
		addBirthDate = new JLabel("Birth date:");
		addBirthDate.setBounds(10, 325, 150, 150);
		addBirthDate.setFont(new Font("Arial", Font.BOLD, 15));
		dateSpinner = new JSpinner(new SpinnerDateModel());
		dateSpinner.setEditor(new JSpinner.DateEditor(dateSpinner, "yyyy-MM-dd"));
		dateSpinner.setBounds(160, 388, 150, 25);
		dateSpinner.setFont(new Font("Arial", Font.BOLD, 15));
		add(dateSpinner);
		add(addBirthDate);
	}

	// Add user sex
	public void gender() {
		addSex = new JLabel("Sex:");
		addSex.setBounds(10, 405, 150, 150);
		addSex.setFont(new Font("Arial", Font.BOLD, 15));
		male = new JRadioButton("Male");
		male.setBounds(160, 440, 400, 35);
		female = new JRadioButton("Female");
		female.setBounds(160, 480, 400, 35);
		add(addSex);
		add(male);
		add(female);
	}
	// Add button register
	public void registerButton() {
		register = new JButton("Register");
		register.setBounds(150, 550, 400, 50);
		add(register);

		register.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				user = new AddUser();		
				try {
				String login = addLogin.getText();
				validateLogin(login);
				loginRegister(login);
				
				String password = new String(addPassword.getPassword());
				String password2 = new String(addAgainPassword.getPassword());
				validatePasswords(password,password2);
				passwordRegister(password);

				String email = addEmail.getText();
				emailRegister(email);

				java.util.Date utilDate = (java.util.Date) dateSpinner.getValue();
				java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
				dateRegister(sqlDate);

				String gender = male.isSelected() ? "Male" : "Female";
				checkGender(gender);
				
				userRegister();	
				
				} catch(Exception ch) {
					JOptionPane.showMessageDialog(null, ch.getMessage(), "Validation Error", JOptionPane.ERROR_MESSAGE);
				}
	}
	// method which add login to data base
	private void loginRegister(String login) {
		user.setLogin(login);
	}
	// method which add password to data base
	private void passwordRegister(String password) {
		user.setPassword(password);
	}
	// method which add email to data base
	private void emailRegister(String email) {
		user.setEmail(email);
	}
	// method which add date to data base
	private void dateRegister(java.sql.Date sqlDate) {
		user.setDate(sqlDate);
	}
	// entity method which add gender to data base
	private void checkGender(String gender) {
		user.setGender(gender);
	}
	// method which check gender from user
	private boolean isMaleSelected() {
		return male.isSelected();
	}
	// method which check length login
	private void validateLogin(String login) throws Exception {
		if(login.length() > 10) {
			throw new Exception("Login is too long.");
		}
	}
	//method which check password
	private void validatePasswords(String password, String password2) throws Exception{
		if (!password.equals(password2)) {
			throw new Exception("Passwords aren't identical.");

		} else if (password.length() < 8) {
			throw new Exception("Password is too short.");
			
		} else if(!containsUpperCaseLetter(password)) {
			throw new Exception("Password must contain at least one uppercase letter.");
			
		} else if(!containsSpecialCharacter(password)) {
			throw new Exception("Password must contain at least one special character.");
		} 
	}

	// method which check big letter in password
    private boolean containsUpperCaseLetter(String password) {
        return password.chars().anyMatch(Character::isUpperCase);
    }
    // method which check special character in password
    private boolean containsSpecialCharacter(String password) {
    	return password.matches(".*[!@#$%\\^&*()_+\\-=\\[\\]\\{};':\",.<>\\/?~`|\\\\].*");
    }
    // method which add user to data base
    private void userRegister() throws Exception {
    	try {
        	entityManagerFactory = Persistence.createEntityManagerFactory("myToDo");
    		entityManager = entityManagerFactory.createEntityManager();
			entityManager.getTransaction().begin();
			entityManager.persist(user);
			entityManager.getTransaction().commit();
			JOptionPane.showMessageDialog(frame, "User registered successfully", "Registration Success",
					JOptionPane.INFORMATION_MESSAGE);

		} catch (Exception ex) {
			entityManager.getTransaction().rollback();
			JOptionPane.showMessageDialog(frame, "Registration failed: " + ex.getMessage(),
					"Registration Failed", JOptionPane.ERROR_MESSAGE);
		} finally {
			entityManagerFactory.close();
			entityManager.close();
		}
			}
		});
    	
	}
}
