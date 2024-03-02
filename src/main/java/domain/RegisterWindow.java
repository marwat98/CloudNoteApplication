package domain;

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

	public static JFrame frame;
	public static JLabel labelAddPassword, registerLabel, labelAddLogin, labelAddAgainPassword, addBirthDate,
			labelAddEmail, addSex;
	public static JTextField addLogin, addEmail;
	public static JPasswordField addPassword, addAgainPassword;
	public static JRadioButton male, female;
	public static JButton register, back;
	public static JSpinner dateSpinner;
	public static EntityManagerFactory entityManagerFactory;
	public static EntityManager entityManager;
	public static AddUser user;

	public void registerWindowSettings() {

		setTitle("ToDoNote");
		setSize(700, 700);
		setLayout(null);
	}

	public void back() {

		back = new JButton("Back");
		back.setBounds(0, 0, 120, 30);
		add(back);

		back.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				LoginWindow loginWindow = new LoginWindow();
				loginWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				loginWindow.setLocationRelativeTo(null);
				loginWindow.setVisible(true);
				dispose();

			}
		});
	}

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
		dateSpinner.setBounds(160, 380, 150, 25);
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
				String login = addLogin.getText();
				loginRegister(login);

				String password = new String(addPassword.getPassword());
				String password2 = new String(addAgainPassword.getPassword());
				if (password.equals(password2)) {
					passwordRegister(password);
				} else {
					JOptionPane.showMessageDialog(frame, "Passwords aren't identical", "Adding password failed ",
							JOptionPane.INFORMATION_MESSAGE);
				}

				String email = addEmail.getText();
				emailRegister(email);

				java.util.Date utilDate = (java.util.Date) dateSpinner.getValue();
				java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
				dateRegister(sqlDate);

				String gender = male.isSelected() ? "Male" : "Female";
				checkGender(gender);

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

	public void loginRegister(String login) {
		user.setLogin(login);
	}

	public void passwordRegister(String password) {
		user.setPassword(password);
	}

	public void emailRegister(String email) {
		user.setEmail(email);
	}

	public void dateRegister(java.sql.Date sqlDate) {
		user.setDate(sqlDate);
	}

	public void checkGender(String gender) {
		user.setGender(gender);
	}

	public boolean isMaleSelected() {
		return male.isSelected();
	}

}
