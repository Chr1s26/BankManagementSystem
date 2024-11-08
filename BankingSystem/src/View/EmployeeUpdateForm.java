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

public class EmployeeUpdateForm extends BaseWindow {
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

	private JButton updateButton;
	private JButton cancelButton;

	private JPanel panel;

	public EmployeeUpdateForm() {
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
		positionComboBox = new JComboBox<>(new String[] { "Manager", "Developer", "Designer", "Tester", "HR" });

		branchLabel = new JLabel("Branch : ");
		branchComboBox = new JComboBox<>(new String[] { "New York", "Los Angeles", "Chicago", "Houston", "Phoenix" });

		updateButton = new JButton("Update");
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
		panel.add(updateButton);
		panel.add(cancelButton);

		this.baseWindow.add(panel, BorderLayout.NORTH);
		prepareBaseWindow();

	}

	public void addActionOnupdateButton() {
		this.updateButton.addActionListener(e -> actionOfupdateButton());
	}

	public void actionOfupdateButton() {

	}

	public void prepareBaseWindow() {
		this.baseWindow.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setTitle("Employee Update Form");
		this.baseWindow.setSize(800, 400);
		this.baseWindow.setVisible(true);
	}
}
