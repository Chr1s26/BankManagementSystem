package View;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import Dao.BranchDaoImpl;
import Model.Branch;

public class EmployeeUpdateForm extends BaseWindow {
	
	private JLabel firstNameLabel;
	private JTextField firstNameField;

	private JLabel lastNameLabel;
	private JTextField lastNameField;

	private JLabel emailLabel;
	private JTextField emailField;

	private JLabel passwordLabel;
	private JPasswordField passwordField;
	
	private JLabel confirmPasswordLabel;
	private JPasswordField confirmPasswordField;

	private JLabel phoneNumberLabel;
	private JTextField phoneNumberField;

	private JLabel positionLabel;
	private JComboBox<String> positionComboBox;

	private JLabel branchLabel;
	private JComboBox<Branch> branchComboBox;
	
	private JLabel salaryLabel;
	private JTextField salaryField;

	private JButton updateButton;
	private JButton cancelButton;

	private JPanel panel;
	
	private BranchDaoImpl branchDao;

	public EmployeeUpdateForm() {
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
		
		confirmPasswordLabel = new JLabel("Confirm Password : ");
		confirmPasswordField = new JPasswordField();

		phoneNumberLabel = new JLabel("Phone : ");
		phoneNumberField = new JTextField();

		positionLabel = new JLabel("Position : ");
		positionComboBox = new JComboBox<>(new String[] { "Manager", "Developer", "Designer", "Tester", "HR" });

		branchLabel = new JLabel("Branch : ");
		branchComboBox = new JComboBox<>(branchDao.getAll().toArray(new Branch[0]));
		
		salaryLabel = new JLabel("Salary : ");
		salaryField = new JTextField();
		
		updateButton = new JButton("Update");
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
		panel.add(confirmPasswordLabel);
		panel.add(confirmPasswordField);
		panel.add(phoneNumberLabel);
		panel.add(phoneNumberField);
		panel.add(positionLabel);
		panel.add(positionComboBox);
		panel.add(branchLabel);
		panel.add(branchComboBox);
		panel.add(salaryLabel);
		panel.add(salaryField);
		panel.add(updateButton);
		panel.add(cancelButton);

		this.add(panel, BorderLayout.NORTH);
		prepareBaseWindow();

	}

	public void prepareBaseWindow() {
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setTitle("Employee Update Form");
		this.setSize(800, 400);
		this.setVisible(true);
	}

	public JLabel getFirstNameLabel() {
		return firstNameLabel;
	}

	public void setFirstNameLabel(JLabel firstNameLabel) {
		this.firstNameLabel = firstNameLabel;
	}

	public JTextField getFirstNameField() {
		return firstNameField;
	}

	public void setFirstNameField(JTextField firstNameField) {
		this.firstNameField = firstNameField;
	}

	public JLabel getLastNameLabel() {
		return lastNameLabel;
	}

	public void setLastNameLabel(JLabel lastNameLabel) {
		this.lastNameLabel = lastNameLabel;
	}

	public JTextField getLastNameField() {
		return lastNameField;
	}

	public void setLastNameField(JTextField lastNameField) {
		this.lastNameField = lastNameField;
	}

	public JLabel getEmailLabel() {
		return emailLabel;
	}

	public void setEmailLabel(JLabel emailLabel) {
		this.emailLabel = emailLabel;
	}

	public JTextField getEmailField() {
		return emailField;
	}

	public void setEmailField(JTextField emailField) {
		this.emailField = emailField;
	}

	public JLabel getPasswordLabel() {
		return passwordLabel;
	}

	public void setPasswordLabel(JLabel passwordLabel) {
		this.passwordLabel = passwordLabel;
	}

	public String getPasswordField() {
		return new String(this.passwordField.getPassword());
	}

	public void setPasswordField(JPasswordField passwordField) {
		this.passwordField = passwordField;
	}

	public JLabel getPhoneNumberLabel() {
		return phoneNumberLabel;
	}

	public void setPhoneNumberLabel(JLabel phoneNumberLabel) {
		this.phoneNumberLabel = phoneNumberLabel;
	}

	public JTextField getPhoneNumberField() {
		return phoneNumberField;
	}

	public void setPhoneNumberField(JTextField phoneNumberField) {
		this.phoneNumberField = phoneNumberField;
	}

	public JLabel getPositionLabel() {
		return positionLabel;
	}

	public void setPositionLabel(JLabel positionLabel) {
		this.positionLabel = positionLabel;
	}

	public String getPositionComboBox() {
		return (String)this.positionComboBox.getSelectedItem();
	}

	public void setPositionComboBox(String positionComboBox) {
		this.positionComboBox.setSelectedItem(positionComboBox);;
	}

	public JLabel getBranchLabel() {
		return branchLabel;
	}

	public void setBranchLabel(JLabel branchLabel) {
		this.branchLabel = branchLabel;
	}

	public int getBranchComboBox() {
		Branch branch = (Branch)this.branchComboBox.getSelectedItem();
		return branch.getId();
	}

	public void setBranchComboBox(String branchComboBox) {
		this.branchComboBox.setSelectedItem(branchComboBox); 
	}

	public JLabel getSalaryLabel() {
		return salaryLabel;
	}

	public void setSalaryLabel(JLabel salaryLabel) {
		this.salaryLabel = salaryLabel;
	}

	public JTextField getSalaryField() {
		return salaryField;
	}

	public void setSalaryField(JTextField salaryField) {
		this.salaryField = salaryField;
	}

	public JLabel getConfirmPasswordLabel() {
		return confirmPasswordLabel;
	}

	public void setConfirmPasswordLabel(JLabel confirmPasswordLabel) {
		this.confirmPasswordLabel = confirmPasswordLabel;
	}

	public String getConfirmPasswordField() {
		return new String(this.confirmPasswordField.getPassword());
	}
	
	public void setConfirmPasswordField(JPasswordField confirmPasswordField) {
		this.confirmPasswordField = confirmPasswordField;
	}

	public JButton getUpdateButton() {
		return updateButton;
	}

	public void setUpdateButton(JButton updateButton) {
		this.updateButton = updateButton;
	}

	public JButton getCancelButton() {
		return cancelButton;
	}

	public void setCancelButton(JButton cancelButton) {
		this.cancelButton = cancelButton;
	}

	public JPanel getPanel() {
		return panel;
	}

	public void setPanel(JPanel panel) {
		this.panel = panel;
	}

	public BranchDaoImpl getBranchDao() {
		return branchDao;
	}

	public void setBranchDao(BranchDaoImpl branchDao) {
		this.branchDao = branchDao;
	}
}
