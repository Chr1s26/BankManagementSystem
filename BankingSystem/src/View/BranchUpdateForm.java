package View;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class BranchUpdateForm extends BaseWindow{
	
	private JLabel nameLabel;
	private JTextField nameField;
	
	private JLabel addressLabel;
	private JTextField addressField;
	
	private JLabel phoneNumberLabel;
	private JTextField phoneField;
	
	private JButton updateButton;
	private JButton cancelButton;
	
	private JPanel panel;
	
	public BranchUpdateForm() {
		initializeComponent();
	}
	
	public void initializeComponent() {
		
		nameLabel = new JLabel("Name : ");
		nameField = new JTextField();
		
		addressLabel = new JLabel("Address : ");
		addressField = new JTextField();
		
		phoneNumberLabel = new JLabel("Phone : ");
		phoneField = new JTextField();
		
		updateButton = new JButton("Update");
		cancelButton = new JButton("Cancel");
		
		panel = new JPanel();
		panel.setLayout(new GridLayout(4, 2));
		
		panel.add(nameLabel);
		panel.add(nameField);
		panel.add(addressLabel);
		panel.add(addressField);
		panel.add(phoneNumberLabel);
		panel.add(phoneField);
		panel.add(updateButton);
		panel.add(cancelButton);
		
		this.baseWindow.add(panel,BorderLayout.NORTH);
		prepareBaseWindow();
	}
	
	public void addActionOnupdateButton() {
		this.updateButton.addActionListener(e -> actionOfupdateButton());
	}
	
	public void actionOfupdateButton() {
		
	}
	
	public void prepareBaseWindow() {
		this.baseWindow.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setTitle("Branch Update Form");
		this.baseWindow.setSize(800,400);
		this.baseWindow.setVisible(true);
	}
}
