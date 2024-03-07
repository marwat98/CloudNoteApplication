package CloudNote;

import javax.swing.JButton;
import javax.swing.JFrame;

public class ApplicationWindow extends JFrame {

	
//	public static void main (String [] args) {
//		ApplicationWindow app = new ApplicationWindow();
//		app.applicationWindowSettings();
//		app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		app.setLocationRelativeTo(null);
//		app.setVisible(true);
//	}
	
	// Size settings application window
	public void applicationWindowSettings() {
		setTitle("CloudNote");
    	setSize(700,700);
    	setLayout(null);
	}
	public void addNote() {
		JButton add = new JButton("Add");
	}

}
