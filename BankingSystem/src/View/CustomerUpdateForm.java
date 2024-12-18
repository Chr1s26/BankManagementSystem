package View;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.util.Calendar;
import java.util.Date;
import java.util.Properties;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerDateModel;

import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.SqlDateModel;

import Dao.BranchDaoImpl;
import Util.DateLabelFormatter;

public class CustomerUpdateForm extends BaseWindow {
	
	private JLabel firstNameLabel;
	private JTextField firstNameField;
	
	private JLabel lastNameLabel;
	private JTextField lastNameField;
	
	private JLabel emailLabel;
	private JTextField emailField;
	
	private JLabel phoneNumberLabel;
	private JTextField phoneNumberField;
	
	private JLabel addressLabel;
	private JTextField addressField;
	
	private JLabel dateLabel;
	private SqlDateModel dateModel;
	private JDatePanelImpl datePanel;
	private JDatePickerImpl datePicker;

	
	private JButton updateButton;
	private JButton cancelButton;
	
	private JPanel panel;
	private BranchDaoImpl branchDao;
	
	public CustomerUpdateForm() {
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
		
		phoneNumberLabel = new JLabel("Phone : ");
		phoneNumberField = new JTextField();
		
		addressLabel = new JLabel("Address : ");
		addressField = new JTextField();
		
		dateLabel = new JLabel("Date of Birth : ");
		this.dateModel = new SqlDateModel();
		this.datePanel = new JDatePanelImpl(dateModel,new Properties());
		this.datePicker = new JDatePickerImpl(datePanel,new DateLabelFormatter());
		
		updateButton = new JButton("Update");
		cancelButton = new JButton("Cancel");
		
		panel = new JPanel();
		panel.setLayout(new GridLayout(6, 2));
		
		panel.add(firstNameLabel);
		panel.add(firstNameField);
		panel.add(lastNameLabel);
		panel.add(lastNameField);
		panel.add(emailLabel);
		panel.add(emailField);
		panel.add(phoneNumberLabel);
		panel.add(phoneNumberField);
		panel.add(addressLabel);
		panel.add(addressField);
		panel.add(dateLabel);
		panel.add(datePicker);


		
		JPanel panel2 = new JPanel();
		panel2.setLayout(new GridLayout(1,1));
		panel2.add(updateButton);
		panel2.add(cancelButton);
		
		this.add(panel,BorderLayout.NORTH);
		this.add(panel2,BorderLayout.SOUTH);
		prepareBaseWindow();
		
	}
	
	public JSpinner createTimeSpinner() {
		SpinnerDateModel timeModel = new SpinnerDateModel(new Date(),null,null,Calendar.HOUR_OF_DAY);
		JSpinner timeSpinner = new JSpinner(timeModel);
		JSpinner.DateEditor timeEditer = new JSpinner.DateEditor(timeSpinner,"HH:mm");
		timeSpinner.setEditor(timeEditer);
		
		Dimension spinnerSize = new Dimension(10,10);
		timeSpinner.setPreferredSize(spinnerSize);
		return timeSpinner;
	}
	
	public JTextField getFirstNameField() {
		return firstNameField;
	}

	public void setFirstNameField(JTextField firstNameField) {
		this.firstNameField = firstNameField;
	}

	public JTextField getLastNameField() {
		return lastNameField;
	}

	public void setLastNameField(JTextField lastNameField) {
		this.lastNameField = lastNameField;
	}

	public JTextField getEmailField() {
		return emailField;
	}

	public void setEmailField(JTextField emailField) {
		this.emailField = emailField;
	}

	public JTextField getPhoneNumberField() {
		return phoneNumberField;
	}

	public void setPhoneNumberField(JTextField phoneNumberField) {
		this.phoneNumberField = phoneNumberField;
	}

	public JLabel getAddressLabel() {
		return addressLabel;
	}

	public void setAddressLabel(JLabel addressLabel) {
		this.addressLabel = addressLabel;
	}

	public JTextField getAddressField() {
		return addressField;
	}

	public void setAddressField(JTextField addressField) {
		this.addressField = addressField;
	}

	public JButton getCancelButton() {
		return cancelButton;
	}

	public void setCancelButton(JButton cancelButton) {
		this.cancelButton = cancelButton;
	}

	public void setupdateButton(JButton updateButton) {
		this.updateButton = updateButton;
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
	
	public String getPhoneNumber() {
		return this.phoneNumberField.getText();
	}
	
	public JDatePanelImpl getDatePanel() {
		return datePanel;
	}

	public void setDatePanel(JDatePanelImpl datePanel) {
		this.datePanel = datePanel;
	}

	public JButton getupdateButton() {
		return this.updateButton;
	}

	public void prepareBaseWindow() {
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setTitle("Customer Update Form");
		this.setSize(800,400);
		
	}
}
