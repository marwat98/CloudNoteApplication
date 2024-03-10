package CloudNote;

import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JSpinner;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SpinnerDateModel;

public class AddUserNote extends JFrame {
	
	private static AddNote addNote;
	private static JLabel dateLabel, timeLabel, repeatLabel;
	private static JTextArea userNoteField;
	private static JSpinner date, time, repeat;
	private static JButton add;
	
	public static void main (String [] args) {
		
		AddUserNote addUserNote = new AddUserNote();
		addUserNote.windowAddUserNoteSettings();
		addUserNote.noteField();
		addUserNote.dateLabel();
		addUserNote.dateNote();
		addUserNote.timeLabel();
		addUserNote.timeNote();
		addUserNote.repeatLabel();
		addUserNote.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		addUserNote.setLocationRelativeTo(null);
		addUserNote.setVisible(true);
	}
	public void windowAddUserNoteSettings() {
		setTitle("CloudNote");
    	setSize(700,700);
    	setLayout(null);
	}
	public void noteField() {
		userNoteField = new JTextArea();
		userNoteField.setBounds(20,60,660,200);
		add(userNoteField);
		
	}
	public void dateLabel() {
		dateLabel = new JLabel("Date: ");
		dateLabel.setBounds(20,335,50,20);
		dateLabel.setFont(new Font("Arial", Font.BOLD, 15));
		add(dateLabel);
	}
	public void dateNote() {
		date = new JSpinner(new SpinnerDateModel());
		date.setEditor(new JSpinner.DateEditor(date, "dd-MM-yyyy"));
		date.setBounds(70, 320, 200, 50);
		date.setFont(new Font("Arial", Font.BOLD, 15));
		add(date);
	}
	public void timeLabel() {
		timeLabel = new JLabel("Time: ");
		timeLabel.setBounds(420,335,50,20);
		timeLabel.setFont(new Font("Arial", Font.BOLD, 15));
		add(timeLabel);
	}
	public void timeNote() {
		time = new JSpinner(new SpinnerDateModel());
		time.setEditor(new JSpinner.DateEditor(time, "HH:mm:ss"));
		time.setBounds(470,320,200,50);
		time.setFont(new Font("Arial", Font.BOLD, 15));
		add(time);
	}
	public void repeatLabel() {
		repeatLabel = new JLabel("Repeat: ");
		repeatLabel.setBounds(20,430,70,20);
		repeatLabel.setFont(new Font("Arial", Font.BOLD, 15));
		add(repeatLabel);
	}
	private void note(String note) {
		addNote.setNote(note);
	}
	private void date(java.sql.Date date) {
		addNote.setDate(date);
	}
	private void time(java.sql.Time time) {
		addNote.setTime(time);
	}
	private void repeat(int repeat) {
		addNote.setRepeat(repeat);
	}

}
