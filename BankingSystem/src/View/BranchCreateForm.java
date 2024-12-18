package View;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class BranchCreateForm extends BaseWindow {
	
	private JLabel nameLabel;
	private JTextField nameField;
	
	private JLabel addressLabel;
	private JTextField addressField;
	
	private JLabel phoneNumberLabel;
	private JTextField phoneField;
	
	private JButton createButton;
	private JButton cancelButton;
	
	private JPanel panel;
	
	public BranchCreateForm() {
		initializeComponent();
	}
	
	public void initializeComponent() {
		
		nameLabel = new JLabel("Name : ");
		nameField = new JTextField();
		
		addressLabel = new JLabel("Address : ");
		addressField = new JTextField();
		
		phoneNumberLabel = new JLabel("Phone : ");
		phoneField = new JTextField();
		
		createButton = new JButton("Create");
		cancelButton = new JButton("Cancel");
		
		panel = new JPanel();
		panel.setLayout(new GridLayout(4, 2));
		
		panel.add(nameLabel);
		panel.add(nameField);
		panel.add(addressLabel);
		panel.add(addressField);
		panel.add(phoneNumberLabel);
		panel.add(phoneField);
		panel.add(createButton);
		panel.add(cancelButton);
		
		this.add(panel,BorderLayout.NORTH);
		prepareBaseWindow();

	}
	
	
	public void prepareBaseWindow() {
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setTitle("Branch Create Form");
		this.setSize(800,400);
	}
	
	public JTextField getNameField() {
		return nameField;
	}

	public void setNameField(JTextField nameField) {
		this.nameField = nameField;
	}

	public JTextField getAddressField() {
		return addressField;
	}

	public void setAddressField(JTextField addressField) {
		this.addressField = addressField;
	}

	public JTextField getPhoneField() {
		return phoneField;
	}

	public void setPhoneField(JTextField phoneField) {
		this.phoneField = phoneField;
	}

	public JButton getCreateButton() {
		return createButton;
	}

	public void setCreateButton(JButton createButton) {
		this.createButton = createButton;
	}

	public JButton getCancelButton() {
		return cancelButton;
	}

	public void setCancelButton(JButton cancelButton) {
		this.cancelButton = cancelButton;
	}
}
