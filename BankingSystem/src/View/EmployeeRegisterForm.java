package View;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import Exception.InvalidTokenException;

public class EmployeeRegisterForm extends BaseWindow{
	
	private JLabel firstNameLabel;
	private JTextField firstNameField;
	
	private JLabel lastNameLabel;
	private JTextField lastNameField;
	
	private JLabel emailLabel;
	private JTextField emailField;
	
	private JLabel passwordLabel;
	private JPasswordField passwordField;
	
	private JLabel phoneNumberLabel;
	private JTextField phoneNumberField;
	
	private JLabel positionLabel;
	private JComboBox<String> positionComboBox;
	
	private JLabel branchLabel;
	private JComboBox<String> branchComboBox;
	
	private JButton createButton;
	private JButton cancelButton;
	
	private JPanel panel;
	
	public EmployeeRegisterForm() {
		initializeComponent();
	}
	
	public void initializeComponent() {
		
		firstNameLabel = new JLabel("Firstname : ");
		firstNameField = new JTextField();
		
		lastNameLabel = new JLabel("Lastname : ");
		lastNameField = new JTextField();
		
		emailLabel = new JLabel("Email : ");
		emailField = new JTextField();
		
		passwordLabel = new JLabel("Password : ");
		passwordField = new JPasswordField();
		
		phoneNumberLabel = new JLabel("Phone : ");
		phoneNumberField = new JTextField();
		
		positionLabel = new JLabel("Position : ");
		positionComboBox = new JComboBox<>(new String[] {"Manager", "Developer", "Designer", "Tester", "HR"});
		
		branchLabel = new JLabel("Branch : ");
		branchComboBox = new JComboBox<>(new String[] {"New York", "Los Angeles", "Chicago", "Houston", "Phoenix"});
		
		createButton = new JButton("Register");
		cancelButton = new JButton("Cancel");
		
		panel = new JPanel();
		panel.setLayout(new GridLayout(8, 2));
		
		panel.add(firstNameLabel);
		panel.add(firstNameField);
		panel.add(lastNameLabel);
		panel.add(lastNameField);
		panel.add(emailLabel);
		panel.add(emailField);
		panel.add(passwordLabel);
		panel.add(passwordField);
		panel.add(phoneNumberLabel);
		panel.add(phoneNumberField);
		panel.add(positionLabel);
		panel.add(positionComboBox);
		panel.add(branchLabel);
		panel.add(branchComboBox);
		panel.add(createButton);
		panel.add(cancelButton);
		
		this.baseWindow.add(panel,BorderLayout.NORTH);
		prepareBaseWindow();
		
	}
	
	public void addActionOnCreateButton() {
		this.createButton.addActionListener(e -> actionOfCreateButton());
	}
	
	public void actionOfCreateButton() {
		
	}
	
	public void prepareBaseWindow() {
		this.baseWindow.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setTitle("Employee Create Form");
		this.baseWindow.setSize(800,400);
		this.baseWindow.setVisible(true);
	}
}
