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

import Dao.BranchDaoImpl;
import Exception.InvalidTokenException;
import Model.Branch;

public class EmployeeRegisterForm extends BaseWindow{
	
	private JLabel firstNameLabel;
	private JTextField firstNameField;
	
	private JLabel lastNameLabel;
	private JTextField lastNameField;
	
	private JLabel emailLabel;
	private JTextField emailField;
	
	private JLabel passwordLabel;
	private JPasswordField passwordField;
	
	private JLabel confirmpasswordLabel;
	private JPasswordField confirmpasswordField;
	
	private JLabel phoneNumberLabel;
	private JTextField phoneNumberField;
	
	private JLabel salaryLabel;
	private JTextField salaryField;
	
	private JLabel positionLabel;
	private JComboBox<String> positionComboBox;
	
	private JLabel branchLabel;
	private JComboBox<Branch> branchComboBox;
	
	private JButton createButton;
	private JButton cancelButton;
	
	private JPanel panel;
	private BranchDaoImpl branchDao;
	
	public EmployeeRegisterForm() {
		initializeComponent();
	}
	
	public void initializeComponent() {
		
		branchDao = new BranchDaoImpl();
		
		firstNameLabel = new JLabel("Firstname : ");
		firstNameField = new JTextField();
		
		lastNameLabel = new JLabel("Lastname : ");
		lastNameField = new JTextField();
		
		emailLabel = new JLabel("Email : ");
		emailField = new JTextField();
		
		passwordLabel = new JLabel("Password : ");
		passwordField = new JPasswordField();
		
		confirmpasswordLabel = new JLabel("Confirm Password : ");
		confirmpasswordField = new JPasswordField();
		
		phoneNumberLabel = new JLabel("Phone : ");
		phoneNumberField = new JTextField();
		
		salaryLabel = new JLabel("Salary : ");
		salaryField = new JTextField();
		
		positionLabel = new JLabel("Position : ");
		positionComboBox = new JComboBox<>(new String[] {"Manager", "Developer", "Designer", "Tester", "HR"});
		
		branchLabel = new JLabel("Branch : ");
		branchComboBox = new JComboBox<>(branchDao.getAll().toArray(new Branch[0]));
		
		createButton = new JButton("Register");
		cancelButton = new JButton("Cancel");
		
		panel = new JPanel();
		panel.setLayout(new GridLayout(10, 2));
		
		panel.add(firstNameLabel);
		panel.add(firstNameField);
		panel.add(lastNameLabel);
		panel.add(lastNameField);
		panel.add(emailLabel);
		panel.add(emailField);
		panel.add(passwordLabel);
		panel.add(passwordField);
		panel.add(confirmpasswordLabel);
		panel.add(confirmpasswordField);
		panel.add(phoneNumberLabel);
		panel.add(phoneNumberField);
		panel.add(salaryLabel);
		panel.add(salaryField);
		panel.add(positionLabel);
		panel.add(positionComboBox);
		panel.add(branchLabel);
		panel.add(branchComboBox);
		panel.add(createButton);
		panel.add(cancelButton);
		
		this.add(panel,BorderLayout.NORTH);
		prepareBaseWindow();
		
	}
	
	public String getFirstName() {
		return this.firstNameField.getText();
	}
	
	public String getLastName() {
		return this.lastNameField.getText();
	}
	
	public String getEmail() {
		return this.emailField.getText();
	}
	
	public String getPassword() {
		return new String(this.passwordField.getPassword());
	}
	
	public String getConfirmPassword() {
		return new String(this.confirmpasswordField.getPassword());
	}
	
	public String getPhoneNumber() {
		return this.phoneNumberField.getText();
	}
	
	public String getPosition() {
		return (String)this.positionComboBox.getSelectedItem();
	}
	
	public int getBranchId() {
		Branch branch = (Branch)this.branchComboBox.getSelectedItem();
		return branch.getId();
	}
	
	public JButton getCreateButton() {
		return this.createButton;
	}
	
	public String getSalary() {
		return this.salaryField.getText();
	}
	
	public void addActionOnCreateButton() {
		this.createButton.addActionListener(e -> actionOfCreateButton());
	}
	
	public void actionOfCreateButton() {
		
	}
	
	public void prepareBaseWindow() {
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setTitle("Employee Create Form");
		this.setSize(800,400);
		
	}

	
}
