package domain;

import javax.swing.JFrame;

public class Main {
	public static void main(String [] args) {
		
		LoginWindow loginWindow = new LoginWindow();
		loginWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		loginWindow.setLocationRelativeTo(null);
		loginWindow.setVisible(true);
		
		
	}

}
