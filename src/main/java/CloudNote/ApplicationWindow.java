package CloudNote;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class ApplicationWindow extends JFrame {
	
	private static JButton addCloudNote,checkCloudNote,shareUserNote,logOut;
	private static JLabel showUser;

	
//	public static void main (String [] args) {
//		ApplicationWindow app = new ApplicationWindow();
//		app.applicationWindowSettings();
//		//app.showUserLogin(loginFieldText);
//		app.addNote();
//		app.checkNote();
//		app.shareNote();
//		app.logOutToMainCloudWindow();
//		app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		app.setLocationRelativeTo(null);
//		app.setVisible(true);
//	}
	
	public void showUserLogin(JTextField loginFieldText) {
		
		AddUserService userService = new AddUserService();
		AddUser user = userService.getUserByLogin(loginFieldText);
		
		if(user != null) {
			showUser = new JLabel("Login: " + user.getLogin());
		} else {
			showUser = new JLabel("Unknow User");
		}
		showUser.setBounds(550,0,500,50);
		add(showUser);
	}
	
	// Size settings application window
	public void applicationWindowSettings() {
		setTitle("CloudNote");
    	setSize(700,700);
    	setLayout(null);
	}
	public void addNote() {
		addCloudNote = new JButton("Add Note");
		addCloudNote.setBounds(150,200,400,50);
		add(addCloudNote);
		addCloudNote.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
			}
		});
	}
	public void checkNote() {
		checkCloudNote = new JButton("Check");
		checkCloudNote.setBounds(150,280,400,50);
		add(checkCloudNote);
	}
	public void shareNote() {
		shareUserNote = new JButton("Share");
		shareUserNote.setBounds(150,360,400,50);
		add(shareUserNote);
	}
	public void logOutToMainCloudWindow() {
		logOut = new JButton("Log Out");
		logOut.setBounds(150,440,400,50);
		add(logOut);
		logOut.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
			}
		});
	}

}
